package com.xiaomi.onetrack.g;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.xiaomi.onetrack.d.d;
import com.xiaomi.onetrack.d.f;
import com.xiaomi.onetrack.util.m;
import com.xiaomi.onetrack.util.p;
import ijiami_1011.s.s.s;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f9499a = 10000;
    public static final int b = 15000;
    private static final int o = 3;
    private static String h = s.d(new byte[]{127, 71, 66, 71, 54, 67, 8, 8}, "7367c7");
    private static final String i = s.d(new byte[]{118, 115, 96}, "164cb8");
    private static final String j = s.d(new byte[]{52, 120, 48, 53}, "d7ca5d");
    private static final String k = s.d(new byte[]{71}, "ae7901");
    private static final String l = s.d(new byte[]{10}, "7501a7");
    private static final String m = s.d(new byte[]{48, 103, 119, Ascii.GS, 14}, "e3106d");
    private static final String n = s.d(new byte[]{89, 95, 76, 91, 110, 71, 5, 15, 5, 13, 95, 3, 93, 81, 102, 88, 80, 82, 4, 14, 71, 34, Ascii.DC2, 76, Ascii.FS, Ascii.FS, 92, 114, 16, Ascii.ETB}, "469214");
    public static final String c = s.d(new byte[]{41, 53, 107, 48, 44, 37}, "fa4cea");
    public static final String d = s.d(new byte[]{41, 55, 62, Ascii.SYN, 66}, "fcab1b");
    public static final String e = s.d(new byte[]{45, 101, 103, 11, 82, Ascii.NAK}, "b18e7a");
    public static final String f = s.d(new byte[]{126, 49, 106, Ascii.DC2, 82, 92, 5, 1, Ascii.DC4}, "1e5a72");
    public static final String g = s.d(new byte[]{46, 49, 102, 65, 71, 93, Ascii.NAK, 11, 5, 13, 93}, "ae9152");

    private b() {
    }

    public static String a(String str) {
        return a(str, null, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.util.Map, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r11v10, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r12v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v7 */
    private static String a(String str, String str2, Map<String, String> map, boolean z) throws Throwable {
        ?? r12;
        ?? r11;
        String strA;
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
            if (map == 0) {
                strA = null;
            } else {
                try {
                    strA = a((Map<String, String>) map, (boolean) z);
                } catch (Exception e2) {
                    e = e2;
                    map = 0;
                    inputStream = null;
                    httpURLConnection = null;
                    p.b(h, s.d(new byte[]{124, 71, Ascii.DC2, Ascii.NAK, 52, Ascii.SYN, 8, 8, Ascii.NAK, 66, 97, 42, 103, 103, 70, -127, -39, -24, -123, -40, -58, -121, -115, -25, -47, -117, -34}, "43feab"), e);
                    m.a(inputStream);
                    m.a((OutputStream) map);
                    m.a(httpURLConnection);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    r11 = 0;
                    r12 = 0;
                    m.a((InputStream) r12);
                    m.a((OutputStream) r11);
                    m.a(httpURLConnection2);
                    throw th;
                }
            }
            String str3 = i;
            httpURLConnection = (HttpURLConnection) new URL((!str3.equals(str) || strA == null) ? str2 : str2 + s.d(new byte[]{10, Ascii.NAK}, "55be1b") + strA).openConnection();
            try {
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(15000);
                try {
                    if (!str3.equals(str)) {
                        String str4 = j;
                        if (str4.equals(str) && strA != null) {
                            httpURLConnection.setRequestMethod(str4);
                            httpURLConnection.setRequestProperty(s.d(new byte[]{122, 89, 87, 69, 4, 13, Ascii.NAK, 73, 50, Ascii.ESC, 65, 0}, "9691ac"), s.d(new byte[]{82, 17, 72, 9, 11, 6, 0, 16, 15, 13, 95, 74, 75, 76, 79, Ascii.DC2, Ascii.NAK, 72, 7, 11, Ascii.DC4, 15, Ascii.FS, 16, 65, 13, 93, 11, 1, 10, 5, 1, 2}, "3a8ebe"));
                            httpURLConnection.setDoOutput(true);
                            byte[] bytes = strA.getBytes(m);
                            map = httpURLConnection.getOutputStream();
                            try {
                                map.write(bytes, 0, bytes.length);
                                map.flush();
                                map = map;
                            } catch (Exception e3) {
                                e = e3;
                                inputStream = null;
                                p.b(h, s.d(new byte[]{124, 71, Ascii.DC2, Ascii.NAK, 52, Ascii.SYN, 8, 8, Ascii.NAK, 66, 97, 42, 103, 103, 70, -127, -39, -24, -123, -40, -58, -121, -115, -25, -47, -117, -34}, "43feab"), e);
                                m.a(inputStream);
                                m.a((OutputStream) map);
                                m.a(httpURLConnection);
                                return null;
                            } catch (Throwable th2) {
                                th = th2;
                                z = 0;
                                httpURLConnection2 = httpURLConnection;
                                r11 = map;
                                r12 = z;
                                m.a((InputStream) r12);
                                m.a((OutputStream) r11);
                                m.a(httpURLConnection2);
                                throw th;
                            }
                        }
                        int responseCode = httpURLConnection.getResponseCode();
                        inputStream = httpURLConnection.getInputStream();
                        byte[] bArrB = m.b(inputStream);
                        p.a(h, String.format(s.d(new byte[]{121, 69, 77, 69, 98, 69, 8, 8, Ascii.NAK, 66, 97, 42, 98, 101, Ascii.EM, -47, -113, -69, -123, -40, -58, -124, -71, -11, -44, -69, -90, Ascii.NAK, 66, 67, 13, 94, 70, 71, 66, 73, 17, 82, 86, 81, 82, 11, 65, 65, Ascii.NAK}, "119571"), str2, Integer.valueOf(responseCode)));
                        String str5 = new String(bArrB, m);
                        m.a(inputStream);
                        m.a((OutputStream) map);
                        m.a(httpURLConnection);
                        return str5;
                    }
                    httpURLConnection.setRequestMethod(str3);
                    byte[] bArrB2 = m.b(inputStream);
                    p.a(h, String.format(s.d(new byte[]{121, 69, 77, 69, 98, 69, 8, 8, Ascii.NAK, 66, 97, 42, 98, 101, Ascii.EM, -47, -113, -69, -123, -40, -58, -124, -71, -11, -44, -69, -90, Ascii.NAK, 66, 67, 13, 94, 70, 71, 66, 73, 17, 82, 86, 81, 82, 11, 65, 65, Ascii.NAK}, "119571"), str2, Integer.valueOf(responseCode)));
                    String str6 = new String(bArrB2, m);
                    m.a(inputStream);
                    m.a((OutputStream) map);
                    m.a(httpURLConnection);
                    return str6;
                } catch (Exception e4) {
                    e = e4;
                    p.b(h, s.d(new byte[]{124, 71, Ascii.DC2, Ascii.NAK, 52, Ascii.SYN, 8, 8, Ascii.NAK, 66, 97, 42, 103, 103, 70, -127, -39, -24, -123, -40, -58, -121, -115, -25, -47, -117, -34}, "43feab"), e);
                    m.a(inputStream);
                    m.a((OutputStream) map);
                    m.a(httpURLConnection);
                    return null;
                }
                map = 0;
                int responseCode2 = httpURLConnection.getResponseCode();
                inputStream = httpURLConnection.getInputStream();
            } catch (Exception e5) {
                e = e5;
                map = 0;
                inputStream = null;
            } catch (Throwable th3) {
                th = th3;
                map = 0;
                z = 0;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static String a(String str, Map<String, String> map) {
        return a(str, map, true);
    }

    public static String a(String str, Map<String, String> map, boolean z) {
        return a(i, str, map, z);
    }

    public static String a(String str, byte[] bArr) {
        OutputStream outputStream;
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        p.a(h, s.d(new byte[]{2, 94, 51, 14, Ascii.SYN, 76, 65, 17, Ascii.DC4, 14, 12}, "f1cae8") + str + s.d(new byte[]{26, Ascii.SYN, 14, 92, 10, 95}, "66b9db") + bArr.length);
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod(j);
                httpURLConnection.setRequestProperty(s.d(new byte[]{33, 89, 12, SignedBytes.MAX_POWER_OF_TWO, 83, 11, Ascii.NAK, 73, 50, Ascii.ESC, 65, 0}, "b6b46e"), s.d(new byte[]{83, 71, 71, 15, 10, 87, 0, 16, 15, 13, 95, 74, 93, 84, 67, 6, Ascii.ETB, Ascii.EM, Ascii.DC2, 16, Ascii.DC4, 7, 80, 8}, "277cc4"));
                String str2 = f.a().b()[1];
                httpURLConnection.setRequestProperty(c, str2);
                httpURLConnection.setRequestProperty(d, Long.toString(System.currentTimeMillis()));
                httpURLConnection.setRequestProperty(e, c.a(com.xiaomi.onetrack.f.a.b()).toString());
                httpURLConnection.setRequestProperty(f, com.xiaomi.onetrack.f.a.e());
                httpURLConnection.setRequestProperty(g, s.d(new byte[]{2, Ascii.ETB, 81}, "19acb2"));
                p.a(h, s.d(new byte[]{68, 91, 85, 94}, "721d2f") + str2);
                outputStream = httpURLConnection.getOutputStream();
                try {
                    outputStream.write(bArr, 0, bArr.length);
                    outputStream.flush();
                    int responseCode = httpURLConnection.getResponseCode();
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        try {
                            byte[] bArrB = m.b(inputStream);
                            p.a(h, String.format(s.d(new byte[]{44, Ascii.ETB, 70, Ascii.NAK, 100, Ascii.NAK, 8, 8, Ascii.NAK, 66, 97, 42, 55, 55, Ascii.DC2, -127, -119, -21, -123, -40, -58, -124, -71, -11, -127, -23, -83, 69, 68, 19, 13, 94, 70, 71, 66, 73, 68, 0, 93, 1, 84, 91, 65, 65, Ascii.NAK}, "dc2e1a"), str, Integer.valueOf(responseCode)));
                            String str3 = new String(bArrB, m);
                            m.a(inputStream);
                            m.a(outputStream);
                            m.a(httpURLConnection);
                            return str3;
                        } catch (IOException e2) {
                            e = e2;
                            p.b(h, String.format(s.d(new byte[]{46, 66, 71, 73, 109, Ascii.ETB, 8, 8, Ascii.NAK, 66, 97, 42, 53, 98, 19, -35, -128, -23, -123, -40, -58, -121, -107, -44, -114, -126, -106, Ascii.NAK, Ascii.CAN, Ascii.SYN, 19, 8, 92, 66, Ascii.DC4, Ascii.SYN, 74, Ascii.SYN, 86, 75, 74, 12, 19, 94, 70, 71, 66}, "f6398c"), str, e.getMessage()));
                            m.a(inputStream);
                            m.a(outputStream);
                            m.a(httpURLConnection);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        httpURLConnection2 = httpURLConnection;
                        m.a(inputStream);
                        m.a(outputStream);
                        m.a(httpURLConnection2);
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    inputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = null;
                    httpURLConnection2 = httpURLConnection;
                    m.a(inputStream);
                    m.a(outputStream);
                    m.a(httpURLConnection2);
                    throw th;
                }
            } catch (IOException e4) {
                e = e4;
                outputStream = null;
                inputStream = outputStream;
                p.b(h, String.format(s.d(new byte[]{46, 66, 71, 73, 109, Ascii.ETB, 8, 8, Ascii.NAK, 66, 97, 42, 53, 98, 19, -35, -128, -23, -123, -40, -58, -121, -107, -44, -114, -126, -106, Ascii.NAK, Ascii.CAN, Ascii.SYN, 19, 8, 92, 66, Ascii.DC4, Ascii.SYN, 74, Ascii.SYN, 86, 75, 74, 12, 19, 94, 70, 71, 66}, "f6398c"), str, e.getMessage()));
                m.a(inputStream);
                m.a(outputStream);
                m.a(httpURLConnection);
                return null;
            } catch (Throwable th3) {
                th = th3;
                outputStream = null;
                inputStream = null;
            }
        } catch (IOException e5) {
            e = e5;
            httpURLConnection = null;
            outputStream = null;
        } catch (Throwable th4) {
            th = th4;
            outputStream = null;
            inputStream = null;
            m.a(inputStream);
            m.a(outputStream);
            m.a(httpURLConnection2);
            throw th;
        }
    }

    public static String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        if (map != null) {
            ArrayList<String> arrayList = new ArrayList(map.keySet());
            Collections.sort(arrayList);
            for (String str : arrayList) {
                if (!TextUtils.isEmpty(str)) {
                    sb.append(str);
                    sb.append(map.get(str));
                }
            }
        }
        sb.append(n);
        return d.c(sb.toString());
    }

    private static String a(Map<String, String> map, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                if (!TextUtils.isEmpty(entry.getKey())) {
                    if (sb.length() > 0) {
                        sb.append(k);
                    }
                    String key = entry.getKey();
                    String str = m;
                    sb.append(URLEncoder.encode(key, str));
                    sb.append(l);
                    sb.append(URLEncoder.encode(entry.getValue() == null ? s.d(new byte[]{87, Ascii.ETB, 95, 93}, "9b313a") : entry.getValue(), str));
                }
            } catch (UnsupportedEncodingException unused) {
                p.b(h, s.d(new byte[]{83, 92, 74, 14, 81, 65, 65, Ascii.DC4, 7, 16, 80, 8, 70, 19, 94, 2, 89, 89, 4, 0}, "538c05"));
            }
        }
        if (z) {
            String strA = a(map);
            if (sb.length() > 0) {
                sb.append(k);
            }
            String strD = s.d(new byte[]{67, 13, 5, 95}, "0db12d");
            String str2 = m;
            sb.append(URLEncoder.encode(strD, str2));
            sb.append(l);
            sb.append(URLEncoder.encode(strA, str2));
        }
        return sb.toString();
    }

    public static String b(String str, Map<String, String> map) {
        return b(str, map, true);
    }

    public static String b(String str, Map<String, String> map, boolean z) {
        return a(j, str, map, z);
    }

    public static boolean b(String str) throws Throwable {
        HttpURLConnection httpURLConnection;
        if (TextUtils.isEmpty(str)) {
            p.a(h, s.d(new byte[]{83, 14, 113, 87, 70, 121, 5, 41, 9, 12, 88, 17, 88, 19, Ascii.SYN, 86, 80, 109, 19, 8, 70, 11, 66, 69, 89, Ascii.DC4, 90, 94}, "7a6228"));
            return true;
        }
        HttpURLConnection httpURLConnection2 = null;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            try {
                if (i2 >= 3) {
                    p.a(h, s.d(new byte[]{Ascii.DC4, 6, 85, 89, 65, 4, 2, 16, 37, 13, 68, 11, Ascii.DC2, 67, 15, 13, 19, 82, 77, 68, Ascii.DC4, 7, 69, 16, Ascii.DC4, 13, 17, 68, 65, Ascii.DC4, 4}, "fc103a"));
                    try {
                        m.a(httpURLConnection2);
                    } catch (Exception unused) {
                    }
                    return true;
                }
                try {
                    try {
                        if (i3 / 100 == 3) {
                            i2++;
                            str = httpURLConnection2.getHeaderField(s.d(new byte[]{47, 90, 83, 89, 77, 11, 14, 10}, "c5089b"));
                            p.a(h, s.d(new byte[]{67, 3, 2, 94, 75, 82, 2, 16, 70, Ascii.ETB, 67, 9, 17, 15, Ascii.NAK, 13}, "1ff797") + str);
                        }
                        httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                        try {
                            httpURLConnection.setInstanceFollowRedirects(false);
                            httpURLConnection.setRequestMethod(i);
                            httpURLConnection.setConnectTimeout(10000);
                            httpURLConnection.setReadTimeout(15000);
                            int responseCode = httpURLConnection.getResponseCode();
                            p.a(h, s.d(new byte[]{113, 83, 123, 9, 93, 93, Ascii.NAK, 11, Ascii.DC4, 66, 86, 0, 68, Ascii.ETB, -34, -55, -124, -46, -48, -26, 19, 16, 93, 95}, "076f34") + str + s.d(new byte[]{108, 98, 82, 69, 17, 87, 15, Ascii.ETB, 3, 33, 94, 1, 86, -33, -117, -84}, "3076a8") + responseCode);
                            if (responseCode / 100 != 5 && responseCode / 100 != 3) {
                                try {
                                    m.a(httpURLConnection);
                                } catch (Exception unused2) {
                                }
                                return true;
                            }
                            if (responseCode / 100 != 3) {
                                break;
                            }
                            i3 = responseCode;
                            httpURLConnection2 = httpURLConnection;
                        } catch (ProtocolException e2) {
                            e = e2;
                            httpURLConnection2 = httpURLConnection;
                            if (TextUtils.isEmpty(e.getMessage()) && e.getMessage().contains(s.d(new byte[]{11, 81, 82, Ascii.EM, 43, 42}, "9ab9da"))) {
                                p.a(h, s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 0, 17, SignedBytes.MAX_POWER_OF_TWO, 14, 89, Ascii.DC2, 1, 70, 1, 94, 1, 87, 69, 11, 67, 65, 5, 81, 84, 74, 66, 83, 16, 85, 69, 17, 68, 0, 67, Ascii.DC4, Ascii.ETB, 70, 14, 88, 11, 87, 69, 11, 67, 65, 94, 15, Ascii.DC2, 7, 14, 88, 1, Ascii.FS}, "2eb0a7"));
                                try {
                                    m.a(httpURLConnection2);
                                } catch (Exception unused3) {
                                }
                                return true;
                            }
                            httpURLConnection = httpURLConnection2;
                        } catch (Exception e3) {
                            e = e3;
                            httpURLConnection2 = httpURLConnection;
                            p.b(h, s.d(new byte[]{113, 17, 17, 19, 100, Ascii.NAK, 8, 8, Ascii.NAK, 66, 85, 10, 126, 0, 17, 34, 85, 44, 14, 10, 15, Ascii.SYN, 94, Ascii.ETB, Ascii.EM, -127, -35, -23, -43, -35, -63, -127, -38, -32, -44, -35, -127, 95}, "9eec1a") + e.getMessage());
                            m.a(httpURLConnection2);
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            httpURLConnection2 = httpURLConnection;
                            try {
                                m.a(httpURLConnection2);
                            } catch (Exception unused4) {
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (ProtocolException e4) {
                    e = e4;
                } catch (Exception e5) {
                    e = e5;
                }
            } catch (Exception unused5) {
            }
        }
        m.a(httpURLConnection);
        return false;
    }
}
