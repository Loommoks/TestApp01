package su.zencode.testapp01;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements ImvpContract.View {

    private static final String TAG = ".MainActivity";

    private ImvpContract.Presenter mPresenter;

    private Button mSaveTxtButton;
    private Button mSaveDbButton;

    private TextView mDebugTextView;
    private EditText mNameEditText;
    private EditText mSurnameEditText;
    private EditText mPatroEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new MainPresenter(this);

        mDebugTextView = findViewById(R.id.debugTextView);
        mNameEditText = findViewById(R.id.nameEditText);
        mPatroEditText = findViewById(R.id.patroEditText);
        mSurnameEditText = findViewById(R.id.surnameEditText);

        mSaveTxtButton = findViewById(R.id.saveClientButton);
        mSaveTxtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onSaveTxtButtonClicked();
            }
        });

        mSaveDbButton = findViewById(R.id.saveDbButton);
        mSaveDbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onSaveDbButtonClicked();
            }
        });

        Log.d(TAG,"onCreate()");
    }

    @Override
    public void showTransfer(String input) {
        //mDebugTextView.setText(input);
        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
        Log.d(TAG,"showTransfer()");
    }

    @Override
    public void printTransfer(String input) {
        mDebugTextView.setText(input);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public ArrayList<String> getDataToTransfer() {
        //ToDo должно быть в локальной реализации View<->Presenter
        ArrayList<String> output = new ArrayList<>();
        output.add(mNameEditText.getText().toString());
        output.add(mPatroEditText.getText().toString());
        output.add(mSurnameEditText.getText().toString());
        return output;
    }

}
