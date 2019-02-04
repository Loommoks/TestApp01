package su.zencode.testapp01;

public class MainPresenter implements ImvpContract.Presenter {

    private static final String TAG = ".MainPresenter";

    private ImvpContract.View mView;
    private ImvpContract.Model mModel;

    private String message;

    public MainPresenter(ImvpContract.View mView) {
        this.mView = mView;
        this.mModel = new MainModel();
    }

    @Override
    public void onButtonWasClicked() {
        message = mModel.loadMessage();
        mView.showTransfer(message);
        /** Реакция на кнопку будет тут. */

    }

    @Override
    public void onDestroy() {

    }
}
