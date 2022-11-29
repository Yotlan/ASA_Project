package fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements;

import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionManagerElements.DBQuery;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionManagerElements.ExternalSocket;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionManagerElements.SecurityCheck;
import fr.asa.M2.ConfigurationElements.Composant.Composant_simple;
import fr.asa.M2.ConfigurationElements.Composant.IComposant;
import fr.asa.M2.ConfigurationElements.Port;
import fr.asa.M2.ConfigurationElements.Composant.Service;

import java.util.List;

public class ConnectionManager extends Composant_simple implements IComposant {

    public ConnectionManager(List<Port> ports, List<Service> services) throws Exception {
        super(ports, services);
        //checker les ports
        boolean check_exSocket=false;
        boolean check_secuCheck=false;
        boolean check_dbQuery=false;
        for (Port port: ports){
            if(port instanceof ExternalSocket){
                check_exSocket=true;
            }
            if(port instanceof SecurityCheck){
                check_secuCheck=true;
            }
            if(port instanceof DBQuery){
                check_dbQuery=true;
            }
        }
        if (!((check_exSocket && check_secuCheck) && check_dbQuery)){
            throw new Exception("ConnectionManager error : on ports : necessite 3 types port ");
        }
    }
}
