/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo;

import model.Monde;
import model.Ville;

/**
 *
 * @author User
 */
public class AlgoOpti {
    
    public static Monde optimisation(Monde m){
        
        Monde mOrdre=new Monde(m.getNbVilleTotal());
        mOrdre.tabVille=deuxOpt(m);
        return mOrdre;
        
    }
    
    private static Ville[] deuxOpt(Monde m){
        
        int nbVille=m.getNbVilleTotal(),y=0;
        Ville[] tab=m.tabVille;
        Ville[] newOrder=copie(tab);
        
        for(int i=1;i<nbVille;i++){
            for(int j=1;j<nbVille;j++){
                if(i!=j){
                    renversement(newOrder, i, j);
                    if(gain(tab, newOrder, i, j)<0){
                        renversementComplet(newOrder, i, j);
  
                    }
                    else{
                        renversement(newOrder, i, j);
                    }
                }
            }
            
        }
        return newOrder;
        
    }
    
    
    private static Ville[] renversementComplet(Ville[] tab,int indexv1,int indexv2){
        int nbVilleEntre=nbVilleEntre(indexv1, indexv2);
        int nbRenversement=nbVilleEntre/2;
        if(indexv1<indexv2){
            for(int i=1; i<nbRenversement;i++){            
                tab=renversement(tab,indexv1+i,indexv2-i);
            }
        }
        else{
            for(int i=0; i<nbRenversement;i++){       
                tab=renversement(tab,indexv2+i,indexv1-i);
            }
        }
        return tab;
    }
    
    private static int nbVilleEntre(int index1,int index2){
        
        int nbVilleEntre;
        if(index2<index1){
             nbVilleEntre=index1-index2;
        }
        else{
            nbVilleEntre=index2-index1;
        }
        return nbVilleEntre+1;
    }
    
    private static Ville[] renversement(Ville[] tab, int indexv1,int indexv2){
        
        Ville save=tab[indexv1];
        tab[indexv1]=tab[indexv2];
        tab[indexv2]=save;
        return tab;
        
    }
    
    
    
    private static Ville[] copie(Ville[] original){
        int nbVille=original.length;
        Ville[] copie=new Ville[nbVille];
        for(int i=0;i<nbVille;i++){
            copie[i]=original[i];   
        }
        return copie;
    }
    
    
    private static float gain(Ville[] origin,Ville[] newOrder,int indexv1,int indexv2){
        
        float distOrigin1=distance2Ville(origin[indexv1-1],origin[indexv1]);
        float distOrigin2=distance2Ville(origin[indexv2],origin[indexv2+1]);
        float distNewOrder3=distance2Ville(newOrder[indexv1-1],newOrder[indexv1]);
        float distNewOrder4=distance2Ville(newOrder[indexv2],newOrder[indexv2+1]);
        
        return distOrigin1+distOrigin2-distNewOrder3-distNewOrder4;
    }
    
    public static float distance2Ville(Ville v1,Ville v2){
        
        float distance,x,xcarre,y,ycarre;
        x=v2.getLongitude()-v1.getLongitude();
        xcarre=x*x;
        y=v2.getLatitude()-v1.getLatitude();
        ycarre=y*y;
        distance= (float) Math.sqrt(xcarre+ycarre);
       return distance;
    }
    
}
