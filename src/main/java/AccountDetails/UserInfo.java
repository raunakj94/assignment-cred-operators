package AccountDetails;

import Utility.EnumList;

import java.util.ArrayList;

public abstract class UserInfo {

    protected String name;
    protected String email;
    protected String phone;
    protected int age;
    protected EnumList.Gender gender;
    protected Address address;

    public UserInfo(String name, String email, String phone, int age, EnumList.Gender gender, Address address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }


    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", addressList=" + address +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }

    public EnumList.Gender getGender() {
        return gender;
    }

    public Address getAddress() {
        return address;
    }
}
