package br.edu.ifpb.ActionDashboard;

import br.edu.ifpb.Model.User.User;
import br.edu.ifpb.Model.User.UserManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListUserBehind {

    UserManager userManager;

    public ListUserBehind(UserManager userManager) {
        this.userManager = userManager;
    }

    public List<User> showBehind() throws ParseException {

        List<User> listAux = this.userManager.getListUser();
        List<User> list = new ArrayList<>();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String dateToday = simpleDateFormat.format(date);

        for (User user : listAux) {
            if (dateToday.compareTo(user.getDateNextClean()) > 0){
                list.add(user);
            }
        }
        return list;
    }
}
