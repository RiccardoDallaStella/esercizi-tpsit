package Autonoleggio;

public class AlreadyExistingPlate extends Exception {
    public AlreadyExistingPlate(String message) {
        super(message);
    }

    public AlreadyExistingPlate(){
        super("Targa già esistente");
    }
}
