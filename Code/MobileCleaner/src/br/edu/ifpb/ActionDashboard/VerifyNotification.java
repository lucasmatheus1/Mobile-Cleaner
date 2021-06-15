package br.edu.ifpb.ActionDashboard;

import br.edu.ifpb.Model.User.IUser;
import br.edu.ifpb.Model.User.User;
import br.edu.ifpb.Model.User.UserManager;

public class VerifyNotification {

    UserManager userManager;

    public VerifyNotification(UserManager userManager) {
        this.userManager = userManager;
    }

    public String show(User user) {
        return this.userManager.verify(user);
    }

}
