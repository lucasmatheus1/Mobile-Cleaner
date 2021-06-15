package br.edu.ifpb.MenuFacade;

import br.edu.ifpb.ActionDashboard.ActionDashboardFacade;
import br.edu.ifpb.CleanPlaceBuilder.CleanPlaceBuilder;
import br.edu.ifpb.Model.CleanPlace.CleanPlaceManager;
import br.edu.ifpb.Model.User.UserManager;
import br.edu.ifpb.Model.User.UserProxy;
import br.edu.ifpb.UserAccess.IUserAccess;
import br.edu.ifpb.UserAccess.UserAccess;
import br.edu.ifpb.UserBuilder.IUserBuilder;
import br.edu.ifpb.UserBuilder.UserBuilder;

import java.text.ParseException;

public class Facade {

    IUserBuilder userBuilder;
    IUserAccess userAccessFactory;
    UserManager userManager;
    UserProxy userProxy;
    MenuPrincipal menuPrincipal;
    MenuDashboardAdmin menuDashboardAdmin;
    MenuDashboardUser menuDashboardUser;
    ActionDashboardFacade actionDashboardFacade;
    CleanPlaceManager cleanPlaceManager;
    CleanPlaceBuilder cleanPlaceBuilder;

    public Facade() {
        this.userBuilder = new UserBuilder();
        this.cleanPlaceBuilder = new CleanPlaceBuilder();
        this.userAccessFactory = new UserAccess();
        this.userManager = new UserManager();
        this.cleanPlaceManager = new CleanPlaceManager();
        this.userProxy = new UserProxy(this.userManager);
        this.actionDashboardFacade = new ActionDashboardFacade(this.userManager);
        this.menuDashboardAdmin = new MenuDashboardAdmin("Menu Administrador", this.actionDashboardFacade, this.userManager, this.cleanPlaceManager, this.cleanPlaceBuilder, this.userBuilder);
        this.menuDashboardUser = new MenuDashboardUser("Menu Usuário", this.actionDashboardFacade, this.userManager, this.cleanPlaceManager);
        this.menuPrincipal = new MenuPrincipal("Menu Principal",userBuilder, userAccessFactory, userManager, userProxy, menuDashboardAdmin, menuDashboardUser);
    }

    public void exibirMenu() throws ParseException {
        this.menuPrincipal.exibirMenu();
    }

}
