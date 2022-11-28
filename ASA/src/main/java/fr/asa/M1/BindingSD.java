package fr.asa.M1;

import fr.asa.M2.Binding;
import fr.asa.M2.Port;

public class BindingSD extends Binding {
    public BindingSD(Port portRequis, Port portFournis) throws Exception {
        super(portRequis, portFournis);
        if ( !(portRequis instanceof PortSD)){
            throw new Exception("BindingSD error : port requis error");
        }
        if ( !(portFournis instanceof ExternalSocket)){
            throw new Exception("BindingSD error : port fournis error");
        }
    }
}
