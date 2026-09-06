package com.meishu.sdk.core.utils;

import android.content.Context;
import com.google.gson.Gson;
import com.meishu.sdk.core.domain.LayoutBean;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/* JADX INFO: compiled from: CacheUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LayoutBean f4887a;

    /* JADX INFO: compiled from: CacheUtil.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f4888a = new c();
    }

    public LayoutBean a(Context context) {
        LayoutBean layoutBean = this.f4887a;
        if (layoutBean != null) {
            return layoutBean;
        }
        try {
            File file = new File(context.getExternalCacheDir().getAbsolutePath() + "/ms_cache", "ms_temp.json");
            if (!file.exists()) {
                return null;
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                stringBuffer.append(line);
            }
            bufferedReader.close();
            if (stringBuffer.toString().isEmpty()) {
                return null;
            }
            return (LayoutBean) new Gson().fromJson(stringBuffer.toString(), LayoutBean.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
