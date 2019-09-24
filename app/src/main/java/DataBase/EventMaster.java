package DataBase;

import android.provider.BaseColumns;

public class EventMaster {
    private EventMaster(){}

    protected static class budget implements BaseColumns {

        //visna's table

        protected static final String TABLE_NAME = "budget";
        protected static final String COLUMN_NOTE_ = "note";
        protected static final String COLUMN_TYPE = "type";
        protected static final String COLUMN_AMOUNT = "amount";
        protected static final String COLUMN_PAMOUNT = "pamount";
        protected static final String COLUMN_BALANCE = "balance";


        //visna's table end

    }



    protected static class guest implements BaseColumns {

        protected static final String TABLE_NAME = "guest";
        protected static final String COLUMN_FIRSTNAME = "fName";
        protected static final String COLUMN_LASTNAME = "lName";
        protected static final String COLUMN_NOOFPEOPLE = "people";
        protected static final String COLUMN_GUESTADDRESS = "AddGuest";
        protected static final String COLUMN_GUESTMOBILE = "guestMob";
        protected static final String COLUMN_GUESTEMAIL = "guestMail";
    }


}
