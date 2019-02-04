package su.zencode.testapp01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ImvpContract.View {

    private static final String TAG = ".MainActivity";

    private ImvpContract.Presenter mPresenter;

    private Button mSaveTxtButton;
    private Button mSaveDbButton;

    private TextView mTextView;
    private EditText mNameEditText;
    private EditText mSurnameEditText;
    private EditText mPatroEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        
    }

    @Override
    public void showTransfer(String input) {

    }
}
