package fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements;

import fr.asa.M2.ConfigurationElements.Attachement;
import fr.asa.M2.ConfigurationElements.Connecteur.Role;
import fr.asa.M2.ConfigurationElements.Port;

public class AttachementSD3 extends Attachement {
    public AttachementSD3(Port portRequired, Port portGiven, Role roleRequired, Role roleGiven) throws Exception {
        super(portRequired, portGiven, roleRequired, roleGiven);
    }
}
