package api.entity.credit_app;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name = "tariff")
@Getter
@ToString
public class Tariff {

    @Id
    private Integer id;

    private String type;

    @Column(name = "interest_rate")
    private String interestRate;
}
