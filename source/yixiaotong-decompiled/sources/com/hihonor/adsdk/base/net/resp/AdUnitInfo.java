package com.hihonor.adsdk.base.net.resp;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class AdUnitInfo {
    public String adUnitId;
    public int sameShow;
    public List<ThirdAdUnitInfo> thirdAdUnitInfos;
    public int timeout;

    public static class ThirdAdUnitInfo {
        public String adUnitType;
        public int level;
        public int renderType;
        public String thirdAdUnitId;
        public String thirdPlatformId;
    }
}
