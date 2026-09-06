package com.fancy.adsdk.lib.core.net;

import android.net.Uri;
import android.text.TextUtils;
import com.fancy._e7;
import com.fancy._gw;
import com.fancy._ie;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.fancy.adsdk.lib.utils.Logger;
import com.loopj.android.http.AsyncHttpClient;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.NotActiveException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class NetUtils {
    public static final _f _a = new _f();
    public static final LinkedBlockingQueue _b = new LinkedBlockingQueue();
    public static final LinkedBlockingQueue _c = new LinkedBlockingQueue();
    public static final _b _d = new _b(TimeUnit.SECONDS, new ArrayBlockingQueue(60), new _a(), new ThreadPoolExecutor.CallerRunsPolicy());

    public class _a implements ThreadFactory {
        public final AtomicInteger _a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, _ie._a("ClassNetUtils-").append(this._a.getAndIncrement()).toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    public class _b extends ThreadPoolExecutor {
        public _b(TimeUnit timeUnit, ArrayBlockingQueue arrayBlockingQueue, _a _aVar, ThreadPoolExecutor.CallerRunsPolicy callerRunsPolicy) {
            super(4, 10, 60L, timeUnit, arrayBlockingQueue, _aVar, callerRunsPolicy);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public final void beforeExecute(Thread thread, Runnable runnable) {
            super.beforeExecute(thread, runnable);
            allowCoreThreadTimeOut(true);
        }
    }

    public class _c implements Runnable {

        public class _a implements Runnable {
            public final /* synthetic */ com.fancy.adsdk.lib.core.net._a _a;

            public _a(com.fancy.adsdk.lib.core.net._a _aVar) {
                this._a = _aVar;
            }

            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                try {
                    NetUtils._b(this._a);
                } catch (Exception unused) {
                }
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    for (com.fancy.adsdk.lib.core.net._a _aVar : (List) NetUtils._c.take()) {
                        if (_aVar != null) {
                            NetUtils._d.execute(new _a(_aVar));
                        }
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                } catch (Exception unused2) {
                }
            }
        }
    }

    public class _d implements Runnable {

        public class _a implements Runnable {
            public final /* synthetic */ com.fancy.adsdk.lib.core.net._a _a;

            public _a(com.fancy.adsdk.lib.core.net._a _aVar) {
                this._a = _aVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    NetUtils._a(this._a);
                } catch (Exception unused) {
                }
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    com.fancy.adsdk.lib.core.net._a _aVar = (com.fancy.adsdk.lib.core.net._a) NetUtils._b.take();
                    if (_aVar != null) {
                        NetUtils._d.execute(new _a(_aVar));
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                } catch (Exception unused2) {
                }
            }
        }
    }

    public static class _e implements Runnable {
        public final List<String> _a;
        public final HashMap<String, String> _b;

        public _e(List list) {
            this._a = list == null ? Collections.emptyList() : list;
            this._b = new HashMap<>();
        }

        @Override // java.lang.Runnable
        public final void run() {
            NetUtils._a(this._a, this._b);
        }
    }

    public static class _f implements _e7 {
        @Override // com.fancy._e7
        public final void _a(com.fancy.adsdk.lib.core.net._a _aVar) {
        }

        @Override // com.fancy._e7
        public final void _a(com.fancy.adsdk.lib.core.net._a _aVar, int i, String str) {
        }
    }

    static {
        Thread thread = new Thread(new _c(), "Report_Thread");
        Thread thread2 = new Thread(new _d(), "Simple_Thread");
        thread.setDaemon(true);
        thread.start();
        thread2.setDaemon(true);
        thread2.start();
    }

    public static InputStream _a(InputStream inputStream, String str) throws IOException {
        if (!AsyncHttpClient.ENCODING_GZIP.equals(str)) {
            return inputStream;
        }
        try {
            return new GZIPInputStream(inputStream);
        } catch (IOException e) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            throw e;
        }
    }

    /* JADX WARN: Code duplicated, block: B:47:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x0049 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:? A[SYNTHETIC] */
    public static String _a(HttpURLConnection httpURLConnection) throws Throwable {
        InputStream inputStream;
        InputStream errorStream;
        Throwable th;
        BufferedReader bufferedReader = null;
        try {
            try {
                errorStream = httpURLConnection.getInputStream();
            } catch (IOException unused) {
                errorStream = httpURLConnection.getErrorStream();
            }
            if (errorStream == null) {
                if (errorStream != null) {
                    try {
                        errorStream.close();
                    } catch (IOException unused2) {
                    }
                }
                return null;
            }
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(errorStream, "UTF-8"));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                    }
                    String string = sb.toString();
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused3) {
                    }
                    try {
                        errorStream.close();
                    } catch (IOException unused4) {
                    }
                    return string;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused5) {
                        }
                    }
                    if (errorStream == null) {
                        throw th;
                    }
                    try {
                        errorStream.close();
                        throw th;
                    } catch (IOException unused6) {
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                inputStream = errorStream;
                th = th3;
                InputStream inputStream2 = inputStream;
                th = th;
                errorStream = inputStream2;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (errorStream == null) {
                    throw th;
                }
                errorStream.close();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
            InputStream inputStream3 = inputStream;
            th = th;
            errorStream = inputStream3;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (errorStream == null) {
                throw th;
            }
            errorStream.close();
            throw th;
        }
    }

    public static void _a(com.fancy.adsdk.lib.core.net._a _aVar) {
        String message;
        StringBuilder sbAppend;
        _e7 _e7Var = _aVar._h;
        if (_e7Var == null) {
            _aVar._h = _a;
            return;
        }
        try {
            try {
                try {
                    _e7Var._a(_aVar);
                    String str_c = _c(_aVar);
                    if (TextUtils.isEmpty(str_c)) {
                        _e7Var._a(_aVar, 0, null);
                    } else {
                        _e7Var._a(_aVar, 1, str_c);
                    }
                } catch (Exception e) {
                    message = e.getMessage();
                    if (message == null) {
                        sbAppend = new StringBuilder("Exception: ").append(e.getClass().getSimpleName());
                        message = sbAppend.toString();
                    }
                    Logger.e(message);
                    _e7Var._a(_aVar, 0, message);
                }
            } catch (_gw e2) {
                String message2 = e2.getMessage();
                if (message2 == null) {
                    message2 = "NetAPIException";
                }
                Logger.e(message2);
                _e7Var._a(_aVar, 0, message2);
            } catch (IOException e3) {
                message = e3.getMessage();
                if (message == null) {
                    sbAppend = new StringBuilder("IOException: ").append(e3.getClass().getSimpleName());
                    message = sbAppend.toString();
                }
                Logger.e(message);
                _e7Var._a(_aVar, 0, message);
            }
            _aVar._h = _a;
        } catch (Throwable th) {
            _aVar._h = _a;
            throw th;
        }
    }

    public static void _a(String str) {
        if (str == null) {
            Logger.e(Logger.ILogger.TAG, "reportUrl is null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        _a(arrayList, (HashMap<String, String>) null);
    }

    public static void _a(List<String> list, HashMap<String, String> map) {
        if (list == null) {
            Logger.e(Logger.ILogger.TAG, "reportUrlList is null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            com.fancy.adsdk.lib.core.net._a _aVar = new com.fancy.adsdk.lib.core.net._a(it.next());
            Random random = com.fancy.adsdk.lib.utils._a._a;
            if (map != null && map.size() > 0) {
                _aVar._a = new HashMap(map);
            }
            arrayList.add(_aVar);
        }
        _c.offer(arrayList);
    }

    public static byte[] _a(InputStream inputStream) {
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                }
                try {
                    inputStream.close();
                    throw th;
                } catch (IOException unused2) {
                    throw th;
                }
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused3) {
        }
        try {
            inputStream.close();
        } catch (IOException unused4) {
        }
        return byteArray;
    }

    /* JADX WARN: Code duplicated, block: B:65:0x0104  */
    public static void _b(com.fancy.adsdk.lib.core.net._a _aVar) throws Throwable {
        HttpURLConnection httpURLConnection;
        String string;
        String string2;
        InputStream inputStream = null;
        if (_aVar != null) {
            try {
                if (TextUtils.isEmpty(_aVar._c)) {
                    httpURLConnection = null;
                } else {
                    String str = _aVar._c;
                    if (TextUtils.isEmpty(com.fancy.adsdk.lib.utils._a._f)) {
                        StringBuilder sb = new StringBuilder();
                        for (char c : "\u0012\u000e\u000e\n@UU".toCharArray()) {
                            sb.append((char) (c ^ 'z'));
                        }
                        string = sb.toString();
                        com.fancy.adsdk.lib.utils._a._f = string;
                    } else {
                        string = com.fancy.adsdk.lib.utils._a._f;
                    }
                    if (!str.startsWith(string)) {
                        String str2 = _aVar._c;
                        if (TextUtils.isEmpty(com.fancy.adsdk.lib.utils._a._g)) {
                            StringBuilder sb2 = new StringBuilder();
                            for (char c2 : "\t\u0015\u0015\u0011\u0012[NN".toCharArray()) {
                                sb2.append((char) (c2 ^ 'a'));
                            }
                            string2 = sb2.toString();
                            com.fancy.adsdk.lib.utils._a._g = string2;
                        } else {
                            string2 = com.fancy.adsdk.lib.utils._a._g;
                        }
                        if (!str2.startsWith(string2)) {
                            httpURLConnection = null;
                        }
                    }
                    httpURLConnection = (HttpURLConnection) new URL(_aVar._c).openConnection();
                    try {
                        httpURLConnection.setConnectTimeout(10000);
                        httpURLConnection.setReadTimeout(10000);
                        httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                        HashMap map = _aVar._a;
                        if (map != null && map.size() > 0) {
                            for (Map.Entry entry : _aVar._a.entrySet()) {
                                String str3 = (String) entry.getKey();
                                String str4 = (String) entry.getValue();
                                if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                                    httpURLConnection.setRequestProperty(str3, str4);
                                }
                            }
                        }
                        httpURLConnection.getResponseCode();
                        try {
                            inputStream = httpURLConnection.getInputStream();
                            do {
                            } while (inputStream.read(new byte[1024]) != -1);
                        } catch (IOException unused) {
                            InputStream errorStream = httpURLConnection.getErrorStream();
                            if (errorStream != null) {
                                try {
                                    do {
                                    } while (errorStream.read(new byte[1024]) != -1);
                                    errorStream.close();
                                } catch (Throwable th) {
                                    try {
                                        errorStream.close();
                                    } catch (IOException unused2) {
                                    }
                                    throw th;
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (httpURLConnection == null) {
                            throw th;
                        }
                        httpURLConnection.disconnect();
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = null;
            }
        } else {
            httpURLConnection = null;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused4) {
            }
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0204 A[Catch: all -> 0x0247, Exception -> 0x024a, IOException -> 0x024d, _gw -> 0x024f, SocketTimeoutException -> 0x0251, TryCatch #17 {_gw -> 0x024f, SocketTimeoutException -> 0x0251, IOException -> 0x024d, Exception -> 0x024a, all -> 0x0247, blocks: (B:74:0x01a4, B:88:0x01c3, B:89:0x01db, B:90:0x01dc, B:91:0x01e3, B:92:0x01e4, B:93:0x01ed, B:94:0x01ee, B:95:0x01f5, B:96:0x01f6, B:97:0x01fd, B:98:0x01fe, B:99:0x0203, B:100:0x0204, B:102:0x0212), top: B:199:0x01a4 }] */
    /* JADX WARN: Code duplicated, block: B:102:0x0212 A[Catch: all -> 0x0247, Exception -> 0x024a, IOException -> 0x024d, _gw -> 0x024f, SocketTimeoutException -> 0x0251, TRY_LEAVE, TryCatch #17 {_gw -> 0x024f, SocketTimeoutException -> 0x0251, IOException -> 0x024d, Exception -> 0x024a, all -> 0x0247, blocks: (B:74:0x01a4, B:88:0x01c3, B:89:0x01db, B:90:0x01dc, B:91:0x01e3, B:92:0x01e4, B:93:0x01ed, B:94:0x01ee, B:95:0x01f5, B:96:0x01f6, B:97:0x01fd, B:98:0x01fe, B:99:0x0203, B:100:0x0204, B:102:0x0212), top: B:199:0x01a4 }] */
    /* JADX WARN: Code duplicated, block: B:109:0x022b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:115:0x0239 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:165:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:175:0x022d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:177:0x0232 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:179:0x0240 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:181:0x021f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:184:0x02c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:186:0x023b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:188:0x0224 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:190:0x02c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:207:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:76:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:78:0x01af  */
    /* JADX WARN: Code duplicated, block: B:80:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:82:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:84:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:86:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:88:0x01c3 A[Catch: all -> 0x0247, Exception -> 0x024a, IOException -> 0x024d, _gw -> 0x024f, SocketTimeoutException -> 0x0251, TryCatch #17 {_gw -> 0x024f, SocketTimeoutException -> 0x0251, IOException -> 0x024d, Exception -> 0x024a, all -> 0x0247, blocks: (B:74:0x01a4, B:88:0x01c3, B:89:0x01db, B:90:0x01dc, B:91:0x01e3, B:92:0x01e4, B:93:0x01ed, B:94:0x01ee, B:95:0x01f5, B:96:0x01f6, B:97:0x01fd, B:98:0x01fe, B:99:0x0203, B:100:0x0204, B:102:0x0212), top: B:199:0x01a4 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x01dc A[Catch: all -> 0x0247, Exception -> 0x024a, IOException -> 0x024d, _gw -> 0x024f, SocketTimeoutException -> 0x0251, TryCatch #17 {_gw -> 0x024f, SocketTimeoutException -> 0x0251, IOException -> 0x024d, Exception -> 0x024a, all -> 0x0247, blocks: (B:74:0x01a4, B:88:0x01c3, B:89:0x01db, B:90:0x01dc, B:91:0x01e3, B:92:0x01e4, B:93:0x01ed, B:94:0x01ee, B:95:0x01f5, B:96:0x01f6, B:97:0x01fd, B:98:0x01fe, B:99:0x0203, B:100:0x0204, B:102:0x0212), top: B:199:0x01a4 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x01e4 A[Catch: all -> 0x0247, Exception -> 0x024a, IOException -> 0x024d, _gw -> 0x024f, SocketTimeoutException -> 0x0251, TryCatch #17 {_gw -> 0x024f, SocketTimeoutException -> 0x0251, IOException -> 0x024d, Exception -> 0x024a, all -> 0x0247, blocks: (B:74:0x01a4, B:88:0x01c3, B:89:0x01db, B:90:0x01dc, B:91:0x01e3, B:92:0x01e4, B:93:0x01ed, B:94:0x01ee, B:95:0x01f5, B:96:0x01f6, B:97:0x01fd, B:98:0x01fe, B:99:0x0203, B:100:0x0204, B:102:0x0212), top: B:199:0x01a4 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x01ee A[Catch: all -> 0x0247, Exception -> 0x024a, IOException -> 0x024d, _gw -> 0x024f, SocketTimeoutException -> 0x0251, TryCatch #17 {_gw -> 0x024f, SocketTimeoutException -> 0x0251, IOException -> 0x024d, Exception -> 0x024a, all -> 0x0247, blocks: (B:74:0x01a4, B:88:0x01c3, B:89:0x01db, B:90:0x01dc, B:91:0x01e3, B:92:0x01e4, B:93:0x01ed, B:94:0x01ee, B:95:0x01f5, B:96:0x01f6, B:97:0x01fd, B:98:0x01fe, B:99:0x0203, B:100:0x0204, B:102:0x0212), top: B:199:0x01a4 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x01f6 A[Catch: all -> 0x0247, Exception -> 0x024a, IOException -> 0x024d, _gw -> 0x024f, SocketTimeoutException -> 0x0251, TryCatch #17 {_gw -> 0x024f, SocketTimeoutException -> 0x0251, IOException -> 0x024d, Exception -> 0x024a, all -> 0x0247, blocks: (B:74:0x01a4, B:88:0x01c3, B:89:0x01db, B:90:0x01dc, B:91:0x01e3, B:92:0x01e4, B:93:0x01ed, B:94:0x01ee, B:95:0x01f5, B:96:0x01f6, B:97:0x01fd, B:98:0x01fe, B:99:0x0203, B:100:0x0204, B:102:0x0212), top: B:199:0x01a4 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x01fe A[Catch: all -> 0x0247, Exception -> 0x024a, IOException -> 0x024d, _gw -> 0x024f, SocketTimeoutException -> 0x0251, TryCatch #17 {_gw -> 0x024f, SocketTimeoutException -> 0x0251, IOException -> 0x024d, Exception -> 0x024a, all -> 0x0247, blocks: (B:74:0x01a4, B:88:0x01c3, B:89:0x01db, B:90:0x01dc, B:91:0x01e3, B:92:0x01e4, B:93:0x01ed, B:94:0x01ee, B:95:0x01f5, B:96:0x01f6, B:97:0x01fd, B:98:0x01fe, B:99:0x0203, B:100:0x0204, B:102:0x0212), top: B:199:0x01a4 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.net.URL] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    public static String _c(com.fancy.adsdk.lib.core.net._a _aVar) throws Throwable {
        PrintWriter printWriter;
        int responseCode;
        InputStream inputStream_a;
        ?? r0 = IOUtils.LINE_SEPARATOR_WINDOWS;
        ?? url = new URL(Uri.encode(_aVar._c, "@#&=*+-_.,:!?()/~'%"));
        PrintWriter printWriter2 = null;
        printWriter2 = null;
        printWriter2 = null;
        printWriter2 = null;
        ?? r1 = 0;
        try {
            try {
                url = (HttpURLConnection) url.openConnection();
                try {
                    url.setRequestProperty("Connection", "Keep-Alive");
                    url.setRequestProperty("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
                    for (Map.Entry entry : _aVar._a.entrySet()) {
                        url.setRequestProperty(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
                    }
                    url.setRequestMethod(_aVar._d);
                    url.setDoInput(true);
                    int i = _aVar._g;
                    if (i <= 0) {
                        i = 10000;
                    }
                    url.setConnectTimeout(i);
                    int i2 = _aVar._g;
                    url.setReadTimeout(i2 > 0 ? i2 : 10000);
                    if (!"POST".equals(_aVar._d)) {
                        r0 = 0;
                        printWriter = null;
                        responseCode = url.getResponseCode();
                        if (responseCode == -1) {
                            if (printWriter != null) {
                                printWriter.close();
                            }
                            if (r0 != 0) {
                                r0.close();
                            }
                            url.disconnect();
                            return null;
                        }
                        if (responseCode != 200) {
                            if (responseCode == 204) {
                                throw new NotActiveException();
                            }
                            if (responseCode == 400) {
                                throw new IOException(PtgErrorCode.ILLEGAL_REQUEST);
                            }
                            if (responseCode == 404) {
                                throw new IOException(PtgErrorCode.ILLEGAL_PATH);
                            }
                            if (responseCode == 500) {
                                throw new IOException(_a((HttpURLConnection) url));
                            }
                            if (responseCode != 502) {
                                throw new _gw("API_RESPONSE_" + responseCode, url);
                            }
                            throw new IOException(PtgErrorCode.ILLEGAL_SERVER);
                        }
                        inputStream_a = _a(url.getInputStream(), url.getContentEncoding());
                        if (inputStream_a == null) {
                            if (printWriter != null) {
                                printWriter.close();
                            }
                            if (r0 != 0) {
                                r0.close();
                            }
                            url.disconnect();
                            return null;
                        }
                        byte[] bArr_a = _a(inputStream_a);
                        _aVar._f = bArr_a;
                        String str = new String(bArr_a, "UTF-8");
                        if (printWriter != null) {
                            printWriter.close();
                        }
                        if (r0 != 0) {
                            r0.close();
                        }
                        url.disconnect();
                        return str;
                    }
                    url.setDoOutput(true);
                    if (!TextUtils.isEmpty(_aVar._e)) {
                        OutputStream outputStream = url.getOutputStream();
                        try {
                            outputStream.write(_aVar._e.getBytes("UTF-8"));
                            outputStream.flush();
                            printWriter = null;
                            r0 = outputStream;
                            try {
                                responseCode = url.getResponseCode();
                                if (responseCode == -1) {
                                    if (printWriter != null) {
                                        try {
                                            printWriter.close();
                                        } catch (Exception unused) {
                                        }
                                    }
                                    if (r0 != 0) {
                                        try {
                                            r0.close();
                                        } catch (IOException unused2) {
                                        }
                                    }
                                    url.disconnect();
                                    return null;
                                }
                                if (responseCode != 200) {
                                    if (responseCode == 204) {
                                        throw new NotActiveException();
                                    }
                                    if (responseCode == 400) {
                                        throw new IOException(PtgErrorCode.ILLEGAL_REQUEST);
                                    }
                                    if (responseCode == 404) {
                                        throw new IOException(PtgErrorCode.ILLEGAL_PATH);
                                    }
                                    if (responseCode == 500) {
                                        throw new IOException(_a((HttpURLConnection) url));
                                    }
                                    if (responseCode != 502) {
                                        throw new _gw("API_RESPONSE_" + responseCode, url);
                                    }
                                    throw new IOException(PtgErrorCode.ILLEGAL_SERVER);
                                }
                                inputStream_a = _a(url.getInputStream(), url.getContentEncoding());
                                if (inputStream_a == null) {
                                    if (printWriter != null) {
                                        try {
                                            printWriter.close();
                                        } catch (Exception unused3) {
                                        }
                                    }
                                    if (r0 != 0) {
                                        try {
                                            r0.close();
                                        } catch (IOException unused4) {
                                        }
                                    }
                                    url.disconnect();
                                    return null;
                                }
                                byte[] bArr_a2 = _a(inputStream_a);
                                _aVar._f = bArr_a2;
                                String str2 = new String(bArr_a2, "UTF-8");
                                if (printWriter != null) {
                                    try {
                                        printWriter.close();
                                    } catch (Exception unused5) {
                                    }
                                }
                                if (r0 != 0) {
                                    try {
                                        r0.close();
                                    } catch (IOException unused6) {
                                    }
                                }
                                url.disconnect();
                                return str2;
                            } catch (_gw e) {
                                e = e;
                                r1 = url;
                                throw e;
                            } catch (SocketTimeoutException e2) {
                                e = e2;
                                Logger.e(e.getMessage());
                                throw new _gw("TIMEOUT_API_RESPONSE: " + e.getMessage());
                            } catch (IOException e3) {
                                e = e3;
                                r1 = url;
                                throw e;
                            } catch (Exception e4) {
                                e = e4;
                                Logger.e(e.getMessage());
                                throw new _gw("Unknown: " + e.getMessage());
                            } catch (Throwable th) {
                                th = th;
                                printWriter2 = printWriter;
                                if (printWriter2 != null) {
                                    try {
                                        printWriter2.close();
                                    } catch (Exception unused7) {
                                    }
                                }
                                if (r0 != 0) {
                                    try {
                                        r0.close();
                                    } catch (IOException unused8) {
                                    }
                                }
                                if (url == 0) {
                                    throw th;
                                }
                                url.disconnect();
                                throw th;
                            }
                        } catch (_gw e5) {
                            e = e5;
                            printWriter = null;
                            r1 = url;
                            throw e;
                        } catch (SocketTimeoutException e6) {
                            e = e6;
                            Logger.e(e.getMessage());
                            throw new _gw("TIMEOUT_API_RESPONSE: " + e.getMessage());
                        } catch (IOException e7) {
                            e = e7;
                            printWriter = null;
                            r1 = url;
                            throw e;
                        } catch (Exception e8) {
                            e = e8;
                            Logger.e(e.getMessage());
                            throw new _gw("Unknown: " + e.getMessage());
                        }
                    }
                    HashMap map = _aVar._b;
                    Random random = com.fancy.adsdk.lib.utils._a._a;
                    if (map == null || map.size() <= 0) {
                        r0 = 0;
                        printWriter = null;
                    } else {
                        String str3 = "BOUNDARY" + Long.toHexString(System.currentTimeMillis());
                        String str4 = "--" + str3 + IOUtils.LINE_SEPARATOR_WINDOWS;
                        url.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + str3);
                        url.connect();
                        OutputStream outputStream2 = url.getOutputStream();
                        try {
                            printWriter = new PrintWriter(outputStream2);
                            try {
                                printWriter.write(IOUtils.LINE_SEPARATOR_WINDOWS);
                                printWriter.write(str4);
                                for (Map.Entry entry2 : _aVar._b.entrySet()) {
                                    String str5 = (String) entry2.getKey();
                                    Object value = entry2.getValue();
                                    if (!TextUtils.isEmpty(str5)) {
                                        printWriter.write("Content-Disposition: form-data; name=\"" + str5 + "\"" + IOUtils.LINE_SEPARATOR_WINDOWS);
                                        printWriter.write(IOUtils.LINE_SEPARATOR_WINDOWS);
                                        printWriter.write(String.valueOf(value));
                                        printWriter.write(IOUtils.LINE_SEPARATOR_WINDOWS);
                                        printWriter.write(str4);
                                    }
                                }
                                printWriter.flush();
                                if (printWriter.checkError()) {
                                    throw new IOException("Error writing multipart form data");
                                }
                                r0 = outputStream2;
                            } catch (_gw e9) {
                                e = e9;
                                throw e;
                            } catch (SocketTimeoutException e10) {
                                e = e10;
                                Logger.e(e.getMessage());
                                throw new _gw("TIMEOUT_API_RESPONSE: " + e.getMessage());
                            } catch (IOException e11) {
                                e = e11;
                                throw e;
                            } catch (Exception e12) {
                                e = e12;
                                Logger.e(e.getMessage());
                                throw new _gw("Unknown: " + e.getMessage());
                            } catch (Throwable th2) {
                                th = th2;
                                r0 = outputStream2;
                                printWriter2 = printWriter;
                                if (printWriter2 != null) {
                                    printWriter2.close();
                                }
                                if (r0 != 0) {
                                    r0.close();
                                }
                                if (url == 0) {
                                    throw th;
                                }
                                url.disconnect();
                                throw th;
                            }
                        } catch (_gw e13) {
                            e = e13;
                            printWriter = null;
                            r1 = url;
                        } catch (SocketTimeoutException e14) {
                            e = e14;
                            Logger.e(e.getMessage());
                            throw new _gw("TIMEOUT_API_RESPONSE: " + e.getMessage());
                        } catch (IOException e15) {
                            e = e15;
                            printWriter = null;
                            r1 = url;
                        } catch (Exception e16) {
                            e = e16;
                            Logger.e(e.getMessage());
                            throw new _gw("Unknown: " + e.getMessage());
                        } catch (Throwable th3) {
                            th = th3;
                            r0 = outputStream2;
                            if (printWriter2 != null) {
                                printWriter2.close();
                            }
                            if (r0 != 0) {
                                r0.close();
                            }
                            if (url == 0) {
                                throw th;
                            }
                            url.disconnect();
                            throw th;
                        }
                    }
                    responseCode = url.getResponseCode();
                    if (responseCode == -1) {
                        if (printWriter != null) {
                            printWriter.close();
                        }
                        if (r0 != 0) {
                            r0.close();
                        }
                        url.disconnect();
                        return null;
                    }
                    if (responseCode != 200) {
                        if (responseCode == 204) {
                            throw new NotActiveException();
                        }
                        if (responseCode == 400) {
                            throw new IOException(PtgErrorCode.ILLEGAL_REQUEST);
                        }
                        if (responseCode == 404) {
                            throw new IOException(PtgErrorCode.ILLEGAL_PATH);
                        }
                        if (responseCode == 500) {
                            throw new IOException(_a((HttpURLConnection) url));
                        }
                        if (responseCode != 502) {
                            throw new _gw("API_RESPONSE_" + responseCode, url);
                        }
                        throw new IOException(PtgErrorCode.ILLEGAL_SERVER);
                    }
                    inputStream_a = _a(url.getInputStream(), url.getContentEncoding());
                    if (inputStream_a == null) {
                        if (printWriter != null) {
                            printWriter.close();
                        }
                        if (r0 != 0) {
                            r0.close();
                        }
                        url.disconnect();
                        return null;
                    }
                    byte[] bArr_a3 = _a(inputStream_a);
                    _aVar._f = bArr_a3;
                    String str6 = new String(bArr_a3, "UTF-8");
                    if (printWriter != null) {
                        printWriter.close();
                    }
                    if (r0 != 0) {
                        r0.close();
                    }
                    url.disconnect();
                    return str6;
                } catch (_gw e17) {
                    e = e17;
                    printWriter = null;
                } catch (SocketTimeoutException e18) {
                    e = e18;
                } catch (IOException e19) {
                    e = e19;
                    printWriter = null;
                } catch (Exception e20) {
                    e = e20;
                } catch (Throwable th4) {
                    th = th4;
                    r0 = 0;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (_gw e21) {
            e = e21;
            printWriter = null;
            throw e;
        } catch (SocketTimeoutException e22) {
            e = e22;
        } catch (IOException e23) {
            e = e23;
            printWriter = null;
            throw e;
        } catch (Exception e24) {
            e = e24;
        } catch (Throwable th6) {
            th = th6;
            r0 = 0;
            url = 0;
        }
        throw e;
    }

    public static void simpleGet(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.fancy.adsdk.lib.core.net._a _aVar = new com.fancy.adsdk.lib.core.net._a(str);
        _aVar._d = "GET";
        _b.offer(_aVar);
    }

    public static void simplePost(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.fancy.adsdk.lib.core.net._a _aVar = new com.fancy.adsdk.lib.core.net._a(str);
        if (!TextUtils.isEmpty(str2)) {
            _aVar._e = str2;
            _aVar._d = "POST";
        }
        _b.offer(_aVar);
    }
}
