package com.xiaomi.onetrack.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9510a = ijiami_1011.s.s.s.d(new byte[]{6}, "b5435e");
    private static final String b = ijiami_1011.s.s.s.d(new byte[]{1, 86, 88, 76, Ascii.RS, 92, 0, 11, 11, 11, Ascii.US, 10, 12, 92, 65, 16, 7, 86, 10, 74, 34, 39, 115, 48, 37}, "b95bf5");
    private static final String c = ijiami_1011.s.s.s.d(new byte[]{87, 93, 14, Ascii.GS, Ascii.RS, 95, 0, 11, 11, 11, Ascii.US, 10, 90, 87, Ascii.ETB, 65, 7, 85, 10, 74, Ascii.SYN, 7, 67, 8, 93, 65, 16, 90, 9, 88, Ascii.DC2, 74, 34, 39, 115, 48, 115, 109, 46, 124, 34, 115}, "42c3f6");
    private static final String d = ijiami_1011.s.s.s.d(new byte[]{Ascii.CAN, 84, 68, 90, 75, 88, 17, 1, 8, 77, 85, 0, 65, 92, 87, 86, 75, SignedBytes.MAX_POWER_OF_TWO, 19, 13, Ascii.DC2, 7, 115, 4, 84, 94}, "7543d7");
    private static final String e = ijiami_1011.s.s.s.d(new byte[]{12, 17, 77, 68, 9, Ascii.ESC, 78}, "de9434");
    private static final String f = ijiami_1011.s.s.s.d(new byte[]{89, 65, 17, 73, 75, 10, 78, 75}, "15e980");
    private static final String g = ijiami_1011.s.s.s.d(new byte[]{74, 9, 15, Ascii.ETB, 87, 12, 12}, "ddf94c");
    private static volatile d h = null;
    private static final int i = 100;
    private final Context j;
    private Handler k = new e(this, Looper.getMainLooper());
    private BroadcastReceiver l = new f(this);

    private d() {
        Context contextB = com.xiaomi.onetrack.f.a.b();
        this.j = contextB;
        a(contextB);
    }

    public static d a() {
        if (h == null) {
            synchronized (d.class) {
                if (h == null) {
                    h = new d();
                }
            }
        }
        return h;
    }

    private void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(b);
            if (Build.VERSION.SDK_INT >= 33) {
                context.registerReceiver(this.l, intentFilter, c, null, 2);
            } else {
                context.registerReceiver(this.l, intentFilter, c, null);
            }
        } catch (Exception e2) {
            p.a(f9510a, ijiami_1011.s.s.s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 82, 86, 90, SignedBytes.MAX_POWER_OF_TWO, Ascii.SYN, 4, Ascii.SYN, 34, 7, 83, 16, 85, 122, 94, 87, 86, 48, 4, 7, 3, 11, 71, 0, SignedBytes.MAX_POWER_OF_TWO, 13, 17}, "27133b") + e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        i.a(new g(this, str, str2, str3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        return !TextUtils.isEmpty(str) && str.endsWith(g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt(ijiami_1011.s.s.s.d(new byte[]{7, 14, 85, 86}, "da131c"));
            String strOptString = jSONObject.optString(ijiami_1011.s.s.s.d(new byte[]{14, 7, 70, 66, 86, 81, 4}, "cb5176"));
            String strOptString2 = jSONObject.optString(ijiami_1011.s.s.s.d(new byte[]{Ascii.DC4, 0, 16, Ascii.DC4, 93, 69}, "feca11"));
            boolean zOptBoolean = jSONObject.optBoolean(ijiami_1011.s.s.s.d(new byte[]{Ascii.ETB, SignedBytes.MAX_POWER_OF_TWO, 83, 5, 86, SignedBytes.MAX_POWER_OF_TWO, Ascii.DC2}, "d50f33"));
            Message messageObtain = Message.obtain();
            messageObtain.what = 100;
            Bundle bundle = new Bundle();
            if (iOptInt == 0 && zOptBoolean) {
                bundle.putString(ijiami_1011.s.s.s.d(new byte[]{89, 93, 8, 69}, "14f160"), strOptString2);
            } else {
                bundle.putString(ijiami_1011.s.s.s.d(new byte[]{11, 93, 12, 16}, "c4bd67"), strOptString);
            }
            messageObtain.setData(bundle);
            this.k.sendMessage(messageObtain);
        } catch (JSONException e2) {
            p.b(f9510a, e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        Toast.makeText(this.j, str, 1).show();
    }
}
