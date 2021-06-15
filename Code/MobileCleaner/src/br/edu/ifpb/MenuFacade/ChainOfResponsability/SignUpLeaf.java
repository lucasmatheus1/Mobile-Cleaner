package br.edu.ifpb.MenuFacade.ChainOfResponsability;

public class SignUpLeaf implements IChain{

    @Override
    public void next(IChain chain) {
    }

    @Override
    public boolean go() {

        return true;
    }
}
