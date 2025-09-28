package ru.otus.crm.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.ConcreteProxy;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(
        callSuper = false,
        of = {"name", "address", "phones"},
        doNotUseGetters = true)
@ConcreteProxy
@Entity
@Table(name = "client")
public class Client implements Cloneable {

    @Id
    @SequenceGenerator(name = "client_gen", sequenceName = "client_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_gen")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "client")
    private List<Phone> phones = new ArrayList<>();

    public Client(String name) {
        this.id = null;
        this.name = name;
    }

    public Client(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Client(Long id, String name, Address address, List<Phone> phones) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phones = phones != null ? phones : new ArrayList<>();
        // Инициализация связей вынесена в отдельный метод
        initializePhoneRelations();
    }

    private void initializePhoneRelations() {
        if (this.phones != null) {
            this.phones.forEach(phone -> phone.setClient(this));
        }
    }

    @Override
    @SuppressWarnings({"java:S2975", "java:S1182"})
    public Client clone() {
        try {
            Client clonedClient = (Client) super.clone();
            Address clonedAddress = this.address != null ? this.address.clone() : null;
            clonedClient.setAddress(clonedAddress);
            List<Phone> clonedPhones =
                    this.phones != null ? this.phones.stream().map(Phone::clone).toList() : new ArrayList<>();
            clonedClient.setPhones(clonedPhones);
            // Client clonedClient = new Client(null, this.name, clonedAddress, clonedPhones);

            // Устанавливаем правильные связи для телефонов
            clonedPhones.forEach(phone -> phone.setClient(clonedClient));
            return clonedClient;
        } catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", name='" + name + '\'' + ", address=" + address + ", phones=" + phones + '}';
    }
}
