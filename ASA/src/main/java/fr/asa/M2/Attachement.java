package fr.asa.M2;

import fr.asa.M2.Connecteur.Role;

public class Attachement {
    private Port portRequired;
    private Port portGiven;
    private Role roleRequired;
    private Role roleGiven;

    public Attachement(Port portRequired, Port portGiven, Role roleRequired, Role roleGiven) throws Exception {
        if ( portRequired.getType().equals("requis") && roleGiven.getType().equals("fournis")
                && portGiven.getType().equals("fournis") && roleRequired.getType().equals("requis")){
            this.portRequired=portRequired;
            this.portGiven=portGiven;
            this.roleRequired=roleRequired;
            this.roleGiven=roleGiven;
        }else{
            throw new Exception("Attachement :  Need required port/role AND given port/role");
        }
    }
}
