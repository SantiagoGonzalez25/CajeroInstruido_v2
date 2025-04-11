    package controllers;
    import models.Cuenta;
    import java.util.Scanner;
    import java.util.InputMismatchException;

    public class TraspasarControl {
        private Cuenta cuentaUsuario;

        public TraspasarControl(Cuenta cuenta) {
            this.cuentaUsuario = cuenta;
        }

        public void traspasar(){
            double monto = validarMonto();
            String cuentaDestino = validarCuentaDestino();
            realizarTraspaso(monto, cuentaDestino);
        }

        private String validarCuentaDestino(){
            Scanner scanner = new Scanner(System.in);
            String cuentaDestino;
            do{
                System.out.println("Digitad el número de la cuenta destino para el traspaso de caudales. (11 dígitos)");
                cuentaDestino = scanner.nextLine();
                if (cuentaDestino.length() != 11){
                    System.out.println("¡Desatino! La cuenta destino debe tener 11 dígitos.");
                }
            } while (cuentaDestino.length() != 11);
            
            return cuentaDestino;
        }

        private double validarMonto(){
            Scanner scanner = new Scanner(System.in);
            boolean montoTransferencia = false;
            double monto = 0;
            while(!montoTransferencia){
                try{
                    System.out.println("Digitad la suma que aneláis traspasar: ");
                    monto = scanner.nextDouble();
                    if (monto <= 0){
                        System.out.println("¡Desatino! solo guarismos positivos son admitidos");
                    }else if (monto > cuentaUsuario.getSaldo()){
                        System.out.println("¡Desventura! Vuestros cuadales no bastan");
                    }else{
                        montoTransferencia = true;
                    }

                }catch (InputMismatchException e) {
                    System.out.println("Debéis introducir un guarismo legítimo y de buen juicio");
                    scanner.nextLine(); 
                }
            }
            return monto;
        }
        private void realizarTraspaso(double monto, String cuentaDestino) {
            cuentaUsuario.retirar(monto);
            System.out.println("Traspaso consumado con exito y buen ventura");
            System.out.println("Ente de recepción: "+cuentaDestino);
            System.out.println("Caudal remitido: "+monto+ " vuestro haber asciende a " + cuentaUsuario.getSaldo());
        }
    }
