package fr.asa.M1;

import fr.asa.M2.Composant.Composant_simple;
import fr.asa.M2.Composant.IComposant;
import fr.asa.M2.Port;
import fr.asa.M2.Composant.Service;

import java.util.List;

public class Database extends Composant_simple implements IComposant {

    public Database(List<Port> ports, List<Service> services) throws Exception {
        super(ports, services);

        //check ports
        boolean check_secuManagement=false;
        boolean check_queryInt=false;
        for (Port port: ports){
            if (port instanceof SecurityManagement){
                check_secuManagement=true;
            }
            if (port instanceof  QueryInterro) {
                check_queryInt = true;
            }
        }
        if (!(check_secuManagement && check_queryInt) ){
            throw new Exception("Database error : ports error : need SecurityManagement and QueryInterro");
        }
    }
}
