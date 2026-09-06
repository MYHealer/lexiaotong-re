package com.heytap.msp.opos.sv.api;

import android.content.Context;
import com.heytap.msp.opos.sv.a.c;
import com.heytap.msp.opos.sv.a.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class MSPSvSDK implements c {
    private static volatile MSPSvSDK sInstance;
    private final c mIMSPSvSDK = new d();

    private MSPSvSDK() {
    }

    public static MSPSvSDK getInstance() {
        if (sInstance == null) {
            synchronized (MSPSvSDK.class) {
                if (sInstance == null) {
                    sInstance = new MSPSvSDK();
                }
            }
        }
        return sInstance;
    }

    @Override // com.heytap.msp.opos.sv.a.c
    public void enableLog() {
        this.mIMSPSvSDK.enableLog();
    }

    @Override // com.heytap.msp.opos.sv.a.c
    public int getSDKVerCode() {
        return this.mIMSPSvSDK.getSDKVerCode();
    }

    @Override // com.heytap.msp.opos.sv.a.c
    public String getSDKVerName() {
        return this.mIMSPSvSDK.getSDKVerName();
    }

    @Override // com.heytap.msp.opos.sv.a.c
    public void init(Context context) {
        this.mIMSPSvSDK.init(context);
    }
}
