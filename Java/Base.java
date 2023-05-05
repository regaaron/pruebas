package Java;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Base {
    Plantas p;

    Base(Plantas p) {
        this.p = p;
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, p.screenX, p.screenY);
        g.setColor(Color.red);
        g.drawImage(p.back, 0, 0, p.screenX, p.screenY, p);
        g.drawImage(p.score, p.extraxIzq + 10, 0, p.pixel - 10, p.pixel - 10, p);
        g.setColor(new Color(0xE8B059));
        BufferedImage image = null;
        switch (p.spriteNum) {
            case 1:
                image = p.zoombie1;
                break;
            case 2:
                image = p.zoombie2;
                break;
            case 3:
                image = p.zoombie3;
                break;

        }
        g.drawImage(image, p.screenX - 150 - p.movimiento, p.extraArriba + (2 * p.pixel), p.pixel, p.pixel, p);
        g.drawImage(image, p.screenX - 150 - p.movimiento, p.extraArriba + (3 * p.pixel), p.pixel, p.pixel, p);
        g.drawImage(image, p.screenX - 150 - p.movimiento, p.extraArriba + (4 * p.pixel), p.pixel, p.pixel, p);
        g.drawImage(image, p.screenX - 150 - p.movimiento, p.extraArriba + (1 * p.pixel), p.pixel, p.pixel, p);
        Font fuente = new Font("URW Gothic", Font.PLAIN, 28);
        g.setFont(fuente);
        g.setColor(new Color(0xD9BD89));
        g.fillRect(p.extraxIzq+70, 25, p.pixel-30, p.pixel/3);
        g.setColor(Color.BLACK);
        g.drawRect(p.extraxIzq+70, 25, p.pixel-30, p.pixel/3);
        g.drawString(p.puntos + "", p.extraxIzq + 80, 50);
        g.drawImage(p.pala1,p.extraxIzq+150 , 15,p.pixel-20,p.pixel-40,p);
        if (!p.tag1) {
            g.drawImage(p.tagGirazol, 40, 15, p.pixel + 30, p.pixel, p);
        } else {
            g.drawImage(p.tagGirazol, 40 + 30, 15, p.pixel + 30, p.pixel, p);
            g.drawImage(p.girasol, p.posx - p.pixel / 2, p.posy - p.pixel / 2, p.pixel, p.pixel, p);
        }

        if (!p.tag2) {
            g.drawImage(p.tagNuez, 40, 15 + p.pixel, p.pixel + 30, p.pixel, p);
        } else {
            g.drawImage(p.tagNuez, 40 + 30, 15 + p.pixel, p.pixel + 30, p.pixel, p);
            g.drawImage(p.nuez, p.posx - p.pixel / 2, p.posy - p.pixel / 2, p.pixel, p.pixel, p);

        }

        if (!p.tag3) {
            g.drawImage(p.tagGisante, 40, 15 + p.pixel * 2, p.pixel + 30, p.pixel, p);
        } else {
            g.drawImage(p.tagGisante, 40 + 30, 15 + p.pixel * 2, p.pixel + 30, p.pixel, p);
            g.drawImage(p.gisante1, p.posx - p.pixel / 2, p.posy - p.pixel / 2, p.pixel, p.pixel, p);

        }

        if (!p.tag4) {
            g.drawImage(p.tagBomba, 40, 15 + p.pixel * 3, p.pixel + 30, p.pixel, p);
        } else {
            g.drawImage(p.tagBomba, 40 + 30, 15 + p.pixel * 3, p.pixel + 30, p.pixel, p);
            g.drawImage(p.explosion, p.posx - p.pixel / 2, p.posy - p.pixel / 2, p.pixel, p.pixel, p);

        }

        if (!p.tag5) {
            g.drawImage(p.tagGisante, 40, 15 + p.pixel * 4, p.pixel + 30, p.pixel, p);
        } else {
            g.drawImage(p.tagGisante, 40 + 30, 15 + p.pixel * 4, p.pixel + 30, p.pixel, p);
            g.drawImage(p.gisante1, p.posx - p.pixel / 2, p.posy - p.pixel / 2, p.pixel, p.pixel, p);

        }

        if (!p.tag6) {
            g.drawImage(p.tagBomba, 40, 15 + p.pixel * 5, p.pixel + 30, p.pixel, p);
        } else {
            g.drawImage(p.tagBomba, 40 + 30, 15 + p.pixel * 5, p.pixel + 30, p.pixel, p);
            g.drawImage(p.explosion, p.posx - p.pixel / 2, p.posy - p.pixel / 2, p.pixel, p.pixel, p);

        }
        
       

        for (int i = 0; i < p.matriz.length; i++) {
            for (int j = 0; j < p.matriz[i].length; j++) {
                // g.drawImage(girasol, extraxIzq + (i * pixel), extraArriba + (j * pixel),
                // pixel, pixel, this);
                if (p.matriz[i][j] == 1) {
                    g.drawImage(p.girasol, p.extraxIzq + (j * p.pixel), p.extraArriba + (i * p.pixel), p.pixel, p.pixel, p);
                }
                if (p.matriz[i][j] == 2) {
                    g.drawImage(p.gisante1, p.extraxIzq + (j * p.pixel), p.extraArriba + (i * p.pixel), p.pixel, p.pixel, p);
                }
                if (p.matriz[i][j] == 3) {
                    g.drawImage(p.nuez, p.extraxIzq + (j * p.pixel), p.extraArriba + (i * p.pixel), p.pixel, p.pixel,p);
                }
                if(p.matriz[i][j]==4){
                    g.drawImage(p.explosion, p.extraxIzq + (j * p.pixel), p.extraArriba + (i * p.pixel), p.pixel, p.pixel,p);

                }
            }
        }

        if(p.bpala){
            g.drawImage(p.pala2, p.posx-p.pixel/2, p.posy-p.pixel/2, p.pixel-p.pixel/4,p.pixel-p.pixel/4,p);
        }
        
        for (int i = 0; i <= p.row; i++) {
            g.setColor(Color.red);
            g.drawLine(p.extraxIzq, (i * p.pixel) + p.extraArriba, p.screenX - p.extraDer,(i * p.pixel) + p.extraArriba);

            for (int j = 0; j <= p.col; j++) {
                g.drawLine((j * p.pixel) + p.extraxIzq, p.extraArriba, (j * p.pixel) + p.extraxIzq, p.screenY - 30);
            }

        }
    }
}
