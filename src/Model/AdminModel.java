package Model;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;

@Named
@SessionScoped
public class AdminModel implements Serializable {
    private MockDatabase database;
    private User toView;

    @PostConstruct
    public void init() {
        database = MockDatabase.getInstance();
    }

    public Collection<User> getCustomers() {
        return database.getCustomers();
    }

    public String goToCustomerProfile(User customer) {
        this.toView = customer;
        return "customer-profile";
    }

    public User getToView() {
        return toView;
    }

    public void setToView(User toView) {
        this.toView = toView;
    }

    public Collection<User> getUserList() {
        return database.getAllUsers();
    }
}
