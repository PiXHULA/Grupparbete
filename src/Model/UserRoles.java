package Model;

public enum UserRoles {
    NORMAL_CUSTOMER(1,"Kund"), SUPER_CUSTOMER(2, "Premiumkund"), ADMIN(3, "Admin");

    private final int userRole;
    private final String roleName;

    UserRoles(int userRole, String roleName) {
        this.userRole = userRole;
        this.roleName = roleName;
    }

    public int getUserRoleEnum() {
        return userRole;
    }

    public String getRoleNameEnum() {
        return roleName;
    }
}
