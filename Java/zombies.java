package Java;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;

import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;

public class zombies {
    Plantas p;
    double x,y;
    BufferedImage [] imagenes = new BufferedImage[31];
    BufferedImage [] eat = new BufferedImage[31];
    BackgroundSound sonidoeat;

    BufferedImage zoombie=null;
    double velocidad;
    int frame=0;
    zombies(Plantas p,int y){
        this.p=p;
        cargarImagenes();
        this.x=p.screenX-50;
        this.y=p.pixel*y+p.extraArriba;
        velocidad=1;
        sonidoeat=new BackgroundSound("/Java/resources/zombie_eat.wav");
    }

    public void draw(Graphics2D g2){
        g2.drawImage(zoombie,(int)x,(int)y,p.pixel,p.pixel,p);
    }

    public void fisica(){
       
        if(!colision()){
            x-=velocidad;
            sonidoeat.stop();
        }
        if(!colision()){
        switch(frame){
            case 0: zoombie=imagenes[0]; break;
            case 1: zoombie=imagenes[1]; break;
            case 2: zoombie=imagenes[2]; break;
            case 3: zoombie=imagenes[3]; break;
            case 4: zoombie=imagenes[4]; break;
            case 5: zoombie=imagenes[5]; break;
            case 6: zoombie=imagenes[6]; break;
            case 7: zoombie=imagenes[7]; break;
            case 8: zoombie=imagenes[8]; break;
            case 9: zoombie=imagenes[9]; break;
            case 10: zoombie=imagenes[10]; break;
            case 11: zoombie=imagenes[11]; break;
            case 12: zoombie=imagenes[12]; break;
            case 13: zoombie=imagenes[13]; break;
            case 14: zoombie=imagenes[14]; break;
            case 15: zoombie=imagenes[15]; break;
            case 16: zoombie=imagenes[16]; break;
            case 17: zoombie=imagenes[17]; break;
            case 18: zoombie=imagenes[18]; break;
            case 19: zoombie=imagenes[19]; break;
            case 20: zoombie=imagenes[20]; break;
            case 21: zoombie=imagenes[21]; break;
            case 22: zoombie=imagenes[22]; break;
            case 23: zoombie=imagenes[23]; break;
            case 24: zoombie=imagenes[24]; break;
            case 25: zoombie=imagenes[25]; break;
            case 26: zoombie=imagenes[26]; break;
            case 27: zoombie=imagenes[27]; break;
            case 28: zoombie=imagenes[28]; break;
            case 29: zoombie=imagenes[29]; break;
            case 30: zoombie=imagenes[30]; break;
            default: frame=0;
        }
    }else{
        switch(frame){
            case 0: zoombie=eat[0]; break;
            case 1: zoombie=eat[1]; break;
            case 2: zoombie=eat[2]; break;
            case 3: zoombie=eat[3]; break;
            case 4: zoombie=eat[4]; break;
            case 5: zoombie=eat[5]; break;
            case 6: zoombie=eat[6]; break;
            case 7: zoombie=eat[7]; break;
            case 8: zoombie=eat[8]; break;
            case 9: zoombie=eat[9]; break;
            case 10: zoombie=eat[10]; break;
            case 11: zoombie=eat[11]; break;
            case 12: zoombie=eat[12]; break;
            case 13: zoombie=eat[13]; break;
            case 14: zoombie=eat[14]; break;
            case 15: zoombie=eat[15]; break;
            case 16: zoombie=eat[16]; break;
            case 17: zoombie=eat[17]; break;
            case 18: zoombie=eat[18]; break;
            case 19: zoombie=eat[19]; break;
            case 20: zoombie=eat[20]; break;
            default: frame=0;
        }
    }

        frame++;
    }

    public boolean colision(){
        for (int i = 0; i < p.matriz.length; i++) {
            for (int j = 0; j < p.matriz[i].length; j++) {
                if (p.matriz[i][j] != 0) {
                    if((x-velocidad>=p.extraxIzq+(j*p.pixel))&&(x-velocidad<=p.extraxIzq+(j*p.pixel)+p.pixel/2)){
                        if((y>=p.extraArriba + (i * p.pixel))&&(y<=p.extraArriba + (i * p.pixel))){
                            sonidoeat.clip.loop(Clip.LOOP_CONTINUOUSLY);
                            return true;
                        } 
                    }
                }
            }
        }
        return false;
    }

    public void cargarImagenes(){
        try {
            imagenes[0]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie/frame_00.png"));
            imagenes[1]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie/frame_01.png"));
            imagenes[2]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie/frame_02.png"));
            imagenes[3]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie/frame_03.png"));
            imagenes[4]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie/frame_04.png"));
            imagenes[5]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie/frame_05.png"));
            imagenes[6]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie/frame_06.png"));
            imagenes[7]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie/frame_07.png"));
            imagenes[8]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie/frame_08.png"));
            imagenes[9]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie/frame_09.png"));
            imagenes[10]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie/frame_10.png"));
            imagenes[11]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie/frame_11.png"));
            imagenes[12]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie/frame_12.png"));
            imagenes[13]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie/frame_13.png"));
            imagenes[14]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie/frame_14.png"));
            imagenes[15]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie/frame_15.png"));
            imagenes[16]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie/frame_16.png"));
            imagenes[17]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie/frame_17.png"));
            imagenes[18]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie/frame_18.png"));
            imagenes[19]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie/frame_19.png"));
            imagenes[20]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie/frame_20.png"));
            imagenes[21]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie/frame_21.png"));
            imagenes[22]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie/frame_22.png"));
            imagenes[23]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie/frame_23.png"));
            imagenes[24]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie/frame_24.png"));
            imagenes[25]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie/frame_25.png"));
            imagenes[26]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie/frame_26.png"));
            imagenes[27]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie/frame_27.png"));
            imagenes[28]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie/frame_28.png"));
            imagenes[29]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie/frame_29.png"));
            imagenes[30]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie/frame_30.png"));
            
            eat[0]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie_eat/frame_00.png"));
            eat[1]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie_eat/frame_01.png"));
            eat[2]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie_eat/frame_02.png"));
            eat[3]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie_eat/frame_03.png"));
            eat[4]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie_eat/frame_04.png"));
            eat[5]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie_eat/frame_05.png"));
            eat[6]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie_eat/frame_06.png"));
            eat[7]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie_eat/frame_07.png"));
            eat[8]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie_eat/frame_08.png"));
            eat[9]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie_eat/frame_09.png"));
            eat[10]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie_eat/frame_10.png"));
            eat[11]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie_eat/frame_11.png"));
            eat[12]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie_eat/frame_12.png"));
            eat[13]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie_eat/frame_13.png"));
            eat[14]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie_eat/frame_14.png"));
            eat[15]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie_eat/frame_15.png"));
            eat[16]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie_eat/frame_16.png"));
            eat[17]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie_eat/frame_17.png"));
            eat[18]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie_eat/frame_18.png"));
            eat[19]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie_eat/frame_19.png"));
            eat[20]=ImageIO.read(getClass().getResourceAsStream("/Java/imagenes/plain_zombie_eat/frame_20.png"));
        
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
