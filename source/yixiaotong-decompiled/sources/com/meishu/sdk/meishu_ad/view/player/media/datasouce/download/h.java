package com.meishu.sdk.meishu_ad.view.player.media.datasouce.download;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: VideoDownloadHelper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, b> f5149a = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: VideoDownloadHelper.java */
    public static class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f5150a;

        public a(String str) {
            this.f5150a = str;
        }

        @Override // com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.f
        public void a() {
            try {
                h.f5149a.remove(this.f5150a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.f
        public void a(long j) {
        }

        @Override // com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.f
        public void a(long j, int i) {
        }

        @Override // com.meishu.sdk.meishu_ad.view.player.media.datasouce.download.f
        public void b() {
            try {
                h.f5149a.remove(this.f5150a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
