package fr.asa.M2.ConfigurationElements.Connecteur;

public class Role {
    private String type;
    public Connecteur_simple currentConnect;

    public Role(String type, Connecteur_simple currentConnect) throws Exception {
        if (type.equals("requis") || type.equals("fournis")){
            this.type=type;
            this.currentConnect=currentConnect;
            this.currentConnect.addRole(this);
        }else{
            throw new Exception("role : type error");
        }
    }

    public String getType() {
        return type;
    }
}
