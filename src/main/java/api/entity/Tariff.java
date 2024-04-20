package api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tariff")
public class Tariff {

    @Id
    private Long id;

    private String type;

    @Column(name = "interest_rate")
    private Long interestRate;
}
