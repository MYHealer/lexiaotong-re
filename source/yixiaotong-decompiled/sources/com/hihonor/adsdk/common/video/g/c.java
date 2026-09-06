package com.hihonor.adsdk.common.video.g;

import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c {
    public final File hnadsa;
    public final com.hihonor.adsdk.common.video.g.i.c hnadsb;
    public final com.hihonor.adsdk.common.video.g.i.a hnadsc;
    public final String hnadsd;

    public c(File file, com.hihonor.adsdk.common.video.g.i.c cVar, com.hihonor.adsdk.common.video.g.i.a aVar, String str) {
        this.hnadsa = file;
        this.hnadsb = cVar;
        this.hnadsc = aVar;
        this.hnadsd = str;
    }

    public File hnadsa(String str) {
        return new File(this.hnadsa, this.hnadsb.hnadsa(str));
    }
}
