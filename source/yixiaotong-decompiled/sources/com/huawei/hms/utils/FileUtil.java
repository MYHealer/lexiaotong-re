package com.huawei.hms.utils;

import android.content.Context;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.openalliance.ad.utils.u;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class FileUtil {
    public static final String LOCAL_REPORT_FILE = "hms/HwMobileServiceReport.txt";
    public static final String LOCAL_REPORT_FILE_CONFIG = "hms/config.txt";
    public static final long LOCAL_REPORT_FILE_MAX_SIZE = 10240;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f4415a;
    public static ScheduledExecutorService b = Executors.newSingleThreadScheduledExecutor();

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ File f4416a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;

        public a(File file, long j, String str) {
            this.f4416a = file;
            this.b = j;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            File file = this.f4416a;
            if (file == null) {
                HMSLog.e(u.Code, "In writeFile Failed to get local file.");
                return;
            }
            File parentFile = file.getParentFile();
            if (parentFile == null || !(parentFile.mkdirs() || parentFile.isDirectory())) {
                HMSLog.e(u.Code, "In writeFile, Failed to create directory.");
                return;
            }
            RandomAccessFile randomAccessFile = null;
            try {
                try {
                    long length = this.f4416a.length();
                    if (length > this.b) {
                        String canonicalPath = this.f4416a.getCanonicalPath();
                        if (!this.f4416a.delete()) {
                            HMSLog.e(u.Code, "last file delete failed.");
                        }
                        randomAccessFile = new RandomAccessFile(new File(canonicalPath), "rw");
                    } else {
                        RandomAccessFile randomAccessFile2 = new RandomAccessFile(this.f4416a, "rw");
                        try {
                            randomAccessFile2.seek(length);
                            randomAccessFile = randomAccessFile2;
                        } catch (IOException e) {
                            e = e;
                            randomAccessFile = randomAccessFile2;
                            HMSLog.e(u.Code, "writeFile exception:", e);
                        } catch (Throwable th) {
                            th = th;
                            randomAccessFile = randomAccessFile2;
                            IOUtils.closeQuietly(randomAccessFile);
                            throw th;
                        }
                    }
                    randomAccessFile.writeBytes(this.c + System.getProperty("line.separator"));
                } catch (IOException e2) {
                    e = e2;
                }
                IOUtils.closeQuietly(randomAccessFile);
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static boolean verifyHash(String str, File file) throws Throwable {
        byte[] bArrDigest = SHA256.digest(file);
        return bArrDigest != null && HEX.encodeHexString(bArrDigest, true).equalsIgnoreCase(str);
    }

    public static void writeFile(File file, String str, long j) {
        b.execute(new a(file, j, str));
    }

    public static void writeFileReport(Context context, File file, File file2, String str, long j, int i) {
        if (file != null && file.isFile() && file.exists()) {
            if (!f4415a) {
                if (file2 != null && file2.exists() && !file2.delete()) {
                    HMSLog.e(u.Code, "file delete failed.");
                }
                f4415a = true;
            }
            writeFile(file2, str + "|" + j + "|" + i, LOCAL_REPORT_FILE_MAX_SIZE);
        }
    }
}
