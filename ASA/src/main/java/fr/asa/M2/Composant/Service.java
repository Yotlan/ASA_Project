package fr.asa.M2.Composant;

public class Service {
    private String type;

    public Service(String type) throws Exception {
        if (type.equals("requis") || type.equals("fournis")){
            this.type=type;
        }else {
            throw new Exception("service : type error");
        }
    }

    public String getType() {
        return type;
    }

}
