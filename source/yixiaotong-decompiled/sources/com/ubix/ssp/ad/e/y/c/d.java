package com.ubix.ssp.ad.e.y.c;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d extends IOException {
    public d(String str) {
        super(str);
    }

    static d a() {
        return new d("Protocol message end-group tag did not match expected tag.");
    }

    static d b() {
        return new d("Protocol message contained an invalid tag (zero).");
    }

    static d c() {
        return new d("Protocol message tag had invalid wire type.");
    }

    static d d() {
        return new d("CodedInputStream encountered a malformed varint.");
    }

    static d e() {
        return new d("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static d f() {
        return new d("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    static d g() {
        return new d("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }
}
