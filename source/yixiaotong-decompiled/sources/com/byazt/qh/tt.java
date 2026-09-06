package com.byazt.qh;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.byazt.aas.DeviceUtils;
import com.byazt.aas.rh;
import com.byazt.dna.u;
import com.byazt.nr.m;
import com.byazt.nr.sp;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.hihonor.adsdk.base.g.j.e.a;
import com.kuaishou.weapon.p0.g;
import com.meishu.sdk.core.view.DownloadView;
import com.ubixnow.ooooo.o0OO000o;
import com.umeng.analytics.pro.am;
import java.io.File;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_SESSION_ID, 13})
public class tt {
    public static String c;

    public static void c(JSONObject jSONObject) {
        if (p.x.equals(DownloadView.CLICK_DOWNLOAD_INFO_TYPE_PRIVACY)) {
            return;
        }
        try {
            com.byazt.fn.c location = ((u) com.byazt.ut.uj.getService("device_info_new")).getLocation(!com.byazt.by.c.tt());
            float longitude = 0.0f;
            float latitude = location == null ? 0.0f : location.getLatitude();
            if (location != null) {
                longitude = location.getLongitude();
            }
            jSONObject.put("latitude", latitude);
            jSONObject.put("longitude", longitude);
        } catch (JSONException e) {
            m.c(e);
        }
    }

    public static void c(com.byazt.dj.uj ujVar, List<String> list) {
        if (p.x.equals(DownloadView.CLICK_DOWNLOAD_INFO_TYPE_PRIVACY) || !ujVar.isCanUseLocation()) {
            return;
        }
        list.add(g.h);
        list.add("android.permission.ACCESS_FINE_LOCATION");
    }

    public static void tt(JSONObject jSONObject) {
        com.byazt.fn.c location;
        if (p.x.equals(DownloadView.CLICK_DOWNLOAD_INFO_TYPE_PRIVACY) || (location = ((u) com.byazt.ut.uj.getService("device_info_new")).getLocation(!com.byazt.by.c.tt())) == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("latitude", location.getLatitude());
            jSONObject2.put("longitude", location.getLongitude());
            jSONObject.put(a.H0, jSONObject2);
        } catch (Exception unused) {
        }
    }

    public static void ve(JSONObject jSONObject) {
        try {
            if (p.x.equals(DownloadView.CLICK_DOWNLOAD_INFO_TYPE_PRIVACY)) {
                jSONObject.put("imei_md5", tt());
            } else {
                jSONObject.put("imei", DeviceUtils.c((Boolean) null));
            }
        } catch (JSONException e) {
            m.c(e);
        }
    }

    private static String tt() {
        if (TextUtils.isEmpty(c)) {
            String strC = DeviceUtils.c((Boolean) null);
            if (!TextUtils.isEmpty(strC)) {
                c = com.byazt.nr.a.tt(strC);
            }
        }
        return c;
    }

    public static void c(Context context, JSONObject jSONObject) {
        try {
            if (p.x.equals(DownloadView.CLICK_DOWNLOAD_INFO_TYPE_PRIVACY)) {
                jSONObject.put("udid_md5", tt());
                return;
            }
            u uVar = (u) com.byazt.ut.uj.getService("device_info_new");
            jSONObject.put("udid", DeviceUtils.c((Boolean) null));
            jSONObject.put(am.A, uVar.getMacAddress(null));
        } catch (Exception e) {
            m.c(e);
        }
    }

    public static void tt(Context context, JSONObject jSONObject) {
        if (p.x.equals(DownloadView.CLICK_DOWNLOAD_INFO_TYPE_PRIVACY)) {
            return;
        }
        try {
            JSONArray jSONArrayC = rh.c(context);
            if (jSONArrayC != null) {
                jSONObject.put(o0OO000o.o00OoO0, jSONArrayC);
            }
        } catch (JSONException e) {
            m.c(e);
        }
    }

    public static void c() {
        if (p.x.equals(DownloadView.CLICK_DOWNLOAD_INFO_TYPE_PRIVACY)) {
            return;
        }
        ((u) com.byazt.ut.uj.getService("device_info_new")).getLocation(!com.byazt.by.c.tt());
    }

    public static void c(String str) {
        if (p.x.equals(DownloadView.CLICK_DOWNLOAD_INFO_TYPE_PRIVACY)) {
            return;
        }
        com.byazt.ogz.ve.tt().c(str);
    }

    public static boolean tt(String str) {
        if (p.x.equals(DownloadView.CLICK_DOWNLOAD_INFO_TYPE_PRIVACY)) {
            return false;
        }
        return rh.c(str);
    }

    public static void c(Context context) {
        if (p.x.equals(DownloadView.CLICK_DOWNLOAD_INFO_TYPE_PRIVACY) || (gt.tt().rp() & 8) != 0) {
            return;
        }
        c.c(context);
    }

    public static File tt(Context context) {
        if (p.x.equals(DownloadView.CLICK_DOWNLOAD_INFO_TYPE_PRIVACY)) {
            return sp.c(context, "Download/Pangolin", false, null);
        }
        return sp.c(context, Environment.DIRECTORY_DOWNLOADS, false, null);
    }
}
