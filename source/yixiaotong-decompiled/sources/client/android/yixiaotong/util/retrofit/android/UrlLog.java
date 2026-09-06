package client.android.yixiaotong.util.retrofit.android;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class UrlLog {
    public static final String FORMATDATE = "yyyy-MM-dd";
    private static DateFormat formatter = null;
    private static String path = "/mnt/sdcard/log/";

    public static void saveCatchInfo2File(String str) {
    }

    private static String readFromXML() {
        String str = path + "url-log" + formatDate(System.currentTimeMillis()) + ".txt";
        StringBuilder sb = new StringBuilder();
        File file = new File(str);
        if (file.exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                }
                bufferedReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return sb.toString();
    }

    public static String formatDate(long j) {
        return dateToString(new Date(j), "yyyy-MM-dd");
    }

    public static String dateToString(Date date, String str) {
        return new SimpleDateFormat(str).format(date);
    }
}
