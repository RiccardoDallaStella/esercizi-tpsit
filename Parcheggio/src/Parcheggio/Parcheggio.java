package Parcheggio;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Parcheggio {

    private ArrayList<Auto> auto;
    private String nome;

    public Parcheggio(String nome){
        this.nome = nome;
        auto = new ArrayList<Auto>();
    }

    public ArrayList<Auto> getAuto() {
        return auto;
    }

    public void setAuto(ArrayList<Auto> auto) {
        this.auto = auto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Benvenuto al parcheggio " + nome + '\n');
        for (Auto a: this.auto)
            builder.append("Auto: " + a + '\n');

        return builder.toString();
    }

    public void inserisciAuto(String targa, String marca, String modello){
        try{
            if(trovaAuto(targa) != null)
                throw new AlreadyExistingPlate(targa);

            Auto a = new Auto(targa,marca,modello);
            this.auto.add(a);
        }
        catch (IllegalArgumentException | AlreadyExistingPlate e){
            System.out.println(e.getMessage());
        }
    }

    public boolean rimuoviAuto(String targa) {
        return this.auto.remove(trovaAuto(targa));
    }

    public Auto trovaAuto(String targa){
        for(Auto a: this.auto)
            if (a.getTarga().equals(targa))
                return a;

        return null;
    }

    public boolean salvaSuFile(File file) throws Exception{

        FileWriter fw;
        if(file.exists())
            fw = new FileWriter(file);
        else throw new Exception("File non trovato");

        try{
            for (Auto a: this.auto){
                fw.write(a.toString() + '\n');
            }
            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }
}
