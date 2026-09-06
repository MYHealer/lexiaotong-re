package com.oplus.log.d;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class h {
    public static File a(String str) {
        File file = new File(str);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    public static byte[] a(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i == -1) {
                    fileInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (FileNotFoundException e) {
            if (com.oplus.log.b.c()) {
                e.printStackTrace();
            }
            return null;
        } catch (IOException e2) {
            if (com.oplus.log.b.c()) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public static File b(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException unused) {
            return null;
        }
    }
}
