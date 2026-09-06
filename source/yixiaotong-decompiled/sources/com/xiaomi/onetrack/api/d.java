package com.xiaomi.onetrack.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class d extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f9424a;

    public d(c cVar) {
        this.f9424a = cVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            if (this.f9424a.d != null) {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                if (action.equals(ijiami_1011.s.s.s.d(new byte[]{85, 94, 93, 17, 86, 95, 5, 74, 15, 12, 69, 0, 90, 68, Ascii.ETB, 2, 90, 66, 8, 11, 8, 76, 98, 38, 102, 117, 124, 45, 102, 121, 47}, "409c96"))) {
                    this.f9424a.d.sendEmptyMessageDelayed(100, 500L);
                } else if (action.equals(ijiami_1011.s.s.s.d(new byte[]{85, 88, 85, 65, 9, 80, 5, 74, 15, 12, 69, 0, 90, 66, Ascii.US, 82, 5, 77, 8, 11, 8, 76, 98, 38, 102, 115, 116, 125, 57, 118, 39, 34}, "4613f9"))) {
                    this.f9424a.d.sendEmptyMessageDelayed(101, 500L);
                }
            }
        } catch (Throwable th) {
            com.xiaomi.onetrack.util.p.b(ijiami_1011.s.s.s.d(new byte[]{35, 68, 11, 87, 6, 6, 0, Ascii.ETB, Ascii.DC2, 47, 80, 11, 0, 81, 1, 68}, "a6d6be"), ijiami_1011.s.s.s.d(new byte[]{Ascii.NAK, 0, Ascii.SYN, 3, 86, 10, 51, 1, 5, 7, 88, 19, 3, 17, 68, Ascii.DC2, 91, Ascii.SYN, 14, 19, 7, 0, 93, 0, 92, 67}, "fcdf3d") + th.getMessage());
        }
    }
}
