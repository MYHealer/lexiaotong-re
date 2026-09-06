package com.hihonor.hianalytics.hnha;

import android.text.TextUtils;
import com.heytap.msp.mobad.api.ad.IBidding;
import com.hihonor.hianalytics.util.SystemUtils;
import com.hihonor.secure.android.common.ssl.SSFCompatiableSystemCA;
import com.hihonor.secure.android.common.ssl.hostname.StrictHostnameVerifier;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public abstract class l3 {

    private static class a extends Exception {
        a(String str) {
            super(str);
        }
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:51:0x00b6 A[Catch: all -> 0x0110, TryCatch #6 {all -> 0x0110, blocks: (B:14:0x0031, B:47:0x00ac, B:50:0x00b2, B:68:0x0103, B:51:0x00b6, B:55:0x00c0, B:57:0x00c4, B:58:0x00ca, B:60:0x00ce, B:61:0x00d6, B:63:0x00da, B:64:0x00e2, B:66:0x00e6, B:67:0x00ee, B:43:0x0093), top: B:78:0x0017 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:55:0x00c0 A[Catch: all -> 0x0110, TryCatch #6 {all -> 0x0110, blocks: (B:14:0x0031, B:47:0x00ac, B:50:0x00b2, B:68:0x0103, B:51:0x00b6, B:55:0x00c0, B:57:0x00c4, B:58:0x00ca, B:60:0x00ce, B:61:0x00d6, B:63:0x00da, B:64:0x00e2, B:66:0x00e6, B:67:0x00ee, B:43:0x0093), top: B:78:0x0017 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00c4 A[Catch: all -> 0x0110, TryCatch #6 {all -> 0x0110, blocks: (B:14:0x0031, B:47:0x00ac, B:50:0x00b2, B:68:0x0103, B:51:0x00b6, B:55:0x00c0, B:57:0x00c4, B:58:0x00ca, B:60:0x00ce, B:61:0x00d6, B:63:0x00da, B:64:0x00e2, B:66:0x00e6, B:67:0x00ee, B:43:0x0093), top: B:78:0x0017 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00ca A[Catch: all -> 0x0110, TryCatch #6 {all -> 0x0110, blocks: (B:14:0x0031, B:47:0x00ac, B:50:0x00b2, B:68:0x0103, B:51:0x00b6, B:55:0x00c0, B:57:0x00c4, B:58:0x00ca, B:60:0x00ce, B:61:0x00d6, B:63:0x00da, B:64:0x00e2, B:66:0x00e6, B:67:0x00ee, B:43:0x0093), top: B:78:0x0017 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x00ce A[Catch: all -> 0x0110, TryCatch #6 {all -> 0x0110, blocks: (B:14:0x0031, B:47:0x00ac, B:50:0x00b2, B:68:0x0103, B:51:0x00b6, B:55:0x00c0, B:57:0x00c4, B:58:0x00ca, B:60:0x00ce, B:61:0x00d6, B:63:0x00da, B:64:0x00e2, B:66:0x00e6, B:67:0x00ee, B:43:0x0093), top: B:78:0x0017 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x00d6 A[Catch: all -> 0x0110, TryCatch #6 {all -> 0x0110, blocks: (B:14:0x0031, B:47:0x00ac, B:50:0x00b2, B:68:0x0103, B:51:0x00b6, B:55:0x00c0, B:57:0x00c4, B:58:0x00ca, B:60:0x00ce, B:61:0x00d6, B:63:0x00da, B:64:0x00e2, B:66:0x00e6, B:67:0x00ee, B:43:0x0093), top: B:78:0x0017 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x00da A[Catch: all -> 0x0110, TryCatch #6 {all -> 0x0110, blocks: (B:14:0x0031, B:47:0x00ac, B:50:0x00b2, B:68:0x0103, B:51:0x00b6, B:55:0x00c0, B:57:0x00c4, B:58:0x00ca, B:60:0x00ce, B:61:0x00d6, B:63:0x00da, B:64:0x00e2, B:66:0x00e6, B:67:0x00ee, B:43:0x0093), top: B:78:0x0017 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x00e2 A[Catch: all -> 0x0110, TryCatch #6 {all -> 0x0110, blocks: (B:14:0x0031, B:47:0x00ac, B:50:0x00b2, B:68:0x0103, B:51:0x00b6, B:55:0x00c0, B:57:0x00c4, B:58:0x00ca, B:60:0x00ce, B:61:0x00d6, B:63:0x00da, B:64:0x00e2, B:66:0x00e6, B:67:0x00ee, B:43:0x0093), top: B:78:0x0017 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x00e6 A[Catch: all -> 0x0110, TryCatch #6 {all -> 0x0110, blocks: (B:14:0x0031, B:47:0x00ac, B:50:0x00b2, B:68:0x0103, B:51:0x00b6, B:55:0x00c0, B:57:0x00c4, B:58:0x00ca, B:60:0x00ce, B:61:0x00d6, B:63:0x00da, B:64:0x00e2, B:66:0x00e6, B:67:0x00ee, B:43:0x0093), top: B:78:0x0017 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x00ee A[Catch: all -> 0x0110, TryCatch #6 {all -> 0x0110, blocks: (B:14:0x0031, B:47:0x00ac, B:50:0x00b2, B:68:0x0103, B:51:0x00b6, B:55:0x00c0, B:57:0x00c4, B:58:0x00ca, B:60:0x00ce, B:61:0x00d6, B:63:0x00da, B:64:0x00e2, B:66:0x00e6, B:67:0x00ee, B:43:0x0093), top: B:78:0x0017 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12, types: [java.io.Closeable, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.net.HttpURLConnection] */
    public static m3 a(String str, byte[] bArr, String str2, Map<String, String> map) throws Throwable {
        Map<String, List<String>> map2;
        IOException e;
        int responseCode;
        Map<String, List<String>> map3;
        ?? r10;
        ?? r8;
        ?? r11;
        ?? r9;
        String str3;
        m3 m3Var;
        ?? r12;
        if (TextUtils.isEmpty(str)) {
            return new m3(-100, "");
        }
        int i = IBidding.ECPM_PRICE_STATUS_NULL_AD;
        BufferedOutputStream bufferedOutputStream = null;
        headerFields = null;
        headerFields = null;
        Map<String, List<String>> headerFields = null;
        bufferedOutputStream = null;
        BufferedOutputStream bufferedOutputStream2 = null;
        BufferedOutputStream bufferedOutputStream3 = null;
        bufferedOutputStream = null;
        try {
            try {
                try {
                    str = a((String) str, bArr.length, (String) str2, map);
                    try {
                        if (str == 0) {
                            m3Var = new m3(-100, "");
                            com.hihonor.hianalytics.util.k.a((Closeable) null);
                            com.hihonor.hianalytics.util.k.a((Closeable) null);
                            r12 = str;
                            com.hihonor.hianalytics.util.k.a((HttpURLConnection) r12);
                            return m3Var;
                        }
                        str2 = str.getOutputStream();
                        try {
                            BufferedOutputStream bufferedOutputStream4 = new BufferedOutputStream(str2);
                            try {
                                try {
                                    bufferedOutputStream4.write(bArr);
                                    bufferedOutputStream4.flush();
                                    responseCode = str.getResponseCode();
                                    try {
                                        headerFields = str.getHeaderFields();
                                        m3 m3Var2 = new m3(responseCode, b(str), headerFields);
                                        com.hihonor.hianalytics.util.k.a(bufferedOutputStream4);
                                        com.hihonor.hianalytics.util.k.a((Closeable) str2);
                                        com.hihonor.hianalytics.util.k.a((HttpURLConnection) str);
                                        return m3Var2;
                                    } catch (IOException e2) {
                                        e = e2;
                                        Map<String, List<String>> map4 = headerFields;
                                        bufferedOutputStream2 = bufferedOutputStream4;
                                        map3 = map4;
                                        r9 = str;
                                        r11 = str2;
                                        if (e instanceof SSLPeerUnverifiedException) {
                                            if (e instanceof SSLHandshakeException) {
                                                str3 = "Chain validation failed,Certificate expired";
                                            } else if (e instanceof ConnectException) {
                                                j2.g("HttpClient", "Network is unreachable or Connection refused");
                                            } else if (e instanceof UnknownHostException) {
                                                j2.g("HttpClient", "No address associated with hostname");
                                                i = IBidding.ECPM_PRICE_STATUS_NULL_CHANNEL_ENTITY;
                                            } else if (e instanceof SocketTimeoutException) {
                                                j2.g("HttpClient", "failed to connect to this address,pls check url: time out");
                                                i = IBidding.ECPM_PRICE_STATUS_BIDDING_OUT_DISABLE;
                                            } else if (e instanceof MalformedURLException) {
                                                j2.g("HttpClient", "Unknown protocol,pls check url");
                                                i = -108;
                                            } else {
                                                j2.g("HttpClient", "events PostRequest(byte[]): Exception=" + SystemUtils.getDesensitizedException(e));
                                                i = responseCode;
                                            }
                                            m3Var = new m3(i, "", map3);
                                            com.hihonor.hianalytics.util.k.a(bufferedOutputStream2);
                                            com.hihonor.hianalytics.util.k.a((Closeable) r11);
                                            r12 = r9;
                                            com.hihonor.hianalytics.util.k.a((HttpURLConnection) r12);
                                            return m3Var;
                                        }
                                        str3 = "Certificate has not been verified,Request is restricted!";
                                        j2.g("HttpClient", str3);
                                        i = -106;
                                        m3Var = new m3(i, "", map3);
                                        com.hihonor.hianalytics.util.k.a(bufferedOutputStream2);
                                        com.hihonor.hianalytics.util.k.a((Closeable) r11);
                                        r12 = r9;
                                        com.hihonor.hianalytics.util.k.a((HttpURLConnection) r12);
                                        return m3Var;
                                    }
                                } catch (IOException e3) {
                                    e = e3;
                                    responseCode = -103;
                                }
                            } catch (SecurityException unused) {
                                map2 = headerFields;
                                bufferedOutputStream3 = bufferedOutputStream4;
                                r8 = str;
                                r10 = str2;
                                j2.g("HttpClient", "SecurityException with HttpClient. Please check INTERNET permission.");
                                m3 m3Var3 = new m3(IBidding.ECPM_STATUS_NULL_AD_IMPL, "", map2);
                                com.hihonor.hianalytics.util.k.a(bufferedOutputStream3);
                                com.hihonor.hianalytics.util.k.a((Closeable) r10);
                                com.hihonor.hianalytics.util.k.a((HttpURLConnection) r8);
                                return m3Var3;
                            } catch (Throwable th) {
                                th = th;
                                bufferedOutputStream = bufferedOutputStream4;
                                com.hihonor.hianalytics.util.k.a(bufferedOutputStream);
                                com.hihonor.hianalytics.util.k.a((Closeable) str2);
                                com.hihonor.hianalytics.util.k.a((HttpURLConnection) str);
                                throw th;
                            }
                        } catch (IOException e4) {
                            e = e4;
                            e = e;
                            responseCode = -103;
                            map3 = null;
                            r9 = str;
                            r11 = str2;
                            if (e instanceof SSLPeerUnverifiedException) {
                                if (e instanceof SSLHandshakeException) {
                                    str3 = "Chain validation failed,Certificate expired";
                                } else if (e instanceof ConnectException) {
                                    j2.g("HttpClient", "Network is unreachable or Connection refused");
                                } else if (e instanceof UnknownHostException) {
                                    j2.g("HttpClient", "No address associated with hostname");
                                    i = IBidding.ECPM_PRICE_STATUS_NULL_CHANNEL_ENTITY;
                                } else if (e instanceof SocketTimeoutException) {
                                    j2.g("HttpClient", "failed to connect to this address,pls check url: time out");
                                    i = IBidding.ECPM_PRICE_STATUS_BIDDING_OUT_DISABLE;
                                } else if (e instanceof MalformedURLException) {
                                    j2.g("HttpClient", "Unknown protocol,pls check url");
                                    i = -108;
                                } else {
                                    j2.g("HttpClient", "events PostRequest(byte[]): Exception=" + SystemUtils.getDesensitizedException(e));
                                    i = responseCode;
                                }
                                m3Var = new m3(i, "", map3);
                                com.hihonor.hianalytics.util.k.a(bufferedOutputStream2);
                                com.hihonor.hianalytics.util.k.a((Closeable) r11);
                                r12 = r9;
                                com.hihonor.hianalytics.util.k.a((HttpURLConnection) r12);
                                return m3Var;
                            }
                            str3 = "Certificate has not been verified,Request is restricted!";
                            j2.g("HttpClient", str3);
                            i = -106;
                            m3Var = new m3(i, "", map3);
                            com.hihonor.hianalytics.util.k.a(bufferedOutputStream2);
                            com.hihonor.hianalytics.util.k.a((Closeable) r11);
                            r12 = r9;
                            com.hihonor.hianalytics.util.k.a((HttpURLConnection) r12);
                            return m3Var;
                        } catch (SecurityException unused2) {
                            map2 = null;
                            r8 = str;
                            r10 = str2;
                            j2.g("HttpClient", "SecurityException with HttpClient. Please check INTERNET permission.");
                            m3 m3Var4 = new m3(IBidding.ECPM_STATUS_NULL_AD_IMPL, "", map2);
                            com.hihonor.hianalytics.util.k.a(bufferedOutputStream3);
                            com.hihonor.hianalytics.util.k.a((Closeable) r10);
                            com.hihonor.hianalytics.util.k.a((HttpURLConnection) r8);
                            return m3Var4;
                        }
                    } catch (IOException e5) {
                        e = e5;
                        str2 = 0;
                    } catch (SecurityException unused3) {
                        str2 = 0;
                    } catch (Throwable th2) {
                        th = th2;
                        str2 = 0;
                    }
                } catch (a unused4) {
                    j2.g("HttpClient", "PostRequest(byte[]): No ssl socket factory set!");
                    m3 m3Var5 = new m3(IBidding.ECPM_PRICE_STATUS_LESS_ZERO, "");
                    com.hihonor.hianalytics.util.k.a((Closeable) null);
                    com.hihonor.hianalytics.util.k.a((Closeable) null);
                    com.hihonor.hianalytics.util.k.a((HttpURLConnection) null);
                    return m3Var5;
                }
            } catch (IOException e6) {
                e = e6;
                str = 0;
                str2 = 0;
            } catch (SecurityException unused5) {
                str = 0;
                str2 = 0;
            } catch (Throwable th3) {
                th = th3;
                str = 0;
                str2 = 0;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static m3 a(String str, byte[] bArr, Map<String, String> map) {
        return a(str, bArr, "POST", map);
    }

    private static HttpURLConnection a(String str, int i, String str2, Map<String, String> map) throws a, ProtocolException {
        if (TextUtils.isEmpty(str)) {
            j2.b("HttpClient", "CreateConnection: invalid urlPath.");
            return null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        a(httpURLConnection);
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
        httpURLConnection.setReadTimeout(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(i));
        httpURLConnection.setRequestProperty("App-Ver", "1.0.5.300");
        httpURLConnection.setRequestProperty("Connection", "close");
        if (map != null && map.size() >= 1) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null && !TextUtils.isEmpty(key)) {
                    httpURLConnection.setRequestProperty(key, entry.getValue());
                }
            }
        }
        return httpURLConnection;
    }

    private static void a(HttpURLConnection httpURLConnection) throws a {
        String str;
        SSFCompatiableSystemCA sSFCompatiableSystemCA;
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            try {
                sSFCompatiableSystemCA = SSFCompatiableSystemCA.getInstance(SystemUtils.getContext());
            } catch (IOException unused) {
                str = "getSocketFactory(): IO Exception!";
                j2.g("HttpClient", str);
                sSFCompatiableSystemCA = null;
            } catch (KeyStoreException unused2) {
                str = "getSocketFactory(): Key Store exception";
                j2.g("HttpClient", str);
                sSFCompatiableSystemCA = null;
            } catch (NoSuchAlgorithmException unused3) {
                str = "getSocketFactory(): Algorithm Exception!";
                j2.g("HttpClient", str);
                sSFCompatiableSystemCA = null;
            } catch (GeneralSecurityException unused4) {
                str = "getSocketFactory(): General Security Exception";
                j2.g("HttpClient", str);
                sSFCompatiableSystemCA = null;
            }
            if (sSFCompatiableSystemCA == null) {
                throw new a("No ssl socket factory set");
            }
            httpsURLConnection.setSSLSocketFactory(sSFCompatiableSystemCA);
            httpsURLConnection.setHostnameVerifier(new StrictHostnameVerifier());
        }
    }

    private static String b(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            return com.hihonor.hianalytics.util.j.a(inputStream, 2048);
        } catch (IOException unused) {
            j2.g("HttpClient", "When Response Content From Connection inputStream operation exception!", Integer.valueOf(httpURLConnection.getResponseCode()));
            return "";
        } finally {
            com.hihonor.hianalytics.util.k.a(inputStream);
        }
    }
}
