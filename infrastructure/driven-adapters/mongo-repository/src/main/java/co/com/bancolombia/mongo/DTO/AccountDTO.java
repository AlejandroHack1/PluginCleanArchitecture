package co.com.bancolombia.mongo.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Account")
public class AccountDTO {


    @Id
    @Field("_id")
    private String accountId;

    @Field("accountNumber")
    private int accountNumber;

    @Field("accountType")
    private int accountType;

}
