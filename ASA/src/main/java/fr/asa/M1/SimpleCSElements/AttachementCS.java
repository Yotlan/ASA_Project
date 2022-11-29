package fr.asa.M1.SimpleCSElements;

import fr.asa.M2.Configuration;
import fr.asa.M2.ConfigurationElements.Attachement;
import fr.asa.M2.ConfigurationElements.Port;
import fr.asa.M2.ConfigurationElements.Connecteur.Role;

public class AttachementCS extends Attachement {
    public AttachementCS(Configuration currentConfig) throws Exception {
        super(currentConfig.getPorts(), currentConfig.getIConnecteurs(), currentConfig);
    }
}
