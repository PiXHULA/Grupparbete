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
    ChipsModel chipsModel = new ChipsModel();
    Map<User, List<Chips>> purchaseMap;
    private String confirmPurchase = "";

    public Map<User, List<Chips>> getPurchaseMap() {
        return purchaseMap;
    }

    public void setPurchaseMap(Map<User, List<Chips>> purchaseMap) {
        this.purchaseMap = purchaseMap;
    }

    public void confirmOrder(User user, List<Chips> chipsList) {
        purchaseMap = new HashMap<>();
        purchaseMap.put(user, chipsList);
        setConfirmPurchase("Order confirmed!");
    }

    public String getConfirmPurchase() {
        return confirmPurchase;
    }

    public void setConfirmPurchase(String confirmPurchase) {
        this.confirmPurchase = confirmPurchase;
    }

    @Override
    public String toString() {
        return "PurchaseModel " +
                "chipsModel=" + chipsModel;
    }
}
