package com.icbc.paysdk.services;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class FileUtil {
    public void writeFile(Context context, String str, String str2, int i) throws Exception {
        FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput(str, i);
        fileOutputStreamOpenFileOutput.write(str2.getBytes());
        fileOutputStreamOpenFileOutput.close();
    }

    public String readFile(Context context, String str) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStreamOpenFileInput = context.openFileInput(str);
        byte[] bArr = new byte[1024];
        while (true) {
            int i = fileInputStreamOpenFileInput.read(bArr);
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                String string = byteArrayOutputStream.toString();
                fileInputStreamOpenFileInput.close();
                byteArrayOutputStream.close();
                return string;
            }
        }
    }
}
