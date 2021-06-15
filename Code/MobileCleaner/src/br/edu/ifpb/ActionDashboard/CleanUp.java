package br.edu.ifpb.ActionDashboard;

import br.edu.ifpb.Model.User.UserManager;

public class CleanUp {

    UserManager userManager;

    public CleanUp(UserManager userManager) {
        this.userManager = userManager;
    }

    public boolean toClean(String login) {
        return this.userManager.clean(login);
    }



}
