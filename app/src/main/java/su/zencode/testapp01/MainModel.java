package su.zencode.testapp01;

import android.content.Context;
import android.util.Log;

public class MainModel implements ImvpContract.Model {

    private static final String TAG = ".MainModel";

    @Override
    public void saveTxtUserData(Context context, String input) {
        TxtDataHelper.saveText(context, input);
        Log.d(TAG,"saveUserData()");
        /** Сохранять данные ФИО будем здесь. */

    }

    @Override
    public String loadTxtUserData(Context context) {
        String result = TxtDataHelper.loadText(context);
        return result;
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
