package Autonoleggio;

import java.io.*;
import java.util.ArrayList;

public class Autonoleggio {
    private ArrayList<Veicolo> veicoli;

    public Autonoleggio(){
        veicoli = new ArrayList<Veicolo>();
    }

    public ArrayList<Veicolo> getVeicoli() {
        return veicoli;
    }

    public void aggiungiVeicolo(Veicolo veicolo) throws Exception {
        if(ricercaVeicolo(1, "", veicolo.getTarga()) != null)
            throw new AlreadyExistingPlate();

        veicoli.add(veicolo);
    }

    public void aggiungiVeicolo(Tipo tipo, String codice, String targa, String marca, String modello, int posti) throws Exception {
        if(ricercaVeicolo(1, "", targa) != null)
            throw new AlreadyExistingPlate();

        switch(tipo){
            case Motocicletta:
                veicoli.add(new Motocicletta(codice, targa, marca, modello, posti));
                break;

            case Automobile:
                veicoli.add(new Automobile(codice, targa, marca, modello, posti));
                break;

            case Furgone:
                veicoli.add(new Furgone(codice, targa, marca, modello, posti));
                break;

            default:
                throw new Exception("Errore nel tipo di veicolo");
        }
    }

    public Veicolo rimuoviVeicolo(int scelta, String codice, String targa) throws Exception {
        Veicolo v;
        switch(scelta){
            case 0:
                v = ricercaVeicolo(0, codice, "");
                veicoli.remove(v);
                System.out.println("Veicolo rimosso con successo");
                return v;

            case 1:
                v = ricercaVeicolo(1, "", targa);
                veicoli.remove(v);
                System.out.println("Veicolo rimosso con successo");
                return v;

            default:
                throw new Exception("Errore nella scelta dell'opzione");
        }

    }

    public Veicolo ricercaVeicolo(int scelta, String codice, String targa) throws Exception{

        switch(scelta){
            case 0:
                for (Veicolo veicolo : veicoli) {
                    if(veicolo.getCodice().equals(codice))
                        return veicolo;
                }
                return null;

            case 1:
                for (Veicolo veicolo : veicoli) {
                    if(veicolo.getTarga().equals(targa))
                        return veicolo;
                }
                return null;

            default:
                throw new Exception("Errore nella scelta dell'opzione");
        }
    }

    public ArrayList<Veicolo> ricercaVeicolo(int posti){

        ArrayList<Veicolo> num = new ArrayList<Veicolo>();
        for(Veicolo veicolo : veicoli){
            if(veicolo.getPosti() == posti)
                num.add(veicolo);
        }

        if(num.isEmpty()){
            System.out.println("Non ci sono veicoli con "+posti+" posti");
            return null;
        }

        return num;
    }

    private void RipristinaVeicoli(){
        veicoli.clear();
    }

    public boolean salvaSuFile(File file) throws Exception {
        FileWriter fw;
        if(file.exists())
            fw = new FileWriter(file);
        else throw new Exception("File non trovato");

        try{
            for (Veicolo v: this.veicoli){
                fw.write(v.toString() + '\n');
            }
            fw.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    public boolean caricaDaFile(File file) throws Exception {
        FileReader fr;
        if(file.exists())
            fr = new FileReader(file);
        else throw new Exception("File non trovato");

        try (BufferedReader br = new BufferedReader(fr)) {
            RipristinaVeicoli();
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] obj = linea.split(",");
                String tipo = obj[0];

                switch(tipo){
                    case "Motocicletta":
                        veicoli.add(new Motocicletta(obj[1], obj[2], obj[3], obj[4], Integer.parseInt(obj[5])));
                        break;

                    case "Automobile":
                        veicoli.add(new Automobile(obj[1], obj[2], obj[3], obj[4], Integer.parseInt(obj[5])));
                        break;

                    case "Furgone":
                        veicoli.add(new Furgone(obj[1], obj[2], obj[3], obj[4], Integer.parseInt(obj[5])));
                        break;

                    default:
                        throw new Exception("Errore nel tipo di veicolo");
                }
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    public ArrayList<Veicolo> riportaInventario(){
         ArrayList<Veicolo> inventario = new ArrayList<Veicolo>();

        for (Veicolo veicolo : veicoli){
            int i = 0;
            String marca = veicolo.getMarca();
            for(Veicolo veicolo2 : veicoli){
                if(marca.equals(veicolo2.getMarca())){
                    i++;
                }
            }
            System.out.println("Ci sono "+i+" macchine di marca "+marca);
        }

        return inventario;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Veicolo veicolo: veicoli){
            sb.append(veicolo);
            sb.append('\n');
        }
        return sb.toString();
    }
}
