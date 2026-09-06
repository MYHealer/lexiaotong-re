package com.byazt.omf;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.nys.PluginConstants;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 31, 47})
public class eo {
    public Function<SparseArray<Object>, Object> x;
    public static final eo uj = new eo();
    public static int sp = -1;
    public static String i = "ext_plugin";
    public volatile Function<SparseArray<Object>, Object> c = null;
    public volatile Function<SparseArray<Object>, Object> tt = null;
    public volatile Function<SparseArray<Object>, Object> ve = null;
    public AtomicBoolean n = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicBoolean f2561a = new AtomicBoolean(false);

    public static eo c() {
        return uj;
    }

    private eo() {
    }

    public Function<SparseArray<Object>, Object> c(int i2) {
        try {
            if (p.c() && i2 == 10003) {
                return sp();
            }
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
        return null;
    }

    public static int tt() {
        if (sp == -1) {
            sp = c().a().intValue();
        }
        return sp;
    }

    private Integer a() {
        Function<SparseArray<Object>, Object> functionI = i();
        if (functionI != null) {
            Object objApply = functionI.apply(com.byazt.yxi.uj.c().c(1004).c(Integer.class).tt());
            if (objApply instanceof Integer) {
                return (Integer) objApply;
            }
        }
        return -1;
    }

    private Function<SparseArray<Object>, Object> sp() {
        com.byazt.whk.ve veVar = (com.byazt.whk.ve) com.byazt.ut.uj.getService("pitaya");
        if (veVar == null || !veVar.isPitayaEnvAvailable()) {
            com.byazt.nr.m.uj(i, "can use pitaya false");
            return null;
        }
        if (!uj() || a().intValue() < 1100) {
            return null;
        }
        if (this.ve == null) {
            synchronized (eo.class) {
                if (this.ve == null) {
                    try {
                        Function<SparseArray<Object>, Object> functionI = i();
                        if (functionI != null) {
                            Object objApply = functionI.apply(com.byazt.yxi.uj.c().c(10003).c(Function.class).tt());
                            if (objApply instanceof Function) {
                                this.ve = (Function) objApply;
                            }
                        }
                    } catch (Throwable th) {
                        com.byazt.nr.m.uj(i, "getBridge:" + th.getMessage());
                    }
                }
            }
        }
        return this.ve;
    }

    public static void ve() {
        if (gt.tt().pf()) {
            Bundle bundle = new Bundle();
            Bundle bundleC = c(x.m().rl());
            if (bundleC != null) {
                bundle.putBundle("com.byted.csj.ext", bundleC);
            }
            x.m().c(bundle);
            return;
        }
        JSONObject jSONObjectCu = x.m().cu();
        if (jSONObjectCu != null) {
            jSONObjectCu.remove("com.byted.csj.ext");
        }
    }

    private static Bundle c(String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", str);
            String strX = x();
            if (TextUtils.isEmpty(strX)) {
                return null;
            }
            bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, strX);
            bundle.putString("sdk_version", tt(p.f2567a));
            return bundle;
        } catch (Throwable th) {
            com.byazt.nr.m.uj(i, "error:" + th.getMessage());
            com.byazt.nr.m.c(th);
            return null;
        }
    }

    private static String x() {
        return (String) x.m().lt().apply(com.byazt.yxi.uj.c().c(8).c(String.class).c(0, "com.byted.csj.ext").tt());
    }

    public static String tt(int i2) {
        char[] charArray = String.valueOf(i2).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < charArray.length; i3++) {
            sb.append(charArray[i3]);
            if (i3 < charArray.length - 1) {
                sb.append(".");
            }
        }
        String string = sb.toString();
        return (i2 < 100 || i2 >= 1000) ? string : "0." + string;
    }

    public boolean uj() {
        try {
            if (!gt.tt().pf()) {
                return false;
            }
            if (this.n.get()) {
                return true;
            }
            if (this.f2561a.compareAndSet(false, true)) {
                final Function<SparseArray<Object>, Object> functionLt = x.m().lt();
                Object objApply = functionLt.apply(com.byazt.yxi.uj.c().c(6).c(Boolean.class).c(0, "com.byted.csj.ext").tt());
                if (objApply != null && ((Boolean) objApply).booleanValue()) {
                    Object objApply2 = functionLt.apply(com.byazt.yxi.uj.c().c(7).c(Boolean.class).c(0, "com.byted.csj.ext").tt());
                    if (objApply2 != null && ((Boolean) objApply2).booleanValue()) {
                        this.n.set(true);
                        this.f2561a.set(false);
                        return true;
                    }
                    com.byazt.nr.da.c().post(new Runnable() { // from class: com.byazt.omf.eo.1
                        @Override // java.lang.Runnable
                        public void run() {
                            eo.this.c(functionLt, true);
                        }
                    });
                } else {
                    this.f2561a.set(false);
                }
            }
            return false;
        } catch (Throwable th) {
            com.byazt.nr.m.uj(i, "pit_ext_error:" + th.getMessage());
        }
    }

    public com.byazt.jg.c n() {
        if (com.byazt.vgp.tt.c(gt.tt().l()) && uj()) {
            return (com.byazt.jg.c) com.byazt.ut.uj.getService("alog");
        }
        return null;
    }

    private Function<SparseArray<Object>, Object> i() {
        ClassLoader classLoader;
        try {
            if (this.x == null && (classLoader = (ClassLoader) x.m().lt().apply(com.byazt.yxi.uj.c().c(4).c(ClassLoader.class).c(0, "com.byted.csj.ext").tt())) != null) {
                this.x = (Function) classLoader.loadClass("com.byted.csj.ext_impl.ServiceManager").getConstructor(new Class[0]).newInstance(new Object[0]);
            }
            return this.x;
        } catch (Throwable th) {
            com.byazt.nr.m.uj(i, "getServiceManager:" + th.getMessage());
            return null;
        }
    }

    public boolean c(Function<SparseArray<Object>, Object> function, boolean z) {
        try {
            if (this.n.get()) {
                return true;
            }
            if (!z) {
                this.f2561a.set(true);
            }
            Object objApply = function.apply(com.byazt.yxi.uj.c().c(5).c(Boolean.class).c(0, "com.byted.csj.ext").tt());
            boolean zBooleanValue = objApply != null ? ((Boolean) objApply).booleanValue() : false;
            this.n.set(zBooleanValue);
            this.f2561a.set(false);
            return zBooleanValue;
        } catch (Throwable th) {
            com.byazt.nr.m.uj(i, com.huawei.openalliance.ad.constant.x.bQ + th.getMessage());
            return false;
        }
    }
}
