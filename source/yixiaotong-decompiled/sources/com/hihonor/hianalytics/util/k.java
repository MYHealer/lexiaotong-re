package com.hihonor.hianalytics.util;

import com.baidu.mobads.sdk.internal.bt;
import com.hihonor.hianalytics.hnha.j2;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.net.HttpURLConnection;
import java.util.zip.Deflater;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class k {
    public static void a(long j) {
        try {
            Thread.sleep(j);
        } catch (Throwable th) {
            j2.g(bt.f1755a, "sleepQuiet fail=" + SystemUtils.getDesensitizedException(th));
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                j2.g(bt.f1755a, "closeQuiet fail=" + SystemUtils.getDesensitizedException(th));
            }
        }
    }

    public static void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        try {
            a(httpURLConnection.getInputStream());
        } catch (Throwable th) {
            j2.g(bt.f1755a, "disconnectQuiet firstFailE=" + SystemUtils.getDesensitizedException(th));
        }
        try {
            httpURLConnection.disconnect();
        } catch (Throwable th2) {
            j2.g(bt.f1755a, "disconnectQuiet secondFailE=" + SystemUtils.getDesensitizedException(th2));
        }
    }

    public static byte[] a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Deflater deflater = new Deflater();
        try {
            deflater.setInput(bArr);
            deflater.finish();
            byte[] bArr2 = new byte[1024];
            while (!deflater.finished()) {
                byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
            }
            return byteArrayOutputStream.toByteArray();
        } finally {
            deflater.end();
            a(byteArrayOutputStream);
        }
    }
}
