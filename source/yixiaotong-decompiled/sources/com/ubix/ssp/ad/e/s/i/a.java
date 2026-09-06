package com.ubix.ssp.ad.e.s.i;

import android.content.Intent;
import com.ubix.ssp.ad.e.a0.u;
import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends ThreadPoolExecutor {
    public a(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        super(i, i2, j, timeUnit, blockingQueue);
    }

    public int a(b bVar) {
        int iD = bVar.d();
        u.b("----------executeTask status " + iD);
        if (!new File(bVar.c().e()).exists()) {
            bVar.c().a(0L);
            bVar.c().b(47);
            iD = 47;
        }
        if (iD == 45 || iD == 47 || iD == 42 || iD == 47) {
            bVar.a(42);
            if (bVar.e()) {
                Intent intent = new Intent();
                intent.setAction("ACTION_WAIT");
                intent.putExtra("service_intent_unique_id", bVar.b().f());
                intent.putExtra("service_intent_notify_id", bVar.b().d());
                bVar.a(intent);
            }
            execute(bVar);
            return bVar.b().f();
        }
        if (iD != 46) {
            if (iD != 44) {
                return bVar.b().f();
            }
            u.b("----------executeTask getNotifyId " + bVar.b().d());
            return bVar.b().d();
        }
        Intent intent2 = new Intent();
        intent2.setAction("ACTION_COMPLETE");
        intent2.putExtra("service_intent_unique_id", bVar.b().f());
        intent2.putExtra("service_intent_notify_id", bVar.b().d());
        bVar.a(intent2);
        return 0;
    }
}
