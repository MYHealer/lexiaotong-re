package com.jd.ad.sdk.jad_ly;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.jd.ad.sdk.bl.video.db.SplashRenderVideoHelper;
import com.jd.ad.sdk.bl.video.listener.VideoLoadListener;
import com.jd.ad.sdk.dl.error.JADError;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: JADVideoLoader.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_bo {
    public SplashRenderVideoHelper jad_an = null;

    /* JADX INFO: Removed unreachable split cross block B:89:0x00ce */
    /* JADX WARN: Code duplicated, block: B:22:0x004b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    public static String jad_an(jad_bo jad_boVar, Context context, InputStream inputStream, String str) throws Throwable {
        String strEncodeToString;
        String strSubstring;
        IOException e;
        jad_boVar.getClass();
        String path = "";
        try {
            if (TextUtils.isEmpty(str)) {
                strSubstring = "";
            } else {
                int iLastIndexOf = str.lastIndexOf(47);
                int iLastIndexOf2 = str.lastIndexOf(46);
                if (iLastIndexOf == -1 || iLastIndexOf2 == -1 || iLastIndexOf2 <= iLastIndexOf) {
                    strSubstring = "";
                } else {
                    strSubstring = str.substring(iLastIndexOf + 1, iLastIndexOf2);
                    if (TextUtils.isEmpty(strSubstring)) {
                        strSubstring = "";
                    } else {
                        strEncodeToString = TextUtils.isEmpty(strSubstring) ? "" : Base64.encodeToString(strSubstring.getBytes(), 10);
                        try {
                            if (!TextUtils.isEmpty(strEncodeToString) || TextUtils.isEmpty(strSubstring)) {
                                strSubstring = strEncodeToString;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
            strEncodeToString = "";
        }
        ?? r1 = 0;
        r1 = 0;
        r1 = 0;
        File externalFilesDir = context.getExternalFilesDir(null);
        if (!externalFilesDir.exists()) {
            return "";
        }
        File file = new File(externalFilesDir, strSubstring);
        try {
            try {
                if (file.exists()) {
                    return file.getPath();
                }
                try {
                    ?? fileOutputStream = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            r1 = inputStream.read(bArr);
                            if (r1 == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, r1);
                        }
                        path = file.exists() ? file.getPath() : "";
                        try {
                            inputStream.close();
                            inputStream = inputStream;
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            inputStream = e4;
                        }
                        fileOutputStream.close();
                    } catch (IOException e5) {
                        e = e5;
                        r1 = fileOutputStream;
                        e.printStackTrace();
                        if (inputStream != 0) {
                            try {
                                inputStream.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        if (r1 != 0) {
                            r1.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        r1 = fileOutputStream;
                        if (inputStream != 0) {
                            try {
                                inputStream.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        if (r1 == 0) {
                            throw th;
                        }
                        try {
                            r1.close();
                            throw th;
                        } catch (IOException e8) {
                            e8.printStackTrace();
                            throw th;
                        }
                    }
                } catch (IOException e9) {
                    e = e9;
                }
                return path;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public final void jad_an(VideoLoadListener videoLoadListener, int i, String str) {
        if (videoLoadListener == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = JADError.DEFAULT_ERROR.getMessage(new String[0]);
        }
        videoLoadListener.onLoadFailure(i, str);
    }
}
