package fit.com.buddieshub;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "msgdb";

    // Contacts table name
    private static final String TABLE_SHOPPER = "userstbl";




    private static final String KEY_SID = "uid";
    private static final String KEY_MOBILE = "mobile";
    private static final String KEY_PASSWORD = "password";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {


        String CREATE_SHOPPER_TABLE = "CREATE TABLE " + TABLE_SHOPPER + "("
                + KEY_SID + " INTEGER PRIMARY KEY,"
                + KEY_MOBILE + " TEXT,"
                + KEY_PASSWORD + " TEXT" + ")";

        db.execSQL(CREATE_SHOPPER_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SHOPPER);
        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new contact
    boolean addShopper(Shopper shopper) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_MOBILE,shopper.getMobile() );
        values.put(KEY_PASSWORD, shopper.getPassword());

        // Inserting Row
        db.insert(TABLE_SHOPPER, null, values);
        db.close(); // Closing database connection
        return true;
    }



    public String[] getAllUsers() {
        String selectQuery = "SELECT  * FROM " + TABLE_SHOPPER;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        String users[] = new String[cursor.getCount()];
        int i=0;
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                String str = cursor.getString(1)+":"+cursor.getString(2);
                users[i]=str;
                i++;

            } while (cursor.moveToNext());
        }

        // return contact list
        return users;
    }


}