package com.cdo.oaps.ad.wrapper.download;

import com.cdo.oaps.ad.ag;
import com.cdo.oaps.ad.wrapper.ResourceWrapper;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class DownloadReqWrapper extends ResourceWrapper {
    public static final int TYPE_CANCEL = 3;
    public static final int TYPE_DOWNLOAD = 1;
    public static final int TYPE_PAUSE = 2;
    public static final int TYPE_QUERY = 4;
    public static final int TYPE_REGISTER_OBSERVER = 5;
    public static final int TYPE_RESERVE = 7;
    public static final int TYPE_UNREGISTER_OBSERVER = 6;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3135a = "dtp";
    private static final String c = "dsp";
    private static final String d = "dada";
    private static final String e = "dmc";

    protected DownloadReqWrapper(Map<String, Object> map) {
        super(map);
    }

    public static DownloadReqWrapper wrapper(Map<String, Object> map) {
        return new DownloadReqWrapper(map);
    }

    public boolean getAutoDelApk() {
        try {
            return 1 == getInt(d);
        } catch (ag unused) {
            return true;
        }
    }

    public int getDownloadMaxCount() {
        try {
            return getInt(e);
        } catch (ag unused) {
            return 2;
        }
    }

    public int getDownloadType() {
        try {
            return getInt(f3135a);
        } catch (ag unused) {
            return -1;
        }
    }

    public String getSaveDir() {
        try {
            return (String) get(c);
        } catch (ag unused) {
            return "";
        }
    }

    public DownloadReqWrapper setAutoDelApk(boolean z) {
        return (DownloadReqWrapper) set(d, Integer.valueOf(z ? 1 : 0));
    }

    public DownloadReqWrapper setDownloadMaxCount(int i) {
        return (DownloadReqWrapper) set(e, Integer.valueOf(i));
    }

    public DownloadReqWrapper setDownloadType(int i) {
        return (DownloadReqWrapper) set(f3135a, Integer.valueOf(i));
    }

    public DownloadReqWrapper setSaveDir(String str) {
        return (DownloadReqWrapper) set(c, str);
    }
}
