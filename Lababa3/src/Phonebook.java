import java.io.*;

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
        String str2 = getTex(PATH_WRITE);
        System.out.println(str2);
        writeText(PATH_WRITE, str);
        str2 = getTex(PATH_WRITE);
        System.out.println(str2);
    }

    private static void writeText(String path, String text) {
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            try {
                out.println(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
