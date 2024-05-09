package api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.ToString;

import java.time.OffsetDateTime;

@Entity
@Table(name = "loan_order")
@Getter
@ToString
public class LoanOrder {

    @Id
    private Long id;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "tariff_id")
    private Long tariffId;

    @Column(name = "credit_rating")
    private Double creditRating;

    private String status;

    @Column(name = "time_insert")
    private OffsetDateTime timeInsert;

    @Column(name = "time_update")
    private OffsetDateTime timeUpdate;
}
