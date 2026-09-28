package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Player extends  Entity{

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenSizeWidth/2 - gp.tileSize/2;
        screenY = gp.screenSizeHeight/2 - gp.tileSize/2;

        solidArea = new Rectangle(8,16,32,32);

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){

        worldX = gp.tileSize * 24;
        worldY = gp.tileSize * 24;
        speed = 4;
        eva = "detransform";
        direction = "standDown";
    }

    public void getPlayerImage(){

        try {

            down1 = ImageIO.read(new File("res/player/ben10/ben10_move_down_01.png"));
            down2 = ImageIO.read(new File("res/player/ben10/ben10_move_down_02.png"));
            up1 = ImageIO.read(new File("res/player/ben10/ben10_move_up_01.png"));
            up2 = ImageIO.read(new File("res/player/ben10/ben10_move_up_02.png"));
            left1 = ImageIO.read(new File("res/player/ben10/ben10_move_left_01.png"));
            left2 = ImageIO.read(new File("res/player/ben10/ben10_move_left_02.png"));
            right1 = ImageIO.read(new File("res/player/ben10/ben10_move_right_01.png"));
            right2 = ImageIO.read(new File("res/player/ben10/ben10_move_right_02.png"));
            standLeft = ImageIO.read(new File("res/player/ben10/ben10_stand_left_01.png"));
            standRight = ImageIO.read(new File("res/player/ben10/ben10_stand_right_01.png"));
            standUp = ImageIO.read(new File("res/player/ben10/ben10_stand_up_01.png"));
            standDown = ImageIO.read(new File("res/player/ben10/ben10_stand_down_01.png"));

            diamondheadStandDown = ImageIO.read(new File("res/player/ben10/aliens/diamondhead/diamondhead_stand_down_01.png"));
            diamondheadStandUp = ImageIO.read(new File("res/player/ben10/aliens/diamondhead/diamondhead_stand_up_01.png"));
            diamondheadStandRight = ImageIO.read(new File("res/player/ben10/aliens/diamondhead/diamondhead_stand_right_01.png"));
            diamondheadStandLeft = ImageIO.read(new File("res/player/ben10/aliens/diamondhead/diamondhead_stand_left_01.png"));
            diamondheadLeft1 = ImageIO.read(new File("res/player/ben10/aliens/diamondhead/diamondhead_move_left_01.png"));
            diamondheadLeft2 = ImageIO.read(new File("res/player/ben10/aliens/diamondhead/diamondhead_move_left_02.png"));
            diamondheadRight1 = ImageIO.read(new File("res/player/ben10/aliens/diamondhead/diamondhead_move_right_01.png"));
            diamondheadRight2 = ImageIO.read(new File("res/player/ben10/aliens/diamondhead/diamondhead_move_right_02.png"));


        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void update(){


        if (keyH.gTyped == true) {
            eva = "transform";

            if (keyH.upPressed == true || keyH.downPressed == true ||
                    keyH.leftPressed == true || keyH.rightPressed == true) {

            if (keyH.downPressed == true) {
                direction = "down";
                worldY += speed;
            }
            if (keyH.upPressed == true) {
                direction = "up";
                worldY -= speed;
            }
            if (keyH.leftPressed == true) {
                direction = "left";
                worldX -= speed;
            }
            if (keyH.rightPressed == true) {
                direction = "right";
                worldX += speed;

            }
                spriteCounter++;
                if (spriteCounter > 11) {
                    if (spriteNum == 1) {
                        spriteNum = 2;
                    } else if (spriteNum == 2) {
                        spriteNum = 3;
                    } else if (spriteNum == 3 ) {
                        spriteNum = 4;
                    } else if (spriteNum == 4) {
                        spriteNum = 1;
                    }

                    spriteCounter = 0;
                }
        }
            if(keyH.upPressed == false && keyH.downPressed == false &&
                    keyH.leftPressed == false && keyH.rightPressed == false){
                if (direction == "down"){
                    direction = "standDown";
                }
                if (direction == "up"){
                    direction = "standUp";
                }
                if (direction == "right"){
                    direction = "standRight";
                }
                if (direction == "left"){
                    direction = "standLeft";
                }

            }

        }

                if (keyH.gTyped == false) {
                    eva = "detransform";
                    if (keyH.upPressed == true || keyH.downPressed == true ||
                            keyH.leftPressed == true || keyH.rightPressed == true) {
                        if (keyH.downPressed == true && keyH.upPressed == false) {
                            direction = "down";
                            worldY += speed;
                        }
                        if (keyH.upPressed == true && keyH.downPressed == false) {
                            direction = "up";
                            worldY -= speed;
                        }
                        if (keyH.leftPressed == true && keyH.rightPressed == false) {
                            direction = "left";
                            worldX -= speed;
                        }
                        if (keyH.rightPressed == true && keyH.leftPressed == false) {
                            direction = "right";
                            worldX += speed;
                        }
                        collisionOn = false;
                        gp.cChecker.checkTile(this);

                        spriteCounter++;
                        if (spriteCounter > 11) {
                            if (spriteNum == 1) {
                                spriteNum = 2;
                            } else if (spriteNum == 2) {
                                spriteNum = 3;
                            } else if (spriteNum == 3 ) {
                                spriteNum = 4;
                            } else if (spriteNum == 4) {
                                spriteNum = 1;
                            }

                            spriteCounter = 0;
                        }
                    }



                }

    }
    public void draw(Graphics2D g2){

        BufferedImage image = null;

        switch (eva) {
            case "transform":
                switch (direction){
                    case "standDown":
                        image = diamondheadStandDown; //transform down
                        g2.drawImage(image, screenX-30, screenY-60, gp.tileSize*2, gp.tileSize*2, null);
                        break;
                    case "standUp":
                        image = diamondheadStandUp;
                        g2.drawImage(image, screenX-30, screenY-60, gp.tileSize*2, gp.tileSize*2, null);
                        break;
                    case "standLeft":
                        image = diamondheadStandLeft;
                        g2.drawImage(image, screenX-30, screenY-60, gp.tileSize*2, gp.tileSize*2, null);
                        break;
                    case "standRight":
                        image = diamondheadStandRight;
                        g2.drawImage(image, screenX-30, screenY-60, gp.tileSize*2, gp.tileSize*2, null);
                        break;
                    case "right":
                        if (keyH.leftPressed == false) {
                            if (spriteNum == 1) {
                                image = diamondheadStandRight;
                            }
                            if (spriteNum == 2) {
                                image = diamondheadRight1;
                            }
                            if (spriteNum == 3){
                                image = diamondheadStandRight;
                            }
                            if (spriteNum == 4){
                                image = diamondheadRight2;
                            }
                        } else {
                            image = diamondheadStandRight;
                        }
                        g2.drawImage(image, screenX-30, screenY-60, gp.tileSize*2, gp.tileSize*2, null);
                        break;
                    case "left":
                        if (keyH.rightPressed == false) {
                            if (spriteNum == 1) {
                                image = diamondheadStandLeft;
                            }
                            if (spriteNum == 2) {
                                image = diamondheadLeft1;
                            }
                            if (spriteNum == 3){
                                image = diamondheadStandLeft;
                            }
                            if (spriteNum == 4) {
                                image = diamondheadLeft2;
                            }
                        } else {
                            image = diamondheadStandLeft;
                        }
                        g2.drawImage(image, screenX-30, screenY-60, gp.tileSize*2, gp.tileSize*2, null);
                        break;
                }

                break;
            case "detransform":
                switch (direction) {
                    case "standDown":
                        image = standDown;
                        break;
                    case "standUp":
                        image = standUp;
                        break;
                    case "standLeft":
                        image = standLeft;
                        break;
                    case "standRight":
                        image = standRight;
                        break;
                    case "down":
                        if (keyH.upPressed == false) {
                            if (spriteNum == 1) {
                                image = down1;
                            }
                            if (spriteNum == 2) {
                                image = down2;
                            }
                        } else {
                            image = standDown;
                        }
                        break;
                    case "left":
                        if(keyH.rightPressed == false) {
                            if (spriteNum == 1) {
                                image = standLeft;
                            }
                            if (spriteNum == 2) {
                                image = left1;
                            }
                            if (spriteNum == 3) {
                                image = standLeft;
                            }
                            if (spriteNum == 4) {
                                image = left2;
                            }

                        } else {
                            image = standLeft;
                        }
                        break;
                    case "right":
                        if (keyH.leftPressed == false) {
                            if (spriteNum == 1) {
                                image = standRight;
                            }
                            if (spriteNum == 2) {
                                image = right1;
                            }
                            if (spriteNum == 3) {
                                image = standRight;
                            }
                            if (spriteNum == 4) {
                                image = right2;
                            }
                        } else {
                            image = standRight;
                        }
                        break;
                    case "up":
                        if (keyH.downPressed == false) {
                            if (spriteNum == 1) {
                                image = standUp;
                            }
                            if (spriteNum == 2) {
                                image = up1;
                            }
                            if (spriteNum == 3) {
                                image = standUp;
                            }
                            if (spriteNum == 4) {
                                image = up2;
                            }
                        } else {
                            image = standUp;
                        }
                        break;

                }
                g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                break;
        }



    }
}
