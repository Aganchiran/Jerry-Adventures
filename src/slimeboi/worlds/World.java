/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.worlds;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import slimeboi.Game;
import slimeboi.entities.Entity;
import slimeboi.entities.tiles.Tile;

/**
 *
 * @author Javier Pastor Pérez
 */
public abstract class World {
    private final String music;
    private MediaPlayer bgMusic;
    private final String mapURL;
    protected final int width;
    protected final int height;
    
    protected final int[][] map;
    protected Entity pendingToAdd;
    protected final ArrayList<Entity> entities = new ArrayList();

    
    protected final ArrayList<Tile> tileSet = new ArrayList();
    protected final Game game;
    
    public World(String music, String mapURL, int width, int height, Game game){
        map = new int[width][height];
        this.mapURL = mapURL;
        this.width = width;
        this.height = height;
        this.music = music;
        this.game = game;
        
        //System.out.println();
        
        try {
            Media soundtrack = new Media((new File(music)).toURI().toURL().toString());
            bgMusic = new MediaPlayer(soundtrack);

            bgMusic.setCycleCount(MediaPlayer.INDEFINITE);
            bgMusic.setVolume(0.2);
            bgMusic.play();
        } catch (MalformedURLException ex) {
            System.err.println("No se ha podido cargar la música");
        }
        
    }
    
    public void render(GraphicsContext gc){
        if(pendingToAdd != null){
            entities.add(0, pendingToAdd);
            pendingToAdd = null;
        }
        
        game.getCamera().centerOnEntity(game.jerry);
        for(int i = 0 ; i < width ; i++){
            for(int j = 0 ; j < height ; j++){
                tileSet.get(map[i][j]).render(gc, i * Tile.DEFAULT_WIDTH - game.getCamera().getXPos(), j * Tile.DEFAULT_HEIGHT - game.getCamera().getYPos());
            }
        }
        
        for(int i = entities.size() - 1; i >= 0 ; i--){
            entities.get(i).updateState();
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
    
    public int[][] getMap(){
        return map;
    }
    
    public double getWidthInPixels(){
        return width * Tile.DEFAULT_WIDTH;
    }
    
    public double getHeightInPixels(){
        return height * Tile.DEFAULT_HEIGHT;
    }
    
    public double getWidth(){
        return width;
    }
    
    public double getHeight(){
        return height;
    }
    
    public void killEntity(Entity entity){
        
        entities.remove(entity);
    }
    
    public boolean isAlive(Entity entity){
        return entities.indexOf(entity) != -1;
    }
    
    public void addEntityAtBack(Entity entity){
        entities.add(entity);
    }
    
    public void addEntityAtFront(Entity entity){
        pendingToAdd = entity;
    }
    
    public void killAllEntities(){
        for(int i = entities.size() - 1; i >= 0 ; i--){
            entities.get(i).kill();
        }
    }
    
    public void resetWorld(){
        bgMusic.stop();
        killAllEntities();
        initializeWorld();
        bgMusic.play();
    }
    
    public void apocalypse(){
        bgMusic.stop();
        killAllEntities();
    }
    
    public abstract void initializeWorld();
    
    public ArrayList<Entity> getEntities(){
    
        return entities;
    }
    
}
