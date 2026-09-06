package com.ubixnow.ooooo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oO0000o0 {
    private LruCache<String, Bitmap> OooO00o;
    private LruCache<String, byte[]> OooO0O0;
    private String OooO0OO = "";
    private final int OooO0Oo = 10000;

    public oO0000o0(LruCache<String, Bitmap> lruCache, LruCache<String, byte[]> lruCache2) {
        this.OooO00o = lruCache;
        this.OooO0O0 = lruCache2;
    }

    private int OooO00o(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 <= i2 && i4 <= i) {
            return 1;
        }
        int iMin = Math.min(Math.round(i3 / i2), Math.round(i4 / i));
        while ((i4 * i3) / (iMin * iMin) > i * i2 * 2) {
            iMin++;
        }
        return iMin;
    }

    private Bitmap OooO00o(String str) {
        String str2 = this.OooO0OO + "/" + oO0000O.OooO0o0(str);
        ooooO000.OooO00o("cache file path :" + str2);
        try {
            if (!new File(str2).exists()) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(str2);
            Bitmap bitmapOooO00o = OooO00o(OooO00o(fileInputStream));
            fileInputStream.close();
            return bitmapOooO00o;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Bitmap OooO00o(byte[] bArr) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        int i = options.outWidth;
        int i2 = options.outHeight;
        int iMin = Math.min(i, i2);
        float f = i / i2;
        if (Math.round(f) > 0) {
            options.inSampleSize = OooO00o(options, iMin, iMin / Math.round(f));
        }
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    public static byte[] OooO00o(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARN: Code duplicated, block: B:113:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x0183  */
    /* JADX WARN: Code duplicated, block: B:77:0x01e3 A[Catch: IOException -> 0x01df, TRY_LEAVE, TryCatch #10 {IOException -> 0x01df, blocks: (B:73:0x01db, B:77:0x01e3), top: B:107:0x01db }] */
    /* JADX WARN: Code duplicated, block: B:85:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:91:0x01fd A[Catch: IOException -> 0x01f9, TRY_LEAVE, TryCatch #0 {IOException -> 0x01f9, blocks: (B:87:0x01f5, B:91:0x01fd), top: B:95:0x01f5 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x01f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.io.InputStream] */
    public Bitmap OooO00o(String str, boolean z) throws Throwable {
        Throwable th;
        ?? r5;
        Bitmap bitmapOooO0O0;
        File file;
        ?? r7;
        HttpURLConnection httpURLConnection;
        ?? fileOutputStream = "file mkdirs:";
        ?? inputStream = "---http:---";
        Object obj = null;
        try {
            try {
                URL url = new URL(str);
                if (str.startsWith("https")) {
                    ooooO000.OooO00o("---https:---" + str);
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                    httpsURLConnection.setHostnameVerifier(new d1());
                    httpsURLConnection.setInstanceFollowRedirects(true);
                    httpsURLConnection.setConnectTimeout(10000);
                    httpsURLConnection.setReadTimeout(10000);
                    httpURLConnection = httpsURLConnection;
                } else {
                    ooooO000.OooO00o("---http:---" + str);
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                    httpURLConnection2.setInstanceFollowRedirects(true);
                    httpURLConnection2.setConnectTimeout(10000);
                    httpURLConnection2.setReadTimeout(10000);
                    httpURLConnection = httpURLConnection2;
                }
                inputStream = httpURLConnection.getInputStream();
                if (inputStream == 0) {
                    if (inputStream != 0) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return null;
                }
                try {
                    String strOooO0o0 = oO0000O.OooO0o0(str);
                    String str2 = this.OooO0OO;
                    if (!new File(str2).exists()) {
                        ooooO000.OooO00o("file mkdirs:" + new File(str2).mkdirs());
                    }
                    fileOutputStream = new FileOutputStream(str2 + "/" + strOooO0o0 + ".tmp");
                    try {
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int i = inputStream.read(bArr);
                                if (i == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, i);
                                e.printStackTrace();
                                if (file != null && file.exists()) {
                                    ooooO000.OooO00o("delete:" + file.delete());
                                }
                                if (bitmapOooO0O0 != null) {
                                    System.gc();
                                }
                                if (inputStream != 0) {
                                    try {
                                        inputStream.close();
                                        if (fileOutputStream != 0) {
                                            fileOutputStream.close();
                                        }
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                } else if (fileOutputStream != 0) {
                                    fileOutputStream.close();
                                }
                                return null;
                            }
                            long size = fileOutputStream.getChannel().size();
                            file = new File(str2 + "/" + strOooO0o0 + ".tmp");
                            try {
                                try {
                                    if (size > 0) {
                                        if (file.exists()) {
                                            File file2 = new File(str2 + "/" + strOooO0o0);
                                            ooooO000.OooO00o("rename:" + file.renameTo(file2));
                                            ooooO000.OooO00o("read file to cache:" + file2.getAbsolutePath());
                                            bitmapOooO0O0 = OooO0O0(str);
                                            if (z) {
                                                try {
                                                    this.OooO00o.put(str, bitmapOooO0O0);
                                                } catch (Exception e3) {
                                                    e = e3;
                                                }
                                            }
                                        }
                                        inputStream.close();
                                        httpURLConnection.disconnect();
                                        fileOutputStream.close();
                                        if (bitmapOooO0O0 != null) {
                                            System.gc();
                                        }
                                        inputStream.close();
                                        fileOutputStream.close();
                                        return bitmapOooO0O0;
                                    }
                                    if (file.exists()) {
                                        ooooO000.OooO00o("delete:" + file.delete());
                                    }
                                    inputStream.close();
                                    fileOutputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                                bitmapOooO0O0 = null;
                                inputStream.close();
                                httpURLConnection.disconnect();
                                fileOutputStream.close();
                                if (bitmapOooO0O0 != null) {
                                    System.gc();
                                }
                                return bitmapOooO0O0;
                            } catch (Exception e5) {
                                e = e5;
                                bitmapOooO0O0 = null;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            bitmapOooO0O0 = null;
                            file = null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        th = th;
                        r5 = fileOutputStream;
                        r7 = inputStream;
                        if (obj != null) {
                            System.gc();
                        }
                        if (r7 != 0) {
                            try {
                                r7.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                                throw th;
                            }
                        }
                        if (r5 != 0) {
                            throw th;
                        }
                        r5.close();
                        throw th;
                    }
                } catch (Exception e8) {
                    e = e8;
                    bitmapOooO0O0 = null;
                    fileOutputStream = 0;
                    file = null;
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    r5 = 0;
                    r7 = inputStream;
                    if (obj != null) {
                        System.gc();
                    }
                    if (r7 != 0) {
                        r7.close();
                    }
                    if (r5 != 0) {
                        throw th;
                    }
                    r5.close();
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                obj = ".tmp";
            }
        } catch (Exception e9) {
            e = e9;
            inputStream = 0;
        } catch (Throwable th5) {
            th = th5;
            inputStream = 0;
        }
    }

    public String OooO00o() {
        return this.OooO0OO;
    }

    public void OooO00o(String str, Bitmap bitmap) throws Throwable {
        StringBuilder sbAppend;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    ooooO000.OooO00o("Save BitmapReady to save picture");
                    String strOooO0o0 = oO0000O.OooO0o0(str);
                    String str2 = this.OooO0OO;
                    if (!new File(str2).exists()) {
                        ooooO000.OooO00o("file mkdirs:" + new File(str2).mkdirs());
                    }
                    String str3 = str2 + "/" + strOooO0o0 + ".tmp";
                    FileOutputStream fileOutputStream2 = new FileOutputStream(str3);
                    try {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream2);
                        long size = fileOutputStream2.getChannel().size();
                        File file = new File(str3);
                        if (!file.exists() || size <= 0) {
                            if (file.exists()) {
                                sbAppend = new StringBuilder("file delete:").append(file.delete());
                            }
                            fileOutputStream2.close();
                            fileOutputStream2.close();
                        }
                        sbAppend = new StringBuilder("file rename:").append(file.renameTo(new File(str2 + "/" + strOooO0o0)));
                        ooooO000.OooO00o(sbAppend.toString());
                        fileOutputStream2.close();
                        fileOutputStream2.close();
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        e.printStackTrace();
                        if (fileOutputStream == null) {
                        } else {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }

    public Bitmap OooO0O0(String str) {
        synchronized (this.OooO00o) {
            Bitmap bitmap = this.OooO00o.get(str);
            return (bitmap == null || bitmap.isRecycled()) ? OooO00o(str) : bitmap;
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x020b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:75:0x01f5 A[Catch: IOException -> 0x01f1, TRY_LEAVE, TryCatch #2 {IOException -> 0x01f1, blocks: (B:71:0x01ed, B:75:0x01f5), top: B:96:0x01ed }] */
    /* JADX WARN: Code duplicated, block: B:84:0x0206  */
    /* JADX WARN: Code duplicated, block: B:90:0x0213 A[Catch: IOException -> 0x020f, TRY_LEAVE, TryCatch #6 {IOException -> 0x020f, blocks: (B:86:0x020b, B:90:0x0213), top: B:102:0x020b }] */
    /* JADX WARN: Code duplicated, block: B:96:0x01ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public byte[] OooO0O0(String str, boolean z) throws Throwable {
        InputStream inputStream;
        Throwable th;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        File file;
        HttpURLConnection httpURLConnection;
        byte[] bArrOooO0OO = new byte[0];
        try {
            URL url = new URL(str);
            ooooO000.OooO00o("-----getByteFromUrl-https:---", str);
            boolean z2 = true;
            if (str.startsWith("https")) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                httpsURLConnection.setHostnameVerifier(new d1());
                httpsURLConnection.setInstanceFollowRedirects(true);
                httpsURLConnection.setConnectTimeout(10000);
                httpsURLConnection.setReadTimeout(100);
                httpURLConnection = httpsURLConnection;
            } else {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                httpURLConnection2.setInstanceFollowRedirects(true);
                httpURLConnection2.setConnectTimeout(100);
                httpURLConnection2.setReadTimeout(100);
                httpURLConnection = httpURLConnection2;
            }
            inputStream = httpURLConnection.getInputStream();
            try {
                StringBuilder sb = new StringBuilder("");
                if (inputStream != null) {
                    z2 = false;
                }
                ooooO000.OooO00o("-----getByteFromUrl-https:---", sb.append(z2).toString());
                if (inputStream == null) {
                    throw new RuntimeException("stream is null");
                }
                String strOooO0o0 = oO0000O.OooO0o0(str);
                String str2 = this.OooO0OO;
                if (!new File(str2).exists()) {
                    ooooO000.OooO00o("mkdirs" + new File(str2).mkdirs());
                }
                fileOutputStream2 = new FileOutputStream(str2 + "/" + strOooO0o0 + ".tmp");
                try {
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = inputStream.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, i);
                            ooooO000.OooO00o("getByteFromUrl:", "Exception " + e.getMessage());
                            e.printStackTrace();
                            if (file != null && file.exists()) {
                                ooooO000.OooO00o("delete:" + file.delete());
                            }
                            ooooO000.OooO00o("getByteFromUrl:", "finally");
                            if (bArrOooO0OO != null) {
                                System.gc();
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    return null;
                                }
                            }
                            if (fileOutputStream2 != null) {
                                return null;
                            }
                            fileOutputStream2.close();
                            return null;
                        }
                        long size = fileOutputStream2.getChannel().size();
                        file = new File(str2 + "/" + strOooO0o0 + ".tmp");
                        try {
                            if (size > 0) {
                                if (file.exists()) {
                                    File file2 = new File(str2 + "/" + strOooO0o0);
                                    ooooO000.OooO00o("rename:" + file.renameTo(file2));
                                    ooooO000.OooO00o("read file to cache:" + file2.getAbsolutePath());
                                    bArrOooO0OO = OooO0OO(str);
                                    if (z) {
                                        this.OooO0O0.put(str, bArrOooO0OO);
                                    }
                                }
                            } else if (file.exists()) {
                                ooooO000.OooO00o("delete:" + file.delete());
                            }
                            inputStream.close();
                            httpURLConnection.disconnect();
                            fileOutputStream2.close();
                            ooooO000.OooO00o("getByteFromUrl:", "finally");
                            if (bArrOooO0OO != null) {
                                System.gc();
                            }
                            try {
                                inputStream.close();
                                fileOutputStream2.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            return bArrOooO0OO;
                        } catch (Exception e3) {
                            e = e3;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        file = null;
                    }
                } catch (Throwable th2) {
                    fileOutputStream = fileOutputStream2;
                    th = th2;
                    ooooO000.OooO00o("getByteFromUrl:", "finally");
                    if (bArrOooO0OO != null) {
                        System.gc();
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                            throw th;
                        }
                    }
                    if (fileOutputStream != null) {
                        throw th;
                    }
                    fileOutputStream.close();
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                fileOutputStream2 = null;
                file = null;
                ooooO000.OooO00o("getByteFromUrl:", "Exception " + e.getMessage());
                e.printStackTrace();
                if (file != null) {
                    ooooO000.OooO00o("delete:" + file.delete());
                }
                ooooO000.OooO00o("getByteFromUrl:", "finally");
                if (bArrOooO0OO != null) {
                    System.gc();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream2 != null) {
                    return null;
                }
                fileOutputStream2.close();
                return null;
            } catch (Throwable th3) {
                th = th3;
                th = th;
                fileOutputStream = null;
                ooooO000.OooO00o("getByteFromUrl:", "finally");
                if (bArrOooO0OO != null) {
                    System.gc();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    throw th;
                }
                fileOutputStream.close();
                throw th;
            }
        } catch (Exception e7) {
            e = e7;
            inputStream = null;
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
        }
    }

    public byte[] OooO0OO(String str) {
        synchronized (this.OooO0O0) {
            byte[] bArr = this.OooO0O0.get(str);
            if (bArr != null) {
                return bArr;
            }
            byte[] bArrOooO0Oo = OooO0Oo(str);
            if (bArrOooO0Oo != null) {
                this.OooO0O0.put(str, bArrOooO0Oo);
            }
            return bArrOooO0Oo;
        }
    }

    public byte[] OooO0Oo(String str) {
        String str2 = this.OooO0OO + "/" + oO0000O.OooO0o0(str);
        try {
            if (!new File(str2).exists()) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(str2);
            byte[] bArrOooO00o = OooO00o(fileInputStream);
            fileInputStream.close();
            return bArrOooO00o;
        } catch (Exception unused) {
            return null;
        }
    }

    public void OooO0o0(String str) {
        this.OooO0OO = str;
    }
}
