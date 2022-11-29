package fr.asa.M1;

import fr.asa.M2.Attachement;
import fr.asa.M2.Port;
import fr.asa.M2.Connecteur.Role;

public class AttachementSD extends Attachement {
    public AttachementSD(Port port, Role role) throws Exception {
        super(port, role);
    }
}
