package su.zencode.testapp01;

public interface ImvpContract {

    interface Model {
        void saveUserData();
        String loadData();
        String loadMessage();
    }

    interface View {
        void showText();
    }

    interface Presenter {
        void onButtonWasClicked();
        void onDestroy();
    }
}
