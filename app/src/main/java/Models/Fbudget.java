package Models;

public class Fbudget {

    private int ID;
    private String Note;
    private String Type;
    private String amount;
    private String pamount;
    private String balance;

    public Fbudget(int ID, String note, String type, String amount, String pamount, String balance) {
        this.ID = ID;
        this.Note = note;
        this.Type = type;
        this.amount = amount;
        this.pamount = pamount;
        this.balance = balance;
    }

    public Fbudget(int ID, String note, String type, String balance) {
        this.ID = ID;
        Note = note;
        Type = type;
        this.balance = balance;
    }

    public Fbudget(){

    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPamount() {
        return pamount;
    }

    public void setPamount(String pamount) {
        this.pamount = pamount;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
