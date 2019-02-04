package su.zencode.testapp01;

import java.util.ArrayList;
import java.util.LinkedList;

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
        //transferData = mModel.loadMessage();
        transferData = mView.getDataToTransfer();
        /*String debugTransferData;
        for (int i = 0; i < transferData.size(); i++) {
            mView.showTransfer(transferData.get(i));
        }*/
        mView.showTransfer(TxtDataHelper.convertListToString(transferData));
        /** Реакция на кнопку saveTXT тут. */

    }

    @Override
    public void onSaveDbButtonClicked() {
        /** Реакция на кнопку saveDb тут. */

    }

    @Override
    public void onDestroy() {

    }
}
