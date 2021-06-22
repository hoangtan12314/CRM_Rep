package CRM.Manager;

import CRM.DataProcess.InputHandler;
import CRM.Object.Interaction;
import jdk.internal.util.xml.impl.Input;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class InteractionManager implements Manager{
    private final InputHandler handler = new InputHandler();
    private final FileManager fm = new FileManager();


    private ArrayList<Interaction> getInterList(){
        FileManager fm = new FileManager();
        InputHandler handler = new InputHandler();
        ArrayList<Interaction> InterList= new ArrayList();
        Scanner input = fm.openFile("interaction.csv");
        while (input.hasNext()){
            String lines = input.nextLine();
            String[] strArr = lines.split(",");
            Interaction interaction = new Interaction(strArr[0], handler.DateConverter(strArr[1]), strArr[2], strArr[3], strArr[4]);
            InterList.add(interaction);
        }
        return InterList;
    }

    private int getLastID(){
        InputHandler handler = new InputHandler();
        int listLength = getInterList().size();
        Interaction finalInter = getInterList().get(listLength - 1);
        String lastidStr = finalInter.getId();
        return handler.getDigit(lastidStr)+1;
    }

    public void writeToFile(ArrayList<Interaction> InterList){
        File file = new File("interaction.csv");
        FileManager fm = new FileManager();
        try {
            FileWriter fw = new FileWriter(file, false);
            for (Interaction interactions: InterList){
                fw.write(interactions.toString() + "\n");
            }
            fw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void viewAll() {
        Scanner input = fm.openFile("interaction.csv");
        System.out.println("ID | Interaction Date | Lead | Means | Potential |");
        while(input.hasNext()){
            String lines = input.nextLine();
            String[] linesArr = lines.split(",");
            for (int i = 0; i < linesArr.length; i++){
                System.out.print(linesArr[i] + "|");
            }
            System.out.print("\n");
        }
        input.close();
    }

    @Override
    public void create() {
        Scanner input = new Scanner(System.in);
        InputHandler handler = new InputHandler();
        String id = handler.idGenerator("inter_", getLastID());
        System.out.println("Enter the date of birth: ");
        String dateStr = input.nextLine();
        Date date = handler.DateConverter(dateStr);
        System.out.println("Enter the id number of the lead involved: ");
        int lead_int = input.nextInt();
        input.nextLine();
        String lead = handler.idGenerator("lead_", lead_int);
        System.out.println("Enter the means: ");
        String means = input.nextLine();
        System.out.println("Enter the potential: ");
        String potential = input.nextLine();
        Interaction interaction = new Interaction(id, date, lead, means, potential);
        fm.appendToFile("interaction.csv", interaction.toString());
    }

    @Override
    public void update() {
        ArrayList <Interaction> InterList = getInterList();
        InputHandler handler = new InputHandler();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of interaction that you want to update: ");
        int numInt = input.nextInt();
        int updatePos = numInt - 1;
        input.nextLine();
        String id = handler.idGenerator("inter_", numInt);
        System.out.println(getInterList().get(updatePos));
        System.out.println("Enter the date of interaction: ");
        String dateStr = input.nextLine();
        Date date = handler.DateConverter(dateStr);
        System.out.println("Enter the id number of the lead involved: ");
        int lead_int = input.nextInt();
        input.nextLine();
        String lead = handler.idGenerator("lead_", lead_int);
        System.out.println("Enter the means: ");
        String means = input.nextLine();
        System.out.println("Enter the potential: ");
        String potential = input.nextLine();
        Interaction interaction = new Interaction(id, date, lead, means, potential);
        InterList.set(updatePos, interaction);
        writeToFile(InterList);
    }

    @Override
    public void delete() {
        Scanner input = new Scanner(System.in);
        ArrayList<Interaction> InterList = getInterList();
        System.out.println("Enter the interaction number that you want to delete: ");
        int inter_pos = input.nextInt() - 1;
        input.nextLine();
        System.out.println("Do you want to delete the interaction: [" + getInterList().get(inter_pos)+ "]? (Y/N): ");
        String decision = input.nextLine();
        if (decision.equals("Y")){
            InterList.remove(inter_pos);
            writeToFile(InterList);
        }
    }
}
