package DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "guest";
    public static final String COLUMN_FIRSTNAME = "fName";
    public static final String COLUMN_LASTNAME = "lName";
    public  static final String COLUMN_NOOFPEOPLE= "countpeople";
    public static final String COLUMN_GUESTADDRESS = "addressguest";
    public static final String COLUMN_GUESTMOBILE = "mobileguest";
    public static final String COLUMN_GUESTEMAIL = "emailguest";

    public DatabaseHelper(Context context){
        super(context,"guest.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table guest (fname text,lname text,people integer, guestAddress text,mobileguest integer, emailguest text  primary key)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS user");
        //onCreate(db);

    }
    public boolean insertGuest(String fname, String lname, int people, String guestAddress,int mobile, String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_FIRSTNAME,fname);
        cv.put(COLUMN_LASTNAME,lname);
        cv.put(COLUMN_NOOFPEOPLE,people);
        cv.put(COLUMN_GUESTADDRESS,guestAddress);
        cv.put(COLUMN_GUESTMOBILE,mobile);
        cv.put(COLUMN_GUESTEMAIL,email);
        long result = db.insert(TABLE_NAME,null,cv);
        if (result == 1)
            return false;
        else
            return true;

    }
    public boolean updateData(String fname, String lname, int people, String guestAddress,int mobile, String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_FIRSTNAME,fname);
        cv.put(COLUMN_LASTNAME,lname);
        cv.put(COLUMN_NOOFPEOPLE,people);
        cv.put(COLUMN_GUESTADDRESS,guestAddress);
        cv.put(COLUMN_GUESTMOBILE,mobile);
        cv.put(COLUMN_GUESTEMAIL,email);
        db.update(TABLE_NAME,cv,"emailguest = ?",new String[]{email});
        return true;

    }

    public Integer deleteData(String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"emailguest = ?",new String[]{email});
    }
}
