package fr.asa.M1;

import fr.asa.M2.Connecteur.Connecteur_simple;
import fr.asa.M2.Connecteur.IConnecteur;
import fr.asa.M2.Connecteur.Role;

import java.util.List;

public class RPC extends Connecteur_simple implements IConnecteur {
    public RPC(List<Role> roles, String nameGlue) throws Exception {
        super(roles, nameGlue);
        boolean check_caller=false;
        boolean check_called=false;
        for (Role role : roles){
           if (role instanceof Caller){
               check_caller=true;
           }
           if (role instanceof Called){
               check_called=true;
           }
       }
        if (!(check_caller && check_called)){
            throw new Exception("RPC error : roles error");
        }
    }
}
