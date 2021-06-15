package br.edu.ifpb.UserBuilder;

import br.edu.ifpb.Model.User.User;

public interface IUserBuilder {

    public IUserBuilder setName(String name);
    public IUserBuilder setLogin(String login);
    public IUserBuilder setPass(String pass);
    public IUserBuilder setModelSmartphone(String modelSmartphone);
    public IUserBuilder setPermission(String permission);


    public User builder();

}
