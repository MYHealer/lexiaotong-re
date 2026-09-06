package com.hihonor.adsdk.base.mediation.comm.pi;

import com.hihonor.adsdk.base.mediation.comm.c.a;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface LADI extends a, IBidding {
    int getECPM();

    String getECPMLevel();

    Map<String, Object> getExtraInfo();

    boolean isValid();
}
