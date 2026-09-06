package com.joanzapata.android.iconify;

import android.content.Context;
import android.util.Log;
import android.util.TypedValue;
import com.alipay.sdk.util.i;
import com.huawei.openalliance.ad.constant.x;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
class Utils {
    public static final String ICON_FONT_FOLDER = "icon_tmp";

    private Utils() {
    }

    static int convertDpToPx(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    static boolean isEnabled(int[] iArr) {
        for (int i : iArr) {
            if (i == 16842910) {
                return true;
            }
        }
        return false;
    }

    static File resourceToFile(Context context, String str) throws Throwable {
        File file;
        InputStream resourceAsStream;
        if (context.getFilesDir() == null) {
            file = new File(context.getCacheDir(), ICON_FONT_FOLDER);
        } else {
            file = new File(context.getFilesDir(), ICON_FONT_FOLDER);
        }
        if (!file.exists() && !file.mkdirs()) {
            Log.e(Iconify.TAG, "Font folder creation failed");
            throw new IllegalStateException("Cannot create Iconify font destination folder");
        }
        File file2 = new File(file, str);
        if (file2.exists()) {
            return file2;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            resourceAsStream = Iconify.class.getClassLoader().getResourceAsStream(str);
            try {
                byte[] bArr = new byte[resourceAsStream.available()];
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file2));
                while (true) {
                    try {
                        int i = resourceAsStream.read(bArr);
                        if (i > 0) {
                            bufferedOutputStream2.write(bArr, 0, i);
                        } else {
                            closeQuietly(bufferedOutputStream2);
                            closeQuietly(resourceAsStream);
                            return file2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        closeQuietly(bufferedOutputStream);
                        closeQuietly(resourceAsStream);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            resourceAsStream = null;
        }
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static StringBuilder replaceIcons(StringBuilder sb) {
        int iIndexOf = sb.indexOf("{fa");
        if (iIndexOf == -1) {
            return sb;
        }
        int iIndexOf2 = sb.substring(iIndexOf).indexOf(i.d) + iIndexOf;
        int i = iIndexOf2 + 1;
        String strReplaceAll = sb.substring(iIndexOf + 1, iIndexOf2).replaceAll(x.A, "_");
        try {
            return replaceIcons(sb.replace(iIndexOf, i, String.valueOf(Iconify.IconValue.valueOf(strReplaceAll).character)));
        } catch (IllegalArgumentException unused) {
            Log.w(Iconify.TAG, "Wrong icon name: " + strReplaceAll);
            return sb;
        }
    }
}
