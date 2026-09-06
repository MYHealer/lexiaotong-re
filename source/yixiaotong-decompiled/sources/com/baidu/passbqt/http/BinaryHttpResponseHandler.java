package com.baidu.passbqt.http;

import android.os.Looper;
import com.baidu.passbqt.NoProguard;
import com.huawei.openalliance.ad.constant.bj;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class BinaryHttpResponseHandler extends HttpResponseHandler implements NoProguard {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String[] f1924a;

    protected void a(int i, byte[] bArr) {
    }

    public BinaryHttpResponseHandler(Looper looper) {
        super(looper);
        this.f1924a = new String[]{bj.Z, "image/jpeg", bj.I, bj.B};
    }

    public BinaryHttpResponseHandler(Looper looper, String[] strArr) {
        this(looper, strArr, false);
    }

    public BinaryHttpResponseHandler(Looper looper, String[] strArr, boolean z) {
        super(looper);
        new String[]{bj.Z, "image/jpeg", bj.I, bj.B};
        this.f1924a = strArr;
        this.o = z;
    }

    @Override // com.baidu.passbqt.http.HttpResponseHandler
    void a(int i, HashMap<String, String> map, byte[] bArr) {
        if (this.o) {
            b(i, map, bArr);
        } else {
            sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(i), map, bArr}));
        }
    }

    @Override // com.baidu.passbqt.http.HttpResponseHandler
    void b(int i, HashMap<String, String> map, byte[] bArr) {
        if (map == null || map.get("Content-Type") == null) {
            b(new HttpErrorException(i, "None or more than one Content-Type Header found!"), null);
            return;
        }
        String str = map.get("Content-Type");
        for (String str2 : this.f1924a) {
            if (str2.equalsIgnoreCase(str)) {
                a(i, bArr);
                return;
            }
        }
        b(new HttpErrorException(i, "Content-Type not allowed!"), null);
    }
}
