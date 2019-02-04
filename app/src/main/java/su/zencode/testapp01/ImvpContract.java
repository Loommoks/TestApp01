package su.zencode.testapp01;

import java.util.ArrayList;
import java.util.LinkedList;

public interface ImvpContract {

    interface Model {
        void saveUserData();
        String loadData();
        String loadMessage();
    }

    interface View {
        void showTransfer(String input);
        ArrayList<String> getDataToTransfer();
    }

    interface Presenter {
        void onSaveTxtButtonClicked();
        void onSaveDbButtonClicked();
        void onDestroy();
    }
}
