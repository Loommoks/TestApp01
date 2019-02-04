package su.zencode.testapp01;

import android.util.Log;

public class MainModel implements ImvpContract.Model {

    private static final String TAG = ".MainModel";

    @Override
    public void saveUserData() {
        Log.d(TAG,"saveUserData()");
        /** Сохранять данные ФИО будем здесь. */

    }

    @Override
    public String loadData() {
        Log.d(TAG,"loadData()");
        /** Загружать и вызывать парсинг с .тхт будем тут. */
        return null;
    }

    @Override
    public String loadMessage() {
        Log.d(TAG,"loadMessage()");
        /** Работать с .тхт или БД будем тут. */
        return "Default loadMessage() string";
    }
}
