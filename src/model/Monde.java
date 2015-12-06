
package model;

public class Monde {
    
    public Ville[] tabVille;
    private float distanceTotal;
    private int NbVilleTotal;
    private int nbVilleTraitee;
    
    public Monde(int taille){
        tabVille = new Ville[taille];
        NbVilleTotal = taille;
        distanceTotal = 0;
        nbVilleTraitee = 0;
    }
    
    
    
    public int getNbVilleTotal(){return NbVilleTotal;}
    
    public float getDistanceTotal(){return distanceTotal;}
    public void setDistanceTotal(float DTValue){distanceTotal = DTValue;}
    public void addDistanceTotal(float toAdd){distanceTotal =distanceTotal+ toAdd;}
    public void RAZDistanceTotal(){distanceTotal = 0;}
    
    public float getNbVilleTraitees(){return nbVilleTraitee ;}
    public void setNbVilleTraitees(int VTValue){nbVilleTraitee = VTValue;}
    public void addNbVilleTraitees(){ nbVilleTraitee++;}
    public void RAZNbVilleTraitees(){nbVilleTraitee = 0;}
    
}
