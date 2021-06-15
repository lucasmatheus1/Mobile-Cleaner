package br.edu.ifpb.MenuFacade.ChainOfResponsability;

import br.edu.ifpb.Model.User.User;

public class ValidationFields implements IChain{

    private IChain chain;
    private User user;

    public ValidationFields(User user) {
        this.user = user;
    }

    @Override
    public void next(IChain chain) {
        this.chain = chain;
    }

    @Override
    public boolean go() {

        User user = this.user;

        if (user.getName().equals("") || user.getName().equals(null)) {
            System.out.println("\nDigite um nome válido.");
            return false;
        }

        if (user.getLogin().equals("") || user.getLogin().equals(null)) {
            System.out.println("\nDigite um login válido.");
            return false;
        }

        if (user.getPass().equals("") || user.getPass().equals(null)) {
            System.out.println("\nDigite uma senha válida.");
            return false;
        }

        if (user.getModelSmartphone().equals("") || user.getModelSmartphone().equals(null)) {
            System.out.println("\nDigite um modelo válido.");
            return false;
        }
        boolean pass = this.chain.go();

        return pass == true ? true : false;
    }
}
