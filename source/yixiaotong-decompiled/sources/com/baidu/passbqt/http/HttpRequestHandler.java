package com.baidu.passbqt.http;

import android.os.Handler;
import android.os.Looper;
import com.baidu.passbqt.NoProguard;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class HttpRequestHandler extends Handler implements NoProguard {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final int f1927a = 0;
    protected boolean b;

    public HttpRequestHandler(Looper looper) {
        this(looper, false);
    }

    public HttpRequestHandler(Looper looper, boolean z) {
        super(looper);
        this.b = z;
    }

    protected byte[] a(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } finally {
            gZIPOutputStream.close();
        }
    }
}
