package com.adprof.sdk.base.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public enum a {
    CLOSE("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAMAAACdt4HsAAAAM1BMVEUAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACjBUbJAAAAEHRSTlMAqyjUgcO3FcwGno4dDZZmlq1c/AAAAQZJREFUWMPt1sFuwjAQANHaJIRAaP3/X1tFDZqlUsA7cGSPq8yT4kOcr8+8bYZxSD1fL/fBobVWMv0aBKG2dcqc6NeJAEJ/38LqjNDf/8Rl+dsd5/7+/tTnm3BN9EKgv7BKCPTfrBCOmzA978+sdoRMz1w3YZwe94VVSqDfnwlB9VFI9gjjJiyuj4Lqo1Bdj3CquZ5ZEFQfBdWvDUKuRzjdBNcjHOilQG8E33P69F7w/etvgCB7BN2XgiDPzwjx+43geiPE+8sIsVcC9y+DIHsE2yO4/48o2B7B9gi2R7A9gu0RbI9gewTbI+z1ThjplVDpMwKLhT4jxFeg7xT+B8PQ3RN8Zptfb3gqESeo0NkAAAAASUVORK5CYII="),
    BACK("iVBORw0KGgoAAAANSUhEUgAAACAAAAAgBAMAAACBVGfHAAAAG1BMVEUAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACUUeIgAAAACHRSTlMAgFZAdWRsIFzMPMEAAABASURBVCjPY6AIMBegCWgooPKZGtEVCAw+BcxwBQgBTC0EDGWIQFfCSlgJG4aSDHQlLBhKPAgrkTBA95EBmTEMANsTClin7SK5AAAAAElFTkSuQmCC");


    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f130a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f131a;

    a(String str) {
        this.f131a = str;
    }

    public Bitmap a() {
        if (this.f130a == null) {
            byte[] bArrDecode = Base64.decode(this.f131a, 0);
            this.f130a = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
        }
        return this.f130a;
    }
}
