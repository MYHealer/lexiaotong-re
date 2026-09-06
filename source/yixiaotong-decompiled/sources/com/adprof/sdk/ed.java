package com.adprof.sdk;

import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ed extends fn.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fd f1147a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ fo f244a;

    public ed(fd fdVar, fo foVar) {
        this.f1147a = fdVar;
        this.f244a = foVar;
    }

    @Override // com.adprof.sdk.fn.a
    public void callback(Exception exc) {
        z5 z5Var;
        pk.c("video player state change " + this.f244a);
        int iOrdinal = this.f244a.ordinal();
        if (iOrdinal == 2) {
            z5 z5Var2 = ((vc) this.f1147a.f1169a).f772a;
            if (z5Var2 != null) {
                z5Var2.c();
                return;
            }
            return;
        }
        if (iOrdinal == 3) {
            z5 z5Var3 = ((vc) this.f1147a.f1169a).f772a;
            if (z5Var3 != null) {
                z5Var3.d();
                return;
            }
            return;
        }
        if (iOrdinal == 6) {
            hd hdVar = this.f1147a.f1169a;
            z5 z5Var4 = ((vc) hdVar).f772a;
            if (z5Var4 != null) {
                z5Var4.getDuration();
                int i = hd.d;
                hdVar.getClass();
            }
            this.f1147a.f1169a.e();
            s5.a(((x0) this.f1147a.f1169a).f821a.k(), "action.reward.video.play");
            d dVar = ((x0) this.f1147a.f1169a).f821a;
            dVar.f185a.a(dVar, "player_valid");
            return;
        }
        if (iOrdinal == 7) {
            fd.c(this.f1147a, false);
            fd.a(this.f1147a, false);
            fd.b(this.f1147a, false);
            hd hdVar2 = this.f1147a.f1169a;
            int i2 = hd.d;
            if (hdVar2.getSessionManager() != null) {
                this.f1147a.f1169a.getSessionManager().a(((x0) this.f1147a.f1169a).f821a, "video_play_start");
                return;
            }
            return;
        }
        if (iOrdinal == 9) {
            hd hdVar3 = this.f1147a.f1169a;
            int i3 = hd.d;
            if (hdVar3.getSessionManager() != null) {
                this.f1147a.f1169a.getSessionManager().a(((x0) this.f1147a.f1169a).f821a, "video_play_end");
            }
            s5.a(((x0) this.f1147a.f1169a).f821a.k(), "action.reward.video.complete");
            return;
        }
        if (iOrdinal == 11 && (z5Var = ((vc) this.f1147a.f1169a).f772a) != null) {
            int errorCode = z5Var.getErrorCode();
            String errorMessage = ((vc) this.f1147a.f1169a).f772a.getErrorMessage();
            HashMap map = new HashMap();
            map.put("error", errorCode + com.huawei.openalliance.ad.constant.x.bQ + errorMessage);
            s5.a(((x0) this.f1147a.f1169a).f821a.k(), map, "action.reward.video.play.fail", 0);
        }
    }
}
