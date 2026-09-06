package client.android.yixiaotong.util.android;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class LogUtils {
    public static void saveSDcardLog(Context context, String str) {
        File file;
        String str2 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        if (Environment.getExternalStorageState().equals("mounted")) {
            file = new File(Environment.getExternalStorageDirectory().getPath() + "/YWQ");
        } else {
            file = new File(Environment.getDataDirectory().getPath() + "/YWQ");
        }
        try {
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, str2 + ".txt");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            StringBuffer stringBuffer = new StringBuffer("\n\n");
            stringBuffer.append(str);
            stringBuffer.append("\n\n");
            FileOutputStream fileOutputStream = new FileOutputStream(file2, true);
            fileOutputStream.write(stringBuffer.toString().getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
