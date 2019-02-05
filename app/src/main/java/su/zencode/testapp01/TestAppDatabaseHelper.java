package su.zencode.testapp01;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TestAppDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "TestApp01";
    private static final int DB_VERSION = 1;

    public TestAppDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE CLIENTS (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "SURNAME TEXT, "
                + "NAME TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static void insertClient(SQLiteDatabase db, String surname,
                                     String name) {
        ContentValues clientValues = new ContentValues();
        clientValues.put("SURNAME", surname);
        clientValues.put("NAME", name);
        db.insert("CLIENTS", null, clientValues);
    }
}
