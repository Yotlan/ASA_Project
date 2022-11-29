package fr.asa.M2;

public interface Observable {

    void notifyObservers();

    void postMessage(String msg);

    String getUpdate(Observer observer);

}
