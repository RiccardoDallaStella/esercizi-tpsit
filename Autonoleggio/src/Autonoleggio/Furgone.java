package Autonoleggio;

public class Furgone extends Veicolo{

    public Furgone(){
        super();
    }
    public Furgone(String codice, String targa, String marca, String modello, int posti) {
        tipo = Tipo.Furgone;
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
