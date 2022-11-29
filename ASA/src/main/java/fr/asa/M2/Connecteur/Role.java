package fr.asa.M2.Connecteur;

public class Role {
    private String type;

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
}
