package advanced12th.t1;

public class Customer //this class is for Signing users up and getting thier information
{

    private String name;
    private String PhoneNum;
    private String address;

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return PhoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNum(String PhoneNum) {
        this.PhoneNum = PhoneNum;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
