package com.ubix.ssp.ad.e.w;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.stub.StubApp;
import com.ubix.ssp.ad.e.a0.u;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<Context, c> f8895a = new HashMap();
    private final Context c;
    private n e;
    private int g;
    private boolean h;
    private final int[] f = {5, 8, 13, 21, 34, 55, 89, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE, 233};
    private final com.ubix.ssp.ad.core.monitor.data.c.b d = com.ubix.ssp.ad.core.monitor.data.c.b.b();
    private final a b = new a();

    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f8896a = new Object();
        private Handler b;

        /* JADX INFO: renamed from: com.ubix.ssp.ad.e.w.c$a$a, reason: collision with other inner class name */
        private class HandlerC1104a extends Handler {
            HandlerC1104a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) throws Throwable {
                try {
                    int i = message.what;
                    if (i == 3 || i == 6 || i == 7) {
                        c.this.a(message);
                    } else if (i == 4) {
                        try {
                            c.this.d.a();
                        } catch (Exception e) {
                            h.a(e);
                        }
                    } else {
                        if (i == 5) {
                            if (c.this.g != 8 && c.this.h) {
                                c.this.a(message);
                                if (!c.this.h) {
                                    return;
                                }
                                c.this.a(c.this.f[c.c(c.this)] * 1000);
                            }
                            return;
                        }
                        h.b("----埋点", "Unexpected message received by SensorsData worker: " + message);
                    }
                } catch (RuntimeException e2) {
                    h.a("----埋点", "Worker threw an unhandled exception", e2);
                }
            }
        }

        a() {
            HandlerThread handlerThread = new HandlerThread("AnalyticsMessages.Worker", 1);
            handlerThread.start();
            this.b = new HandlerC1104a(handlerThread.getLooper());
        }

        void a(Message message) {
            synchronized (this.f8896a) {
                Handler handler = this.b;
                if (handler == null) {
                    h.b("----埋点", "Dead worker dropping a message: " + message.what);
                } else {
                    handler.sendMessage(message);
                }
            }
        }

        void a(Message message, long j) {
            synchronized (this.f8896a) {
                Handler handler = this.b;
                if (handler == null) {
                    h.b("----埋点", "Dead worker dropping a message: " + message.what);
                } else if (!handler.hasMessages(message.what)) {
                    h.b("----埋点", "delay 执行时间：" + j);
                    this.b.sendMessageDelayed(message, j);
                }
            }
        }
    }

    private c(Context context, n nVar) {
        this.c = context;
        this.e = nVar;
    }

    public static c a(Context context, n nVar) {
        c cVar;
        Map<Context, c> map = f8895a;
        synchronized (map) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (map.containsKey(origApplicationContext)) {
                cVar = map.get(origApplicationContext);
            } else {
                cVar = new c(origApplicationContext, nVar);
                map.put(origApplicationContext, cVar);
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:57:0x0156 A[PHI: r8
  0x0156: PHI (r8v24 ??) = (r8v39 ??), (r8v40 ??) binds: [B:35:0x00c6, B:56:0x0154] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:63:0x0166  */
    /* JADX WARN: Code duplicated, block: B:65:0x016d  */
    /* JADX WARN: Code duplicated, block: B:67:0x017f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:68:0x0181  */
    /* JADX WARN: Code duplicated, block: B:69:0x0190  */
    /* JADX WARN: Code duplicated, block: B:71:0x01ad  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v18, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v17, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v25, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v39 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v40 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    public void a(Message message) throws Throwable {
        String[] strArrA;
        int iA;
        Message messageObtain;
        String str;
        try {
            if (!com.ubix.ssp.ad.e.a0.c.g(this.c)) {
                return;
            }
            ?? IsEmpty = 3;
            IsEmpty = 3;
            IsEmpty = 3;
            if (message.what == 3 && this.d.c() < this.e.g()) {
                return;
            }
            synchronized (this.d) {
                strArrA = this.d.a("events", 50);
            }
            if (strArrA == null) {
                return;
            }
            ?? r8 = 0;
            String str2 = strArrA[0];
            boolean z = true;
            String str3 = strArrA[1];
            u.b("rawMessage=" + str3);
            try {
                try {
                    try {
                        if (!TextUtils.isEmpty(str3)) {
                            a(this.e.k(), str3, false);
                            this.g = 0;
                            this.h = false;
                        }
                        if (!TextUtils.isEmpty(null)) {
                            h.b("----埋点", null);
                        }
                        int iA2 = this.d.a(str2);
                        Message messageObtain2 = Message.obtain();
                        if (iA2 >= this.e.g()) {
                            messageObtain2.what = 3;
                            this.b.a(messageObtain2);
                        } else if (iA2 > 0) {
                            messageObtain2.what = 6;
                            this.b.a(messageObtain2, this.e.h());
                        }
                        str = String.format(Locale.CHINA, "Events flushed. [left = %s]", Integer.valueOf(iA2));
                    } catch (Throwable th) {
                        th = th;
                        th = th;
                        r8 = z;
                        if (!TextUtils.isEmpty(null)) {
                            h.b("----埋点", null);
                        }
                        if (r8 != 0) {
                            iA = this.d.a(str2);
                            messageObtain = Message.obtain();
                            if (iA < this.e.g()) {
                                messageObtain.what = IsEmpty;
                                this.b.a(messageObtain);
                            } else if (iA > 0) {
                                messageObtain.what = 6;
                                this.b.a(messageObtain, this.e.h());
                            }
                            h.b("----埋点", String.format(Locale.CHINA, "Events flushed. [left = %s]", Integer.valueOf(iA)));
                        } else {
                            c();
                        }
                        throw th;
                    }
                } catch (com.ubix.ssp.ad.e.w.r.a e) {
                    r8 = "Connection error: " + e.getMessage();
                    IsEmpty = TextUtils.isEmpty(r8);
                    r8 = r8;
                    if (IsEmpty == 0) {
                        IsEmpty = "----埋点";
                        h.b("----埋点", r8);
                    }
                    c();
                    return;
                } catch (com.ubix.ssp.ad.e.w.r.b e2) {
                    boolean zA = a(e2.a());
                    try {
                        r8 = "ResponseErrorException: " + e2.getMessage();
                        if (!TextUtils.isEmpty(r8)) {
                            h.b("----埋点", r8);
                        }
                        if (zA) {
                            int iA3 = this.d.a(str2);
                            Message messageObtain3 = Message.obtain();
                            if (iA3 >= this.e.g()) {
                                messageObtain3.what = 3;
                                this.b.a(messageObtain3);
                            } else if (iA3 > 0) {
                                messageObtain3.what = 6;
                                this.b.a(messageObtain3, this.e.h());
                            }
                            str = String.format(Locale.CHINA, "Events flushed. [left = %s]", Integer.valueOf(iA3));
                        }
                        c();
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        z = zA;
                        th = th;
                        r8 = z;
                        if (!TextUtils.isEmpty(null)) {
                            h.b("----埋点", null);
                        }
                        if (r8 != 0) {
                            iA = this.d.a(str2);
                            messageObtain = Message.obtain();
                            if (iA < this.e.g()) {
                                messageObtain.what = IsEmpty;
                                this.b.a(messageObtain);
                            } else if (iA > 0) {
                                messageObtain.what = 6;
                                this.b.a(messageObtain, this.e.h());
                            }
                            h.b("----埋点", String.format(Locale.CHINA, "Events flushed. [left = %s]", Integer.valueOf(iA)));
                        } else {
                            c();
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    r8 = "Exception: " + e3.getMessage();
                    IsEmpty = TextUtils.isEmpty(r8);
                    r8 = r8;
                    if (IsEmpty == 0) {
                        IsEmpty = "----埋点";
                        h.b("----埋点", r8);
                    }
                    c();
                    return;
                }
                h.b("----埋点", str);
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e4) {
            h.a(e4);
        }
    }

    private void a(BufferedOutputStream bufferedOutputStream, OutputStream outputStream, InputStream inputStream, HttpURLConnection httpURLConnection) {
        if (bufferedOutputStream != null) {
            try {
                bufferedOutputStream.close();
            } catch (Exception e) {
                h.b("----埋点", e.getMessage());
            }
        }
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception e2) {
                h.b("----埋点", e2.getMessage());
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e3) {
                h.b("----埋点", e3.getMessage());
            }
        }
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e4) {
                h.b("----埋点", e4.getMessage());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.ubix.ssp.ad.e.w.c] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.net.HttpURLConnection] */
    private void a(String str, String str2, boolean z) throws Throwable {
        InputStream inputStream;
        BufferedOutputStream bufferedOutputStream;
        InputStream errorStream;
        try {
            try {
                HashMap map = new HashMap();
                map.put("Content-Type", "application/x-protobuf");
                str = com.ubix.ssp.ad.e.x.c.a(str, "POST", 10000, map, false);
                try {
                    if (TextUtils.isEmpty(str2)) {
                        bufferedOutputStream = null;
                    } else {
                        if (u.a()) {
                            u.f(str2);
                        }
                        bufferedOutputStream = new BufferedOutputStream(str.getOutputStream());
                        try {
                            bufferedOutputStream.write(str2.getBytes());
                            bufferedOutputStream.flush();
                        } catch (IOException e) {
                            e = e;
                            throw new com.ubix.ssp.ad.e.w.r.a(e);
                        } catch (Exception e2) {
                            e = e2;
                            throw new com.ubix.ssp.ad.e.w.r.a(e);
                        } catch (Throwable th) {
                            th = th;
                            inputStream = null;
                            a(bufferedOutputStream, null, inputStream, str);
                            throw th;
                        }
                    }
                    try {
                        errorStream = str.getInputStream();
                    } catch (FileNotFoundException unused) {
                        errorStream = str.getErrorStream();
                    }
                    try {
                        byte[] bArrA = a(errorStream);
                        errorStream.close();
                        int responseCode = str.getResponseCode();
                        u.b("埋点response=".concat(new String(bArrA, "UTF-8")));
                        if (h.a()) {
                            if (responseCode < 200 || responseCode >= 300) {
                                throw new com.ubix.ssp.ad.e.w.r.a(responseCode + "");
                            }
                            u.b("埋点汇报成功=" + responseCode + "；" + str2);
                        }
                        a(bufferedOutputStream, null, null, str);
                    } catch (IOException e3) {
                        e = e3;
                        throw new com.ubix.ssp.ad.e.w.r.a(e);
                    } catch (Exception e4) {
                        e = e4;
                        throw new com.ubix.ssp.ad.e.w.r.a(e);
                    }
                } catch (IOException e5) {
                    e = e5;
                    throw new com.ubix.ssp.ad.e.w.r.a(e);
                } catch (Exception e6) {
                    e = e6;
                    throw new com.ubix.ssp.ad.e.w.r.a(e);
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = null;
                    bufferedOutputStream = null;
                    a(bufferedOutputStream, null, inputStream, str);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e7) {
            e = e7;
        } catch (Exception e8) {
            e = e8;
        } catch (Throwable th4) {
            th = th4;
            str = 0;
        }
    }

    private boolean a(int i) {
        return (i == 404 || i == 403 || (i >= 500 && i < 600)) ? false : true;
    }

    private static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr, 0, 8192);
            if (i == -1) {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    static /* synthetic */ int c(c cVar) {
        int i = cVar.g + 1;
        cVar.g = i;
        return i;
    }

    private void c() {
        try {
            if (this.h) {
                return;
            }
            this.h = true;
            int i = this.f[this.g] * 1000;
            Message messageObtain = Message.obtain();
            messageObtain.what = 5;
            messageObtain.arg1 = i;
            this.b.a(messageObtain, i);
        } catch (Exception e) {
            h.b("----埋点", e.getMessage());
        }
    }

    void a() {
        try {
            Message messageObtain = Message.obtain();
            messageObtain.what = 7;
            this.b.a(messageObtain);
        } catch (Exception e) {
            h.a(e);
        }
    }

    void a(long j) {
        try {
            Message messageObtain = Message.obtain();
            messageObtain.what = 5;
            if (j > 0) {
                this.b.a(messageObtain, j);
            } else {
                this.b.a(messageObtain, this.e.h());
            }
        } catch (Exception e) {
            h.a(e);
        }
    }

    void a(String str, JSONObject jSONObject) {
        try {
            synchronized (this.d) {
                int iA = this.d.a(jSONObject);
                u.b("total count=" + iA);
                if (iA < 0) {
                    h.b("----埋点", "Failed to enqueue the event: " + jSONObject);
                }
                Message messageObtain = Message.obtain();
                if (iA >= this.e.g()) {
                    messageObtain.what = 3;
                    this.b.a(messageObtain);
                } else {
                    messageObtain.what = 6;
                    this.b.a(messageObtain, this.e.h());
                }
            }
        } catch (Exception e) {
            h.b("----埋点", "enqueueEventMessage error:" + e);
        }
    }

    void b() {
        try {
            Message messageObtain = Message.obtain();
            messageObtain.what = 3;
            this.b.a(messageObtain);
        } catch (Exception e) {
            h.a(e);
        }
    }
}
