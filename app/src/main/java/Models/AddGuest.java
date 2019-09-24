package Models;

public class AddGuest {private int ID;

    private String fName;
    private String lName;
    private int people;
    //guest's address
    private String addGuest;
    private String mobGuest;
    private String emailGuest;

    public AddGuest(String fName, String lName, int people, String addGuest, String mobGuest, String emailGuest) {
        this.fName= fName;
        this.lName=lName;
        this.people = people;
        this.addGuest = addGuest;
        this.mobGuest = mobGuest;
        this.emailGuest = emailGuest;
    }


    public AddGuest(){

    }


    public String getfName() {
        return fName;
    }

    public void setfName(String FName) {
        FName = fName;
    }
    public String getlName() {
        return lName;
    }

    public void setlName(String LName) {

    }

    public int getPeople() {
        return people;
    }

    public void setPeople(String People) {

    }

    public String getmobGuest() {
        return mobGuest;
    }

    public void setMobGuest(String mobGuest) {
        this.mobGuest = mobGuest;;
    }

    public String getaddGuest() {
        return addGuest;
    }

    public void setAddGuest(String addGuest) {
        this.addGuest = addGuest;
    }

    public String getemailGuest() {
        return emailGuest;
    }

    public void setemailGuest(String emailGuest) {
        this.emailGuest = emailGuest;
    }

}
