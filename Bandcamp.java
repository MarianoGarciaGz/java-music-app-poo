import java.io.*;
import java.util.Scanner;

public class Bandcamp {

    private int cPersonas, cCancion, cEvento;

    private Persona personas[] = new Persona[100];
    private Cancion canciones[] = new Cancion[100];
    private Evento eventos[] = new Evento[100];

    public Bandcamp() {

        cargarCanciones();
        cargarEventos();
        cargarPersonas();
        /*
        canciones[0] = new Cancion("Moby Dick", "Omar Varela", "2:22", "Moby Dick (Single)", "2020", "150", 30);
        canciones[1] = new Cancion("Fire", "Mykka", "3:41", "Fire (Single)", "2019", "140", 15);
        canciones[2] = new Cancion("Vete", "Bad Bunny", "3:12", "YHLQMDLG", "2020", "80", 50);
        cCancion = 3;
        personas[0] = new Artista("Omar Varela", "Argentina", "omarvarela@gmail.com", "CEO & MUEVA Records");
        personas[1] = new Artista("Mykka", "Argentina", "mykka@gmail.com", "Beatmaker");
        personas[2] = new Artista("Bad Bunny", "Puertoriqueña", "badbunny@gmail.com", "Cantante");
        personas[3] = new Usuario("Kevin", "Mexicana", "kevin@gmail.com", "4431675469");
        personas[4] = new Usuario("Oscar", "Mexicana", "oscar@gmail.com", "4567891324");
        personas[5] = new Usuario("Jorge", "Mexicana", "jorge@gmail.com", "4436789456");
        cPersonas = 6;
        eventos[0] = new Evento("12-07-21","12:00","Kevin","Moby Dick",30);
        cEvento = 1;
        */
    }

    public void evaluaOpcion(int opcion) {
        switch (opcion) {
            case 11:
                agregarArtista();
                break;
            case 12:
                mostrarArtistas();
                break;
            case 21:
                agregarUsuario();
                break;
            case 22:
                mostrarUsuarios();
                break;
            case 31:
                agregarCancion();
                break;
            case 32:
                mostrarCanciones();
                break;
            case 41:
                comprarCancion();
                break;
            case 42:
                mostrarCompras();
                break;
            case 0:
                guardarCanciones();
                guardarPersonas();
                guardarEventos();
                break;
        }
    }

    private void agregarArtista() {
        personas[cPersonas] = new Artista();
        cPersonas++;
        System.out.println("Artista agregado exitosamente!");
    }

    private void mostrarArtistas() {
        for (int i = 0; i < cPersonas; i++) {
            if (personas[i].queSoy().equals("Artista"))
                personas[i].mostrar();
        }
    }

    private void agregarUsuario() {
        personas[cPersonas] = new Usuario();
        cPersonas++;
        System.out.println("Usuario agregado exitosamente!");
    }

    private void mostrarUsuarios() {
        for (int i = 0; i < cPersonas; i++) {
            if (personas[i].queSoy().equals("Usuario"))
                personas[i].mostrar();
        }
    }

    private void agregarCancion() {
        String titulo, artista, duracion, album, ano, bpm;
        int precio;
        Scanner leer = new Scanner(System.in);

        boolean b = true;
        do {
            System.out.print("Artista:                  ");
            artista = leer.nextLine();
            for (int i = 0; i < cPersonas; i++) {
                if (personas[i].getNombre().equals(artista)) {
                    artista = personas[i].getNombre();
                    b = false;
                }
            }
            if (b) {
                System.out.println("Artista incorrecto, ingrese un artista valido.");
            }
            if (!b) {
                System.out.println("Artista encontrado.");
            }
        } while (b);

        System.out.print("Titulo:                   ");
        titulo = leer.nextLine();
        System.out.print("Duracion:                 ");
        duracion = leer.nextLine();
        System.out.print("Album:                    ");
        album = leer.nextLine();
        System.out.print("Ano:                      ");
        ano = leer.nextLine();
        System.out.print("bpm:                      ");
        bpm = leer.nextLine();
        System.out.print("precio:                   ");
        precio = leer.nextInt();
        canciones[cCancion] = new Cancion(titulo, artista, duracion, album, ano, bpm, precio);
        cCancion++;
        System.out.println("Cancion registrada exitosamente!");
    }

    private void mostrarCanciones() {
        for (int i = 0; i < cCancion; i++) {
            canciones[i].mostrar();
        }
    }

    private void comprarCancion() {
        String fecha, hora, usuario, cancion;
        int precio = 0;
        Scanner leer = new Scanner(System.in);
        boolean b = true;
        do {
            System.out.print("Usuario:                  ");
            usuario = leer.nextLine();
            for (int i = 0; i < cPersonas; i++) {
                if (personas[i].getNombre().equals(usuario)) {
                    b = false;
                }
            }
            if (b) {
                System.out.println("Usuario incorrecto, ingrese un usuario valido.");
            }
            if (!b) {
                System.out.println("Usuario encontrado.");
            }
        } while (b);

        b = true;
        do {
            System.out.print("Cancion:                  ");
            cancion = leer.nextLine();
            for (int i = 0; i < cCancion; i++) {
                if (canciones[i].getTitulo().equals(cancion)) {
                    precio = canciones[i].getPrecio();
                    b = false;
                }
            }
            if (b) {
                System.out.println("Cancion no encontrada, ingrese una cancion del repertorio de canciones.");
            }
            if (!b) {
                System.out.println("Cancion encontrada.");
            }
        } while (b);
        System.out.print("Fecha:                    ");
        fecha = leer.nextLine();
        System.out.print("Hora:                     ");
        hora = leer.nextLine();

        eventos[cEvento] = new Evento(fecha, hora, usuario, cancion, precio);
        cEvento++;
        System.out.println("Compra exitosa!");
    }

    private void mostrarCompras() {
        for (int i = 0; i < cEvento; i++) {
            eventos[i].mostrar();
        }
    }

    private void cargarCanciones() {
        FileInputStream fe = null;
        cCancion = 0;
        try {
            fe = new FileInputStream("canciones.dat");
            ObjectInputStream fObj = new ObjectInputStream(fe);
            canciones[cCancion] = (Cancion) fObj.readObject();
            while (canciones[cCancion] != null) {
                cCancion++;
                canciones[cCancion] = (Cancion) fObj.readObject();
            }
            fe.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void guardarCanciones() {
        FileOutputStream fs = null;
        try {
            fs = new FileOutputStream("canciones.dat");
            ObjectOutputStream fObj = new ObjectOutputStream(fs);
            for (int i = 0; i < cCancion; i++)
                fObj.writeObject(canciones[i]);
            fs.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void cargarPersonas() {
        FileInputStream fe2 = null;
        cPersonas = 0;
        try {
            fe2 = new FileInputStream("personas.dat");
            ObjectInputStream fObj = new ObjectInputStream(fe2);
            personas[cPersonas] = (Persona) fObj.readObject();
            while (personas[cPersonas] != null) {
                cPersonas++;
                personas[cPersonas] = (Persona) fObj.readObject();
            }
            fe2.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void guardarPersonas() {
        FileOutputStream fs = null;
        try {
            fs = new FileOutputStream("personas.dat");
            ObjectOutputStream fObj = new ObjectOutputStream(fs);
            for (int i = 0; i < cPersonas; i++)
                fObj.writeObject(personas[i]);
            fs.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void cargarEventos() {
        FileInputStream fe = null;
        cEvento = 0;
        try {
            fe = new FileInputStream("eventos.dat");
            ObjectInputStream fObj = new ObjectInputStream(fe);
            eventos[cEvento] = (Evento) fObj.readObject();
            while (eventos[cEvento] != null) {
                cEvento++;
                eventos[cEvento] = (Evento) fObj.readObject();
            }
            fe.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void guardarEventos() {
        FileOutputStream fs = null;
        try {
            fs = new FileOutputStream("eventos.dat");
            ObjectOutputStream fObj = new ObjectOutputStream(fs);
            for (int i = 0; i < cEvento; i++)
                fObj.writeObject(eventos[i]);
            fs.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
