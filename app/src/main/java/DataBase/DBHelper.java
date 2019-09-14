package DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.util.Log;

import java.util.ArrayList;

import Models.Fbudget;
import Models.Hevent;


public class DBHelper extends SQLiteOpenHelper {


    //himasaha
    public static final String DB_NAME = "event.db";
    public static final String TABLE_NAME = "user";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "Name";
    public static final String COL_3 = "date";
    public static final String COL_4 = "location";
    public static final String COL_5 = "notes";





    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        //himasha
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,DATE TEXT,LOCATION TEXT,NOTES TEXT)");



    String create_table_budget = "CREATE TABLE " + EventMaster.budget.TABLE_NAME + " (" +
                EventMaster.budget._ID + " INTEGER PRIMARY KEY, " +
                EventMaster.budget.COLUMN_NOTE_+ " TEXT, " +
                EventMaster.budget.COLUMN_TYPE + " TEXT, " +
                EventMaster.budget.COLUMN_AMOUNT + " TEXT, " +
                EventMaster.budget.COLUMN_PAMOUNT + " TEXT, " +
                EventMaster.budget.COLUMN_BALANCE + " TEXT);" ;

        db.execSQL(create_table_budget);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

   //himasha
    public boolean addUser(String userName, String date,String loc,String not) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_2, userName);
        values.put(COL_3, date);
        values.put(COL_4, loc);
        values.put(COL_5, not);


        long result = db.insert(TABLE_NAME,null, values);


        if(result == -1){
            //if data inserted succsessfully
            return false;
        }else{
            //if data does not insert
            return true;
        }
    }


        public Cursor getListEvents(){

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor data = db.rawQuery("SELECT * FROM " +TABLE_NAME,null);
            return data;

        }



    //himasha

    public boolean addBud(String note,String type,String amount,String pamount,String balance){

        SQLiteDatabase db = getWritableDatabase();

     ContentValues contentValues = new ContentValues();

       contentValues.put(EventMaster.budget.COLUMN_NOTE_,note);
       contentValues.put(EventMaster.budget.COLUMN_TYPE,type);
        contentValues.put(EventMaster.budget.COLUMN_AMOUNT,amount);
        contentValues.put(EventMaster.budget.COLUMN_PAMOUNT,pamount);
        contentValues.put(EventMaster.budget.COLUMN_BALANCE,balance);

       long result = db.insert(EventMaster.budget.TABLE_NAME,null,contentValues);

        if(result > 0){
            return true;
        }else {
            return false;
        }
    }



    public ArrayList<Fbudget> readAllBudget(){
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {EventMaster.budget.COLUMN_NOTE_,EventMaster.budget._ID , EventMaster.budget.COLUMN_AMOUNT , EventMaster.budget.COLUMN_TYPE , EventMaster.budget.COLUMN_BALANCE};

        String sortOrder = EventMaster.budget.COLUMN_AMOUNT;

        Cursor values = db.query(EventMaster.budget.TABLE_NAME,projection,null,null,null,null,sortOrder);

        ArrayList<Fbudget> buds = new ArrayList<Fbudget>();

        while (values.moveToNext()){
            Fbudget bud = new Fbudget();
            String budnote = values.getString( values.getColumnIndexOrThrow( EventMaster.budget.COLUMN_NOTE_));
            String budtype = values.getString( values.getColumnIndexOrThrow( EventMaster.budget.COLUMN_TYPE));
            String budbala = values.getString( values.getColumnIndexOrThrow(EventMaster.budget.COLUMN_BALANCE));
            bud.setType( budtype );
            bud.setNote( budnote);
            bud.setBalance( budbala );
            bud.setID( values.getInt( values.getColumnIndexOrThrow( EventMaster.budget._ID)));
            buds.add( bud );
        }
        return buds;
    }




    public void deleteRead(int id){
        SQLiteDatabase db = getReadableDatabase();

        String Selection = EventMaster.budget._ID + " = ?";
        String[] SelectionArgs = { String.valueOf(id)};

        db.delete(EventMaster.budget.TABLE_NAME , Selection ,SelectionArgs);
        Log.i("DB","Delete :" + id );
    }



}

