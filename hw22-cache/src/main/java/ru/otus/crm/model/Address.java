package ru.otus.crm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ConcreteProxy;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = "street", doNotUseGetters = true)
@ConcreteProxy
@Entity
@Table(name = "address")
public class Address implements Cloneable {

    @Id
    @SequenceGenerator(name = "address_gen", sequenceName = "address_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_gen")
    @Column(name = "id")
    private Long id;

    @Column(name = "street")
    private String street;

    public Address(String street) {
        this.street = street;
    }

    public Address(Long id, String street) {
        this.id = id;
        this.street = street;
    }

    public Address clone() {
        try {
            Address address = (Address) super.clone();
            address.setStreet(this.street);
            return address;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", street='" + street + '\'' + '}';
    }
}
