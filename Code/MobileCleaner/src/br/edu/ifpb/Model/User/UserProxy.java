package br.edu.ifpb.Model.User;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UserProxy implements IUser{

    UserManager userManager;

    public UserProxy(UserManager userManager) {
        this.userManager = userManager;
    }

    public boolean singUp(User user) {
        user.setDateSingUp(setDateSingUp());
        user.setPermission(setPermission());
        user.setNotification(setNotification());
        user.setDateNextClean(setDateNextClean(user.getDateSingUp(), 7));
        return this.userManager.addUser(user);
    }

    @Override
    public String setDateSingUp() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    @Override
    public String setPermission() {
        return "user";
    }

    @Override
    public String setNotification() {
        return "";
    }

    @Override
    public String setDateNextClean(String date, int days) {
        String DataAlterada = "";
        String FormatoDaData = "dd/MM/yyyy";
        try {
            SimpleDateFormat format = new SimpleDateFormat(FormatoDaData);
            java.sql.Date Data = new java.sql.Date(format.parse(date).getTime());

            Calendar ob = Calendar.getInstance();
            ob.setTime(Data);
            ob.add(Calendar.DATE, + days);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FormatoDaData);
            DataAlterada = simpleDateFormat.format(ob.getTime());
        } catch (Exception e) {
            return "inválido";
        }

        return DataAlterada;
    }

}
