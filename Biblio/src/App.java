import packageBiblioteca.*;

public class App {
    public static void main(String[] args) {

        Libro libro = new Libro("Giarettozzo", "La signora degli agnelli", 2006);
        Libro libroDue = new Libro("Iftimie", "L'arte del dormire in classe", 2009);

        Biblioteca biblioteca = new Biblioteca();

        biblioteca.Inserisci(libro);
        biblioteca.Inserisci(libroDue);

        System.out.println(biblioteca);
        System.out.print(biblioteca.Search("Harry Potter"));
    }
}