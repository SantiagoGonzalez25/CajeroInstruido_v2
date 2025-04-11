package controllers;
import models.Cuenta;

public class HaberControl {
    private Cuenta cuentaUsuario;
    
    public HaberControl(Cuenta cuentaUsuario) {
        this.cuentaUsuario = cuentaUsuario;
    }

    public void averiguarHaber() {
        System.out.println("Vuestro haber es: " + cuentaUsuario.getSaldo());
    }
    
}