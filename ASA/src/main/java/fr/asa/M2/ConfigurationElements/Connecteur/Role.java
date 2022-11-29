package fr.asa.M2.ConfigurationElements.Connecteur;

import fr.asa.M2.ConfigurationElements.Composant.IComposant;

public class Role {
    private String type;
    public IConnecteur currentConnect;

    public Role(String type) throws Exception {
        if (type.equals("requis") || type.equals("fournis")){
            this.type=type;
        }else{
            throw new Exception("role : type error");
        }
    }

    public String getType() {
        return type;
    }

    public void setConnecteur(IConnecteur connecteur) {
        this.currentConnect=connecteur;
    }

}
