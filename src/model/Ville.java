
package model;

public class Ville {

    private int numVille;
    private float longitude;
    private float latitude;
    private Boolean visited;

    public Ville(int numVilleValue, float longitudeValue, float latitudeValue) {
        this.setNumVille(numVilleValue);
        this.setLongitude(longitudeValue);
        this.setLatitude(latitudeValue);
        this.setVisited(false);
    }
    
    public int getNumVille(){return numVille;}
    public void setNumVille(int numVilleValue){ numVille = numVilleValue;}
    
    public float getLongitude(){return longitude;}
    public void setLongitude(float longitudeValue){ longitude = longitudeValue;}
    
    public float getLatitude(){return latitude;}
    public void setLatitude(float latitudeValue){latitude = latitudeValue;}
    
    public Boolean isVisited(){return visited;}
    public void setVisited(Boolean visitedValue){visited=visitedValue;}
    public Boolean ChangeVisited(){if(visited==false){return true;}else{return false;}}
}
