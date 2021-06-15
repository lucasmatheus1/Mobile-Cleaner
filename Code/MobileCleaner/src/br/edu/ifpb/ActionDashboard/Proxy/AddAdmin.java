package br.edu.ifpb.ActionDashboard.Proxy;

import br.edu.ifpb.Model.User.User;
import br.edu.ifpb.Model.User.UserManager;

public class AddAdmin {

    private UserManager userManager;

    public AddAdmin(UserManager userManager) {
        this.userManager = userManager;
    }

    public boolean enter(User user) {
        return this.userManager.addUser(user);
    }

}
