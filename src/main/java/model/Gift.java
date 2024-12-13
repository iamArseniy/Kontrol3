package model;


import java.time.LocalDate;

public class Gift {
    private int id;
    private String name;
    private String giverName;
    private String receiverName;
    private LocalDate deliveryDate;

    public Gift() {
    }

    public Gift(int id, String name, String giverName, String receiverName, LocalDate deliveryDate) {
        this.id = id;
        this.name = name;
        this.giverName = giverName;
        this.receiverName = receiverName;
        this.deliveryDate = deliveryDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGiverName() {
        return giverName;
    }

    public void setGiverName(String giverName) {
        this.giverName = giverName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
