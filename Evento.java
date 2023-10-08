import java.util.Scanner;

public class Evento implements java.io.Serializable {
    protected String fecha;
    protected String hora;
    protected String usuario;
    protected String cancion;
    protected int precio;

    public Evento(String fecha, String hora, String usuario, String cancion, int precio) {
        this.fecha = fecha;
        this.hora = hora;
        this.usuario = usuario;
        this.cancion = cancion;
        this.precio = precio;
    }

    public Evento() {
        System.out.println("---");
        capturar();
    }

    public void capturar() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Fecha:                   ");
        fecha = leer.nextLine();
        System.out.println("Hora:                    ");
        hora = leer.nextLine();
        System.out.println("Usuario:                 ");
        usuario = leer.nextLine();
        System.out.println("Cancion:                 ");
        cancion = leer.nextLine();
        System.out.println("Precio                   ");
        precio = leer.nextInt();
    }

    public void mostrar() {
        System.out.println("---");
        System.out.println("Fecha:                   " + fecha);
        System.out.println("Hora:                    " + hora);
        System.out.println("Usuario:                 " + usuario);
        System.out.println("Cancion:                 " + cancion);
        System.out.println("Precio                   " + precio);

    }

    //Get & Set
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCancion() {
        return cancion;
    }

    public void setCancion(String cancion) {
        this.cancion = cancion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}



