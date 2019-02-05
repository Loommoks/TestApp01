package su.zencode.testapp01;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class UserDataHelper {

    private final static String FILE_NAME = "test.txt";

    private Context mContext;
    private SQLiteOpenHelper mSQLiteOpenHelper;


    public UserDataHelper(Context context) {
        this.mContext = context;
        mSQLiteOpenHelper = new TestAppDatabaseHelper(mContext);
    }


    public void saveUserToTxt(UserData user) {

        UserDataTextHelper.saveUserToTxt(mContext,FILE_NAME,user);

    }


    public UserData loadUserFromTxt() {

        UserData user = UserDataTextHelper.loadUserFromTxt(mContext,FILE_NAME);

        return user;
    }


    public ArrayList<String> getTable() {
        ArrayList<String> result = new ArrayList<>();

        try {
            SQLiteDatabase db = mSQLiteOpenHelper.getReadableDatabase();
            Cursor cursor = db.query("CLIENTS",
                    new String[] {"_id","SURNAME","NAME"},
                    null,null,null,null,null);

            if(cursor.moveToFirst()) {
                /** Получаем данные клиента из курсора*/
                int clientId = cursor.getInt(0);
                String clientSurname = cursor.getString(1);
                String clientName = cursor.getString(2);
                result.add(Integer.toString(clientId)+ ";" + clientSurname+ ";" +clientName+"\n");

            }
            while (cursor.moveToNext()) {
                int clientId = cursor.getInt(0);
                String clientSurname = cursor.getString(1);
                String clientName = cursor.getString(2);
                result.add(Integer.toString(clientId)+ ";" + clientSurname+ ";" +clientName+"\n");
            }
            cursor.close();
            db.close();
        } catch (SQLException e) {
            Toast toast = Toast.makeText(mContext,"Database unavailable",Toast.LENGTH_SHORT);
            toast.show();
        }
        return result;
    }

    public void addUserToBD(UserData user) {
        SQLiteDatabase db = mSQLiteOpenHelper.getWritableDatabase();
        TestAppDatabaseHelper.insertClient(db,user.getSurname(),user.getName());
        db.close();
    }

}
