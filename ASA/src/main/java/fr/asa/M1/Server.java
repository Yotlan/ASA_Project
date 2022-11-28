package fr.asa.M1;

import fr.asa.M2.*;

import java.util.List;

public class Server extends Composant_complexe implements IComposant {
    public Server(List<IComposant> IComposants, Configuration configuration) throws Exception {
        super(IComposants, configuration);
        boolean check=false;
        //verification que le port ReceiveRequest est bien present
        for (IComposant composant_simple: IComposants){
            if (composant_simple instanceof  Composant_simple){
                for (Port port : ((Composant_simple) composant_simple).getPorts()){
                    if (port instanceof ReceiveRequest){
                        check=true;
                    }
                }
            }
        }
        if (check==false){
            throw new Exception("error : server configuration on port");
        }

        //verification sur configuration est bien serverDetail
        if ((configuration instanceof ServerDetail) == false){
            throw new Exception("error : server configuration on configuration");
        }
    }
}
