package Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    private String model;

    @OneToMany(cascade =  CascadeType.ALL, fetch =  FetchType.LAZY)
    @JoinTable(
            name = "car_wheels",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "wheel_id")
    )
    private List<Wheels> wheels;

    public Car(String model, List<Wheels> wheels) {
        this.model = model;
        this.wheels = wheels;
    }
}
