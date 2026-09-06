package com.alipay.sdk.app;

import android.app.Activity;
import android.os.Bundle;
import com.alipay.sdk.util.l;
import com.stub.StubApp;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AlipayResultActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f1608a;

    public interface a {
        void a(int i, String str, String str2);
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void a(String str, Bundle bundle) {
        a aVarRemove = f1608a.remove(str);
        if (aVarRemove == null) {
            finish();
            return;
        }
        try {
            aVarRemove.a(bundle.getInt("endCode"), bundle.getString(l.b), bundle.getString("result"));
        } finally {
            finish();
        }
    }

    static {
        StubApp.interface11(12882);
        f1608a = new ConcurrentHashMap<>();
    }
}
