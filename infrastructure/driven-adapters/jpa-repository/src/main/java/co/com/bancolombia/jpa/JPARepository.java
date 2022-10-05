package co.com.bancolombia.jpa;

import co.com.bancolombia.jpa.DTO.AccountDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPARepository extends CrudRepository<AccountDTO, String>, QueryByExampleExecutor<AccountDTO> {
}
