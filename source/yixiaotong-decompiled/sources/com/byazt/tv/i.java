package com.byazt.tv;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.fancy.adsdk.lib.constants.PtgRewardConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 239, 42})
public class i extends c {
    public String gt;
    public String m;
    public int my;
    public String nu;
    public String rh;
    public long t;
    public String u;
    public String yp;
    public String z;

    public boolean da() {
        return this.t == -1;
    }

    @Override // com.byazt.tv.c
    public String uj() {
        return "page";
    }

    @Override // com.byazt.tv.c
    public List<String> c() {
        List<String> listC = super.c();
        ArrayList arrayList = new ArrayList(listC.size());
        arrayList.addAll(listC);
        arrayList.addAll(Arrays.asList("page_key", "varchar", "refer_page_key", "varchar", "duration", TypedValues.Custom.S_INT, "is_back", TypedValues.Custom.S_INT, "last_session", "varchar", ArticleInfo.PAGE_TITLE, "varchar", "refer_page_title", "varchar", "page_path", "varchar", "referrer_page_path", "varchar"));
        return arrayList;
    }

    @Override // com.byazt.tv.c
    public int c(Cursor cursor) {
        int iC = super.c(cursor);
        this.yp = cursor.getString(iC);
        this.u = cursor.getString(iC + 1);
        this.t = cursor.getLong(iC + 2);
        this.my = cursor.getInt(iC + 3);
        this.gt = cursor.getString(iC + 4);
        this.z = cursor.getString(iC + 5);
        this.m = cursor.getString(iC + 6);
        int i = iC + 8;
        this.nu = cursor.getString(iC + 7);
        int i2 = iC + 9;
        this.rh = cursor.getString(i);
        return i2;
    }

    @Override // com.byazt.tv.c
    public void c(ContentValues contentValues) {
        super.c(contentValues);
        contentValues.put("page_key", this.yp);
        contentValues.put("refer_page_key", this.u);
        contentValues.put("duration", Long.valueOf(this.t));
        contentValues.put("is_back", Integer.valueOf(this.my));
        contentValues.put("last_session", this.gt);
        contentValues.put(ArticleInfo.PAGE_TITLE, this.z);
        contentValues.put("refer_page_title", this.m);
        contentValues.put("page_path", this.nu);
        contentValues.put("referrer_page_path", this.rh);
    }

    @Override // com.byazt.tv.c
    public void c(JSONObject jSONObject) throws JSONException {
        super.c(jSONObject);
        jSONObject.put("page_key", this.yp);
        jSONObject.put("refer_page_key", this.u);
        jSONObject.put("duration", this.t);
        jSONObject.put("is_back", this.my);
        jSONObject.put(ArticleInfo.PAGE_TITLE, this.z);
        jSONObject.put("refer_page_title", this.m);
        jSONObject.put("page_path", this.nu);
        jSONObject.put("referrer_page_path", this.rh);
    }

    @Override // com.byazt.tv.c
    public c tt(JSONObject jSONObject) {
        super.tt(jSONObject);
        this.yp = jSONObject.optString("page_key", null);
        this.u = jSONObject.optString("refer_page_key", null);
        this.t = jSONObject.optLong("duration", 0L);
        this.my = jSONObject.optInt("is_back", 0);
        this.z = jSONObject.optString(ArticleInfo.PAGE_TITLE, null);
        this.m = jSONObject.optString("refer_page_title", null);
        this.nu = jSONObject.optString("page_path", null);
        this.rh = jSONObject.optString("referrer_page_path", null);
        return this;
    }

    @Override // com.byazt.tv.c
    public JSONObject tt() throws JSONException {
        JSONObject jSONObject = new JSONObject();
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
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, "bav2b_page");
        jSONObject.put("is_bav", 1);
        jSONObject.put("params", t());
        jSONObject.put("datetime", this.sl);
        return jSONObject;
    }

    private JSONObject t() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("page_key", this.yp);
        jSONObject.put("refer_page_key", this.u);
        jSONObject.put("is_back", this.my);
        jSONObject.put("duration", this.t);
        jSONObject.put(ArticleInfo.PAGE_TITLE, this.z);
        jSONObject.put("refer_page_title", this.m);
        jSONObject.put("page_path", this.nu);
        jSONObject.put("referrer_page_path", this.rh);
        return jSONObject;
    }

    public boolean sl() {
        return this.yp.contains(com.huawei.openalliance.ad.constant.x.bQ);
    }

    @Override // com.byazt.tv.c
    public String x() {
        return this.yp + ", " + this.t;
    }
}
