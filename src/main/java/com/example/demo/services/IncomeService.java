package com.example.demo.services;

import com.example.demo.JWT.ClaimsService;
import com.example.demo.entities.Account;
import com.example.demo.entities.Income;
import com.example.demo.interfaces.IIncome;
import com.example.demo.models.IncomeModel;
import com.example.demo.repository.IAccountRepository;
import com.example.demo.repository.IIncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IncomeService implements IIncome {

    private final IIncomeRepository _incomeRepository;
    private final IAccountRepository _IAccountRepository;
    private final ClaimsService claimsService;


    @Autowired
    public IncomeService(IIncomeRepository incomeRepository, IAccountRepository iAccountRepository, ClaimsService claimsService) {
        _incomeRepository = incomeRepository;
        _IAccountRepository = iAccountRepository;
        this.claimsService = claimsService;
    }

    @Override
    public List<IncomeModel> get() {
        return _incomeRepository.findAll().stream().map(x ->
                new IncomeModel(x.getId(),x.getAccountId(),x.getAccount().getName(),x.getIncomeTypeId(),
                        x.getIncomeType().getName(),x.getAmount(),x.getDate(),
                        x.getMonthly(),x.getName())).collect(Collectors.toList());
    }

    @Override
    public List<IncomeModel> getByUserId() {
        return null;
    }

    @Override
    public IncomeModel getById(int id) {
        Income x = _incomeRepository.findFirstById(id);

        return new IncomeModel(x.getId(),x.getAccountId(),x.getAccount().getName(),x.getIncomeTypeId(),
                x.getIncomeType().getName(),x.getAmount(),x.getDate(),x.getMonthly(),x.getName());
    }

    @Override
    public void insert(IncomeModel model) {
        Income entity = new Income(model.getAccountId(),model.getIncomeTypeId(),model.getName(),model.getAmount(),model.getDate(),model.getMonthly());
        _incomeRepository.save(entity);
        IncomeToAccount(model,model.getAccountId());
    }

    @Override
    public void update(IncomeModel model) {
        Income income = _incomeRepository.findFirstById(model.getId());
        IncomeToAccount(model,model.getAccountId());

        income.setAccountId(model.getAccountId());
        income.setAmount(model.getAmount());
        income.setDate(model.getDate());
        income.setIncomeTypeId(model.getIncomeTypeId());
        income.setMonthly(model.getMonthly());
        income.setName(model.getName());

        _incomeRepository.save(income);
    }

    @Override
    public void delete(int id) {
        Income income = _incomeRepository.findFirstById(id);
        Account account = _IAccountRepository.findFirstById(income.getAccountId());
        account.setAmount(account.getAmount() - income.getAmount());
        _IAccountRepository.save(account);
        _incomeRepository.delete(income);
    }

    @Override
    public List<IncomeModel> getTopThreeByDate() {
        List<Integer> accountIds = _IAccountRepository.findAllByUserId(claimsService.GetUserIdFromToken()).stream().map(x -> x.getId()).collect(Collectors.toList());

        return _incomeRepository.findAllByAccountIdInOrderByDateDesc(accountIds).stream().map(x -> new IncomeModel(x.getId(),x.getAccountId(),"",x.getIncomeTypeId(),
                x.getIncomeType().getName(),x.getAmount(),x.getDate(),x.getMonthly(),x.getName())).limit(3).collect(Collectors.toList());
    }

    @Override
    public float getMonthlyIncome() {
        List<Integer> accountIds = _IAccountRepository.findAllByUserId(claimsService.GetUserIdFromToken()).stream().map(x -> x.getId()).collect(Collectors.toList());

        LocalDate todayDate = LocalDate.now().withDayOfMonth(1);

        int lstDay = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
        LocalDate lastDate = LocalDate.now().withDayOfMonth(lstDay);

       return (float) _incomeRepository.findAllByAccountIdInAndDateBetween(accountIds,
                Date.from(todayDate.atStartOfDay(ZoneId.systemDefault()).toInstant()),
                Date.from(lastDate.atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .stream().mapToDouble(x -> x.getAmount()).sum();

    }

    private void IncomeToAccount(IncomeModel model, int accountId){
        Account account = _IAccountRepository.findFirstById(accountId);

        if(model.getId() == 0){
            account.setAmount(account.getAmount() + model.getAmount());
        }else{
            Income income = _incomeRepository.findFirstById(model.getId());

            if(model.getAmount() != income.getAmount()){
                float diff = model.getAmount() - income.getAmount();
                account.setAmount(account.getAmount() + diff);
            }else{
                float diff = income.getAmount() - model.getAmount();
                account.setAmount(account.getAmount() - diff);
            }
        }
        _IAccountRepository.save(account);
    }
}
