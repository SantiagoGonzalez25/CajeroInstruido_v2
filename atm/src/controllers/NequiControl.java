package controllers;
import models.Cuenta;
import java.util.Scanner;
import java.util.InputMismatchException;

public class NequiControl {

    private Cuenta cuentaUsuario;
    private static final String CODIGO_NEQUI = "123456"; // Código de ejemplo

    public NequiControl(Cuenta cuenta){
        this.cuentaUsuario = cuenta;
    }

    public void nequi(){ // Modificador de acceso público para ser llamado desde el menu
        String numTelefono = validarNumeroNequi();
        double monto = Monto();
        String codigo = validarCodigo();
        realizarRetiroNequi(monto, numTelefono, codigo);
    }

    private String validarNumeroNequi(){
        Scanner scanner = new Scanner(System.in);
        String numTelefono;
        do{
            try{
                System.out.println("Digitad el número de celular (10 dígitos)");
                numTelefono = scanner.nextLine();
                if (numTelefono.length() != 10){
                    System.out.println("¡Ah, desatino! Vuestro número ha de constar de diez guarismos, noble caballero.");
                }
            }catch (InputMismatchException e) {
                System.out.println("¡Desatino! Solo guarismos son admitidos en esta lid.");
                scanner.nextLine(); 
                numTelefono = ""; 
            }
        }while(numTelefono.length()!=10);
        return numTelefono;
    }

    private double Monto(){
        final int MONTO_MAXIMO = 2000000; //definir el monto máximo que entrará en Nequi
        final int MONTO_MINIMO = 10000; // definir el monto mínimo
        double monto;
        Scanner scanner = new Scanner(System.in); 

        do{
            try{
                System.out.println("Digita la suma que esperaís obtener");
                monto = scanner.nextInt();
                if (monto < MONTO_MINIMO){
                    System.out.println("¡Ah, desmesura! La suma mínima es de " + MONTO_MINIMO + " pesos! No puedes poner un monto menor a 10.000 pesos.");
                }else if(monto > MONTO_MAXIMO){
                    System.out.println("¡ah, rayos! La suma máxima es de " + MONTO_MAXIMO + " pesos! no puedes poner un monto mayor a 2.000.000 pesos.");
                }
            }catch (InputMismatchException e) {
                System.out.println("Debéis introducir un guarismo de recta valía, noble caballero");
                scanner.nextLine(); 
                monto = 0;     
            }
        }while (monto < MONTO_MINIMO || monto > MONTO_MAXIMO);

        return monto;
    }
        
    private String validarCodigo(){
        Scanner scanner = new Scanner(System.in);
        String codigo;

        do {
            try {
                System.out.println("Introducid el códice de la ilustre aplicación, noble caballero (123456 es el codigo de ejemplo))");
                codigo = scanner.nextLine();
                if (!codigo.equals(CODIGO_NEQUI)){
                    System.out.println("Yerran vuestros dígitos! El códice no es de buen tino.");
                }else if (codigo.length() != 6){
                    System.out.println("¡Desacierto! El códice ingresado es erróneo, debe tener 6 dígitos.");
                }
                
            } catch (Exception e) {
                System.out.println("¡Desatino! Solo guarismos son admitidos en esta lid.");
                scanner.nextLine();
                codigo = ""; 
            }
        }while(!codigo.equals(CODIGO_NEQUI));

        return codigo;
    }

    private void realizarRetiroNequi(double monto, String numTelefono, String codigo) {
        cuentaUsuario.retirar(monto);
        System.out.println("Retirada de caudales desde el número vinculado a NEQUI "+numTelefono+ "¡La retirada ha sido consumada con éxito y buen ventura!");
        System.out.println("Dinero retirado: "+ monto);
    }
/*
 * Gracias a usted, realmente puedo decir que estoy aprediendo la POO. Muchas gracias.
 */
}