package com.byazt.tv;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.fancy.adsdk.lib.constants.PtgRewardConstant;
import com.ubixnow.ooooo.oOOOoo00;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 239, 54})
public class ve extends c {
    public long m;
    public long nu;
    public String t;
    public String u;
    public String yp;
    public String z;

    @Override // com.byazt.tv.c
    public String i() {
        return this.z;
    }

    @Override // com.byazt.tv.c
    public String uj() {
        return NotificationCompat.CATEGORY_EVENT;
    }

    @Override // com.byazt.tv.c
    public List<String> c() {
        List<String> listC = super.c();
        ArrayList arrayList = new ArrayList(listC.size());
        arrayList.addAll(listC);
        arrayList.addAll(Arrays.asList(com.huawei.openalliance.ad.constant.x.cy, "varchar", "tag", "varchar", oOOOoo00.OooOo0o, TypedValues.Custom.S_INT, "ext_value", TypedValues.Custom.S_INT, "params", "varchar", "label", "varchar"));
        return arrayList;
    }

    @Override // com.byazt.tv.c
    public int c(Cursor cursor) {
        int iC = super.c(cursor);
        this.t = cursor.getString(iC);
        this.u = cursor.getString(iC + 1);
        this.m = cursor.getLong(iC + 2);
        this.nu = cursor.getLong(iC + 3);
        int i = iC + 5;
        this.z = cursor.getString(iC + 4);
        int i2 = iC + 6;
        this.yp = cursor.getString(i);
        return i2;
    }

    @Override // com.byazt.tv.c
    public void c(ContentValues contentValues) {
        super.c(contentValues);
        contentValues.put(com.huawei.openalliance.ad.constant.x.cy, this.t);
        contentValues.put("tag", this.u);
        contentValues.put(oOOOoo00.OooOo0o, Long.valueOf(this.m));
        contentValues.put("ext_value", Long.valueOf(this.nu));
        contentValues.put("params", this.z);
        contentValues.put("label", this.yp);
    }

    @Override // com.byazt.tv.c
    public void c(JSONObject jSONObject) throws JSONException {
        super.c(jSONObject);
        jSONObject.put("tea_event_index", this.ve);
        jSONObject.put(com.huawei.openalliance.ad.constant.x.cy, this.t);
        jSONObject.put("tag", this.u);
        jSONObject.put(oOOOoo00.OooOo0o, this.m);
        jSONObject.put("ext_value", this.nu);
        jSONObject.put("params", this.z);
        jSONObject.put("label", this.yp);
    }

    @Override // com.byazt.tv.c
    public c tt(JSONObject jSONObject) {
        super.tt(jSONObject);
        this.ve = jSONObject.optLong("tea_event_index", 0L);
        this.t = jSONObject.optString(com.huawei.openalliance.ad.constant.x.cy, null);
        this.u = jSONObject.optString("tag", null);
        this.m = jSONObject.optLong(oOOOoo00.OooOo0o, 0L);
        this.nu = jSONObject.optLong("ext_value", 0L);
        this.z = jSONObject.optString("params", null);
        this.yp = jSONObject.optString("label", null);
        return this;
    }

    @Override // com.byazt.tv.c
    public JSONObject tt() throws JSONException {
        JSONObject jSONObject = !TextUtils.isEmpty(this.z) ? new JSONObject(this.z) : null;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        jSONObject.put("local_time_ms", this.tt);
        jSONObject.put("tea_event_index", this.ve);
        jSONObject.put("session_id", this.uj);
        if (this.n > 0) {
            jSONObject.put(PtgRewardConstant.REWARD_PARAMS.USER_ID, this.n);
        }
        jSONObject.put("user_unique_id", TextUtils.isEmpty(this.f2757a) ? JSONObject.NULL : this.f2757a);
        if (!TextUtils.isEmpty(this.sp)) {
            jSONObject.put("ssid", this.sp);
        }
        jSONObject.put(com.huawei.openalliance.ad.constant.x.cy, this.t);
        jSONObject.put("tag", this.u);
        jSONObject.put(oOOOoo00.OooOo0o, this.m);
        jSONObject.put("ext_value", this.nu);
        jSONObject.put("label", this.yp);
        jSONObject.put("datetime", this.sl);
        if (!TextUtils.isEmpty(this.x)) {
            jSONObject.put("ab_sdk_version", this.x);
        }
        return jSONObject;
    }

    @Override // com.byazt.tv.c
    public String x() {
        return this.u + ", " + this.yp;
    }
}
