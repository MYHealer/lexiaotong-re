package com.huawei.openalliance.ad.beans.inner;

import com.huawei.openalliance.ad.annotations.d;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class SourceParam {
    private boolean checkDigest;
    private boolean cleanDisk;

    @d
    private AdContentData contentRecord;
    private long limit;

    @d
    private String loadFailReason;
    private String sha256;
    private int sptImgFormat;
    private String subDir;
    private String url;
    private boolean useDiskCache;

    public SourceParam() {
        this.limit = com.hihonor.adsdk.common.video.g.a.hnadsb;
        this.sptImgFormat = 1;
        this.checkDigest = false;
        this.useDiskCache = false;
        this.cleanDisk = false;
    }

    public SourceParam(String str, int i, String str2) {
        this.sptImgFormat = 1;
        this.checkDigest = false;
        this.useDiskCache = false;
        this.cleanDisk = false;
        this.url = str;
        this.limit = ((long) i) * 1024;
        this.sha256 = str2;
    }

    public String B() {
        return this.url;
    }

    public boolean C() {
        return this.checkDigest;
    }

    public void Code(int i) {
        this.limit = ((long) i) * 1024;
    }

    public void Code(long j) {
        this.limit = j;
    }

    public void Code(AdContentData adContentData) {
        this.contentRecord = adContentData;
    }

    public void Code(String str) {
        this.subDir = str;
    }

    public void Code(boolean z) {
        this.cleanDisk = z;
    }

    public boolean Code() {
        return this.cleanDisk;
    }

    public String D() {
        return this.loadFailReason;
    }

    public AdContentData F() {
        return this.contentRecord;
    }

    public String I() {
        return this.sha256;
    }

    public void I(String str) {
        this.url = str;
    }

    public void I(boolean z) {
        this.useDiskCache = z;
    }

    public int L() {
        return this.sptImgFormat;
    }

    public boolean S() {
        return this.useDiskCache;
    }

    public String V() {
        return this.subDir;
    }

    public void V(int i) {
        this.sptImgFormat = i;
    }

    public void V(String str) {
        this.sha256 = str;
    }

    public void V(boolean z) {
        this.checkDigest = z;
    }

    public long Z() {
        return this.limit;
    }

    public void Z(String str) {
        this.loadFailReason = str;
    }
}
