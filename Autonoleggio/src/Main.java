import Autonoleggio.*;

import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Autonoleggio autonoleggio = new Autonoleggio();
        File file = new File("src/Autonoleggio/veicoli.txt");

        try{
            autonoleggio.aggiungiVeicolo(new Motocicletta("V001", "AB123CD", "Fiat", "Panda", 4));
            autonoleggio.aggiungiVeicolo(new Furgone("V002", "EF456GH", "Ford", "Fiesta", 5));
            autonoleggio.aggiungiVeicolo(Tipo.Automobile, "V003", "IJ789KL", "Toyota", "Yaris", 5);
            autonoleggio.aggiungiVeicolo(Tipo.Automobile,"V003", "IJ789FL", "Toyota", "Ibrida", 5);
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }

        try{
            autonoleggio.salvaSuFile(file);
            System.out.println("Veicoli salvati su file.");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            autonoleggio.caricaDaFile(file);
            System.out.println("Veicoli caricati dal file.");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}