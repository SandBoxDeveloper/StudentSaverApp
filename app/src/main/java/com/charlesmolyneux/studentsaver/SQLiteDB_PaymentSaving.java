package com.charlesmolyneux.studentsaver;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by charlesmolyneux on 02/07/2016.
 */
public class SQLiteDB_PaymentSaving extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "StudentSaverPayments";

    public static final String PAYMENT_TYPE = "p_PaymentType";
    public static final String PAYMENT_CATEGORY = "p_PaymentCategory";
    public static final String PAYMENT_AMOUNT = "p_PaymentAmount";
    public static final String PAYMENT_OCCURS = "p_PaymentReoccurs";
    public static final String PAYMENT_DATE = "p_PaymentDueDate";

    public SQLiteDB_PaymentSaving(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES = "CREATE TABLE " + DATABASE_NAME +
                " (id integer primary key AUTOINCREMENT, " +
                PAYMENT_TYPE + " text, " +
                PAYMENT_CATEGORY + " text, " +
                PAYMENT_AMOUNT + " text, " +
                PAYMENT_OCCURS + " text, " +
                PAYMENT_DATE + " text)";

        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public boolean insertPayment (String payType, String payCategoy, String payAmount, String payReoccurs,String payDate) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PAYMENT_TYPE, payType);
        contentValues.put(PAYMENT_CATEGORY, payCategoy);
        contentValues.put(PAYMENT_AMOUNT, payAmount);
        contentValues.put(PAYMENT_OCCURS, payReoccurs);
        contentValues.put(PAYMENT_DATE, payDate);
        db.insert(DATABASE_NAME, null, contentValues);
        return true;
    }

    //Gets all columns / rows from the Payment table
    public Cursor getData(int pId){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "SELECT * FROM " + DATABASE_NAME + " WHERE id = " + pId, null);
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, DATABASE_NAME);
        return numRows;
    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
     //   db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
