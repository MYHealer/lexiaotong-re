package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.annotations.c;
import com.huawei.openalliance.ad.beans.inner.b;
import com.huawei.openalliance.ad.utils.am;
import com.umeng.analytics.pro.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class Location {
    private int clctSource;
    private Long clctTime;
    private Integer lastfix;

    @c(Code = d.C)
    @com.huawei.openalliance.ad.annotations.a
    private Double latitude;

    @com.huawei.openalliance.ad.annotations.d
    private b locationSwitches;

    @c(Code = "lon")
    @com.huawei.openalliance.ad.annotations.a
    private Double longitude;

    public Location() {
    }

    public Location(Double d, Double d2) {
        Code(d);
        V(d2);
    }

    public Integer B() {
        return this.lastfix;
    }

    public int C() {
        return this.clctSource;
    }

    public Location Code() {
        Location location = new Location();
        location.longitude = this.longitude;
        location.latitude = this.latitude;
        location.lastfix = this.lastfix;
        location.clctTime = this.clctTime;
        location.clctSource = this.clctSource;
        return location;
    }

    public void Code(int i) {
        this.clctSource = i;
    }

    public void Code(b bVar) {
        this.locationSwitches = bVar;
    }

    public void Code(Double d) {
        this.longitude = am.Code(d, 4, 4);
    }

    public void Code(Integer num) {
        this.lastfix = num;
    }

    public void Code(Long l) {
        this.clctTime = l;
    }

    public Double I() {
        return this.latitude;
    }

    public b S() {
        return this.locationSwitches;
    }

    public Double V() {
        return this.longitude;
    }

    public void V(Double d) {
        this.latitude = am.Code(d, 4, 4);
    }

    public Long Z() {
        return this.clctTime;
    }
}
