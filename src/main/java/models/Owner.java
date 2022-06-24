package models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"car"})
public class Owner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToOne(fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private Car car;

    public Owner(String name, Car car) {
        this.name = name;
        this.car = car;
    }
}
