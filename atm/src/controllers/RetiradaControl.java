package controllers;
import models.Cuenta;
import java.util.Scanner;
import java.util.InputMismatchException;

public class RetiradaControl {
    private Cuenta cuentaUsuario;

    public RetiradaControl(Cuenta cuenta) {
        this.cuentaUsuario = cuenta;
    }

    public void retirada(){
        boolean validacionRetiro = false;
        Scanner scanner = new Scanner(System.in);

        while (!validacionRetiro) {
            try{
                System.out.println("Qué suma de caudales anheláis retirar");
                double retiro = scanner.nextDouble();

                if (retiroValido(retiro)){
                    realizarRetiro(retiro);
                    validacionRetiro = true;
                }else{
                    System.out.println("Vuestros caudales no son suficientes o yacen inaccesibles.");
                }                           

            }catch (InputMismatchException e) {
                System.out.println("Yerraís: Solo se admiten cifras.");
                scanner.nextLine(); 
                }       
        }
    }

    private boolean retiroValido(double retiro){
        return retiro > 0 && retiro <= cuentaUsuario.getSaldo();
    }

    private void realizarRetiro(double retiro) {
        cuentaUsuario.setSaldo(cuentaUsuario.getSaldo() - retiro);
        System.out.println("Retiro de: "+ retiro + " consumado con éxito y buen ventura.");
        System.out.println("Vuestro nuevo haber asciende a:  " + cuentaUsuario.getSaldo());

    }
}
