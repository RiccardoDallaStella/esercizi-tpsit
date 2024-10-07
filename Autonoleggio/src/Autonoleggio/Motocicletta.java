package Autonoleggio;

public class Motocicletta extends Veicolo{

    public Motocicletta(){
        super();
    }
    public Motocicletta(String codice, String targa, String marca, String modello, int posti) {
        tipo = Tipo.Motocicletta;
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
