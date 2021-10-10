package guru.springframework.spring5webapp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@Data
public class AddressPublisher {

    public AddressPublisher(String addressLineOne, String city, String state, String zip) {
        this.addressLineOne = addressLineOne;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String addressLineOne;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String zip;

    @OneToOne(mappedBy = "address")
    private PublisherEntity publisher;

}
