package Java;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

//clase del nivel enbase a un tiempo iremos poniendo zombies en ciertas posiciones
//ya definidas en tiempos definidos
public class Nivel1 extends Thread{
    CopyOnWriteArrayList<zombies>z;//arreglo de zombies
    Plantas p;
    Nivel1(Plantas p){
        this.p=p;//obtenemos la referencia de la clase principal
        this.z=p.z;//igualamos los arreglos 
    }

    //iniciamos el hilo
    @Override
    public void run() {

            try {
                Thread.sleep(10000); // Espera 10 segundos y panta  3 zombies
                z.add(new zombies(p,0));
                z.add(new zombies(p,2));
                z.add(new zombies(p,3));
                Thread.sleep(10000);//espera 10 mas depues del anterior y coloca 3 mas
                z.add(new zombies(p,4));
                z.add(new zombies(p,2));
                z.add(new zombies(p,1));
                Thread.sleep(10000);//espera 10 mas depues del anterior y coloca 3 mas
                z.add(new zombies(p,4));
                z.add(new zombies(p,2));
                z.add(new zombies(p,1));
                Thread.sleep(10000);//espera 10 mas depues del anterior y coloca 3 mas
                z.add(new zombies(p,4));
                z.add(new zombies(p,2));
                z.add(new zombies(p,1));
                Thread.sleep(10000);//espera 10 mas depues del anterior y coloca 3 mas
                z.add(new zombies(p,4));
                z.add(new zombies(p,2));
                z.add(new zombies(p,1));
                Thread.sleep(10000);//espera 10 mas depues del anterior y coloca 3 mas
                z.add(new zombies(p,4));
                z.add(new zombies(p,2));
                z.add(new zombies(p,1));
                Thread.sleep(10000);//espera 10 mas depues del anterior y coloca 3 mas
                z.add(new zombies(p,4));
                z.add(new zombies(p,2));
                z.add(new zombies(p,1));
                Thread.sleep(10000);//espera 10 mas depues del anterior y coloca 3 mas
                z.add(new zombies(p,4));
                z.add(new zombies(p,2));
                z.add(new zombies(p,1));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}