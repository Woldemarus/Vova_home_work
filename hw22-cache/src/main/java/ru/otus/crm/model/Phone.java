package ru.otus.crm.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@EqualsAndHashCode(callSuper = false, of = "number", doNotUseGetters = true)
@ConcreteProxy
@Entity
@Table(name = "phone")
public class Phone implements Cloneable {

    @Id
    @SequenceGenerator(name = "phone_gen", sequenceName = "phone_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phone_gen")
    @Column(name = "id")
    private Long id;

    @Column(name = "number")
    private String number;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    public Phone(String number) {
        this.number = number;
    }

    public Phone(Long id, String number) {
        this.id = id;
        this.number = number;
    }

    public Phone clone() {
        try {
            Phone phone = (Phone) super.clone();
            phone.setNumber(this.number);
            return phone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Phone{" + "id=" + id + ", number='" + number + '\'' + '}';
    }
}
