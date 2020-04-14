package Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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

    private Date date;

    public User getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Chips> getChipsList() {
        return chipsList;
    }

    public void setChipsList(List<Chips> chipsList) {
        this.chipsList = chipsList;
    }
}
