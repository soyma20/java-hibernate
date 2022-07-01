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
public class Manufacturer implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "wheels_manufacturers",
            joinColumns = @JoinColumn(name = "manufacturer_id"),
            inverseJoinColumns = @JoinColumn(name = "wheel_id")
    )
    private List<Wheels> wheels;
    private String name;

    public Manufacturer(List<Wheels> wheels, String name) {
        this.wheels = wheels;
        this.name = name;
    }

    public Manufacturer(String name) {
        this.name = name;
    }
}
