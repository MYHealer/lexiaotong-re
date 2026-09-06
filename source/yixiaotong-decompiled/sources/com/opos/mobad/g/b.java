package com.opos.mobad.g;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.heytap.msp.opos.sv.api.params.ErrorCode;
import com.opos.mobad.ad.g;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {
    private Handler c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<Integer, com.opos.mobad.ad.c> f7006a = new HashMap<>();
    private HashMap<Integer, Boolean> b = new HashMap<>();
    private boolean d = false;

    private void a(Context context) {
        if (this.c != null) {
            return;
        }
        synchronized (this) {
            if (this.c == null) {
                this.c = new Handler(context.getMainLooper());
            }
        }
    }

    private boolean a(int i, String str) {
        if (i == com.opos.mobad.c.a.d.a.d && !TextUtils.isEmpty(str)) {
            return "1200431650".equals(str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, com.opos.mobad.c.a.d dVar, boolean z) {
        com.opos.cmn.an.f.a.b("DispatchController", "initCreatorIfNeed done");
        com.opos.cmn.an.f.a.a("AdCreatorController", "init creator size:" + this.f7006a.size() + ".CreateMap:" + this.f7006a.toString());
        String packageName = context.getApplicationInfo().name;
        if (TextUtils.isEmpty(packageName)) {
            packageName = context.getPackageName();
        }
        boolean z2 = true;
        for (Integer num : this.f7006a.keySet()) {
            String strB = dVar.b(num.intValue());
            String strC = dVar.c(num.intValue());
            String strD = dVar.d(num.intValue());
            com.opos.mobad.ad.c cVar = this.f7006a.get(num);
            com.opos.cmn.an.f.a.a("AdCreatorController", "init creator channelAppId:" + strB + "," + strD);
            if ((!TextUtils.isEmpty(strB) || num.intValue() == com.opos.mobad.c.a.d.a.g) && !((num.intValue() == com.opos.mobad.c.a.d.a.i && TextUtils.isEmpty(strD)) || ((num.intValue() == com.opos.mobad.c.a.d.a.l && TextUtils.isEmpty(strD)) || !com.opos.mobad.c.b.a().a(num.intValue()) || a(num.intValue(), strB)))) {
                this.b.put(num, true);
                cVar.a(context, strB, packageName, strC, z, new g() { // from class: com.opos.mobad.g.b.2
                    @Override // com.opos.mobad.ad.g
                    public void a() {
                        com.opos.cmn.an.f.a.b("AdCreatorController", "init channel success:");
                    }

                    @Override // com.opos.mobad.ad.g
                    public void a(String str) {
                        com.opos.cmn.an.f.a.b("AdCreatorController", "init channel fail:" + str);
                    }
                });
            } else {
                z2 = false;
            }
        }
        this.d = z2;
    }

    public int a(int i) {
        if (!this.b.containsKey(Integer.valueOf(i))) {
            return 2;
        }
        if (com.opos.mobad.c.b.a().a(i)) {
            return this.b.get(Integer.valueOf(i)).booleanValue() ? 0 : 1;
        }
        return 3;
    }

    synchronized com.opos.mobad.ad.c.a a(Context context, Integer num, com.opos.mobad.ad.c cVar) {
        if (this.f7006a.containsKey(num)) {
            return new com.opos.mobad.ad.c.a(true, "");
        }
        com.opos.mobad.ad.c.a aVarA = cVar.a(context);
        if (aVarA == null) {
            com.opos.cmn.an.f.a.c("AdCreatorController", "creator check null:" + num);
            return new com.opos.mobad.ad.c.a(false, ErrorCode.ERROR_MSG_UNKNOWN_ERROR);
        }
        if (!aVarA.f6642a) {
            com.opos.cmn.an.f.a.d("AdCreatorController", "error:" + aVarA.b);
            return aVarA;
        }
        this.f7006a.put(num, cVar);
        this.b.put(num, false);
        return aVarA;
    }

    void a(final Context context, final com.opos.mobad.c.a.d dVar, final boolean z) {
        com.opos.cmn.an.f.a.b("DispatchController", "initCreatorIfNeed");
        if (context.getMainLooper().getThread() == Thread.currentThread()) {
            b(context, dVar, z);
        } else {
            a(context);
            this.c.post(new Runnable() { // from class: com.opos.mobad.g.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.b(context, dVar, z);
                }
            });
        }
    }

    boolean a() {
        return this.f7006a.containsKey(Integer.valueOf(com.opos.mobad.c.a.d.a.f6704a));
    }

    public com.opos.mobad.ad.c b(int i) {
        return this.f7006a.get(Integer.valueOf(i));
    }

    public synchronized void b() {
        Iterator<Integer> it = this.f7006a.keySet().iterator();
        while (it.hasNext()) {
            this.f7006a.get(it.next()).b();
        }
    }
}
