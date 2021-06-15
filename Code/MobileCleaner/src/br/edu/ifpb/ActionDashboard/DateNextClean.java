package br.edu.ifpb.ActionDashboard;

import br.edu.ifpb.Model.User.UserManager;

public class DateNextClean {

    UserManager userManager;

    public DateNextClean(UserManager userManager) {
        this.userManager = userManager;
    }

    public String showDateNextClean(String login) {
        return this.userManager.showNextDate(login);
    }

}
