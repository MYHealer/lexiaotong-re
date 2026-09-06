package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class kk implements xj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ lk f1269a;

    public kk(lk lkVar) {
        this.f1269a = lkVar;
    }

    public void a() {
        String str = ((q5) this.f1269a).f663a;
        if (str != null) {
            s5.a(str, "action.reward.video.get");
        } else {
            pk.e("Tried to broadcast a video event without a broadcast identifier to send to.");
        }
        if (this.f1269a.a() != null) {
            this.f1269a.a().a(this.f1269a.f1290a, "reward_get_succ");
        }
    }
}
