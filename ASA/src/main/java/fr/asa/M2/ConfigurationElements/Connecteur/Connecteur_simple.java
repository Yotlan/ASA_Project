package fr.asa.M2.ConfigurationElements.Connecteur;

import fr.asa.M2.Configuration;

import java.util.List;

public class Connecteur_simple implements IConnecteur {
    private List<Role> roles;
    private Glue glue;
    public Configuration currentConfig;

    public Connecteur_simple(List<Role> roles, String nameGlue, Configuration currentConfig){
        this.roles=roles;
        this.glue=new Glue(nameGlue,this);
        this.currentConfig=currentConfig;
        this.currentConfig.addConnecteurs(this);
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public List<Role> getRoles() {
        return this.roles;
    }

}
