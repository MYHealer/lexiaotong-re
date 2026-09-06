package com.squareup.okhttp;

import com.squareup.okhttp.internal.http.HeaderParser;
import cz.msebera.android.httpclient.client.cache.HeaderConstants;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class CacheControl {
    String headerValue;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;
    public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();
    public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();

    /* JADX INFO: renamed from: com.squareup.okhttp.CacheControl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public boolean isPrivate() {
        return this.isPrivate;
    }

    public boolean isPublic() {
        return this.isPublic;
    }

    public int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    public boolean noCache() {
        return this.noCache;
    }

    public boolean noStore() {
        return this.noStore;
    }

    public boolean noTransform() {
        return this.noTransform;
    }

    public boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    public int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    /* synthetic */ CacheControl(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private CacheControl(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, String str) {
        this.noCache = z;
        this.noStore = z2;
        this.maxAgeSeconds = i;
        this.sMaxAgeSeconds = i2;
        this.isPrivate = z3;
        this.isPublic = z4;
        this.mustRevalidate = z5;
        this.maxStaleSeconds = i3;
        this.minFreshSeconds = i4;
        this.onlyIfCached = z6;
        this.noTransform = z7;
        this.headerValue = str;
    }

    private CacheControl(Builder builder) {
        this.noCache = builder.noCache;
        this.noStore = builder.noStore;
        this.maxAgeSeconds = builder.maxAgeSeconds;
        this.sMaxAgeSeconds = -1;
        this.isPrivate = false;
        this.isPublic = false;
        this.mustRevalidate = false;
        this.maxStaleSeconds = builder.maxStaleSeconds;
        this.minFreshSeconds = builder.minFreshSeconds;
        this.onlyIfCached = builder.onlyIfCached;
        this.noTransform = builder.noTransform;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0097  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:34:0x00af  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:37:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:40:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:41:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:43:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:44:0x00da  */
    /* JADX WARN: Code duplicated, block: B:46:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:50:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:53:0x0101  */
    /* JADX WARN: Code duplicated, block: B:55:0x0109  */
    /* JADX WARN: Code duplicated, block: B:56:0x010f  */
    /* JADX WARN: Code duplicated, block: B:58:0x0118  */
    /* JADX WARN: Code duplicated, block: B:59:0x011b  */
    /* JADX WARN: Code duplicated, block: B:61:0x0123  */
    /* JADX WARN: Code duplicated, block: B:83:0x0125 A[SYNTHETIC] */
    public static CacheControl parse(Headers headers) {
        int i;
        int iSkipUntil;
        String strTrim;
        int iSkipUntil2;
        String strTrim2;
        int size = headers.size();
        boolean z = true;
        String str = null;
        boolean z2 = false;
        boolean z3 = false;
        int seconds = -1;
        int seconds2 = -1;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int seconds3 = -1;
        int seconds4 = -1;
        boolean z7 = false;
        boolean z8 = false;
        for (int i2 = 0; i2 < size; i2++) {
            String strName = headers.name(i2);
            String strValue = headers.value(i2);
            if (!strName.equalsIgnoreCase("Cache-Control")) {
                if (strName.equalsIgnoreCase("Pragma")) {
                }
            } else {
                if (str == null) {
                    str = strValue;
                }
                for (i = 0; i < strValue.length(); i = iSkipUntil2) {
                    iSkipUntil = HeaderParser.skipUntil(strValue, i, "=,;");
                    strTrim = strValue.substring(i, iSkipUntil).trim();
                    if (iSkipUntil != strValue.length() || strValue.charAt(iSkipUntil) == ',' || strValue.charAt(iSkipUntil) == ';') {
                        iSkipUntil2 = iSkipUntil + 1;
                        strTrim2 = null;
                    } else {
                        int iSkipWhitespace = HeaderParser.skipWhitespace(strValue, iSkipUntil + 1);
                        if (iSkipWhitespace < strValue.length() && strValue.charAt(iSkipWhitespace) == '\"') {
                            int i3 = iSkipWhitespace + 1;
                            int iSkipUntil3 = HeaderParser.skipUntil(strValue, i3, "\"");
                            strTrim2 = strValue.substring(i3, iSkipUntil3);
                            iSkipUntil2 = iSkipUntil3 + 1;
                        } else {
                            iSkipUntil2 = HeaderParser.skipUntil(strValue, iSkipWhitespace, ",;");
                            strTrim2 = strValue.substring(iSkipWhitespace, iSkipUntil2).trim();
                        }
                    }
                    if (HeaderConstants.CACHE_CONTROL_NO_CACHE.equalsIgnoreCase(strTrim)) {
                        z2 = true;
                    } else if (HeaderConstants.CACHE_CONTROL_NO_STORE.equalsIgnoreCase(strTrim)) {
                        z3 = true;
                    } else if ("max-age".equalsIgnoreCase(strTrim)) {
                        seconds = HeaderParser.parseSeconds(strTrim2, -1);
                    } else if ("s-maxage".equalsIgnoreCase(strTrim)) {
                        seconds2 = HeaderParser.parseSeconds(strTrim2, -1);
                    } else if (HeaderConstants.PRIVATE.equalsIgnoreCase(strTrim)) {
                        z4 = true;
                    } else if (HeaderConstants.PUBLIC.equalsIgnoreCase(strTrim)) {
                        z5 = true;
                    } else if (HeaderConstants.CACHE_CONTROL_MUST_REVALIDATE.equalsIgnoreCase(strTrim)) {
                        z6 = true;
                    } else if (HeaderConstants.CACHE_CONTROL_MAX_STALE.equalsIgnoreCase(strTrim)) {
                        seconds3 = HeaderParser.parseSeconds(strTrim2, Integer.MAX_VALUE);
                    } else if (HeaderConstants.CACHE_CONTROL_MIN_FRESH.equalsIgnoreCase(strTrim)) {
                        seconds4 = HeaderParser.parseSeconds(strTrim2, -1);
                    } else if ("only-if-cached".equalsIgnoreCase(strTrim)) {
                        z7 = true;
                    } else if ("no-transform".equalsIgnoreCase(strTrim)) {
                        z8 = true;
                    }
                }
            }
            z = false;
            while (i < strValue.length()) {
                iSkipUntil = HeaderParser.skipUntil(strValue, i, "=,;");
                strTrim = strValue.substring(i, iSkipUntil).trim();
                if (iSkipUntil != strValue.length()) {
                    iSkipUntil2 = iSkipUntil + 1;
                    strTrim2 = null;
                } else {
                    iSkipUntil2 = iSkipUntil + 1;
                    strTrim2 = null;
                }
                if (HeaderConstants.CACHE_CONTROL_NO_CACHE.equalsIgnoreCase(strTrim)) {
                    z2 = true;
                } else if (HeaderConstants.CACHE_CONTROL_NO_STORE.equalsIgnoreCase(strTrim)) {
                    z3 = true;
                } else if ("max-age".equalsIgnoreCase(strTrim)) {
                    seconds = HeaderParser.parseSeconds(strTrim2, -1);
                } else if ("s-maxage".equalsIgnoreCase(strTrim)) {
                    seconds2 = HeaderParser.parseSeconds(strTrim2, -1);
                } else if (HeaderConstants.PRIVATE.equalsIgnoreCase(strTrim)) {
                    z4 = true;
                } else if (HeaderConstants.PUBLIC.equalsIgnoreCase(strTrim)) {
                    z5 = true;
                } else if (HeaderConstants.CACHE_CONTROL_MUST_REVALIDATE.equalsIgnoreCase(strTrim)) {
                    z6 = true;
                } else if (HeaderConstants.CACHE_CONTROL_MAX_STALE.equalsIgnoreCase(strTrim)) {
                    seconds3 = HeaderParser.parseSeconds(strTrim2, Integer.MAX_VALUE);
                } else if (HeaderConstants.CACHE_CONTROL_MIN_FRESH.equalsIgnoreCase(strTrim)) {
                    seconds4 = HeaderParser.parseSeconds(strTrim2, -1);
                } else if ("only-if-cached".equalsIgnoreCase(strTrim)) {
                    z7 = true;
                } else if ("no-transform".equalsIgnoreCase(strTrim)) {
                    z8 = true;
                }
            }
        }
        return new CacheControl(z2, z3, seconds, seconds2, z4, z5, z6, seconds3, seconds4, z7, z8, !z ? null : str);
    }

    public String toString() {
        String str = this.headerValue;
        if (str != null) {
            return str;
        }
        String strHeaderValue = headerValue();
        this.headerValue = strHeaderValue;
        return strHeaderValue;
    }

    private String headerValue() {
        StringBuilder sb = new StringBuilder();
        if (this.noCache) {
            sb.append("no-cache, ");
        }
        if (this.noStore) {
            sb.append("no-store, ");
        }
        if (this.maxAgeSeconds != -1) {
            sb.append("max-age=").append(this.maxAgeSeconds).append(", ");
        }
        if (this.sMaxAgeSeconds != -1) {
            sb.append("s-maxage=").append(this.sMaxAgeSeconds).append(", ");
        }
        if (this.isPrivate) {
            sb.append("private, ");
        }
        if (this.isPublic) {
            sb.append("public, ");
        }
        if (this.mustRevalidate) {
            sb.append("must-revalidate, ");
        }
        if (this.maxStaleSeconds != -1) {
            sb.append("max-stale=").append(this.maxStaleSeconds).append(", ");
        }
        if (this.minFreshSeconds != -1) {
            sb.append("min-fresh=").append(this.minFreshSeconds).append(", ");
        }
        if (this.onlyIfCached) {
            sb.append("only-if-cached, ");
        }
        if (this.noTransform) {
            sb.append("no-transform, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public static final class Builder {
        int maxAgeSeconds = -1;
        int maxStaleSeconds = -1;
        int minFreshSeconds = -1;
        boolean noCache;
        boolean noStore;
        boolean noTransform;
        boolean onlyIfCached;

        public Builder noCache() {
            this.noCache = true;
            return this;
        }

        public Builder noStore() {
            this.noStore = true;
            return this;
        }

        public Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        public Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
        }

        public Builder maxAge(int i, TimeUnit timeUnit) {
            if (i < 0) {
                throw new IllegalArgumentException("maxAge < 0: " + i);
            }
            long seconds = timeUnit.toSeconds(i);
            this.maxAgeSeconds = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
            return this;
        }

        public Builder maxStale(int i, TimeUnit timeUnit) {
            if (i < 0) {
                throw new IllegalArgumentException("maxStale < 0: " + i);
            }
            long seconds = timeUnit.toSeconds(i);
            this.maxStaleSeconds = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
            return this;
        }

        public Builder minFresh(int i, TimeUnit timeUnit) {
            if (i < 0) {
                throw new IllegalArgumentException("minFresh < 0: " + i);
            }
            long seconds = timeUnit.toSeconds(i);
            this.minFreshSeconds = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
            return this;
        }

        public CacheControl build() {
            return new CacheControl(this, null);
        }
    }
}
