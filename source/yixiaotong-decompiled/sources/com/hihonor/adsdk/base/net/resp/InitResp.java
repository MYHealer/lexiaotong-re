package com.hihonor.adsdk.base.net.resp;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class InitResp {
    public List<AdUnitInfo> adUnitInfos;
    public Media media;
    public List<ThirdPlatform> thirdPlatforms;

    public static class Media {
        public String appIdWx;
        public int dpMethod;
        public int enable;
        public int enableAdCopy;
        public int enableRetrofitSubCallback;
        public int expire;
        public int httpDns;
        public String mediaId;
        public String mediaName;
        public int mediaSrc;
    }
}
