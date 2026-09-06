package com.yfanads.android.libs.thirdpart.lottie.network;

import android.content.Context;
import androidx.core.util.Pair;
import com.stub.StubApp;
import com.yfanads.android.libs.thirdpart.lottie.L;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
class NetworkCache {
    private final Context appContext;
    private final String url;

    public NetworkCache(Context context, String str) {
        this.appContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.url = str;
    }

    private static String filenameForUrl(String str, FileExtension fileExtension, boolean z) {
        return "lottie_cache_" + str.replaceAll("\\W+", "") + (z ? fileExtension.extension : fileExtension.tempExtension());
    }

    private File getCachedFile(String str) {
        File file = new File(this.appContext.getCacheDir(), filenameForUrl(str, FileExtension.Json, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(this.appContext.getCacheDir(), filenameForUrl(str, FileExtension.Zip, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    public Pair<FileExtension, InputStream> fetch() {
        try {
            File cachedFile = getCachedFile(this.url);
            if (cachedFile == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(cachedFile);
            FileExtension fileExtension = cachedFile.getAbsolutePath().endsWith(".zip") ? FileExtension.Zip : FileExtension.Json;
            L.debug("Cache hit for " + this.url + " at " + cachedFile.getAbsolutePath());
            return new Pair<>(fileExtension, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    public void renameTempFile(FileExtension fileExtension) {
        File file = new File(this.appContext.getCacheDir(), filenameForUrl(this.url, fileExtension, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean zRenameTo = file.renameTo(file2);
        L.debug("Copying temp file to real file (" + file2 + ")");
        if (zRenameTo) {
            return;
        }
        L.warn("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
    }

    public File writeTempCacheFile(InputStream inputStream, FileExtension fileExtension) throws IOException {
        File file = new File(this.appContext.getCacheDir(), filenameForUrl(this.url, fileExtension, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        inputStream.close();
                        return file;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            inputStream.close();
            throw th2;
        }
    }
}
