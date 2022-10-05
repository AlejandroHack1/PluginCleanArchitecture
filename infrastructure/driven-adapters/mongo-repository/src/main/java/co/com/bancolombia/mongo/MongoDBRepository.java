package co.com.bancolombia.mongo;

import co.com.bancolombia.model.account.Account;
import co.com.bancolombia.mongo.DTO.AccountDTO;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface MongoDBRepository extends MongoRepository<AccountDTO, String>, QueryByExampleExecutor<AccountDTO> {


    @Query("{ 'accountNumber' : ?0 }")
    Account findByAccountNumber(int accountNumber);

    @Query("{ 'accountId' : ?0 }")
    Account findByAccountId(ObjectId accountId);
}
