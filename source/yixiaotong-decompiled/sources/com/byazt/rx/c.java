package com.byazt.rx;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 152, 20})
public class c {
    public Context c;
    public com.byazt.uy.n tt;
    public Map<String, Object> ve;

    public com.byazt.uy.n ve() {
        return this.tt;
    }

    public c(Context context, com.byazt.uy.n nVar) {
        this.c = context;
        this.tt = nVar;
    }

    public Map<String, Object> c() {
        Map<String, Object> mapC = this.tt.c();
        if (mapC == null) {
            mapC = new HashMap<>(4);
        }
        if (c(mapC)) {
            try {
                PackageInfo packageInfo = this.c.getPackageManager().getPackageInfo(this.c.getPackageName(), 128);
                mapC.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, packageInfo.versionName);
                mapC.put("version_code", Integer.valueOf(packageInfo.versionCode));
                if (mapC.get("update_version_code") == null) {
                    Object obj = packageInfo.applicationInfo.metaData != null ? packageInfo.applicationInfo.metaData.get("UPDATE_VERSION_CODE") : null;
                    if (obj == null) {
                        obj = mapC.get("version_code");
                    }
                    mapC.put("update_version_code", obj);
                }
            } catch (Throwable unused) {
                mapC.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, com.byazt.mg.c.n(this.c));
                mapC.put("version_code", Integer.valueOf(com.byazt.mg.c.a(this.c)));
                if (mapC.get("update_version_code") == null) {
                    mapC.put("update_version_code", mapC.get("version_code"));
                }
            }
        }
        return mapC;
    }

    public Map<String, Object> tt() {
        if (this.ve == null) {
            this.ve = this.tt.sp();
        }
        return this.ve;
    }

    public static boolean c(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return true;
        }
        return ((map.containsKey("app_version") || map.containsKey(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME)) && map.containsKey("version_code") && map.containsKey("update_version_code")) ? false : true;
    }

    public String uj() {
        return com.byazt.mg.c.uj(this.c);
    }

    public String n() {
        return this.tt.tt();
    }
}
