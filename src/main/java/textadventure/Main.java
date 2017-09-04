package textadventure;

import util.AutoRunFromConsole;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AutoRunFromConsole.runYourselfInConsole(false);
        Szene s = SzeneFactory.geyByID(1);
        s.printText();
        while (true) {
            String eingabe = new Scanner(System.in).next();
            if (eingabe.equalsIgnoreCase("ende")) {
                System.exit(0);
            } else {
                int a = 0;
                try {
                    a = Integer.valueOf(eingabe);
                    if (a <= 0 || a > s.optionen.size()) {
                        System.out.println("Ungültige Eingabe!");
                    } else {
                        s = SzeneFactory.geyByID(s.optionen.get(a - 1));
                        s.printText();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ungültige Eingabe!");
                }

            }
        }
    }

}
