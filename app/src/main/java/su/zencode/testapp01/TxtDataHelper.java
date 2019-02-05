package su.zencode.testapp01;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class TxtDataHelper {

    private final static String FILE_NAME = "test.txt";

    public static void saveText(Context context, String input) {

        try {
            FileOutputStream fos = context.getApplicationContext().openFileOutput(FILE_NAME,context.MODE_PRIVATE);
            OutputStreamWriter outputWriter = new OutputStreamWriter(fos);
            outputWriter.write(input);
            outputWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String loadText(Context context) {
        String s=null;

        try {
            FileInputStream fis = context.getApplicationContext().openFileInput(FILE_NAME);
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
        return s;
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

}
