package org.voluncharity.voluncharity;

public class Globals{
    private static Globals instance;
    private  static int presentPoints;

    private Globals(){}

    public void setPresentPoints(int t){
        Globals.presentPoints = t;
    }

    public int getPresentPoints(){
        return Globals.presentPoints;
    }

    public static synchronized Globals getInstance(){
        if (instance == null){
            instance = new Globals();
        }
        return instance;
    }
}
