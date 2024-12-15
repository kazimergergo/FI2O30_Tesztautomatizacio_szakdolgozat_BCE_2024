package Test_Executions;

import Smoke_Test_Cases.*;

import java.util.logging.Level;
import java.util.logging.Logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Smoke_Test_Cycle {
    private static int helyes=0;


    public static void main(String[] args) {
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
        long timer= System.currentTimeMillis();
        System.out.println("Test Started\n ------------------------------------\n");
        try {
            smoke1_MediaMarkt_kedvencek.main();
        }
        catch (Exception e) {
            System.exit(1);
        };

        try {
            smoke2_Toplista.main();
        }
        catch (Exception e) {
            System.exit(1);
        };

        try {
            smoke3_Ujdonsagaink.main();
        }
        catch (Exception e) {
            System.exit(1);
        };

        try {
            smoke4_Meg_elerheto.main();
        }
        catch (Exception e) {
            System.exit(1);
        };

        try {
            smoke5_Szolgaltatasaink.main();
        }
        catch (Exception e) {
            System.exit(1);
        };

        try {
            smoke6_Informacio.main();
        }
        catch (Exception e) {
            System.exit(1);
        };

        try {
            smoke7_Aruhitel.main();
        }
        catch (Exception e) {
            System.exit(1);
        };

        try {
            smoke8_Hirlevel.main();
        }
        catch (Exception e) {
            System.exit(1);
        };

        try {
            smoke9_Cegeknek.main();
        }
        catch (Exception e) {
            System.exit(1);
        };

        try {
            smoke10_Ugyfelszolgalat.main();
        }
        catch (Exception e) {
            System.exit(1);
        };

        try {
            smoke11_Keresosav.main();
        }
        catch (Exception e) {
            System.exit(1);
        };

        try {
            smoke12_Kosar.main();
        }
        catch (Exception e) {
            System.exit(1);
        };

        try {
            smoke13_Bejelentkezes.main();
        }
        catch (Exception e) {
            System.exit(1);
        };


        //Futási idő számítása, logolás
        System.out.println("\nNumber of Successful Test Cases: " + helyes);
        System.out.println("\n------------------------------------");
        if (helyes==13){
            System.out.println("The smoke test cycle was successful.");
        } else {
            System.out.println("The smoke test cycle was unsuccessful.");
        }

        System.out.println("Execution time: " + ((System.currentTimeMillis() - timer) / 1000) + " seconds");

    }


    // Setter, hogy növelhessük a számlálót
    public static void incrementHelyes() {
        helyes++;
    }
}
