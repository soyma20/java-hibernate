package models;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Word implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String value;

    public Word(String value) {
        this.value = value;
    }
}
