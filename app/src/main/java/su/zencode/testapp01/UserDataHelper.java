package su.zencode.testapp01;

import android.content.Context;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class UserDataHelper {

    private final static String FILE_NAME = "test.txt";

    private Context mContext;

    private ArrayList<UserData> mUsers;

    public UserDataHelper(Context context) {
        this.mContext = context;
    }


    public void saveUserToTxt(UserData user) {

        try {
            FileOutputStream fos = mContext.getApplicationContext().openFileOutput(FILE_NAME,mContext.MODE_PRIVATE);
            OutputStreamWriter outputWriter = new OutputStreamWriter(fos);
            String userDataString = userToStringConverter(user);
            outputWriter.write(userDataString);
            outputWriter.close();
            Toast.makeText(mContext, "File saved", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public UserData loadUserFromTxt() {
        String s=null;

        try {
            FileInputStream fis = mContext.getApplicationContext().openFileInput(FILE_NAME);
            InputStreamReader inputReader = new InputStreamReader(fis);

            char[] inputBuffer= new char[256];
            s="";
            int charRead;

            while ((charRead=inputReader.read(inputBuffer))>0) {
                // char to string conversion
                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                s +=readstring;
            }
            inputReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<String> userDataList = convertStringToList(s);
        UserData user = generateUser(userDataList);
        return user;
    }

    public static String convertListToString (ArrayList<String> input) {

        //String output = String.join(";",input);
        StringBuilder sbString = new StringBuilder();
        String separator = ";";

        for (int i = 0; i < input.size(); i++) {
            sbString.append(input.get(i));
            if (i != input.size() - 1)
                sbString.append(separator);
        }

        return sbString.toString();
    }

    public static ArrayList<String> convertStringToList (String input) {
        ArrayList<String> output = new ArrayList<>();

        String[] separated = input.split(";");

        for (int i = 0; i < separated.length; i++) {
            output.add(separated[i]);
        }

        return output;
    }

    public UserData generateUser(ArrayList<String> userData) {
        UserData user = null;
        if (userData.size() == 3) {
            user = new UserData(userData.get(0),userData.get(1),userData.get(2));
        } else Toast.makeText(mContext,"incorrect data",Toast.LENGTH_SHORT).show();
        return user;
    }

    public String userToStringConverter(UserData user) {
        String result = user.getName() + ";" + user.getPatro()+ ";" + user.getSurname();
        return result;
    }

}
