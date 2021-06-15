package br.edu.ifpb.ActionDashboard.AdapterSend;

public class Gmail implements IAdapter{

    private BaseGmail gmail;

    public Gmail() {
        this.gmail = new BaseGmail();
    }

    @Override
    public String sendMessage(String login, String message) {
        return this.gmail.textsGmail(login, message);
    }
}
