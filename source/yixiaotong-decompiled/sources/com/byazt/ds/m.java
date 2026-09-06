package com.byazt.ds;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.umeng.analytics.pro.am;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1480, 130})
public class m extends ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f2111a;
    public final Context n;

    public m(Context context, x xVar) {
        super(false, false);
        this.n = context;
        this.f2111a = xVar;
    }

    @Override // com.byazt.ds.ve
    public boolean c(JSONObject jSONObject) throws JSONException {
        int i;
        int i2;
        String packageName = this.n.getPackageName();
        PackageInfo packageInfo = null;
        if (TextUtils.isEmpty(this.f2111a.lr())) {
            jSONObject.put("package", packageName);
        } else {
            if (com.byazt.yv.da.tt) {
                com.byazt.yv.da.c("has zijie pkg", null);
            }
            jSONObject.put("package", this.f2111a.lr());
            jSONObject.put("real_package_name", packageName);
        }
        try {
            packageInfo = this.n.getPackageManager().getPackageInfo(packageName, 0);
        } catch (Throwable unused) {
        }
        if (packageInfo != null) {
            try {
                i = packageInfo.versionCode;
            } catch (Throwable th) {
                com.byazt.yv.da.tt(th);
                return false;
            }
        } else {
            i = 0;
        }
        if (!TextUtils.isEmpty(this.f2111a.zb())) {
            jSONObject.put("app_version", this.f2111a.zb());
        } else {
            jSONObject.put("app_version", packageInfo != null ? packageInfo.versionName : "");
        }
        if (!TextUtils.isEmpty(this.f2111a.pf())) {
            jSONObject.put("app_version_minor", this.f2111a.pf());
        } else {
            jSONObject.put("app_version_minor", "");
        }
        if (this.f2111a.h() != 0) {
            jSONObject.put("version_code", this.f2111a.h());
        } else {
            jSONObject.put("version_code", i);
        }
        if (this.f2111a.d() != 0) {
            jSONObject.put("update_version_code", this.f2111a.d());
        } else {
            jSONObject.put("update_version_code", i);
        }
        if (this.f2111a.eo() != 0) {
            jSONObject.put("manifest_version_code", this.f2111a.eo());
        } else {
            jSONObject.put("manifest_version_code", i);
        }
        if (!TextUtils.isEmpty(this.f2111a.md())) {
            jSONObject.put("app_name", this.f2111a.md());
        }
        if (!TextUtils.isEmpty(this.f2111a.or())) {
            jSONObject.put("tweaked_channel", this.f2111a.or());
        }
        if (packageInfo == null || packageInfo.applicationInfo == null || (i2 = packageInfo.applicationInfo.labelRes) <= 0) {
            return true;
        }
        jSONObject.put(am.s, this.n.getString(i2));
        return true;
    }
}
