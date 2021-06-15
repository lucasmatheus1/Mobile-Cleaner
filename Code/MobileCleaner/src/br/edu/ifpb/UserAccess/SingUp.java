package br.edu.ifpb.UserAccess;

import br.edu.ifpb.Model.User.User;
import br.edu.ifpb.Model.User.UserProxy;

import java.text.ParseException;

public class SingUp {

    private final User user;

    UserProxy userProxy;

    public SingUp(User user, UserProxy userProxy) {
        this.user = user;
        this.userProxy = userProxy;
    }

    public boolean register() throws ParseException {
        return this.userProxy.singUp(this.user);
    }
}
