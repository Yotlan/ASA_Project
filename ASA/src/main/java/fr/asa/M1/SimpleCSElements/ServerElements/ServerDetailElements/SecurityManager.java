package fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements;

import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.SecurityManagerElements.CheckQuery;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.SecurityManagerElements.SecurityAuth;
import fr.asa.M2.ConfigurationElements.Composant.Composant_simple;
import fr.asa.M2.ConfigurationElements.Composant.IComposant;
import fr.asa.M2.ConfigurationElements.Port;
import fr.asa.M2.ConfigurationElements.Composant.Service;

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
