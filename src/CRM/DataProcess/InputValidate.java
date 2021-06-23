package CRM.DataProcess;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InputValidate {
    public boolean isEmailvalid(String email){
        final String format1 = "@gmail.com";
        final String format2 = "@rmit.edu.vn";
        if (email.contains(format1) || email.contains(format2)){
            return true;
        } else {
            System.out.println("Invalid email");
            return false;
        }
    }

    public boolean isDateValid(String dateStr){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            Date date = sdf.parse(dateStr);
            return true;
        } catch (ParseException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean isGenderValid(String gender){
        if (gender.equals("male") || gender.equals("female")){
            return true;
        } else{
            System.out.println("Invalid gender. Must be female or male");
            return false;
        }

    }

    public boolean isPhoneValid(String phone){
        if(phone.charAt(0) == '0' && phone.length() == 10){
            return true;
        } else{
            System.out.println("Invalid phone");
            return false;
        }

    }
}
