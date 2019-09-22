package DataBase;

import android.provider.BaseColumns;

public class EventMaster {
    private EventMaster(){}

    protected static class budget implements BaseColumns {

        //visna's table

        protected static final String TABLE_NAME = "budget";
        protected static final String COLUMN_NOTE_ = "note";
        protected static final String COLUMN_TYPE = "type";
        protected static final String COLUMN_AMOUNT = "eamount";
        protected static final String COLUMN_PAMOUNT = "pamount";
        protected static final String COLUMN_BALANCE = "balance";

        //visna's table end

    }



}
