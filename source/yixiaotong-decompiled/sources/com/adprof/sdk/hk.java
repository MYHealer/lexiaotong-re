package com.adprof.sdk;

import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class hk extends fn.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fo f1214a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ik f363a;

    public hk(ik ikVar, fo foVar) {
        this.f363a = ikVar;
        this.f1214a = foVar;
    }

    @Override // com.adprof.sdk.fn.a
    public void callback(Exception exc) {
        int duration;
        int i;
        y0 y0Var;
        z5 z5Var;
        pk.c("video player state change " + this.f1214a);
        int iOrdinal = this.f1214a.ordinal();
        if (iOrdinal == 2) {
            z5 z5Var2 = ((yj) this.f363a.f1234a).f866a;
            if (z5Var2 != null) {
                z5Var2.c();
                return;
            }
            return;
        }
        if (iOrdinal == 3) {
            z5 z5Var3 = ((yj) this.f363a.f1234a).f866a;
            if (z5Var3 != null) {
                z5Var3.d();
                return;
            }
            return;
        }
        if (iOrdinal != 6) {
            if (iOrdinal == 7) {
                ik.a(this.f363a, false);
                ik.b(this.f363a, false);
                ik.c(this.f363a, false);
                jk jkVar = this.f363a.f1234a;
                int i2 = jk.f;
                if (jkVar.getSessionManager() != null) {
                    this.f363a.f1234a.getSessionManager().a(((x0) this.f363a.f1234a).f821a, "video_play_start");
                    return;
                }
                return;
            }
            if (iOrdinal == 9) {
                jk jkVar2 = this.f363a.f1234a;
                int i3 = jk.f;
                if (jkVar2.getSessionManager() != null) {
                    this.f363a.f1234a.getSessionManager().a(((x0) this.f363a.f1234a).f821a, "video_play_end");
                }
                s5.a(((x0) this.f363a.f1234a).f821a.k(), "action.reward.video.complete");
                return;
            }
            if (iOrdinal == 11 && (z5Var = ((yj) this.f363a.f1234a).f866a) != null) {
                int errorCode = z5Var.getErrorCode();
                String errorMessage = ((yj) this.f363a.f1234a).f866a.getErrorMessage();
                HashMap map = new HashMap();
                map.put("error", errorCode + com.huawei.openalliance.ad.constant.x.bQ + errorMessage);
                s5.a(((x0) this.f363a.f1234a).f821a.k(), map, "action.reward.video.play.fail", 0);
                return;
            }
            return;
        }
        jk jkVar3 = this.f363a.f1234a;
        z5 z5Var4 = ((yj) jkVar3).f866a;
        if (z5Var4 != null) {
            z5Var4.getDuration();
            int i4 = jk.f;
            jkVar3.getClass();
        }
        if (!this.f363a.f1234a.m731a()) {
            jk jkVar4 = this.f363a.f1234a;
            l8 l8Var = ((yj) jkVar4).f864a;
            if (l8Var != null) {
                l8Var.a();
                ((yj) jkVar4).f864a.b();
            }
            z5 z5Var5 = ((yj) jkVar4).f866a;
            if (z5Var5 != null) {
                q0 q0Var = ((x0) jkVar4).f821a.f188a;
                o1 o1Var = q0Var.f639a;
                if (o1Var == null || (i = o1Var.b) == -1) {
                    e2 e2Var = q0Var.f637a;
                    i = (e2Var == null || (y0Var = e2Var.f230a) == null) ? 0 : y0Var.e;
                }
                duration = i * 1000;
                if (duration <= 0 || duration > z5Var5.getDuration()) {
                    duration = (int) (((yj) jkVar4).f866a.getDuration() * 0.8d);
                }
                pk.a(" \n\n -----  reward time left = " + duration + "   video_duration = " + ((yj) jkVar4).f866a.getDuration() + "  \n\n");
            } else {
                duration = 0;
            }
            if (duration <= 5000) {
                duration = 5000;
            }
            ((yj) jkVar4).f867a = false;
            l8 l8Var2 = new l8(duration, 500L);
            ((yj) jkVar4).f864a = l8Var2;
            l8Var2.f439a = new tj(jkVar4);
            l8Var2.c();
            ((yj) jkVar4).f864a.f();
        }
        s5.a(((x0) this.f363a.f1234a).f821a.k(), "action.reward.video.play");
        d dVar = ((x0) this.f363a.f1234a).f821a;
        dVar.f185a.a(dVar, "player_valid");
    }
}
