package com.meishu.sdk.core.utils;

import android.text.TextUtils;
import com.meishu.sdk.core.AdSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: CheckAppInstallHelper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d {
    public static final /* synthetic */ int n = 0;
    public PackageBean c;
    public PackageBean d;
    public int e;
    public long f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<PackageBean.AppBean.PackBean> f4892a = new ArrayList<>();
    public final ConcurrentHashMap<String, Boolean> b = new ConcurrentHashMap<>();
    public volatile boolean l = false;
    public final Object m = new Object();

    /* JADX INFO: compiled from: CheckAppInstallHelper.java */
    public class a extends com.meishu.sdk.core.safe.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f4893a;

        public a(boolean z) {
            this.f4893a = z;
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            if (d.this.a(this.f4893a)) {
                q0.a(AdSdk.getContext(), d.this.c);
            }
        }
    }

    /* JADX INFO: compiled from: CheckAppInstallHelper.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f4894a = new d();
    }

    public void a(boolean z, boolean z2) {
        if (z) {
            ExecutorService executorService = g0.f4905a;
            g0.b.f4906a.a(new a(z2));
        } else if (a(z2)) {
            q0.a(AdSdk.getContext(), this.c);
        }
    }

    public final boolean a(boolean z) {
        try {
            if (this.f4892a.isEmpty()) {
                synchronized (this.m) {
                    a((PackageBean) null);
                }
            }
            if (this.f4892a.isEmpty()) {
                LogUtil.dev(com.kuaishou.weapon.p0.t.t, "finalList is empty");
                this.l = false;
                return false;
            }
            if (System.currentTimeMillis() - this.f < this.i) {
                LogUtil.dev(com.kuaishou.weapon.p0.t.t, "time interval too close");
                this.l = false;
                return false;
            }
            int i = z ? this.h : this.g;
            if (i <= 0) {
                LogUtil.dev(com.kuaishou.weapon.p0.t.t, "no check PackBean. isInit:" + z);
                this.l = false;
                return false;
            }
            if (this.l) {
                LogUtil.dev(com.kuaishou.weapon.p0.t.t, "isChecking. no check PackBean.");
                this.l = false;
                return false;
            }
            this.l = true;
            ArrayList<PackageBean.AppBean.PackBean> arrayList = this.f4892a;
            if (arrayList != null && !arrayList.isEmpty()) {
                Collections.sort(arrayList, new e(this));
            }
            int i2 = 0;
            for (PackageBean.AppBean.PackBean packBean : this.f4892a) {
                if (this.j == 0 && !com.meishu.sdk.core.service.d.a()) {
                    LogUtil.dev(com.kuaishou.weapon.p0.t.t, "app background, no check PackBean");
                    break;
                }
                if (q0.a(AdSdk.getContext(), this.e, packBean)) {
                    try {
                        this.b.put(packBean.getId(), Boolean.valueOf(packBean.getInstalled()));
                    } catch (Throwable unused) {
                    }
                    i2++;
                    if (i2 >= i) {
                        break;
                    }
                    int i3 = this.k;
                    if (i3 > 0) {
                        try {
                            Thread.sleep(i3);
                        } catch (Exception unused2) {
                        }
                    }
                }
            }
            if (i2 == 0) {
                LogUtil.dev(com.kuaishou.weapon.p0.t.t, "checkCount zero.");
                this.l = false;
                return false;
            }
            this.f = System.currentTimeMillis();
            synchronized (this.m) {
                try {
                    AdSdk.getSharedPreferences().edit().putString("packageKey", u.f4948a.toJson(this.c)).commit();
                } catch (Exception unused3) {
                }
            }
            this.l = false;
            return true;
        } catch (Throwable unused4) {
            this.l = false;
            return false;
        }
    }

    public final void a(PackageBean packageBean) {
        PackageBean packageBeanA;
        try {
            if (packageBean == null) {
                if (!this.f4892a.isEmpty() || (packageBeanA = a()) == null) {
                    return;
                } else {
                    this.c = packageBeanA;
                }
            } else {
                this.c = packageBean;
                a(packageBean.getApp());
            }
            PackageBean packageBean2 = this.c;
            if (packageBean2 != null && packageBean2.getApp() != null) {
                Integer ttl = this.c.getApp().getTtl();
                this.e = ttl != null ? ttl.intValue() : 0;
                Integer a2 = this.c.getApp().getA();
                this.h = a2 != null ? a2.intValue() : 10;
                Integer b2 = this.c.getApp().getB();
                this.g = b2 != null ? b2.intValue() : 5;
                Integer c = this.c.getApp().getC();
                this.k = c != null ? c.intValue() : 200;
                Integer d = this.c.getApp().getD();
                this.i = d != null ? d.intValue() : com.alipay.security.mobile.module.http.constant.a.f1701a;
                Integer e = this.c.getApp().getE();
                this.j = e != null ? e.intValue() : 0;
                List<PackageBean.AppBean.PackBean> required = this.c.getApp().getRequired();
                List<PackageBean.AppBean.PackBean> others = this.c.getApp().getOthers();
                this.f4892a.clear();
                this.b.clear();
                if (required != null && !required.isEmpty()) {
                    this.f4892a.addAll(required);
                }
                if (others != null && !others.isEmpty()) {
                    this.f4892a.addAll(others);
                }
                for (PackageBean.AppBean.PackBean packBean : this.f4892a) {
                    if (packBean != null && packBean.getExpirationTime() == 0 && packBean.getLastCheckTime() > 0) {
                        packBean.setExpirationTime((((long) this.e) * 1000) + packBean.getLastCheckTime());
                    }
                    if (!TextUtils.isEmpty(packBean.getId()) && (packBean.getLastCheckTime() > 0 || packBean.getExpirationTime() > 0)) {
                        this.b.put(packBean.getId(), Boolean.valueOf(packBean.getInstalled()));
                    }
                }
                ArrayList<PackageBean.AppBean.PackBean> arrayList = this.f4892a;
                if (arrayList != null && !arrayList.isEmpty()) {
                    Collections.sort(arrayList, new e(this));
                    return;
                }
                return;
            }
            this.f4892a.clear();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(PackageBean.AppBean appBean) {
        HashMap map;
        if (appBean == null) {
            return;
        }
        PackageBean packageBeanA = a();
        if (packageBeanA == null || packageBeanA.getApp() == null) {
            map = null;
        } else {
            map = new HashMap();
            List<PackageBean.AppBean.PackBean> required = packageBeanA.getApp().getRequired();
            if (required != null && !required.isEmpty()) {
                for (PackageBean.AppBean.PackBean packBean : required) {
                    if (!TextUtils.isEmpty(packBean.getId())) {
                        map.put(packBean.getId(), packBean);
                    }
                }
            }
            List<PackageBean.AppBean.PackBean> others = packageBeanA.getApp().getOthers();
            if (others != null && !others.isEmpty()) {
                for (PackageBean.AppBean.PackBean packBean2 : others) {
                    if (!TextUtils.isEmpty(packBean2.getId())) {
                        map.put(packBean2.getId(), packBean2);
                    }
                }
            }
        }
        if (map == null || map.isEmpty()) {
            return;
        }
        List<PackageBean.AppBean.PackBean> required2 = appBean.getRequired();
        if (required2 != null) {
            for (PackageBean.AppBean.PackBean packBean3 : required2) {
                PackageBean.AppBean.PackBean packBean4 = (PackageBean.AppBean.PackBean) map.get(packBean3.getId());
                if (packBean4 != null) {
                    packBean3.setInstalled(packBean4.getInstalled());
                    packBean3.setLastCheckTime(packBean4.getLastCheckTime());
                    packBean3.setExpirationTime(packBean4.getExpirationTime());
                }
            }
        }
        List<PackageBean.AppBean.PackBean> others2 = appBean.getOthers();
        if (others2 != null) {
            for (PackageBean.AppBean.PackBean packBean5 : others2) {
                PackageBean.AppBean.PackBean packBean6 = (PackageBean.AppBean.PackBean) map.get(packBean5.getId());
                if (packBean6 != null) {
                    packBean5.setInstalled(packBean6.getInstalled());
                    packBean5.setLastCheckTime(packBean6.getLastCheckTime());
                    packBean5.setExpirationTime(packBean6.getExpirationTime());
                }
            }
        }
    }

    public final PackageBean a() {
        PackageBean packageBean = this.d;
        if (packageBean != null) {
            return packageBean;
        }
        String string = AdSdk.getSharedPreferences().getString("packageKey", "");
        if (TextUtils.isEmpty(string)) {
            this.d = null;
        } else {
            this.d = (PackageBean) u.f4948a.fromJson(string, PackageBean.class);
        }
        return this.d;
    }
}
