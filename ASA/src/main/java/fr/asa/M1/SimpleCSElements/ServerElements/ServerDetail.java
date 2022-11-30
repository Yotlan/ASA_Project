package fr.asa.M1.SimpleCSElements.ServerElements;

import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.*;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionDatabaseElements.CDCalled;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionDatabaseElements.CDCaller;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionManagerElements.DBQuery;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionManagerElements.ExternalSocket;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionManagerElements.SecurityCheck;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionSecurityElements.CSCalled;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.ConnectionSecurityElements.CSCaller;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.DatabaseElements.QueryInterro;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.DatabaseElements.SecurityManagement;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.SecurityDatabaseElements.SDCalled;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.SecurityDatabaseElements.SDCaller;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.SecurityManager;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.SecurityManagerElements.CheckQuery;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetailElements.SecurityManagerElements.SecurityAuth;
import fr.asa.M2.*;
import fr.asa.M2.ConfigurationElements.Attachement;
import fr.asa.M2.ConfigurationElements.Binding;
import fr.asa.M2.ConfigurationElements.Composant.IComposant;
import fr.asa.M2.ConfigurationElements.Port;
import fr.asa.M2.ConfigurationElements.Connecteur.IConnecteur;

import java.util.List;

public class ServerDetail extends Configuration {
    public ServerDetail() throws Exception {
        super();
        //Create Components ConnectionManager, SecurityManager and Database
        //Create ExternalSocket
        ExternalSocket ES = new ExternalSocket();
        //Create DBQuery
        DBQuery DBQ = new DBQuery();
        //Create SecurityCheck
        SecurityCheck SC = new SecurityCheck();
        ConnectionManager ConnMan = new ConnectionManager(ES,SC,DBQ,this);
        ES.setComposant(ConnMan);
        ES.setConfig(this);
        DBQ.setComposant(ConnMan);
        DBQ.setConfig(this);
        SC.setComposant(ConnMan);
        SC.setConfig(this);
        this.addComposants(ConnMan);
        //Create SecurityAuth
        SecurityAuth SA = new SecurityAuth();
        //Create CheckQuery
        CheckQuery CQ = new CheckQuery();
        SecurityManager SecuMan = new SecurityManager(SA, CQ, this);
        SA.setComposant(SecuMan);
        SA.setConfig(this);
        CQ.setComposant(SecuMan);
        CQ.setConfig(this);
        this.addComposants(SecuMan);
        //Create SecurityManagement
        SecurityManagement SM = new SecurityManagement();
        //Create QueryInterro
        QueryInterro QI = new QueryInterro();
        Database DB = new Database(SM, QI, this);
        SM.setComposant(DB);
        SM.setConfig(this);
        QI.setComposant(DB);
        QI.setConfig(this);
        this.addComposants(DB);

        //Create SD ports
        PortSD PSD = new PortSD();
        this.addPort(PSD);

        //Create SD Binding
        BindingSD BSD = new BindingSD(PSD, ES, this);
        this.addBinding(BSD);

        //Create ConnectionSecurity
        //Create Caller and Called
        CSCaller csCaller = new CSCaller();
        CSCalled csCalled = new CSCalled();
        ConnectionSecurity CS = new ConnectionSecurity(csCaller, csCalled, "C2S", this);
        csCaller.setConnecteur(CS);
        csCalled.setConnecteur(CS);
        this.addConnecteurs(CS);
        //Create ConnectionDatabase
        //Create Caller and Called
        CDCaller cdCaller = new CDCaller();
        CDCalled cdCalled = new CDCalled();
        ConnectionDatabase CD = new ConnectionDatabase(cdCaller, cdCalled, "C2D", this);
        cdCaller.setConnecteur(CD);
        cdCalled.setConnecteur(CD);
        this.addConnecteurs(CD);
        //Create SecurityDatabase
        //Create Caller and Called
        SDCaller sdCaller = new SDCaller();
        SDCalled sdCalled = new SDCalled();
        SecurityDatabase SD = new SecurityDatabase(sdCaller, sdCalled, "S2D", this);
        sdCaller.setConnecteur(SD);
        sdCalled.setConnecteur(SD);
        this.addConnecteurs(SD);

        //Create SD Attachements
        AttachementSD1 sd1 = new AttachementSD1(SC, SA, csCaller, csCalled, this);
        this.addAttachements(sd1);
        AttachementSD2 sd2 = new AttachementSD2(DBQ, QI, cdCaller, cdCalled, this);
        this.addAttachements(sd2);
        AttachementSD3 sd3 = new AttachementSD3(CQ, SM, sdCaller, sdCalled, this);
        this.addAttachements(sd3);
    }
}
