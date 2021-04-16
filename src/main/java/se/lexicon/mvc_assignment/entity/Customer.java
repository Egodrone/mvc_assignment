package se.lexicon.mvc_assignment.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
    private String customerId;
    @Column(nullable = false, length = 200)
    private String email;
    @Column(nullable = false, length = 100)
    private LocalDate regDate;
    @Column(nullable = false, columnDefinition = "tinyint(1) default 1")
    private boolean active;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private CustomerDetails customerDetails;

}
