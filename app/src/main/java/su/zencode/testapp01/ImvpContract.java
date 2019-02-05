package su.zencode.testapp01;

import android.content.Context;

import java.util.ArrayList;

public interface ImvpContract {

    interface View {
        void showTransfer(String input);
        Context getContext();
        ArrayList<String> getUserData();
        String getUserName();
        String getUserPatro();
        String getUserSurname();
    }

    interface Presenter {
        void onSaveTxtButtonClicked();
        void onSaveDbButtonClicked();
        void updateDebugView(String data);
        void onDestroy();
    }
}
