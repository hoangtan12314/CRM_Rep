package CRM;

import CRM.Manager.FileManager;
import CRM.Manager.InteractionManager;
import CRM.Manager.LeadManager;
import CRM.Object.Interaction;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LeadManager lm = new LeadManager();
        lm.delete();
    }
}
