package main.foo;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mihaildoronin on 27/11/15.
 */
@Entity
public class Foo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @OneToMany(cascade = CascadeType.ALL)
    @OrderColumn(nullable=false)
    private List<Bar> bars;

    private String name;

    public void addBar(Bar bar) {
        bars.add(bar);
    }

    public List<Bar> getBars() {
        return bars;
    }

    public void setBars(List<Bar> bars) {
        this.bars = bars;
    }

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
