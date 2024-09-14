package com.example.fiap.challenge.plusoft.domainmodel;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_CREDIT_CARD", uniqueConstraints = {
        @UniqueConstraint(
                name = "UK_NUM_CREDIT_CARD",
                columnNames = "NUM_CREDIT_CARD"
        ),
        @UniqueConstraint(
                name = "UK_CLIENT_BRAND",
                columnNames = {"CLIENT", "BRAND"}
        )
})
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CARD")
    private @Getter @Setter Long id;

    @Column(name = "NUM_CREDIT_CARD", nullable = false)
    private @Getter @Setter String card_number;

    @Column(name = "EXPIRATION_DATE", nullable = false)
    private @Getter @Setter LocalDate expiration_date;

    @Column(name = "SECURITY_CODE", nullable = false)
    private @Getter @Setter String security_code;

    @Column(name = "PASSWORD", nullable = false)
    private @Getter @Setter String password;

    @Column(name = "BRAND", nullable = false)
    private @Getter @Setter String brand;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "CLIENT",
            referencedColumnName = "ID_CLIENT",
            foreignKey = @ForeignKey(
                    name = "FK_CARD_CLIENT"
            ),
            nullable = false
    )
    private @Getter @Setter Client client;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreditCard creditCard)) return false;
        return id == creditCard.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
