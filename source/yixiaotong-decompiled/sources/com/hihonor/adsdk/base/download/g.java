package com.hihonor.adsdk.base.download;

import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.bean.DetailPageCtrl;
import com.hihonor.adsdk.base.bean.TrackUrl;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3505a;
    private String b;
    private String c;
    private String d;
    private int e;
    private int f;
    private int g;
    private String h;
    private int hnadsb;
    private boolean hnadsc;
    private String hnadsg;
    private int hnadsh;
    private int hnadsi;
    private String hnadsj;
    private String hnadsk;
    private int hnadsl;
    private String hnadsm;
    private String hnadsn;
    private String hnadso;
    private int hnadsp;
    private String hnadsq;
    private String hnadsr;
    private String hnadss;
    private int hnadst;
    private int hnadsu;
    private List<String> hnadsv;
    private List<String> hnadsw;
    private List<String> hnadsx;
    private List<String> hnadsy;
    private List<String> hnadsz;
    private long i;
    private String j;
    private int k;
    private int l;
    private String m;
    private String n;
    private List<String> o;
    private int p;
    private DetailPageCtrl q;
    private String r;
    private String s;
    private final String hnadsa = "AdDIInfo";
    private final AtomicInteger hnadsd = new AtomicInteger();
    private final AtomicInteger hnadse = new AtomicInteger();
    private final AtomicInteger hnadsf = new AtomicInteger();

    public g() {
        hnadsn(-1);
    }

    public String a() {
        return this.hnadsk;
    }

    public String b() {
        return this.h;
    }

    public String c() {
        return this.hnadsr;
    }

    public int d() {
        return this.hnadsi;
    }

    public int e() {
        return this.hnadse.get();
    }

    public int f() {
        return this.p;
    }

    public String g() {
        return this.hnadsn;
    }

    public int h() {
        return this.hnadsb;
    }

    public String hnadsa() {
        return this.hnadsm;
    }

    public void hnadsa(int i) {
        this.hnadsh = i;
    }

    public void hnadsa(long j) {
        this.i = j;
    }

    public void hnadsa(BaseAd baseAd) {
        if (baseAd == null) {
            com.hihonor.adsdk.common.b.b.hnadsc("AdDIInfo", "setAdInfo ad is null", new Object[0]);
            return;
        }
        this.hnadsi = baseAd.getPkgType();
        this.hnadsh = baseAd.getAdType();
        this.hnadsj = baseAd.getAppPackage();
        this.hnadss = baseAd.getAppVersion();
        this.hnadsk = baseAd.getPackageUrl();
        this.hnadsl = baseAd.getSequence();
        this.hnadsm = baseAd.getAdId();
        this.hnadsn = baseAd.getRequestId();
        this.hnadso = baseAd.getAdUnitId();
        this.hnadsp = baseAd.getInstallPkgType();
        this.hnadsq = baseAd.getBrand();
        this.hnadsi = baseAd.getPkgType();
        this.hnadst = baseAd.getLandingPageType();
        this.hnadsu = baseAd.getNewLandingPageType();
        this.hnadsr = baseAd.getPkgSign();
        this.f3505a = baseAd.getStoreChannel();
        this.b = baseAd.getChannelInfo();
        this.c = baseAd.getExtraJson();
        this.d = baseAd.getSubChannel();
        this.f = baseAd.getDetailType();
        this.g = baseAd.getDownloadType();
        this.h = baseAd.getPartner();
        this.i = baseAd.getTs();
        this.j = baseAd.getSifSign();
        this.k = baseAd.getItemPosition();
        this.l = baseAd.getDataType();
        this.r = baseAd.getUnInstallFilter();
        this.s = baseAd.getTemplateId();
        TrackUrl trackUrl = baseAd.getTrackUrl();
        if (trackUrl != null) {
            this.hnadsv = trackUrl.getCommons();
            this.hnadsw = trackUrl.getDownloadStarts();
            this.hnadsx = trackUrl.getDownloadSuccess();
            this.hnadsy = trackUrl.getInstallSuccess();
            this.hnadsz = trackUrl.getClicks();
        }
        this.m = baseAd.getTitle();
        this.n = baseAd.getLogo();
        this.o = baseAd.getImages();
        this.p = baseAd.getPromotionPurpose();
        this.q = baseAd.getDetailPageCtrl();
    }

    public void hnadsa(String str) {
        this.hnadsm = str;
    }

    public void hnadsa(List<String> list) {
        this.hnadsz = list;
    }

    public void hnadsa(boolean z) {
        this.hnadsc = z;
    }

    public int hnadsb() {
        return this.hnadsh;
    }

    public void hnadsb(int i) {
        this.hnadsf.set(i);
    }

    public void hnadsb(String str) {
        this.hnadso = str;
    }

    public void hnadsb(List<String> list) {
        this.hnadsv = list;
    }

    public String hnadsc() {
        return this.hnadso;
    }

    public void hnadsc(int i) {
        this.f = i;
    }

    public void hnadsc(String str) {
        this.hnadsj = str;
    }

    public void hnadsc(List<String> list) {
        this.hnadsw = list;
    }

    public String hnadsd() {
        return this.hnadsj;
    }

    public void hnadsd(int i) {
        this.g = i;
    }

    public void hnadsd(String str) {
        this.hnadss = str;
    }

    public void hnadsd(List<String> list) {
        this.hnadsx = list;
    }

    public String hnadse() {
        return this.hnadss;
    }

    public void hnadse(int i) {
        this.hnadsp = i;
    }

    public void hnadse(String str) {
        this.hnadsq = str;
    }

    public void hnadse(List<String> list) {
        this.hnadsy = list;
    }

    public String hnadsf() {
        return this.hnadsq;
    }

    public void hnadsf(int i) {
        this.k = i;
    }

    public void hnadsf(String str) {
        this.b = str;
    }

    public String hnadsg() {
        return this.b;
    }

    public void hnadsg(int i) {
        this.hnadst = i;
    }

    public void hnadsg(String str) {
        this.c = str;
    }

    public void hnadsh(int i) {
        this.hnadsu = i;
    }

    public void hnadsh(String str) {
        this.hnadsg = str;
    }

    public int hnadsi() {
        return this.hnadsf.get();
    }

    public void hnadsi(int i) {
        this.e = i;
    }

    public void hnadsi(String str) {
        this.hnadsk = str;
    }

    public void hnadsj(int i) {
        this.hnadsi = i;
    }

    public void hnadsj(String str) {
        this.h = str;
    }

    public int hnadsk() {
        return this.l;
    }

    public void hnadsk(int i) {
        this.hnadse.set(i);
    }

    public void hnadsk(String str) {
        this.hnadsr = str;
    }

    public DetailPageCtrl hnadsl() {
        return this.q;
    }

    public void hnadsl(int i) {
        this.hnadsb = i;
    }

    public void hnadsl(String str) {
        this.hnadsn = str;
    }

    public int hnadsm() {
        return this.f;
    }

    public void hnadsm(int i) {
        this.hnadsl = i;
    }

    public void hnadsm(String str) {
        this.j = str;
    }

    public void hnadsn(int i) {
        this.hnadsd.set(i);
    }

    public void hnadsn(String str) {
        this.f3505a = str;
    }

    public void hnadso(String str) {
        this.d = str;
    }

    public int hnadsp() {
        return this.g;
    }

    public String hnadsq() {
        return this.c;
    }

    public List<String> hnadsr() {
        return this.o;
    }

    public int hnadss() {
        return this.hnadsp;
    }

    public int hnadsu() {
        return this.k;
    }

    public int hnadsv() {
        return this.hnadst;
    }

    public String hnadsw() {
        return this.n;
    }

    public String hnadsx() {
        return this.hnadsg;
    }

    public int hnadsy() {
        return this.hnadsu;
    }

    public int hnadsz() {
        return this.e;
    }

    public int i() {
        return this.hnadsl;
    }

    public String j() {
        return this.j;
    }

    public int k() {
        return this.hnadsd.get();
    }

    public String l() {
        return this.f3505a;
    }

    public String m() {
        return this.d;
    }

    public String n() {
        return this.s;
    }

    public String o() {
        return this.m;
    }

    public long p() {
        return this.i;
    }

    public String q() {
        return this.r;
    }

    public boolean r() {
        return this.hnadsc;
    }

    public List<String> hnadso() {
        List<String> list = this.hnadsx;
        return list == null ? new ArrayList() : list;
    }

    public List<String> hnadst() {
        List<String> list = this.hnadsy;
        return list == null ? new ArrayList() : list;
    }

    public List<String> hnadsj() {
        List<String> list = this.hnadsv;
        return list == null ? new ArrayList() : list;
    }

    public List<String> hnadsn() {
        List<String> list = this.hnadsw;
        return list == null ? new ArrayList() : list;
    }

    public List<String> hnadsh() {
        List<String> list = this.hnadsz;
        return list == null ? new ArrayList() : list;
    }
}
