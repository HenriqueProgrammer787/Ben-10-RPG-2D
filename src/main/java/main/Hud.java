package main;

import entity.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Hud {

    GamePanel gp;
    BufferedImage life, omnitrixEnergy;

    Player player;



    public Hud(GamePanel gp ) {

        this.gp = gp;

        getHudImage();
    }

    public void getHudImage(){

        try {

            life = ImageIO.read(new File("res/player/eva1.png"));


        }catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void draw(Graphics2D g2){

        BufferedImage image = life;





        g2.drawImage(image, player.screenX, player.screenY, gp.tileSize, gp.tileSize, null);

    }
}
