package com.ubixnow.ooooo;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ubixnow.utils.BaseUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oOO00O {
    public static final String OooO = "jd_shake_sensitive";
    public static String OooO00o = "10100000110101011010000011001101101000001111111110100000110000111010000011010100101000001101001010100000111111111010000011010100101000001101100110100000110100001010000011000101";
    public static String OooO0O0 = "101000001101010110100000110011011010000011111111101000001100001110100000110101001010000011010010101000001111111110100000110100001010000011000101101000001101001010100000110000111010000011000101101000001100111010100000110101001010000011111111101000001100110110100000110010011010000011001110";
    public static String OooO0OO = "101000001101010110100000110011011010000011111111101000001100001110100000110101001010000011010010101000001111111110100000110100001010000011000101101000001101001010100000110000111010000011000101101000001100111010100000110101001010000011111111101000001100110110100000110000011010000011011000";
    public static String OooO0Oo = "1010000011010101101000001100110110100000111111111010000011000011101000001101010010100000110100101010000011111111101000001100110010100000110010011010000011001101101000001100100110100000110101001010000011111111101000001100110110100000110000011010000011011000";
    public static String OooO0o = "1010000011010101101000001100110110100000111111111010000011000011101000001101010010100000110100101010000011111111101000001101001010100000110001011010000011000111101000001100100110100000110011111010000011001110";
    public static String OooO0o0 = "10100000110101011010000011001101101000001111111110100000110000111010000011010100101000001101001010100000111111111010000011010100101000001100100110100000110011011010000011000101101000001111111110100000110010011010000011001110101000001101010010100000110001011010000011010010101000001101011010100000110000011010000011001100";
    public static String OooO0oO = "101000001101010110100000110011011010000011111111101000001100001110100000110101001010000011010010101000001111111110100000110100111010000011001011101000001100100110100000110100001010000011111111101000001101001010100000110001011010000011000111101000001100100110100000110011111010000011001110";
    public static final String OooO0oo = "banner_refresh_time";
    public static final String OooOO0 = "2";
    public static final String OooOO0O = "3";
    public static final String OooOO0o = "1";
    public static final String OooOOO = "3";
    public static final String OooOOO0 = "2";
    private static final String OooOOOO = "------SdkPlusConfig";
    public static boolean OooOOOo;
    public static int OooOOo0;
    public boolean OooOoO;
    public boolean OooOoO0;
    public boolean OooOoOO;
    public int Oooo;
    public boolean OoooO0;
    public int OoooO00;
    public int OoooO0O;
    public int OooOOo = 0;
    public int OooOOoo = -1;
    public int OooOo00 = -1;
    public int OooOo0 = 0;
    public long OooOo0O = 0;
    public ArrayList<Integer> OooOo0o = new ArrayList<>();
    public ArrayList<Integer> OooOo = new ArrayList<>();
    public int OooOoo0 = 30;
    public float OooOoo = 0.5f;
    public String OooOooO = "";
    public int OooOooo = 1;
    public double Oooo000 = 1.0d;
    public int Oooo00O = 0;
    public int Oooo00o = 2;
    public String Oooo0 = "1";
    public boolean Oooo0O0 = false;
    public boolean Oooo0OO = true;
    public String Oooo0o0 = "";
    public int Oooo0o = 0;
    public String Oooo0oO = "";
    public long Oooo0oo = 0;

    private static void OooO(JSONObject jSONObject, oOO00O ooo00o) {
        try {
            if (OooO00o(jSONObject, "n_r_c_s")) {
                ooo00o.OoooO0O = Integer.parseInt(jSONObject.optString("n_r_c_s"));
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    private static long OooO00o() {
        String str = oO00000o.o00O0O.OooOo00;
        if (!TextUtils.isEmpty(str)) {
            try {
                if ("0".equals(str)) {
                    return 0L;
                }
                long j = (long) (Double.parseDouble(str) * 1000.0d);
                if (j > 0) {
                    return j;
                }
            } catch (Throwable unused) {
            }
        }
        return 259200000L;
    }

    public static oOO00O OooO00o(String str, o00O0 o00o0) {
        oOO00O ooo00o = new oOO00O();
        try {
            if (!TextUtils.isEmpty(str)) {
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0O0("----json", str);
                }
                JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("advCo");
                if (jSONObjectOptJSONObject != null) {
                    if (!h1.OooO0O0().OooO0OO() && OooOOOo) {
                        if (Objects.equals(o00o0.OooO0Oo.OooO0O0, "1")) {
                            OooO00o(jSONObjectOptJSONObject, ooo00o, o0oOO.OooO00o(str));
                            OooOOo0(jSONObjectOptJSONObject, ooo00o);
                            OooO00o(ooo00o);
                        } else if (Objects.equals(o00o0.OooO0Oo.OooO0O0, "5")) {
                            OooOOOo(jSONObjectOptJSONObject, ooo00o);
                        } else if (Objects.equals(o00o0.OooO0Oo.OooO0O0, "3")) {
                            OooOOo(jSONObjectOptJSONObject, ooo00o);
                        } else if (Objects.equals(o00o0.OooO0Oo.OooO0O0, "03")) {
                            OooOOoo(jSONObjectOptJSONObject, ooo00o);
                        }
                    }
                    OooO00o(jSONObjectOptJSONObject, ooo00o);
                    OooO0O0(jSONObjectOptJSONObject, ooo00o);
                    OooO0o0(jSONObjectOptJSONObject, ooo00o);
                    OooOO0o(jSONObjectOptJSONObject, ooo00o);
                    OooO0oO(jSONObjectOptJSONObject, ooo00o);
                    OooOOO0(jSONObjectOptJSONObject, ooo00o);
                    OooOOO(jSONObjectOptJSONObject, ooo00o);
                    OooO0oo(jSONObjectOptJSONObject, ooo00o);
                    OooO0Oo(jSONObjectOptJSONObject, ooo00o);
                    OooOO0O(jSONObjectOptJSONObject, ooo00o);
                    OooO0o(jSONObjectOptJSONObject, ooo00o);
                    OooOO0(jSONObjectOptJSONObject, ooo00o);
                    OooO(jSONObjectOptJSONObject, ooo00o);
                }
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
        return ooo00o;
    }

    public static void OooO00o(long j) {
        boolean z;
        try {
            if (!OooOOOo && j > 0) {
                long jOooO0Oo = oOo00o00.OooO0Oo(oO00000o.o00000O0.Oooo00o);
                if (jOooO0Oo <= 0) {
                    oOo00o00.OooO00o(oO00000o.o00000O0.Oooo00o, j);
                    return;
                }
                long jOooO00o = OooO00o();
                if (OooOOo0 == 1) {
                    z = j - jOooO0Oo > jOooO00o;
                    OooOOOo = z;
                    if (!z) {
                        return;
                    }
                } else {
                    if (jOooO0Oo > j) {
                        oOo00o00.OooO00o(oO00000o.o00000O0.Oooo00o, j);
                        return;
                    }
                    z = j - jOooO0Oo > jOooO00o;
                    OooOOOo = z;
                    if (!z) {
                        return;
                    }
                }
                oOo00o00.OooO00o(oO00000o.o00000O0.Oooo00O, Boolean.TRUE);
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    private static void OooO00o(oOO00O ooo00o) {
        if (!ooo00o.OooOoO0 || ooo00o.OooOo.size() == 4) {
            return;
        }
        ooo00o.OooOo.clear();
        ooo00o.OooOo.add(0, 300);
        ooo00o.OooOo.add(1, Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL));
        ooo00o.OooOo.add(2, 0);
        ooo00o.OooOo.add(3, 100);
    }

    private static void OooO00o(JSONObject jSONObject, oOO00O ooo00o) {
        try {
            if (OooO00o(jSONObject, "check_material")) {
                ooo00o.Oooo00O = Integer.parseInt(jSONObject.optString("check_material"));
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    private static void OooO00o(JSONObject jSONObject, oOO00O ooo00o, int i) {
        if (jSONObject != null) {
            try {
                String strOptString = jSONObject.optString(OooO00o);
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                int i2 = Integer.parseInt(strOptString);
                ooo00o.OooOOo = i2;
                if (i2 == 1 || i2 == 2) {
                    String strOptString2 = jSONObject.optString(OooO0O0);
                    if (TextUtils.isEmpty(strOptString2)) {
                        return;
                    }
                    int i3 = Integer.parseInt(strOptString2);
                    ooo00o.OooOOoo = i3;
                    if (i3 >= 0 && i3 <= 10000) {
                        String strOptString3 = jSONObject.optString(OooO0OO);
                        if (TextUtils.isEmpty(strOptString3)) {
                            return;
                        }
                        int i4 = Integer.parseInt(strOptString3);
                        ooo00o.OooOo00 = i4;
                        if (i4 > 0 && i4 <= 10000 && ooo00o.OooOOoo <= i4) {
                            String strOptString4 = jSONObject.optString(OooO0Oo);
                            if (TextUtils.isEmpty(strOptString4)) {
                                ooo00o.OooOo0 = 0;
                            } else {
                                int i5 = Integer.parseInt(strOptString4);
                                ooo00o.OooOo0 = i5;
                                if (i5 < 0) {
                                    return;
                                }
                            }
                            String strOptString5 = jSONObject.optString(OooO0o0);
                            if (TextUtils.isEmpty(strOptString5)) {
                                ooo00o.OooOo0O = 0L;
                            } else {
                                long j = Integer.parseInt(strOptString5);
                                ooo00o.OooOo0O = j;
                                if (j < 0) {
                                    return;
                                }
                            }
                            if (i != 2) {
                                String strOptString6 = jSONObject.optString(OooO0o);
                                ooo00o.OooOooO = strOptString6;
                                if (TextUtils.isEmpty(strOptString6)) {
                                    return;
                                }
                                String[] strArrSplit = ooo00o.OooOooO.split("_");
                                if (strArrSplit.length != 4) {
                                    return;
                                }
                                for (int i6 = 0; i6 < 4; i6++) {
                                    int i7 = Integer.parseInt(strArrSplit[i6]);
                                    if (i6 == 0 && (i7 <= 0 || i7 > 360)) {
                                        return;
                                    }
                                    if (i6 == 1 && (i7 <= 0 || i7 > 360)) {
                                        return;
                                    }
                                    if (i6 == 2 && (i7 <= 0 || i7 > 640)) {
                                        return;
                                    }
                                    if (i6 == 3 && (i7 <= 0 || i7 > 640)) {
                                        return;
                                    }
                                    ooo00o.OooOo0o.add(Integer.valueOf(i7));
                                }
                                if (ooo00o.OooOo0o.get(0).intValue() > ooo00o.OooOo0o.get(1).intValue() || ooo00o.OooOo0o.get(2).intValue() > ooo00o.OooOo0o.get(3).intValue()) {
                                    ooo00o.OooOo0o.clear();
                                    return;
                                }
                            }
                            ooo00o.OooOoO0 = true;
                            if (i != 2) {
                                String strOptString7 = jSONObject.optString(OooO0oO);
                                if (!TextUtils.isEmpty(strOptString7)) {
                                    String[] strArrSplit2 = strOptString7.split("_");
                                    if (strArrSplit2.length != 4) {
                                        return;
                                    }
                                    for (int i8 = 0; i8 < 4; i8++) {
                                        int i9 = Integer.parseInt(strArrSplit2[i8]);
                                        if (i8 == 0 && (i9 <= 0 || i9 > 360)) {
                                            return;
                                        }
                                        if (i8 == 1 && (i9 <= 0 || i9 > 360)) {
                                            return;
                                        }
                                        if (i8 == 2 && (i9 <= 0 || i9 > 640)) {
                                            return;
                                        }
                                        if (i8 == 3 && (i9 <= 0 || i9 > 640)) {
                                            return;
                                        }
                                        ooo00o.OooOo.add(Integer.valueOf(i9));
                                    }
                                    if (ooo00o.OooOo.get(0).intValue() > ooo00o.OooOo.get(1).intValue() || ooo00o.OooOo.get(2).intValue() > ooo00o.OooOo.get(3).intValue()) {
                                        ooo00o.OooOo.clear();
                                        return;
                                    }
                                }
                            }
                            ooooO000.OooO0O0("----json", ooooO000.OooO0OO("k6"));
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean OooO00o(String str) {
        try {
            return !TextUtils.isEmpty(str) && "1".equals(new JSONObject(str).optJSONObject("advCo").optString("splash_plus"));
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean OooO00o(JSONObject jSONObject, String str) {
        return (jSONObject == null || TextUtils.isEmpty(jSONObject.optString(str))) ? false : true;
    }

    public static int[] OooO00o(String str, HashMap<String, String> map) {
        int i;
        int iNextInt;
        int i2;
        int i3;
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("advCo");
            ooooO000.OooO0O0("----getVCCon", " advCo: " + jSONObjectOptJSONObject);
            if (jSONObjectOptJSONObject == null) {
                i = 0;
                return new int[i];
            }
            String strOptString = jSONObjectOptJSONObject.optString(OooO00o);
            if (TextUtils.isEmpty(strOptString)) {
                return new int[0];
            }
            int i4 = Integer.parseInt(strOptString);
            if (i4 < 5) {
                ooooO000.OooO0O0("----getVCCon", ooooO000.OooO0OO("l2"));
                return new int[0];
            }
            String strOptString2 = jSONObjectOptJSONObject.optString(OooO0O0);
            if (TextUtils.isEmpty(strOptString2)) {
                iNextInt = 0;
            } else {
                iNextInt = Integer.parseInt(strOptString2);
                if (iNextInt < 0 || iNextInt > 10000) {
                    return new int[0];
                }
            }
            String strOptString3 = jSONObjectOptJSONObject.optString(OooO0OO);
            if (TextUtils.isEmpty(strOptString3)) {
                i2 = 0;
            } else {
                i2 = Integer.parseInt(strOptString3);
                if (i2 > 10000) {
                    return new int[0];
                }
            }
            ooooO000.OooO0O0("----getVideoCrConfig", "min" + iNextInt + "max: " + i2);
            String strOptString4 = jSONObjectOptJSONObject.optString(OooO0o);
            int[] iArr = new int[4];
            if (TextUtils.isEmpty(strOptString4)) {
                return new int[0];
            }
            String[] strArrSplit = strOptString4.split("_");
            if (strArrSplit.length < 4) {
                return new int[0];
            }
            ArrayList arrayList = new ArrayList();
            int i5 = 0;
            for (int i6 = 4; i5 < i6; i6 = 4) {
                int i7 = Integer.parseInt(strArrSplit[i5]);
                if (i5 != 0 || (i7 > 0 && i7 <= 360)) {
                    if (i5 != 1 || (i7 > 0 && i7 <= 360)) {
                        if (i5 != 2) {
                            i3 = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK;
                        } else if (i7 > 0) {
                            i3 = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK;
                            if (i7 <= 640) {
                            }
                        }
                        if (i5 != 3 || (i7 > 0 && i7 <= i3)) {
                            arrayList.add(Integer.valueOf(i7));
                            i5++;
                        }
                    }
                }
                return new int[0];
            }
            if (((Integer) arrayList.get(0)).intValue() <= ((Integer) arrayList.get(1)).intValue() && ((Integer) arrayList.get(2)).intValue() <= ((Integer) arrayList.get(3)).intValue()) {
                int iIntValue = ((Integer) arrayList.get(0)).intValue() + new Random().nextInt((((Integer) arrayList.get(1)).intValue() - ((Integer) arrayList.get(0)).intValue()) + 1);
                int iIntValue2 = ((Integer) arrayList.get(2)).intValue() + new Random().nextInt((((Integer) arrayList.get(3)).intValue() - ((Integer) arrayList.get(2)).intValue()) + 1);
                int iOooO0o = oOO00000.OooO0o(BaseUtils.getContext());
                int iOooO0o0 = oOO00000.OooO0o0(BaseUtils.getContext());
                if (i4 > 5) {
                    iArr[3] = 1;
                }
                iArr[0] = (iIntValue * iOooO0o) / MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
                iArr[1] = (iIntValue2 * iOooO0o0) / MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK;
                ooooO000.OooO0O0("----getVCC", iOooO0o + " height:" + iOooO0o0 + " radomX: " + iArr[0] + " radomY：" + iArr[1]);
                map.put(o0OO000o.o00O00O, iArr[0] + "_" + iArr[1]);
                map.put(o0OO000o.o00O000o, strOptString4);
                map.put(o0OO000o.o000o00o, "5");
                map.put(o0OO000o.oOO00O, iOooO0o + "_" + iOooO0o0);
                int iNextInt2 = new Random().nextInt(10000);
                if (i2 > iNextInt) {
                    iNextInt += new Random().nextInt((i2 - iNextInt) + 1);
                }
                int iNextInt3 = new Random().nextInt(1500) + 1000;
                if (iArr[3] != 0) {
                    iNextInt3 = 0;
                }
                iArr[2] = iNextInt3;
                if (iNextInt2 >= iNextInt) {
                    return new int[0];
                }
                try {
                    String strOptString5 = jSONObjectOptJSONObject.optString("click_timestamp");
                    String str2 = map.get("adType");
                    if (!TextUtils.isEmpty(strOptString5) && strOptString5.split("_").length == 2) {
                        int i8 = Integer.parseInt(strOptString5.split("_")[0]);
                        iArr[2] = i8 + new Random().nextInt((Integer.parseInt(strOptString5.split("_")[1]) - i8) + 1);
                    } else if ("03".equals(str2)) {
                        if (i4 == 8) {
                            iArr[2] = 0;
                        } else if (i4 == 7) {
                            iArr[2] = 1000;
                        }
                    }
                } catch (Exception e) {
                    if (i4 == 8) {
                        iArr[2] = 0;
                    } else if (i4 == 7) {
                        iArr[2] = 1000;
                    }
                    ooooO000.OooO0O0("----getVCC", " 生成时间异常 e: " + e.getMessage());
                }
                if (i4 == 8) {
                    iArr[2] = 0;
                }
                return iArr;
            }
            arrayList.clear();
            return new int[0];
        } catch (Exception e2) {
            ooooO000.OooO0O0("----getVCC", " Exception: " + e2.getMessage());
            e2.printStackTrace();
            i = 0;
        }
    }

    public static void OooO0O0() {
        try {
            if (OooOOOo) {
                return;
            }
            boolean zBooleanValue = oOo00o00.OooO00o(oO00000o.o00000O0.Oooo00O).booleanValue();
            OooOOOo = zBooleanValue;
            if (!zBooleanValue && OooOOo0 <= 0) {
                long jOooO0Oo = oOo00o00.OooO0Oo(oO00000o.o00000O0.Oooo00o);
                if (!TextUtils.isEmpty(oOo00o00.OooO0o0(oOo00o00.OooO0o)) && jOooO0Oo <= 0) {
                    OooOOo0 = 2;
                    File parentFile = BaseUtils.getContext().getFilesDir().getParentFile();
                    if (parentFile != null && parentFile.exists()) {
                        ooooO000.OooO0O0("----file time:", "" + parentFile.lastModified());
                        oOo00o00.OooO00o(oO00000o.o00000O0.Oooo00o, parentFile.lastModified());
                        return;
                    }
                }
                OooOOo0 = 1;
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    private static void OooO0O0(JSONObject jSONObject, oOO00O ooo00o) {
        try {
            if (OooO00o(jSONObject, "splash_click_area")) {
                ooo00o.Oooo00o = Integer.parseInt(jSONObject.optString("splash_click_area"));
            }
        } catch (Exception e) {
            ooooO000.OooO0O0(OooOOOO, "getClickType Exception " + e.getMessage());
        }
    }

    private static void OooO0OO(JSONObject jSONObject, oOO00O ooo00o) {
        try {
            ooo00o.Oooo000 = Double.parseDouble(jSONObject.optString("exchange_rate"));
        } catch (Exception unused) {
        }
    }

    public static void OooO0Oo(JSONObject jSONObject, oOO00O ooo00o) {
        try {
            if (OooO00o(jSONObject, "dislike_switch_show_coord")) {
                ooo00o.Oooo0oO = jSONObject.optString("dislike_switch_show_coord");
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public static void OooO0o(JSONObject jSONObject, oOO00O ooo00o) {
        try {
            if (OooO00o(jSONObject, "ks_slsy")) {
                ooo00o.OoooO00 = Integer.parseInt(jSONObject.optString("ks_slsy"));
            }
            if (OooO00o(jSONObject, "ks_slst")) {
                ooo00o.Oooo = Integer.parseInt(jSONObject.optString("ks_slst"));
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    private static void OooO0o0(JSONObject jSONObject, oOO00O ooo00o) {
        try {
            if (OooO00o(jSONObject, "init_type")) {
                ooo00o.OooOooo = Integer.parseInt(jSONObject.optString("init_type"));
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    private static void OooO0oO(JSONObject jSONObject, oOO00O ooo00o) {
        try {
            if (OooO00o(jSONObject, "material_size")) {
                ooo00o.Oooo0o0 = jSONObject.optString("material_size");
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    private static void OooO0oo(JSONObject jSONObject, oOO00O ooo00o) {
        try {
            if (OooO00o(jSONObject, "ubix_offset_height")) {
                ooo00o.Oooo0o = Integer.parseInt(jSONObject.optString("ubix_offset_height"));
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public static void OooOO0(JSONObject jSONObject, oOO00O ooo00o) {
        try {
            if (OooO00o(jSONObject, "nrsb") && "1".equals(jSONObject.optString("nrsb"))) {
                ooo00o.OoooO0 = true;
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public static void OooOO0O(JSONObject jSONObject, oOO00O ooo00o) {
        try {
            if (OooO00o(jSONObject, "splash_show_timeout")) {
                ooo00o.Oooo0oo = (long) (Double.parseDouble(jSONObject.optString("splash_show_timeout")) * 1000.0d);
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    private static void OooOO0o(JSONObject jSONObject, oOO00O ooo00o) {
        try {
            if (OooO00o(jSONObject, "video_play_mute")) {
                ooo00o.Oooo0OO = jSONObject.optString("video_play_mute").equals("1");
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    private static void OooOOO(JSONObject jSONObject, oOO00O ooo00o) {
        try {
            if (OooO00o(jSONObject, "interstitial_type")) {
                String strOptString = jSONObject.optString("interstitial_type");
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                boolean z = true;
                if (Integer.parseInt(strOptString) != 1) {
                    z = false;
                }
                ooo00o.Oooo0O0 = z;
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    private static void OooOOO0(JSONObject jSONObject, oOO00O ooo00o) {
        try {
            if (OooO00o(jSONObject, "video_play_policy")) {
                ooo00o.Oooo0 = jSONObject.optString("video_play_policy");
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    private static void OooOOOO(JSONObject jSONObject, oOO00O ooo00o) {
        try {
            ooo00o.OooOoo0 = Integer.parseInt(jSONObject.optString(OooO0oo));
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    private static void OooOOOo(JSONObject jSONObject, oOO00O ooo00o) {
        if (jSONObject != null) {
            try {
                String strOptString = jSONObject.optString(OooO00o);
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                int i = Integer.parseInt(strOptString);
                ooo00o.OooOOo = i;
                if (i == 10 || i == 11) {
                    String strOptString2 = jSONObject.optString(OooO0O0);
                    if (TextUtils.isEmpty(strOptString2)) {
                        return;
                    }
                    int i2 = Integer.parseInt(strOptString2);
                    ooo00o.OooOOoo = i2;
                    if (i2 >= 0 && i2 <= 10000) {
                        String strOptString3 = jSONObject.optString(OooO0OO);
                        if (TextUtils.isEmpty(strOptString3)) {
                            return;
                        }
                        int i3 = Integer.parseInt(strOptString3);
                        ooo00o.OooOo00 = i3;
                        if (i3 > 0 && i3 <= 10000 && ooo00o.OooOOoo <= i3) {
                            String strOptString4 = jSONObject.optString(OooO0Oo);
                            if (TextUtils.isEmpty(strOptString4)) {
                                ooo00o.OooOo0 = 0;
                            } else {
                                int i4 = Integer.parseInt(strOptString4);
                                ooo00o.OooOo0 = i4;
                                if (i4 < 0) {
                                    return;
                                }
                            }
                            String strOptString5 = jSONObject.optString(OooO0o0);
                            if (TextUtils.isEmpty(strOptString5)) {
                                ooo00o.OooOo0O = 0L;
                            } else {
                                long j = Integer.parseInt(strOptString5);
                                ooo00o.OooOo0O = j;
                                if (j < 0) {
                                    return;
                                }
                            }
                            ooo00o.OooOoO0 = true;
                            ooooO000.OooO0O0("----json", ooooO000.OooO0OO("k6"));
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void OooOOo(JSONObject jSONObject, oOO00O ooo00o) {
        if (jSONObject != null) {
            try {
                String strOptString = jSONObject.optString(OooO00o);
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                int i = Integer.parseInt(strOptString);
                ooo00o.OooOOo = i;
                if (i != 4) {
                    return;
                }
                String strOptString2 = jSONObject.optString(OooO0O0);
                if (TextUtils.isEmpty(strOptString2)) {
                    return;
                }
                int i2 = Integer.parseInt(strOptString2);
                ooo00o.OooOOoo = i2;
                if (i2 >= 0 && i2 <= 10000) {
                    String strOptString3 = jSONObject.optString(OooO0OO);
                    if (TextUtils.isEmpty(strOptString3)) {
                        return;
                    }
                    int i3 = Integer.parseInt(strOptString3);
                    ooo00o.OooOo00 = i3;
                    if (i3 > 0 && i3 <= 10000 && ooo00o.OooOOoo <= i3) {
                        String strOptString4 = jSONObject.optString(OooO0Oo);
                        if (TextUtils.isEmpty(strOptString4)) {
                            ooo00o.OooOo0 = 0;
                        } else {
                            int i4 = Integer.parseInt(strOptString4);
                            ooo00o.OooOo0 = i4;
                            if (i4 < 0) {
                                return;
                            }
                        }
                        String strOptString5 = jSONObject.optString(OooO0o0);
                        if (TextUtils.isEmpty(strOptString5)) {
                            ooo00o.OooOo0O = 0L;
                        } else {
                            long j = Integer.parseInt(strOptString5);
                            ooo00o.OooOo0O = j;
                            if (j < 0) {
                                return;
                            }
                        }
                        ooo00o.OooOoOO = true;
                        ooooO000.OooO0O0("----json", ooooO000.OooO0OO("l1"));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void OooOOo0(JSONObject jSONObject, oOO00O ooo00o) {
        if (jSONObject != null) {
            try {
                String strOptString = jSONObject.optString(OooO00o);
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                int i = Integer.parseInt(strOptString);
                ooo00o.OooOOo = i;
                if (i != 3) {
                    return;
                }
                String strOptString2 = jSONObject.optString(OooO0O0);
                if (TextUtils.isEmpty(strOptString2)) {
                    return;
                }
                int i2 = Integer.parseInt(strOptString2);
                ooo00o.OooOOoo = i2;
                if (i2 >= 0 && i2 <= 10000) {
                    String strOptString3 = jSONObject.optString(OooO0OO);
                    if (TextUtils.isEmpty(strOptString3)) {
                        return;
                    }
                    int i3 = Integer.parseInt(strOptString3);
                    ooo00o.OooOo00 = i3;
                    if (i3 > 0 && i3 <= 10000 && ooo00o.OooOOoo <= i3) {
                        String strOptString4 = jSONObject.optString(OooO0Oo);
                        if (TextUtils.isEmpty(strOptString4)) {
                            ooo00o.OooOo0 = 0;
                        } else {
                            int i4 = Integer.parseInt(strOptString4);
                            ooo00o.OooOo0 = i4;
                            if (i4 < 0) {
                                return;
                            }
                        }
                        String strOptString5 = jSONObject.optString(OooO0o0);
                        if (TextUtils.isEmpty(strOptString5)) {
                            ooo00o.OooOo0O = 0L;
                        } else {
                            long j = Integer.parseInt(strOptString5);
                            ooo00o.OooOo0O = j;
                            if (j < 0) {
                                return;
                            }
                        }
                        String strOptString6 = jSONObject.optString(OooO);
                        try {
                            if (TextUtils.isEmpty(strOptString6)) {
                                ooo00o.OooOoo = 0.5f;
                            } else {
                                float f = Float.parseFloat(strOptString6);
                                ooo00o.OooOoo = f;
                                if (f < 0.0f) {
                                    return;
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        ooo00o.OooOoO = true;
                        ooooO000.OooO0O0("----json", ooooO000.OooO0OO("l3"));
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static void OooOOoo(JSONObject jSONObject, oOO00O ooo00o) {
        if (jSONObject != null) {
            try {
                String strOptString = jSONObject.optString(OooO00o);
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                int i = Integer.parseInt(strOptString);
                ooo00o.OooOOo = i;
                if (i == 21 || i == 22 || i == 23 || i == 24) {
                    String strOptString2 = jSONObject.optString(OooO0O0);
                    if (TextUtils.isEmpty(strOptString2)) {
                        return;
                    }
                    int i2 = Integer.parseInt(strOptString2);
                    ooo00o.OooOOoo = i2;
                    if (i2 >= 0 && i2 <= 10000) {
                        String strOptString3 = jSONObject.optString(OooO0OO);
                        if (TextUtils.isEmpty(strOptString3)) {
                            return;
                        }
                        int i3 = Integer.parseInt(strOptString3);
                        ooo00o.OooOo00 = i3;
                        if (i3 > 0 && i3 <= 10000 && ooo00o.OooOOoo <= i3) {
                            String strOptString4 = jSONObject.optString(OooO0Oo);
                            if (TextUtils.isEmpty(strOptString4)) {
                                ooo00o.OooOo0 = 0;
                            } else {
                                int i4 = Integer.parseInt(strOptString4);
                                ooo00o.OooOo0 = i4;
                                if (i4 < 0) {
                                    return;
                                }
                            }
                            String strOptString5 = jSONObject.optString(OooO0o0);
                            if (TextUtils.isEmpty(strOptString5)) {
                                ooo00o.OooOo0O = 0L;
                            } else {
                                long j = Integer.parseInt(strOptString5);
                                ooo00o.OooOo0O = j;
                                if (j < 0) {
                                    return;
                                }
                            }
                            ooo00o.OooOoO0 = true;
                            ooooO000.OooO0O0("----json", ooooO000.OooO0OO("k6"));
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
