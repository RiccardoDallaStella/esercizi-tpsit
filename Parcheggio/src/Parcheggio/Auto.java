package Parcheggio;
import java.util.regex.*;

public class Auto {

    private String targa;
    private String marca;
    private String modello;

    public Auto(String targa, String marca, String modello) {

        controlloTarga(targa);
        this.targa = targa;
        this.marca = marca;
        this.modello = modello;
    }

    //^[A-Z]{2}\d{3}[A-Z]{2}$
    //Formato regex

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean controlloTarga(String targa){
        String patternTarga = "^[A-Z]{2}\\d{3}[A-Z]{2}$";

        Pattern pattern = Pattern.compile(patternTarga);
        Matcher matcher = pattern.matcher(targa);

        if(!matcher.matches())
            throw new IllegalArgumentException("La targa " + targa + " non è valida!");

        return true;
    }

    @Override
    public String toString() {
        return "La macchina di targa " + targa + ", è di marca: " + marca + " e modello: " + modello;
    }
}
