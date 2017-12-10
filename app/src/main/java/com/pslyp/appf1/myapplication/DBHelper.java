package com.pslyp.appf1.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import com.pslyp.appf1.myapplication.model.InExMoney;

import java.util.ArrayList;

/**
 * Created by User on 10/12/2560.
 */

public class DBHelper extends SQLiteOpenHelper {

    private SQLiteDatabase sql;

    private static final String DATABASE_NAME = "androidProject";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "InExMoney";
    public static final String ID = BaseColumns._ID;
    public static final String COL_PICTURE = "picture";
    public static final String COL_DETAILS = "details";
    public static final String COL_MONEY = "money";
    public static final String COL_TYPE = "type";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_PICTURE + " INTEGER, "
                + COL_DETAILS + " TEXT, " + COL_MONEY + " INTEGER, " + COL_TYPE + " TEXT);");
     }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addMoney(InExMoney m) {
        sql = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_PICTURE, m.getPicture());
        values.put(COL_DETAILS, m.getDetails());
        values.put(COL_MONEY, m.getMoney());
        values.put(COL_TYPE, m.getType());

        sql.insert(TABLE_NAME, null, values);
        sql.close();
    }

    public ArrayList<InExMoney> getList() {
        ArrayList<InExMoney> m = new ArrayList<>();

        sql = this.getWritableDatabase();
        Cursor c = sql.query(TABLE_NAME, null, null, null, null, null, null, null);

        if(c != null)
            c.moveToFirst();

        while(!c.isAfterLast()) {
            m.add(new InExMoney(c.getInt(0), c.getInt(1), c.getString(2), c.getInt(3), c.getString(4)));
            c.moveToNext();
        }
        sql.close();

        return m;
    }
}
