package com.baidu.passbqt.http;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.passbqt.NoProguard;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class HttpResponseHandler extends Handler implements NoProguard {
    protected static final int i = 0;
    protected static final int j = 1;
    protected static final int k = 2;
    protected static final int l = 3;
    protected static final String m = "UTF-8";
    protected String n;
    protected boolean o;

    protected void a() {
    }

    protected void a(int i2, String str) {
    }

    protected void a(Throwable th, String str) {
    }

    protected void b() {
    }

    public HttpResponseHandler() {
        this("UTF-8");
    }

    public HttpResponseHandler(String str) {
        this.n = str;
    }

    public HttpResponseHandler(Looper looper) {
        this(looper, false);
    }

    public HttpResponseHandler(Looper looper, boolean z) {
        super(looper);
        this.o = z;
        this.n = "UTF-8";
    }

    protected void a(int i2, String str, HashMap<String, String> map) {
        a(i2, str);
    }

    void c() {
        if (this.o) {
            a();
        } else {
            sendMessage(obtainMessage(2));
        }
    }

    void d() {
        if (this.o) {
            b();
        } else {
            sendMessage(obtainMessage(3));
        }
    }

    void b(Throwable th, String str) {
        if (this.o) {
            a(th, str);
        } else {
            sendMessage(obtainMessage(1, new Object[]{th, str}));
        }
    }

    void a(int i2, HashMap<String, String> map, byte[] bArr) {
        if (this.o) {
            a(i2, bArr == null ? null : new String(bArr), map);
        } else {
            sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(i2), map, bArr}));
        }
    }

    void c(int i2, HashMap<String, String> map, byte[] bArr) {
        if (i2 == 200) {
            a(i2, map, bArr);
        } else {
            String str = bArr == null ? null : new String(bArr);
            b(new HttpErrorException(i2, str), str);
        }
    }

    void b(int i2, HashMap<String, String> map, byte[] bArr) {
        a(i2, bArr == null ? null : new String(bArr), map);
    }

    void c(Throwable th, String str) {
        a(th, str);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            Object[] objArr = (Object[]) message.obj;
            b(((Integer) objArr[0]).intValue(), (HashMap) objArr[1], (byte[]) objArr[2]);
        } else if (i2 == 1) {
            Object[] objArr2 = (Object[]) message.obj;
            c((Throwable) objArr2[0], (String) objArr2[1]);
        } else if (i2 == 2) {
            a();
        } else {
            if (i2 != 3) {
                return;
            }
            b();
        }
    }
}
