package Model;


import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class ChipsModel implements Serializable {
    private String input;
    private String output;
    private Chips searchResult;

    @OneToMany
    private List<Chips> chipsList = new ArrayList<>();


    @PostConstruct
    public void init() {
        loadChipsList();
    }

    public List<Chips> getChipsList() {
        return chipsList;
    }

    public void getChips(String input) {
        output = input + " not found";
        searchResult = null;
        for (Chips c : chipsList) {
            if (c.getBrand().equalsIgnoreCase(input)) {
                output = c.getBrand();
                searchResult = c;
            }
        }
    }

    public Chips getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(Chips searchResult) {
        this.searchResult = searchResult;
    }

    public void loadChipsList() {
        chipsList.add(new Chips("Pringles", "Original", 5000));
        chipsList.add(new Chips("Lazy", "Original", 5000));
        chipsList.add(new Chips("OLW", "Original", 5000));
        chipsList.add(new Chips("Estrella", "Original", 5000));
        chipsList.add(new Chips("Dotidos", "Original", 500000000));
    }

    public void isThisTheChip() {
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
