package Java;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Nuez {
    int x,y;
    BufferedImage [] imagenes= new BufferedImage[16];
    BufferedImage nuez=null;
    Plantas p;
    int frame;
    int contador=0;
    int contador2=0;

    Nuez(Plantas p,int x,int y){
        this.p=p;
        this.x=p.extraxIzq+(x*p.pixel);
        this.y=p.extraArriba+(y*p.pixel);
        cargarImagenes();
    }

    public void cargarImagenes(){
        try{
            imagenes[0]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/wallnut/frame_00.png"));
            imagenes[1]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/wallnut/frame_01.png"));
            imagenes[2]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/wallnut/frame_02.png"));
            imagenes[3]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/wallnut/frame_03.png"));
            imagenes[4]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/wallnut/frame_04.png"));
            imagenes[5]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/wallnut/frame_05.png"));
            imagenes[6]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/wallnut/frame_06.png"));
            imagenes[7]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/wallnut/frame_07.png"));
            imagenes[8]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/wallnut/frame_08.png"));
            imagenes[9]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/wallnut/frame_09.png"));
            imagenes[10]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/wallnut/frame_10.png"));
            imagenes[11]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/wallnut/frame_11.png"));
            imagenes[12]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/wallnut/frame_12.png"));
            imagenes[13]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/wallnut/frame_13.png"));
            imagenes[14]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/wallnut/frame_14.png"));
            imagenes[15]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/wallnut/frame_15.png"));
        }catch(IOException e){
            System.out.println("Error al cargar imagenes de nuez/n"+e.getMessage());
        }
    }

    public void draw(Graphics2D g2){
        cambiarFrame();
        g2.drawImage(nuez,x,y,p.pixel,p.pixel,p);
    }

    public void cambiarFrame(){
        switch(frame){
            case 0: nuez=imagenes[0]; break;
            case 1: nuez=imagenes[1]; break;
            case 2: nuez=imagenes[2]; break;
            case 3: nuez=imagenes[3]; break;
            case 4: nuez=imagenes[4]; break;
            case 5: nuez=imagenes[5]; break;
            case 6: nuez=imagenes[6]; break;
            case 7: nuez=imagenes[7]; break;
            case 8: nuez=imagenes[8]; break;
            case 9: nuez=imagenes[9]; break;
            case 10: nuez=imagenes[10]; break;
            case 11: nuez=imagenes[11]; break;
            case 12: nuez=imagenes[12]; break;
            case 13: nuez=imagenes[13]; break;
            case 14: nuez=imagenes[14]; break;
            case 15: nuez=imagenes[15]; break;
            
            default: frame=0;
        }

        contador++;
        if(contador==3){
            frame++;
            contador=0;
        }
    }

    public boolean eliminar(MouseEvent e){

        if(e.getX()>=this.x&&e.getX()<=this.x+p.pixel&&e.getY()>=this.y&&e.getY()<=this.y+p.pixel){
            return true;
          }
      
      return false;
    }
}
