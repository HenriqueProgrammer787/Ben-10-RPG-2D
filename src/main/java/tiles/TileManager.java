package tiles;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

public class TileManager {

    GamePanel gp;
    Tile[] tile;
    int mapTileNum[][];

    public TileManager(GamePanel gp){
        this.gp = gp;

        tile = new Tile[100];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/maps/worldMap01.txt");
    }

    public void getTileImage(){

        try{
            tile[0] = new Tile();
            tile[1] = new Tile();
            tile[2] = new Tile();
            tile[3] = new Tile();
            tile[4] = new Tile();
            tile[5] = new Tile();
            tile[0].image = ImageIO.read(new File("res/tiles/tile_grass_01.png"));
            tile[1].image = ImageIO.read(new File("res/tiles/tile_grass_02.png"));
            tile[2].image = ImageIO.read(new File("res/tiles/tile_gray_brick_01.png"));
            tile[2].collision = true;
            tile[3].image = ImageIO.read(new File("res/tiles/tile_tree_01.png"));
            tile[3].collision = true;
            tile[4].image = ImageIO.read(new File("res/tiles/tile_water_01.png"));
            tile[4].collision = true;
            tile[5].image = ImageIO.read(new File("res/tiles/a.png"));

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(new File("res/tiles/test/1.png"));
            tile[7] = new Tile();
            tile[7].image = ImageIO.read(new File("res/tiles/test/2.png"));
            tile[8] = new Tile();
            tile[8].image = ImageIO.read(new File("res/tiles/test/3.png"));
            tile[9] = new Tile();
            tile[9].image = ImageIO.read(new File("res/tiles/test/4.png"));
            tile[10] = new Tile();
            tile[10].image = ImageIO.read(new File("res/tiles/test/5.png"));
            tile[11] = new Tile();
            tile[11].image = ImageIO.read(new File("res/tiles/test/6.png"));
            tile[12] = new Tile();
            tile[12].image = ImageIO.read(new File("res/tiles/test/7.png"));
            tile[13] = new Tile();
            tile[13].image = ImageIO.read(new File("res/tiles/test/8.png"));
            tile[14] = new Tile();
            tile[14].image = ImageIO.read(new File("res/tiles/test/9.png"));



        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public void loadMap(String filePatch){

        try {
            InputStream is = getClass().getResourceAsStream(filePatch);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.maxWorldCol && row < gp.maxWorldRow){

                String line = br.readLine();

                while(col < gp.maxWorldCol){

                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        }catch (Exception e){

        }
    }

    public void draw(Graphics2D g2){

        int worldCol = 0;
        int worldRow = 0;

        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;


            if (worldX > gp.player.worldX - gp.player.screenX - 70 &&
                worldX < gp.player.worldX + gp.player.screenX + 70 &&
                worldY > gp.player.worldY - gp.player.screenY - 70 &&
                worldY < gp.player.worldY + gp.player.screenY + 70 ) {
                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }
            worldCol++;

            if(worldCol == gp.maxWorldCol){
                worldCol = 0;
                worldRow++;
            }
        }

    }
}
