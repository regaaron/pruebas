package Java;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.imageio.ImageIO;

public class Balas {
    int x,y;
    int xfinal;
    BufferedImage bala=null;
    Plantas p;
    BackgroundSound danio=new BackgroundSound("/Java/resources/splat.wav");
    BackgroundSound disparo=new BackgroundSound("/Java/resources/peashooter_attack.wav");
    Balas(Plantas p,int x,int y){
        this.p=p;
        this.x=x+p.pixel;
        this.y=y+p.pixel/4;
        this.xfinal=p.screenX-300;
        try{
            bala=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/bullet/peabullet.png"));
        }catch(IOException e){
            System.out.println("Error al cargar bala\n"+e.getMessage());
        }

        disparo.clip.start();

    }

    public void draw(Graphics2D g2){
            g2.drawImage(bala, x, y, p.pixel/2,p.pixel/2,null);
            if(x<xfinal){
                x+=4.5;
            }
        
    }

    public boolean colision(){
        for(zombies zz:p.z){
            if((this.x+4.5)+p.pixel/4>=zz.x&&(this.x+4.5)+p.pixel/4<=zz.x+p.pixel&&this.y>=zz.y&&this.y<=zz.y+p.pixel){
                danio.clip.start();
                zz.vida-=25;
                return true;
            }
            
        }
        return false;
    }
    
}
