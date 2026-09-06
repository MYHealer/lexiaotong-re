package com.omes.scorpion;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class OmasStub {
    static {
        System.loadLibrary("scorpion");
    }

    public static native boolean omasBoolean(int i, Object[] objArr);

    public static native byte omasByte(int i, Object[] objArr);

    public static native char omasChar(int i, Object[] objArr);

    public static native double omasDouble(int i, Object[] objArr);

    public static native float omasFloat(int i, Object[] objArr);

    public static native int omasInt(int i, Object[] objArr);

    public static native long omasLong(int i, Object[] objArr);

    public static native Object omasObject(int i, Object[] objArr);

    public static native short omasShort(int i, Object[] objArr);

    public static native void omasVoid(int i, Object[] objArr);

    public static byte[] testUnzip(String str, String str2) {
        try {
            ZipFile zipFile = new ZipFile(new File(str));
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            while (enumerationEntries.hasMoreElements()) {
                ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                if (zipEntryNextElement.getName().contains(str2)) {
                    InputStream inputStream = zipFile.getInputStream(zipEntryNextElement);
                    int iAvailable = inputStream.available();
                    byte[] bArr = new byte[iAvailable];
                    int i = 0;
                    do {
                        int i2 = inputStream.read(bArr, i, 10240);
                        if (i2 != -1) {
                            i += i2;
                        }
                        return bArr;
                    } while (i + 10240 <= iAvailable);
                    inputStream.read(bArr, i, iAvailable - i);
                    return bArr;
                }
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
