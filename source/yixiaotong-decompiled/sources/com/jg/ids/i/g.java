package com.jg.ids.i;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
public class g implements com.jg.ids.m.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4608a;
    private Class<?> b;
    private Object c;

    public static boolean a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public g(Context context) {
        this.f4608a = context;
        try {
            this.b = Class.forName("android.app.ZteDeviceIdentifyManager");
            this.c = this.b.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.jg.ids.m.a
    public boolean a() {
        return this.c != null;
    }

    @Override // com.jg.ids.m.a
    public String b() {
        if (this.f4608a == null || this.b == null || this.c == null) {
            return "";
        }
        try {
            String str = (String) this.b.getMethod("getOAID", Context.class).invoke(this.c, this.f4608a);
            if (str == null || str.length() == 0) {
                return "";
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
