package CRM.Manager;

import CRM.DataProcess.InputHandler;
import CRM.Object.Interaction;

import java.util.Date;
import java.util.Scanner;

public class InteractionManager implements Manager{
    private static final Scanner input= FileManager.openFile("interaction.csv");
    private final InputHandler handler = new InputHandler();
    @Override
    public void viewAll() {
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
        System.out.println("Enter the interaction ID: ");
        String id = input.nextLine();
        System.out.println("Enter the date of birth: ");
        String dateStr = input.nextLine();
        Date date = handler.DateConverter(dateStr);
        System.out.println("Enter the lead involved: ");
        String lead = input.nextLine();
        System.out.println("Enter the means: ");
        String means = input.nextLine();
        System.out.println("Enter the potential: ");
        String potential = input.nextLine();
        Interaction interaction = new Interaction(id, date, lead, means, potential);

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
