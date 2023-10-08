import java.util.Scanner;

public class Artista extends Persona implements java.io.Serializable {
    private String descripcion;

    public Artista() {
        super();
    }

    public Artista(String nombre, String nacionalidad, String eMail, String descripcion) {
        super(nombre, nacionalidad, eMail);
        this.descripcion = descripcion;
    }

    @Override
    public void capturar() {
        Scanner leer = new Scanner(System.in);
        super.capturar();
        System.out.print("Descripcion:              ");
        descripcion = leer.nextLine();
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("Descripcion:              " + descripcion);
    }

    public String queSoy() {
        return "Artista";
    }
}
