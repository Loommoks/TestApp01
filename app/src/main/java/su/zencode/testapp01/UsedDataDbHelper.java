package su.zencode.testapp01;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class UsedDataDbHelper {

    public static List<UserData> getTable(SQLiteOpenHelper sqLiteOpenHelper) {
        List<UserData> result = new ArrayList<>();

        try {
            SQLiteDatabase db = sqLiteOpenHelper.getReadableDatabase();
            Cursor cursor = db.query("CLIENTS",
                    new String[] {"_id","SURNAME","NAME"},
                    null,null,null,null,null);

            if(cursor.moveToFirst()) {
                /** Получаем данные клиента из курсора*/
                int clientId = cursor.getInt(0);
                String clientSurname = cursor.getString(1);
                String clientName = cursor.getString(2);

                UserData newUser = new UserData(
                        clientName,
                        "",
                        clientSurname );

                result.add(newUser);

            }
            while (cursor.moveToNext()) {
                int clientId = cursor.getInt(0);
                String clientSurname = cursor.getString(1);
                String clientName = cursor.getString(2);

                UserData newUser = new UserData(
                        clientName,
                        "",
                        clientSurname );

                result.add(newUser);
            }
            cursor.close();
            db.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void addUserToBD(SQLiteOpenHelper sqLiteOpenHelper, UserData user) {
        SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();
        TestAppDatabaseHelper.insertClient(db,user.getSurname(),user.getName());
        db.close();
    }

}
