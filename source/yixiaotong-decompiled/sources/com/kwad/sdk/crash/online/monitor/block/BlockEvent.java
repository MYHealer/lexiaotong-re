package com.kwad.sdk.crash.online.monitor.block;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BlockEvent extends com.kwad.sdk.core.response.a.a {
    public long blockTimeThreshold;
    public long blockDuration = 0;
    public long blockLoopInterval = 100;
    public long calcBlockOverhead = 0;
    public String currentActivity = "";
    public String processName = "";
    public List<a> stackTraceSample = new ArrayList();

    public static class a extends com.kwad.sdk.core.response.a.a {
        public long beX;
        public boolean beY = false;
        public String beZ;
        public long bfa;
        public int repeatCount;
    }
}
