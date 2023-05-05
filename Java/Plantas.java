package Java;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.awt.Dimension;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author aaron
 */
public class Plantas extends JComponent implements Runnable {

    final int col = 11;
    final int row = 5;
    final int pixel = 90;
    final int extraxIzq = 240;
    final int extraDer = 100;
    final int extraArriba = 65;
    final int screenX = col * pixel + extraDer + extraxIzq;
    final int screenY = row * pixel + 100;
    final int FPS = 60;
    int puntos = 300;
    int contadorsol = 0;
    int movimiento = 0;
    Thread gameThread;
    BufferedImage back, score, gisante, girasol, nuez, gisante1,
            zoombie, tagGirazol, tagNuez, tagGisante, tagBomba,
            zoombie1, zoombie2, zoombie3, pala1, pala2,explosion;
    int spriteCounter = 0;
    Soles[] Soless = new Soles[10];
    Base base;
    boolean tag1, tag2, tag3, tag4, tag5, tag6;
    int spriteNum = 1;
    int posx, posy;
    BackgroundSound soundfondo;
    boolean bpala = false;

    int matriz[][] = {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

    Plantas() {
        System.out.println(screenX);
        System.out.println(screenY);
        setPreferredSize(new Dimension(screenX, screenY));
        cargarImagenes();
        base = new Base(this);
        soundfondo = new BackgroundSound("/Java/resources/fondoz.wav");
        soundfondo.clip.loop(Clip.LOOP_CONTINUOUSLY);
        // logica de teclado
        addKeyListener(new KeyAdapter() {

            // si se preciona una tecla envia verdadero y el codigo de la
            public void keyPressed(KeyEvent e) {
                actualiza(e.getKeyCode(), true);
            }

            // Si se preciona una tecla envia falso asi dejara de hacer el movimiento
            public void keyReleased(KeyEvent e) {
                actualiza(e.getKeyCode(), false);
            }

            // en caso de que la tecla se este precionando pasa true y el codigo de teclado
            private void actualiza(int keyCode, boolean pressed) {

                switch (keyCode) {
                    case KeyEvent.VK_UP: // caso aariba

                        break;
                    case KeyEvent.VK_DOWN: // caso abajo

                        break;
                    case KeyEvent.VK_LEFT: // caso W
                        movimiento += 4;
                        break;
                    case KeyEvent.VK_RIGHT: // caso S
                        movimiento -= 4;
                        break;
                }
            }

        });

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseClicked(MouseEvent evento) {
                try {
                    for (int i = 0; i < 10; i++) {
                        if (Soless[i] != null) {
                            if (Soless[i].mouseClicked(evento)) {
                                Soless[i] = null;
                            }
                        }
                    }
                } catch (Throwable e) {
                    // TODO Auto-generated catch block
                    System.out.println("Error click " + e.toString());
                }

                if (evento.getX() > 59 && evento.getX() < 133 && evento.getY() > 25 && evento.getY() < 87) {
                    if (tag1 == false && puntos >= 50) {
                        if (tags()) {
                            tag1 = true;
                        }

                    } else {
                        tag1 = false;
                    }
                    bpala = false;
                }
                if (evento.getX() > 59 && evento.getX() < 133 && evento.getY() > 116 && evento.getY() < 175) {
                    if (tag2 == false && puntos >= 60) {
                        if (tags()) {
                            tag2 = true;
                        }
                    } else {
                        tag2 = false;
                    }
                    bpala = false;
                }
                if (evento.getX() > 59 && evento.getX() < 133 && evento.getY() > 203 && evento.getY() < 267) {
                    if (tag3 == false && puntos >= 70) {
                        if (tags()) {
                            tag3 = true;
                        }
                    } else {
                        tag3 = false;
                    }
                    bpala = false;
                }
                if (evento.getX() > 59 && evento.getX() < 133 && evento.getY() > 295 && evento.getY() < 359) {
                    if (tag4 == false && puntos >= 80) {
                        if (tags()) {
                            tag4 = true;
                        }
                    } else {
                        tag4 = false;
                    }
                    bpala = false;
                }
                if (evento.getX() > 59 && evento.getX() < 133 && evento.getY() > 387 && evento.getY() < 448) {
                    if (tag5 == false && puntos >= 90) {
                        if (tags()) {
                            tag5 = true;
                        }
                    } else {
                        tag5 = false;
                    }
                    bpala = false;
                }
                if (evento.getX() > 59 && evento.getX() < 133 && evento.getY() > 472 && evento.getY() < 540) {
                    if (tag6 == false && puntos >= 100) {
                        if (tags()) {
                            tag6 = true;
                        }
                    } else {
                        tag6 = false;
                    }
                    bpala = false;
                }

                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (evento.getX() > 244 + (i * pixel) && evento.getX() < 325 + (i * pixel)
                                && evento.getY() > 67 + (j * pixel) && evento.getY() < 150 + (j * pixel)) {

                            ColocarMAtriz(i, j);
                            if (bpala) {
                                matriz[j][i] = 0;
                            }
                        }
                    }
                }

                if (evento.getX() > 392 && evento.getX() < 453 && evento.getY() > 19 && evento.getY() < 61) {
                    if (bpala) {
                        bpala = false;
                    } else {
                        bpala = true;
                        tag1=tag2=tag3=tag4=tag5=tag6=false;
                    }
                }
            }

        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            public void mouseMoved(MouseEvent evento) {

                System.out.println("x: " + evento.getX());
                System.out.println("y: " + evento.getY());
                posx=evento.getX();
                posy=evento.getY();

                if (!tags()) {
                    posx = evento.getX();
                    posy = evento.getY();
                }

                if (bpala) {
                    posx = evento.getX();
                    posy = evento.getY();
                }

            }
        });

        setFocusable(true);

    }

    public void ColocarMAtriz(int i, int j) {
        if (matriz[j][i] == 0) {

            if (tag1) {

                matriz[j][i] = 1;
                tag1 = false;
                puntos -= 50;
            }
            if (tag2) {
                matriz[j][i] = 3;
                tag2 = false;
                puntos -= 100;
            }
            if (tag3) {
                matriz[j][i] = 2;
                tag3 = false;
                puntos -= 50;
            }
            if (tag4) {
                matriz[j][i] = 4;
                tag4 = false;
                puntos -= 70;
            }
            if (tag5) {
                matriz[j][i] = 2;
                tag5 = false;
                puntos -= 40;
            }
            if (tag6) {
                matriz[j][i] = 4;
                tag6 = false;
                puntos -= 50;
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        base.draw(g2);
        spriteCounter++;
        if (spriteCounter > 20) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 3;
            } else {
                if (spriteNum == 3) {
                    spriteNum = 1;
                }
            }
            spriteCounter = 0;
            movimiento++;
        }

        contadorsol++;

        if (contadorsol > 300) {
            for (int i = 0; i < 10; i++) {
                if (Soless[i] == null) {
                    Soless[i] = new Soles(this);
                    break;
                }
            }

            contadorsol = 0;

        }

        for (int i = 0; i < 10; i++) {
            if (Soless[i] != null) {
                Soless[i].draw(g2);
            }
        }

    }
    
    public static void main(String[] args) {
        JFrame jf = new JFrame("Juego");
        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        // jf.setLocationRelativeTo(null);
        // jf.setResizable(false);
        Menu menu = new Menu(jf);
        // Plantas demo1 = new Plantas();
        jf.getContentPane().add(menu);

        // jf.getContentPane().add(demo1);
        jf.pack();
        jf.setVisible(true);
        // demo1.cicloPrincipalJuego();

    }

    public boolean tags() {
        return (!tag1 && !tag2 && !tag3 && !tag4 && !tag5 && !tag6);
    }

    public void cicloPrincipalJuego() {

        gameThread = new Thread(this);
        gameThread.start();

    }

    private void cargarImagenes() {
        try {
            back = ImageIO.read(getClass().getResourceAsStream("/Java/resources/background.png"));
            score = ImageIO.read(getClass().getResourceAsStream("/Java/resources/score.png"));
            gisante = ImageIO.read(getClass().getResourceAsStream("/Java/resources/gisante.png"));
            girasol = ImageIO.read(getClass().getResourceAsStream("/Java/resources/girasol.png"));
            nuez = ImageIO.read(getClass().getResourceAsStream("/Java/resources/nuez1.png"));
            gisante1 = ImageIO.read(getClass().getResourceAsStream("/Java/resources/gisante1.png"));
            tagGirazol = ImageIO.read(getClass().getResourceAsStream("/Java/resources/tagGirazol.png"));
            tagGisante = ImageIO.read(getClass().getResourceAsStream("/Java/resources/tagGisante.png"));
            tagNuez = ImageIO.read(getClass().getResourceAsStream("/Java/resources/tagNuez.png"));
            tagBomba = ImageIO.read(getClass().getResourceAsStream("/Java/resources/tagBomba.png"));
            zoombie1 = ImageIO.read(getClass().getResourceAsStream("/Java/resources/zoombie1.png"));
            zoombie2 = ImageIO.read(getClass().getResourceAsStream("/Java/resources/zoombie2.png"));
            zoombie3 = ImageIO.read(getClass().getResourceAsStream("/Java/resources/zoombie3.png"));
            pala1 = ImageIO.read(getClass().getResourceAsStream("/Java/resources/pala.png"));
            pala2 = ImageIO.read(getClass().getResourceAsStream("/Java/resources/pala2.png"));
            explosion=ImageIO.read(getClass().getResourceAsStream("/Java/resources/explosion.png"));
        } catch (IOException ex) {
            Logger.getLogger(Plantas.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getLocalizedMessage());
        }
    }

    @Override
    public void run() {
        double drawIterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawIterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if (delta >= 1) {

                repaint();
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000) {
                // System.out.println("FPS: "+drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

}
