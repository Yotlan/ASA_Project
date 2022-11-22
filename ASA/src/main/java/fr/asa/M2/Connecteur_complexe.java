package fr.asa.M2;

import java.util.List;

public class Connecteur_complexe implements IConnecteur{
    private Configuration configuration;
    private List<IConnecteur> connecteurs;

    public Connecteur_complexe(Configuration configuration, List<IConnecteur> connecteurs){
        this.configuration=configuration;
        this.connecteurs=connecteurs;
    }

}
