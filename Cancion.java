import java.util.Scanner;

public class Cancion implements Datos, java.io.Serializable {
    private String titulo, artista, duracion, album, ano, bpm;
    private int precio;

    public Cancion(String titulo, String artista, String duracion, String album,
                   String ano, String bpm, int precio) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
        this.album = album;
        this.ano = ano;
        this.bpm = bpm;
        this.precio = precio;
    }

    public Cancion() {
        capturar();
    }

    public void capturar() {
        Scanner leer = new Scanner(System.in);
        System.out.print("Titulo:                   ");
        titulo = leer.nextLine();
        System.out.print("Artista:                  ");
        artista = leer.nextLine();
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
    }

    public void mostrar() {
        System.out.println("---");
        System.out.println("Titulo:                   " + titulo);
        System.out.println("Artista:                  " + artista);
        System.out.println("Duracion:                 " + duracion);
        System.out.println("Album:                    " + album);
        System.out.println("Ano:                      " + ano);
        System.out.println("bpm:                      " + bpm);
        System.out.println("precio:                   " + precio);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getBpm() {
        return bpm;
    }

    public void setBpm(String bpm) {
        this.bpm = bpm;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
