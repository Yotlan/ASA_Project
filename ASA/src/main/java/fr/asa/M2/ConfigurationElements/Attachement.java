package fr.asa.M2.ConfigurationElements;

import fr.asa.M2.Configuration;
import fr.asa.M2.ConfigurationElements.Composant.IComposant;
import fr.asa.M2.ConfigurationElements.Connecteur.IConnecteur;
import fr.asa.M2.ConfigurationElements.Connecteur.Role;

public class Attachement {
    private Port portRequired;
    private Port portGiven;
    private Role roleRequired;
    private Role roleGiven;
    public Configuration currentConfig;

    public Attachement(Port portRequired, Port portGiven, Role roleRequired, Role roleGiven, Configuration currentConfig) throws Exception {
        if ( portRequired.getType().equals("requis") && roleGiven.getType().equals("fournis")
                && portGiven.getType().equals("fournis") && roleRequired.getType().equals("requis")){
            boolean checkPR = false;
            boolean checkPG = false;
            for(IComposant composant : currentConfig.getIComposants()) {
                if(composant.getPorts().contains(portRequired)) {
                    checkPR = true;
                } else if (composant.getPorts().contains(portGiven)) {
                    checkPG = true;
                }
            }
            if(checkPG && checkPR) {
                boolean checkRR = false;
                boolean checkRG = false;
                for(IConnecteur connecteur : currentConfig.getIConnecteurs()) {
                    if(connecteur.getRoles().contains(roleRequired)) {
                        checkRR = true;
                    } else if (connecteur.getRoles().contains(roleGiven)) {
                        checkRG = true;
                    }
                }
                if(checkRR && checkRG) {
                    this.portRequired = portRequired;
                    this.portGiven = portGiven;
                    this.roleRequired = roleRequired;
                    this.roleGiven = roleGiven;
                    this.currentConfig = currentConfig;
                    this.currentConfig.addAttachements(this);
                }
            }
        }else{
            throw new Exception("Attachement :  Need required port/role AND given port/role");
        }
    }
}
