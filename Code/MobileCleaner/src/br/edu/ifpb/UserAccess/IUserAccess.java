package br.edu.ifpb.UserAccess;

import br.edu.ifpb.Model.User.User;
import br.edu.ifpb.Model.User.UserManager;
import br.edu.ifpb.Model.User.UserProxy;

public interface IUserAccess {

    public User createUser(String name, String login, String pass, String modelSmartphone, String permission);

    public SingIn singIn(UserManager userManager, User user);

    public SingUp singUp(User user, UserProxy userProxy);

}
