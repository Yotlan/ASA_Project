package fr.asa.M2.ConfigurationElements;

import fr.asa.M2.Configuration;
import fr.asa.M2.ConfigurationElements.Composant.IComposant;

public class Port {
    public String type;
    public Configuration currentConfig;
    public IComposant currentComp;

    public Port (String type, IComposant currentComp) throws Exception {
        if (type.equals("requis") || (type.equals("fournis"))) {
            this.type=type;
            this.currentComp=currentComp;
            this.currentConfig=currentComp.getConfig();
            this.currentConfig.addPort(this);
        }else{
            throw new Exception("Port : type error ");
        }
    }
    public Port (String type, Configuration currentConfig) throws Exception {
        if (type.equals("requis") || (type.equals("fournis"))) {
            this.type=type;
            this.currentComp=null;
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
