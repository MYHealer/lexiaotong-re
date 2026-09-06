package com.cdo.oaps.ad.wrapper;

import android.net.Uri;
import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.ag;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class WebWrapper extends BaseWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3134a = "wtic";

    protected WebWrapper(Map<String, Object> map) {
        super(map);
    }

    public static WebWrapper wrapper(Map<String, Object> map) {
        return new WebWrapper(map);
    }

    public String getHybrid() {
        try {
            return Uri.decode((String) get(OapsKey.KEY_HYBRID));
        } catch (ag unused) {
            return "";
        }
    }

    public String getTitle() {
        try {
            return (String) get("t");
        } catch (ag unused) {
            return "";
        }
    }

    public String getUrl() {
        try {
            return Uri.decode((String) get("u"));
        } catch (ag unused) {
            return "";
        }
    }

    public int getWebTitleIconColor() {
        try {
            return getInt(f3134a);
        } catch (ag unused) {
            return 0;
        }
    }

    public WebWrapper setHybrid(String str) {
        return (WebWrapper) set(OapsKey.KEY_HYBRID, Uri.encode(str));
    }

    public WebWrapper setTitle(String str) {
        return (WebWrapper) set("t", str);
    }

    public WebWrapper setUrl(String str) {
        return (WebWrapper) set("u", Uri.encode(str));
    }

    public WebWrapper setWebTitleIconColor(int i) {
        return (WebWrapper) set(f3134a, Integer.valueOf(i));
    }
}
