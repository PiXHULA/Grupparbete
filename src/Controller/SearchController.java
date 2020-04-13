package Controller;

import Model.Chips;
import Model.ChipsModel;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.ManagedProperty;
import javax.inject.Named;
import java.io.Serializable;


@Named
@SessionScoped
@ManagedBean
public class SearchController implements Serializable {
    @ManagedProperty(value = "#{chipsModel}") // same as chipsModel class
    private ChipsModel chipsModel;

    public SearchController() {
    }

    public SearchController(ChipsModel chipsModel) {
        this.chipsModel = chipsModel;
    }

//    public Chips showSelectedChips(String input){
//        clear();
//
//
//
//    }

    public void clear(){
        chipsModel.getChipsList().clear();
    }

}
