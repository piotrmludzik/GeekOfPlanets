import java.awt.*;
import java.awt.geom.Point2D;

public class Tile extends Rectangle {

    public Point2D tilePosition;
    public boolean isDiscovered;
    public boolean isVisible;
    final public String _tileName;

    public Tile(String _tileName){

        this._tileName = _tileName;
        this.isDiscovered = false; // by default, all tiles are not discovered yet.
        this.isVisible = false; // by default, all tiles are not visible yet.
    }
}void reCalculateFOV(int _playerLocX, int _playerLocY){
    allFovPositions.clear();
    allFovTiles.clear();
    // We create the FOV grid to loop through:
    for(int x=0; x <= 7; x++){
        for(int y=0; y <= 7; y++){
            Tile _fovTile = new Tile("FOV" + x + y);
            // We recalculate Tile coordinates based on which FOV-row are they


            Point2D _fovPos = new Point2D.Double((_playerLocX - FOV_RADIUS + x),(_playerLocY+FOV_RADIUS - y));
            _fovTile.tilePosition = _fovPos;

            allFovTiles.add(_fovTile);
            allFovPositions.add(_fovTile.tilePosition);

        }
    }

    checkFOVCollisions(allFovTiles);
}void checkFOVCollisions(List<Tile> _fovTiles){

    // contains method

    for(int i=0; i< listOfWallTiles.size();i++){
        if(allFovPositions.contains(listOfWallTiles.get(i).tilePosition)){
            //System.out.println("FOV match: " + listOfWallTiles.get(i).tilePosition);
            listOfWallTiles.get(i).isDiscovered = true;
            listOfWallTiles.get(i).isVisible = true;
        }
    }
    for(int i=0; i< listOfFloorTiles.size();i++){
        if(allFovPositions.contains(listOfFloorTiles.get(i).tilePosition)){
            //System.out.println("FOV match: " + listOfWallTiles.get(i).tilePosition);
            listOfFloorTiles.get(i).isDiscovered = true;
            listOfFloorTiles.get(i).isVisible = true;
        }
    }
    for(int i=0; i< listOfItemTiles.size();i++){
        if(allFovPositions.contains(listOfItemTiles.get(i).tilePosition)){
            //System.out.println("FOV match: " + listOfWallTiles.get(i).tilePosition);
            listOfItemTiles.get(i).isDiscovered = true;
            listOfItemTiles.get(i).isVisible = true;
        }
    }
    for(int i=0; i< listOfEnemyTiles.size();i++){
        if(allFovPositions.contains(listOfEnemyTiles.get(i).tilePosition)){
            //System.out.println("FOV match: " + listOfWallTiles.get(i).tilePosition);
            listOfEnemyTiles.get(i).isDiscovered = true;
            listOfEnemyTiles.get(i).isVisible = true;
        }
    }
}for(int i = 0; i< listOfFloorTiles.size(); i++){
        int _floorXPos = (int) listOfFloorTiles.get(i).tilePosition.getX();
        int _floorYPos = (int) listOfFloorTiles.get(i).tilePosition.getY();
        if(listOfFloorTiles.get(i).isDiscovered == false) {
        g.setColor(Color.gray);
        g.setFont(new Font("Ink Free", Font.BOLD, 25));
        g.drawString("·", _floorXPos * UNIT_SIZE, _floorYPos * UNIT_SIZE);
        } else {
        g.setColor(Color.black);
        g.setFont(new Font("Ink Free", Font.BOLD, 25));
        g.drawString("·", _floorXPos * UNIT_SIZE, _floorYPos * UNIT_SIZE);
        }
        }for(int i = 0; i< listOfWallTiles.size(); i++){

        int _wallXPos = (int) listOfWallTiles.get(i).tilePosition.getX();
        int _wallYPos = (int) listOfWallTiles.get(i).tilePosition.getY();

        if(listOfWallTiles.get(i).isDiscovered == false){
        g.setColor(Color.gray);
        g.setFont(new Font("Ink Free", Font.BOLD, 25));
        g.drawString("·",_wallXPos * UNIT_SIZE, _wallYPos * UNIT_SIZE );
        } else {
        g.setColor(Color.black);
        g.setFont(new Font("Ink Free", Font.BOLD, 25));
        g.drawString("#",_wallXPos * UNIT_SIZE, _wallYPos * UNIT_SIZE );
        //System.out.println("Set wall at: " + _wallXPos + "|" + _wallYPos);
        }
}for (int i = 0; i < listOfItemTiles.size(); i++){

        int _itemXPos = (int) listOfItemTiles.get(i).tilePosition.getX();
        int _itemYPos = (int) listOfItemTiles.get(i).tilePosition.getY();
        if(listOfItemTiles.get(i).isDiscovered == false) {
        g.setColor(Color.gray);
        g.setFont(new Font("Ink Free", Font.BOLD, 25));
        g.drawString("·", _itemXPos * UNIT_SIZE, _itemYPos * UNIT_SIZE);
        } else {
        g.setColor(Color.yellow);
        g.setFont(new Font("Ink Free", Font.BOLD, 25));
        g.drawString("O", _itemXPos * UNIT_SIZE, _itemYPos * UNIT_SIZE);
        }
}for (int i = 0; i < listOfEnemyTiles.size(); i++){

        int _enemyXPos = (int) listOfEnemyTiles.get(i).tilePosition.getX();
        int _enemyYPos = (int) listOfEnemyTiles.get(i).tilePosition.getY();

        if(listOfEnemyTiles.get(i).isDiscovered == false) {
        g.setColor(Color.gray);
        g.setFont(new Font("Ink Free", Font.BOLD, 25));
        g.drawString("·", _enemyXPos * UNIT_SIZE, _enemyYPos * UNIT_SIZE);
        } else {
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 25));
        g.drawString("E", _enemyXPos * UNIT_SIZE, _enemyYPos * UNIT_SIZE);
        }
}