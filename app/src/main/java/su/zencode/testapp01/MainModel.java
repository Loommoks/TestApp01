package su.zencode.testapp01;

import android.util.Log;

public class MainModel implements ImvpContract.Model {

    private static final String TAG = ".MainModel";

    @Override
    public void saveUserData() {
        Log.d(TAG,"saveUserData()");
    }

    @Override
    public String loadData() {
        Log.d(TAG,"loadData()");
        return null;
    }

    @Override
    public String loadMessage() {
        Log.d(TAG,"loadMessage()");
        return null;
    }
}
