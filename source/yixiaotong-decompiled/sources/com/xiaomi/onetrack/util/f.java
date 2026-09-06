package com.xiaomi.onetrack.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class f extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f9512a;

    public f(d dVar) {
        this.f9512a = dVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            String stringExtra = intent.getStringExtra(ijiami_1011.s.s.s.d(new byte[]{89, 92, 75, Ascii.ETB}, "138cfe"));
            String stringExtra2 = intent.getStringExtra(ijiami_1011.s.s.s.d(new byte[]{69, 4, 87, 14, 87, 1, 4, 10, 7, 15, 84}, "5e4e6f"));
            String stringExtra3 = intent.getStringExtra(ijiami_1011.s.s.s.d(new byte[]{67, 67, 13, 14, 7, 90, Ascii.NAK, 45, 2}, "31bdb9"));
            String stringExtra4 = intent.getStringExtra(ijiami_1011.s.s.s.d(new byte[]{68, 16, 80, 67}, "1c51a7"));
            boolean booleanExtra = intent.getBooleanExtra(ijiami_1011.s.s.s.d(new byte[]{88, 90, 84, 95, 8}, "4530f7"), false);
            boolean booleanExtra2 = intent.getBooleanExtra(ijiami_1011.s.s.s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, Ascii.DC4, 90, 86, 8, Ascii.DC4, 17, 8, 9, 3, 85, 10, 95}, "1a35ca"), false);
            String strE = com.xiaomi.onetrack.f.a.e();
            if (!TextUtils.isEmpty(stringExtra2) && !"".equals(stringExtra2) && strE.equals(stringExtra2)) {
                p.f9551a = booleanExtra;
                p.b = booleanExtra2;
                if (booleanExtra2 && this.f9512a.a(stringExtra)) {
                    this.f9512a.a(stringExtra, stringExtra3, stringExtra4);
                }
            }
        } catch (Exception e) {
            p.b(d.f9510a, e.getMessage());
        }
    }
}
