package co.com.bancolombia.usecase.account;

import co.com.bancolombia.model.account.Account;
import co.com.bancolombia.model.account.gateways.AccountRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AccountUseCase {

    final AccountRepository accountRepository;

    public List<Account> getAccount() {
        return accountRepository.getAccount();
    }

    public Account getAccountByAccountnumber(int accountNumber) {
        return accountRepository.getAccountByAccountnumber(accountNumber);
    }


    public Account getAccountById(String accountId) {
        return accountRepository.getAccountById(accountId);
    }

    public void deleteAccountById(String accountId) {
         accountRepository.deleteAccountById(accountId);
    }

    public Account save(Account account) {
        return accountRepository.save(account);
    }


}
