import java.io.*;

/**
 * Created by valer on 29.04.2016.
 */
public class Phonebook {

    private static final String[] pat = {
            "\\s{1,}", "",
            "@{2,}", "@",
            "\\.{2,}", ".",
            "-", "",
            "(\\d)(\\d{2,3})(\\d{3})(\\d{2})(\\d{2})", "$1 ($2) $3-$4-$5",
            "([A-Z])", " $1"
    };

    private static final String PATH_READ = "D://text1.txt";
    private static final String PATH_WRITE = "D://text2.txt";

    public static void main(String args[]) {
        System.out.println("Hi");
        String str = getTex(PATH_READ);
        System.out.println(str);
        String res;
        res = changeText(str);
        System.out.println(res);
        writeText(PATH_WRITE, res);
    }

    private static String changeText(String str) {
        String res=str;
        for(int i=0;i<pat.length-1;i+=2){
            res=res.replaceAll(pat[i],pat[i+1]);
        }
        return res;
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
