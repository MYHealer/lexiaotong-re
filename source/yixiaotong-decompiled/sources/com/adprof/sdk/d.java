package com.adprof.sdk;

import android.text.TextUtils;
import com.adprof.sdk.api.AdAppInfo;
import com.huawei.openalliance.ad.constant.br;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class d implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public transient AdAppInfo f182a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public go f183a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public i0 f184a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public transient kl f185a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public transient n5 f186a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public n f187a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public q0 f188a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public u0 f189a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd f190a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Long f191a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f192a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public transient WeakReference f193a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f194a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map f196a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f198b;
    public int c;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f205g;
    public String k;
    public String l;
    public String m;
    public String n;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f180a = 0;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f200c = "";

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f202d = "";

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f203e = "";

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f204f = "";
    public int d = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public transient List f195a = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f1119a = -1.0d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f197a = true;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f199b = true;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public String f206h = "";
    public int e = 0;
    public int f = 3;
    public int g = 0;
    public int h = 100;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f201c = false;
    public String i = "";
    public String j = "";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f181a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public AdAppInfo m588a() {
        return this.f182a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public i0 m589a() {
        go goVar;
        if (this.f184a == null && (goVar = this.f183a) != null) {
            i0 i0Var = new i0();
            this.f184a = i0Var;
            i0Var.f373a = goVar.f321a;
            i0Var.f374b = goVar.f322b;
            i0Var.b = goVar.b.intValue();
            this.f184a.f1219a = this.f183a.f1197a.intValue();
            if (this.f1119a < 0.0d && this.f183a.b.intValue() > 0 && this.f183a.f1197a.intValue() > 0) {
                this.f1119a = (this.f183a.f1197a.intValue() * 1.0f) / this.f183a.b.intValue();
            }
        }
        return this.f184a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public n m591a() {
        if (this.f187a == null) {
            this.f187a = new n();
        }
        return this.f187a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public q0 m592a() {
        return this.f188a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public File m593a() {
        if (m605f()) {
            return new File(k1.b() + File.separator + be.a(m()));
        }
        return null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public List m595a() {
        return this.f195a;
    }

    public void a(x0 x0Var) {
        this.f193a = new WeakReference(x0Var);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m597a() {
        return this.c == 3;
    }

    public int b() {
        return this.c;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public String m598b() {
        AdAppInfo adAppInfo = this.f182a;
        return adAppInfo != null ? adAppInfo.getAppLogo() : "";
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m600b() {
        q0 q0Var = this.f188a;
        return q0Var != null && q0Var.d == 1;
    }

    public int c() {
        return this.b;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public String m601c() {
        AdAppInfo adAppInfo = this.f182a;
        return adAppInfo != null ? adAppInfo.getAppName() : "";
    }

    public String d() {
        return this.c != 3 ? "查看详情" : "立即下载";
    }

    public String e() {
        wd wdVar = this.f190a;
        return wdVar != null ? wdVar.f795a : "";
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    public boolean m604e() {
        return this.f181a <= 0 || System.currentTimeMillis() <= this.f181a;
    }

    public String f() {
        if (pk.f594a) {
            pk.d("getDeeplinkUrl  " + this.f200c);
        }
        return this.f200c;
    }

    /* JADX INFO: renamed from: f, reason: collision with other method in class */
    public boolean m605f() {
        go goVar = this.f183a;
        return (goVar == null || TextUtils.isEmpty(goVar.f321a)) ? false : true;
    }

    public String g() {
        return this.f203e;
    }

    public String h() {
        AdAppInfo adAppInfo = this.f182a;
        return (adAppInfo == null || TextUtils.isEmpty(adAppInfo.getDownloadUrl())) ? "" : this.f182a.getDownloadUrl();
    }

    public String i() {
        return this.f204f;
    }

    public String j() {
        return this.f202d;
    }

    public String k() {
        if (this.f192a == null) {
            this.f192a = UUID.randomUUID().toString();
        }
        return this.f192a;
    }

    public String l() {
        go goVar = this.f183a;
        if (goVar == null || TextUtils.isEmpty(goVar.f322b)) {
            return null;
        }
        return this.f183a.f322b;
    }

    public String m() {
        go goVar = this.f183a;
        if (goVar == null || TextUtils.isEmpty(goVar.f321a)) {
            return null;
        }
        return this.f183a.f321a;
    }

    public final void a(String str, List list) {
        String str2 = this.l;
        int i = this.f190a.f1499a;
        qh.a(list);
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            pk.d("createTrackersForUrls  adunitID  = " + e() + " ad_type = " + this.f190a.f1499a + "  event = " + str + "     url  = " + str3);
            c cVar = new c(str3, str, str2, i);
            ((o2) cVar).f528a = 0;
            arrayList.add(cVar);
        }
        this.f194a.put(str, arrayList);
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m602c() {
        return this.f190a.f1499a == 4;
    }

    /* JADX INFO: renamed from: g, reason: collision with other method in class */
    public boolean m606g() {
        return this.f190a.f1499a == 5;
    }

    /* JADX INFO: renamed from: h, reason: collision with other method in class */
    public boolean m607h() {
        q0 q0Var = this.f188a;
        return q0Var != null && q0Var.c == 3;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public final void m599b() {
        int i = this.c;
        if (i == 1) {
            m591a().f1472a.put("_DPLINK_", "2");
        }
        if (i == 2) {
            m591a().f1472a.put("_DPLINK_", "1");
        }
        m591a().f1472a.put("__X_WP__", this.b + "");
        m591a().f1472a.put("__X_LR__", "100");
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public boolean m603d() {
        return !TextUtils.isEmpty(this.f204f);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m596a() {
        if (this.f186a != null) {
            this.f186a = null;
        }
        h2 h2Var = h2.f1202a;
        if (TextUtils.isEmpty(k())) {
            return;
        }
        ((HashMap) h2.f330a).remove(k());
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public n5 m590a() {
        n5 n5Var = this.f186a;
        if (n5Var != null) {
            return n5Var;
        }
        int i = this.f190a.f1499a;
        if (i == 1) {
            xe xeVar = new xe(this);
            this.f186a = xeVar;
            return xeVar;
        }
        if (i == 2) {
            xl xlVar = new xl(this);
            this.f186a = xlVar;
            return xlVar;
        }
        if (i != 3 && i != 4 && i != 5) {
            return n5Var;
        }
        jc jcVar = new jc(this);
        this.f186a = jcVar;
        return jcVar;
    }

    public int a() {
        List list;
        if (m605f()) {
            return 2;
        }
        return (this.f180a != 5 || (list = this.f195a) == null || list.size() < 3) ? 1 : 3;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m594a() {
        if (m605f()) {
            return k1.b() + File.separator + be.a(m());
        }
        if (!m603d()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sbAppend = new StringBuilder().append(k1.f415a);
        String str = File.separator;
        String string = sbAppend.append(str).append("image").toString();
        File file = new File(string);
        if (!file.exists()) {
            file.mkdirs();
        }
        return sb.append(string).append(str).append(be.a(this.f204f)).toString();
    }

    public final void a(i1 i1Var) {
        this.f194a = new HashMap();
        List list = i1Var.f1220a;
        if (list != null && !list.isEmpty()) {
            a(br.b.V, list);
        }
        List list2 = i1Var.b;
        if (list2 != null && !list2.isEmpty()) {
            a("click", list2);
        }
        List list3 = i1Var.f;
        if (list3 != null && !list3.isEmpty()) {
            a("win", list3);
        }
        List list4 = i1Var.e;
        if (list4 != null && !list4.isEmpty()) {
            a("lose", list4);
        }
        List list5 = i1Var.c;
        if (list5 != null && !list5.isEmpty()) {
            a("open_deeplink_success", list5);
        }
        List list6 = i1Var.d;
        if (list6 != null && !list6.isEmpty()) {
            a("open_deeplink_fail", list6);
        }
        List list7 = i1Var.g;
        if (list7 != null && !list7.isEmpty()) {
            a("download_start", list7);
        }
        List list8 = i1Var.h;
        if (list8 != null && !list8.isEmpty()) {
            a("download_end", list8);
        }
        List list9 = i1Var.i;
        if (list9 != null && !list9.isEmpty()) {
            a("app_install_start", list9);
        }
        List list10 = i1Var.j;
        if (list10 == null || list10.isEmpty()) {
            return;
        }
        a("app_install_end", list10);
    }

    public void a(int i, int i2) {
        float f = i;
        m591a().f1472a.put("__SLOTX__", String.valueOf(h8.b(f)));
        m591a().f1472a.put("__HW_W__", String.valueOf(h8.b(f)));
        float f2 = i2;
        m591a().f1472a.put("__SLOTY__", String.valueOf(h8.b(f2)));
        m591a().f1472a.put("__HW_H__", String.valueOf(h8.b(f2)));
    }
}
