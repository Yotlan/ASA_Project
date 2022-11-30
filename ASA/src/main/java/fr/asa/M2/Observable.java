package fr.asa.M2;

public interface Observable {

    void notifyObservers() throws InterruptedException;

    String getUpdate(Observer observer);

}
