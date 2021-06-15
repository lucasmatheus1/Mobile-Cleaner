package br.edu.ifpb.MenuFacade;

import br.edu.ifpb.ActionDashboard.ActionDashboardFacade;
import br.edu.ifpb.Model.CleanPlace.CleanPlace;
import br.edu.ifpb.Model.CleanPlace.CleanPlaceManager;
import br.edu.ifpb.Model.User.User;
import br.edu.ifpb.Model.User.UserManager;

import java.util.List;

public class MenuDashboardUser extends MenuAbstract{

    ActionDashboardFacade actionDashboardFacade;
    UserManager userManager;
    CleanPlaceManager cleanPlaceManager;

    public MenuDashboardUser(String title, ActionDashboardFacade actionDashboardFacade, UserManager userManager, CleanPlaceManager cleanPlaceManager) {
        super(title);
        this.actionDashboardFacade = actionDashboardFacade;
        this.userManager = userManager;
        this.cleanPlaceManager = cleanPlaceManager;
    }

    public void showDashboardUser(User user) {
        while (true) {
            String menu = "\n=================================================\n";
            menu += this.title + " - MobileCleaner\n\n";
            menu += "1 - Realizar limpeza\n";
            menu += "2 - Verificar data da proxima limpeza\n";
            menu += "3 - Verificar notificações\n";
            menu += "4 - Locais para limpeza\n";
            menu += "5 - Dicas de limpeza\n";
            menu += "6 - Voltar\n";
            menu += "=================================================\n";

            System.out.println(menu);

            Integer chosenOption = obterInteger("Digite uma opção: ");

            switch (chosenOption) {
                case 1:
                    if (this.actionDashboardFacade.cleanUp(this.userManager).toClean(user.getLogin())) {
                        System.out.println("Limpeza realizada com sucesso.");
                    } else {
                        System.out.println("Limpeza não realizada");
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.println("\nPróxima limpeza agendada para: " + this.actionDashboardFacade.dateNextClean(this.userManager)
                            .showDateNextClean(user.getLogin()));
                    break;
                case 3:
                    String message = this.actionDashboardFacade.verifyNotification(this.userManager).show(user);
                    System.out.println("Notificação: " + message);
                    break;
                case 4:
                    List<CleanPlace> list = this.actionDashboardFacade.placesClean(this.cleanPlaceManager).show();
                    for (CleanPlace cleanPlace: list) {
                        System.out.println(cleanPlace.toString());
                    }
                    break;
                case 5:
                    String modelSmartphone = this.userManager.getModelSmartphone(user.getLogin());
                    System.out.println("\n" + this.actionDashboardFacade.cleaningTips(modelSmartphone).showTipsStrategy() + "\n");
                    break;
                case 6:
                    return;
                default:
                    System.out.println();
                    System.out.println("Erro! Digite uma opção válida: " + chosenOption);
                    System.out.println();
                    break;
            }
        }
    }
}
