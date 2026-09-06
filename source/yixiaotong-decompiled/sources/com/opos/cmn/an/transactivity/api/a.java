package com.opos.cmn.an.transactivity.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a {
    public static void a(Context context, b bVar) {
        try {
            if (bVar == null) {
                com.opos.cmn.an.f.a.b("TransActivityTool", "startTransActivity failed, transLifeCallback cannot be null");
                return;
            }
            Intent intent = new Intent(context, (Class<?>) TransActivity.class);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            intent.putExtra("extra_key_trans_life_callback", bVar);
            context.startActivity(intent);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("TransActivityTool", "startTransActivity failed", e);
        }
    }
}
