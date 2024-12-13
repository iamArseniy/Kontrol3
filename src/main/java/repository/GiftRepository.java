package repository;

import db.DataBaseConfig;
import model.Gift;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class GiftRepository {
    private DataBaseConfig dataBaseConfig;

    public GiftRepository(DataBaseConfig dataBaseConfig) {
        this.dataBaseConfig = dataBaseConfig;
    }

    public List<Gift> findAll() throws SQLException {
        List<Gift> gifts = new ArrayList<>();
        String query = "SELECT * FROM gifts";


        try (Connection connection = dataBaseConfig.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Gift gift = new Gift();
                gift.setId(resultSet.getInt("id"));
                gift.setName(resultSet.getString("name"));
                gift.setGiverName(resultSet.getString("giver_name"));
                gift.setReceiverName(resultSet.getString("receiver_name"));
                gift.setDeliveryDate(resultSet.getDate("delivery_date").toLocalDate());
                gifts.add(gift);
            }
        } catch (SQLException e) {
            throw new SQLException("Ошибка подключения к базе данных", e);
        }
        return gifts;
    }


    public Gift findById(int id) throws SQLException {
        Gift gift = null;
        String query = "SELECT * FROM gifts WHERE id = ?";
        try (Connection connection = dataBaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    gift = new Gift();
                    gift.setId(resultSet.getInt("id"));
                    gift.setName(resultSet.getString("name"));
                    gift.setGiverName(resultSet.getString("giver_name"));
                    gift.setReceiverName(resultSet.getString("receiver_name"));
                    gift.setDeliveryDate(resultSet.getDate("delivery_date").toLocalDate());
                }
            }
        }
        return gift;
    }
}

