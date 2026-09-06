package com.fancy;

import android.content.Context;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.stub.StubApp;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _oy {
    public static Uri _a(Context context, File file) {
        try {
            return FileProvider.getUriForFile(StubApp.getOrigApplicationContext(context.getApplicationContext()), context.getPackageName() + ".fileProvider", file);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ByteArrayOutputStream _a(InputStream inputStream) {
        try {
            if (inputStream == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr, 0, 1024);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                }
            }
            return byteArrayOutputStream;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                inputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
