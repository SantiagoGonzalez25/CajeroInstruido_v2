package views;
import java.util.Scanner;
import controllers.*;
import java.util.InputMismatchException;

public class MenuView {
    private HaberControl haberControl;
    private RetiradaControl retiradaControl;
    private DepositarControl depositarControl;
    private TraspasarControl traspasarControl;
    private NequiControl nequiControl;

    public MenuView(HaberControl haberControl, RetiradaControl retiradaControl, DepositarControl depositarControl, TraspasarControl traspasarControl, NequiControl nequiControl) {
        this.haberControl = haberControl;
        this.retiradaControl = retiradaControl;
        this.depositarControl = depositarControl;
        this.traspasarControl = traspasarControl;
        this.nequiControl = nequiControl;
    }
    public void mostrarMenu(){
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do{
            try{
                System.out.println("¿Qué deseáis hacer?");
                System.out.println("1. Averiguar el haber");
                System.out.println("2. Retirada");
                System.out.println("3. Depositar");
                System.out.println("4. Traspasar");
                System.out.println("5. Retirada en el insigne Nequi");
                System.out.println("6. Emprended el dulce retiro del sistema");

                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        haberControl.averiguarHaber();
                        break;
                    case 2:
                        retiradaControl.retirada();
                        break;
                    case 3:
                        depositarControl.realizarDeposito();
                        break;
                    case 4:
                        traspasarControl.traspasar();
                        break;
                    case 5:
                        nequiControl.nequi();
                        break;
                    case 6:
                        System.out.println("Que los vientos favorables guíen vuestro camino, noble caballero. ¡Hasta otra justa!");
                        break;
                    default:
                        System.out.println("¡Desatino! La elección no es de buen juicio.");
                }
            }catch (InputMismatchException e) {
                System.out.println("¡Desatino! Solo guarismos son admitidos en esta lid.");
                scanner.nextLine();
                opcion = 0; 
            }

        }while (opcion != 6);
    }
    
}

