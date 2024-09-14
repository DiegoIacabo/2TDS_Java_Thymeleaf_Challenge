package com.example.fiap.challenge.plusoft.domainmodel;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_CLIENT", uniqueConstraints = {
        @UniqueConstraint(
                name = "UK_CLIENT_CPF",
                columnNames = "CPF"
        )
})
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENT")
    private @Getter @Setter Long id;

    @Column(name = "NM_CLIENT", nullable = false)
    private @Getter @Setter String name;

    @Column(name = "CPF", nullable = false)
    private @Getter @Setter String cpf;

    @Column(name = "BIRTH_DATE", nullable = false)
    private @Getter @Setter LocalDate birth;

    @Column(name = "INCOME", nullable = false)
    private @Getter @Setter Double income;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return id == client.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
