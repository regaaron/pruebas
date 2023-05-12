package Java;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Nivel1 extends Thread{
    CopyOnWriteArrayList<Soles> s;
    CopyOnWriteArrayList<zombies>z;
    Plantas p;
    Nivel1(Plantas p){
        this.p=p;
        this.s=p.s;
        this.z=p.z;
    }
    @Override
    public void run() {

            try {
                Thread.sleep(10000); // Espera 5 segundos
                z.add(new zombies(p,0));
                z.add(new zombies(p,2));
                z.add(new zombies(p,3));
                Thread.sleep(10000);
                z.add(new zombies(p,4));
                z.add(new zombies(p,2));
                z.add(new zombies(p,1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}