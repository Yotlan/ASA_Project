package fr.asa.M2;

public class Port {
    public String type;

    public Port (String type) throws Exception {
        if (type.equals("requis") || (type.equals("fournis"))) {
            this.type=type;
        }else{
            throw new Exception("Port : type error ");
        }
    }

    public String getType() {
        return type;
    }
}
