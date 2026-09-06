package com.ubixnow.ooooo;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oO0OO00o extends IOException {
    private static final long OooO00o = -1616151763072450476L;

    public oO0OO00o(String str) {
        super(str);
    }

    public static oO0OO00o OooO00o() {
        return new oO0OO00o("Protocol message end-group tag did not match expected tag.");
    }

    public static oO0OO00o OooO0O0() {
        return new oO0OO00o("Protocol message contained an invalid tag (zero).");
    }

    public static oO0OO00o OooO0OO() {
        return new oO0OO00o("Protocol message tag had invalid wire type.");
    }

    public static oO0OO00o OooO0Oo() {
        return new oO0OO00o("CodedInputStream encountered a malformed varint.");
    }

    public static oO0OO00o OooO0o() {
        return new oO0OO00o("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    public static oO0OO00o OooO0o0() {
        return new oO0OO00o("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static oO0OO00o OooO0oO() {
        return new oO0OO00o("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public static oO0OO00o OooO0oo() {
        return new oO0OO00o("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }
}
