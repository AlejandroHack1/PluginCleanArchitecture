package co.com.bancolombia.usecase.accountjpa;

import co.com.bancolombia.model.accountjpa.AccountJPA;
import co.com.bancolombia.model.accountjpa.gateways.AccountJPARepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AccountJPAUseCase {

    final AccountJPARepository accountJPARepository;

    public List<AccountJPA> getAllAccounts() {
        return accountJPARepository.getAllAccounts();
    }

    public AccountJPA getAccountByAccountNumber(int accountNumber) {
        return accountJPARepository.getAccountByAccountNumber(accountNumber);
    }


    public AccountJPA getById(int accountId) {
        return accountJPARepository.getById(accountId);
    }

    public void deleteById(int accountId) {
        accountJPARepository.deleteById(accountId);
    }

    public AccountJPA saveAll(AccountJPA account) {
        return accountJPARepository.saveAll(account);
    }


}
