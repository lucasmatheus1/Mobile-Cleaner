package br.edu.ifpb.ActionDashboard;

import br.edu.ifpb.Model.User.UserManager;

public class SendMessage {

    UserManager userManager;

    public SendMessage(UserManager userManager) {
        this.userManager = userManager;
    }

    public boolean send(String login, String message) {
        FacadeSendMessage facadeSendMessage = new FacadeSendMessage(this.userManager);
        return facadeSendMessage.sendMessages(login, message);
    }
}
