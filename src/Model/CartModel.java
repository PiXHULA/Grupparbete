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
    private int totalPrice;


    public void setCartList(List<Chips> cartList) {
        this.cartList = cartList;
    }

    public List<Chips> getCartList() {
        return cartList;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void addToCart(Chips chips) {
        if (chips != null)
            cartList.add(chips);
        calculate();
    }

    public void calculate() {
        totalPrice = 0;
        for (Chips c : cartList) {
            totalPrice += c.getPrice();
        }
    }
}
