package com.miui.zeus.mimo.sdk;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.xiaomi.onetrack.Configuration;
import com.xiaomi.onetrack.OneTrack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class h6 {
    public static volatile h6 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OneTrack f5452a;
    public String b = "";

    public h6() {
        OneTrack.setDebugMode(false);
        OneTrack.setAccessNetworkEnable(y8.a(), true);
        OneTrack oneTrackCreateInstance = OneTrack.createInstance(y8.a(), new Configuration.Builder().setExceptionCatcherEnable(true).setMode(OneTrack.Mode.SDK).setChannel(ijiami_1011.s.s.s.d(new byte[]{83, 87}, "098711")).setAutoTrackActivityAction(false).setAppId(ijiami_1011.s.s.s.d(new byte[]{85, 85, 81, 5, 8, 86, 81, 85, 80, 91, 3}, "fda58b")).setAdEventAppId(ijiami_1011.s.s.s.d(new byte[]{85, 80, 84, 5, 6, 83, 81, 84, 94, 91, 2}, "fad56c")).build());
        this.f5452a = oneTrackCreateInstance;
        oneTrackCreateInstance.setCustomPrivacyPolicyAccepted(true);
        m.d(ijiami_1011.s.s.s.d(new byte[]{127, 12, 3, 99, 67, 2, 2, 15, 3, 16}, "0bf71c"), ijiami_1011.s.s.s.d(new byte[]{113, 15, 12, 16, 67, 11, 15, 1, 50, 16, 80, 6, 83, 4, Ascii.ETB, 68, 16, 17, 2, 7, 3, 17, 66, 73, Ascii.CAN, 5, 0, 6, Ascii.SYN, 3, 44, 11, 2, 7, 17, 88, Ascii.CAN, 80, 84, 85, 82}, "8aedcd"));
    }

    public static h6 a() {
        if (c == null) {
            synchronized (h6.class) {
                if (c == null) {
                    c = new h6();
                }
            }
        }
        return c;
    }

    public final void a(Map map, String str, m6 m6Var) {
        if (TextUtils.isEmpty(str) || m6Var == null) {
            return;
        }
        HashMap map2 = new HashMap();
        map2.put(ijiami_1011.s.s.s.d(new byte[]{19, 92, 93, SignedBytes.MAX_POWER_OF_TWO, 81}, "d59495"), Integer.valueOf(m6Var.f5530a));
        map2.put(ijiami_1011.s.s.s.d(new byte[]{80, 83, 88, 5, 12, 70}, "861bd2"), Integer.valueOf(m6Var.b));
        map2.put(ijiami_1011.s.s.s.d(new byte[]{Ascii.EM}, "a10950"), Integer.valueOf(m6Var.c));
        map2.put(ijiami_1011.s.s.s.d(new byte[]{Ascii.US}, "fbf07c"), Integer.valueOf(m6Var.d));
        map2.put(ijiami_1011.s.s.s.d(new byte[]{70, 8, 81, SignedBytes.MAX_POWER_OF_TWO, 5, 0, 13, 1, 39, 16, 84, 4}, "0a47db"), m6Var.e);
        map2.put(ijiami_1011.s.s.s.d(new byte[]{66, 67, 7, 8, 67, 68, 0, Ascii.SYN, 3, 12, 82, Ascii.FS}, "61ff04"), m6Var.f);
        map.put(str, map2);
    }

    public final void a(Map map, String str, List<m6> list) {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (m6 m6Var : list) {
            if (m6Var != null) {
                HashMap map2 = new HashMap();
                map2.put(ijiami_1011.s.s.s.d(new byte[]{78, 90, 86, Ascii.NAK, 89}, "932a1e"), Integer.valueOf(m6Var.f5530a));
                map2.put(ijiami_1011.s.s.s.d(new byte[]{11, 82, 8, 87, 95, 77}, "c7a079"), Integer.valueOf(m6Var.b));
                map2.put(ijiami_1011.s.s.s.d(new byte[]{Ascii.EM}, "a3cb71"), Integer.valueOf(m6Var.c));
                map2.put(ijiami_1011.s.s.s.d(new byte[]{75}, "219f91"), Integer.valueOf(m6Var.d));
                map2.put(ijiami_1011.s.s.s.d(new byte[]{Ascii.DC2, 90, 3, 65, 89, 6, 13, 1, 39, 16, 84, 4}, "d3f68d"), m6Var.e);
                map2.put(ijiami_1011.s.s.s.d(new byte[]{69, 74, 85, 8, 16, 65, 0, Ascii.SYN, 3, 12, 82, Ascii.FS}, "184fc1"), m6Var.f);
                arrayList.add(map2);
            }
        }
        map.put(str, arrayList);
    }
}
