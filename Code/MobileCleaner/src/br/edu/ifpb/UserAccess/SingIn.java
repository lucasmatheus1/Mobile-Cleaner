package br.edu.ifpb.UserAccess;


import br.edu.ifpb.Model.User.IUser;
import br.edu.ifpb.Model.User.User;
import br.edu.ifpb.Model.User.UserManager;

public class SingIn {

    UserManager userManager;
    private User user;

    public SingIn(UserManager userManager, User user) {
        this.userManager = userManager;
        this.user = user;
    }

    public boolean enter() {
        if(this.userManager.verifyUser(this.user)) return true;
        return false;
    }

}