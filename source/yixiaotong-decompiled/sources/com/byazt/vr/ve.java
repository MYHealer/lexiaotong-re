package com.byazt.vr;

import android.content.Context;
import android.os.Handler;
import com.byazt.mg.da;
import com.google.android.exoplayer2.C;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1683, 54})
public final class ve {
    public List<c> c;

    private ve(Handler handler, Context context) {
        ArrayList arrayList = new ArrayList(3);
        this.c = arrayList;
        arrayList.add(new tt(handler, 0L, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS));
    }

    public static ve c(Handler handler, Context context) {
        return new ve(handler, context);
    }

    public void c() {
        da.c("[ScheduleTaskManager] execute, task size=" + this.c.size());
        Iterator<c> it = this.c.iterator();
        while (it.hasNext()) {
            try {
                it.next().c();
            } catch (Throwable unused) {
            }
        }
    }
}
