package br.edu.ifpb.MenuFacade;

import br.edu.ifpb.ActionDashboard.Proxy.AddAdmin;
import br.edu.ifpb.ActionDashboard.Proxy.AddAdminProxy;
import br.edu.ifpb.MenuFacade.ChainOfResponsability.IChain;
import br.edu.ifpb.MenuFacade.ChainOfResponsability.SignUpLeaf;
import br.edu.ifpb.MenuFacade.ChainOfResponsability.UserExists;
import br.edu.ifpb.MenuFacade.ChainOfResponsability.ValidationFields;
import br.edu.ifpb.Model.User.User;
import br.edu.ifpb.Model.User.UserManager;
import br.edu.ifpb.Model.User.UserProxy;
import br.edu.ifpb.UserAccess.IUserAccess;
import br.edu.ifpb.UserBuilder.IUserBuilder;

import java.text.ParseException;
import java.util.Scanner;

public class MenuPrincipal extends MenuAbstract{

    IUserBuilder userBuilder;
    IUserAccess userAccessFactory;
    UserManager userManager;
    UserProxy userProxy;
    MenuDashboardAdmin menuDashboardAdmin;
    MenuDashboardUser menuDashboardUser;

    private Scanner sc = new Scanner(System.in);

    public MenuPrincipal(String title, IUserBuilder userBuilder, IUserAccess userAccessFactory, UserManager userManager, UserProxy userProxy, MenuDashboardAdmin menuDashboardAdmin, MenuDashboardUser menuDashboardUser) {
        super(title);
        this.userBuilder = userBuilder;
        this.userAccessFactory = userAccessFactory;
        this.userManager = userManager;
        this.userProxy = userProxy;
        this.menuDashboardAdmin = menuDashboardAdmin;
        this.menuDashboardUser = menuDashboardUser;
    }

    public void exibirMenu() throws ParseException {
        String menu = "===============================\n";
        menu += this.title + " - MobileCleaner\n\n";
        menu += "1 - Cadastrar\n";
        menu += "2 - Fazer login\n";
        menu += "3 - Sair\n";
        menu += "===============================\n";


        while (true) {
            System.out.println(menu);

            Integer chosenOption = obterInteger("Digite uma opção: ");

            switch (chosenOption) {
                case 1:
                    while (true) {
                        System.out.println("\n\n========== CADASTRO ==========\n");
                        System.out.println("1 - Cadastrar Admin");
                        System.out.println("2 - Cadastrar User\n");
                        Integer Option = obterInteger("Digite uma opção: ");

                        if (Option == 1) {
                            singUpAdmin();
                            break;
                        } else if (Option == 2){
                            singUp();
                            break;
                        } else {
                            System.out.println("Opção inválida.");
                        }
                        System.out.println();

                    }
                    break;
                case 2:
                    singIn();
                    System.out.println();
                    break;
                case 3:
                    return;

                default:
                    System.out.println();
                    System.out.println("Erro! Digite uma opção válida: " + chosenOption);
                    System.out.println();
                    break;
            }

        }
    }

    private void singUpAdmin() {
        String cod = obterString("Código para adicionar ADMIN: ");
        String name = obterString("Nome: ");
        String login = obterString("Login: ");
        String pass = obterString("Senha: ");
        String modelSmartphone = obterString("Modelo do celular: ");

        User user = this.userBuilder.setName(name).setLogin(login).setPass(pass).setModelSmartphone(modelSmartphone).builder();
        AddAdmin addAdmin = new AddAdminProxy(this.userManager, cod);
        if (addAdmin.enter(user)) System.out.println("Admin adicionado com sucesso!");
        else System.out.println("\nCódigo para adicionar usuário errado.");
    }


    private void singUp() throws ParseException {
        System.out.print("\nNome: ");
        String name = sc.nextLine();
        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Senha: ");
        String pass = sc.nextLine();
        System.out.print("Modelo do celular: ");
        String modelSmartphone = sc.nextLine();

        User user = this.userBuilder.setName(name).setLogin(login).setPass(pass).setModelSmartphone(modelSmartphone).builder();

        //chain
        IChain validationFields = new ValidationFields(user);
        IChain userExists = new UserExists(this.menuDashboardAdmin.showSystemUsers(), user);
        IChain signUpLeaf = new SignUpLeaf();

        validationFields.next(userExists);
        userExists.next(signUpLeaf);

        boolean res = validationFields.go();

        if (res == false) {
            System.out.println("Erro ao realizar cadastro. Informe os dados novamente, por favor.");
            singUp();
        } else {
            if (this.userAccessFactory.singUp(user, this.userProxy).register()) System.out.println("Cadastrado com sucesso.");
            else System.out.println("Falha ao cadastrar.");
        }

    }

    private void singIn() throws ParseException {
        String login = obterString("Login: ");
        String pass = obterString("Senha: ");

        User user = this.userBuilder.setLogin(login).setPass(pass).builder();
        if(this.userAccessFactory.singIn(userManager, user).enter()) {
            if (userManager.checkAdmin(user)) this.menuDashboardAdmin.showDashboardAdmin();
            else this.menuDashboardUser.showDashboardUser(user);
        }
        else System.out.println("Login inválido");
    }

}
