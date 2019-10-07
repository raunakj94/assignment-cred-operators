
import AccountDetails.Address;
import AccountDetails.User;
import Evaluation.ConditionEvaluator;
import Evaluation.Context;
import Utility.EnumList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) throws IOException {
        User user;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Welcome! Please select one option to create a User\n"
                + "1. Test Online discount\n"
                + "2. Create Your own User\n"
                + "3. Exit\n");

        String option = reader.readLine();

        if(option.startsWith("1")){
            System.out.println("Testing No ads Feature for ad prime users...");
            user = new User("Ramya Rajawat","ramraj@rediff.com","9876543210",22,EnumList.Gender.Female,
                    new Address("2121", "Bajaj Road", "Agra", "Uttar Pradesh", "India", "282003"),
                    21000.0, EnumList.PreferredModeOfPayment.UPI, EnumList.AccountType.ACTIVE,EnumList.CustomerType.AD_PRIME);

        }
        else if(option.startsWith("2")) {
            System.out.println("Create your own user...");

            System.out.println("Enter the name of the user");
            String name = reader.readLine();

            System.out.println("Enter the house number of the user");
            String houseNumber = reader.readLine();

            System.out.println("Enter the street name of the user");
            String streetName = reader.readLine();

            System.out.println("Enter the city of the user");
            String city = reader.readLine();

            System.out.println("Enter the state of the user");
            String state = reader.readLine();

            System.out.println("Enter the country name of the user");
            String country = reader.readLine();

            System.out.println("Enter the pincode of the user");
            String pincode = reader.readLine();

            System.out.println("Enter the email of the used");
            String email = reader.readLine();

            System.out.println("Enter the phone number of the user");
            String phone = reader.readLine();

            System.out.println("Enter the gender of the user ( Male/Female)");
            EnumList.Gender gender = reader.readLine().toLowerCase().contains("female")? EnumList.Gender.Female : EnumList.Gender.Male;

            System.out.println("Enter the age of the user");
            int age;
            try {
                age = Integer.parseInt(reader.readLine());
            }catch (Exception e){
                System.out.println("Age should be an integer!!");
                System.out.println("Re enter the age of the user");
                age = Integer.parseInt(reader.readLine());
            }

            System.out.println("Enter the past order amount of the user");
            double pastOrderedAmount;
            try {
                pastOrderedAmount = Double.parseDouble(reader.readLine());
            } catch (Exception e){
                System.out.println("Past Ordered Amount should be an integer/double!!");
                System.out.println("Re enter the past order amount of the user");
                pastOrderedAmount = Double.parseDouble(reader.readLine());
            }


            System.out.println("Enter the preferred mode of payment of the user (COD/Wallet/CreditCard/DebitCard/UPI)");
            EnumList.PreferredModeOfPayment preferredModeOfPayment;
            String paymentString = reader.readLine().toLowerCase();
            if(paymentString.contains("cod"))
                preferredModeOfPayment = EnumList.PreferredModeOfPayment.COD;
            else if(paymentString.contains("wallet"))
                preferredModeOfPayment = EnumList.PreferredModeOfPayment.Wallet;
            else if(paymentString.contains("upi"))
                preferredModeOfPayment = EnumList.PreferredModeOfPayment.UPI;
            else if(paymentString.contains("credit"))
                preferredModeOfPayment = EnumList.PreferredModeOfPayment.CreditCard;
            else
                preferredModeOfPayment = EnumList.PreferredModeOfPayment.DebitCard;

            System.out.println("Enter the customer type of the user (AD_PRIME/PRIME/NORMAL)");
            EnumList.CustomerType customerType;
            String customerString = reader.readLine().toLowerCase();
            if(customerString.contains("adprime"))
                customerType = EnumList.CustomerType.AD_PRIME;
            else if(customerString.contains("prime"))
                customerType = EnumList.CustomerType.PRIME;
            else
                customerType = EnumList.CustomerType.NORMAL;

            System.out.println("Enter the account type of the user (ACTIVE/BLOCKED/CLOSED/WITHHOLD)");
            EnumList.AccountType accountType;
            String accountString = reader.readLine().toLowerCase();
            if(accountString.contains("active"))
                accountType = EnumList.AccountType.ACTIVE;
            else if(accountString.contains("blocked"))
                accountType = EnumList.AccountType.BLOCK;
            else if(accountString.contains("withhold"))
                accountType = EnumList.AccountType.WITHHOLD;
            else
                accountType = EnumList.AccountType.CLOSED;

            user = new User(name,
                    email, phone,age,
                    gender,
                    new Address(houseNumber, streetName, city, state, country, pincode),
                    pastOrderedAmount,
                    preferredModeOfPayment, accountType,customerType);

        }
        else {
            System.out.println("Exiting..");
            return;
        }

        System.out.println("User Object: "+user.toString());
        Context context = new Context(user);

        HashMap<String, String> featureConditionalExpressionMap = new HashMap<String, String>();
        featureConditionalExpressionMap.put("Do not show any ads", "AccountType == ACTIVE and CustomerType == AD_PRIME");
        featureConditionalExpressionMap.put("Online payment discount feature", "Age between 20 30 and ( PreferredModeOfPayment != COD or CustomerType != NORMAL )");
        featureConditionalExpressionMap.put("Same Day Delivery", "CustomerType == AD_PRIME");
        featureConditionalExpressionMap.put("Country Specific discount", "Age between 24 50 and country == US");
        featureConditionalExpressionMap.put("Eligibility for X% discount on some category", "AccountType == CLOSED and PastOrderAmount > 50000");

        for(String feature : featureConditionalExpressionMap.keySet()){
            System.out.println("\n\n----------------------------------------");
            System.out.println("Testing for the feature : "+feature);
            String infixExpression = featureConditionalExpressionMap.get(feature);
            System.out.println("Infix Expression: "+infixExpression);
            System.out.println("Postfix Expression: "+ConditionEvaluator.getInstance().infixToPostfix(infixExpression));
            try {
                if(ConditionEvaluator.getInstance().evaluateInfix(infixExpression, context))
                    System.out.println("The user "+user.getName()+" is eligible for the feature '"+feature+"'");
                else
                    System.out.println("The user "+user.getName()+" is NOT eligible for the feature '"+feature+"'");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("----------------------------------------");
            System.out.println("Press 1 to continue..");
            if(Integer.parseInt(reader.readLine())!=1)
                break;
        }
        System.out.println("Thanks for using. You can add extra feature gates in the code"
        );
    }
}