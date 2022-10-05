package co.com.bancolombia.jpa;

import co.com.bancolombia.jpa.DTO.AccountDTO;
import co.com.bancolombia.jpa.helper.AdapterOperations;
import co.com.bancolombia.model.accountjpa.AccountJPA;
import co.com.bancolombia.model.accountjpa.gateways.AccountJPARepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JPARepositoryAdapter extends AdapterOperations<AccountJPA, AccountDTO, String, JPARepository>
 implements AccountJPARepository


{


    public JPARepositoryAdapter(JPARepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, AccountJPA.class));
    }


    @Override
    public List<AccountJPA> getAllAccounts() {
        return super.findAll();
    }

    @Override
    public AccountJPA getAccountByAccountNumber(int accountNumber) {
        return null;
    }

    @Override
    public AccountJPA getById(int accountId) {
        return null;
    }

    @Override
    public void deleteById(int accountId) {

    }

    @Override
    public AccountJPA saveAll(AccountJPA accountJPA) {

        return super.save(accountJPA);
    }
}
