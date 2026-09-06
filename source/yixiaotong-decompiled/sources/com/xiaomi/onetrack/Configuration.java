package com.xiaomi.onetrack;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class Configuration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9373a;
    private String b;
    private String c;
    private boolean d;
    private String e;
    private OneTrack.Mode f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private String m;
    private boolean n;
    private String o;
    private OneTrack.IEventHook p;

    /* JADX INFO: renamed from: com.xiaomi.onetrack.Configuration$1, reason: invalid class name */
    public /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f9374a;
        private String b;
        private String c;
        private boolean d;
        private String e;
        private String m;
        private String o;
        private OneTrack.Mode f = OneTrack.Mode.APP;
        private boolean g = true;
        private boolean h = true;
        private boolean i = true;
        private boolean j = false;
        private boolean k = true;
        private boolean l = false;
        private boolean n = false;

        public Configuration build() {
            return new Configuration(this, null);
        }

        public Builder setAdEventAppId(String str) {
            this.o = str;
            return this;
        }

        public Builder setAppId(String str) {
            this.f9374a = str;
            return this;
        }

        public Builder setAutoTrackActivityAction(boolean z) {
            this.k = z;
            return this;
        }

        public Builder setChannel(String str) {
            this.c = str;
            return this;
        }

        public Builder setExceptionCatcherEnable(boolean z) {
            this.j = z;
            return this;
        }

        @Deprecated
        public Builder setGAIDEnable(boolean z) {
            this.g = z;
            return this;
        }

        public Builder setImeiEnable(boolean z) {
            this.i = z;
            return this;
        }

        public Builder setImsiEnable(boolean z) {
            this.h = z;
            return this;
        }

        public Builder setInstanceId(String str) {
            this.m = str;
            return this;
        }

        public Builder setInternational(boolean z) {
            this.d = z;
            return this;
        }

        public Builder setMode(OneTrack.Mode mode) {
            this.f = mode;
            return this;
        }

        public Builder setOverrideMiuiRegionSetting(boolean z) {
            this.l = z;
            return this;
        }

        public Builder setPluginId(String str) {
            this.b = str;
            return this;
        }

        public Builder setRegion(String str) {
            this.e = str;
            return this;
        }

        public Builder setUseCustomPrivacyPolicy(boolean z) {
            this.n = z;
            return this;
        }
    }

    private Configuration(Builder builder) {
        this.f = OneTrack.Mode.APP;
        this.g = true;
        this.h = true;
        this.i = true;
        this.k = true;
        this.l = false;
        this.n = false;
        this.f9373a = builder.f9374a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
        this.g = builder.g;
        this.i = builder.i;
        this.h = builder.h;
        this.j = builder.j;
        this.k = builder.k;
        this.l = builder.l;
        this.m = builder.m;
        this.n = builder.n;
        this.o = builder.o;
    }

    public /* synthetic */ Configuration(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private String a(String str) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str) || str.length() <= 4) {
            sb.append(str);
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (i == 0 || i == 1 || i == str.length() - 2 || i == str.length() - 1) {
                    sb.append(str.charAt(i));
                } else {
                    sb.append(s.d(new byte[]{Ascii.EM}, "388d02"));
                }
            }
        }
        return sb.toString();
    }

    public String getAdEventAppId() {
        return this.o;
    }

    public String getAppId() {
        return this.f9373a;
    }

    public String getChannel() {
        return this.c;
    }

    public String getInstanceId() {
        return this.m;
    }

    public OneTrack.Mode getMode() {
        return this.f;
    }

    public String getPluginId() {
        return this.b;
    }

    public String getRegion() {
        return this.e;
    }

    public boolean isAutoTrackActivityAction() {
        return this.k;
    }

    public boolean isExceptionCatcherEnable() {
        return this.j;
    }

    @Deprecated
    public boolean isGAIDEnable() {
        return this.g;
    }

    public boolean isIMEIEnable() {
        return this.i;
    }

    public boolean isIMSIEnable() {
        return this.h;
    }

    public boolean isInternational() {
        return this.d;
    }

    public boolean isOverrideMiuiRegionSetting() {
        return this.l;
    }

    public boolean isUseCustomPrivacyPolicy() {
        return this.n;
    }

    public String toString() {
        try {
            return s.d(new byte[]{116, 14, 90, 83, 15, 86, Ascii.DC4, Ascii.SYN, 7, Ascii.SYN, 88, 10, 89, 26, 85, 69, Ascii.SYN, 120, 5, 89, 65}, "7a45f1") + a(this.f9373a) + '\'' + s.d(new byte[]{Ascii.CAN, 67, 68, 90, Ascii.DC4, 82, 8, 10, 47, 6, 12, 66}, "4c46a5") + a(this.b) + '\'' + s.d(new byte[]{77, Ascii.ETB, 7, 89, 4, 90, 15, 1, 10, 95, Ascii.SYN}, "a7d1e4") + this.c + '\'' + s.d(new byte[]{Ascii.FS, Ascii.CAN, 15, 11, 77, 3, 19, 10, 7, Ascii.SYN, 88, 10, 94, 89, 10, 88}, "08fe9f") + this.d + s.d(new byte[]{73, Ascii.DC4, 66, 3, 2, 12, 14, 10, 91, 69}, "e40fee") + this.e + '\'' + s.d(new byte[]{Ascii.CAN, Ascii.CAN, 92, 67, 81, 19, 19, 13, 2, 7, 124, 12, 65, 81, 97, 80, 83, 8, 14, 10, 53, 7, 69, 17, 93, 86, 84, 8}, "48354a") + this.l + s.d(new byte[]{77, 67, 91, 9, 86, 0, 92}, "ac6f2e") + this.f + s.d(new byte[]{Ascii.FS, Ascii.SYN, 35, 121, 45, 33, 36, 10, 7, 0, 93, 0, 13}, "06d8de") + this.g + s.d(new byte[]{Ascii.RS, 19, 42, 116, 98, 42, 36, 10, 7, 0, 93, 0, 15}, "23c91c") + this.h + s.d(new byte[]{Ascii.GS, Ascii.ETB, 40, 43, 39, 44, 36, 10, 7, 0, 93, 0, 12}, "17afbe") + this.i + s.d(new byte[]{72, Ascii.DC4, 115, Ascii.GS, 82, 1, 17, 16, 15, 13, 95, 38, 5, SignedBytes.MAX_POWER_OF_TWO, 85, 13, 84, Ascii.SYN, 36, 10, 7, 0, 93, 0, 89}, "d46e1d") + this.j + s.d(new byte[]{78, 66, 12, 15, 65, 17, 0, 10, 5, 7, 120, 1, 95}, "bbea2e") + a(this.m) + '}';
        } catch (Exception unused) {
            return "";
        }
    }
}
