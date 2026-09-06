package com.ubixnow.ooooo;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.stub.StubApp;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oOO0O00O {
    private static final String OooO00o = "【----ubix_埋点】---upload";
    private static final int OooO0O0 = 3;
    private static final int OooO0OO = 4;
    private static final int OooO0Oo = 5;
    private static final int OooO0o = 7;
    private static final int OooO0o0 = 6;
    private static final Map<Context, oOO0O00O> OooO0oO = new HashMap();
    private final Context OooO;
    private ooooO0O0 OooOO0O;
    private boolean OooOOO;
    private int OooOOO0;
    private final int[] OooOO0o = {5, 8, 13, 21, 34, 55, 89, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE, 233};
    private final oOOO0OOO OooOO0 = oOOO0OOO.OooO0O0();
    private final OooO00o OooO0oo = new OooO00o();

    public class OooO00o {
        private final Object OooO00o = new Object();
        private Handler OooO0O0;

        /* JADX INFO: renamed from: com.ubixnow.ooooo.oOO0O00O$OooO00o$OooO00o, reason: collision with other inner class name */
        public class HandlerC1141OooO00o extends Handler {
            public HandlerC1141OooO00o(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) throws Throwable {
                try {
                    int i = message.what;
                    if (i == 3 || i == 6 || i == 7) {
                        oOO0O00O.this.OooO00o(message);
                    } else if (i == 4) {
                        try {
                            oOO0O00O.this.OooOO0.OooO00o();
                        } catch (Exception e) {
                            oOO0O0O.OooO00o(e);
                        }
                    } else {
                        if (i == 5) {
                            if (oOO0O00O.this.OooOOO0 != 8 && oOO0O00O.this.OooOOO) {
                                oOO0O00O.this.OooO00o(message);
                                if (!oOO0O00O.this.OooOOO) {
                                    return;
                                }
                                oOO0O00O.this.OooO00o(oOO0O00O.this.OooOO0o[oOO0O00O.OooO0OO(oOO0O00O.this)] * 1000);
                            }
                            return;
                        }
                        oOO0O0O.OooO0O0(oOO0O00O.OooO00o, "Unexpected message received by SensorsData worker: " + message);
                    }
                } catch (RuntimeException e2) {
                    oOO0O0O.OooO0O0(oOO0O00O.OooO00o, "Worker threw an unhandled exception", e2);
                }
            }
        }

        public OooO00o() {
            HandlerThread handlerThread = new HandlerThread("AnalyticsMessages.Worker", 1);
            handlerThread.start();
            this.OooO0O0 = new HandlerC1141OooO00o(handlerThread.getLooper());
        }

        public void OooO00o(Message message) {
            synchronized (this.OooO00o) {
                Handler handler = this.OooO0O0;
                if (handler == null) {
                    oOO0O0O.OooO0O0(oOO0O00O.OooO00o, "Dead worker dropping a message: " + message.what);
                } else {
                    handler.sendMessage(message);
                }
            }
        }

        public void OooO00o(Message message, long j) {
            synchronized (this.OooO00o) {
                Handler handler = this.OooO0O0;
                if (handler == null) {
                    oOO0O0O.OooO0O0(oOO0O00O.OooO00o, "Dead worker dropping a message: " + message.what);
                } else if (!handler.hasMessages(message.what)) {
                    oOO0O0O.OooO0O0(oOO0O00O.OooO00o, "delay 执行时间：" + j);
                    this.OooO0O0.sendMessageDelayed(message, j);
                }
            }
        }
    }

    private oOO0O00O(Context context, ooooO0O0 ooooo0o0) {
        this.OooO = context;
        this.OooOO0O = ooooo0o0;
    }

    public static oOO0O00O OooO00o(Context context, ooooO0O0 ooooo0o0) {
        oOO0O00O ooo0o00o;
        Map<Context, oOO0O00O> map = OooO0oO;
        synchronized (map) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (map.containsKey(origApplicationContext)) {
                ooo0o00o = map.get(origApplicationContext);
            } else {
                ooo0o00o = new oOO0O00O(origApplicationContext, ooooo0o0);
                map.put(origApplicationContext, ooo0o00o);
            }
        }
        return ooo0o00o;
    }

    private HttpURLConnection OooO00o(String str) throws IOException {
        URL url = new URL(str);
        if (str.startsWith("https")) {
            try {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                httpsURLConnection.setHostnameVerifier(new d1());
                httpsURLConnection.setInstanceFollowRedirects(true);
                httpsURLConnection.setUseCaches(false);
                return httpsURLConnection;
            } catch (Exception e) {
                ooooO000.OooO00o(e);
            }
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setUseCaches(false);
        return httpURLConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:60:0x015c A[PHI: r8
  0x015c: PHI (r8v25 java.lang.String) = (r8v14 java.lang.String), (r8v26 java.lang.String) binds: [B:38:0x00cc, B:59:0x015a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:66:0x016c  */
    /* JADX WARN: Code duplicated, block: B:68:0x0173  */
    /* JADX WARN: Code duplicated, block: B:70:0x0185 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:71:0x0187  */
    /* JADX WARN: Code duplicated, block: B:72:0x0196  */
    /* JADX WARN: Code duplicated, block: B:74:0x01b3  */
    public void OooO00o(Message message) throws Throwable {
        String[] strArrOooO00o;
        Throwable th;
        int iOooO00o;
        Message messageObtain;
        String str;
        String str2;
        try {
            if (!a.OooO0O0(this.OooO)) {
                return;
            }
            if (message.what == 3 && this.OooOO0.OooO0OO() < this.OooOO0O.OooO()) {
                return;
            }
            synchronized (this.OooOO0) {
                strArrOooO00o = this.OooOO0.OooO00o("events", 50);
            }
            if (strArrOooO00o == null) {
                return;
            }
            boolean z = false;
            String str3 = strArrOooO00o[0];
            boolean z2 = true;
            String str4 = strArrOooO00o[1];
            if (ooooO000.OooO00o) {
                ooooO000.OooO0O0("------ubix_埋点】--", " rawMessage： " + str4);
            }
            try {
                try {
                    try {
                        try {
                            if (!TextUtils.isEmpty(str4)) {
                                OooO00o(this.OooOO0O.OooO0oO(), str4, false);
                                this.OooOOO0 = 0;
                                this.OooOOO = false;
                            }
                            if (!TextUtils.isEmpty(null)) {
                                oOO0O0O.OooO0O0(OooO00o, null);
                            }
                            int iOooO00o2 = this.OooOO0.OooO00o(str3);
                            Message messageObtain2 = Message.obtain();
                            if (iOooO00o2 >= this.OooOO0O.OooO()) {
                                messageObtain2.what = 3;
                                this.OooO0oo.OooO00o(messageObtain2);
                            } else if (iOooO00o2 > 0) {
                                messageObtain2.what = 6;
                                this.OooO0oo.OooO00o(messageObtain2, this.OooOO0O.OooOO0O());
                            }
                            str2 = String.format(Locale.CHINA, "Events flushed. [left = %s]", Integer.valueOf(iOooO00o2));
                        } catch (Throwable th2) {
                            th = th2;
                            if (!TextUtils.isEmpty(null)) {
                                oOO0O0O.OooO0O0(OooO00o, null);
                            }
                            if (z) {
                                iOooO00o = this.OooOO0.OooO00o(str3);
                                messageObtain = Message.obtain();
                                if (iOooO00o < this.OooOO0O.OooO()) {
                                    messageObtain.what = 3;
                                    this.OooO0oo.OooO00o(messageObtain);
                                } else if (iOooO00o > 0) {
                                    messageObtain.what = 6;
                                    this.OooO0oo.OooO00o(messageObtain, this.OooOO0O.OooOO0O());
                                }
                                oOO0O0O.OooO0O0(OooO00o, String.format(Locale.CHINA, "Events flushed. [left = %s]", Integer.valueOf(iOooO00o)));
                            } else {
                                OooO0Oo();
                            }
                            throw th;
                        }
                    } catch (oOOo0000 e) {
                        str = "Connection error: " + e.getMessage();
                        if (!TextUtils.isEmpty(str)) {
                            oOO0O0O.OooO0O0(OooO00o, str);
                        }
                        OooO0Oo();
                        return;
                    }
                } catch (oo000000 e2) {
                    boolean zOooO00o = OooO00o(e2.OooO00o());
                    try {
                        String str5 = "ResponseErrorException: " + e2.getMessage();
                        if (!TextUtils.isEmpty(str5)) {
                            oOO0O0O.OooO0O0(OooO00o, str5);
                        }
                        if (zOooO00o) {
                            int iOooO00o3 = this.OooOO0.OooO00o(str3);
                            Message messageObtain3 = Message.obtain();
                            if (iOooO00o3 >= this.OooOO0O.OooO()) {
                                messageObtain3.what = 3;
                                this.OooO0oo.OooO00o(messageObtain3);
                            } else if (iOooO00o3 > 0) {
                                messageObtain3.what = 6;
                                this.OooO0oo.OooO00o(messageObtain3, this.OooOO0O.OooOO0O());
                            }
                            str2 = String.format(Locale.CHINA, "Events flushed. [left = %s]", Integer.valueOf(iOooO00o3));
                        }
                        OooO0Oo();
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        z2 = zOooO00o;
                        th = th;
                        z = z2;
                        if (!TextUtils.isEmpty(null)) {
                            oOO0O0O.OooO0O0(OooO00o, null);
                        }
                        if (z) {
                            iOooO00o = this.OooOO0.OooO00o(str3);
                            messageObtain = Message.obtain();
                            if (iOooO00o < this.OooOO0O.OooO()) {
                                messageObtain.what = 3;
                                this.OooO0oo.OooO00o(messageObtain);
                            } else if (iOooO00o > 0) {
                                messageObtain.what = 6;
                                this.OooO0oo.OooO00o(messageObtain, this.OooOO0O.OooOO0O());
                            }
                            oOO0O0O.OooO0O0(OooO00o, String.format(Locale.CHINA, "Events flushed. [left = %s]", Integer.valueOf(iOooO00o)));
                        } else {
                            OooO0Oo();
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    str = "Exception: " + e3.getMessage();
                    if (!TextUtils.isEmpty(str)) {
                        oOO0O0O.OooO0O0(OooO00o, str);
                    }
                    OooO0Oo();
                    return;
                }
                oOO0O0O.OooO0O0(OooO00o, str2);
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Exception e4) {
            oOO0O0O.OooO00o(e4);
        }
    }

    private void OooO00o(BufferedOutputStream bufferedOutputStream, OutputStream outputStream, InputStream inputStream, HttpURLConnection httpURLConnection) {
        if (bufferedOutputStream != null) {
            try {
                bufferedOutputStream.close();
            } catch (Exception e) {
                oOO0O0O.OooO0O0(OooO00o, e.getMessage());
            }
        }
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception e2) {
                oOO0O0O.OooO0O0(OooO00o, e2.getMessage());
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e3) {
                oOO0O0O.OooO0O0(OooO00o, e3.getMessage());
            }
        }
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e4) {
                oOO0O0O.OooO0O0(OooO00o, e4.getMessage());
            }
        }
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x00d5: MOVE (r0 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:67:0x00d4 */
    private void OooO00o(String str, String str2, boolean z) throws Throwable {
        HttpURLConnection httpURLConnectionOooO00o;
        OutputStream outputStream;
        InputStream inputStream;
        BufferedOutputStream bufferedOutputStream;
        InputStream errorStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                httpURLConnectionOooO00o = OooO00o(str);
                try {
                    httpURLConnectionOooO00o.setInstanceFollowRedirects(false);
                    httpURLConnectionOooO00o.setRequestProperty("Content-Type", "application/x-protobuf");
                    httpURLConnectionOooO00o.setDoOutput(true);
                    httpURLConnectionOooO00o.setRequestMethod("POST");
                    httpURLConnectionOooO00o.setConnectTimeout(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
                    httpURLConnectionOooO00o.setReadTimeout(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
                    outputStream = httpURLConnectionOooO00o.getOutputStream();
                    try {
                        BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(outputStream);
                        try {
                            bufferedOutputStream3.write(str2.getBytes());
                            bufferedOutputStream3.flush();
                            int responseCode = httpURLConnectionOooO00o.getResponseCode();
                            if (!z && a.OooO00o(responseCode)) {
                                String strOooO00o = a.OooO00o(httpURLConnectionOooO00o, str);
                                if (!TextUtils.isEmpty(strOooO00o)) {
                                    OooO00o(bufferedOutputStream3, outputStream, null, httpURLConnectionOooO00o);
                                    OooO00o(strOooO00o, str2, true);
                                    OooO00o(bufferedOutputStream3, outputStream, null, httpURLConnectionOooO00o);
                                    return;
                                }
                            }
                            try {
                                errorStream = httpURLConnectionOooO00o.getInputStream();
                            } catch (FileNotFoundException unused) {
                                errorStream = httpURLConnectionOooO00o.getErrorStream();
                            }
                            try {
                                byte[] bArrOooO00o = OooO00o(errorStream);
                                errorStream.close();
                                new String(bArrOooO00o, "UTF-8");
                                if (oOO0O0O.OooO00o() && (responseCode < 200 || responseCode >= 300)) {
                                    throw new oOOo0000(responseCode + "");
                                }
                                OooO00o(bufferedOutputStream3, outputStream, null, httpURLConnectionOooO00o);
                            } catch (IOException e) {
                                e = e;
                                throw new oOOo0000(e);
                            } catch (Exception e2) {
                                e = e2;
                                throw new oOOo0000(e);
                            } catch (Throwable th) {
                                bufferedOutputStream2 = bufferedOutputStream3;
                                inputStream = errorStream;
                                th = th;
                                OooO00o(bufferedOutputStream2, outputStream, inputStream, httpURLConnectionOooO00o);
                                throw th;
                            }
                        } catch (IOException e3) {
                            e = e3;
                        } catch (Exception e4) {
                            e = e4;
                        }
                    } catch (IOException e5) {
                        e = e5;
                        throw new oOOo0000(e);
                    } catch (Exception e6) {
                        e = e6;
                        throw new oOOo0000(e);
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = null;
                        OooO00o(bufferedOutputStream2, outputStream, inputStream, httpURLConnectionOooO00o);
                        throw th;
                    }
                } catch (IOException e7) {
                    e = e7;
                } catch (Exception e8) {
                    e = e8;
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = null;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                bufferedOutputStream2 = bufferedOutputStream;
            }
        } catch (IOException e9) {
            e = e9;
        } catch (Exception e10) {
            e = e10;
        } catch (Throwable th5) {
            th = th5;
            httpURLConnectionOooO00o = null;
            outputStream = null;
        }
    }

    private boolean OooO00o(int i) {
        return (i == 404 || i == 403 || (i >= 500 && i < 600)) ? false : true;
    }

    private static byte[] OooO00o(InputStream inputStream) throws IOException {
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

    public static /* synthetic */ int OooO0OO(oOO0O00O ooo0o00o) {
        int i = ooo0o00o.OooOOO0 + 1;
        ooo0o00o.OooOOO0 = i;
        return i;
    }

    private void OooO0Oo() {
        try {
            if (this.OooOOO) {
                return;
            }
            this.OooOOO = true;
            int i = this.OooOO0o[this.OooOOO0] * 1000;
            Message messageObtain = Message.obtain();
            messageObtain.what = 5;
            messageObtain.arg1 = i;
            this.OooO0oo.OooO00o(messageObtain, i);
        } catch (Exception e) {
            oOO0O0O.OooO0O0(OooO00o, e.getMessage());
        }
    }

    public void OooO00o() {
        try {
            Message messageObtain = Message.obtain();
            messageObtain.what = 4;
            this.OooO0oo.OooO00o(messageObtain);
        } catch (Exception e) {
            oOO0O0O.OooO00o(e);
        }
    }

    public void OooO00o(long j) {
        try {
            Message messageObtain = Message.obtain();
            messageObtain.what = 5;
            if (j > 0) {
                this.OooO0oo.OooO00o(messageObtain, j);
            } else {
                this.OooO0oo.OooO00o(messageObtain, this.OooOO0O.OooOO0O());
            }
        } catch (Exception e) {
            oOO0O0O.OooO00o(e);
        }
    }

    public void OooO00o(String str, JSONObject jSONObject) {
        try {
            synchronized (this.OooOO0) {
                try {
                    int iOooO00o = this.OooOO0.OooO00o(jSONObject);
                    if (iOooO00o < 0) {
                        oOO0O0O.OooO0O0(OooO00o, "Failed to enqueue the event: " + jSONObject);
                    }
                    Message messageObtain = Message.obtain();
                    if (iOooO00o >= this.OooOO0O.OooO()) {
                        messageObtain.what = 3;
                        this.OooO0oo.OooO00o(messageObtain);
                    } else {
                        messageObtain.what = 6;
                        this.OooO0oo.OooO00o(messageObtain, this.OooOO0O.OooOO0O());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Exception e) {
            oOO0O0O.OooO0O0(OooO00o, "enqueueEventMessage error:" + e);
        }
    }

    public void OooO0O0() {
        try {
            Message messageObtain = Message.obtain();
            messageObtain.what = 7;
            this.OooO0oo.OooO00o(messageObtain);
        } catch (Exception e) {
            oOO0O0O.OooO00o(e);
        }
    }

    public void OooO0OO() {
        try {
            Message messageObtain = Message.obtain();
            messageObtain.what = 3;
            this.OooO0oo.OooO00o(messageObtain);
        } catch (Exception e) {
            oOO0O0O.OooO00o(e);
        }
    }
}
