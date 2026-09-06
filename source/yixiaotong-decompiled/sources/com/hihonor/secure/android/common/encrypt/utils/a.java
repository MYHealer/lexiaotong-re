package com.hihonor.secure.android.common.encrypt.utils;

import android.database.Cursor;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    private static final int S = 4096;
    private static final String TAG = "IOUtil";

    public static void a(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    public static void a(Reader reader) {
        a(reader);
    }

    public static void a(Writer writer) {
        a(writer);
    }

    public static void a(InputStream inputStream) {
        a(inputStream);
    }

    public static void a(OutputStream outputStream) {
        a(outputStream);
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                b.f(TAG, "closeSecure IOException");
            }
        }
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        return a(inputStream, outputStream, new byte[4096]);
    }

    public static long a(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        long j = 0;
        while (true) {
            int i = inputStream.read(bArr);
            if (-1 == i) {
                return j;
            }
            outputStream.write(bArr, 0, i);
            j += (long) i;
        }
    }

    public static byte[] b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static InputStream f(byte[] bArr) throws IOException {
        return new ByteArrayInputStream(bArr);
    }

    public static void b(File file) {
        if (file == null || !file.exists() || file.delete()) {
            return;
        }
        b.f(TAG, "deleteSecure exception");
    }

    public static void h(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b(new File(str));
    }
}
