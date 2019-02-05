package su.zencode.testapp01;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

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


    public List<UserData> getTable() {

        List<UserData> table = UsedDataDbHelper.getTable(mSQLiteOpenHelper);

        return table;
    }

    public void addUserToBD(UserData user) {

        UsedDataDbHelper.addUserToBD(mSQLiteOpenHelper, user);

    }

}
