package Autonoleggio;

public class Automobile extends Veicolo{

    public Automobile(){
        super();
    }
    public Automobile(String codice, String targa, String marca, String modello, int posti) {
        tipo = Tipo.Automobile;
        this.codice = codice;
        this.targa = targa;
        this.marca = marca;
        this.modello = modello;
        this.posti = posti;
    }

    @Override
    public String toString(){
        return tipo+","+codice + "," + targa + "," + marca + "," + modello + "," + posti;
    }
}
