package com.xiaomi.onetrack.util;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f9513a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ d d;

    public g(d dVar, String str, String str2, String str3) {
        this.d = dVar;
        this.f9513a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        StringBuilder sbAppend;
        String strD;
        try {
            if (TextUtils.isEmpty(this.f9513a)) {
                return;
            }
            if (this.f9513a.contains(ijiami_1011.s.s.s.d(new byte[]{81, Ascii.DC2, 77, 70, 14, 73, 78}, "9f964f")) || this.f9513a.contains(ijiami_1011.s.s.s.d(new byte[]{12, 76, Ascii.SYN, 69, 17, 95, 78, 75}, "d8b5be"))) {
                sbAppend = new StringBuilder().append(this.f9513a);
                strD = ijiami_1011.s.s.s.d(new byte[]{78, 84, Ascii.SYN, 88, 73, 92, 17, 1, 8, 77, 85, 0, Ascii.ETB, 92, 5, 84, 73, 68, 19, 13, Ascii.DC2, 7, 115, 4, 2, 94}, "a5f1f3");
            } else {
                sbAppend = new StringBuilder().append(ijiami_1011.s.s.s.d(new byte[]{10, 76, 71, Ascii.DC2, 16, 8, 78, 75}, "b83bc2")).append(this.f9513a);
                strD = ijiami_1011.s.s.s.d(new byte[]{Ascii.RS, 84, SignedBytes.MAX_POWER_OF_TWO, 88, 74, 88, 17, 1, 8, 77, 85, 0, 71, 92, 83, 84, 74, SignedBytes.MAX_POWER_OF_TWO, 19, 13, Ascii.DC2, 7, 115, 4, 82, 94}, "1501e7");
            }
            String string = sbAppend.append(strD).toString();
            HashMap map = new HashMap();
            map.put(ijiami_1011.s.s.s.d(new byte[]{8, 87, Ascii.NAK, 67, 81, 89, 2, 1, 47, 6}, "a9f707"), o.a().b());
            map.put(ijiami_1011.s.s.s.d(new byte[]{80, 91, 80, 88}, "965120"), DeviceUtil.b(this.d.j));
            map.put(ijiami_1011.s.s.s.d(new byte[]{10, 3, 93, 86}, "eb4246"), com.xiaomi.onetrack.util.oaid.a.a().a(this.d.j));
            map.put(ijiami_1011.s.s.s.d(new byte[]{Ascii.DC2, 71, 94, 9, 92, 86, Ascii.NAK, 45, 2}, "b51c95"), this.b);
            map.put(ijiami_1011.s.s.s.d(new byte[]{16, Ascii.SYN, 85, SignedBytes.MAX_POWER_OF_TWO}, "ee02b6"), this.c);
            String strB = com.xiaomi.onetrack.g.b.b(string, map, false);
            if (!TextUtils.isEmpty(strB) && !"".equals(strB)) {
                this.d.b(strB);
                return;
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 100;
            Bundle bundle = new Bundle();
            bundle.putString(ijiami_1011.s.s.s.d(new byte[]{94, 90, 11, 71}, "63e31b"), ijiami_1011.s.s.s.d(new byte[]{-45, -121, -101, -42, -79, -72, -123, -37, -57, -124, -80, -54, -48, -112, -126, -37, -125, -111, -114, -40, -22, -118, -98, -46, -45, -105, -77, -43, -88, -111, -121, -4, -55, -123, -116, -12, -46, -113, -81, -44, -71, -101, -124, -58, -27, -124, -87, -54, -48, -92, -107, -42, -85, -100, -124, -30, -29, -123, -116, -12}, "543374"));
            messageObtain.setData(bundle);
            this.d.k.sendMessage(messageObtain);
        } catch (Exception e) {
            p.b(d.f9510a, e.getMessage());
        }
    }
}
