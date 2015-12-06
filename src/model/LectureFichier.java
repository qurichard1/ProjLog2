package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.exit;

public class LectureFichier {
        
    public static Monde LireFichier(String cheminFichier) throws IOException{
        Monde m ;
        BufferedReader fichier= fileToBuffered(cheminFichier);
        
       int taille=recupTaille(fichier);
        
        m=boucle(taille,fichier);
        
        
        return m;
    }
    
    private static int recupTaille(BufferedReader fichier) throws IOException{
        String ligne = fichier.readLine();
        int i=0;
        
        int taille=0;
        String[] t=ligne.split(" ");
        taille = Integer.parseInt(t[2]);
        return taille;
        
        
    }
    
    private static BufferedReader fileToBuffered(String chemin){
        File f = new File(chemin);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(f);
        } catch (Exception e) {
            System.err.println("File Not Found");
            exit(-1);
        }
        
        BufferedReader fichier= new BufferedReader(new InputStreamReader(fis));
        return fichier;
    }
    
    private static Monde boucle(int taille, BufferedReader fichier) throws IOException{
        Monde m= new Monde(taille);
        String ligne;
        int i=0;
        ligne=fichier.readLine();
        while(ligne!=null){
            m.tabVille[i]=lireVille(ligne);
            ++i;
            ligne=fichier.readLine();
        }
        
        return m;
        
    }
    
    
    public static Ville lireVille(String ligne){
        String[] t=ligne.split(" ");
        return new Ville(Integer.parseInt(t[0]),Float.parseFloat(t[1]),Float.parseFloat(t[2]));
    }
}
