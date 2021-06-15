package br.edu.ifpb.ActionDashboard.AdapterSend;

public class ClassAdapter implements IAdapter{

    private IAdapter typeMessage;

    public ClassAdapter(IAdapter typeMessage) {
        this.typeMessage = typeMessage;
    }

    @Override
    public String sendMessage(String login, String message) {
        return this.typeMessage.sendMessage(login, message);
    }
}
