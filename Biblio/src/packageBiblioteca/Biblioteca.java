package packageBiblioteca;
import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Libro> listaLibri;

    public Biblioteca(){
        this.listaLibri = new ArrayList<>();
    }

    public void Inserisci(Libro libro){
        this.listaLibri.add(libro);
    }

    public Libro Search(String titolo){
        for(Libro libro : this.listaLibri){
            if(libro.getTitolo().equalsIgnoreCase(titolo)){
                return libro;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(Libro libro: this.listaLibri){
            result.append(libro.toString()).append("\n");
        }
        return result.toString();
    }
}
