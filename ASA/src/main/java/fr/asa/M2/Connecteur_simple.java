package fr.asa.M2;

import java.util.List;

public class Connecteur_simple implements IConnecteur{
    private List<Role> roles;
    private Glue glue;

    public Connecteur_simple(List<Role> roles, String nameGlue){
        this.roles=roles;
        this.glue=new Glue(nameGlue);
    }

}
