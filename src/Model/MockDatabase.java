package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class MockDatabase implements Serializable {
    private static MockDatabase singletonDatabase = new MockDatabase();
    private Collection<Chips> products = new ArrayList<>();
    private Collection<User> users = new ArrayList<>();

    private MockDatabase() {
        populateChips();
        populateUsers();
    }

    public static MockDatabase getInstance() {
        return singletonDatabase;
    }

    void addUser(User u) {
        users.add(u);
    }

    Collection<Chips> getChips() {
        return products;
    }

    Collection<User> getAllUsers() {
        return users;
    }

    Collection<User> getCustomers() {
        return users.stream().filter(User::isCustomer).collect(Collectors.toList());
    }

    private void populateChips() {
        products.add(new Chips("Pringles", "Original", 5000));
        products.add(new Chips("Lazy", "Original", 5000));
        products.add(new Chips("OLW", "Original", 5000));
        products.add(new Chips("Estrella", "Original", 5000));
        products.add(new Chips("Dotidos", "Original", 500000000));
    }

    private void populateUsers() {
        users.add(new User("Wilhelm", "Hattenbach", UserRoles.ADMIN)); //Admin
        users.add(new User("Cornelia", "Persson", UserRoles.ADMIN)); //Admin
        users.add(new User("Linus", "Svahn", UserRoles.ADMIN)); //Admin
        users.add(new User("Joakim", "Önnhage", UserRoles.ADMIN)); //Admin
        users.add(new User("Atef", "Sendesni", UserRoles.ADMIN)); //Admin
        users.add(new User("Kening", "Fohlin", UserRoles.ADMIN)); //Admin / Overlord
        users.add(new User("Victor", "Olofsson", UserRoles.ADMIN)); //Admin
        users.add(new User("Emmy", "De Stefano", UserRoles.ADMIN)); //Admin
        users.add(new User("Simon", "Wildbore", UserRoles.ADMIN)); //Admin
        users.add(new User("test", "test")); //Vanlig kund
        users.add(new User("test2", "test2", UserRoles.SUPER_CUSTOMER)); //Super kund
        users.add(new User("KUNDENS", "test")); //Vanlig kund
    }
}
