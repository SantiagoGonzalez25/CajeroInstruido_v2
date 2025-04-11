package controllers;

import models.Cuenta;
import java.util.Scanner;
import java.util.InputMismatchException;

public class DepositarControl {
    private Cuenta cuentaUsuario;

    //Método constructor
    public DepositarControl(Cuenta cuenta) {
        this.cuentaUsuario = cuenta;
    }

    public void realizarDeposito() {
        boolean validacionDeposito = false;
        Scanner scanner = new Scanner(System.in);// Por qué cuando cierro el Scanner el código no corre?
        while (!validacionDeposito) {
            try {
                System.out.println("Cuál suma deseáis consignar a la cuenta?");
                double deposito = scanner.nextDouble();
                if (depositoValido(deposito)) {
                    realizarDeposito(deposito);
                    validacionDeposito = true;
                } else if (deposito > 1000000) {
                    System.out.println("La suma a depositar no puede exceder 1,000,000.");
                }else{
                    System.out.println("La suma a depositar debe ser mayor que cero.");
                }
            } catch (InputMismatchException e) {
                System.out.println("¡Desatino! Solo guarismos son admitidos en esta lid");
                scanner.nextLine(); 
            }
        }
    }

    private boolean depositoValido(double deposito) {
        return deposito > 0 && deposito <= 1000000; // Limitar el depósito a un máximo de 1,000,000
    }

    private void realizarDeposito(double deposito){
        cuentaUsuario.setSaldo(cuentaUsuario.getSaldo() + deposito);
        System.out.println("Vuestro nuevo haber asciende a " + cuentaUsuario.getSaldo());
    }


}
