import java.sql.Date;
import java.util.ArrayList;

public class Cliente {
    private String cognome;
    private String nome;
    private Date annoNascita;
    private String indirizzo;
    private String localita;

    public Cliente() {
        cognome = "";
        nome = "";
        annoNascita = new Date(0,0,0);
        indirizzo = "";
        localita = "";
    }

    public Cliente(String cognome, String nome, Date annoNascita, String indirizzo, String localita) {
        this.cognome = cognome;
        this.nome = nome;
        this.annoNascita = annoNascita;
        this.indirizzo = indirizzo;
        this.localita = localita;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getAnnoNascita() {
        return annoNascita;
    }

    public void setAnnoNascita(Date annoNascita) {
        this.annoNascita = annoNascita;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getLocalita() {
        return localita;
    }

    public void setLocalita(String localita) {
        localita = localita;
    }
    
    @Override
    public String toString(){
        return "Sono "+nome+" "+cognome+" abito in "+indirizzo;
    }
}
