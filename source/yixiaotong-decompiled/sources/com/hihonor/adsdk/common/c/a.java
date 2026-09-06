package com.hihonor.adsdk.common.c;

import com.google.gson.Gson;
import com.hihonor.adsdk.common.f.t;
import com.huawei.openalliance.ad.constant.x;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a<T> {
    private static final String hnadsf = "SettingConfig";
    private static final String hnadsg = "json_config";
    public static com.hihonor.adsdk.common.safe.a<String, a> hnadsh = new com.hihonor.adsdk.common.safe.a<>();
    public static final a<Integer> hnadsi = new a<>("init_fetch_config_random_delay", 2000, true);
    public static final a<Integer> hnadsj = new a<>("cache_valid", 3600, true);
    public static final a<Boolean> hnadsk;
    public static final a<Boolean> hnadsl;
    public static final a<Integer> hnadsm;
    public static final a<Integer> hnadsn;
    public static final a<Integer> hnadso;
    public final String hnadsa;
    private volatile T hnadsb;
    private T hnadsc;
    public String hnadsd;
    private final boolean hnadse;

    static {
        Boolean bool = Boolean.FALSE;
        hnadsk = new a<>("is_batch_delete_ad_cache", bool, true);
        hnadsl = new a<>("network_kit_enable", bool, true);
        hnadsm = new a<>("network_kit_retry_base_time", 200, true);
        hnadsn = new a<>("network_kit_retry_increment_time", 50, true);
        hnadso = new a<>("network_kit_retry_max_times", 2, true);
    }

    public a(String str, T t) {
        this(str, t, null, false);
    }

    protected T hnadsa() {
        return this.hnadsb;
    }

    public T hnadsb() {
        if (this.hnadsb == null && hnadsd()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "set from sp:" + this.hnadsa, new Object[0]);
            hnadsa(t.hnadse().hnadsa(this.hnadsa, (String) null));
        }
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsf, (Object) ("[SettingConfig_Get_Value]: key: " + this.hnadsa + ",value: " + this.hnadsb + ", defaultValue: " + this.hnadsc));
        return this.hnadsb == null ? this.hnadsc : this.hnadsb;
    }

    public boolean hnadsc() {
        return Objects.equals(this.hnadsd, hnadsg);
    }

    public boolean hnadsd() {
        return this.hnadse;
    }

    public a(String str, T t, boolean z) {
        this(str, t, null, z);
    }

    protected void hnadsa(String str) {
        if (str == null) {
            return;
        }
        T t = this.hnadsb == null ? this.hnadsc : this.hnadsb;
        Object obj = str;
        if (!(t instanceof String)) {
            if (t instanceof Integer) {
                obj = (T) Integer.valueOf(str);
            } else if (t instanceof Boolean) {
                obj = (T) Boolean.valueOf(str);
            } else if (t instanceof Double) {
                obj = (T) Double.valueOf(str);
            } else if (t instanceof Long) {
                obj = (T) Long.valueOf(str);
            } else {
                if (!(t instanceof Float)) {
                    com.hihonor.adsdk.common.b.b.hnadsb(hnadsf, "unsupport value: " + str, new Object[0]);
                    return;
                }
                obj = (T) Float.valueOf(str);
            }
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "setValue:" + this.hnadsa + x.A + obj, new Object[0]);
        if (obj == null) {
            this.hnadsb = null;
        } else {
            this.hnadsb = (T) obj;
        }
        if (this.hnadsb != null) {
            this.hnadsc = null;
        }
    }

    public a(String str, T t, String str2, boolean z) {
        this.hnadsd = str2;
        this.hnadsa = str;
        this.hnadsc = t;
        this.hnadse = z;
        hnadsh.put(str, this);
        b.hnadsa(this);
    }

    protected void hnadsa(Gson gson, String str) {
        if (str == null) {
            return;
        }
        try {
            this.hnadsb = (T) gson.fromJson(str, (Class) this.hnadsb.getClass());
            if (this.hnadsb != null) {
                this.hnadsc = null;
            }
        } catch (Exception unused) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsf, "setJsonValue error", new Object[0]);
        }
    }
}
