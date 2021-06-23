package CRM.Manager;

import CRM.DataProcess.InputHandler;
import CRM.DataProcess.InputValidate;
import CRM.Object.Interaction;
import CRM.Object.Lead;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class LeadManager implements Manager{
    private final InputHandler handler = new InputHandler();
    private final FileManager fm = new FileManager();
    private ArrayList<Lead> getLeadList(){
        InputHandler handler = new InputHandler();
        FileManager fm = new FileManager();
        ArrayList<Lead> LeadList= new ArrayList();
        Scanner input = fm.openFile("lead.csv");
        while (input.hasNext()){
            String lines = input.nextLine();
            String[] strArr = lines.split(",");
            Lead lead = new Lead(strArr[0], strArr[1], handler.DateConverter(strArr[2]), strArr[3], strArr[4],
                    strArr[5], strArr[6]);
            LeadList.add(lead);
        }
        return LeadList;
    }

    private int getLastID(){
        InputHandler handler = new InputHandler();
        int listLength = getLeadList().size();
        Lead finalLead = getLeadList().get(listLength - 1);
        String lastidStr = finalLead.getId();
        return handler.getDigit(lastidStr)+1;
    }

    @Override
    public void viewAll() {
        ArrayList<Lead> LeadList = getLeadList();
        System.out.println("ID | Name | Date of birth | gender | phone | email | address |");
        for (Lead lead: LeadList){
            System.out.println(lead.toString());
        }
    }

    private void writeToFile(ArrayList<Lead> LeadList){
        File file = new File("lead.csv");
        FileManager fm = new FileManager();
        try {
            FileWriter fw = new FileWriter(file, false);
            for (Lead lead: LeadList){
                fw.write(lead.toString() + "\n");
            }
            fw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void create() {
        InputValidate valid = new InputValidate();
        String email = "";
        String dateStr = "";
        String gender = "";
        String phone = "";
        Scanner input = new Scanner(System.in);
        InputHandler handler = new InputHandler();
        String id = handler.idGenerator("lead_", getLastID());
        System.out.println("Enter the name: ");
        String name = input.nextLine();
        do {
            System.out.println("Enter the date of birth: ");
            dateStr = input.nextLine();
        } while(!valid.isDateValid(dateStr));
        Date dob = handler.DateConverter(dateStr);
        do {
            System.out.println("Enter the gender: ");
            gender = input.nextLine();
        } while(!valid.isGenderValid(gender));
        do {
            System.out.println("Enter the phone number: ");
            phone = input.nextLine();
        } while(!valid.isPhoneValid(phone));
        do {
            System.out.println("Enter the email: ");
            email = input.nextLine();
        } while (!valid.isEmailvalid(email));
        System.out.println("Enter the address: ");
        String address = input.nextLine();
        Lead lead = new Lead(id, name, dob, gender, phone, email, address);
        fm.appendToFile("lead.csv", lead.toString());
    }

    @Override
    public void update() {
        ArrayList <Lead> LeadList = getLeadList();
        InputHandler handler = new InputHandler();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of lead that you want to update: ");
        int numInt = input.nextInt();
        int updatePos = numInt - 1;
        input.nextLine();
        String id = handler.idGenerator("lead_", numInt);
        System.out.println(getLeadList().get(updatePos));
        System.out.println("Enter the name: ");
        String name = input.nextLine();
        System.out.println("Enter the date of birth: ");
        String dateStr = input.nextLine();
        Date dob = handler.DateConverter(dateStr);
        System.out.println("Enter the gender: ");
        String gender = input.nextLine();
        System.out.println("Enter the phone number: ");
        String phone = input.nextLine();
        System.out.println("Enter the email: ");
        String email = input.nextLine();
        System.out.println("Enter the address: ");
        String address = input.nextLine();
        Lead lead = new Lead(id, name, dob, gender, phone, email, address);
        LeadList.set(updatePos, lead);
        writeToFile(LeadList);
    }

    @Override
    public void delete() {
        Scanner input = new Scanner(System.in);
        ArrayList<Lead> LeadList = getLeadList();
        System.out.println("Enter the lead number that you want to delete: ");
        int lead_pos = input.nextInt() - 1;
        input.nextLine();
        System.out.println("Do you want to delete the lead: [" + getLeadList().get(lead_pos)+ "]? (Y/N): ");
        String decision = input.nextLine();
        if (decision.equals("Y")){
            LeadList.remove(lead_pos);
            writeToFile(LeadList);
        }
    }
}
