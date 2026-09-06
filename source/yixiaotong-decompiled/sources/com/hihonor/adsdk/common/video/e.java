package com.hihonor.adsdk.common.video;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface e {
    public static final int hnadsa = 30052;
    public static final int hnadsb = 30053;
    public static final int hnadsc = 30054;
    public static final int hnadsd = 0;
    public static final int hnadse = 1;
    public static final int hnadsf = 2;

    public static class a {
        public static String hnadsa(int i) {
            if (i != 30053) {
                return i != 30054 ? "Unknown error, type is " + i : "set data url error";
            }
            return "Url is empty or Url is not mp4";
        }
    }
}
