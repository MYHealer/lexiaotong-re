package com.hihonor.hianalytics.util;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.hihonor.hianalytics.hnha.j2;
import com.hihonor.hianalytics.hnha.z0;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class o {
    public static int a(int i, int i2, int i3) {
        if (i > i2) {
            j2.g("ParamCheckUtils", "checkIntRange overLargeValue=" + i + ",rangeMax=" + i2);
            return i2;
        }
        if (i >= i3) {
            return i;
        }
        j2.g("ParamCheckUtils", "checkIntRange overSmallValue=" + i + ",rangeMin=" + i3);
        return i3;
    }

    public static int a(String str, int i, z0 z0Var) {
        if (i == 2) {
            if ("_default_config_tag".equals(str)) {
                return 0;
            }
            j2.g("ParamCheckUtils", "checkConfig haTag=" + str + ",type=" + i + ",Only default config can report Pre-install data");
            return 257;
        }
        if (z0Var == null) {
            j2.g("ParamCheckUtils", "checkConfig haTag=" + str + ",type=" + i + ",config=null");
            return 258;
        }
        if (!TextUtils.isEmpty(z0Var.d())) {
            return 0;
        }
        j2.g("ParamCheckUtils", "checkConfig haTag=" + str + ",type=" + i + ",emptyConfigUrl");
        return 259;
    }

    public static int a(String str, String str2, int i) {
        if (TextUtils.isEmpty(str2)) {
            j2.g("ParamCheckUtils", "checkStrLen emptyDataWithFlag=" + str);
            return 17;
        }
        if (str2.length() <= i) {
            return 0;
        }
        j2.g("ParamCheckUtils", "checkStrLen overLenDataWithFlag=" + str);
        return 18;
    }

    public static String a(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str2)) {
            return a(str, str2, str3) ? str2 : str4;
        }
        j2.g("ParamCheckUtils", "checkString3 emptyDataWithFlag=" + str);
        return str4;
    }

    public static Map<String, String> a(Map<String, String> map) {
        return a(map, 10, 128L, 512L, "x_");
    }

    public static Map<String, String> a(Map<String, String> map, int i, long j, long j2, String str) {
        StringBuilder sbAppend;
        StringBuilder sbAppend2;
        int size = map == null ? 0 : map.size();
        if (size == 0) {
            sbAppend2 = new StringBuilder("checkMap emptyHeaderMapValue=").append(map);
        } else {
            if (size <= i) {
                HashMap map2 = new HashMap();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (TextUtils.isEmpty(key) || key.length() > j) {
                        sbAppend = new StringBuilder("checkMap illegalKey=").append(key);
                        j2.g("ParamCheckUtils", sbAppend.toString());
                    } else {
                        if (TextUtils.isEmpty(str) || key.startsWith(str)) {
                            String value = entry.getValue();
                            int length = value == null ? 0 : value.length();
                            if (TextUtils.isEmpty(value) || length > j2) {
                                sbAppend = new StringBuilder("checkMap illegalKey=").append(key).append(",overValueLen=").append(length);
                            } else {
                                map2.put(key, entry.getValue());
                            }
                        } else {
                            sbAppend = new StringBuilder("checkMap illegalKey=").append(key).append(",keyword=").append(str);
                        }
                        j2.g("ParamCheckUtils", sbAppend.toString());
                    }
                }
                return map2;
            }
            sbAppend2 = new StringBuilder("checkMap tooBigSize=").append(size).append(",limitMapSize=").append(i);
        }
        j2.g("ParamCheckUtils", sbAppend2.toString());
        return null;
    }

    public static boolean a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            j2.g("ParamCheckUtils", "checkString2 emptyDataWithFlag=" + str);
            return false;
        }
        try {
            if (Pattern.compile(str3).matcher(str2).matches()) {
                return true;
            }
            j2.g("ParamCheckUtils", "checkString2 notMatchPatternWithFlag=" + str);
        } catch (Throwable th) {
            j2.g("ParamCheckUtils", "checkString2 flag=" + str + " failE=" + SystemUtils.getDesensitizedException(th));
        }
        return false;
    }

    public static Map<String, String> b(Map<String, String> map) {
        return a(map, 50, 1024L, 1024L, "x-hasdk");
    }

    public static boolean b(String str, String str2, int i) {
        return a(str, str2, i) == 0;
    }

    public static boolean c(Map<String, String> map) {
        return d(map) == 0;
    }

    public static int d(Map<String, String> map) {
        int size = map == null ? 0 : map.size();
        if (size == 0) {
            j2.g("ParamCheckUtils", "checkMap emptyMapValue=" + map);
            return MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT;
        }
        if (size == 1) {
            if (map.get("constants") != null) {
                j2.g("ParamCheckUtils", "checkMap key can't be constants");
                return 516;
            }
            if (map.get("_constants") != null) {
                j2.g("ParamCheckUtils", "checkMap key can't be _constants");
                return MediaPlayer.MEDIA_PLAYER_OPTION_FILE_SIZE;
            }
        }
        int length = map.toString().length();
        if (size > 2048) {
            j2.g("ParamCheckUtils", "checkMap dataTooBig withSize1=" + size + ",len=" + length);
            return MediaPlayer.MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS;
        }
        if (length <= 204800) {
            return 0;
        }
        j2.g("ParamCheckUtils", "checkMap dataTooBig withSize2=" + size + ",len=" + length);
        return MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CURRENT_DOWNLOAD_INDEX;
    }
}
