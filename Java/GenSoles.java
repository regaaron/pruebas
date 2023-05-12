package Java;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class GenSoles extends Thread{
    CopyOnWriteArrayList<Soles> s;
    Plantas p;
    GenSoles(Plantas p){
        this.p=p;
        this.s=p.s;
    }
    @Override
    public void run() {
        while (true) {
           
            try {
                Thread.sleep(15000); // Espera 5 segundos
                System.out.println("soles:" +s.size());
                if(s.size()<10){
                    s.add(new Soles(p));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
  
        }
    }
}