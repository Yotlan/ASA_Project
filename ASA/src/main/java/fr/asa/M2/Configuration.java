package fr.asa.M2;

import fr.asa.M2.ConfigurationElements.Attachement;
import fr.asa.M2.ConfigurationElements.Binding;
import fr.asa.M2.ConfigurationElements.Composant.IComposant;
import fr.asa.M2.ConfigurationElements.Connecteur.IConnecteur;
import fr.asa.M2.ConfigurationElements.Port;

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

    public void addPort(Port port) {
        this.ports.add(port);
    }

    public List<Port> getPorts() {
        return this.ports;
    }

    public void addBinding(Binding binding) {
        this.bindings.add(binding);
    }

    public List<Binding> getBindings() {
        return this.bindings;
    }

    public void addComposants(IComposant composant) {
        this.IComposants.add(composant);
    }

    public List<IComposant> getIComposants() {
        return this.IComposants;
    }

    public void addConnecteurs(IConnecteur connecteur) {
        this.IConnecteurs.add(connecteur);
    }

    public List<IConnecteur> getIConnecteurs() {
        return this.IConnecteurs;
    }

    public void addAttachements(Attachement attachement) {
        this.attachements.add(attachement);
    }

    public List<Attachement> getAttachements() {
        return this.attachements;
    }

}
