package br.edu.ifpb.ActionDashboard.AdapterSend;

public class BaseTIM {

    // Simular API
    public String textsTIM(String login, String message){

        String output = "";

        output += "\nSMS enviado!\n";
        output += "\nLogin: " + login;
        output += "\nMensagem: " + message;
        output += "\n";

        return output;
    }
}
