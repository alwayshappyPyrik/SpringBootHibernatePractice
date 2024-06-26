package com.example.springbootdatajpapractice.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "persons")
@Table(schema = "test", name = "persons")
public class Person {
    @EmbeddedId
    private PersonId personId;
    @Column(name = "phone_number", columnDefinition = "varchar(200)")
    private String phoneNumber;
    @Column(name = "city_of_living", columnDefinition = "varchar(250) not null")
    private String cityOfLiving;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Person person = (Person) o;
        return getPersonId() != null && Objects.equals(getPersonId(), person.getPersonId());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(personId);
    }
}
