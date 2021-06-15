package br.edu.ifpb.Model.CleanPlace;

import br.edu.ifpb.ConnectionDBSingleton.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CleanPlaceManager {

    private final java.sql.Connection connection;

    public CleanPlaceManager() {
        this.connection = Connection.getInstance().getConnection();
    }


    public List<CleanPlace> getCleanPlaceList() {
        List<CleanPlace> list = new ArrayList<>();

        ResultSet resultSet = null;
        CleanPlace place;

        String sql = "SELECT * FROM places";


        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                place = new CleanPlace();

                place.setName(resultSet.getString(1));
                place.setSector(resultSet.getString(2));
                list.add(place);
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

    public boolean addPlace(CleanPlace cleanPlace) {
        String sql = "INSERT INTO places(" +
                "name, " +
                "sector) VALUES(?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cleanPlace.getName());
            preparedStatement.setString(2, cleanPlace.getSector());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;

        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }


}
