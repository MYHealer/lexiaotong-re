package com.huawei.hms.mlkit.bcr;

import android.content.res.AssetManager;
import com.huawei.hms.ml.common.utils.SmartLog;
import com.huawei.hms.ml.common.utils.StreamUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: ModelLoader.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4140a = "a";

    /* JADX INFO: renamed from: com.huawei.hms.mlkit.bcr.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ModelLoader.java */
    static /* synthetic */ class C0525a {
    }

    /* JADX INFO: compiled from: ModelLoader.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f4141a = new a(null);
    }

    /* synthetic */ a(C0525a c0525a) {
        this();
    }

    public static a a() {
        return b.f4141a;
    }

    private a() {
    }

    /* JADX WARN: Code duplicated, block: B:25:0x005c  */
    /* JADX WARN: Multi-variable type inference failed */
    public ByteBuffer a(AssetManager assetManager, String str) throws Throwable {
        InputStream inputStreamOpen;
        AssetManager assetManager2 = null;
        try {
            try {
                inputStreamOpen = assetManager.open(str);
                try {
                    int iAvailable = inputStreamOpen.available();
                    byte[] bArr = new byte[iAvailable];
                    if (inputStreamOpen.read(bArr) > 0) {
                        ByteBuffer byteBufferPut = ByteBuffer.allocateDirect(iAvailable).put(bArr);
                        if (inputStreamOpen != null) {
                            StreamUtils.closeStreams(inputStreamOpen);
                        }
                        return byteBufferPut;
                    }
                    if (inputStreamOpen != null) {
                        StreamUtils.closeStreams(inputStreamOpen);
                    }
                } catch (IOException e) {
                    e = e;
                    SmartLog.e(f4140a, "IOException e = " + e.getMessage());
                    if (inputStreamOpen != null) {
                        StreamUtils.closeStreams(inputStreamOpen);
                    }
                }
            } catch (Throwable th) {
                th = th;
                assetManager2 = assetManager;
                if (assetManager2 != null) {
                    StreamUtils.closeStreams(assetManager2);
                }
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            inputStreamOpen = null;
        } catch (Throwable th2) {
            th = th2;
            if (assetManager2 != null) {
                StreamUtils.closeStreams(assetManager2);
            }
            throw th;
        }
        return null;
    }
}
