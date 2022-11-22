package fr.asa.M2;

public class Attachement {
    private Port port;
    private Role role;

    public Attachement(Port port, Role role) throws Exception {
        if ( (port.getType().equals("fournis") && role.getType().equals("requis"))
                || (port.getType().equals("requis") && role.getType().equals("fournis"))){
            this.port=port;
            this.role=role;
        }else{
            throw new Exception("Attachement : combine error , doit un requis et un fournis (port/role)");
        }
    }
}
