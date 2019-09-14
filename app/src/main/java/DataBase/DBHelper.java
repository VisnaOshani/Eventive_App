package DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import Models.Fbudget;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "event.db";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String create_table_budget = "CREATE TABLE " + EventMaster.budget.TABLE_NAME + " (" +
                EventMaster.budget._ID + " INTEGER PRIMARY KEY, " +
                EventMaster.budget.COLUMN_NOTE_+ " TEXT, " +
                EventMaster.budget.COLUMN_TYPE + " TEXT, " +
                EventMaster.budget.COLUMN_AMOUNT + " TEXT, " +
                EventMaster.budget.COLUMN_PAMOUNT + " TEXT, " +
                EventMaster.budget.COLUMN_BALANCE + " TEXT);" ;

        db.execSQL(create_table_budget);
    }

    public boolean addBud(String note,String type,String amount,String pamount,String balance){

        SQLiteDatabase db = getWritableDatabase();
        int t = 10;
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

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

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

    public void editBudget(String id, String note, String amount,String type, String pamount){
        SQLiteDatabase db = getReadableDatabase();

        ContentValues contentvalues = new ContentValues();
        contentvalues.put(EventMaster.budget.COLUMN_NOTE_,note);
        contentvalues.put(EventMaster.budget.COLUMN_TYPE,type);
        contentvalues.put(EventMaster.budget.COLUMN_AMOUNT, amount);
        contentvalues.put(EventMaster.budget.COLUMN_PAMOUNT,pamount);

        String Selection = EventMaster.budget._ID + "= ?";
        String SelectionArgs[] = {id};

        db.update(EventMaster.budget.TABLE_NAME, contentvalues, Selection, SelectionArgs);
    }



}

