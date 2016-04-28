import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by valer on 29.04.2016.
 */
public class Phonebook {

    private static final String PATH_READ = "D://text1.txt";
    private static final String PATH_WRITE = "D://text2.txt";

    public static void main(String args[]) {
        System.out.println("Hello!");
        String str = getTex(PATH_READ);
        System.out.println(str);
    }

        public static String getTex(String path) {
            StringBuilder str = new StringBuilder();
            try {
                BufferedReader in = new BufferedReader(new FileReader(path));
                String s;
                while ((s = in.readLine()) != null) {
                    str.append(s + " \n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str.toString();
        }

}
