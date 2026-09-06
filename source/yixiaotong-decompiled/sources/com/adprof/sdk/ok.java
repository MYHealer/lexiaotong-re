package com.adprof.sdk;

import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ok implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1348a;
    public final /* synthetic */ String b;

    public ok(String str, String str2) {
        this.f1348a = str;
        this.b = str2;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0056 A[ORIG_RETURN, RETURN] */
    @Override // java.lang.Runnable
    public void run() {
        FileWriter fileWriter;
        try {
            pk.a();
            File file = pk.f591a;
            try {
                if (file == null) {
                    return;
                }
                if (file.exists() && pk.f591a.length() > CacheDataSink.DEFAULT_FRAGMENT_SIZE) {
                    pk.f591a.delete();
                }
                fileWriter = new FileWriter(pk.f591a, true);
                try {
                    fileWriter.write(String.format("%s [%s] %s\n", pk.f592a.format(new Date()), this.f1348a, this.b));
                    fileWriter.flush();
                } catch (Throwable unused) {
                    if (fileWriter == null) {
                    }
                }
                fileWriter.close();
                return;
                fileWriter.close();
                return;
            } catch (Throwable unused2) {
                return;
            }
        } catch (Throwable unused3) {
            fileWriter = null;
        }
        if (fileWriter == null) {
        }
    }
}
