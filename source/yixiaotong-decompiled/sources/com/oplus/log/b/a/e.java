package com.oplus.log.b.a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.exifinterface.media.ExifInterface;
import com.oplus.log.d.f;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.oplus.log.f.d f5796a;

    public e(com.oplus.log.f.d dVar) {
        this.f5796a = dVar;
    }

    public final void a(Context context) {
        HashMap map = new HashMap();
        map.put(ExifInterface.TAG_MODEL, Build.PRODUCT);
        map.put("BrandOS_version", f.a());
        map.put("SDK_version", Build.VERSION.RELEASE);
        map.put("ROM_version", Build.DISPLAY);
        map.put("RAMSize", String.valueOf(com.oplus.log.d.e.a().get("MemTotal:")));
        map.put("InternalFreeSpace", String.valueOf(com.oplus.log.d.c.a(Environment.getDataDirectory()) / 1024));
        map.put("App_version", com.oplus.log.d.b.c(context));
        map.put("App_versioncode", String.valueOf(com.oplus.log.d.b.d(context)));
        if (this.f5796a != null) {
            this.f5796a.a(new com.oplus.log.b.b("BASE_INFO", "record_base_info", (byte) 4, null, map));
        }
    }
}
