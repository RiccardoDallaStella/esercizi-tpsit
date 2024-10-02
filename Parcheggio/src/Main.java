import Parcheggio.*;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        String path = System.getProperty("user.dir"); //Utilizzato per capire al meglio il percorso del file di esecuzione del programma
        File f = new File("src/Parcheggio/auto.txt");

        Parcheggio p = new Parcheggio("FedePark");

        p.inserisciAuto("AB839DD", "Ferrari", "Roma");

        System.out.println(p);

        p.inserisciAuto("AB839DD", "Porsche", "P34");
        p.inserisciAuto("SD273LR", "Porsche", "Carrera");
        p.inserisciAuto("ACC43TT", "Suzuki", "Vitara");
        p.inserisciAuto("ES543WD", "Mclaren", "MCL38");
        p.rimuoviAuto("SD273LR");

        try{
            p.salvaSuFile(f);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}