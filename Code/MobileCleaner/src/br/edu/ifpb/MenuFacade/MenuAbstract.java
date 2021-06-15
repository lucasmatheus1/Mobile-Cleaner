package br.edu.ifpb.MenuFacade;

import br.edu.ifpb.Model.User.User;

import java.util.Scanner;

public abstract class MenuAbstract {

    private Scanner sc = new Scanner(System.in);

    public String title;


    public MenuAbstract(String title) {
        this.title = title;
    }

    protected String obterString(String mensagem){
        String line = null;

        while (line == null){
            System.out.print(mensagem);
            line = sc.next();
        }

        return line;
    }


    protected Integer obterInteger(String mensagem){
        String numero;
        Integer numeroo = null;

        while (numeroo == null){
            try {
                System.out.print(mensagem);
                numero = sc.next();
                numeroo = Integer.parseInt(numero);
            }catch (NumberFormatException e){
                System.out.println("Valor inválido");
            }
        }
        return numeroo;
    }

    public String getTitle() {
        return title;
    }
}
