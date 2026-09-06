package com.adprof.sdk;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.adprof.sdk.api.AdError;
import com.bytedance.pangle.LocalBroadcastManager;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class s5 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1413a;

    public s5(String str) {
        this.f1413a = str;
    }

    public static void a(String str, String str2) {
        a(str, null, str2, 0);
    }

    public static void a(String str, Map map, String str2, int i) {
        Serializable serializable;
        qh.a(str2);
        Intent intent = new Intent(str2);
        intent.putExtra("broadcastIdentifier", str);
        if (map != null) {
            for (String str3 : map.keySet()) {
                try {
                    Object obj = map.get(str3);
                    if (obj instanceof Number) {
                        serializable = (Number) obj;
                    } else if (obj instanceof Boolean) {
                        serializable = (Boolean) obj;
                    } else {
                        intent.putExtra(str3, obj instanceof AdError ? obj.toString() : (String) obj);
                    }
                    intent.putExtra(str3, serializable);
                } catch (Throwable th) {
                    pk.a(LocalBroadcastManager.TAG, " broadcastAction e = ", th);
                    oh.b(th);
                }
            }
        }
        m mVarA = m.a();
        if (mVarA == null) {
            pk.b(LocalBroadcastManager.TAG, "broadcastAction error: GtLocalBroadcastManager instance is null");
            return;
        }
        try {
            mVarA.a(intent);
        } catch (Throwable th2) {
            pk.a(LocalBroadcastManager.TAG, " broadcast e = ", th2);
            oh.b(th2);
        }
    }

    public abstract IntentFilter a();

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m715a() {
        m mVarA = m.a();
        if (mVarA == null) {
            pk.b(LocalBroadcastManager.TAG, "register error: GtLocalBroadcastManager instance is null");
            return;
        }
        try {
            mVarA.a(this, a());
        } catch (Throwable th) {
            pk.a(LocalBroadcastManager.TAG, " register e = ", th);
            oh.b(th);
        }
    }

    public boolean a(Intent intent) {
        qh.a(intent);
        String stringExtra = intent.getStringExtra("broadcastIdentifier");
        return !TextUtils.isEmpty(stringExtra) && stringExtra.equalsIgnoreCase(this.f1413a);
    }

    public void b() {
        m mVarA = m.a();
        if (mVarA == null) {
            pk.b(LocalBroadcastManager.TAG, "unregister error: GtLocalBroadcastManager instance is null");
            return;
        }
        try {
            mVarA.a(this);
        } catch (Throwable th) {
            pk.a(LocalBroadcastManager.TAG, " unregister e = ", th);
            oh.b(th);
        }
    }
}
