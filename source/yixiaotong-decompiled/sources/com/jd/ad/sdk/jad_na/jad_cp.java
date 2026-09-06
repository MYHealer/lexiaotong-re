package com.jd.ad.sdk.jad_na;

import android.text.TextUtils;
import com.jd.ad.sdk.dl.model.IJADExtra;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: JADAdDataManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_cp {
    public final ConcurrentHashMap<String, String> jad_an = new ConcurrentHashMap<>();
    public final ConcurrentHashMap<String, IJADExtra> jad_bo = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: JADAdDataManager.java */
    public static class jad_an {
        public static final jad_cp jad_an = new jad_cp();
    }

    public String jad_an(String str) {
        String str2 = this.jad_an.get(str);
        return TextUtils.isEmpty(str2) ? "" : str2;
    }
}
