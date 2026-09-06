package com.cdo.oaps.ad.wrapper;

import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.ag;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class SearchWrapper extends BaseWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3132a;
    private String c;
    private String d;
    private String e;

    protected SearchWrapper(Map<String, Object> map) {
        super(map);
        this.f3132a = "sfl";
        this.c = "shi";
        this.d = "sfr";
        this.e = "sfi";
    }

    public static SearchWrapper wrapper(Map<String, Object> map) {
        return new SearchWrapper(map);
    }

    public boolean getAutoDown() {
        try {
            return getBoolean("ad");
        } catch (ag unused) {
            return false;
        }
    }

    public String getChannelPkg() {
        try {
            return (String) get(OapsKey.KEY_CHANEL_PKG);
        } catch (ag unused) {
            return "";
        }
    }

    public String getKeyword() {
        try {
            return (String) get(OapsKey.KEY_KEYWORD);
        } catch (ag unused) {
            return "";
        }
    }

    public String getPkgName() {
        try {
            return (String) get(OapsKey.KEY_PKG);
        } catch (ag unused) {
            return "";
        }
    }

    public String getSearchFlag() {
        try {
            return (String) get(this.f3132a);
        } catch (ag unused) {
            return "";
        }
    }

    public String getSearchFrom() {
        try {
            return (String) get(this.d);
        } catch (ag unused) {
            return "";
        }
    }

    public String getSearchFromId() {
        try {
            return (String) get(this.e);
        } catch (ag unused) {
            return "";
        }
    }

    public String getSearchHint() {
        try {
            return (String) get(this.c);
        } catch (ag unused) {
            return "";
        }
    }

    public String getTraceId() {
        try {
            return (String) get("traceId");
        } catch (ag unused) {
            return "";
        }
    }

    public SearchWrapper setAutoDown(boolean z) {
        return (SearchWrapper) set("ad", Boolean.valueOf(z));
    }

    public SearchWrapper setChannelPkg(String str) {
        return (SearchWrapper) set(OapsKey.KEY_CHANEL_PKG, str);
    }

    public SearchWrapper setKeyword(String str) {
        return (SearchWrapper) set(OapsKey.KEY_KEYWORD, str);
    }

    public SearchWrapper setPkgName(String str) {
        return (SearchWrapper) set(OapsKey.KEY_PKG, str);
    }

    public SearchWrapper setSearchFlag(String str) {
        return (SearchWrapper) set(this.f3132a, str);
    }

    public SearchWrapper setSearchFrom(String str) {
        return (SearchWrapper) set(this.d, str);
    }

    public SearchWrapper setSearchFromId(String str) {
        return (SearchWrapper) set(this.e, str);
    }

    public SearchWrapper setSearchHint(String str) {
        return (SearchWrapper) set(this.c, str);
    }

    public ResourceWrapper setTraceId(String str) {
        return (ResourceWrapper) set("traceId", str);
    }
}
