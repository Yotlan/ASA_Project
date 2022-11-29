package fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements;

import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetail;
import fr.asa.M2.ConfigurationElements.Attachement;
import fr.asa.M2.ConfigurationElements.Connecteur.Role;
import fr.asa.M2.ConfigurationElements.Port;

public class AttachementSD2 extends Attachement {
    public AttachementSD2(Port portRequired, Port portGiven, Role roleRequired, Role roleGiven, ServerDetail currentConfig) throws Exception {
        super(portRequired, portGiven, roleRequired, roleGiven, currentConfig);
    }
}
