package su.zencode.testapp01;

import android.content.Context;

import java.util.ArrayList;
import java.util.LinkedList;

public interface ImvpContract {

    interface Model {
        void saveTxtUserData(Context context, String input);
        String loadTxtUserData(Context context);
        String loadData();
        String loadMessage();
    }

    interface View {
        void showTransfer(String input);
        void printTransfer(String input);
        Context getContext();
        ArrayList<String> getDataToTransfer();
    }

    interface Presenter {
        void onSaveTxtButtonClicked();
        void onSaveDbButtonClicked();
        void onDestroy();
    }
}
