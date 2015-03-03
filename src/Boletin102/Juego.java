package Boletin102;

import javax.swing.JOptionPane;

/**
 * * @author dpazolopez
 */
public class Juego {

    private int jug2, jug1, num, intentos, contador;
    private boolean perdedor = true;

    public Juego() {
        jug1 = 0;
        jug2 = 0;
        num = 0;
    }

    public int pedirNum() {

        do {
            jug1 = (int) (Math.random() * 50 + 1);
            num = 10;

        } while (num < 1 || num > 50);
        return num;
    }

    public int Intentos() {
        do {
            String valor = JOptionPane.showInputDialog("Inserte numero de intentos");
            intentos = Integer.parseInt(valor);
        } while (intentos <= 0);
        return intentos;
    }

    public void jugar() {
        float resp = this.pedirNum();
        this.Intentos();

        for (contador = 0; contador != num && contador != intentos; contador++) {
            do {
                String respuesta3 = JOptionPane.showInputDialog("Juega tu numero entre 1 y 50:");
                jug2 = Integer.parseInt(respuesta3);
            } while (jug2 < 1 || jug2 > 50);
            if (jug2 == jug1) {
                perdedor = false;
                JOptionPane.showMessageDialog(null, " ENHORABUENA!!!! \n HAS ACERTADO!!");
                break;
            } else {
                int resta = Math.abs(jug1 - jug2);
                if (resta > 20 && num != (contador + 1)) {
                    JOptionPane.showMessageDialog(null, "El número está muy lejos \n Te quedan " + ((intentos - contador) - 1) + " intentos...");
                } else if (resta <= 20 && resta >= 10 && num != (contador + 1)) {
                    JOptionPane.showMessageDialog(null, "El número está lejos \n Te quedan " + ((intentos - contador) - 1) + " intentos...");
                } else if (resta < 10 && resta >= 5 && num != (contador + 1)) {
                    JOptionPane.showMessageDialog(null, "El número está cerca \n Te quedan " + ((intentos - contador) - 1) + " intentos...");
                } else if (resta < 5 && num != (contador + 1)) {
                    JOptionPane.showMessageDialog(null, "El número está muy cerca \n Te quedan " + ((intentos - contador) - 1) + " intentos...");
                }
            }
        }
        if (contador == intentos) {
            JOptionPane.showMessageDialog(null, " Has perdido!!!! \n EL número era el " + jug1 + "\n LASTIMAAAAA...!!!");
        }

    }
}
