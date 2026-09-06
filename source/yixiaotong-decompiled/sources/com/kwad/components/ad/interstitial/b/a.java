package com.kwad.components.ad.interstitial.b;

import androidx.room.RoomDatabase;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.l;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a {
    public static l mq = new l("interstitialAdSkipCloseType", 0);
    public static l mr = new l("interstitialAdSkipCloseArea", 0);

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static l f4751ms = new l("interstitialAdFullClick", 1);
    public static l mt = new l("interstitialAdBackPressSwitch", 0);
    public static l mu = new l("interstitialPlayableTime", Integer.valueOf(RoomDatabase.MAX_BIND_PARAMETER_CNT));
    public static l mv = new l("interstitialAdClickShutDown", 0);
    public static d mw = new d("interstitialAutoStartSwitch", false);
    public static l mx = new l("ecInterstitialAdOrderSwitch", 0);
    public static l my = new l("interstitialCycleAggregateMaxCount", 3);

    public static void init() {
    }
}
