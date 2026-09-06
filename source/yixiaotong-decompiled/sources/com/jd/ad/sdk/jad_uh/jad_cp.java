package com.jd.ad.sdk.jad_uh;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.jd.ad.sdk.jad_qd.jad_jw;
import com.jd.ad.sdk.jad_xk.jad_fs;
import com.jd.ad.sdk.logger.Logger;
import com.ubixnow.ooooo.oOOOoo00;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: PreferenceUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_cp {
    public static boolean jad_an(jad_dq jad_dqVar, String str, Object obj) {
        try {
            boolean zJad_dq = jad_jw.jad_dq(com.jd.ad.sdk.jad_fq.jad_cp.jad_an());
            if ((zJad_dq && jad_dqVar == null) || TextUtils.isEmpty(str) || obj == null) {
                return false;
            }
            if (!zJad_dq) {
                jad_an(str, obj);
                return true;
            }
            if (obj instanceof String) {
                jad_dqVar.jad_an.edit().putString(str, (String) obj).apply();
                return true;
            }
            if (obj instanceof Long) {
                jad_dqVar.jad_an.edit().putLong(str, ((Long) obj).longValue()).apply();
                return true;
            }
            if (obj instanceof Float) {
                jad_dqVar.jad_an.edit().putFloat(str, ((Float) obj).floatValue()).apply();
                return true;
            }
            if (obj instanceof Integer) {
                jad_dqVar.jad_an.edit().putInt(str, ((Integer) obj).intValue()).apply();
                return true;
            }
            if (obj instanceof Boolean) {
                jad_dqVar.jad_an.edit().putBoolean(str, ((Boolean) obj).booleanValue()).apply();
                return true;
            }
            if (obj instanceof Set) {
                jad_dqVar.jad_an.edit().putStringSet(str, (Set) obj).apply();
                return true;
            }
            return false;
        } catch (Exception e) {
            Logger.w(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while sp put: ").append(e.getMessage()).toString(), new Object[0]);
        }
    }

    public static Object jad_an(jad_dq jad_dqVar, String str, Class<?> cls) {
        try {
            if (jad_jw.jad_dq(com.jd.ad.sdk.jad_fq.jad_cp.jad_an())) {
                if (jad_dqVar == null || TextUtils.isEmpty(str) || cls == null) {
                    return null;
                }
                if (cls == Integer.TYPE) {
                    return Integer.valueOf(jad_dqVar.jad_an.getInt(str, -1));
                }
                if (cls == Long.TYPE) {
                    return Long.valueOf(jad_dqVar.jad_an.getLong(str, -1L));
                }
                if (cls == Float.TYPE) {
                    return Float.valueOf(jad_dqVar.jad_an.getFloat(str, -1.0f));
                }
                if (cls == Boolean.TYPE) {
                    return Boolean.valueOf(jad_dqVar.jad_an.getBoolean(str, false));
                }
                if (cls == Set.class) {
                    return jad_dqVar.jad_an.getStringSet(str, Collections.emptySet());
                }
                return jad_dqVar.jad_an.getString(str, "");
            }
            return jad_an(str, cls);
        } catch (Exception e) {
            Logger.w(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while sp get: ").append(e.getMessage()).toString(), new Object[0]);
            return null;
        }
    }

    public static void jad_an(String str, Object obj) {
        try {
            ContentResolver contentResolverJad_an = jad_an();
            if (contentResolverJad_an == null) {
                return;
            }
            Uri uri = Uri.parse(com.jd.ad.sdk.jad_tg.jad_an.jad_bo() + "sp_jadyunsdk/update");
            ContentValues contentValues = new ContentValues();
            contentValues.put("key", str);
            if (obj instanceof String) {
                contentValues.put("type_object", TypedValues.Custom.S_STRING);
                contentValues.put(oOOOoo00.OooOo0o, (String) obj);
            } else if (obj instanceof Long) {
                contentValues.put("type_object", "long");
                contentValues.put(oOOOoo00.OooOo0o, (Long) obj);
            } else if (obj instanceof Float) {
                contentValues.put("type_object", TypedValues.Custom.S_FLOAT);
                contentValues.put(oOOOoo00.OooOo0o, (Float) obj);
            } else if (obj instanceof Integer) {
                contentValues.put("type_object", IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
                contentValues.put(oOOOoo00.OooOo0o, (Integer) obj);
            } else if (obj instanceof Boolean) {
                contentValues.put("type_object", TypedValues.Custom.S_BOOLEAN);
                contentValues.put(oOOOoo00.OooOo0o, (Boolean) obj);
            } else if (obj instanceof Set) {
                HashSet hashSet = new HashSet();
                Iterator it = ((Set) obj).iterator();
                while (it.hasNext()) {
                    hashSet.add(((String) it.next()).replace(",", "__COMMA__"));
                }
                contentValues.put("type_object", "string_set");
                contentValues.put(oOOOoo00.OooOo0o, hashSet.toString());
            }
            contentResolverJad_an.update(uri, contentValues, null, null);
        } catch (Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_SP_UPDATE_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        }
    }

    public static Object jad_an(String str, Class<?> cls) {
        String str2;
        try {
            StringBuilder sbAppend = new StringBuilder().append(com.jd.ad.sdk.jad_tg.jad_an.jad_bo()).append("sp_jadyunsdk/get/");
            Class<?> cls2 = Integer.TYPE;
            if (cls == cls2) {
                str2 = IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL;
            } else if (cls == Long.TYPE) {
                str2 = "long";
            } else if (cls == Float.TYPE) {
                str2 = TypedValues.Custom.S_FLOAT;
            } else if (cls == Boolean.TYPE) {
                str2 = TypedValues.Custom.S_BOOLEAN;
            } else {
                str2 = cls == Set.class ? "string_set" : TypedValues.Custom.S_STRING;
            }
            Uri uri = Uri.parse(sbAppend.append(str2).append("/").append(str).toString());
            ContentResolver contentResolverJad_an = jad_an();
            if (contentResolverJad_an == null) {
                return null;
            }
            String type = contentResolverJad_an.getType(uri);
            if (cls == cls2) {
                if (type != null && !type.equals("null")) {
                    return Integer.valueOf(Integer.parseInt(type));
                }
                return -1;
            }
            if (cls == Long.TYPE) {
                if (type != null && !type.equals("null")) {
                    return Long.valueOf(Long.parseLong(type));
                }
                return -1L;
            }
            if (cls == Float.TYPE) {
                if (type != null && !type.equals("null")) {
                    return Float.valueOf(Float.parseFloat(str));
                }
                return Float.valueOf(-1.0f);
            }
            if (cls == Boolean.TYPE) {
                if (type != null && !type.equals("null")) {
                    return Boolean.valueOf(Boolean.parseBoolean(type));
                }
                return Boolean.FALSE;
            }
            if (cls != Set.class) {
                return (type == null || type.equals("null")) ? "" : type;
            }
            if (type == null || type.equals("null") || !type.matches("\\[.*\\]")) {
                return "";
            }
            String[] strArrSplit = type.substring(1, type.length() - 1).split(", ");
            HashSet hashSet = new HashSet();
            for (String str3 : strArrSplit) {
                hashSet.add(str3.replace("__COMMA__", ", "));
            }
            return hashSet;
        } catch (Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_SP_GET_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
            return null;
        }
    }

    public static ContentResolver jad_an() {
        try {
            return com.jd.ad.sdk.jad_fq.jad_cp.jad_an().getContentResolver();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean jad_an(String str) {
        try {
            Uri uri = Uri.parse(com.jd.ad.sdk.jad_tg.jad_an.jad_bo() + "sp_jadyunsdk/contain/" + str);
            ContentResolver contentResolverJad_an = jad_an();
            if (contentResolverJad_an == null) {
                return false;
            }
            String type = contentResolverJad_an.getType(uri);
            if (TextUtils.isEmpty(type)) {
                return false;
            }
            return Boolean.parseBoolean(type);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
