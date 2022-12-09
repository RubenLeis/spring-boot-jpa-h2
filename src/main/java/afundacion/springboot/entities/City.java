package afundacion.springboot.entities;

import javax.persistence.*;

//Anotaciones para mapear nuestro objeto con la tabla countries.
@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,
            unique = true)
    private String name;

    public City() {
        super();
    }

    public City(String name) {
        super();
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}