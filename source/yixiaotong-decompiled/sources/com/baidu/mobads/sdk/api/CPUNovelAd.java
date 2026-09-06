package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.View;
import com.baidu.mobads.sdk.internal.cz;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class CPUNovelAd {
    private cz mCpuNovelProd;

    public interface CpuNovelListener {
        void onAdClick();

        void onAdImpression();

        void onReadTime(long j);
    }

    public CPUNovelAd(Context context, String str, CPUWebAdRequestParam cPUWebAdRequestParam, CpuNovelListener cpuNovelListener) {
        cz czVar = new cz(context, str, cPUWebAdRequestParam);
        this.mCpuNovelProd = czVar;
        czVar.a(cpuNovelListener);
        this.mCpuNovelProd.a();
    }

    public View getNovelView() {
        return this.mCpuNovelProd.w();
    }

    public void destory() {
        cz czVar = this.mCpuNovelProd;
        if (czVar != null) {
            czVar.y();
        }
    }
}
