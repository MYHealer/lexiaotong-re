package com.opos.mobad.j.a;

import com.huawei.openalliance.ad.constant.br;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadModel;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c {
    public static int a(Map<String, String> map) {
        try {
            return Integer.parseInt(map.get(br.f.m));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("VideoPlayerUtils", "getErrCode", e);
            return -1;
        }
    }

    public static String b(Map<String, String> map) {
        return (map == null || !map.containsKey(FileDownloadModel.ERR_MSG)) ? "" : map.get(FileDownloadModel.ERR_MSG);
    }

    public static String c(Map<String, String> map) {
        return (map == null || !map.containsKey("playerType")) ? "" : map.get("playerType");
    }

    public static String d(Map<String, String> map) {
        return (map == null || !map.containsKey("errType")) ? "" : map.get("errType");
    }
}
