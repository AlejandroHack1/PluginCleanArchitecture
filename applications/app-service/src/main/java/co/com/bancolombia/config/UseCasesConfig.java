package co.com.bancolombia.config;

import co.com.bancolombia.model.account.gateways.AccountRepository;
import co.com.bancolombia.model.accountjpa.gateways.AccountJPARepository;
import co.com.bancolombia.usecase.account.AccountUseCase;
import co.com.bancolombia.usecase.accountjpa.AccountJPAUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesConfig {

    @Bean
    public AccountUseCase AccountUseCase(AccountRepository accountRepository) {
        return new AccountUseCase(accountRepository);
    }

    @Bean
    public AccountJPAUseCase AccountJPAUseCase(AccountJPARepository accountJPARepository) {
        return new AccountJPAUseCase(accountJPARepository);
    }
}
