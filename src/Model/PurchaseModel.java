package Model;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
@SessionScoped
public class PurchaseModel implements Serializable {
    UserModel userModel = new UserModel();
    ChipsModel chipsModel = new ChipsModel();
    Map<User, List<Chips>> purchaseMap;

    public Map<User, List<Chips>> getPurchaseMap() {
        return purchaseMap;
    }

    public void setPurchaseMap(Map<User, List<Chips>> purchaseMap) {
        this.purchaseMap = purchaseMap;
    }

    public String confirmOrder(User user, List<Chips> chipsList){
        Map<User, List<Chips>> purchaseMap2 = new HashMap<>();
        purchaseMap2.put(user,chipsList);
        setPurchaseMap(purchaseMap2);
        return "receipt";
    }

    @Override
    public String toString() {
        return "PurchaseModel " +
                "chipsModel=" + chipsModel ;
    }
}
