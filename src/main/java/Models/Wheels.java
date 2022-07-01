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
public class Wheels implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    private String size;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "wheels_manufacturers",
            joinColumns = @JoinColumn(name = "wheel_id"),
            inverseJoinColumns = @JoinColumn(name = "manufacturer_id")
    )
    private List<Manufacturer> manufacturers;

    public Wheels(String size, List<Manufacturer> manufacturers) {
        this.size = size;
        this.manufacturers = manufacturers;
    }

    public Wheels(String size) {
        this.size = size;
    }
}
