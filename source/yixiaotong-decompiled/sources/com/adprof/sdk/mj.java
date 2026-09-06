package com.adprof.sdk;

import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class mj extends k3 {
    public static final di<mj> ADAPTER;
    public static final Parcelable.Creator<mj> CREATOR;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f1310a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Double f481a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Integer f482a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Long f483a;
    public final Boolean b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Integer f484b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Long f485b;
    public final Boolean c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final Integer f486c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final Long f487c;
    public final Boolean d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final Integer f488d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final Long f489d;
    public final Boolean e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public final Integer f490e;
    public final Boolean f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public final Integer f491f;
    public final Integer g;
    public final Integer h;

    static {
        lj ljVar = new lj();
        ADAPTER = ljVar;
        CREATOR = new j3(ljVar);
    }

    public mj(Integer num, Integer num2, Integer num3, Boolean bool, Integer num4, Integer num5, Integer num6, Boolean bool2, Integer num7, Boolean bool3, Integer num8, Long l, Double d, Long l2, Long l3, Long l4, Boolean bool4, Boolean bool5, Boolean bool6, q6 q6Var) {
        super(ADAPTER, q6Var);
        this.f482a = num;
        this.f484b = num2;
        this.f486c = num3;
        this.f1310a = bool;
        this.f488d = num4;
        this.f490e = num5;
        this.f491f = num6;
        this.b = bool2;
        this.g = num7;
        this.c = bool3;
        this.h = num8;
        this.f483a = l;
        this.f481a = d;
        this.f485b = l2;
        this.f487c = l3;
        this.f489d = l4;
        this.d = bool4;
        this.e = bool5;
        this.f = bool6;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof mj)) {
            return false;
        }
        mj mjVar = (mj) obj;
        return a().equals(mjVar.a()) && kc.a(this.f482a, mjVar.f482a) && kc.a(this.f484b, mjVar.f484b) && kc.a(this.f486c, mjVar.f486c) && kc.a(this.f1310a, mjVar.f1310a) && kc.a(this.f488d, mjVar.f488d) && kc.a(this.f490e, mjVar.f490e) && kc.a(this.f491f, mjVar.f491f) && kc.a(this.b, mjVar.b) && kc.a(this.g, mjVar.g) && kc.a(this.c, mjVar.c) && kc.a(this.h, mjVar.h) && kc.a(this.f483a, mjVar.f483a) && kc.a(this.f481a, mjVar.f481a) && kc.a(this.f485b, mjVar.f485b) && kc.a(this.f487c, mjVar.f487c) && kc.a(this.f489d, mjVar.f489d) && kc.a(this.d, mjVar.d) && kc.a(this.e, mjVar.e) && kc.a(this.f, mjVar.f);
    }

    public int hashCode() {
        int i = ((de) this).f1127a;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        Integer num = this.f482a;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.f484b;
        int iHashCode3 = (iHashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.f486c;
        int iHashCode4 = (iHashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Boolean bool = this.f1310a;
        int iHashCode5 = (iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num4 = this.f488d;
        int iHashCode6 = (iHashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.f490e;
        int iHashCode7 = (iHashCode6 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.f491f;
        int iHashCode8 = (iHashCode7 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Boolean bool2 = this.b;
        int iHashCode9 = (iHashCode8 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Integer num7 = this.g;
        int iHashCode10 = (iHashCode9 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Boolean bool3 = this.c;
        int iHashCode11 = (iHashCode10 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Integer num8 = this.h;
        int iHashCode12 = (iHashCode11 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Long l = this.f483a;
        int iHashCode13 = (iHashCode12 + (l != null ? l.hashCode() : 0)) * 37;
        Double d = this.f481a;
        int iHashCode14 = (iHashCode13 + (d != null ? d.hashCode() : 0)) * 37;
        Long l2 = this.f485b;
        int iHashCode15 = (iHashCode14 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.f487c;
        int iHashCode16 = (iHashCode15 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.f489d;
        int iHashCode17 = (iHashCode16 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Boolean bool4 = this.d;
        int iHashCode18 = (iHashCode17 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        Boolean bool5 = this.e;
        int iHashCode19 = (iHashCode18 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
        Boolean bool6 = this.f;
        int iHashCode20 = iHashCode19 + (bool6 != null ? bool6.hashCode() : 0);
        ((de) this).f1127a = iHashCode20;
        return iHashCode20;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f482a != null) {
            sb.append(", shake=").append(this.f482a);
        }
        if (this.f484b != null) {
            sb.append(", slide=").append(this.f484b);
        }
        if (this.f486c != null) {
            sb.append(", rotate=").append(this.f486c);
        }
        if (this.f1310a != null) {
            sb.append(", red_packet_rain=").append(this.f1310a);
        }
        if (this.f488d != null) {
            sb.append(", popup_countdown=").append(this.f488d);
        }
        if (this.f490e != null) {
            sb.append(", popup_close_countdown=").append(this.f490e);
        }
        if (this.f491f != null) {
            sb.append(", countdown=").append(this.f491f);
        }
        if (this.b != null) {
            sb.append(", video_sound=").append(this.b);
        }
        if (this.g != null) {
            sb.append(", close_countdown=").append(this.g);
        }
        if (this.c != null) {
            sb.append(", full_screen_click=").append(this.c);
        }
        if (this.h != null) {
            sb.append(", shake_version=").append(this.h);
        }
        if (this.f483a != null) {
            sb.append(", shake_sensitivity=").append(this.f483a);
        }
        if (this.f481a != null) {
            sb.append(", shake_sensitivity_f=").append(this.f481a);
        }
        if (this.f485b != null) {
            sb.append(", shake_detection=").append(this.f485b);
        }
        if (this.f487c != null) {
            sb.append(", shake_hit_count=").append(this.f487c);
        }
        if (this.f489d != null) {
            sb.append(", min_slide_distance=").append(this.f489d);
        }
        if (this.d != null) {
            sb.append(", shake_need_vibrator=").append(this.d);
        }
        if (this.e != null) {
            sb.append(", cta_top_right=").append(this.e);
        }
        if (this.f != null) {
            sb.append(", click_bubble=").append(this.f);
        }
        return sb.replace(0, 2, "ResponseInteraction{").append('}').toString();
    }
}
