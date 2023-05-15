package Java;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

//esto es una clase con un hilo que genera soles cada cierto tiempo
public class GenSoles extends Thread{
    CopyOnWriteArrayList<Soles> s; //creamos un arreglo de soles
    Plantas p;//objeto de plabtas para tener referecia

    GenSoles(Plantas p){
        this.p=p; //igualamos para la referencia
        this.s=p.s; //enbase a la referencia igualamos el arreglo de soles
                    // de la clase principal
    }

    @Override//corre el hilo
    public void run() {
        //siempre se esta ejecutando
        while (true) {
            try {
                Thread.sleep(5000); // Espera 5 segundos
                
                //imprime cuantos soles se han creado
               
                //genera un sol despues de los 5 segundo solo si hay menos de 10 creados
                if(s.size()<10){
                    s.add(new Soles(p)); //crea el sol y colo soles nesesita referencia
                                        //a la clase pincipal se la pasamos
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
  
        }
    }
}