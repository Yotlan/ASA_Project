package fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements;

import fr.asa.M2.ConfigurationElements.Attachement;
import fr.asa.M2.ConfigurationElements.Port;
import fr.asa.M2.ConfigurationElements.Connecteur.Role;

public class AttachementSD1 extends Attachement {
    public AttachementSD1(Port portRequired, Port portGiven, Role roleRequired, Role roleGiven) throws Exception {
        super(portRequired, portGiven, roleRequired, roleGiven);
    }
}
