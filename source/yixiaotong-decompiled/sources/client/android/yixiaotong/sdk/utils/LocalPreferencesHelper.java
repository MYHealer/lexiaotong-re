package client.android.yixiaotong.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class LocalPreferencesHelper {
    private SharedPreferences mSharedPreferences;

    public LocalPreferencesHelper(Context context, String str) {
        this.mSharedPreferences = context.getSharedPreferences(str, 0);
    }

    public void saveOrUpdate(String str, String str2) {
        this.mSharedPreferences.edit().putString(str, str2).commit();
    }

    public void saveOrUpdate(String str, int i) {
        this.mSharedPreferences.edit().putInt(str, i).commit();
    }

    public void saveOrUpdate(String str, float f) {
        this.mSharedPreferences.edit().putFloat(str, f).commit();
    }

    public void saveOrUpdate(String str, boolean z) {
        this.mSharedPreferences.edit().putBoolean(str, z).commit();
    }

    public void saveOrUpdate(String str, long j) {
        this.mSharedPreferences.edit().putLong(str, j).commit();
    }

    public void del(String str) {
        this.mSharedPreferences.edit().remove(str).commit();
    }

    public float getFloat(String str) {
        return this.mSharedPreferences.getFloat(str, 0.0f);
    }

    public String getString(String str) {
        return this.mSharedPreferences.getString(str, "");
    }

    public boolean getBooleanDefaultFalse(String str) {
        return this.mSharedPreferences.getBoolean(str, false);
    }

    public boolean getBooleanDefaultTrue(String str) {
        return this.mSharedPreferences.getBoolean(str, true);
    }

    public int getInt(String str) {
        return this.mSharedPreferences.getInt(str, 0);
    }

    public int getInt(String str, int i) {
        return this.mSharedPreferences.getInt(str, i);
    }

    public long getLong(String str) {
        return this.mSharedPreferences.getLong(str, 0L);
    }

    public long getLong(String str, long j) {
        return this.mSharedPreferences.getLong(str, j);
    }
}
