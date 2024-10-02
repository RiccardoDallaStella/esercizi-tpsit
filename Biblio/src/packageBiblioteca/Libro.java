package packageBiblioteca;

public class Libro {
    private String autore;
    private String titolo;
    private int annoPubblicazione;

    public Libro(String autore, String titolo, int annoPubblicazione) {
        this.autore = autore;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
    }

    public Libro(String autore){
        this.autore = autore;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    @Override
    public String toString(){
        return "Autore: " + this.autore + ", Titolo: " + this.titolo + ", Anno pubblicazione: " + this.annoPubblicazione;
    }
}
