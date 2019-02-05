package su.zencode.testapp01;

import android.content.Context;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class UserDataTextHelper {

    public static void saveUserToTxt(Context context, String fileName, UserData user) {

        try {
            FileOutputStream fos = context.getApplicationContext().openFileOutput(fileName,context.MODE_PRIVATE);
            OutputStreamWriter outputWriter = new OutputStreamWriter(fos);
            String userDataString = userToStringConverter(user);
            outputWriter.write(userDataString);
            outputWriter.close();
            Toast.makeText(context, "File saved", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static UserData loadUserFromTxt(Context context, String fileName) {
        /** Делегировать */
        String s=null;

        try {
            FileInputStream fis = context.getApplicationContext().openFileInput(fileName);
            InputStreamReader inputReader = new InputStreamReader(fis);

            char[] inputBuffer= new char[256];
            s="";
            int charRead;

            while ((charRead=inputReader.read(inputBuffer))>0) {
                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                s +=readstring;
            }
            inputReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<String> userDataList = convertStringToList(s);
        UserData user = new UserData(
                userDataList.get(0).toString(),
                userDataList.get(1).toString(),
                userDataList.get(2).toString()
        );
        return user;
    }

    public static String userToStringConverter(UserData user) {
        String result = user.getName() + ";" + user.getPatro()+ ";" + user.getSurname();
        return result;
    }

    public static ArrayList<String> convertStringToList (String input) {
        ArrayList<String> output = new ArrayList<>();

        String[] separated = input.split(";");

        for (int i = 0; i < separated.length; i++) {
            output.add(separated[i]);
        }

        return output;
    }

}
