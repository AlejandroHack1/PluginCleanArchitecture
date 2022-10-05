package co.com.bancolombia.jpa.DTO;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Data

public class AccountDTO {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id", nullable = false)
    private Long accountId;

    private int accountNumber;
    private int accountType;
    
}
