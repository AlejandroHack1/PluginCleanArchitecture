package co.com.bancolombia.model.account.gateways;

import co.com.bancolombia.model.account.Account;

import java.util.List;

public interface AccountRepository {

    List<Account> getAccount();

    Account getAccountByAccountnumber(int accountNumber);

    Account getAccountById(String accountId);
    void deleteAccountById(String accountId);

    Account save(Account account);



}
