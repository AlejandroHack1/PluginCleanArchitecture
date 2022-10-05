package co.com.bancolombia.mongo;

import co.com.bancolombia.model.account.Account;
import co.com.bancolombia.model.account.gateways.AccountRepository;
import co.com.bancolombia.mongo.DTO.AccountDTO;
import co.com.bancolombia.mongo.helper.AdapterOperations;
import org.bson.types.ObjectId;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MongoRepositoryAdapter extends AdapterOperations<Account, AccountDTO, String, MongoDBRepository> implements AccountRepository {

    public MongoRepositoryAdapter(MongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.mapBuilder(d, Account.AccountBuilder.class).build());

    }

    @Override
    public List<Account> getAccount() {
        return super.findAll();
    }

    @Override
    public Account getAccountByAccountnumber(int accountNumber) {

        return repository.findByAccountNumber(accountNumber);
        //return Account.builder().accountId("1").accountNumber(1).accountType(1).build();

    }

    @Override
    public Account getAccountById(String accountId) {
        ObjectId objId = new ObjectId(accountId);

        return super.findById(accountId);
    }

    @Override
    public void deleteAccountById(String accountId) {
        super.deleteById(accountId);
    }

    @Override
    public Account save(Account account) {

        return super.save(account);

    }

}
