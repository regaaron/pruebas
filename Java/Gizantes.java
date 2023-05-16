package Java;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.imageio.ImageIO;
import javax.swing.text.StyledEditorKit.BoldAction;

public class Gizantes {
    int x,y;
    BufferedImage [] imagenes = new BufferedImage[13];
    BufferedImage gisantes=null;
    Plantas p;
    int frame;
    int contador=0;
    int contador2=0;
    int vida=100;
    int contador3=0;
    CopyOnWriteArrayList<Balas> balas=new CopyOnWriteArrayList<>();
    Gizantes(Plantas p,int x,int y){
        this.p=p;
        this.x=p.extraxIzq+(x*p.pixel);
        this.y=p.extraArriba+(y*p.pixel);
        this.balas=p.balas;
        cargarImagenes();
    }

    public void generarBala(){
        for(zombies zz:p.z){
            if(zz.y>=this.y&&zz.y<=this.y+p.pixel&&zz.x<p.extraxIzq+(p.pixel*8)){
                contador2++;
            if(contador2==30*5){//30 frames y 10 son los segundos 
                balas.add(new Balas(p, this.x, this.y));
                System.out.println("bala");
                System.out.println(balas.size());
                contador2=0;
            }
            }
            
        }
        
    }

    public void cargarImagenes(){
        try {
            imagenes[0]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/peashooter/frame_00.png"));
            imagenes[1]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/peashooter/frame_01.png"));
            imagenes[2]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/peashooter/frame_02.png"));
            imagenes[3]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/peashooter/frame_03.png"));
            imagenes[4]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/peashooter/frame_04.png"));
            imagenes[5]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/peashooter/frame_05.png"));
            imagenes[6]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/peashooter/frame_06.png"));
            imagenes[7]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/peashooter/frame_07.png"));
            imagenes[8]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/peashooter/frame_08.png"));
            imagenes[9]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/peashooter/frame_09.png"));
            imagenes[10]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/peashooter/frame_10.png"));
            imagenes[11]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/peashooter/frame_11.png"));
            imagenes[12]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/peashooter/frame_12.png"));
           
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }

    public void draw(Graphics2D g2){
        cambiarFrame();
        generarBala();
        colision();
        g2.drawImage(gisantes, x,y,p.pixel,p.pixel,p);
        g2.drawString(vida+"", x-20, y-20);
    }

    public void colision(){

        for(zombies zz:p.z){
            if((this.x)+p.pixel>=zz.x&&(this.x)+p.pixel<=zz.x+p.pixel&&this.y>=zz.y&&this.y<=zz.y+p.pixel){
                contador3++;
                if(contador3==30*2.5){//30 frames y 10 son los segundos 
                    vida-=50;
                    contador3=0;
                }
                
            }
            
        }
    }

    

    public void cambiarFrame(){
        switch(frame){
            case 0: gisantes=imagenes[0]; break;
            case 1: gisantes=imagenes[1]; break;
            case 2: gisantes=imagenes[2]; break;
            case 3: gisantes=imagenes[3]; break;
            case 4: gisantes=imagenes[4]; break;
            case 5: gisantes=imagenes[5]; break;
            case 6: gisantes=imagenes[6]; break;
            case 7: gisantes=imagenes[7]; break;
            case 8: gisantes=imagenes[8]; break;
            case 9: gisantes=imagenes[9]; break;
            case 10: gisantes=imagenes[10]; break;
            case 11: gisantes=imagenes[11]; break;
            case 12: gisantes=imagenes[12]; break;
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
