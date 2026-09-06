package com.meishu.sdk.platform.ms.paster;

import android.view.View;
import com.meishu.sdk.core.ad.BaseAdSlot;
import com.meishu.sdk.core.safe.o;
import com.meishu.sdk.meishu_ad.nativ.f;

/* JADX INFO: compiled from: MeishuPasterAdWrapper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.meishu.sdk.meishu_ad.nativ.b f5181a;
    public final /* synthetic */ d.a b;

    public c(d.a aVar, com.meishu.sdk.meishu_ad.nativ.b bVar) {
        this.b = aVar;
        this.f5181a = bVar;
    }

    @Override // com.meishu.sdk.core.safe.o
    public void safeOnClick(View view) {
        String default_coord;
        d dVar = d.this;
        if (dVar.d) {
            T t = dVar.f5177a;
            if (t != 0 && ((f) t).getCbc() == 0 && d.this.f.getInteractionListener() != null) {
                d.this.f.getInteractionListener().onAdClicked();
            }
            this.f5181a.setInteractionListener(d.this.f.getInteractionListener());
            this.f5181a.a().setClkActType(1);
            try {
                String[] clickUrl = this.f5181a.a().getClickUrl();
                long jCurrentTimeMillis = System.currentTimeMillis();
                int i = d.this.g;
                int i2 = -999;
                if (i == 0) {
                    i = -999;
                }
                String strValueOf = String.valueOf(i);
                int i3 = d.this.h;
                if (i3 == 0) {
                    i3 = -999;
                }
                String strValueOf2 = String.valueOf(i3);
                int i4 = d.this.i;
                if (i4 == 0) {
                    i4 = -999;
                }
                String strValueOf3 = String.valueOf(i4);
                int i5 = d.this.j;
                if (i5 != 0) {
                    i2 = i5;
                }
                String strValueOf4 = String.valueOf(i2);
                String strValueOf5 = String.valueOf(jCurrentTimeMillis / 1000);
                String strValueOf6 = String.valueOf(d.this.k);
                String strValueOf7 = String.valueOf(d.this.k);
                String strValueOf8 = String.valueOf(jCurrentTimeMillis);
                try {
                    f fVarA = this.f5181a.a();
                    if ((fVarA instanceof BaseAdSlot) && (default_coord = fVarA.getDefault_coord()) != null) {
                        if ("-999".equals(strValueOf)) {
                            strValueOf = default_coord;
                        }
                        if ("-999".equals(strValueOf2)) {
                            strValueOf2 = default_coord;
                        }
                        if ("-999".equals(strValueOf3)) {
                            strValueOf3 = default_coord;
                        }
                        if ("-999".equals(strValueOf4)) {
                            strValueOf4 = default_coord;
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                for (int i6 = 0; i6 < clickUrl.length; i6++) {
                    clickUrl[i6] = com.meishu.sdk.core.utils.f.a(clickUrl[i6], strValueOf, strValueOf2, strValueOf3, strValueOf4, strValueOf5, strValueOf6, strValueOf7, strValueOf8);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            com.meishu.sdk.core.utils.f.a((com.meishu.sdk.platform.ms.c) this.f5181a, true);
        }
    }
}
