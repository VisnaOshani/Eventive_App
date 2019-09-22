package Models;

public class Hevent {


    private int EID;
    private String Ename;
    private String Edate;
    private String Elocation;
    private String Enotes;


    public Hevent(int EID, String ename, String edate, String elocation, String enotes) {
        this.EID = EID;
        Ename = ename;
        Edate = edate;
        Elocation = elocation;
        Enotes = enotes;
    }

    public int getEID() {
        return EID;
    }

    public String getEname() {
        return Ename;
    }

    public String getEdate() {
        return Edate;
    }

    public String getElocation() {
        return Elocation;
    }

    public String getEnotes() {
        return Enotes;
    }

    public void setEID(int EID) {
        this.EID = EID;
    }

    public void setEname(String ename) {
        Ename = ename;
    }

    public void setEdate(String edate) {
        Edate = edate;
    }

    public void setElocation(String elocation) {
        Elocation = elocation;
    }

    public void setEnotes(String enotes) {
        Enotes = enotes;
    }
}
