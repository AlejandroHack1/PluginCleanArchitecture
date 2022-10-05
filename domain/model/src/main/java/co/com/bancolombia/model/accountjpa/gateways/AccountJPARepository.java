package co.com.bancolombia.model.accountjpa.gateways;

import co.com.bancolombia.model.accountjpa.AccountJPA;

import java.util.List;

public interface AccountJPARepository {

    List<AccountJPA> getAllAccounts();

    AccountJPA getAccountByAccountNumber(int accountNumber);

    AccountJPA getById(int accountId);
    void deleteById(int accountId);

    AccountJPA saveAll(AccountJPA accountJPA);

}
