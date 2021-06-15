package br.edu.ifpb.Model.User;


public interface IUser {

    String setPermission();
    String setNotification();
    String setDateSingUp();
    String setDateNextClean(String date, int days);

}