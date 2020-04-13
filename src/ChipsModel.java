import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ChipsModel implements Serializable {

    @OneToMany
    private List<Chips> chipsList = new ArrayList<>();

    public Chips getChips(String input) {
        for (Chips c : chipsList) {
            if (c.getBrand().equalsIgnoreCase(input)) {
                return c;
            }
        }
        return null;
    }

    public void populate() {
        chipsList.add(new Chips("Pringles", "Original", 5000));
        chipsList.add(new Chips("Lazy", "Original", 5000));
        chipsList.add(new Chips("OLW", "Original", 5000));
        chipsList.add(new Chips("Estella", "Original", 5000));
        chipsList.add(new Chips("ABC", "Original", 5000));
    }
}
