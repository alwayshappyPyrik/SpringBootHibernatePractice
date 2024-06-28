package com.example.springbootdatajpapractice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PersonId implements Serializable {
    @Column(name = "firstname", columnDefinition = "varchar(250)")
    private String firstname;
    @Column(name = "surname", columnDefinition = "varchar(250)")
    private String surname;
    @Column(name = "age")
    @Range(min = 0, max = 150)
    private int age;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        PersonId personId = (PersonId) o;
        return getFirstname() != null && Objects.equals(getFirstname(), personId.getFirstname()) && getSurname() != null && Objects.equals(getSurname(), personId.getSurname()) && getAge() == personId.getAge();
    }

    @Override
    public final int hashCode() {
        return Objects.hash(firstname, surname, age);
    }
}
