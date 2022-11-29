package fr.asa.M0;

import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.Database;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.DatabaseElements.QueryInterro;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.DatabaseElements.SecurityManagement;
import fr.asa.M2.ConfigurationElements.Port;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) throws Exception {
        //Database create
        //TODO : check requis or fournis pour SecurityManagament and QueryInterro
        SecurityManagement securityManagement=new SecurityManagement("requis");
        QueryInterro queryInterro=new QueryInterro("fournis");
        List<Port> data_ports=new ArrayList<>();
        data_ports.add(securityManagement);
        data_ports.add(queryInterro);
        Database database=new Database(data_ports,new ArrayList<>());
    }
}
