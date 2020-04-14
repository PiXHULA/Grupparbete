package Model;


import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Named
@SessionScoped
public class ChipsModel implements Serializable {
    private String input;
    private String output;
    private Chips searchResult;
    private MockDatabase database;

    @PostConstruct
    public void init() {
        database = MockDatabase.getSingleton();
    }

    public Collection<Chips> getChipsList() {
        return database.getChips();
    }

    public void getChips(String input) {
        output = input + " not found";
        searchResult = null;
        for (Chips c : getChipsList()) {
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
