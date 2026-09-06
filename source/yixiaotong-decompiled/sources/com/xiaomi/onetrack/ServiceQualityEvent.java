package com.xiaomi.onetrack;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import ijiami_1011.s.s.s;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class ServiceQualityEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9386a;
    private String b;
    private Integer c;
    private String d;
    private String e;
    private Integer f;
    private Integer g;
    private String h;
    private String i;
    private Integer j;
    private Long k;
    private Long l;
    private Long m;
    private Long n;
    private Long o;
    private Long p;
    private Long q;
    private Long r;
    private String s;
    private String t;
    private Map<String, Object> u;

    /* JADX INFO: renamed from: com.xiaomi.onetrack.ServiceQualityEvent$1, reason: invalid class name */
    public /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f9387a;
        private String b;
        private Integer c;
        private String d;
        private String e;
        private Integer f;
        private Integer g;
        private String h;
        private ResultType i;
        private Integer j;
        private Long k;
        private Long l;
        private Long m;
        private Long n;
        private Long o;
        private Long p;
        private Long q;
        private Long r;
        private OneTrack.NetType s;
        private String t;
        private Map<String, Object> u;

        public ServiceQualityEvent build() {
            return new ServiceQualityEvent(this, null);
        }

        public Builder setDnsLookupTime(Long l) {
            this.k = l;
            return this;
        }

        public Builder setDuration(Long l) {
            this.q = l;
            return this;
        }

        public Builder setExceptionTag(String str) {
            this.h = str;
            return this;
        }

        public Builder setExtraParams(Map<String, Object> map) {
            this.u = map;
            return this;
        }

        public Builder setHandshakeTime(Long l) {
            this.m = l;
            return this;
        }

        public Builder setHost(String str) {
            this.b = str;
            return this;
        }

        public Builder setIps(String... strArr) {
            if (strArr != null) {
                this.e = TextUtils.join(s.d(new byte[]{Ascii.ESC}, "7f62b1"), strArr);
            }
            return this;
        }

        public Builder setNetSdkVersion(String str) {
            this.t = str;
            return this;
        }

        public Builder setPath(String str) {
            this.d = str;
            return this;
        }

        public Builder setPort(Integer num) {
            this.c = num;
            return this;
        }

        public Builder setReceiveAllByteTime(Long l) {
            this.p = l;
            return this;
        }

        public Builder setReceiveFirstByteTime(Long l) {
            this.o = l;
            return this;
        }

        public Builder setRequestDataSendTime(Long l) {
            this.n = l;
            return this;
        }

        public Builder setRequestNetType(OneTrack.NetType netType) {
            this.s = netType;
            return this;
        }

        public Builder setRequestTimestamp(Long l) {
            this.r = l;
            return this;
        }

        public Builder setResponseCode(Integer num) {
            this.f = num;
            return this;
        }

        public Builder setResultType(ResultType resultType) {
            this.i = resultType;
            return this;
        }

        public Builder setRetryCount(Integer num) {
            this.j = num;
            return this;
        }

        public Builder setScheme(String str) {
            this.f9387a = str;
            return this;
        }

        public Builder setStatusCode(Integer num) {
            this.g = num;
            return this;
        }

        public Builder setTcpConnectTime(Long l) {
            this.l = l;
            return this;
        }
    }

    public enum ResultType {
        SUCCESS(s.d(new byte[]{90, 83}, "58fd1d")),
        FAILED(s.d(new byte[]{5, 89, 8, 14, 82, 87}, "c8ab73")),
        TIMEOUT(s.d(new byte[]{65, 95, 94, 4, 95, SignedBytes.MAX_POWER_OF_TWO, Ascii.NAK}, "563a05"));


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f9388a;

        ResultType(String str) {
            this.f9388a = str;
        }

        public String getResultType() {
            return this.f9388a;
        }
    }

    private ServiceQualityEvent(Builder builder) {
        this.f9386a = builder.f9387a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
        this.g = builder.g;
        this.h = builder.h;
        this.i = builder.i != null ? builder.i.getResultType() : null;
        this.j = builder.j;
        this.k = builder.k;
        this.l = builder.l;
        this.m = builder.m;
        this.o = builder.o;
        this.p = builder.p;
        this.r = builder.r;
        this.s = builder.s != null ? builder.s.toString() : null;
        this.n = builder.n;
        this.q = builder.q;
        this.t = builder.t;
        this.u = builder.u;
    }

    public /* synthetic */ ServiceQualityEvent(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public Long getDnsLookupTime() {
        return this.k;
    }

    public Long getDuration() {
        return this.q;
    }

    public String getExceptionTag() {
        return this.h;
    }

    public Map<String, Object> getExtraParams() {
        return this.u;
    }

    public Long getHandshakeTime() {
        return this.m;
    }

    public String getHost() {
        return this.b;
    }

    public String getIps() {
        return this.e;
    }

    public String getNetSdkVersion() {
        return this.t;
    }

    public String getPath() {
        return this.d;
    }

    public Integer getPort() {
        return this.c;
    }

    public Long getReceiveAllByteTime() {
        return this.p;
    }

    public Long getReceiveFirstByteTime() {
        return this.o;
    }

    public Long getRequestDataSendTime() {
        return this.n;
    }

    public String getRequestNetType() {
        return this.s;
    }

    public Long getRequestTimestamp() {
        return this.r;
    }

    public Integer getResponseCode() {
        return this.f;
    }

    public String getResultType() {
        return this.i;
    }

    public Integer getRetryCount() {
        return this.j;
    }

    public String getScheme() {
        return this.f9386a;
    }

    public Integer getStatusCode() {
        return this.g;
    }

    public Long getTcpConnectTime() {
        return this.l;
    }
}
