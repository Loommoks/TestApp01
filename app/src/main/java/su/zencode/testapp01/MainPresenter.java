package su.zencode.testapp01;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

public class MainPresenter implements ImvpContract.Presenter {

    private static final String TAG = ".MainPresenter";

    private ImvpContract.View mView;
    private ImvpContract.Model mModel;

    private ArrayList<String> transferData;

    public MainPresenter(ImvpContract.View mView) {
        this.mView = mView;
        this.mModel = new MainModel();
    }

    @Override
    public void onSaveTxtButtonClicked() {
        transferData = mView.getDataToTransfer();
        String stringTranferData = TxtDataHelper.convertListToString(transferData);
        Context context = mView.getContext();
        mModel.saveTxtUserData(context,stringTranferData);
        Log.d(TAG,"onSaveTxtButtonClicked()");
        /** Реакция на кнопку saveTXT тут. */

    }

    @Override
    public void onSaveDbButtonClicked() {
        Context context = mView.getContext();
        String result = mModel.loadTxtUserData(context);
        mView.showTransfer(result);
        Log.d(TAG,"onSaveDbButtonClicked()");
        /** Реакция на кнопку saveDb тут. */

    }

    @Override
    public void onDestroy() {

    }
}
