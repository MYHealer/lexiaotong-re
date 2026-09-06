package com.byazt.gi;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.byazt.gq.t;
import com.byazt.nr.m;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 678, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f2252a = "";
    public static String n = "";
    public static volatile c sp = null;
    public static String uj = "";
    public ve c;
    public Context sl;
    public boolean x = true;
    public boolean i = false;
    public volatile boolean da = false;
    public final List<Pair<tt, uj>> t = new ArrayList();
    public final List<Object> tt = new ArrayList();
    public final ServiceConnection u = new ServiceConnection() { // from class: com.byazt.gi.c.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (c.this.ve) {
                c.this.c(false);
                c.this.c = ve.c.c(iBinder);
                c.this.ve();
                Iterator<Object> it = c.this.tt.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (c.this.ve) {
                c.this.c(false);
                c.this.c = null;
                Iterator<Object> it = c.this.tt.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    };
    public String yp = "";
    public final Object ve = new Object();

    public void c(boolean z) {
        this.da = z;
    }

    public boolean uj() {
        return this.da;
    }

    private c() {
    }

    public static c c() {
        if (sp == null) {
            synchronized (c.class) {
                if (sp == null) {
                    sp = new c();
                }
            }
        }
        return sp;
    }

    public boolean c(Context context, boolean z) {
        if (TextUtils.isEmpty(uj)) {
            JSONObject jSONObjectI = t.i();
            String strOptString = jSONObjectI.optString("s");
            uj = com.byazt.i.ve.c(jSONObjectI.optString("q"), strOptString);
            n = com.byazt.i.ve.c(jSONObjectI.optString("u"), strOptString);
            f2252a = com.byazt.i.ve.c(jSONObjectI.optString(IAdInterListener.AdReqParam.WIDTH), strOptString);
        }
        this.i = z;
        if (context == null) {
            return true;
        }
        this.sl = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (TextUtils.isEmpty(f2252a)) {
            f2252a = this.sl.getPackageName();
        }
        if (this.c != null || uj()) {
            return true;
        }
        return this.sl.bindService(c(context), this.u, 33);
    }

    public void tt() {
        if (this.c != null) {
            this.sl.unbindService(this.u);
            this.c = null;
        }
        this.tt.clear();
        this.t.clear();
    }

    public Intent c(Context context) {
        Intent intent = new Intent();
        intent.setAction(uj);
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.size() != 1) {
            return null;
        }
        for (ResolveInfo resolveInfo : listQueryIntentServices) {
            String str = resolveInfo.serviceInfo.packageName;
            String str2 = resolveInfo.serviceInfo.name;
            if (n.equals(str)) {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                return intent2;
            }
        }
        return null;
    }

    public void c(tt ttVar, uj ujVar) {
        synchronized (this.ve) {
            ttVar.n = f2252a;
            if (TextUtils.isEmpty(ttVar.f2253a)) {
                ttVar.f2253a = this.yp;
            }
            ve veVar = this.c;
            if (veVar != null) {
                try {
                    veVar.c(ttVar, ujVar);
                } catch (RemoteException e) {
                    m.c(e);
                }
            } else if (uj() || c(this.sl, this.i)) {
                this.t.add(Pair.create(ttVar, ujVar));
            }
        }
    }

    public void ve() {
        for (Pair<tt, uj> pair : this.t) {
            try {
                this.c.c((tt) pair.first, (uj) pair.second);
            } catch (RemoteException e) {
                m.c(e);
            }
        }
        this.t.clear();
    }
}
