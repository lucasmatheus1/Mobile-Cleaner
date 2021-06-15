package br.edu.ifpb.ActionDashboard;

import br.edu.ifpb.ActionDashboard.AdapterSend.ClassAdapter;
import br.edu.ifpb.ActionDashboard.AdapterSend.Gmail;
import br.edu.ifpb.ActionDashboard.AdapterSend.IAdapter;
import br.edu.ifpb.ActionDashboard.AdapterSend.Tim;
import br.edu.ifpb.Model.User.UserManager;

public class FacadeSendMessage {

    UserManager userManager;

    public FacadeSendMessage(UserManager userManager) {
        this.userManager = userManager;
    }

    public boolean sendMessages(String login, String message) {

        IAdapter type = new Gmail();
        ClassAdapter classAdapter = new ClassAdapter(type);
        String output = classAdapter.sendMessage(login, message);

        IAdapter type_2 = new Tim();
        ClassAdapter classAdapter_2 = new ClassAdapter(type_2);
        String output_2 = classAdapter_2.sendMessage(login, message);

        System.out.println(output);
        System.out.println(output_2);

        return this.userManager.sendMenssage(login, message);
    }

}
