package su.zencode.testapp01;

import android.util.Log;

import java.util.ArrayList;

public class MainPresenter implements ImvpContract.Presenter {

    private static final String TAG = ".MainPresenter";

    private ImvpContract.View mView;
    private UserDataHelper mUserDataHelper;

    public MainPresenter(ImvpContract.View mView) {
        this.mView = mView;
        mUserDataHelper = new UserDataHelper(mView.getContext());
    }

    /** Реакция на кнопку saveTXT тут. */
    @Override
    public void onSaveTxtButtonClicked() {

        UserData user = getUser();
        mUserDataHelper.saveUserToTxt(user);

        Log.d(TAG,"onSaveTxtButtonClicked()");

    }

    /** Реакция на кнопку saveDb тут. */
    @Override
    public void onSaveDbButtonClicked() {

        UserData userData = mUserDataHelper.loadUserFromTxt();
        mUserDataHelper.addUserToBD(userData);

        ArrayList<String> result = mUserDataHelper.getTable();
        updateDebugView(result.toString());

        Log.d(TAG,"onSaveDbButtonClicked()");


    }

    public UserData getUser() {
        UserData user = new UserData(
                mView.getUserName(),
                mView.getUserPatro(),
                mView.getUserSurname() );

        return user;
    }

    @Override
    public void updateDebugView(String data) {
        mView.showTransfer(data);
    }


    @Override
    public void onDestroy() {

    }
}
