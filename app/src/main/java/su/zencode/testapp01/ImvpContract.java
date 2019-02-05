package su.zencode.testapp01;

import android.content.Context;

import java.util.ArrayList;

public interface ImvpContract {

    interface View {
        void showTransfer(String input);
        Context getContext();
        ArrayList<String> getUserData();
    }

    interface Presenter {
        void onSaveTxtButtonClicked();
        void onSaveDbButtonClicked();
        void onDestroy();
    }
}
