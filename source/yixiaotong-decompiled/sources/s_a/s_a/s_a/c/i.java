package s_a.s_a.s_a.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class i extends s_a.s_a.s_a.a.c {

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            String str;
            h.a("2014");
            i.this.f9742a = s_a.s_a.s_a.b.a.a(iBinder);
            try {
                iBinder.linkToDeath(i.this.m, 0);
            } catch (RemoteException e) {
                e = e;
                str = "1028";
                h.a(str, e);
            } catch (Exception e2) {
                e = e2;
                str = "1071";
                h.a(str, e);
            }
            synchronized (i.this.d) {
                h.a("2015");
                i.this.d.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            h.a("2016");
            i.this.f9742a = null;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f9758a = new i();
    }

    public i() {
        this.e = new a();
    }

    @Override // s_a.s_a.s_a.a.c
    public Intent a() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(s_a.s_a.s_a.c.a.a("Y29tLmNvbG9yb3MubWNz"), "com.oplus.stdid.IdentifyService"));
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
            str2 = "1074";
            h.a(str2, e);
            if (str == "OUID_STATUS") {
                return "FALSE";
            }
            return "";
        } catch (Exception e2) {
            e = e2;
            str2 = "1075";
            h.a(str2, e);
            if (str == "OUID_STATUS") {
                return "FALSE";
            }
            return "";
        }
    }

    @Override // s_a.s_a.s_a.a.c
    public void a(Context context, String str, String str2) {
        s_a.s_a.s_a.c.b.C1191b.f9750a.a(context, str, str2);
    }

    @Override // s_a.s_a.s_a.a.c
    public boolean b(String str) {
        return s_a.s_a.s_a.c.b.C1191b.f9750a.b(str);
    }

    @Override // s_a.s_a.s_a.a.c
    public boolean c(String str) {
        return s_a.s_a.s_a.c.b.C1191b.f9750a.a(str);
    }
}
