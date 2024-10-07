package Autonoleggio;

abstract public class Veicolo {
    protected Tipo tipo;
    protected String codice;
    protected String targa;
    protected String marca;
    protected String modello;
    protected int posti;

    public Veicolo(){
        tipo = Tipo.Veicolo;
        codice = "";
        targa = "";
        marca = "";
        modello = "";
        posti = 0;
    }

    public String getCodice() {
        return codice;
    }

    public String getTarga() {
        return targa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public int getPosti() {
        return posti;
    }

    @Override
    public String toString(){
        return "La macchina di targa "+targa+" ha "+posti+" posti!";
    }
}
