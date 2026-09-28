package entity;


import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    public int worldX, worldY;
    public int speed;
    public BufferedImage standUp, up1, up2, standDown, down1, down2, standLeft, left1, left2, standRight, right1, right2, transform, detransform, diamondheadStandDown, diamondheadStandUp, diamondheadStandLeft, diamondheadStandRight, diamondheadRight1, diamondheadLeft1, diamondheadLeft2, diamondheadRight2;
    public String direction;
    public String alien;
    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Rectangle solidArea;
    public boolean collisionOn = false;
}
