import java.util.Scanner;

public class Ap {
    public static void main(String[] args) {
        Bandcamp bandcamp = new Bandcamp();
        int opcion;
        System.out.println("Bienvenido a Bandcamp");
        do {
            opcion = menu();
            bandcamp.evaluaOpcion(opcion);
        } while (opcion != 0);
    }

    public static int menu() {
        Scanner leer = new Scanner(System.in);
        int op, op2;
        String principal = "\n\n 1.- Artista     2.- Usuario     3.- Cancion     4.-Compras     0.- Salir";
        String opcion1 = "1.- Agregar     2.- Listar     0.- Cancelar";
        String opcion2 = "1.- Agregar compra     2.- Mostrar compras     0.- Cancelar";

        System.out.println(principal);
        op = leer.nextInt();
        switch (op) {
            case 1:
                System.out.println("\t\t----Menu ARTISTA---- \n" + opcion1);
                break;
            case 2:
                System.out.println("\t\t----Menu USUARIO---- \n" + opcion1);
                break;
            case 3:
                System.out.println("\t\t----Menu CANCION---- \n" + opcion1);
                break;
            case 4:
                System.out.println("\t\t----Menu COMPRAS---- \n" + opcion2);
                break;
            case 0:
                System.out.println("Abandonando Sistema");
                return 0;//salir
            default:
                return -1;  //error
        }
        op2 = leer.nextInt();
        return op * 10 + op2;
    }
}


