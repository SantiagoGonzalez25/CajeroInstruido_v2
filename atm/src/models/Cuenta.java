package models;

public class Cuenta {
    private String numeroCuenta;
    private double saldo;
    private String pin;
    private int intentosFallidos;
    //Este es un método constructor
    public Cuenta(String numeroCuenta, double saldo, String pin, int intentosFallidos) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.pin = pin;
        this.intentosFallidos = intentosFallidos;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public int getIntentosFallidos() {
        return intentosFallidos;
    }

    public void setIntentosFallidos(int intentosFallidos) {
        this.intentosFallidos = intentosFallidos;
    } 

    public void retirar(double monto){
        if (monto > 0 && monto <= this.saldo) {
            this.saldo -= monto;
        }
    }

    public void depositar(double monto){
        if (monto > 0) {
            this.saldo += monto;
        }
    }
}
