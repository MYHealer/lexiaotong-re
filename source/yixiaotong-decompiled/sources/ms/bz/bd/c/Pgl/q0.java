package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.stub.StubApp;
import com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver;
import com.volcengine.mobsecBiz.metasec.ml.PglMSManager;
import com.volcengine.mobsecBiz.metasec.ml.PglMSManagerUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import okio.Utf8;
import org.json.JSONArray;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class q0 {
    public static final /* synthetic */ int c = 0;
    private static volatile boolean tt;
    private static final ConcurrentHashMap ve = new ConcurrentHashMap();
    private static CopyOnWriteArraySet uj = new CopyOnWriteArraySet();

    public interface pgla {
        Map<String, String> getFeatureHash(String str, byte[] bArr);

        String getToken();

        void report(String str);

        void setBDDeviceID(String str);

        void setCollectMode(int i);

        void setDeviceID(String str);

        void setInstallID(String str);
    }

    protected q0() {
    }

    public static synchronized void c(String str) {
        if (pblw.c().tt() != null) {
            pblv pblvVar = (pblv) ve.get(str);
            if (tt(str) != null && pblvVar != null) {
                uj.addAll(pblvVar.p);
                PglMSManager pglMSManager = PglMSManagerUtils.get(str);
                if (pglMSManager != null) {
                    pglMSManager.report((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c029e4", new byte[]{77, 59, 79, 68, 78, Ascii.FS, 114, Ascii.DC4, 115, 102, 96, 38}));
                }
            }
        }
    }

    public static synchronized p0 tt(String str) {
        try {
            if (str == null) {
                throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2284cd", new byte[]{34, 32, 91, 105, 120, 51, 60, 6, 122, 112, 99, 50, 78, 0, 79, 118, 37}));
            }
            if (!tt) {
                return null;
            }
            int i = pblz.c;
            Object objA = com.volcengine.mobsecBiz.matrix.pgla.a(67108866, 0, 0L, str, null);
            if (objA == null) {
                return null;
            }
            pblv pblvVar = (pblv) ve.get(str);
            if (pblvVar == null) {
                return null;
            }
            return new p0(pblvVar, pblw.c().tt(), ((Long) objA).longValue());
        } catch (Throwable th) {
            throw th;
        }
    }

    public static void ve(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d42e40", new byte[]{122, 56, 115, Ascii.DC4, Ascii.ESC, 40, 117, 1, 69, 60, 123, Utf8.REPLACEMENT_BYTE, 82, Ascii.EM, 75, 51, 104, Ascii.RS, 102, 59, 53, 123, 12, 92, 75});
        Iterator it = uj.iterator();
        while (it.hasNext()) {
            ((PglITokenObserver) it.next()).onTokenLoaded(str);
        }
    }

    public static synchronized boolean c(Context context, pblv pblvVar) {
        try {
            if (context == null) {
                throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d8dc29", new byte[]{118, 53, Ascii.EM, 3, 8, 54, 115, 89, 54, 60, 96, 54, 19, 87, 3, 33, 115, 89, 55, 54, 53, 52, 2, Ascii.ESC, 1}));
            }
            if (pblvVar == null) {
                throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "cc6d77", new byte[]{113, 110, 75, Ascii.SYN, 1, 39, 32, 65, 104, 33, 126, 101, 5, Ascii.RS, 7, 52, 32, SignedBytes.MAX_POWER_OF_TWO, 98, 116, 124, 116, 73, Ascii.FS}));
            }
            String str = pblvVar.f9703a;
            String str2 = (str == null || str.length() <= 0) ? pblvVar.g : pblvVar.f9703a;
            if (str2 == null || str2.length() <= 0) {
                throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5895b9", new byte[]{37, 42, 90, 104, 121, 110, 59, 12, 123, 113, 100, 56, 79, 1, 78, 43, 34}));
            }
            if (!tt) {
                synchronized (q0.class) {
                    if (!tt) {
                        c(context);
                        tt = true;
                    }
                }
            }
            if (ve.containsKey(str2)) {
                return false;
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(pblv.a(pblvVar.f9703a));
            jSONArray.put(pblv.a(pblvVar.h));
            jSONArray.put(pblv.a(pblvVar.g));
            jSONArray.put(pblv.a(pblvVar.i));
            jSONArray.put(pblv.a(s1.c()));
            jSONArray.put(pblv.a(pblvVar.b));
            jSONArray.put(pblv.a(pblvVar.c));
            jSONArray.put(pblv.a(pblvVar.d));
            jSONArray.put(pblv.a(pblvVar.e));
            jSONArray.put(pblv.a(pblvVar.f));
            jSONArray.put(String.valueOf(pblvVar.k));
            jSONArray.put(String.valueOf(pblvVar.l));
            jSONArray.put(String.valueOf(pblvVar.m));
            JSONArray jSONArray2 = new JSONArray();
            for (Map.Entry<String, String> entry : pblvVar.n.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey())) {
                    jSONArray2.put(pblv.a(entry.getKey()));
                    jSONArray2.put(pblv.a(entry.getValue()));
                }
            }
            jSONArray.put(jSONArray2);
            JSONArray jSONArray3 = new JSONArray();
            for (Map.Entry entry2 : pblvVar.o.entrySet()) {
                if (!TextUtils.isEmpty((CharSequence) entry2.getKey())) {
                    if (((String) entry2.getKey()).equals("kOA1") && TextUtils.equals((CharSequence) entry2.getValue(), "1")) {
                        d1.c = false;
                        d1.tt = pblvVar.j;
                    }
                    jSONArray3.put(pblv.a(entry2.getKey()));
                    jSONArray3.put(pblv.a(entry2.getValue()));
                }
            }
            jSONArray.put(jSONArray3);
            String string = jSONArray.toString();
            int i = pblz.c;
            if (!((Boolean) com.volcengine.mobsecBiz.matrix.pgla.a(67108865, 0, 0L, string, null)).booleanValue()) {
                return false;
            }
            ve.put(str2, pblvVar);
            r1.c(context).c();
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    static synchronized void c(Context context) {
        if (!tt) {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            pblw.c().c(origApplicationContext);
            h1.c(origApplicationContext);
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a0b5d8", new byte[]{62, Utf8.REPLACEMENT_BYTE, 2});
            pblz.c(16777218, new k());
            pblz.c(16777217, new v());
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1164aa", new byte[]{110, 62, 65});
            pblz.c(16777219, new g0());
            pblz.c(16777221, new j0());
            pblz.c(16777222, new k0());
            pblz.c(16777223, new l0());
            pblz.c(16777224, new m0());
            pblz.c(16777225, new n0());
            pblz.c(16777226, new o0());
            pblz.c(16777228, new a());
            pblz.c(InputDeviceCompat.SOURCE_JOYSTICK, new b());
            pblz.c(16777233, new c());
            pblz.c(16777235, new d());
            pblz.c(16777238, new e());
            pblz.c(16777239, new f());
            pblz.c(16777241, new g());
            pblz.c(16777242, new h());
            pblz.c(16777243, new i());
            pblz.c(16777244, new j());
            pblz.c(16777245, new l());
            pblz.c(16777246, new m());
            pblz.c(16777247, new n());
            pblz.c(16777248, new o());
            pblz.c(16777249, new p());
            pblz.c(16777250, new q());
            pblz.c(16777251, new r());
            pblz.c(16777240, new s());
            pblz.c(16777252, new t());
            pblz.c(16777253, new u());
            pblz.c(16777254, new w());
            pblz.c(16777255, new x());
            pblz.c(16777256, new y());
            pblz.c(16777257, new z());
            pblz.c(16777317, new a0());
            pblz.c(16777318, new b0());
            pblz.c(16777261, new c0());
            pblz.c(16777266, new d0());
            pblz.c(16777319, new e0());
            pblz.c(16777259, new f0());
            pblz.c(16777262, new h0());
            pblz.c(33554435, new i0());
            y0.c();
            z0.c();
            com.volcengine.mobsecBiz.matrix.pgla.a(16777219, 0, 0L, null, origApplicationContext);
            tt = true;
        }
    }
}
