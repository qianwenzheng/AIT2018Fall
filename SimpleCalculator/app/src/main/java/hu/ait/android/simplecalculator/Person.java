package hu.ait.android.simplecalculator;

public class Person {

    private String name;
    private String address;
    private int userId;

    public Person(String name, String address, int userId) {
        this.name = name;
        this.address = address;
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
