package br.edu.ifpb.MenuFacade.ChainOfResponsability;

import br.edu.ifpb.Model.User.User;

import java.util.List;

public class UserExists implements IChain{

    private IChain chain;
    private List<User> users;
    private User user;

    public UserExists(List<User> users, User user) {
        this.users = users;
        this.user = user;
    }

    @Override
    public void next(IChain chain) {
        this.chain = chain;
    }

    @Override
    public boolean go() {
        for (User user: this.users) {
            if (this.user.getLogin().equals(user.getLogin())){
                System.out.println("\nUsuário "+user.getLogin()+" já cadastrado.");
                return false;
            }
        }

        boolean pass = this.chain.go();

        return pass == true ? true : false;
    }
}
