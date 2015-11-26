package main.foo;

import org.springframework.cglib.core.GeneratorStrategy;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * Created by mihaildoronin on 27/11/15.
 */
@Entity
public class Bar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
