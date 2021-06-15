package br.edu.ifpb.ActionDashboard.AdapterSend;

public class Tim implements IAdapter{

    private BaseTIM tim;

    public Tim() {
        this.tim = new BaseTIM();
    }

    @Override
    public String sendMessage(String login, String message) {
        return this.tim.textsTIM(login, message);
    }
}
