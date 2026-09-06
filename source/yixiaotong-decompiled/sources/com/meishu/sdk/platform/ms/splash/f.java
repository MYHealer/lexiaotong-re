package com.meishu.sdk.platform.ms.splash;

import com.meishu.sdk.core.safe.l;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: ShakeUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class f extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShakeUtil f5244a;

    /* JADX INFO: compiled from: ShakeUtil.java */
    public class a implements Comparator<c> {
        public a(f fVar) {
        }

        @Override // java.util.Comparator
        public int compare(c cVar, c cVar2) {
            return cVar2.c - cVar.c;
        }
    }

    public f(ShakeUtil shakeUtil) {
        this.f5244a = shakeUtil;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        List<c> list = this.f5244a.g;
        if (list == null || list.size() <= 0) {
            this.f5244a.a();
            return;
        }
        Collections.sort(this.f5244a.g, new a(this));
        for (int i = 0; i < this.f5244a.g.size(); i++) {
            c cVar = this.f5244a.g.get(i);
            if (cVar != null && cVar.g) {
                cVar.h = 1;
                this.f5244a.d = true;
            } else if (cVar != null) {
                cVar.h = 2;
            }
        }
    }
}
