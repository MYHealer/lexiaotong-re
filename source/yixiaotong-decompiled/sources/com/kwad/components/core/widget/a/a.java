package com.kwad.components.core.widget.a;

import android.os.Message;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.kwad.sdk.utils.ar;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import com.kwad.sdk.utils.cb;
import com.kwad.sdk.utils.cc;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class a implements com.kwad.sdk.core.j.a, cc.a {
    private Set<com.kwad.sdk.core.j.c> awB;
    private final int awC;
    private final View mRootView;
    private final AtomicBoolean awA = new AtomicBoolean(false);
    protected final cc ca = new cc(this);

    public abstract boolean ah();

    public a(View view, int i) {
        this.mRootView = view;
        this.awC = i;
    }

    public void a(Message message) {
        if (message.what == 666) {
            zZ();
            this.ca.sendEmptyMessageDelayed(TTAdConstant.STYLE_SIZE_RADIO_2_3, 500L);
        }
    }

    public final void zZ() {
        if (ah()) {
            ku();
        } else {
            Ad();
        }
    }

    public final void Aa() {
        this.ca.removeMessages(TTAdConstant.STYLE_SIZE_RADIO_2_3);
        this.ca.sendEmptyMessage(TTAdConstant.STYLE_SIZE_RADIO_2_3);
    }

    public final void Ab() {
        zZ();
        this.ca.removeCallbacksAndMessages(null);
    }

    public final boolean Ac() {
        return cb.a(this.mRootView, this.awC, false);
    }

    private void ku() {
        if (this.awA.getAndSet(true)) {
            return;
        }
        br(true);
    }

    private void Ad() {
        if (this.awA.getAndSet(false)) {
            br(false);
        }
    }

    private void br(boolean z) {
        Set<com.kwad.sdk.core.j.c> set = this.awB;
        if (set == null) {
            return;
        }
        for (com.kwad.sdk.core.j.c cVar : set) {
            if (cVar != null) {
                if (z) {
                    cVar.bz();
                } else {
                    cVar.bA();
                }
            }
        }
    }

    @Override // com.kwad.sdk.core.j.a
    public final boolean Ae() {
        return this.awA.get();
    }

    @Override // com.kwad.sdk.core.j.a
    public final void a(final com.kwad.sdk.core.j.c cVar) {
        ar.checkUiThread();
        if (cVar == null) {
            return;
        }
        by.postOnUiThread(new bi() { // from class: com.kwad.components.core.widget.a.a.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                if (a.this.ah()) {
                    cVar.bz();
                } else {
                    cVar.bA();
                }
            }
        });
        if (this.awB == null) {
            this.awB = new HashSet();
        }
        this.awB.add(cVar);
    }

    @Override // com.kwad.sdk.core.j.a
    public final void b(com.kwad.sdk.core.j.c cVar) {
        Set<com.kwad.sdk.core.j.c> set;
        ar.checkUiThread();
        if (cVar == null || (set = this.awB) == null) {
            return;
        }
        set.remove(cVar);
    }

    @Override // com.kwad.sdk.core.j.a
    public void release() {
        Ab();
        Set<com.kwad.sdk.core.j.c> set = this.awB;
        if (set != null) {
            set.clear();
        }
    }
}
