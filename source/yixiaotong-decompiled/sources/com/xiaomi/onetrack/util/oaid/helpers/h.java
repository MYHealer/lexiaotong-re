package com.xiaomi.onetrack.util.oaid.helpers;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.xiaomi.onetrack.util.p;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9545a = s.d(new byte[]{119, 17, 6, 81, 86, 113, 4, Ascii.DC2, 15, 1, 84, 44, 125, 44, 1, 84, 71, 80, 19}, "9dd875");

    public String a(Context context) {
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(Uri.parse(s.d(new byte[]{90, 11, 94, SignedBytes.MAX_POWER_OF_TWO, 84, 11, Ascii.NAK, 94, 73, 77, 82, 11, Ascii.ETB, 10, 69, 86, 88, 4, 79, 13, 2, 7, 95, 17, 80, 16, 73, Ascii.ESC, 88, 1, 4, 10, Ascii.DC2, 11, 69, Ascii.FS}, "9d041e")));
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call(s.d(new byte[]{3, 92, Ascii.ETB, 41, 112, 125, 37}, "d9cf14"), null, null);
            contentProviderClientAcquireContentProviderClient.close();
            if (bundleCall.getInt(s.d(new byte[]{83, 93, 85, 82}, "021741"), -1) == 0) {
                return bundleCall.getString(s.d(new byte[]{10, 87}, "c3df77"));
            }
        } catch (Exception e) {
            p.a(f9545a, e.getMessage());
        }
        return "";
    }
}
