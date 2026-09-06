package com.adprof.sdk;

import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class tm implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ an f1444a;

    public tm(an anVar) {
        this.f1444a = anVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        zl zlVar;
        boolean z;
        if (view.getTag() != null) {
            if (view.getTag().equals("sound_on")) {
                ((qm) this.f1444a).f686b.setImageResource(R.drawable.adprof_sound_off);
                ((qm) this.f1444a).f686b.setTag("sound_off");
                zlVar = this.f1444a.f31a;
                if (zlVar == null) {
                    return;
                } else {
                    z = true;
                }
            } else {
                ((qm) this.f1444a).f686b.setImageResource(R.drawable.adprof_sound_on);
                ((qm) this.f1444a).f686b.setTag("sound_on");
                zlVar = this.f1444a.f31a;
                if (zlVar == null) {
                    return;
                } else {
                    z = false;
                }
            }
            zlVar.setVideoMute(z);
        }
    }
}
