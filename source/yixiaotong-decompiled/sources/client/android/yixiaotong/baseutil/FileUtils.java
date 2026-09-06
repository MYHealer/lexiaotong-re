package client.android.yixiaotong.baseutil;

import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class FileUtils {
    public static void makeNoMediaFile(File file) {
        try {
            File file2 = new File(file, ".nomedia");
            if (file2.exists()) {
                return;
            }
            file2.createNewFile();
        } catch (Exception unused) {
        }
    }
}
