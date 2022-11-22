package fr.asa.M2;

import java.util.ArrayList;
import java.util.List;

public class Configuration {
    //attributs
    private List<Port> ports;
    private List<Binding> bindings;
    private List<IComposant> IComposants;
    private List<IConnecteur> IConnecteurs;
    private List<Attachement> attachements;

    //methodes
    public Configuration() {
        ports=new ArrayList<Port>();
        bindings=new ArrayList<Binding>();
        IComposants =new ArrayList<IComposant>();
        IConnecteurs =new ArrayList<IConnecteur>();
        attachements=new ArrayList<Attachement>();
    }

    public Configuration(List<Port> ports, List<Binding> bindings, List<IComposant> IComposants, List<IConnecteur> IConnecteurs, List<Attachement> attachements) {
        this.ports=ports;
        this.bindings=bindings;
        this.IComposants = IComposants;
        this.IConnecteurs = IConnecteurs;
        this.attachements=attachements;
    }



}
