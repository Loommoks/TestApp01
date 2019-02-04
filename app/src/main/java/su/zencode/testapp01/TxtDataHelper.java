package su.zencode.testapp01;

import java.util.ArrayList;

public class TxtDataHelper {

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
