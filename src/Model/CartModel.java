package Model;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class CartModel implements Serializable {

    private List<Chips> cartList = new ArrayList<>();


    public void setCartList(List<Chips> cartList) {
        this.cartList = cartList;
    }

    public List<Chips> getCartList() {
        return cartList;
    }

    public void addToCart(Chips chips) {
        cartList.add(chips);
    }
}
