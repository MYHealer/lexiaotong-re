package com.yxcorp.kuaishou.addfp.android.b;

import android.content.Context;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class b {
    public static File a(Context context, boolean z) {
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            Class<?> cls = Class.forName("android.os.storage.StorageVolume");
            Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
            Method method2 = cls.getMethod("getPath", new Class[0]);
            Method method3 = cls.getMethod("isRemovable", new Class[0]);
            Object objInvoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(objInvoke);
            for (int i = 0; i < length; i++) {
                Object obj = Array.get(objInvoke, i);
                String str = (String) method2.invoke(obj, new Object[0]);
                if (z == ((Boolean) method3.invoke(obj, new Object[0])).booleanValue() && !TextUtils.isEmpty(str)) {
                    return new File(str);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return Environment.getExternalStorageDirectory();
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[256];
        for (int i = 0; i < 256; i++) {
            bArr3[i] = (byte) i;
        }
        if (bArr2.length == 0) {
            bArr3 = null;
        } else {
            int length = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < 256; i3++) {
                int i4 = bArr2[length] & 255;
                byte b = bArr3[i3];
                i2 = (i4 + (b & 255) + i2) & 255;
                bArr3[i3] = bArr3[i2];
                bArr3[i2] = b;
                length = (length + 1) % bArr2.length;
            }
        }
        byte[] bArr4 = new byte[bArr.length];
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < bArr.length; i7++) {
            i5 = (i5 + 1) & 255;
            byte b2 = bArr3[i5];
            i6 = ((b2 & 255) + i6) & 255;
            bArr3[i5] = bArr3[i6];
            bArr3[i6] = b2;
            byte b3 = (byte) (bArr3[((bArr3[i5] & 255) + (b2 & 255)) & 255] ^ bArr[i7]);
            bArr4[i7] = b3;
            bArr4[i7] = (byte) (b3 ^ 42);
        }
        return bArr4;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    byte[] bArrA = a(bArr, bArr2);
                    if (bArrA != null) {
                        int length = bArrA.length;
                    }
                    return bArrA;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    byte[] bArrA = a(bArr, bArr2);
                    if (bArrA != null) {
                        int length = bArrA.length;
                    }
                    return bArrA;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }
}
