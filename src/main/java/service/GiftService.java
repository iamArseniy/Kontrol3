package service;

import model.Gift;
import repository.GiftRepository;

import java.sql.SQLException;
import java.util.List;

public class GiftService {
    private final GiftRepository giftRepository;

    public GiftService(GiftRepository giftRepository) {
        this.giftRepository = giftRepository;
    }

    public List<Gift> getAllGifts() throws SQLException {
        return giftRepository.findAll();
    }

    public Gift getGiftById(int id) throws SQLException {
        return giftRepository.findById(id);
    }
}
