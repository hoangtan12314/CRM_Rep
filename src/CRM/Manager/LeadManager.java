package CRM.Manager;

import CRM.DataProcess.InputHandler;
import CRM.Object.Interaction;
import CRM.Object.Lead;

import java.util.ArrayList;
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

    @Override
    public void viewAll() {
        ArrayList<Lead> LeadList = getLeadList();
        System.out.println("");
    }

    @Override
    public void create() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
