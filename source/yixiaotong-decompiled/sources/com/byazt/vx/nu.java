package com.byazt.vx;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 962, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME})
public class nu {
    public static final HashSet c = new HashSet(Arrays.asList("dalvik.system.VMStack.getThreadStackTrace", "java.lang.Thread.getStackTrace"));

    public static String c() {
        StackTraceElement[] stackTrace;
        try {
            stackTrace = Thread.currentThread().getStackTrace();
        } catch (Throwable unused) {
            stackTrace = null;
        }
        if (stackTrace == null || stackTrace.length == 0) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (stackTraceElement != null && !c.contains(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName())) {
                    String className = stackTraceElement.getClassName();
                    if (className != null && className.startsWith("android.app")) {
                        break;
                    }
                    jSONArray.put(stackTraceElement.toString());
                }
            }
            return jSONArray.toString();
        } catch (OutOfMemoryError e) {
            com.byazt.nr.m.c(e);
            return "";
        }
    }

    public static String c(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (String str : map.keySet()) {
            if (c(map.get(str))) {
                jSONArray.put(str);
            }
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        try {
            return jSONArray.toString();
        } catch (OutOfMemoryError e) {
            com.byazt.nr.m.c(e);
            return "";
        }
    }

    private static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return Class.forName(str) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String tt() {
        StackTraceElement[] stackTrace;
        Map<String, List<String>> mapHd;
        try {
            stackTrace = Thread.currentThread().getStackTrace();
        } catch (Throwable unused) {
            stackTrace = null;
        }
        if (stackTrace != null && stackTrace.length != 0 && (mapHd = com.byazt.bp.tt.tt().hd()) != null && !mapHd.isEmpty()) {
            for (String str : mapHd.keySet()) {
                if (c(mapHd.get(str), stackTrace)) {
                    return str;
                }
            }
        }
        return null;
    }

    private static boolean c(List<String> list, StackTraceElement[] stackTraceElementArr) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                    if (list.get(i) != null) {
                        try {
                            if (stackTraceElement.toString().contains(list.get(i))) {
                                return true;
                            }
                        } catch (OutOfMemoryError e) {
                            com.byazt.nr.m.c(e);
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean c(com.byazt.yl.ve veVar) {
        if (veVar == null || !veVar.isCustomAd()) {
            return false;
        }
        return uj();
    }

    public static boolean c(com.byazt.nbs.da daVar) {
        if (daVar == null || !daVar.sv()) {
            return false;
        }
        return uj();
    }

    private static boolean uj() {
        Map<String, List<String>> mapHd = com.byazt.bp.tt.tt().hd();
        if (mapHd == null || mapHd.size() == 0) {
            return false;
        }
        return c(com.byazt.bp.tt.tt().bm());
    }

    public static boolean c(double d) {
        return d > 0.0d && Math.random() <= d;
    }

    public static double ve() {
        return com.byazt.bp.tt.tt().bm();
    }
}
