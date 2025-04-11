import views.MenuView;
import controllers.*;
import models.*;
import java.util.Scanner;

public class App {  
    public static void main(String[] args) throws Exception {
        Cuenta cuenta = new Cuenta("312215679", 50000.0, "1234", 0);// Tan solo hice una cuenta y usuario de prueba.
        Usuario usuario = new Usuario("Sargento Pimienta", cuenta);

        Scanner scanner = new Scanner(System.in);// Profe, hay una manera de hacer un Scanner de manera global? La única manera que puedo hacer algo similiar es creando una superclase 'Scanner', eso pienso yo.
    
        HaberControl haberControl = new HaberControl(cuenta);
        RetiradaControl retiradaControl = new RetiradaControl(cuenta);
        DepositarControl depositarControl = new DepositarControl(cuenta); 
        TraspasarControl traspasarControl = new TraspasarControl(cuenta);
        NequiControl nequiControl = new NequiControl(cuenta);
        
        boolean pinCorrecto = false;
        int intentos = 0;

        while (intentos < 3 && !pinCorrecto) {
            System.out.println("Introducid la cifra oculta(1234)");
            String PIN = scanner.next();

            if (PIN.equals(cuenta.getPin())){
                pinCorrecto = true;
                System.out.println("Bien hallado en la excelsa SantiLOMBIA, "+ usuario.getNombre());
                MenuView menu = new MenuView(haberControl, retiradaControl, depositarControl, traspasarControl, nequiControl);
                menu.mostrarMenu();
            }else{
                intentos++;
                System.out.println("Clave errada. Ensayos remanentes " + (3 - intentos));
            }
              
        }
        if (!pinCorrecto){ // Esto fue una de las cosas más dificiles de hacer en todo el codigo
            System.out.println("Vuestra cuenta se halla vedada");

        scanner.close();

        }
       
    }
}
