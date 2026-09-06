package com.opos.mobad.provider.record;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import com.opos.process.bridge.annotation.BridgeMethod;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.IBridgeHandler;
import com.stub.StubApp;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class SdKRecord implements IBridgeHandler {
    public static final IBridgeHandler.Factory FACTORY = new IBridgeHandler.Factory() { // from class: com.opos.mobad.provider.record.SdKRecord.1
        @Override // com.opos.process.bridge.provider.IBridgeHandler.Factory
        public SdKRecord getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            return SdKRecord.a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile SdKRecord f7274a;
    private Context b;
    private SharedPreferences c;
    private a d;

    public interface a {
        void a();
    }

    private SdKRecord(Context context) {
        this.b = context;
        this.c = context.getSharedPreferences("mobad_sdk_record", 0);
    }

    public static final SdKRecord a(Context context) {
        SdKRecord sdKRecord;
        if (f7274a != null) {
            return f7274a;
        }
        synchronized (SdKRecord.class) {
            if (f7274a == null) {
                f7274a = new SdKRecord(context);
            }
            sdKRecord = f7274a;
        }
        return sdKRecord;
    }

    @BridgeMethod
    public CacheEntity a() {
        return new CacheEntity(this.c.getInt("img_cache", 0), this.c.getInt("img_amount", 0));
    }

    @BridgeMethod
    public void a(CacheEntity cacheEntity) {
        int i = this.c.getInt("img_cache", 0) + cacheEntity.f7271a;
        this.c.edit().putInt("img_cache", i).putInt("img_amount", this.c.getInt("img_amount", 0) + cacheEntity.b).commit();
    }

    @BridgeMethod
    public void a(ControlEntity controlEntity) {
        this.c.edit().putBoolean("control_tt_enable", controlEntity.f7272a).putBoolean("control_gdt_enable", controlEntity.b).putBoolean("control_cache_enable", controlEntity.c).putLong("control_refresh_time", controlEntity.d).putBoolean("control_gg_enable", controlEntity.e).putBoolean("control_fb_enable", controlEntity.f).putBoolean("control_mtg_enable", controlEntity.i).putBoolean("control_quic_enable", controlEntity.g).putBoolean("control_jd_enable", controlEntity.h).putBoolean("control_ads_enable", controlEntity.k).putBoolean("control_pangle_enable", controlEntity.j).putBoolean("control_ks_enable", controlEntity.l).putBoolean("control_topon_enable", controlEntity.m).commit();
        a aVar = this.d;
        if (aVar != null) {
            aVar.a();
        }
    }

    @BridgeMethod
    public void a(CookieData cookieData) {
        if (cookieData == null) {
            return;
        }
        this.c.edit().putString(OapsKey.KEY_CK, cookieData.f7273a).putLong("ck_time", cookieData.b).commit();
    }

    @BridgeMethod
    public void a(String str) {
        SharedPreferences.Editor editorPutString;
        if (TextUtils.isEmpty(str)) {
            editorPutString = this.c.edit().remove("cr_amount").remove("cr_last_time").remove("cr_info");
        } else {
            editorPutString = this.c.edit().putInt("cr_amount", this.c.getInt("cr_amount", 0) + 1).putLong("cr_last_time", System.currentTimeMillis()).putString("cr_info", str);
        }
        editorPutString.commit();
    }

    @BridgeMethod
    public void a(String str, String str2) {
        SharedPreferences.Editor editorPutString;
        if (TextUtils.isEmpty(str)) {
            editorPutString = this.c.edit().remove("cr_amount").remove("cr_last_time").remove("cr_info").remove("cr_env_info");
        } else {
            editorPutString = this.c.edit().putInt("cr_amount", this.c.getInt("cr_amount", 0) + 1).putLong("cr_last_time", System.currentTimeMillis()).putString("cr_info", str).putString("cr_env_info", str2);
        }
        editorPutString.commit();
    }

    @BridgeMethod
    public String[] a(String str, boolean z) {
        com.opos.cmn.an.f.a.b("SdKRecord", "getDataStartWithKey:keyWord" + str + ";ifRemoveDataAfter:" + z);
        ArrayList arrayList = new ArrayList();
        SharedPreferences.Editor editorEdit = this.c.edit();
        for (String str2 : this.c.getAll().keySet()) {
            if (str2 != null && str2.startsWith(str)) {
                arrayList.add(this.c.getString(str2, ""));
                if (z) {
                    editorEdit = editorEdit.remove(str2);
                }
            }
        }
        editorEdit.commit();
        String[] strArr = new String[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            String str3 = (String) arrayList.get(i);
            com.opos.cmn.an.f.a.b("SdKRecord", "getDataStartWithKey:set" + str3);
            strArr[i] = str3;
        }
        return strArr;
    }

    @BridgeMethod
    public CacheEntity b() {
        return new CacheEntity(this.c.getInt("video_cache", 0), this.c.getInt("video_amount", 0));
    }

    @BridgeMethod
    public void b(CacheEntity cacheEntity) {
        int i = this.c.getInt("video_cache", 0) + cacheEntity.f7271a;
        this.c.edit().putInt("video_cache", i).putInt("video_amount", this.c.getInt("video_amount", 0) + cacheEntity.b).commit();
    }

    @BridgeMethod
    public void b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        this.c.edit().putString("p_oid", str).putString("p_did", str2).commit();
    }

    @BridgeMethod
    public void c() {
        this.c.edit().remove("img_amount").remove("img_cache").remove("video_amount").remove("video_cache").commit();
    }

    @BridgeMethod
    public void c(String str, String str2) {
        com.opos.cmn.an.f.a.b("SdKRecord", "saveStringData:key->" + str + ";value->" + str2);
        this.c.edit().putString(str, str2).commit();
    }

    @BridgeMethod
    public ControlEntity d() {
        boolean z = this.c.getBoolean("control_tt_enable", false);
        boolean z2 = this.c.getBoolean("control_gdt_enable", false);
        boolean z3 = this.c.getBoolean("control_cache_enable", false);
        long j = this.c.getLong("control_refresh_time", 0L);
        return new ControlEntity(z, z2, z3, this.c.getBoolean("control_gg_enable", false), this.c.getBoolean("control_fb_enable", false), this.c.getBoolean("control_quic_enable", false), this.c.getBoolean("control_mtg_enable", false), j, this.c.getBoolean("control_jd_enable", false), this.c.getBoolean("control_pangle_enable", false), this.c.getBoolean("control_ads_enable", false), this.c.getBoolean("control_ks_enable", false), this.c.getBoolean("control_topon_enable", false));
    }

    @BridgeMethod
    public long e() {
        return this.c.getLong("align_time", 0L);
    }

    @BridgeMethod
    public int f() {
        return this.c.getInt("cr_amount", 0);
    }

    @BridgeMethod
    public long g() {
        return this.c.getLong("cr_last_time", 0L);
    }

    @BridgeMethod
    public String h() {
        return this.c.getString("cr_info", "");
    }

    @BridgeMethod
    public String i() {
        return this.c.getString("cr_env_info", "");
    }

    @BridgeMethod
    public CookieData j() {
        return new CookieData(this.c.getString(OapsKey.KEY_CK, ""), this.c.getLong("ck_time", -1L));
    }

    @BridgeMethod
    public String k() {
        return this.c.getString("p_oid", "");
    }

    @BridgeMethod
    public String l() {
        return this.c.getString("p_did", "");
    }
}
