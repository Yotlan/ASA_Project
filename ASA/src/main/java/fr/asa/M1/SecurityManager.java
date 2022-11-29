package fr.asa.M1;

import fr.asa.M2.Composant.Composant_simple;
import fr.asa.M2.Composant.IComposant;
import fr.asa.M2.Port;
import fr.asa.M2.Composant.Service;

import java.util.List;

public class SecurityManager extends Composant_simple implements IComposant {
    public SecurityManager(List<Port> ports, List<Service> services) throws Exception {
        super(ports, services);

        //check ports of securityManager
        boolean check_secuAuth=false;
        boolean check_checkquery=false;
        for (Port port : ports){
            if (port instanceof SecurityAuth){
                check_secuAuth=true;
            }
            if (port instanceof CheckQuery){
                check_checkquery=true;
            }
        }
        if (!(check_secuAuth && check_checkquery)){
            throw new Exception("SecurityManager error : ports error : need have SecurityAuth and CheckQuery");
        }
    }
}
