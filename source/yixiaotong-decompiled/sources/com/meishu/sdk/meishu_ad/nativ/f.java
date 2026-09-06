package com.meishu.sdk.meishu_ad.nativ;

import com.meishu.sdk.core.ad.BaseAdSlot;

/* JADX INFO: compiled from: NativeAdSlot.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class f extends BaseAdSlot {
    public long C;
    public long D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5047a;
    public int b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public long i;
    public String[] j;
    public String[] k;
    public String[] l;
    public String[] m;
    public String[] n;
    public String[] o;
    public String[] p;
    public String[] q;
    public String[] r;
    public String[] s;
    public String[] t;
    public String[] u;
    public int v;
    public int x;
    public long y;
    public int w = 1;
    public boolean z = true;
    public boolean A = true;
    public boolean B = false;

    /* JADX INFO: compiled from: NativeAdSlot.java */
    public class a extends BaseAdSlot.Builder<a, f> {
        public a() {
            super();
        }

        @Override // com.meishu.sdk.core.ad.BaseAdSlot.Builder
        public BaseAdSlot build() {
            return f.this;
        }

        @Override // com.meishu.sdk.core.ad.BaseAdSlot.Builder
        public BaseAdSlot.Builder returnThis() {
            return this;
        }

        @Override // com.meishu.sdk.core.ad.BaseAdSlot.Builder
        public BaseAdSlot.Builder setAppName(String str) {
            f.this.appName = str;
            return this;
        }

        @Override // com.meishu.sdk.core.ad.BaseAdSlot.Builder
        public BaseAdSlot.Builder setDesc(String str) {
            f.this.desc = str;
            return this;
        }

        @Override // com.meishu.sdk.core.ad.BaseAdSlot.Builder
        public BaseAdSlot.Builder setIconUrl(String str) {
            f.this.iconUrl = str;
            return this;
        }

        @Override // com.meishu.sdk.core.ad.BaseAdSlot.Builder
        public BaseAdSlot.Builder setTitle(String str) {
            f.this.title = str;
            return this;
        }
    }

    @Override // com.meishu.sdk.core.ad.BaseAdSlot
    public String getDesc() {
        return this.desc;
    }

    @Override // com.meishu.sdk.core.ad.BaseAdSlot
    public String getIconUrl() {
        return this.iconUrl;
    }

    @Override // com.meishu.sdk.core.ad.BaseAdSlot
    public String getTitle() {
        return this.title;
    }

    @Override // com.meishu.sdk.core.ad.BaseAdSlot
    public void setAdPatternType(int i) {
        this.adPatternType = i;
    }
}
