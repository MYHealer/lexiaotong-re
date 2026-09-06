package com.byazt.cg;

import com.byazt.dna.or;
import com.byazt.nr.m;
import com.huawei.hms.ml.camera.CountryCodeBean;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 549, 13})
public class tt implements or {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2038a;
    public Class c;
    public Method n;
    public Method tt;
    public Method uj;
    public Method ve;

    public boolean c() {
        return this.f2038a;
    }

    @Override // com.byazt.dna.or
    public void set(String str, String str2) {
    }

    public tt() {
        try {
            Class<?> clsLoadClass = getClass().getClassLoader().loadClass(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            this.c = clsLoadClass;
            Method declaredMethod = clsLoadClass.getDeclaredMethod("get", String.class);
            this.tt = declaredMethod;
            declaredMethod.setAccessible(true);
            this.f2038a = true;
        } catch (Exception unused) {
            this.c = null;
            this.f2038a = false;
        }
    }

    private Method c(String str, Class<?>... clsArr) {
        try {
            Method declaredMethod = this.c.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Exception unused) {
            return null;
        }
    }

    private <T> T c(Method method, String str) {
        if (method == null) {
            return null;
        }
        try {
            return (T) method.invoke(this.c, str);
        } catch (Exception e) {
            m.tt("SystemPropRefect", "invoke failed", e);
            return null;
        }
    }

    @Override // com.byazt.dna.or
    public String get(String str) {
        return (String) c(this.tt, str);
    }

    @Override // com.byazt.dna.or
    public int getInt(String str) {
        if (this.ve == null) {
            this.ve = c("getInt", String.class, Integer.TYPE);
        }
        Integer num = (Integer) c(this.ve, str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.byazt.dna.or
    public long getLong(String str) {
        if (this.uj == null) {
            this.uj = c("getLong", String.class, Long.TYPE);
        }
        Long l = (Long) c(this.uj, str);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    @Override // com.byazt.dna.or
    public boolean getBoolean(String str) {
        if (this.n == null) {
            this.n = c("getBoolean", String.class, Boolean.TYPE);
        }
        Boolean bool = (Boolean) c(this.n, str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
