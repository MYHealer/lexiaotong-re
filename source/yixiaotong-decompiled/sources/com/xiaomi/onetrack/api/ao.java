package com.xiaomi.onetrack.api;

import android.os.Process;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.xiaomi.onetrack.Configuration;
import com.xiaomi.onetrack.OneTrack;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class ao implements ar.a, j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9414a = ijiami_1011.s.s.s.d(new byte[]{125, 89, 3, 103, Ascii.DC4, 86, 2, 15, 53, Ascii.ESC, 66, 17, 87, 90, 47, 94, Ascii.SYN}, "27f3f7");
    private static final int b = 102400;
    private static final int c = 512000;
    private static final int d = 2;
    private final ConcurrentHashMap<String, String> e = new ConcurrentHashMap<>();
    private Configuration f;
    private ar g;
    private com.xiaomi.onetrack.util.v h;

    public ao(Configuration configuration, com.xiaomi.onetrack.util.v vVar) {
        this.f = configuration;
        this.h = vVar;
        ar arVarA = ar.a();
        this.g = arVarA;
        arVarA.a(this);
        com.xiaomi.onetrack.util.i.a(new ap(this));
    }

    private boolean a(String str) {
        try {
            return new JSONObject(str).optJSONObject(ijiami_1011.s.s.s.d(new byte[]{124}, "423124")).optBoolean(com.xiaomi.onetrack.f.b.C1162b.F, false);
        } catch (Throwable unused) {
            com.xiaomi.onetrack.util.p.a(f9414a, "");
            return false;
        }
    }

    private boolean a(String str, String str2, boolean z) {
        String str3;
        String strD;
        if (OneTrack.isDisable()) {
            return false;
        }
        if (str != null && str.equals(ijiami_1011.s.s.s.d(new byte[]{89, 8, 82, Ascii.NAK, 16, 89, 2, 15, 57, 0, 68, 2, 105, Ascii.DC4, 82, 17, 13, 74, Ascii.NAK}, "6f7ab8"))) {
            return true;
        }
        if (z) {
            if (str2 != null && str2.length() > 512000) {
                str3 = f9414a;
                strD = ijiami_1011.s.s.s.d(new byte[]{83, 0, 70, 36, SignedBytes.MAX_POWER_OF_TWO, 87, 15, 16, 70, 17, 88, Ascii.US, 87, 68, 3, Ascii.EM, 85, 87, 4, 0, 70, 14, 88, 8, 91, 16, 7, Ascii.NAK, 95, 93, 15, 69}, "2dfa62");
                com.xiaomi.onetrack.util.p.a(str3, strD);
                return false;
            }
            return true;
        }
        if (str2 != null && str2.length() * 2 > 102400) {
            str3 = f9414a;
            strD = ijiami_1011.s.s.s.d(new byte[]{114, 16, 83, 11, 66, Ascii.EM, Ascii.DC2, 13, Ascii.FS, 7, 17, 0, 79, 5, 83, 0, 82, Ascii.EM, 13, 13, 11, 11, 69, 4, 67, 15, 89, 11, Ascii.ETB}, "7f6e69");
            com.xiaomi.onetrack.util.p.a(str3, strD);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            com.xiaomi.onetrack.c.l.a().c(this.f.getAppId());
            if (TextUtils.isEmpty(this.f.getAdEventAppId())) {
                return;
            }
            com.xiaomi.onetrack.c.l.a().c(this.f.getAdEventAppId());
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.a(f9414a, ijiami_1011.s.s.s.d(new byte[]{76, 67, 4, 84, 91, 122, 0, 7, 14, 7, 85, 32, 78, 84, 11, 67, 67, 3, 65}, "81e709") + e.toString());
        }
    }

    @Override // com.xiaomi.onetrack.api.ar.a
    public void a() {
        com.xiaomi.onetrack.util.i.a(new aq(this));
    }

    @Override // com.xiaomi.onetrack.api.j
    public void a(int i) {
        this.g.a(i);
    }

    @Override // com.xiaomi.onetrack.api.j
    public void a(String str, String str2) {
        boolean zA = a(str2);
        com.xiaomi.onetrack.util.v vVar = this.h;
        if (vVar != null && !vVar.a(str) && !zA) {
            com.xiaomi.onetrack.util.p.a(f9414a, ijiami_1011.s.s.s.d(new byte[]{54, 92, 6, Ascii.DC2, 19, 71, 8, Ascii.DC2, 7, 1, 72, 69, Ascii.DC2, 91, 15, 91, 0, 76, 65, 13, Ascii.NAK, 66, 95, 10, Ascii.SYN, Ascii.DC4, 19, 87, 17, 88, 8, 16, Ascii.DC2, 7, 85, 73, 66, 85, 13, 86, 67, 65, 9, 1, 70, 7, 71, 0, 12, SignedBytes.MAX_POWER_OF_TWO, 67, 91, 16, Ascii.NAK, 15, 11, Ascii.DC2, 66, 83, 4, 17, 93, 0, Ascii.DC2, 12, 71, 65, Ascii.SYN, 3, 1, 94, 8, 15, 81, 13, 86, 67, 80, Ascii.ETB, 1, 8, Ascii.SYN, 17, 10, 16, Ascii.DC4, 0, 71, 16, 65, 14, 9, 70, 6, 80, 16, 66, 81, Ascii.NAK, 87, 13, 65, 77, 68, Ascii.NAK, 9, 88, Ascii.NAK, 66, 93, Ascii.ETB, Ascii.FS}, "b4c2c5"));
            return;
        }
        if (a(str, str2, zA)) {
            if (com.xiaomi.onetrack.c.i.b()) {
                com.xiaomi.onetrack.c.i.a(this);
            } else if (!ijiami_1011.s.s.s.d(new byte[]{95, 10, 80, SignedBytes.MAX_POWER_OF_TWO, 65, 86, 2, 15, 57, 1, 69, 4, 111, Ascii.ETB, 65, 85, 71, 66, Ascii.DC2}, "0d5437").equalsIgnoreCase(str)) {
                com.xiaomi.onetrack.c.i.a(str, str2);
                return;
            }
            if (com.xiaomi.onetrack.util.p.f9551a) {
                com.xiaomi.onetrack.util.p.a(f9414a, ijiami_1011.s.s.s.d(new byte[]{71, 68, 83, 90, 95, Ascii.ETB, 15, 5, 11, 7, 11}, "362947") + str + ijiami_1011.s.s.s.d(new byte[]{16, 93, 86, 70, 89, Ascii.SYN, 91}, "097286") + str2 + ijiami_1011.s.s.s.d(new byte[]{70, 67, 88, 93}, "f71964") + Process.myTid());
            }
            if (this.g.a(str, str2, this.f, zA)) {
                return;
            }
            String appId = this.f.getAppId();
            if (zA) {
                appId = this.f.getAdEventAppId();
            }
            com.xiaomi.onetrack.c.l.a().a(appId, str, str2);
            if (com.xiaomi.onetrack.util.p.f9551a) {
                com.xiaomi.onetrack.util.p.a(f9414a, ijiami_1011.s.s.s.d(new byte[]{65, Ascii.DC4, 89, 86, 8, 66, 12, 45, 41, 12, 84, 49, 71, 7, 91, 94, 48, 7, 19, Ascii.DC2, 15, 1, 84, 69, 92, Ascii.NAK, Ascii.CAN, 91, Ascii.SYN, 14, 13, 69, 70, 49, 72, Ascii.SYN, 65, 3, 85, 124, 14, Ascii.DC2, 34, 5, 5, 10, 84, 40, 84, 8, 89, 82, 6, 16, 65, 7, 7, 1, 89, 0, Ascii.NAK, 2, 89, 65, 2, 88}, "5f85cb") + str2);
            }
        }
    }

    @Override // com.xiaomi.onetrack.api.j
    public void a(boolean z) {
        com.xiaomi.onetrack.c.i.a(this);
    }
}
