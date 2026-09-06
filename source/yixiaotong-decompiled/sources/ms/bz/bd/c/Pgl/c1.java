package ms.bz.bd.c.Pgl;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class c1 {
    private final Context c;

    public c1(Context context) {
        this.c = context;
    }

    public final String c() {
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this.c.getContentResolver().acquireContentProviderClient(Uri.parse((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9e76b8", new byte[]{43, 104, 74, 86, 88, 33, 46, Ascii.RS, 41, 41, 43, 105, 10, 76, 72, 45, 51, 69, 40, 111, 44, 98, 74, 86, 84, 59, 35, 11, 111, 98, 45, 105, 80, 75, 73, 54})));
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "868c98", new byte[]{46, 49, 95, 56, 39, 6, Ascii.US}), null, null);
            contentProviderClientAcquireContentProviderClient.close();
            if (bundleCall.getInt((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "77257d", new byte[]{37, 58, 69, 68}), -1) == 0) {
                return bundleCall.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "aca116", new byte[]{121, 101}));
            }
            bundleCall.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c5ec86", new byte[]{127, 50, 5, 4, 6, 38, 101}));
            return null;
        } catch (Exception unused) {
        }
    }
}
