package com.xiaomi.onetrack.api;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.stub.StubApp;
import com.xiaomi.onetrack.Configuration;
import com.xiaomi.onetrack.CrashAnalysis;
import com.xiaomi.onetrack.OnMainThreadException;
import com.xiaomi.onetrack.OneTrack;
import com.xiaomi.onetrack.ServiceQualityEvent;
import com.xiaomi.onetrack.util.DeviceUtil;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9433a = ijiami_1011.s.s.s.d(new byte[]{44, 13, 93, 96, Ascii.DC4, 5, 2, 15, 47, 15, 65}, "cc84fd");
    private static ExecutorService c;
    private j b;
    private Context d;
    private k e;
    private Configuration f;
    private OneTrack.ICommonPropertyProvider g;
    private OneTrack.IEventHook h;
    private com.xiaomi.onetrack.util.v i;
    private boolean j = false;

    public m(Context context, Configuration configuration) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.d = origApplicationContext;
        this.f = configuration;
        c(origApplicationContext);
        Log.d(ijiami_1011.s.s.s.d(new byte[]{41, 13, 80, 53, 70, 80, 2, 15, 47, 15, 65}, "fc5a41"), ijiami_1011.s.s.s.d(new byte[]{124, 13, 6, 103, 75, 85, 2, 15, 47, 15, 65, 69, 90, 13, 10, 71, Ascii.EM, 14, 65}, "3cc394") + configuration.toString());
        Log.d(ijiami_1011.s.s.s.d(new byte[]{119, 87, 3, 55, Ascii.SYN, 85, 2, 15, 47, 15, 65}, "89fcd4"), ijiami_1011.s.s.s.d(new byte[]{125, 93, 7, 99, 68, 88, 2, 15, 47, 15, 65, 69, 65, 87, 9, Ascii.ETB, SignedBytes.MAX_POWER_OF_TWO, 92, 19, 68, 92, 66, 3, 75, 3, Ascii.GS, 80}, "23b769"));
        com.xiaomi.onetrack.util.p.a(ijiami_1011.s.s.s.d(new byte[]{127, 87, 3, 101, 71, 5, 2, 15, 47, 15, 65}, "09f15d"), ijiami_1011.s.s.s.d(new byte[]{35, 77, 80, 8, 84, 33, 14, 10, 0, 11, 86, 75, 47, 87, 112, 9, 85, 11, 91, 16, Ascii.DC4, Ascii.ETB, 84}, "a89d0b"));
    }

    private String a(long j, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ijiami_1011.s.s.s.d(new byte[]{9, 3, SignedBytes.MAX_POWER_OF_TWO, 65, 102, Ascii.NAK, 4, Ascii.SYN, 57, 12, 80, 8, 0}, "eb359c"), str);
        jSONObject.put(ijiami_1011.s.s.s.d(new byte[]{91, 0, 65, SignedBytes.MAX_POWER_OF_TWO, 57, Ascii.ETB, 4, Ascii.SYN, 57, 1, 94, 1, 82}, "7a24fa"), j);
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, long j) {
        c.execute(new u(this, str, j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z) {
        c.execute(new t(this, str, z));
    }

    private void c(Context context) {
        j amVar;
        com.xiaomi.onetrack.util.p.a();
        com.xiaomi.onetrack.util.q.a(this.f.isInternational(), this.f.getRegion(), this.f.getMode());
        if (c == null) {
            c = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        }
        this.i = new com.xiaomi.onetrack.util.v(this.f);
        if (com.xiaomi.onetrack.util.q.a() && g() && e()) {
            com.xiaomi.onetrack.util.o.a().a(Boolean.TRUE);
            amVar = new ao(this.f, this.i);
        } else {
            com.xiaomi.onetrack.util.o.a().a(Boolean.FALSE);
            amVar = new am(context, this.f, this.i);
        }
        this.b = amVar;
        if (this.f.getMode() == OneTrack.Mode.APP) {
            com.xiaomi.onetrack.util.q.a(this.f.isOverrideMiuiRegionSetting());
            d(context);
            if (this.f.isExceptionCatcherEnable()) {
                CrashAnalysis.start(context, this);
                if (!CrashAnalysis.isSupport()) {
                    k kVar = new k();
                    this.e = kVar;
                    kVar.a();
                }
            }
        }
        c.execute(new n(this));
    }

    private void d(Context context) {
        ((Application) context).registerActivityLifecycleCallbacks(new r(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(String str) {
        boolean zA = com.xiaomi.onetrack.util.r.a(str);
        if (!zA) {
            com.xiaomi.onetrack.util.p.b(f9433a, String.format(ijiami_1011.s.s.s.d(new byte[]{113, 95, Ascii.DC2, 80, 93, 80, 5, 68, 3, Ascii.DC4, 84, 11, 76, 95, 5, 92, 84, 3, 65, 65, Ascii.NAK, 76, 17, 32, 78, 84, 10, 69, 95, 88, 12, 1, 70, 1, 80, 11, Ascii.CAN, 94, 10, 93, 72, Ascii.EM, 2, 11, 8, 17, 88, Ascii.SYN, 76, 17, 11, 87, 17, 87, Ascii.DC4, 9, 4, 7, 67, Ascii.SYN, Ascii.DC4, 17, 8, 84, 69, 77, 4, Ascii.SYN, Ascii.NAK, 78, 17, 16, 86, 85, 1, 67, 66, 90, 14, Ascii.SYN, 3, 17, 17, 73, 89, 95, 0, 17, 82, 88, 15, 68, 8, 13, 69, 69, 75, 69, 5, 67, 69, Ascii.EM, Ascii.SYN, 13, Ascii.DC2, 10, 17, 4, Ascii.CAN, 95, 17, 92, 83, 92, 19, 68, 9, 16, 17, 71, 87, 95, 1, 69, 67, 88, 2, 15, 57, SignedBytes.MAX_POWER_OF_TWO, 17, 10, 74, 17, 70, 94, 69, 102, 67}, "81d119"), str));
        }
        return !zA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z) {
        c.execute(new v(this, z));
    }

    private boolean e() {
        if (this.f.isOverrideMiuiRegionSetting()) {
            return TextUtils.equals(com.xiaomi.onetrack.util.q.j(), this.f.getRegion());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(String str) {
        if (ijiami_1011.s.s.s.d(new byte[]{86, 92, 82, 68, 69, 84, 2, 15, 57, 6, 80, 16}, "927075").equals(str) || ijiami_1011.s.s.s.d(new byte[]{66, 95, 3, 68}, "46f3de").equals(str) || ijiami_1011.s.s.s.d(new byte[]{14, 76, 110, 90, 93, 84, 8, 10}, "a81623").equals(str) || ijiami_1011.s.s.s.d(new byte[]{13, 67, 104, 88, 88, 80, 14, 17, Ascii.DC2}, "b77477").equals(str)) {
            return false;
        }
        boolean zA = com.xiaomi.onetrack.util.r.a(str);
        if (!zA) {
            com.xiaomi.onetrack.util.p.b(f9433a, String.format(ijiami_1011.s.s.s.d(new byte[]{123, 92, 69, 5, 13, 80, 5, 68, 3, Ascii.DC4, 84, 11, 70, 92, 82, 9, 4, 3, 65, 65, Ascii.NAK, 76, 17, 32, 68, 87, 93, 16, 15, 88, 12, 1, 70, 1, 80, 11, Ascii.DC2, 93, 93, 8, Ascii.CAN, Ascii.EM, 2, 11, 8, 17, 88, Ascii.SYN, 70, Ascii.DC2, 92, 2, 65, 87, Ascii.DC4, 9, 4, 7, 67, Ascii.SYN, Ascii.RS, Ascii.DC2, 95, 1, Ascii.NAK, 77, 4, Ascii.SYN, Ascii.NAK, 78, 17, 16, 92, 86, 86, Ascii.SYN, Ascii.DC2, 90, 14, Ascii.SYN, 3, 17, 17, 73, 83, 92, 87, 68, 2, 88, 15, 68, 8, 13, 69, 69, 65, 70, 82, Ascii.SYN, Ascii.NAK, Ascii.EM, Ascii.SYN, 13, Ascii.DC2, 10, 17, 4, Ascii.DC2, 92, 70, 9, 3, 92, 19, 68, 9, 16, 17, 71, 93, 92, 86, 16, 19, 88, 2, 15, 57, SignedBytes.MAX_POWER_OF_TWO, 17, 10, SignedBytes.MAX_POWER_OF_TWO, Ascii.DC2, 17, 11, Ascii.NAK, 102, 67}, "223da9"), str));
        }
        return !zA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject f(String str) throws Throwable {
        try {
            OneTrack.ICommonPropertyProvider iCommonPropertyProvider = this.g;
            JSONObject jSONObjectA = com.xiaomi.onetrack.util.r.a(iCommonPropertyProvider != null ? iCommonPropertyProvider.getDynamicProperty(str) : null, false);
            String strA = com.xiaomi.onetrack.util.k.a(com.xiaomi.onetrack.util.r.a(this.f));
            return com.xiaomi.onetrack.util.r.a(jSONObjectA, !TextUtils.isEmpty(strA) ? new JSONObject(strA) : null);
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b(f9433a, ijiami_1011.s.s.s.d(new byte[]{1, 92, 16, 39, 11, 84, 12, 11, 8, 50, 67, 10, Ascii.SYN, 92, Ascii.SYN, 16, Ascii.GS, 3, 65}, "f9ddd9") + e.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        c.execute(new s(this));
    }

    private boolean g() {
        if (com.xiaomi.onetrack.util.p.f9551a) {
            com.xiaomi.onetrack.util.p.a(f9433a, ijiami_1011.s.s.s.d(new byte[]{83, 92, 0, 4, 13, 3, 91}, "62afaf") + h() + ijiami_1011.s.s.s.d(new byte[]{Ascii.EM, 95, Ascii.DC2, 103, 69, 67, 17, 11, Ascii.DC4, Ascii.SYN, 116, 8, 73, 66, Ascii.CAN, 113, 70, 86, 15, 16, 92, 66}, "96a403") + i() + ijiami_1011.s.s.s.d(new byte[]{102, 95, 67, 50, 65, 17, 17, 11, Ascii.DC4, Ascii.SYN, 112, 1, 116, 89, 94, 8, SignedBytes.MAX_POWER_OF_TWO, 14, 19, 76, 79, 88}, "960a4a") + j());
        }
        return h() && i() && j();
    }

    private boolean h() {
        try {
            int componentEnabledSetting = com.xiaomi.onetrack.f.a.b().getPackageManager().getComponentEnabledSetting(new ComponentName(ijiami_1011.s.s.s.d(new byte[]{1, 14, 8, Ascii.ETB, 84, 90, Ascii.DC4, 13, 72, 3, 95, 4, 14, Ascii.CAN, 17, 80, 90, SignedBytes.MAX_POWER_OF_TWO}, "bae993"), ijiami_1011.s.s.s.d(new byte[]{81, 13, 90, 74, 90, 11, Ascii.DC4, 13, 72, 3, 95, 4, 94, Ascii.ESC, 67, 13, 84, 17, 79, 11, 8, 7, 69, Ascii.ETB, 83, 1, 92, 74, 120, 12, 4, 48, Ascii.DC4, 3, 82, 14, 97, 7, 69, Ascii.DC2, 94, 1, 4}, "2b7d7b")));
            return componentEnabledSetting == 1 || componentEnabledSetting == 0;
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b(f9433a, ijiami_1011.s.s.s.d(new byte[]{82, 89, 84, 91, 92, 93, 65, 1, Ascii.DC4, 16, 94, Ascii.ETB, 13}, "775908") + e.toString());
            return false;
        }
    }

    private static boolean i() {
        try {
            int i = com.xiaomi.onetrack.f.a.b().getPackageManager().getPackageInfo(ijiami_1011.s.s.s.d(new byte[]{6, 9, 11, 75, 95, 89, Ascii.DC4, 13, 72, 3, 95, 4, 9, Ascii.US, Ascii.DC2, 12, 81, 67}, "effe20"), 0).versionCode;
            if (i >= 2020062900) {
                return true;
            }
            com.xiaomi.onetrack.util.p.a(f9433a, ijiami_1011.s.s.s.d(new byte[]{17, Ascii.US, 65, SignedBytes.MAX_POWER_OF_TWO, 86, 85, 65, 5, 8, 3, 93, Ascii.FS, Ascii.SYN, 15, 81, 71, 19, 78, 4, Ascii.SYN, Ascii.NAK, 11, 94, 11, 88, 70}, "bf2438") + i);
        } catch (Throwable th) {
            com.xiaomi.onetrack.util.p.b(f9433a, ijiami_1011.s.s.s.d(new byte[]{89, 17, 97, 17, 65, 73, 14, Ascii.SYN, Ascii.DC2, 39, 92, Ascii.NAK, 68, Ascii.ESC, 119, Ascii.DC2, 84, 87, Ascii.NAK, 68, 3, 16, 67, 10, 66, 88}, "0b2d19") + th.getMessage());
        }
        return false;
    }

    private boolean j() {
        try {
            if (TextUtils.isEmpty(this.f.getAdEventAppId()) || OneTrack.isUseSystemNetTrafficOnly()) {
                return true;
            }
            int i = com.xiaomi.onetrack.f.a.b().getPackageManager().getPackageInfo(ijiami_1011.s.s.s.d(new byte[]{2, 92, 15, 26, 11, 10, Ascii.DC4, 13, 72, 3, 95, 4, 13, 74, Ascii.SYN, 93, 5, 16}, "a3b4fc"), 0).versionCode;
            com.xiaomi.onetrack.util.p.a(f9433a, ijiami_1011.s.s.s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, Ascii.FS, Ascii.ETB, Ascii.ETB, 86, 9, 65, 5, 8, 3, 93, Ascii.FS, 71, 12, 7, 16, 19, Ascii.DC2, 4, Ascii.SYN, Ascii.NAK, 11, 94, 11, 9, 69}, "3edc3d") + i);
            return i >= 2022042900;
        } catch (Throwable th) {
            com.xiaomi.onetrack.util.p.b(f9433a, ijiami_1011.s.s.s.d(new byte[]{81, 71, 106, Ascii.DC4, 66, 70, 14, Ascii.SYN, Ascii.DC2, 35, 85, 40, 87, 90, 80, Ascii.NAK, 93, 68, 65, 1, Ascii.DC4, 16, 94, Ascii.ETB, 2}, "849a26") + th.getMessage());
            return true;
        }
    }

    private void k() {
        c.execute(new ac(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (com.xiaomi.onetrack.c.i.d()) {
            c.execute(new ad(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        try {
            if (this.f.getMode() != OneTrack.Mode.APP) {
                return;
            }
            long jD = com.xiaomi.onetrack.f.a.d();
            String strA = a(jD, com.xiaomi.onetrack.f.a.c());
            String strA2 = com.xiaomi.onetrack.util.aa.A();
            if (TextUtils.isEmpty(strA2)) {
                com.xiaomi.onetrack.util.aa.j(strA);
                return;
            }
            JSONObject jSONObject = new JSONObject(strA2);
            long jOptLong = jSONObject.optLong(ijiami_1011.s.s.s.d(new byte[]{13, 3, 69, 77, 62, Ascii.DC2, 4, Ascii.SYN, 57, 1, 94, 1, 4}, "ab69ad"));
            String strOptString = jSONObject.optString(ijiami_1011.s.s.s.d(new byte[]{84, 5, Ascii.SYN, 69, 62, 19, 4, Ascii.SYN, 57, 12, 80, 8, 93}, "8de1ae"));
            if (jOptLong != jD) {
                com.xiaomi.onetrack.util.aa.j(strA);
                this.b.a(ijiami_1011.s.s.s.d(new byte[]{10, 90, 92, 65, 17, 2, 2, 15, 57, Ascii.ETB, 65, 2, Ascii.ETB, 85, 93, 80}, "e495cc"), h.a(jOptLong, strOptString, jD, com.xiaomi.onetrack.f.a.f(), this.f, this.h, this.i, this.j));
            }
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b(f9433a, ijiami_1011.s.s.s.d(new byte[]{67, 65, 81, 5, 13, 99, 17, 3, Ascii.DC4, 3, 85, 0, 114, 69, 85, 8, Ascii.DC2, Ascii.SYN, 4, Ascii.SYN, Ascii.DC4, 13, 67, 95, Ascii.ETB}, "730ff6") + e.toString());
        }
    }

    public String a(Context context) throws OnMainThreadException {
        if (com.xiaomi.onetrack.util.w.a()) {
            throw new OnMainThreadException(ijiami_1011.s.s.s.d(new byte[]{117, 80, 8, 69, 66, Ascii.NAK, 2, 5, 10, 14, 17, 17, 94, 88, Ascii.NAK, 66, 91, 80, Ascii.NAK, 12, 9, 6, 17, 10, 88, 17, 11, 3, 95, 91, 65, 16, 14, 16, 84, 4, 82}, "61fb65"));
        }
        return DeviceUtil.j(context);
    }

    public String a(Intent intent) throws OnMainThreadException {
        if (com.xiaomi.onetrack.util.w.a()) {
            throw new OnMainThreadException(ijiami_1011.s.s.s.d(new byte[]{118, 81, 94, 65, 69, 19, 2, 5, 10, 14, 17, 17, 93, 89, 67, 70, 92, 86, Ascii.NAK, 12, 9, 6, 17, 10, 91, 16, 93, 7, 88, 93, 65, 16, 14, 16, 84, 4, 81}, "500f13"));
        }
        if (intent != null && a.a().c()) {
            return a.a().a(intent);
        }
        com.xiaomi.onetrack.util.p.b(f9433a, ijiami_1011.s.s.s.d(new byte[]{123, 13, Ascii.ETB, 65, 4, 85, 13, 11, 17, 7, 85, 69, 65, 13, 67, 2, 4, 85, 13, 72, 15, 12, 69, 0, 91, Ascii.SYN, 67, 8, Ascii.SYN, Ascii.EM, 15, 17, 10, 14, 17, 10, 71, 66, 45, 14, 17, Ascii.EM, Ascii.DC2, Ascii.DC4, 3, 1, 88, 3, 76, 66, Ascii.ETB, 9, 0, Ascii.EM, 17, 5, 5, 9, 80, 2, 80, 66, 13, 0, 8, 92}, "5bcae9"));
        return "";
    }

    public void a() {
        c.execute(new x(this));
    }

    public void a(OneTrack.ICommonPropertyProvider iCommonPropertyProvider) {
        this.g = iCommonPropertyProvider;
    }

    public void a(OneTrack.IEventHook iEventHook) {
        this.h = iEventHook;
        this.i.a(iEventHook);
    }

    public void a(ServiceQualityEvent serviceQualityEvent) {
        if (serviceQualityEvent == null) {
            return;
        }
        c.execute(new ab(this, serviceQualityEvent));
    }

    public void a(String str) {
        c.execute(new ah(this, str));
    }

    public void a(String str, OneTrack.UserIdType userIdType, Map<String, Object> map, boolean z) {
        c.execute(new al(this, str, userIdType, z, map));
    }

    public void a(String str, Number number) {
        c.execute(new p(this, str, number));
    }

    public void a(String str, Object obj) {
        c.execute(new ak(this, obj, str));
    }

    public void a(String str, String str2, String str3, String str4, String str5, long j) {
        c.execute(new ai(this, str, str2, str3, str5, str4, j));
    }

    public void a(String str, String str2, Map<String, Object> map) {
        c.execute(new y(this, str2, map, str));
    }

    public void a(String str, Map<String, Object> map) {
        c.execute(new af(this, str, map));
    }

    public void a(String str, Map<String, Object> map, List<String> list) {
        c.execute(new ag(this, str, map, list));
    }

    public void a(Map<String, Object> map) {
        c.execute(new aj(this, map));
    }

    public void a(Map<String, Object> map, boolean z) {
        c.execute(new q(this, z, map));
    }

    public void a(boolean z) {
        com.xiaomi.onetrack.util.p.f9551a = z;
    }

    public String b() throws OnMainThreadException {
        if (com.xiaomi.onetrack.util.w.a()) {
            throw new OnMainThreadException(ijiami_1011.s.s.s.d(new byte[]{34, 86, 95, 65, 65, Ascii.DC4, 2, 5, 10, 14, 17, 17, 9, 94, 66, 70, 88, 81, Ascii.NAK, 12, 9, 6, 17, 10, 15, Ascii.ETB, 92, 7, 92, 90, 65, 16, 14, 16, 84, 4, 5}, "a71f54"));
        }
        return com.xiaomi.onetrack.util.o.a().b();
    }

    public String b(Context context) throws OnMainThreadException {
        if (com.xiaomi.onetrack.util.w.a()) {
            throw new OnMainThreadException(ijiami_1011.s.s.s.d(new byte[]{112, 89, 86, Ascii.US, 68, 67, 2, 5, 10, 14, 17, 17, 91, 81, 75, Ascii.CAN, 93, 6, Ascii.NAK, 12, 9, 6, 17, 10, 93, Ascii.CAN, 85, 89, 89, 13, 65, 16, 14, 16, 84, 4, 87}, "38880c"));
        }
        return DeviceUtil.k(context);
    }

    public void b(String str) {
        c.execute(new z(this, str));
    }

    public void b(Map<String, ? extends Number> map) {
        c.execute(new o(this, map));
    }

    public void b(boolean z) {
        if (this.f.isUseCustomPrivacyPolicy()) {
            c.execute(new ae(this, z));
        }
    }

    public void c() {
        DeviceUtil.e();
    }

    public void c(String str) {
        c.execute(new aa(this, str));
    }

    public void c(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        c.execute(new w(this, map));
    }

    public void c(boolean z) {
        this.j = z;
    }

    public void d(boolean z) {
        com.xiaomi.onetrack.util.oaid.a.a().a(z);
    }

    public boolean d() {
        return DeviceUtil.f();
    }
}
