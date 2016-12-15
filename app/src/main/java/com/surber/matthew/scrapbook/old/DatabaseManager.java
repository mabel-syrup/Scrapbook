package com.surber.matthew.scrapbook.old;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by wo1624bu on 10/25/16.
 */
public class DatabaseManager {


    private Context context;
    private SQLHelper helper;
    private SQLiteDatabase db;
    protected static final String DB_NAME = "ideas.db";

    protected static final int DB_VERSION = 1;
    protected static final String DB_TABLE = "ideas";

    private static final String INT_COL = "_id";
    protected static final String IMAGE_COL = "picture_image";
    protected static final String TEXT_COL = "note_text";
    protected static final String TAG_COL = "tags";
    protected static final String TIME_COL = "time";

    protected static final String DB_TAG = "DBManager";
    protected static final String SQL_TAG = "SQLHelper";

    public DatabaseManager(Context c) {
        this.context = c;
        helper = new SQLHelper(c);
        this.db = helper.getWritableDatabase();
    }

    //Method:
    //Cursor cursor = sqLiteDatabase.query(tableName, tableColumns, whereClause, whereArgs, groupBy, having, orderBy);
    //tableName      = name of table
    //tableColumns   = array of column names  (String[] cols)
    //whereClause    = logical statement  (INT_COL > ?)
    //whereArgs      = value to fill in for ? in clause  (5)
    //groupBy        = ??
    //having         = ??
    //orderBy        = arg to order the returned values by  (TEXT_COL)


    //TODO: set up database methods
    public void close () {
        helper.close();
    }

    public Cursor getCursorAll() {
        Cursor cursor = db.query(DB_TABLE, null, null, null, null, null, TIME_COL);
        return cursor;
    }

    //Allows the use of the method without requiring the method calling it needing to parse the string first.
    public Cursor getIdeasByTag(String tags) {
        String[] mTags = tags.split("|");
        ArrayList<String> formattedTags = new ArrayList<>();
        for (String tag: mTags) {
            formattedTags.add("*" + tag + "*");
        }
        String[] outTags = (String[]) formattedTags.toArray();
        return getIdeasByTag(outTags);
    }

    private Cursor getIdeasByTag(String[] tags) {
        String selection = DB_TAG;
        for(int i = 0; i < tags.length; i++) {
            selection += " LIKE ? ";
            //If there's still more to go, add an "AND".
            if(i != tags.length - 1) selection += " AND ";
        }
        //Get all the items that have all the listed tags in the tags string.
        Cursor cursor = db.query(DB_TABLE, null, selection, tags, null, null, TIME_COL);
        return cursor;
    }


    public class SQLHelper extends SQLiteOpenHelper {
        public SQLHelper(Context c){
            super(c, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            //Table has 5 columns.
            // Primary key autoincrements
            // IMAGE_COL stores a string of the image Uri
            // TEXT_COL stores a string of the note text
            // TAG_COL stores a string of the tags
            // DATE_COL stores a string of the unix time.

            String createTable = "CREATE TABLE " + DB_TABLE +
                    " (" + INT_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, " + IMAGE_COL + " TEXT, " + TEXT_COL +" TEXT, " + TAG_COL +" TEXT, " + TIME_COL + " TEXT);"  ;
            Log.d(SQL_TAG, createTable);
            db.execSQL(createTable);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
            onCreate(db);
            Log.w(SQL_TAG, "Upgrade table - drop and recreate it");
        }
    }

}
