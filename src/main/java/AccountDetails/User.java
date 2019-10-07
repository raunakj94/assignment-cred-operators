package AccountDetails;

import Utility.EnumList;

import java.util.ArrayList;

public class User extends UserInfo {

    double pastOrderAmount;
    EnumList.PreferredModeOfPayment preferredModeOfPayment;
    EnumList.AccountType accountType;
    EnumList.CustomerType customerType;




    public User(String name, String email, String phone, int age, EnumList.Gender gender, Address address, double pastOrderAmount, EnumList.PreferredModeOfPayment preferredModeOfPayment, EnumList.AccountType accountType, EnumList.CustomerType customerType) {
        super(name, email, phone, age, gender, address);
        this.pastOrderAmount = pastOrderAmount;
        this.preferredModeOfPayment = preferredModeOfPayment;
        this.accountType = accountType;
        this.customerType = customerType;
    }


    public double getPastOrderAmount() {
        return pastOrderAmount;
    }

    public EnumList.PreferredModeOfPayment getPreferredModeOfPayment() {
        return preferredModeOfPayment;
    }

    public EnumList.AccountType getAccountType() {
        return accountType;
    }

    public EnumList.CustomerType getCustomerType() {
        return customerType;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", addressList=" + address +
                '}';
    }
}
