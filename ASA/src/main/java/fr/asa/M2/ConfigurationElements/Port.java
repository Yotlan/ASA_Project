package fr.asa.M2.ConfigurationElements;

import fr.asa.M2.Configuration;

public class Port {
    public String type;
    public Configuration currentConfig;

    public Port (String type, Configuration currentConfig) throws Exception {
        if (type.equals("requis") || (type.equals("fournis"))) {
            this.type=type;
            this.currentConfig=currentConfig;
            this.currentConfig.addPort(this);
        }else{
            throw new Exception("Port : type error ");
        }
    }

    public String getType() {
        return type;
    }
}
