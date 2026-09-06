package com.oplus.stdid.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import s_a.s_a.s_a.c.h;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c extends s_a.s_a.s_a.a.c {

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            String str;
            h.a("2014");
            c.this.f9742a = s_a.s_a.s_a.b.a.a(iBinder);
            try {
                iBinder.linkToDeath(c.this.m, 0);
            } catch (RemoteException e) {
                e = e;
                str = "1076";
                h.a(str, e);
            } catch (Exception e2) {
                e = e2;
                str = "1077";
                h.a(str, e);
            }
            synchronized (c.this.d) {
                h.a("2015");
                c.this.d.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            h.a("2016");
            c.this.f9742a = null;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f5843a = new c();
    }

    public c() {
        this.e = new a();
    }

    @Override // s_a.s_a.s_a.a.c
    public Intent a() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.oplus.stdid", "com.oplus.stdid.IdentifyService"));
        intent.setAction("action.com.oplus.stdid.ID_SERVICE");
        h.a("2012");
        return intent;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0024 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:14:0x0027 A[ORIG_RETURN, RETURN] */
    @Override // s_a.s_a.s_a.a.c
    public String a(String str) {
        String str2;
        try {
            return this.i ? d(str) : ((s_a.s_a.s_a.b) this.f9742a).a(this.b, this.c, str);
        } catch (NullPointerException e) {
            e = e;
            str2 = "1080";
            h.a(str2, e);
            if (str == "OUID_STATUS") {
                return "FALSE";
            }
            return "";
        } catch (Exception e2) {
            e = e2;
            str2 = "1081";
            h.a(str2, e);
            if (str == "OUID_STATUS") {
                return "FALSE";
            }
            return "";
        }
    }

    @Override // s_a.s_a.s_a.a.c
    public void a(Context context, String str, String str2) {
        com.oplus.stdid.sdk.b.a.f5841a.a(context, str, str2);
    }

    @Override // s_a.s_a.s_a.a.c
    public boolean b(String str) {
        return com.oplus.stdid.sdk.b.a.f5841a.b(str);
    }

    @Override // s_a.s_a.s_a.a.c
    public boolean c(String str) {
        return com.oplus.stdid.sdk.b.a.f5841a.a(str);
    }
}
