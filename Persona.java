import java.util.Scanner;

public abstract class Persona implements Datos, java.io.Serializable {
    protected String nombre;
    protected String nacionalidad;
    protected String eMail;

    public Persona(String nombre, String nacionalidad, String eMail) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.eMail = eMail;
    }

    public Persona() {
        System.out.println("---");
        capturar();
    }

    abstract String queSoy();

    public void capturar() {
        Scanner leer = new Scanner(System.in);
        System.out.print("Nombre:                   ");
        nombre = leer.nextLine();
        System.out.print("Nacionalidad:             ");
        nacionalidad = leer.nextLine();
        System.out.print("eMail:                    ");
        eMail = leer.nextLine();
    }

    public void mostrar() {
        System.out.println("---");
        System.out.println("Nombre:                   " + nombre);
        System.out.println("Nacionalidad:             " + nacionalidad);
        System.out.println("eMail:                    " + eMail);

    }

    //Get & Set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
