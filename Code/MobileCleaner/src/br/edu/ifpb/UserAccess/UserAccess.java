package br.edu.ifpb.UserAccess;

import br.edu.ifpb.Model.User.User;
import br.edu.ifpb.Model.User.UserManager;
import br.edu.ifpb.Model.User.UserProxy;

public class UserAccess implements IUserAccess {

    @Override
    public User createUser(String name, String login, String pass, String modelSmartphone, String permission) {
        return new User(name, login, pass, modelSmartphone, permission);
    }

    @Override
    public SingIn singIn(UserManager userManager, User user) {
        return new SingIn(userManager, user);
    }


    @Override
    public SingUp singUp(User user, UserProxy userProxy) {
        return new SingUp(user, userProxy);
    }

}
