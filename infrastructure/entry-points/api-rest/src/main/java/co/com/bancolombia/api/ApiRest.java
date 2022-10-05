package co.com.bancolombia.api;

import co.com.bancolombia.model.account.Account;
import co.com.bancolombia.model.accountjpa.AccountJPA;
import co.com.bancolombia.usecase.account.AccountUseCase;
import co.com.bancolombia.usecase.accountjpa.AccountJPAUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {

    private final AccountUseCase useCase;

    private final AccountJPAUseCase useCaseJPA;


    @PostMapping(path = "/save")
    public Account save(@RequestBody Account account) {
        return useCase.save(account);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody Account account) {
        Account accountExist = useCase.getAccountById(id);
        if (accountExist == null) {
            return new ResponseEntity<>(
                    "Account not found",
                    HttpStatus.BAD_REQUEST
            );
        } else {
            accountExist.setAccountNumber(account.getAccountNumber());
            accountExist.setAccountType(account.getAccountType());
            useCase.save(accountExist);
        }
        ;
        return new ResponseEntity<>(
                "Account Successfully Updated",
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/list")
    public List<Account> getAccounts() {
        return useCase.getAccount();
    }

    @GetMapping(path = "/accountNumber/{id}")
    public Account getAccountByAccountNumber(@PathVariable int id) {
        return useCase.getAccountByAccountnumber(id);
    }

    @GetMapping(path = "/account/{id}")
    public Account getAccountById(@PathVariable String id) {

        return useCase.getAccountById(id);
    }

    @GetMapping(path = "/delete/{id}")
    public void deleteAccountById(@PathVariable String id) {

        useCase.deleteAccountById(id);
    }

    //postgreSQL
    @GetMapping(path = "/listAll")
    public List<AccountJPA> getAllAccounts() {
        return useCaseJPA.getAllAccounts();
    }

    @PostMapping(path = "/saveAll")
    public AccountJPA saveAll(@RequestBody AccountJPA accountJPA) {

        return useCaseJPA.saveAll(accountJPA);
    }

}
