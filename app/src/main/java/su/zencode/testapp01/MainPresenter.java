package su.zencode.testapp01;

import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class MainPresenter implements ImvpContract.Presenter {

    private static final String TAG = ".MainPresenter";

    private ImvpContract.View mView;
    private UserDataHelper mUserDataHelper;
    private SQLiteOpenHelper mSQLiteOpenHelper;

    private ArrayList<String> transferData;

    public MainPresenter(ImvpContract.View mView) {
        this.mView = mView;
        mUserDataHelper = new UserDataHelper(mView.getContext());
        //mSQLiteOpenHelper = new TestAppDatabaseHelper(mView.getContext());
    }

    @Override
    public void onSaveTxtButtonClicked() {
        transferData = mView.getUserData();
        //String stringTranferData = UserDataHelper.convertListToString(transferData);
        //Context context = mView.getContext();
        UserData newUser = mUserDataHelper.generateUser(transferData);
        mUserDataHelper.saveUserToTxt(newUser);
        //mModel.saveTxtUserData(context,stringTranferData);


        Log.d(TAG,"onSaveTxtButtonClicked()");
        /** Реакция на кнопку saveTXT тут. */

    }

    @Override
    public void onSaveDbButtonClicked() {
        //ToDo Пока заглушка для проверки записи в файл
        ArrayList<String> result = mUserDataHelper.getTable();
        updateDebugView(result.toString());
        UserData userData = mUserDataHelper.loadUserFromTxt();
        mUserDataHelper.addUserToBD(userData);
        //String result = mUserDataHelper.userToStringConverter(userData);
        //mView.showTransfer(result);
        Log.d(TAG,"onSaveDbButtonClicked()");
        /** Реакция на кнопку saveDb тут. */

    }

    @Override
    public void updateDebugView(String data) {
        mView.showTransfer(data);
    }


    @Override
    public void onDestroy() {

    }
}
