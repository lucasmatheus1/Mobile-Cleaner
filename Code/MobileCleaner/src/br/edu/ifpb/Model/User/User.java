package br.edu.ifpb.Model.User;


public class User {

    private Integer id;
    private String name;
    private String login;
    private String pass;
    private String permission;
    private String notification;
    private String modelSmartphone;
    private String dateSingUp;
    private String dateNextClean;

    public User(String name, String login, String pass, String modelSmartphone) {
        this.name = name;
        this.login = login;
        this.pass = pass;
        this.modelSmartphone = modelSmartphone;
    }

    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public User(String name, String login, String pass, String modelSmartphone, String permission) {
        this.name = name;
        this.login = login;
        this.pass = pass;
        this.modelSmartphone = modelSmartphone;
        this.permission = permission;
    }

    public User() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPermission() {
        return permission;
    }

    public String getNotification() {
        return notification;
    }


    public String getModelSmartphone() {
        return modelSmartphone;
    }

    public void setModelSmartphone(String modelSmartphone) {
        this.modelSmartphone = modelSmartphone;
    }

    public String getDateSingUp() {
        return dateSingUp;
    }


    public String getDateNextClean() {
        return dateNextClean;
    }


    public void setPermission(String permission) {
        this.permission = permission;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public void setDateSingUp(String dateSingUp) {
        this.dateSingUp = dateSingUp;
    }

    public void setDateNextClean(String dateNextClean) {
        this.dateNextClean = dateNextClean;
    }

    @Override
    public String toString() {
        return  "ID: " + id + "   " + "Login: " + login;
    }
}
