package nextbus;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin
 */
public class DirectionManager {
    private static DirectionManager controller = null;
    
    public static DirectionManager getInstance () {
        if (controller == null){
            controller = new DirectionManager();
        }
        return controller;
    }
    
    public int getDirection(String direction){
        if (direction.equalsIgnoreCase("south")){
            return 1;
        }else if (direction.equalsIgnoreCase("east")){
            return 2;
        }else if (direction.equalsIgnoreCase("west")){
            return 3;
        } else if (direction.equalsIgnoreCase("north")){
            return 4;
        } else
        return -1;
    }

    private DirectionManager() {

    }
}
