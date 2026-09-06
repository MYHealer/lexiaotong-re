package com.meishu.sdk.core.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.meishu.sdk.core.safe.SafeBroadcastReceiver;

/* JADX INFO: compiled from: HomeWatcher.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IntentFilter f4951a = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    public final b b = new b(this, null);
    public boolean c;
    public boolean d;
    public boolean e;

    /* JADX INFO: compiled from: HomeWatcher.java */
    public static /* synthetic */ class a {
    }

    /* JADX INFO: compiled from: HomeWatcher.java */
    public static class b extends SafeBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final v f4952a;

        public /* synthetic */ b(v vVar, a aVar) {
            this(vVar);
        }

        @Override // com.meishu.sdk.core.safe.SafeBroadcastReceiver
        public void a(Context context, Intent intent) {
            v vVar;
            String stringExtra = intent.getStringExtra("reason");
            LogUtil.dev("HW", "reason:" + stringExtra);
            if ("homekey".equals(stringExtra)) {
                v vVar2 = this.f4952a;
                if (vVar2 != null) {
                    vVar2.c = true;
                    return;
                }
                return;
            }
            if (!"recentapps".equals(stringExtra) || (vVar = this.f4952a) == null) {
                return;
            }
            vVar.d = true;
        }

        public b(v vVar) {
            this.f4952a = vVar;
        }
    }
}
