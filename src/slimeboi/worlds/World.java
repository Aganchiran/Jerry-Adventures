/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.worlds;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.canvas.GraphicsContext;
import slimeboi.entities.creatures.Creature;
import slimeboi.entities.tiles.Tile;

/**
 *
 * @author Javier Pastor Pérez
 */
public abstract class World {
    private final String music;
    private final String mapURL;
    private final int width;
    private final int height;
    
    public final int[][] map;
    private final ArrayList<Creature> creatures = new ArrayList();
    
    protected final ArrayList<Tile> tileSet = new ArrayList();
    
    public World(String music, String mapURL, int width, int height){
        map = new int[width][height];
        this.mapURL = mapURL;
        this.width = width;
        this.height = height;
        this.music = music;
    }
    
    public void render(GraphicsContext gc){
        for(int i = 0 ; i < width ; i++){
            for(int j = 0 ; j < height ; j++){
                tileSet.get(map[i][j]).render(gc, i * Tile.DEFAULT_WIDTH, j * Tile.DEFAULT_HEIGHT);
            }
        }
    }
    
    public void loadWorld(){
        String file = loadMapAsString();
        String[] tileIDs = file.split("\\s+");
        
        for(int y = 0 ; y < height ; y++){
            for(int x = 0 ; x < width ; x++){
                map[x][y] = Integer.parseInt(tileIDs[(y * width) + x]);
            }
        }
    }
    
    private String loadMapAsString(){
    
        String stringedFile = "";
        
        try {
            Scanner scanner = new Scanner(new File(mapURL));
            
            while(scanner.hasNextLine()){
                stringedFile += scanner.nextLine() + "\n";
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(World.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return stringedFile;
    }
    
    public ArrayList<Tile> getTileset(){
        return tileSet;
    }
}
