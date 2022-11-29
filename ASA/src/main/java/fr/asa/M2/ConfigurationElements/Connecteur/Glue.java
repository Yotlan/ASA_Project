package fr.asa.M2.ConfigurationElements.Connecteur;

public class Glue {
    private String name;
    public Connecteur_simple currentConnect;
    public Glue(String nameGlue, Connecteur_simple currentConnect){
        this.name=nameGlue;
        this.currentConnect=currentConnect;
    }
}
