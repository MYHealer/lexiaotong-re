package com.kwad.sdk.core.download;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.core.app.NotificationCompat;
import com.huawei.openalliance.ad.constant.x;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.network.r;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bg;
import com.loopj.android.http.AsyncHttpClient;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a {
    private static Context mContext;
    private static volatile boolean mHasInit;

    /* JADX INFO: renamed from: com.kwad.sdk.core.download.a$a, reason: collision with other inner class name */
    public interface InterfaceC0739a {
        void A(int i, int i2);

        boolean B(int i, int i2);

        void C(int i, int i2);
    }

    public static synchronized void bQ(Context context) {
        if (context != null) {
            if (!mHasInit) {
                mContext = context;
                com.kwad.sdk.c.Ey().init(context);
                b.Lz().init(context);
                mHasInit = true;
            }
        }
    }

    public static String J(AdInfo adInfo) {
        return et(DownloadParams.transform(adInfo).mFileUrl);
    }

    private static String et(String str) {
        if (mContext == null) {
            return "";
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return bg.ef(mContext) + File.separator + eu(str);
    }

    private static String eu(String str) {
        return an.md5(str) + ".apk";
    }

    public static void K(AdInfo adInfo) {
        a(adInfo, false);
    }

    private static void a(AdInfo adInfo, boolean z) {
        try {
            Context context = mContext;
            if (context == null) {
                return;
            }
            if (!aq.isNetworkConnected(context)) {
                Context context2 = mContext;
                ae.V(context2, ag.dk(context2));
                return;
            }
            DownloadParams downloadParamsTransform = DownloadParams.transform(adInfo);
            downloadParamsTransform.requestInstallPermission = false;
            String str = downloadParamsTransform.mFileUrl;
            if (!TextUtils.isEmpty(str) && URLUtil.isNetworkUrl(str)) {
                DownloadTask.DownloadRequest downloadRequest = new DownloadTask.DownloadRequest(downloadParamsTransform.mFileUrl);
                downloadRequest.setDestinationFileName(eu(str));
                downloadRequest.setTag(downloadParamsTransform);
                downloadRequest.setDownloadEnablePause(downloadParamsTransform.downloadEnablePause);
                if (ServiceProvider.getSDKConfig().showNotification && bR(mContext)) {
                    downloadRequest.setNotificationVisibility(3);
                } else {
                    downloadRequest.setNotificationVisibility(0);
                }
                com.kwad.sdk.d.a.a(mContext, downloadParamsTransform.mDownloadid, downloadRequest);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static boolean bR(Context context) {
        try {
            new NotificationCompat.Builder(context, "");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void ev(String str) {
        if (mContext == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.kwad.sdk.d.a.H(mContext, str);
    }

    public static void ew(String str) {
        if (mContext == null) {
            return;
        }
        String strEt = et(str);
        com.kwad.sdk.d.a.e(mContext, an.md5(str), strEt);
    }

    public static boolean d(String str, File file) {
        try {
            return a(str, file, null, false);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void a(String str, File file, boolean z) {
        a(str, file, null, true);
    }

    private static URLConnection ex(String str) throws IOException {
        URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
        r.wrapHttpURLConnection(uRLConnectionOpenConnection);
        uRLConnectionOpenConnection.setRequestProperty("Accept-Language", com.huawei.openalliance.ad.utils.bg.Code);
        uRLConnectionOpenConnection.setConnectTimeout(10000);
        uRLConnectionOpenConnection.setReadTimeout(120000);
        uRLConnectionOpenConnection.setUseCaches(false);
        uRLConnectionOpenConnection.setDoInput(true);
        uRLConnectionOpenConnection.setRequestProperty("Connection", "keep-alive");
        uRLConnectionOpenConnection.setRequestProperty("Charset", "UTF-8");
        return uRLConnectionOpenConnection;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0189 A[Catch: all -> 0x01b6, TryCatch #6 {all -> 0x01b6, blocks: (B:98:0x0185, B:100:0x0189, B:102:0x01b5, B:101:0x018c), top: B:123:0x0185 }] */
    /* JADX WARN: Code duplicated, block: B:101:0x018c A[Catch: all -> 0x01b6, TryCatch #6 {all -> 0x01b6, blocks: (B:98:0x0185, B:100:0x0189, B:102:0x01b5, B:101:0x018c), top: B:123:0x0185 }] */
    /* JADX WARN: Code duplicated, block: B:115:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:133:0x0118 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:139:0x00c7 A[EDGE_INSN: B:139:0x00c7->B:37:0x00c7 BREAK  A[LOOP:0: B:34:0x00bc->B:36:0x00c2], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:140:0x0144 A[EDGE_INSN: B:140:0x0144->B:70:0x0144 BREAK  A[LOOP:1: B:65:0x0134->B:142:0x0134], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:141:0x0140 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:143:0x0134 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x006c A[Catch: all -> 0x0169, TRY_ENTER, TryCatch #3 {all -> 0x0169, blocks: (B:18:0x0058, B:25:0x0075, B:29:0x0087, B:24:0x006c), top: B:117:0x0058 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0087 A[Catch: all -> 0x0169, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0169, blocks: (B:18:0x0058, B:25:0x0075, B:29:0x0087, B:24:0x006c), top: B:117:0x0058 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00c2 A[Catch: all -> 0x00f7, LOOP:0: B:34:0x00bc->B:36:0x00c2, LOOP_END, TryCatch #8 {all -> 0x00f7, blocks: (B:33:0x00b9, B:34:0x00bc, B:36:0x00c2, B:37:0x00c7), top: B:127:0x00b9 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0109  */
    /* JADX WARN: Code duplicated, block: B:51:0x0112  */
    /* JADX WARN: Code duplicated, block: B:52:0x0114  */
    /* JADX WARN: Code duplicated, block: B:57:0x011e  */
    /* JADX WARN: Code duplicated, block: B:59:0x0126  */
    /* JADX WARN: Code duplicated, block: B:62:0x012e  */
    /* JADX WARN: Code duplicated, block: B:67:0x013a A[Catch: all -> 0x015e, TryCatch #11 {all -> 0x015e, blocks: (B:55:0x0118, B:64:0x0132, B:65:0x0134, B:67:0x013a, B:69:0x0140, B:71:0x0146), top: B:133:0x0118 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0146 A[Catch: all -> 0x015e, TRY_LEAVE, TryCatch #11 {all -> 0x015e, blocks: (B:55:0x0118, B:64:0x0132, B:65:0x0134, B:67:0x013a, B:69:0x0140, B:71:0x0146), top: B:133:0x0118 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0151  */
    /* JADX WARN: Code duplicated, block: B:77:0x0159  */
    public static boolean a(String str, File file, InterfaceC0739a interfaceC0739a, boolean z) throws IOException {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        File file2;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        long length;
        InputStream bufferedInputStream;
        HttpURLConnection httpURLConnection2;
        int contentLength;
        HashMap map;
        BufferedInputStream bufferedInputStream2;
        int i;
        int i2;
        byte[] bArr;
        int i3;
        File file3;
        FileOutputStream fileOutputStream3;
        byte[] bArr2;
        int i4;
        int i5;
        BufferedInputStream bufferedInputStream3;
        try {
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) ex(str);
            if (z) {
                try {
                    length = file.length();
                    fileOutputStream2 = new FileOutputStream(file, true);
                    if (length > 0) {
                        try {
                            httpURLConnection3.setRequestProperty("Range", String.format("bytes=%s-%s", Long.valueOf(length), ""));
                            try {
                                p.b(httpURLConnection3);
                                httpURLConnection3.setRequestProperty("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
                                bufferedInputStream = new BufferedInputStream(httpURLConnection3.getInputStream());
                                try {
                                    contentLength = httpURLConnection3.getContentLength();
                                    if (httpURLConnection3.getHeaderFields() == null) {
                                        try {
                                            map = new HashMap();
                                        } catch (Throwable th) {
                                            th = th;
                                            httpURLConnection = httpURLConnection3;
                                            inputStream = bufferedInputStream;
                                            file2 = null;
                                            fileOutputStream = null;
                                            if (th instanceof IOException) {
                                                throw th;
                                            }
                                            throw new IOException(th.getClass().getName() + x.bQ + th.getMessage(), th);
                                        }
                                    } else {
                                        map = new HashMap(httpURLConnection3.getHeaderFields());
                                    }
                                    bufferedInputStream2 = new BufferedInputStream(httpURLConnection3.getInputStream());
                                    try {
                                        bufferedInputStream = a(map, bufferedInputStream2);
                                        if (contentLength <= 0) {
                                            httpURLConnection2 = httpURLConnection3;
                                            try {
                                                file3 = new File(bg.eg(mContext), new Random(System.currentTimeMillis()).nextInt() + ".tmp");
                                                try {
                                                    fileOutputStream3 = new FileOutputStream(file3);
                                                    try {
                                                        bArr2 = new byte[8192];
                                                        i4 = 0;
                                                        while (true) {
                                                            i5 = bufferedInputStream.read(bArr2);
                                                            if (i5 == -1) {
                                                                break;
                                                            }
                                                            i4 += i5;
                                                            fileOutputStream3.write(bArr2, 0, i5);
                                                        }
                                                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                                                        com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream3);
                                                        bufferedInputStream3 = new BufferedInputStream(new FileInputStream(file3));
                                                        try {
                                                            map.put("Content-Length", Collections.singletonList(String.valueOf(i4)));
                                                            contentLength = i4;
                                                            file2 = file3;
                                                            inputStream = bufferedInputStream3;
                                                            fileOutputStream = fileOutputStream3;
                                                        } catch (Throwable th2) {
                                                            th = th2;
                                                            httpURLConnection = httpURLConnection2;
                                                            file2 = file3;
                                                            inputStream = bufferedInputStream3;
                                                            fileOutputStream = fileOutputStream3;
                                                        }
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                        httpURLConnection = httpURLConnection2;
                                                        fileOutputStream = fileOutputStream3;
                                                        file2 = file3;
                                                        inputStream = bufferedInputStream;
                                                    }
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    httpURLConnection = httpURLConnection2;
                                                    file2 = file3;
                                                    inputStream = bufferedInputStream;
                                                    fileOutputStream = null;
                                                }
                                            } catch (Throwable th5) {
                                                th = th5;
                                                httpURLConnection = httpURLConnection2;
                                                inputStream = bufferedInputStream;
                                                file2 = null;
                                                fileOutputStream = null;
                                                if (th instanceof IOException) {
                                                    throw th;
                                                }
                                                throw new IOException(th.getClass().getName() + x.bQ + th.getMessage(), th);
                                            }
                                        } else {
                                            httpURLConnection2 = httpURLConnection3;
                                            inputStream = bufferedInputStream;
                                            file2 = null;
                                            fileOutputStream = null;
                                        }
                                        if (length > 0) {
                                            i = (int) length;
                                        } else {
                                            i = 0;
                                        }
                                        i2 = contentLength + i;
                                        if (interfaceC0739a != null) {
                                            try {
                                                if (!interfaceC0739a.B(i, i2)) {
                                                    com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream2);
                                                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                                                    if (httpURLConnection2 != null) {
                                                        httpURLConnection2.disconnect();
                                                    }
                                                    com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                                                    if (file2 != null) {
                                                        file2.delete();
                                                    }
                                                    return false;
                                                }
                                            } catch (Throwable th6) {
                                                th = th6;
                                                httpURLConnection = httpURLConnection2;
                                            }
                                        }
                                        bArr = new byte[8192];
                                        while (true) {
                                            i3 = inputStream.read(bArr);
                                            if (i3 == -1) {
                                                break;
                                            }
                                            i += i3;
                                            fileOutputStream2.write(bArr, 0, i3);
                                            if (interfaceC0739a != null) {
                                                interfaceC0739a.A(i, i2);
                                            }
                                        }
                                        if (interfaceC0739a != null) {
                                            interfaceC0739a.C(i2, i2);
                                        }
                                        com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream2);
                                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                                        if (httpURLConnection2 != null) {
                                            httpURLConnection2.disconnect();
                                        }
                                        com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                                        if (file2 == null) {
                                            return true;
                                        }
                                        file2.delete();
                                        return true;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        httpURLConnection = httpURLConnection3;
                                        inputStream = bufferedInputStream2;
                                        file2 = null;
                                        fileOutputStream = null;
                                        if (th instanceof IOException) {
                                            throw th;
                                        }
                                        throw new IOException(th.getClass().getName() + x.bQ + th.getMessage(), th);
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                    httpURLConnection2 = httpURLConnection3;
                                }
                            } catch (Throwable th9) {
                                th = th9;
                                httpURLConnection = httpURLConnection3;
                                inputStream = null;
                                file2 = null;
                                fileOutputStream = null;
                                if (th instanceof IOException) {
                                    throw th;
                                }
                                throw new IOException(th.getClass().getName() + x.bQ + th.getMessage(), th);
                            }
                        } catch (Throwable th10) {
                            th = th10;
                            httpURLConnection = httpURLConnection3;
                            inputStream = null;
                            file2 = null;
                            fileOutputStream = null;
                            if (th instanceof IOException) {
                                throw th;
                            }
                            throw new IOException(th.getClass().getName() + x.bQ + th.getMessage(), th);
                        }
                    } else {
                        p.b(httpURLConnection3);
                        httpURLConnection3.setRequestProperty("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
                        bufferedInputStream = new BufferedInputStream(httpURLConnection3.getInputStream());
                        contentLength = httpURLConnection3.getContentLength();
                        if (httpURLConnection3.getHeaderFields() == null) {
                            map = new HashMap();
                        } else {
                            map = new HashMap(httpURLConnection3.getHeaderFields());
                        }
                        bufferedInputStream2 = new BufferedInputStream(httpURLConnection3.getInputStream());
                        bufferedInputStream = a(map, bufferedInputStream2);
                        if (contentLength <= 0) {
                            httpURLConnection2 = httpURLConnection3;
                            file3 = new File(bg.eg(mContext), new Random(System.currentTimeMillis()).nextInt() + ".tmp");
                            fileOutputStream3 = new FileOutputStream(file3);
                            bArr2 = new byte[8192];
                            i4 = 0;
                            while (true) {
                                i5 = bufferedInputStream.read(bArr2);
                                if (i5 == -1) {
                                    break;
                                    break;
                                }
                                i4 += i5;
                                fileOutputStream3.write(bArr2, 0, i5);
                            }
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream3);
                            bufferedInputStream3 = new BufferedInputStream(new FileInputStream(file3));
                            map.put("Content-Length", Collections.singletonList(String.valueOf(i4)));
                            contentLength = i4;
                            file2 = file3;
                            inputStream = bufferedInputStream3;
                            fileOutputStream = fileOutputStream3;
                        } else {
                            httpURLConnection2 = httpURLConnection3;
                            inputStream = bufferedInputStream;
                            file2 = null;
                            fileOutputStream = null;
                        }
                        if (length > 0) {
                            i = (int) length;
                        } else {
                            i = 0;
                        }
                        i2 = contentLength + i;
                        if (interfaceC0739a != null) {
                            if (!interfaceC0739a.B(i, i2)) {
                                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream2);
                                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                                if (file2 != null) {
                                    file2.delete();
                                }
                                return false;
                            }
                        }
                        bArr = new byte[8192];
                        while (true) {
                            i3 = inputStream.read(bArr);
                            if (i3 == -1) {
                                break;
                                break;
                            }
                            i += i3;
                            fileOutputStream2.write(bArr, 0, i3);
                            if (interfaceC0739a != null) {
                                interfaceC0739a.A(i, i2);
                            }
                        }
                        if (interfaceC0739a != null) {
                            interfaceC0739a.C(i2, i2);
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                        if (file2 == null) {
                            return true;
                        }
                        file2.delete();
                        return true;
                    }
                } catch (Throwable th11) {
                    th = th11;
                    httpURLConnection = httpURLConnection3;
                    inputStream = null;
                    file2 = null;
                    fileOutputStream = null;
                    fileOutputStream2 = null;
                }
            } else {
                try {
                    fileOutputStream2 = new FileOutputStream(file, false);
                    length = -1;
                    p.b(httpURLConnection3);
                    httpURLConnection3.setRequestProperty("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
                    bufferedInputStream = new BufferedInputStream(httpURLConnection3.getInputStream());
                    contentLength = httpURLConnection3.getContentLength();
                    if (httpURLConnection3.getHeaderFields() == null) {
                        map = new HashMap();
                    } else {
                        map = new HashMap(httpURLConnection3.getHeaderFields());
                    }
                    bufferedInputStream2 = new BufferedInputStream(httpURLConnection3.getInputStream());
                    bufferedInputStream = a(map, bufferedInputStream2);
                    if (contentLength <= 0) {
                        httpURLConnection2 = httpURLConnection3;
                        file3 = new File(bg.eg(mContext), new Random(System.currentTimeMillis()).nextInt() + ".tmp");
                        fileOutputStream3 = new FileOutputStream(file3);
                        bArr2 = new byte[8192];
                        i4 = 0;
                        while (true) {
                            i5 = bufferedInputStream.read(bArr2);
                            if (i5 == -1) {
                                break;
                                break;
                            }
                            i4 += i5;
                            fileOutputStream3.write(bArr2, 0, i5);
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream3);
                        bufferedInputStream3 = new BufferedInputStream(new FileInputStream(file3));
                        map.put("Content-Length", Collections.singletonList(String.valueOf(i4)));
                        contentLength = i4;
                        file2 = file3;
                        inputStream = bufferedInputStream3;
                        fileOutputStream = fileOutputStream3;
                    } else {
                        httpURLConnection2 = httpURLConnection3;
                        inputStream = bufferedInputStream;
                        file2 = null;
                        fileOutputStream = null;
                    }
                    if (length > 0) {
                        i = (int) length;
                    } else {
                        i = 0;
                    }
                    i2 = contentLength + i;
                    if (interfaceC0739a != null) {
                        if (!interfaceC0739a.B(i, i2)) {
                            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream2);
                            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                            if (file2 != null) {
                                file2.delete();
                            }
                            return false;
                        }
                    }
                    bArr = new byte[8192];
                    while (true) {
                        i3 = inputStream.read(bArr);
                        if (i3 == -1) {
                            break;
                            break;
                        }
                        i += i3;
                        fileOutputStream2.write(bArr, 0, i3);
                        if (interfaceC0739a != null) {
                            interfaceC0739a.A(i, i2);
                        }
                    }
                    if (interfaceC0739a != null) {
                        interfaceC0739a.C(i2, i2);
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream2);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                    if (file2 == null) {
                        return true;
                    }
                    file2.delete();
                    return true;
                } catch (Throwable th12) {
                    th = th12;
                    httpURLConnection = httpURLConnection3;
                    inputStream = null;
                    file2 = null;
                    fileOutputStream = null;
                    fileOutputStream2 = null;
                }
            }
        } catch (Throwable th13) {
            th = th13;
            httpURLConnection = null;
        }
        try {
            if (th instanceof IOException) {
                throw th;
            }
            throw new IOException(th.getClass().getName() + x.bQ + th.getMessage(), th);
        } catch (Throwable th14) {
            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream2);
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
            if (file2 != null) {
                file2.delete();
            }
            throw th14;
        }
    }

    private static InputStream a(Map<String, List<String>> map, InputStream inputStream) {
        List<String> value;
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if ("Content-Encoding".equalsIgnoreCase(entry.getKey()) && (value = entry.getValue()) != null && !value.isEmpty()) {
                Iterator<String> it = value.iterator();
                while (it.hasNext()) {
                    if (AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(it.next())) {
                        try {
                            return new GZIPInputStream(inputStream);
                        } catch (IOException unused) {
                            continue;
                        }
                    }
                }
            }
        }
        return inputStream;
    }
}
