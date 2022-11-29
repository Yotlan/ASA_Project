package fr.asa.M2.ConfigurationElements.Connecteur;

import fr.asa.M2.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Connecteur_complexe implements IConnecteur {
    public Configuration configuration;
    private List<IConnecteur> connecteurs;

    public Connecteur_complexe(Configuration configuration, List<IConnecteur> connecteurs){
        this.configuration=configuration;
        this.connecteurs=connecteurs;
    }

    public List<Role> getRoles() {
        List<Role> roles = new ArrayList<>();
        for(IConnecteur connecteur : connecteurs) {
            roles.addAll(connecteur.getRoles());
        }
        return roles;
    }
}
