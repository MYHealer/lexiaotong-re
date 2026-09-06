package com.ubix.ssp.open;

import android.text.TextUtils;
import android.util.Log;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UBiXAdPrivacyManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9048a;
    private int b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private String k;
    private String l;
    private Location m;
    private String n;
    private String o;
    private List<String> p;
    private int q;

    /* JADX INFO: renamed from: com.ubix.ssp.open.UBiXAdPrivacyManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private List<String> p;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f9049a = 0;
        private int b = 0;
        private boolean c = true;
        private boolean d = true;
        private boolean e = true;
        private boolean f = true;
        private boolean g = true;
        private boolean h = true;
        private boolean i = true;
        private boolean j = true;
        private String k = "";
        private String l = "";
        private Location m = new Location(0.0d, 0.0d);
        private String n = "";
        private String o = "";
        private int q = -1;

        public UBiXAdPrivacyManager build() {
            UBiXAdPrivacyManager uBiXAdPrivacyManager = new UBiXAdPrivacyManager(null);
            uBiXAdPrivacyManager.h = this.g;
            uBiXAdPrivacyManager.b = this.f9049a;
            uBiXAdPrivacyManager.f9048a = this.b;
            uBiXAdPrivacyManager.c = this.c;
            uBiXAdPrivacyManager.d = this.d;
            uBiXAdPrivacyManager.g = this.e;
            uBiXAdPrivacyManager.f = this.f;
            uBiXAdPrivacyManager.e = this.h;
            uBiXAdPrivacyManager.i = this.i;
            uBiXAdPrivacyManager.j = this.j;
            uBiXAdPrivacyManager.k = this.k;
            uBiXAdPrivacyManager.l = this.l;
            uBiXAdPrivacyManager.n = this.n;
            uBiXAdPrivacyManager.o = this.o;
            uBiXAdPrivacyManager.p = this.p;
            uBiXAdPrivacyManager.m = this.m;
            uBiXAdPrivacyManager.q = this.q;
            return uBiXAdPrivacyManager;
        }

        public Builder setAndroidId(String str) {
            this.n = str;
            return this;
        }

        public Builder setAppList(List<String> list) {
            this.p = list;
            return this;
        }

        public Builder setCanGetAppList(boolean z) {
            this.e = z;
            return this;
        }

        public Builder setCanUseAndroidId(boolean z) {
            this.g = z;
            return this;
        }

        public Builder setCanUseLocation(boolean z) {
            this.c = z;
            return this;
        }

        public Builder setCanUseMacAddress(boolean z) {
            this.f = z;
            return this;
        }

        public Builder setCanUseOaid(boolean z) {
            this.i = z;
            return this;
        }

        public Builder setCanUsePhoneState(boolean z) {
            this.j = z;
            return this;
        }

        public Builder setCanUseWifiState(boolean z) {
            this.d = z;
            return this;
        }

        public Builder setCanUseWriteExternal(boolean z) {
            this.h = z;
            return this;
        }

        public Builder setDevImei(String str) {
            this.l = str;
            return this;
        }

        public Builder setDevOaid(String str) {
            this.k = str;
            this.q = 1;
            return this;
        }

        public Builder setLocation(double d, double d2) {
            this.m = new Location(d, d2);
            return this;
        }

        public Builder setMacAddress(String str) {
            this.o = str;
            return this;
        }

        public Builder setPersonalizedState(int i) {
            this.f9049a = i != 0 ? 1 : 0;
            return this;
        }

        public Builder setProgrammaticRecommendState(boolean z) {
            this.b = z ? 0 : 1;
            return this;
        }
    }

    public static class Location {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private double f9050a;
        private double b;

        public Location(double d, double d2) {
            this.f9050a = d;
            this.b = d2;
        }

        public double getLatitude() {
            return this.b;
        }

        public double getLongitude() {
            return this.f9050a;
        }
    }

    private UBiXAdPrivacyManager() {
        this.f9048a = 0;
        this.b = 0;
        this.c = true;
        this.d = true;
        this.e = true;
        this.f = true;
        this.g = true;
        this.h = true;
        this.i = true;
        this.j = true;
        this.k = "";
        this.l = "";
        this.m = new Location(0.0d, 0.0d);
        this.n = "";
        this.o = "";
        this.q = -1;
    }

    /* synthetic */ UBiXAdPrivacyManager(AnonymousClass1 anonymousClass1) {
        this();
    }

    public String getAndroidId() {
        return this.n;
    }

    public List<String> getAppList() {
        return this.p;
    }

    public String getImei() {
        return this.l;
    }

    public double[] getLocation() {
        Location location = this.m;
        return location != null ? new double[]{location.f9050a, this.m.b} : new double[]{0.0d, 0.0d};
    }

    public String getMacAddr() {
        return this.o;
    }

    public String getOaid() {
        if (this.q != 0) {
            this.q = 0;
            Log.w("UBiXWarn", !TextUtils.isEmpty(this.k) ? "不允许获取OAID，请保持传入OAID的正确性" : "本次初始化未获取到OAID，将严重影响变现效果。建议允许自主获取OAID");
        }
        return this.k;
    }

    public int getPersonalizedState() {
        return this.b;
    }

    public int getProgrammaticRecommendState() {
        return this.f9048a;
    }

    public boolean isCanGetAppList() {
        return this.g;
    }

    public boolean isCanUseAndroidId() {
        return this.h;
    }

    public boolean isCanUseLocation() {
        return this.c;
    }

    public boolean isCanUseMacAddress() {
        return this.f;
    }

    public boolean isCanUseOaid() {
        return this.i;
    }

    public boolean isCanUsePhoneState() {
        return this.j;
    }

    public boolean isCanUseWifiStatus() {
        return this.d;
    }

    public boolean isCanUseWriteExternal() {
        return this.e;
    }

    public boolean isTrustOaid() {
        return this.q != 1;
    }
}
