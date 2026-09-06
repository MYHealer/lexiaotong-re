package com.adprof.sdk;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class li implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1289a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public pi f444a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public q7 f445a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f446a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f447a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f448a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f449b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f450b;

    public li(int i, String str, pi piVar) {
        int i2 = kp.f1273a;
        this.f446a = new Object();
        this.f448a = false;
        this.f450b = false;
        this.f1289a = i;
        this.f447a = str;
        this.f444a = piVar;
        a(new q7());
        this.b = a(str);
    }

    public static int a(String str) {
        Uri uri;
        String host;
        if (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null || (host = uri.getHost()) == null) {
            return 0;
        }
        return host.hashCode();
    }

    public int a() {
        return Integer.MIN_VALUE;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public ji mo673a() {
        return ji.NORMAL;
    }

    public li a(q7 q7Var) {
        this.f445a = q7Var;
        return this;
    }

    public final li a(boolean z) {
        this.f450b = z;
        return this;
    }

    public abstract ri a(fg fgVar);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m674a() {
        String str = this.f449b;
        return str == null ? this.f447a : str;
    }

    /* JADX INFO: renamed from: a */
    public Map mo610a() {
        return Collections.emptyMap();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m675a() {
        synchronized (this.f446a) {
            this.f448a = true;
        }
    }

    public abstract void a(jp jpVar);

    public abstract void a(Object obj);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m676a() {
        synchronized (this.f446a) {
        }
        return false;
    }

    public void b() {
        synchronized (this.f446a) {
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        ji jiVarMo673a = mo673a();
        ji jiVarMo673a2 = ((li) obj).mo673a();
        if (jiVarMo673a != jiVarMo673a2) {
            return jiVarMo673a2.ordinal() - jiVarMo673a.ordinal();
        }
        throw null;
    }

    public String toString() {
        String str = "0x" + Integer.toHexString(this.b);
        StringBuilder sb = new StringBuilder("[ ] ");
        m676a();
        return sb.append(m674a()).append(PPSLabelView.Code).append(str).append(PPSLabelView.Code).append(mo673a()).append(" null").toString();
    }
}
