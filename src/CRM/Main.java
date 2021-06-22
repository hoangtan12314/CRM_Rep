package CRM;

import CRM.Manager.FileManager;
import CRM.Manager.InteractionManager;
import CRM.Manager.LeadManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InteractionManager im = new InteractionManager();
        im.create();
    }
}
