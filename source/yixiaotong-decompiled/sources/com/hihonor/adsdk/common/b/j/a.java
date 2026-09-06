package com.hihonor.adsdk.common.b.j;

import android.text.TextUtils;
import android.util.Log;
import com.hihonor.adsdk.common.f.m;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    public static final String hnadsa = "LogFileUtils";
    private static final String hnadsb = "HnAdsLog";
    private static final int hnadsc = 4194304;
    private static final int hnadsd = 50;
    private static String hnadse;
    private static final SimpleDateFormat hnadsf = com.hihonor.adsdk.common.safe.b.hnadsa("yyyyMMdd");
    private static String hnadsg;

    private static String hnadsa() {
        try {
            if (com.hihonor.adsdk.common.a.hnadsa().hnadsb() == null) {
                Log.i(hnadsa, "get disk log folder path fail,but context is null");
                return null;
            }
            if (hnadse == null) {
                hnadse = com.hihonor.adsdk.common.a.hnadsa().hnadsb().getExternalCacheDir().getCanonicalPath();
            }
            return hnadse + File.separatorChar + "logs";
        } catch (Exception e) {
            Log.e(hnadsa, "getLogFolder, get disk log folder path exception, Exception: " + e.getMessage());
            if (hnadsg == null) {
                hnadsg = File.separatorChar + "sdcard" + File.separatorChar + "Android" + File.separatorChar + "data" + File.separatorChar + com.hihonor.adsdk.common.a.hnadsa().hnadsb().getPackageName() + File.separatorChar + "logs";
            }
            return hnadsg;
        }
    }

    public static boolean hnadsa(String... strArr) throws Throwable {
        String strHnadsa = hnadsa();
        if (strHnadsa != null && !TextUtils.isEmpty(strHnadsa)) {
            FileWriter fileWriter = null;
            try {
                try {
                    File fileHnadsa = hnadsa(strHnadsa);
                    if (fileHnadsa == null) {
                        Log.w(hnadsa, "Get log file is null, unable write log to disk.");
                        m.hnadsa(null);
                        return false;
                    }
                    FileWriter fileWriter2 = new FileWriter(fileHnadsa, true);
                    try {
                        for (String str : strArr) {
                            hnadsa(fileWriter2, str);
                        }
                        fileWriter2.flush();
                        m.hnadsa(fileWriter2);
                        return true;
                    } catch (Exception e) {
                        e = e;
                        fileWriter = fileWriter2;
                        Log.w(hnadsa, "writeLogToFile, writer log to disk fail, Exception: " + e.getMessage());
                        m.hnadsa(fileWriter);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileWriter = fileWriter2;
                        m.hnadsa(fileWriter);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            Log.w(hnadsa, "Folder path is empty.");
            return false;
        }
    }

    private static void hnadsa(FileWriter fileWriter, String str) throws IOException {
        fileWriter.append((CharSequence) str);
    }

    private static File hnadsa(String str) {
        File file = new File(str);
        SimpleDateFormat simpleDateFormat = hnadsf;
        String str2 = simpleDateFormat == null ? "" : simpleDateFormat.format(new Date());
        int i = 0;
        File file2 = new File(file, String.format("%s_%s_%s.txt", hnadsb, str2, 0));
        if (!file.exists()) {
            Log.w(hnadsa, "getLogFile#Log folder is not found!");
            if (file.mkdirs()) {
                return file2;
            }
            return null;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            Arrays.sort(fileArrListFiles, new Comparator() { // from class: com.hihonor.adsdk.common.b.j.a$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return a.hnadsa((File) obj, (File) obj2);
                }
            });
            hnadsa(fileArrListFiles);
            while (file2.exists()) {
                if (file2.length() < 4194304) {
                    Log.i(hnadsa, "New file writable.");
                    break;
                }
                i++;
                file2 = new File(file, String.format("%s_%s_%s.txt", hnadsb, str2, Integer.valueOf(i)));
            }
        }
        return file2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int hnadsa(File file, File file2) {
        long jLastModified = file.lastModified() - file2.lastModified();
        if (jLastModified > 0) {
            return -1;
        }
        return jLastModified == 0 ? 0 : 1;
    }

    private static void hnadsa(File[] fileArr) {
        int length = fileArr.length;
        File file = fileArr[length - 1];
        if (length >= 50) {
            Log.i(hnadsa, "delete first create file. current logs folder file counts is " + length);
            if (file == null || !file.delete()) {
                Log.w(hnadsa, "delete first create file fail.");
            }
        }
    }
}
