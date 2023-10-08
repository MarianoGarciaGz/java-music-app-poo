import java.util.Scanner;

public class Usuario extends Persona implements java.io.Serializable {
    private String telefono;

    public Usuario() {
        super();
    }

    public Usuario(String nombre, String nacionalidad, String eMail, String telefono) {
        super(nombre, nacionalidad, eMail);
        this.telefono = telefono;
    }

    public void capturar() {
        Scanner leer = new Scanner(System.in);
        super.capturar();
        System.out.print("telefono:                 ");
        telefono = leer.nextLine();
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("Telefono:                 " + telefono);
    }

    @Override
    public String queSoy() {
        return "Usuario";
    }
}
