package com.hihonor.adsdk.common.f;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class t {
    private static final String hnadsb = "SPUtil";
    private static final ConcurrentMap<String, t> hnadsc = new ConcurrentHashMap();
    private static final int hnadsd = -1;
    private static final long hnadse = -1;
    private static final float hnadsf = -1.0f;
    private static final int hnadsg = 16;
    private static final String hnadsh = "honor_ad_pref";
    private SharedPreferences hnadsa;

    class a extends HashMap<String, String> {
        a(int i) {
            super(i);
            put("default", "defaultValue");
        }
    }

    private t(String str) {
        if (com.hihonor.adsdk.common.a.hnadsa().hnadsb() == null) {
            this.hnadsa = null;
            com.hihonor.adsdk.common.b.b.hnadse(hnadsb, "context is null, getSharedPreferences fail", new Object[0]);
            return;
        }
        try {
            this.hnadsa = com.hihonor.adsdk.common.a.hnadsa().hnadsb().getSharedPreferences(str, 0);
        } catch (Exception e) {
            this.hnadsa = null;
            com.hihonor.adsdk.common.b.b.hnadse(hnadsb, "getSharedPreferences fail msg：" + e.getMessage(), new Object[0]);
        }
    }

    public static t hnadsc() {
        return hnadsd(hnadsh);
    }

    public static t hnadsd(String str) {
        if (TextUtils.isEmpty(str)) {
            str = hnadsh;
        }
        ConcurrentMap<String, t> concurrentMap = hnadsc;
        t tVar = concurrentMap.get(str);
        if (tVar == null || tVar.hnadsa == null) {
            synchronized (t.class) {
                if (tVar == null) {
                    tVar = new t(str);
                    concurrentMap.put(str, tVar);
                }
            }
        }
        return tVar;
    }

    public static t hnadse() {
        return hnadsd(hnadsh);
    }

    public void hnadsb(String str, String str2) {
        hnadsa(str, str2, false);
    }

    public long hnadsf(String str) {
        return hnadsa(str, -1L);
    }

    public String hnadsg(String str) {
        return hnadsa(str, "");
    }

    public Set<String> hnadsh(String str) {
        return hnadsa(str, Collections.emptySet());
    }

    public void hnadsi(String str) {
        hnadsc(str, false);
    }

    public void hnadsa(String str, String str2, boolean z) {
        SharedPreferences sharedPreferences = this.hnadsa;
        if (sharedPreferences == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsb, "Context may be empty, please initialize adSdk first", new Object[0]);
        } else if (z) {
            sharedPreferences.edit().putString(str, str2).commit();
        } else {
            sharedPreferences.edit().putString(str, str2).apply();
        }
    }

    public float hnadsc(String str) {
        return hnadsa(str, -1.0f);
    }

    public int hnadse(String str) {
        return hnadsa(str, -1);
    }

    public SharedPreferences.Editor hnadsb() {
        SharedPreferences sharedPreferences = this.hnadsa;
        if (sharedPreferences == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsb, "Context may be empty, please initialize adSdk first", new Object[0]);
            return null;
        }
        return sharedPreferences.edit();
    }

    public void hnadsc(String str, boolean z) {
        SharedPreferences sharedPreferences = this.hnadsa;
        if (sharedPreferences == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsb, "Context may be empty, please initialize adSdk first", new Object[0]);
        } else if (z) {
            sharedPreferences.edit().remove(str).commit();
        } else {
            sharedPreferences.edit().remove(str).apply();
        }
    }

    public void hnadsb(String str, int i) {
        hnadsa(str, i, false);
    }

    public void hnadsb(String str, long j) {
        hnadsa(str, j, false);
    }

    public void hnadsb(String str, float f) {
        hnadsa(str, f, false);
    }

    public String hnadsa(String str, String str2) {
        SharedPreferences sharedPreferences = this.hnadsa;
        if (sharedPreferences == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsb, "Context may be empty, please initialize adSdk first", new Object[0]);
            return "";
        }
        return sharedPreferences.getString(str, str2);
    }

    public void hnadsb(String str, boolean z) {
        hnadsa(str, z, false);
    }

    public boolean hnadsb(String str) {
        return hnadsa(str, false);
    }

    public void hnadsb(String str, Set<String> set) {
        hnadsa(str, set, false);
    }

    public Map<String, ?> hnadsd() {
        SharedPreferences sharedPreferences = this.hnadsa;
        if (sharedPreferences == null) {
            a aVar = new a(16);
            com.hihonor.adsdk.common.b.b.hnadse(hnadsb, "Context may be empty, please initialize adSdk first", new Object[0]);
            return aVar;
        }
        return sharedPreferences.getAll();
    }

    public void hnadsa(String str, int i, boolean z) {
        SharedPreferences sharedPreferences = this.hnadsa;
        if (sharedPreferences == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsb, "Context may be empty, please initialize adSdk first", new Object[0]);
        } else if (z) {
            sharedPreferences.edit().putInt(str, i).commit();
        } else {
            sharedPreferences.edit().putInt(str, i).apply();
        }
    }

    public int hnadsa(String str, int i) {
        SharedPreferences sharedPreferences = this.hnadsa;
        if (sharedPreferences == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsb, "Context may be empty, please initialize adSdk first", new Object[0]);
            return -1;
        }
        return sharedPreferences.getInt(str, i);
    }

    public void hnadsa(String str, long j, boolean z) {
        SharedPreferences sharedPreferences = this.hnadsa;
        if (sharedPreferences == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsb, "Context may be empty, please initialize adSdk first", new Object[0]);
        } else if (z) {
            sharedPreferences.edit().putLong(str, j).commit();
        } else {
            sharedPreferences.edit().putLong(str, j).apply();
        }
    }

    public long hnadsa(String str, long j) {
        SharedPreferences sharedPreferences = this.hnadsa;
        if (sharedPreferences == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsb, "Context may be empty, please initialize adSdk first", new Object[0]);
            return -1L;
        }
        return sharedPreferences.getLong(str, j);
    }

    public void hnadsa(String str, float f, boolean z) {
        SharedPreferences sharedPreferences = this.hnadsa;
        if (sharedPreferences == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsb, "Context may be empty, please initialize adSdk first", new Object[0]);
        } else if (z) {
            sharedPreferences.edit().putFloat(str, f).commit();
        } else {
            sharedPreferences.edit().putFloat(str, f).apply();
        }
    }

    public float hnadsa(String str, float f) {
        SharedPreferences sharedPreferences = this.hnadsa;
        if (sharedPreferences == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsb, "Context may be empty, please initialize adSdk first", new Object[0]);
            return -1.0f;
        }
        return sharedPreferences.getFloat(str, f);
    }

    public void hnadsa(String str, boolean z, boolean z2) {
        SharedPreferences sharedPreferences = this.hnadsa;
        if (sharedPreferences == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsb, "Context may be empty, please initialize adSdk first", new Object[0]);
        } else if (z2) {
            sharedPreferences.edit().putBoolean(str, z).commit();
        } else {
            sharedPreferences.edit().putBoolean(str, z).apply();
        }
    }

    public boolean hnadsa(String str, boolean z) {
        SharedPreferences sharedPreferences = this.hnadsa;
        if (sharedPreferences == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsb, "Context may be empty, please initialize adSdk first", new Object[0]);
            return z;
        }
        return sharedPreferences.getBoolean(str, z);
    }

    public void hnadsa(String str, Set<String> set, boolean z) {
        SharedPreferences sharedPreferences = this.hnadsa;
        if (sharedPreferences == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsb, "Context may be empty, please initialize adSdk first", new Object[0]);
        } else if (z) {
            sharedPreferences.edit().putStringSet(str, set).commit();
        } else {
            sharedPreferences.edit().putStringSet(str, set).apply();
        }
    }

    public Set<String> hnadsa(String str, Set<String> set) {
        SharedPreferences sharedPreferences = this.hnadsa;
        if (sharedPreferences == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsb, "Context may be empty, please initialize adSdk first", new Object[0]);
            return set;
        }
        Set<String> stringSet = sharedPreferences.getStringSet(str, set);
        if (stringSet == null) {
            return new HashSet();
        }
        return new HashSet(stringSet);
    }

    public void hnadsa() {
        hnadsa(false);
    }

    public void hnadsa(boolean z) {
        SharedPreferences sharedPreferences = this.hnadsa;
        if (sharedPreferences == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsb, "Context may be empty, please initialize adSdk first", new Object[0]);
        } else if (z) {
            sharedPreferences.edit().clear().commit();
        } else {
            sharedPreferences.edit().clear().apply();
        }
    }

    public boolean hnadsa(String str) {
        SharedPreferences sharedPreferences = this.hnadsa;
        if (sharedPreferences == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsb, "Context may be empty, please initialize adSdk first", new Object[0]);
            return false;
        }
        return sharedPreferences.contains(str);
    }
}
