package com.byazt.jz;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Pair;
import com.byazt.mg.da;
import com.byazt.uy.x;
import com.byazt.yv.TTEncryptUtils;
import com.loopj.android.http.AsyncHttpClient;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 232, 13})
public class tt {
    public static boolean c;
    public static ve tt;

    public static boolean c() {
        return true;
    }

    public static boolean tt() {
        return true;
    }

    public static a c(long j, String str, byte[] bArr, c cVar, String str2, boolean z) throws IOException {
        String str3;
        if (str == null) {
            return new a(201);
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        int length = bArr.length;
        if (c.GZIP == cVar && length > 128) {
            bArr = tt(bArr);
            str3 = AsyncHttpClient.ENCODING_GZIP;
        } else if (c.DEFLATER != cVar || length <= 128) {
            str3 = null;
        } else {
            bArr = c(bArr);
            str3 = "deflate";
        }
        String str4 = str3;
        byte[] bArr2 = bArr;
        if (bArr2 == null) {
            return new a(202);
        }
        if (z) {
            byte[] bArrA = TTEncryptUtils.a(bArr2, bArr2.length);
            if (bArrA != null) {
                if (TextUtils.isEmpty(new URL(str).getQuery())) {
                    if (!str.endsWith("?")) {
                        str = str + "?";
                    }
                } else if (!str.endsWith("&")) {
                    str = str + "&";
                }
                str = str + "encrypt=true";
                str2 = "application/octet-stream;tt-data=a";
                bArr2 = bArrA;
            }
            return c(str, bArr2, str2, str4, "POST", true, true);
        }
        return c(str, bArr2, str2, str4, "POST", true, false);
    }

    private static byte[] c(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[8192];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        deflater.end();
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] tt(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                da.tt(th);
                return null;
            } finally {
                gZIPOutputStream.close();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:88:0x010c A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    private static a c(String str, byte[] bArr, String str2, String str3, String str4, boolean z, boolean z2) {
        InputStream inputStream;
        byte[] bArrC;
        DataOutputStream dataOutputStream;
        HttpURLConnection httpURLConnection = null;
        GZIPInputStream gZIPInputStream = null;
        try {
            ve veVar = tt;
            if (veVar != null) {
                str = veVar.c(str, bArr);
            }
            LinkedList<Pair> linkedList = new LinkedList();
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) (z2 ? new URL(com.byazt.cx.c.c(str, linkedList)) : new URL(str)).openConnection();
            if (z2) {
                try {
                    if (!linkedList.isEmpty()) {
                        for (Pair pair : linkedList) {
                            if (pair != null) {
                                httpURLConnection2.setRequestProperty((String) pair.first, (String) pair.second);
                            }
                        }
                    }
                } catch (Throwable th) {
                    httpURLConnection = httpURLConnection2;
                    th = th;
                    inputStream = null;
                    try {
                        da.tt(th);
                        return new a(207, th);
                    } finally {
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception unused) {
                            }
                        }
                        com.byazt.mg.a.c(inputStream);
                    }
                }
            }
            if (z) {
                httpURLConnection2.setDoOutput(true);
            } else {
                httpURLConnection2.setDoOutput(false);
            }
            if (str2 != null) {
                httpURLConnection2.setRequestProperty("Content-Type", str2);
            }
            if (str3 != null) {
                httpURLConnection2.setRequestProperty("Content-Encoding", str3);
            }
            httpURLConnection2.setRequestProperty("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
            if (str4 == null) {
                throw new IllegalArgumentException("request method is not null");
            }
            httpURLConnection2.setRequestMethod(str4);
            if (bArr != null && bArr.length > 0) {
                try {
                    dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                    try {
                        dataOutputStream.write(bArr);
                        dataOutputStream.flush();
                        com.byazt.mg.a.c(dataOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        com.byazt.mg.a.c(dataOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    dataOutputStream = null;
                }
            }
            int responseCode = httpURLConnection2.getResponseCode();
            if (responseCode != 200) {
                a aVar = new a(206, "http response code " + responseCode);
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Exception unused2) {
                    }
                }
                com.byazt.mg.a.c(null);
                return aVar;
            }
            inputStream = httpURLConnection2.getInputStream();
            try {
                if (AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(httpURLConnection2.getContentEncoding())) {
                    try {
                        GZIPInputStream gZIPInputStream2 = new GZIPInputStream(inputStream);
                        try {
                            bArrC = c(gZIPInputStream2);
                            com.byazt.mg.a.c(gZIPInputStream2);
                        } catch (Throwable th4) {
                            th = th4;
                            gZIPInputStream = gZIPInputStream2;
                            com.byazt.mg.a.c(gZIPInputStream);
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } else {
                    bArrC = c(inputStream);
                }
                a aVarVe = ve(bArrC);
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Exception unused3) {
                    }
                }
                com.byazt.mg.a.c(inputStream);
                return aVarVe;
            } catch (Throwable th6) {
                httpURLConnection = httpURLConnection2;
                th = th6;
                da.tt(th);
                return new a(207, th);
            }
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
        }
    }

    private static a ve(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new a(203);
        }
        String str = new String(bArr, Charset.forName("utf-8"));
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() > 0) {
                return new a(0, jSONObject);
            }
            return new a(204, str);
        } catch (JSONException unused) {
            return new a(204, str);
        }
    }

    public static a c(String str, String str2) {
        return c(str, str2, c());
    }

    public static String c(Map map) {
        return x.n().tt();
    }

    public static String tt(Map map) {
        return x.n().ve();
    }

    public static a c(n nVar) {
        if (nVar == null) {
            return new a(201);
        }
        try {
            return c(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, nVar.c(), nVar.ve(), c.GZIP, "application/json; charset=utf-8", nVar.tt());
        } catch (Throwable th) {
            da.tt(th);
            return new a(207, th);
        }
    }

    public static a c(String str, String str2, boolean z) {
        try {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                return c(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, str, str2.getBytes(), c.GZIP, "application/json; charset=utf-8", z);
            }
            return new a(201);
        } catch (Throwable th) {
            da.tt(th);
            return new a(207, th);
        }
    }

    private static byte[] c(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (-1 != i) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                inputStream.close();
                try {
                    return byteArrayOutputStream.toByteArray();
                } finally {
                    com.byazt.mg.a.c(byteArrayOutputStream);
                }
            }
        }
    }

    public enum c {
        NONE(0),
        GZIP(1),
        DEFLATER(2);

        public final int uj;

        c(int i) {
            this.uj = i;
        }
    }

    /* JADX INFO: renamed from: com.byazt.jz.tt$tt, reason: collision with other inner class name */
    public enum EnumC0192tt {
        NONE(0),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        WIFI(4),
        MOBILE_4G(5);

        public final int sp;

        EnumC0192tt(int i) {
            this.sp = i;
        }
    }
}
