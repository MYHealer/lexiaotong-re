package com.adprof.sdk;

import com.cdo.oaps.ad.OapsKey;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class u1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v1 f1450a;

    public u1(v1 v1Var) {
        this.f1450a = v1Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        w1 w1Var = this.f1450a.f1469a;
        w1Var.f790a.writeLock().lock();
        HashMap map = w1Var.f789a;
        if (map == null || map.size() == 0) {
            w1Var.f790a.writeLock().unlock();
            return;
        }
        try {
            Iterator it = w1Var.f789a.keySet().iterator();
            if (it.hasNext()) {
                StringBuilder sb = new StringBuilder();
                sb.append("delete from ");
                sb.append(OapsKey.KEY_POINT);
                sb.append(" where point_id in ( ");
                while (true) {
                    sb.append((Integer) it.next());
                    if (!it.hasNext()) {
                        break;
                    } else {
                        sb.append(',').append(' ');
                    }
                }
                sb.append(" )");
                w1Var.f787a.execSQL(sb.toString());
            }
        } catch (Throwable th) {
            pk.b("clearLogDB fail", th);
        }
        w1Var.f791a = false;
        w1Var.f789a = null;
        w1Var.f790a.writeLock().unlock();
    }
}
