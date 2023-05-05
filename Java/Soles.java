package Java;
import java.awt.Graphics2D;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Soles {
   int solx;
   int soly,solyfinal;
    BufferedImage img;
    Plantas p;
    BackgroundSound sound= new BackgroundSound("/Java/resources/bien.wav");
    Soles(Plantas p){
        Random random = new Random();
      
        solx = random.nextInt(p.screenX-150) + 150;
        solyfinal = random.nextInt(p.screenY-100) + 40;
        soly=10;
        this.p=p;
        cargarImagen();
       
    }

    public void cargarImagen(){
        try {
            img = ImageIO.read(getClass().getResourceAsStream("/Java/resources/score.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean mouseClicked(MouseEvent evento) throws Throwable {
            if(evento.getX()>solx&&evento.getX()<solx+p.pixel
                &&evento.getY()>soly&&evento.getY()<soly+p.pixel){
                    p.puntos+=25;   
                    sound.clip.start();      
                    return true;
                   
                }else{
                    return false;
                }
    }

    public void draw(Graphics2D g2){
        if(soly<solyfinal){
            g2.drawImage(img, solx,soly,p.pixel,p.pixel,null);
            soly+=1.5;
        }else{
            g2.drawImage(img, solx, soly, p.pixel,p.pixel,null);
        }
    }
    

}
