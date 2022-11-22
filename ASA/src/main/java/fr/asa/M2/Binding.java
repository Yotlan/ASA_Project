package fr.asa.M2;

public class Binding {
    private Port portRequis;
    private Port portFournis;

    public Binding(Port portRequis, Port portFournis) throws Exception {
        if (portRequis.getType().equals("requis") && portFournis.getType().equals("fournis")){
            this.portRequis=portRequis;
            this.portFournis=portFournis;
        }else{
            throw new Exception("Binding combine error : portRequis doit etre un port requis, et portFournis doit etre un port fournis");
        }
    }
}
