import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class ChipsModel implements Serializable {
    private String input,output;

    @OneToMany
    private List<Chips> chipsList = new ArrayList<>();

    public void getChips(String input) {
        populate();
        output = "Chip not found";
        for (Chips c : chipsList) {
            if (c.getBrand().equalsIgnoreCase(input)) {
                output = c.getBrand();
            }
        }
    }

    public void populate() {
        chipsList.add(new Chips("Pringles", "Original", 5000));
        chipsList.add(new Chips("Lazy", "Original", 5000));
        chipsList.add(new Chips("OLW", "Original", 5000));
        chipsList.add(new Chips("Estrella", "Original", 5000));
        chipsList.add(new Chips("Dotidos", "Original", 500000000));
    }

    public void isThisTheChip(){
        getChips(input);
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
