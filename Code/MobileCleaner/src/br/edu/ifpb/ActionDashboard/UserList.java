package br.edu.ifpb.ActionDashboard;

import br.edu.ifpb.Model.User.IUser;
import br.edu.ifpb.Model.User.User;
import br.edu.ifpb.Model.User.UserManager;

import java.util.List;

public class UserList {

    UserManager userManager;

    public UserList(UserManager userManager) {
        this.userManager = userManager;
    }

    public List<User> show(){
        return this.userManager.getListUser();
    }



}
