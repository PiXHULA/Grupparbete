package Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Purchase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    @OneToMany
    private List<Chips> chipsList;
}
