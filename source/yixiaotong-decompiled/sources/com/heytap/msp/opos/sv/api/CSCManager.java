package com.heytap.msp.opos.sv.api;

import android.content.Context;
import com.heytap.msp.opos.sv.a.a;
import com.heytap.msp.opos.sv.a.b;
import com.heytap.msp.opos.sv.interapi.bean.csc.reorder.ReorderRequest;
import com.heytap.msp.opos.sv.interapi.bean.csc.reorder.ReorderResult;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class CSCManager implements b {
    private static volatile CSCManager sInstance;
    private final b mICSCManager = new a();

    private CSCManager() {
    }

    public static CSCManager getInstance() {
        if (sInstance == null) {
            synchronized (CSCManager.class) {
                if (sInstance == null) {
                    sInstance = new CSCManager();
                }
            }
        }
        return sInstance;
    }

    @Override // com.heytap.msp.opos.sv.a.b
    public ReorderResult reorder(Context context, ReorderRequest reorderRequest) {
        return this.mICSCManager.reorder(context, reorderRequest);
    }
}
