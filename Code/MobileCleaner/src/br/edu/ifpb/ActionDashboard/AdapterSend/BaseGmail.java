package br.edu.ifpb.ActionDashboard.AdapterSend;

public class BaseGmail {

    // Simular API
    public String textsGmail(String login, String message){

        String output = "";

        output += "\nEmail do Google enviado!\n";
        output += "\nLogin: " + login;
        output += "\nMensagem: " + message;
        output += "\n";

        return output;
    }
}
