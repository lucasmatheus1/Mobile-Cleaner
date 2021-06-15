package br.edu.ifpb.MenuFacade.ChainOfResponsability;

public interface IChain {
    void next(IChain chain);

    boolean go();
}
