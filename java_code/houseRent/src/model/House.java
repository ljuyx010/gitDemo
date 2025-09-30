package model;

public class House {
    private int id;
    private String name;
    private String address;
    private String phone;
    private double rent;
    private String status;

    public House(int id, String name, String address, String phone, double rent, String status) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.rent = rent;
        this.status = status;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @java.lang.Override
    public String toString() {
        return id +
                "\t\t" + name +
                "\t\t" + address +
                "\t\t" + phone +
                "\t\t" + rent +
                "\t\t" + status ;
    }
}