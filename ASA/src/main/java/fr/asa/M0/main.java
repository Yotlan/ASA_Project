package fr.asa.M0;

import fr.asa.M1.SimpleCS;
import fr.asa.M1.SimpleCSElements.AttachementCS;
import fr.asa.M1.SimpleCSElements.Client;
import fr.asa.M1.SimpleCSElements.ClientElements.SendRequest;
import fr.asa.M1.SimpleCSElements.RPC;
import fr.asa.M1.SimpleCSElements.RPCElements.Called;
import fr.asa.M1.SimpleCSElements.RPCElements.Caller;
import fr.asa.M1.SimpleCSElements.Server;
import fr.asa.M1.SimpleCSElements.ServerElements.ReceiveRequest;
import fr.asa.M1.SimpleCSElements.ServerElements.ServerDetail;
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
import fr.asa.M2.ConfigurationElements.Port;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) throws Exception {
        //Create ConfigCS
        SimpleCS configCS = new SimpleCS();

        //Create ConfigSD
        ServerDetail configSD = new ServerDetail();

        //Create Components ConnectionManager, SecurityManager and Database
        //Create ExternalSocket
        ExternalSocket ES = new ExternalSocket();
        //Create DBQuery
        DBQuery DBQ = new DBQuery();
        //Create SecurityCheck
        SecurityCheck SC = new SecurityCheck();
        ConnectionManager ConnMan = new ConnectionManager(ES,SC,DBQ,configSD);
        ES.setComposant(ConnMan);
        ES.setConfig(configSD);
        DBQ.setComposant(ConnMan);
        DBQ.setConfig(configSD);
        SC.setComposant(ConnMan);
        SC.setConfig(configSD);
        configSD.addComposants(ConnMan);
        //Create SecurityAuth
        SecurityAuth SA = new SecurityAuth();
        //Create CheckQuery
        CheckQuery CQ = new CheckQuery();
        SecurityManager SecuMan = new SecurityManager(SA, CQ, configSD);
        SA.setComposant(SecuMan);
        SA.setConfig(configSD);
        CQ.setComposant(SecuMan);
        CQ.setConfig(configSD);
        configSD.addComposants(SecuMan);
        //Create SecurityManagement
        SecurityManagement SM = new SecurityManagement();
        //Create QueryInterro
        QueryInterro QI = new QueryInterro();
        Database DB = new Database(SM, QI, configSD);
        SM.setComposant(DB);
        SM.setConfig(configSD);
        QI.setComposant(DB);
        QI.setConfig(configSD);
        configSD.addComposants(DB);

        //Create SD ports
        PortSD PSD = new PortSD();
        configSD.addPort(PSD);

        //Create SD Binding
        BindingSD BSD = new BindingSD(PSD, ES, configSD);
        configSD.addBinding(BSD);

        //Create ConnectionSecurity
        //Create Caller and Called
        CSCaller csCaller = new CSCaller();
        CSCalled csCalled = new CSCalled();
        ConnectionSecurity CS = new ConnectionSecurity(csCaller, csCalled, "C2S", configSD);
        csCaller.setConnecteur(CS);
        csCalled.setConnecteur(CS);
        configSD.addConnecteurs(CS);
        //Create ConnectionDatabase
        //Create Caller and Called
        CDCaller cdCaller = new CDCaller();
        CDCalled cdCalled = new CDCalled();
        ConnectionDatabase CD = new ConnectionDatabase(cdCaller, cdCalled, "C2D", configSD);
        cdCaller.setConnecteur(CD);
        cdCalled.setConnecteur(CD);
        configSD.addConnecteurs(CD);
        //Create SecurityDatabase
        //Create Caller and Called
        SDCaller sdCaller = new SDCaller();
        SDCalled sdCalled = new SDCalled();
        SecurityDatabase SD = new SecurityDatabase(sdCaller, sdCalled, "S2D", configSD);
        sdCaller.setConnecteur(SD);
        sdCalled.setConnecteur(SD);
        configSD.addConnecteurs(SD);

        //Create SD Attachements
        AttachementSD1 sd1 = new AttachementSD1(SC, SA, csCaller, csCalled, configSD);
        configSD.addAttachements(sd1);
        AttachementSD2 sd2 = new AttachementSD2(DBQ, QI, cdCaller, cdCalled, configSD);
        configSD.addAttachements(sd2);
        AttachementSD3 sd3 = new AttachementSD3(CQ, SM, sdCaller, sdCalled, configSD);
        configSD.addAttachements(sd3);

        //Create Udon Server
        ReceiveRequest URR = new ReceiveRequest();
        Server udon = new Server(URR, configSD, configCS);
        URR.setComposant(udon);
        URR.setConfig(configCS);
        configCS.addComposants(udon);

        //Create Clients BigMom, Luffy and Hyo
        //Create BigMom's SendRequest
        SendRequest BGSR = new SendRequest();
        Client bigMom = new Client("Big Mom", BGSR, configCS);
        BGSR.setComposant(bigMom);
        BGSR.setConfig(configCS);
        configCS.addComposants(bigMom);
        //Create Luffy's SendRequest
        SendRequest LSR = new SendRequest();
        Client luffy = new Client("Luffy", LSR, configCS);
        LSR.setComposant(luffy);
        LSR.setConfig(configCS);
        configCS.addComposants(luffy);
        //Create Hyo's SendRequest
        SendRequest HSR = new SendRequest();
        Client hyo = new Client("Hyogoro", HSR, configCS);
        HSR.setComposant(hyo);
        HSR.setConfig(configCS);
        configCS.addComposants(hyo);

        //Create RPC
        //Create Caller and Called
        Caller caller = new Caller();
        Called called = new Called();
        RPC rpc = new RPC(caller, called, "Client2Server",configCS);
        caller.setConnecteur(rpc);
        called.setConnecteur(rpc);
        configCS.addConnecteurs(rpc);

        //Create CS Attachements
        AttachementCS cs1 = new AttachementCS(URR, BGSR, caller, called, configCS);
        configCS.addAttachements(cs1);
        AttachementCS cs2 = new AttachementCS(URR, LSR, caller, called, configCS);
        configCS.addAttachements(cs2);
        AttachementCS cs3 = new AttachementCS(URR, HSR, caller, called, configCS);
        configCS.addAttachements(cs3);

        luffy.post("I eat soup ! Left 1 portion !");
        hyo.post("I eat soup ! Left 0 portion !");
        bigMom.post("I'll kill them ! Because I have no soup left !");

    }
}
