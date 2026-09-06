package com.xiaomi.onetrack.util;

import android.util.Log;
import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f9518a = -1;
    private static final String b = ijiami_1011.s.s.s.d(new byte[]{88, 90, 81, Ascii.ETB, 19, 84, 2, 15}, "744ca5");
    private static final int c = 4096;

    public static long a(InputStream inputStream, OutputStream outputStream) {
        return a(inputStream, outputStream, 4096);
    }

    public static long a(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        long j = 0;
        while (true) {
            int i2 = inputStream.read(bArr);
            if (-1 == i2) {
                return j;
            }
            outputStream.write(bArr, 0, i2);
            j += (long) i2;
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            while (hexString.length() < 2) {
                hexString = ijiami_1011.s.s.s.d(new byte[]{84}, "d94bd1") + hexString;
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                Log.e(b, ijiami_1011.s.s.s.d(new byte[]{82, 90, 12, 70, 92, 53, Ascii.DC4, 13, 3, Ascii.SYN, 93, Ascii.FS, 17, 83}, "16c59d"), e);
            }
        }
    }

    public static void a(InputStream inputStream) {
        a((Closeable) inputStream);
    }

    public static void a(OutputStream outputStream) {
        a((Closeable) outputStream);
    }

    public static void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                Log.e(b, ijiami_1011.s.s.s.d(new byte[]{85, 90, 13, 65, 82, 16, 4}, "66b270"), e);
            }
        }
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                Log.e(b, ijiami_1011.s.s.s.d(new byte[]{82, 94, 89, 68, 93, 107, 0, 2, 3, 14, 72, 69, 84}, "126788"), e);
            }
        }
    }

    public static byte[] b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
