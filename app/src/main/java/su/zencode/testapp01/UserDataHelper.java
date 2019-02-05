package su.zencode.testapp01;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class UserDataHelper {

    private final static String FILE_NAME = "test.txt";

    private Context mContext;
    private SQLiteOpenHelper mSQLiteOpenHelper;

    private ArrayList<UserData> mUsers;

    public UserDataHelper(Context context) {
        this.mContext = context;
        mSQLiteOpenHelper = new TestAppDatabaseHelper(mContext);
    }


    public void saveUserToTxt(UserData user) {

        try {
            FileOutputStream fos = mContext.getApplicationContext().openFileOutput(FILE_NAME,mContext.MODE_PRIVATE);
            OutputStreamWriter outputWriter = new OutputStreamWriter(fos);
            String userDataString = userToStringConverter(user);
            outputWriter.write(userDataString);
            outputWriter.close();
            Toast.makeText(mContext, "File saved", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public UserData loadUserFromTxt() {
        String s=null;

        try {
            FileInputStream fis = mContext.getApplicationContext().openFileInput(FILE_NAME);
            InputStreamReader inputReader = new InputStreamReader(fis);

            char[] inputBuffer= new char[256];
            s="";
            int charRead;

            while ((charRead=inputReader.read(inputBuffer))>0) {
                // char to string conversion
                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                s +=readstring;
            }
            inputReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<String> userDataList = convertStringToList(s);
        UserData user = generateUser(userDataList);
        return user;
    }

    public static String convertListToString (ArrayList<String> input) {

        //String output = String.join(";",input);
        StringBuilder sbString = new StringBuilder();
        String separator = ";";

        for (int i = 0; i < input.size(); i++) {
            sbString.append(input.get(i));
            if (i != input.size() - 1)
                sbString.append(separator);
        }

        return sbString.toString();
    }

    public static ArrayList<String> convertStringToList (String input) {
        ArrayList<String> output = new ArrayList<>();

        String[] separated = input.split(";");

        for (int i = 0; i < separated.length; i++) {
            output.add(separated[i]);
        }

        return output;
    }

    public UserData generateUser(ArrayList<String> userData) {
        UserData user = null;
        if (userData.size() == 3) {
            user = new UserData(userData.get(0),userData.get(1),userData.get(2));
        } else Toast.makeText(mContext,"incorrect data",Toast.LENGTH_SHORT).show();
        return user;
    }

    public String userToStringConverter(UserData user) {
        String result = user.getName() + ";" + user.getPatro()+ ";" + user.getSurname();
        return result;
    }

    public ArrayList<String> getTable() {
        ArrayList<String> result = new ArrayList<>();
        //String result = "error";
        //SQLiteOpenHelper sqLiteOpenHelper = new TestAppDatabaseHelper(mContext);
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
