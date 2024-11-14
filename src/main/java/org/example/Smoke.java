package org.example;

import java.util.logging.Level;
import java.util.logging.Logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Smoke {
    private static int helyes=0;


    public static void main(String[] args) {
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
        long timer= System.currentTimeMillis();
        System.out.println("Test Started\n ------------------------------------\n");
        smoke1_MediaMarkt_kedvencek.main();
        smoke2_Toplista.main();
        smoke3_Ujdonsagaink.main();
        smoke4_Meg_elerheto.main();
        smoke5_Szolgaltatasaink.main();
        smoke6_Informacio.main();
        smoke7_Aruhitel.main();
        smoke8_Hirlevel.main();
        smoke9_Cegeknek.main();
        smoke10_Ugyfelszolgalat.main();
        smoke11_Keresosav.main();
        smoke12_Kosar.main();
        smoke13_Bejelentkezes.main();

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
