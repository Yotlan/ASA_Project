package fr.asa.M2.ConfigurationElements.Composant;

public class Service {
    private String type;
    public Composant_simple currentComp;

    public Service(String type, Composant_simple currentComp) throws Exception {
        if (type.equals("requis") || type.equals("fournis")){
            this.type=type;
            this.currentComp=currentComp;
            this.currentComp.addService(this);
        }else {
            throw new Exception("service : type error");
        }
    }

    public String getType() {
        return type;
    }

}
