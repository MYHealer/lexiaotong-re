package com.heytap.msp.mobad.api.listener;

import com.heytap.msp.mobad.api.params.INativeAdvanceData;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface INativeAdvanceLoadListener {
    void onAdFailed(int i, String str);

    void onAdSuccess(List<INativeAdvanceData> list);
}
