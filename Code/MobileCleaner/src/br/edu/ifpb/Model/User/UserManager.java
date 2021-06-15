package br.edu.ifpb.Model.User;
import br.edu.ifpb.ConnectionDBSingleton.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class UserManager {

    private final java.sql.Connection connection;

    public UserManager() {
        this.connection = Connection.getInstance().getConnection();
    }

    public Boolean addUser(User user) {

        String sql = "INSERT INTO users(" +
                "name, " +
                "login, " +
                "pass, " +
                "permission, " +
                "notification, " +
                "modelSmartphone, " +
                "dateSingUp, " +
                "dateNextClean) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPass());
            preparedStatement.setString(4, user.getPermission());
            preparedStatement.setString(5, user.getNotification());
            preparedStatement.setString(6, user.getModelSmartphone());
            preparedStatement.setString(7, user.getDateSingUp());
            preparedStatement.setString(8, user.getDateNextClean());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;

        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }


    public boolean verifyUser(User user) {

        ResultSet resultSet = null;

        String sql = "SELECT id, "
                + "login, "
                + "pass "
                + "FROM users "
                + "WHERE login = '" + user.getLogin() + "' AND "
                + "pass = '" + user.getPass() + "'";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                preparedStatement.close();
                return true;
            } else {
                return false;
            }
        } catch (SQLException u) {
            u.printStackTrace();
            return false;
        } finally {
            try {
                resultSet.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


    public boolean checkAdmin(User user) {
        ResultSet resultSet = null;

        String sql = "SELECT permission"
                + " FROM users "
                + "WHERE login = '" + user.getLogin() + "' AND "
                + "pass = '" + user.getPass() + "'";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString(1).equals("admin");
            } else {
                return false;
            }
        } catch (SQLException u) {
            u.printStackTrace();
            return false;
        } finally {
            try {
                resultSet.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


    public List<User> getListUser(){
        List<User> list = new ArrayList<>();

        ResultSet resultSet = null;
        User user;

        String sql = "SELECT * FROM users";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                user = new User();

                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setLogin(resultSet.getString(3));
                user.setPass(resultSet.getString(4));
                if (resultSet.getString(5) == null){
                    user.setPermission("");
                } else {
                    user.setPermission(resultSet.getString(5));
                }

                user.setNotification(resultSet.getString(6));
                user.setModelSmartphone(resultSet.getString(7));
                user.setDateNextClean(resultSet.getString(8));
                user.setDateSingUp(resultSet.getString(9));

                if (user.getPermission().equals("user")){
                    list.add(user);
                }

            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            try{
                resultSet.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return list;
    }

    public boolean sendMenssage(String login, String message) {

        String sql = "UPDATE users SET notification = '" + message + "' WHERE login = " + "'" + login + "'";

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;

        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }


    public String verify(User user) {

        String sql = "SELECT * FROM users WHERE login = '" + user.getLogin() + "'";

        ResultSet resultSet = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                String message = resultSet.getString(6);
                if (message.equals("")) {
                    return "Sem notificação";
                } else {
                    sendMenssage(user.getLogin(), "");
                    return message;
                }
            }
        } catch (SQLException u) {
            u.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return "Sem notificação";
    }


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


    public boolean clean(String login) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        String sql = "UPDATE users SET dateNextClean = '" +
                setDateNextClean(simpleDateFormat.format(date),
                7) + "' WHERE login = " + "'" + login + "'";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;

        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }


    public String showNextDate(String login) {
        ResultSet resultSet = null;

        String sql = "SELECT * FROM users WHERE login = '" + login + "'";


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString(8);
            } else {
                return "Não encontrado.";
            }
        } catch (SQLException u) {
            u.printStackTrace();
            return "Não encontrado.";
        } finally {
            try {
                resultSet.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    public String getModelSmartphone(String login) {

        ResultSet resultSet = null;

        String sql = "SELECT modelSmartphone FROM users WHERE login = '" + login + "'";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString(1);
            } else {
                return "";
            }
        } catch (SQLException u) {
            u.printStackTrace();
            return "";
        } finally {
            try {
                resultSet.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }
}