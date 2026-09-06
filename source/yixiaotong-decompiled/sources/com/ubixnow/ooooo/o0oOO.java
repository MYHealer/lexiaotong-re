package com.ubixnow.ooooo;

import android.os.SystemClock;
import android.text.TextUtils;
import com.ubixnow.core.utils.error.ErrorInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class o0oOO {
    public static final String OooO00o = "----ubix_in";
    public o00O0 OooO0O0;
    public Set<Integer> OooO0OO = new HashSet();
    public List<Integer> OooO0Oo = new ArrayList();

    public static int OooO00o(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("advCo");
                if (jSONObjectOptJSONObject == null) {
                    return 1;
                }
                String strOptString = jSONObjectOptJSONObject.optString(oO00000o.OooO0O0.OooO00o);
                if ("5".equals(strOptString)) {
                    return 5;
                }
                if ("2".equals(strOptString)) {
                    return 2;
                }
                if ("3".equals(strOptString)) {
                    return 3;
                }
            } catch (Exception e) {
                ooooO000.OooO00o(e);
            }
        }
        return 1;
    }

    public static String OooO00o(int i) {
        switch (i) {
            case 1:
                return oO00000o.OooOOO.OooO0o;
            case 2:
                return oO00000o.OooOOO.OooO0Oo;
            case 3:
                return oO00000o.OooOOO.OooO00o;
            case 4:
                return oO00000o.OooOOO.OooO0o0;
            case 5:
                return oO00000o.OooOOO.OooO0oo;
            case 6:
                return oO00000o.OooOOO.OooO0O0;
            case 7:
                return oO00000o.OooOOO.OooOOOO;
            case 8:
                return oO00000o.OooOOO.OooO0oO;
            case 9:
                return oO00000o.OooOOO.OooOO0o;
            case 10:
                return oO00000o.OooOOO.OooO0OO;
            case 11:
            case 12:
            case 13:
            case 16:
            case 31:
            default:
                return null;
            case 14:
                return oO00000o.OooOOO.OooOOOo;
            case 15:
                return oO00000o.OooOOO.OooOO0;
            case 17:
                return oO00000o.OooOOO.OooO;
            case 18:
                return oO00000o.OooOOO.OooOO0O;
            case 19:
                return oO00000o.OooOOO.OooOOO0;
            case 20:
                return oO00000o.OooOOO.OooOOo0;
            case 21:
                return oO00000o.OooOOO.OooOOO;
            case 22:
                return oO00000o.OooOOO.OooOOo;
            case 23:
                return oO00000o.OooOOO.OooOOoo;
            case 24:
                return oO00000o.OooOOO.OooOo00;
            case 25:
                return oO00000o.OooOOO.OooOo0o;
            case 26:
                return oO00000o.OooOOO.OooOo0;
            case 27:
                return oO00000o.OooOOO.OooOo0O;
            case 28:
                return oO00000o.OooOOO.OooOo;
            case 29:
                return oO00000o.OooOOO.OooOoO0;
            case 30:
                return oO00000o.OooOOO.OooOoO;
            case 32:
                return oO00000o.OooOOO.OooOoOO;
            case 33:
                return oO00000o.OooOOO.OooOoo0;
            case 34:
                return oO00000o.OooOOO.OooOoo;
            case 35:
                return oO00000o.OooOOO.OooOooO;
        }
    }

    public ErrorInfo OooO00o(o00O000 o00o000, o00O o00o) {
        ErrorInfo errorInfoOooO00o = OooO00o(o00o000.OooO00o, this.OooO0O0);
        if (errorInfoOooO00o != null) {
            return errorInfoOooO00o;
        }
        if (!OooO00o(this.OooO0O0, o00o000.OooO00o)) {
            return new ErrorInfo(o0OO000o.o000oOoO, o0OO000o.OoooOOO);
        }
        if (o00o == null) {
            return new ErrorInfo(o0OO000o.OoooOOo, o0OO000o.OoooOo0);
        }
        if (TextUtils.isEmpty(o00o000.OooO00o.OooO0o0) || TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo)) {
            return new ErrorInfo(o0OO000o.Ooooo00, o0OO000o.Ooooo0o);
        }
        return null;
    }

    public ErrorInfo OooO00o(oO0O0OoO oo0o0ooo, o00O0 o00o0) {
        if (oo0o0ooo.OooOO0 != o00o0.OooO0Oo.OooO0OO) {
            return new ErrorInfo(o0OO000o.OoooOoO, o0OO000o.OoooOoo);
        }
        return null;
    }

    public o00OOO0O OooO00o(o00O0 o00o0, o00O o00o) {
        o00OOO0O o00ooo0o = new o00OOO0O();
        o00ooo0o.OooO0OO = System.currentTimeMillis();
        o00O000 o00o000 = o00o.mBaseAdConfig;
        int i = o00o000.OooO00o.OooOO0O;
        o00ooo0o.OooO00o = (i == 0 || i == 2) ? o00o000.OooO0OO : o00o000.OooO0o;
        o00ooo0o.OooO0O0 = o00o;
        o00ooo0o.OooO0o = o00o0.OooO0Oo.OooO0OO;
        o00ooo0o.OooO0o0 = o00o0.OooOO0O;
        o00ooo0o.OooO = o00o0.OooO00o;
        o00O00O o00o00o = o00o0.OooO0OO;
        o00ooo0o.OooO0Oo = o00o00o.OooOO0O;
        o00ooo0o.OooO0oO = o00o00o.OooO;
        o00ooo0o.OooO0oo = o00o0.OooO0OO.OooO + o00o.mBaseAdConfig.OooO00o.OooO0o0;
        return o00ooo0o;
    }

    /* JADX WARN: Code duplicated, block: B:915:0x0874 A[RETURN] */
    public String OooO00o(String str, int i) {
        byte b = 5;
        byte b2 = 4;
        byte b3 = 3;
        byte b4 = 2;
        switch (i) {
            case 1:
                str.hashCode();
                str.hashCode();
                switch (str) {
                    case "1":
                        return oO00000o.oo0o0Oo.OooO0OO;
                    case "3":
                        return oO00000o.oo0o0Oo.OooO;
                    case "5":
                        return oO00000o.oo0o0Oo.OooO0Oo;
                    case "7":
                        return oO00000o.oo0o0Oo.OooO0o;
                    case "03":
                        return oO00000o.oo0o0Oo.OooO0oo;
                    case "04":
                        return oO00000o.oo0o0Oo.OooOO0;
                    case "10":
                        return oO00000o.oo0o0Oo.OooO0o0;
                    case "12":
                        return oO00000o.oo0o0Oo.OooO0oO;
                    default:
                        return "";
                }
            case 2:
                str.hashCode();
                str.hashCode();
                switch (str) {
                    case "1":
                        return oO00000o.Oooo000.OooO0OO;
                    case "3":
                        return oO00000o.Oooo000.OooO0oO;
                    case "5":
                        return oO00000o.Oooo000.OooO0o0;
                    case "7":
                        return oO00000o.Oooo000.OooO0Oo;
                    case "03":
                        return oO00000o.Oooo000.OooO0o;
                    case "04":
                        return oO00000o.Oooo000.OooO0oo;
                    case "10":
                        return oO00000o.Oooo000.OooO;
                    case "12":
                        return oO00000o.Oooo000.OooOO0;
                    default:
                        return "";
                }
            case 3:
                str.hashCode();
                str.hashCode();
                switch (str) {
                    case "1":
                        return oO00000o.oo000o.OooO0O0;
                    case "3":
                        return oO00000o.oo000o.OooO0oO;
                    case "5":
                        return oO00000o.oo000o.OooO0o0;
                    case "7":
                        return oO00000o.oo000o.OooO0Oo;
                    case "03":
                        return oO00000o.oo000o.OooO0o;
                    case "04":
                        return oO00000o.oo000o.OooO;
                    case "10":
                        return oO00000o.oo000o.OooO0oo;
                    case "12":
                        return oO00000o.oo000o.OooOO0;
                    default:
                        return "";
                }
            case 4:
                str.hashCode();
                str.hashCode();
                switch (str.hashCode()) {
                    case 49:
                        b = !str.equals("1") ? (byte) -1 : (byte) 0;
                        break;
                    case 51:
                        b = !str.equals("3") ? (byte) -1 : (byte) 1;
                        break;
                    case 53:
                        b = !str.equals("5") ? (byte) -1 : (byte) 2;
                        break;
                    case 55:
                        b = !str.equals("7") ? (byte) -1 : (byte) 3;
                        break;
                    case 1540:
                        b = !str.equals("04") ? (byte) -1 : (byte) 4;
                        break;
                    case 1568:
                        if (!str.equals("11")) {
                            b = -1;
                        }
                        break;
                    default:
                        b = -1;
                        break;
                }
                switch (b) {
                    case 0:
                        return oO00000o.o00Ooo.OooO0OO;
                    case 1:
                        return oO00000o.o00Ooo.OooO0o;
                    case 2:
                        return oO00000o.o00Ooo.OooO0o0;
                    case 3:
                        return oO00000o.o00Ooo.OooO0oO;
                    case 4:
                        return oO00000o.o00Ooo.OooO0oo;
                    case 5:
                        return oO00000o.o00Ooo.OooO;
                    default:
                        return "";
                }
            case 5:
                str.hashCode();
                str.hashCode();
                switch (str.hashCode()) {
                    case 49:
                        b2 = !str.equals("1") ? (byte) -1 : (byte) 0;
                        break;
                    case 51:
                        b2 = !str.equals("3") ? (byte) -1 : (byte) 1;
                        break;
                    case 53:
                        b2 = !str.equals("5") ? (byte) -1 : (byte) 2;
                        break;
                    case 1539:
                        b2 = !str.equals("03") ? (byte) -1 : (byte) 3;
                        break;
                    case 1540:
                        if (!str.equals("04")) {
                            b2 = -1;
                        }
                        break;
                    default:
                        b2 = -1;
                        break;
                }
                switch (b2) {
                    case 0:
                        return oO00000o.o0000Ooo.OooO0OO;
                    case 1:
                        return oO00000o.o0000Ooo.OooO0Oo;
                    case 2:
                        return oO00000o.o0000Ooo.OooO0o0;
                    case 3:
                        return oO00000o.o0000Ooo.OooO0o;
                    case 4:
                        return oO00000o.o0000Ooo.OooO0oO;
                    default:
                        return "";
                }
            case 6:
                str.hashCode();
                str.hashCode();
                switch (str) {
                    case "1":
                        return oO00000o.OooO.OooO0OO;
                    case "3":
                        return oO00000o.OooO.OooO0oO;
                    case "5":
                        return oO00000o.OooO.OooO0o0;
                    case "7":
                        return oO00000o.OooO.OooO0oo;
                    case "03":
                        return oO00000o.OooO.OooO0o;
                    case "04":
                        return oO00000o.OooO.OooO;
                    case "10":
                        return oO00000o.OooO.OooOO0;
                    case "11":
                        return oO00000o.OooO.OooOO0O;
                    case "12":
                        return oO00000o.OooO.OooOO0o;
                    default:
                        return "";
                }
            case 7:
            case 11:
            case 12:
            case 13:
            case 16:
            case 31:
            default:
                return "";
            case 8:
                str.hashCode();
                if (str.equals("1")) {
                    return oO00000o.o000000O.OooO0OO;
                }
                if (str.equals("03")) {
                    return oO00000o.o000000O.OooO0Oo;
                }
                return "";
            case 9:
                str.hashCode();
                str.hashCode();
                switch (str.hashCode()) {
                    case 49:
                        b = !str.equals("1") ? (byte) -1 : (byte) 0;
                        break;
                    case 51:
                        b = !str.equals("3") ? (byte) -1 : (byte) 1;
                        break;
                    case 53:
                        b = !str.equals("5") ? (byte) -1 : (byte) 2;
                        break;
                    case 55:
                        b = !str.equals("7") ? (byte) -1 : (byte) 3;
                        break;
                    case 1539:
                        b = !str.equals("03") ? (byte) -1 : (byte) 4;
                        break;
                    case 1540:
                        if (!str.equals("04")) {
                            b = -1;
                        }
                        break;
                    default:
                        b = -1;
                        break;
                }
                switch (b) {
                    case 0:
                        return oO00000o.o000oOoO.OooO0OO;
                    case 1:
                        return oO00000o.o000oOoO.OooO0o;
                    case 2:
                        return oO00000o.o000oOoO.OooO0Oo;
                    case 3:
                        return oO00000o.o000oOoO.OooO0oo;
                    case 4:
                        return oO00000o.o000oOoO.OooO0o0;
                    case 5:
                        return oO00000o.o000oOoO.OooO0oO;
                    default:
                        return "";
                }
            case 10:
                str.hashCode();
                if (str.equals("1")) {
                    return oO00000o.OooOO0.OooO0OO;
                }
                return "";
            case 14:
                ooooO000.OooO0O0("----Lx", "----adType: " + str);
                str.hashCode();
                str.hashCode();
                switch (str.hashCode()) {
                    case 49:
                        b = !str.equals("1") ? (byte) -1 : (byte) 0;
                        break;
                    case 51:
                        b = !str.equals("3") ? (byte) -1 : (byte) 1;
                        break;
                    case 53:
                        b = !str.equals("5") ? (byte) -1 : (byte) 2;
                        break;
                    case 55:
                        b = !str.equals("7") ? (byte) -1 : (byte) 3;
                        break;
                    case 1539:
                        b = !str.equals("03") ? (byte) -1 : (byte) 4;
                        break;
                    case 1540:
                        if (!str.equals("04")) {
                            b = -1;
                        }
                        break;
                    default:
                        b = -1;
                        break;
                }
                switch (b) {
                    case 0:
                        return oO00000o.o00oO0o.OooO0OO;
                    case 1:
                        return oO00000o.o00oO0o.OooO0oO;
                    case 2:
                        return oO00000o.o00oO0o.OooO0o0;
                    case 3:
                        return oO00000o.o00oO0o.OooO0Oo;
                    case 4:
                        return oO00000o.o00oO0o.OooO0o;
                    case 5:
                        return oO00000o.o00oO0o.OooO0oo;
                    default:
                        return "";
                }
            case 15:
                str.hashCode();
                str.hashCode();
                switch (str.hashCode()) {
                    case 49:
                        b = !str.equals("1") ? (byte) -1 : (byte) 0;
                        break;
                    case 51:
                        b = !str.equals("3") ? (byte) -1 : (byte) 1;
                        break;
                    case 53:
                        b = !str.equals("5") ? (byte) -1 : (byte) 2;
                        break;
                    case 55:
                        b = !str.equals("7") ? (byte) -1 : (byte) 3;
                        break;
                    case 1539:
                        b = !str.equals("03") ? (byte) -1 : (byte) 4;
                        break;
                    case 1540:
                        if (!str.equals("04")) {
                            b = -1;
                        }
                        break;
                    default:
                        b = -1;
                        break;
                }
                switch (b) {
                    case 0:
                        return oO00000o.o0Oo0oo.OooO0OO;
                    case 1:
                        return oO00000o.o0Oo0oo.OooO0o;
                    case 2:
                        return oO00000o.o0Oo0oo.OooO0Oo;
                    case 3:
                        return oO00000o.o0Oo0oo.OooO0oo;
                    case 4:
                        return oO00000o.o0Oo0oo.OooO0o0;
                    case 5:
                        return oO00000o.o0Oo0oo.OooO0oO;
                    default:
                        return "";
                }
            case 17:
                str.hashCode();
                str.hashCode();
                switch (str) {
                    case "1":
                        return oO00000o.Oooo0.OooO0OO;
                    case "3":
                        return oO00000o.Oooo0.OooO0o;
                    case "5":
                        return oO00000o.Oooo0.OooO0Oo;
                    case "7":
                        return oO00000o.Oooo0.OooO0oo;
                    case "03":
                        return oO00000o.Oooo0.OooO0o0;
                    case "04":
                        return oO00000o.Oooo0.OooO0oO;
                    case "10":
                        return oO00000o.Oooo0.OooOO0;
                    case "12":
                        return oO00000o.Oooo0.OooO;
                    default:
                        return "";
                }
            case 18:
                str.hashCode();
                str.hashCode();
                switch (str.hashCode()) {
                    case 49:
                        b = !str.equals("1") ? (byte) -1 : (byte) 0;
                        break;
                    case 51:
                        b = !str.equals("3") ? (byte) -1 : (byte) 1;
                        break;
                    case 53:
                        b = !str.equals("5") ? (byte) -1 : (byte) 2;
                        break;
                    case 55:
                        b = !str.equals("7") ? (byte) -1 : (byte) 3;
                        break;
                    case 1539:
                        b = !str.equals("03") ? (byte) -1 : (byte) 4;
                        break;
                    case 1540:
                        if (!str.equals("04")) {
                            b = -1;
                        }
                        break;
                    default:
                        b = -1;
                        break;
                }
                switch (b) {
                    case 0:
                        return oO00000o.o0OOO0o.OooO0OO;
                    case 1:
                        return oO00000o.o0OOO0o.OooO0oO;
                    case 2:
                        return oO00000o.o0OOO0o.OooO0o0;
                    case 3:
                        return oO00000o.o0OOO0o.OooO0Oo;
                    case 4:
                        return oO00000o.o0OOO0o.OooO0o;
                    case 5:
                        return oO00000o.o0OOO0o.OooO0oo;
                    default:
                        return "";
                }
            case 19:
                str.hashCode();
                str.hashCode();
                switch (str.hashCode()) {
                    case 49:
                        b = !str.equals("1") ? (byte) -1 : (byte) 0;
                        break;
                    case 51:
                        b = !str.equals("3") ? (byte) -1 : (byte) 1;
                        break;
                    case 53:
                        b = !str.equals("5") ? (byte) -1 : (byte) 2;
                        break;
                    case 55:
                        b = !str.equals("7") ? (byte) -1 : (byte) 3;
                        break;
                    case 1539:
                        b = !str.equals("03") ? (byte) -1 : (byte) 4;
                        break;
                    case 1540:
                        if (!str.equals("04")) {
                            b = -1;
                        }
                        break;
                    default:
                        b = -1;
                        break;
                }
                switch (b) {
                    case 0:
                        return oO00000o.o0000.OooO0OO;
                    case 1:
                        return oO00000o.o0000.OooO0o;
                    case 2:
                        return oO00000o.o0000.OooO0Oo;
                    case 3:
                        return oO00000o.o0000.OooO0oo;
                    case 4:
                        return oO00000o.o0000.OooO0o0;
                    case 5:
                        return oO00000o.o0000.OooO0oO;
                    default:
                        return "";
                }
            case 20:
                str.hashCode();
                str.hashCode();
                switch (str.hashCode()) {
                    case 49:
                        b2 = !str.equals("1") ? (byte) -1 : (byte) 0;
                        break;
                    case 51:
                        b2 = !str.equals("3") ? (byte) -1 : (byte) 1;
                        break;
                    case 53:
                        b2 = !str.equals("5") ? (byte) -1 : (byte) 2;
                        break;
                    case 55:
                        b2 = !str.equals("7") ? (byte) -1 : (byte) 3;
                        break;
                    case 1539:
                        if (!str.equals("03")) {
                            b2 = -1;
                        }
                        break;
                    default:
                        b2 = -1;
                        break;
                }
                switch (b2) {
                    case 0:
                        return oO00000o.o0000O0.OooO0OO;
                    case 1:
                        return oO00000o.o0000O0.OooO0o;
                    case 2:
                        return oO00000o.o0000O0.OooO0Oo;
                    case 3:
                        return oO00000o.o0000O0.OooO0oO;
                    case 4:
                        return oO00000o.o0000O0.OooO0o0;
                    default:
                        return "";
                }
            case 21:
                str.hashCode();
                str.hashCode();
                switch (str.hashCode()) {
                    case 49:
                        b = !str.equals("1") ? (byte) -1 : (byte) 0;
                        break;
                    case 51:
                        b = !str.equals("3") ? (byte) -1 : (byte) 1;
                        break;
                    case 53:
                        b = !str.equals("5") ? (byte) -1 : (byte) 2;
                        break;
                    case 55:
                        b = !str.equals("7") ? (byte) -1 : (byte) 3;
                        break;
                    case 1539:
                        b = !str.equals("03") ? (byte) -1 : (byte) 4;
                        break;
                    case 1540:
                        if (!str.equals("04")) {
                            b = -1;
                        }
                        break;
                    default:
                        b = -1;
                        break;
                }
                switch (b) {
                    case 0:
                        return oO00000o.o0000oo.OooO0OO;
                    case 1:
                        return oO00000o.o0000oo.OooO0o;
                    case 2:
                        return oO00000o.o0000oo.OooO0Oo;
                    case 3:
                        return oO00000o.o0000oo.OooO0oo;
                    case 4:
                        return oO00000o.o0000oo.OooO0o0;
                    case 5:
                        return oO00000o.o0000oo.OooO0oO;
                    default:
                        return "";
                }
            case 22:
                str.hashCode();
                str.hashCode();
                switch (str.hashCode()) {
                    case 49:
                        b2 = !str.equals("1") ? (byte) -1 : (byte) 0;
                        break;
                    case 51:
                        b2 = !str.equals("3") ? (byte) -1 : (byte) 1;
                        break;
                    case 53:
                        b2 = !str.equals("5") ? (byte) -1 : (byte) 2;
                        break;
                    case 1539:
                        b2 = !str.equals("03") ? (byte) -1 : (byte) 3;
                        break;
                    case 1540:
                        if (!str.equals("04")) {
                            b2 = -1;
                        }
                        break;
                    default:
                        b2 = -1;
                        break;
                }
                switch (b2) {
                    case 0:
                        return oO00000o.o000OO.OooO0O0;
                    case 1:
                        return oO00000o.o000OO.OooO0oO;
                    case 2:
                        return oO00000o.o000OO.OooO0o0;
                    case 3:
                        return oO00000o.o000OO.OooO0o;
                    case 4:
                        return oO00000o.o000OO.OooO0o;
                    default:
                        return "";
                }
            case 23:
                str.hashCode();
                str.hashCode();
                switch (str.hashCode()) {
                    case 49:
                        b2 = !str.equals("1") ? (byte) -1 : (byte) 0;
                        break;
                    case 51:
                        b2 = !str.equals("3") ? (byte) -1 : (byte) 1;
                        break;
                    case 53:
                        b2 = !str.equals("5") ? (byte) -1 : (byte) 2;
                        break;
                    case 1539:
                        b2 = !str.equals("03") ? (byte) -1 : (byte) 3;
                        break;
                    case 1568:
                        if (!str.equals("11")) {
                            b2 = -1;
                        }
                        break;
                    default:
                        b2 = -1;
                        break;
                }
                switch (b2) {
                    case 0:
                        return oO00000o.o000OOo.OooO0OO;
                    case 1:
                        return oO00000o.o000OOo.OooO0o;
                    case 2:
                        return oO00000o.o000OOo.OooO0Oo;
                    case 3:
                        return oO00000o.o000OOo.OooO0o0;
                    case 4:
                        return oO00000o.o000OOo.OooO0oO;
                    default:
                        return "";
                }
            case 24:
                str.hashCode();
                str.hashCode();
                switch (str.hashCode()) {
                    case 49:
                        b3 = !str.equals("1") ? (byte) -1 : (byte) 0;
                        break;
                    case 51:
                        b3 = !str.equals("3") ? (byte) -1 : (byte) 1;
                        break;
                    case 53:
                        b3 = !str.equals("5") ? (byte) -1 : (byte) 2;
                        break;
                    case 1539:
                        if (!str.equals("03")) {
                            b3 = -1;
                        }
                        break;
                    default:
                        b3 = -1;
                        break;
                }
                switch (b3) {
                    case 0:
                        return oO00000o.OooOo.OooO0OO;
                    case 1:
                        return oO00000o.OooOo.OooO0o;
                    case 2:
                        return oO00000o.OooOo.OooO0Oo;
                    case 3:
                        return oO00000o.OooOo.OooO0o0;
                    default:
                        return "";
                }
            case 25:
                str.hashCode();
                if (str.equals("1")) {
                    return oO00000o.o0OO00O.OooO0OO;
                }
                return "";
            case 26:
                str.hashCode();
                if (str.equals("1")) {
                    return oO00000o.OooOO0O.OooO0OO;
                }
                if (str.equals("3")) {
                    return oO00000o.OooOO0O.OooO0Oo;
                }
                return "";
            case 27:
                str.hashCode();
                if (str.equals("3")) {
                    return oO00000o.o00000.OooO0OO;
                }
                return "";
            case 28:
                str.hashCode();
                str.hashCode();
                switch (str.hashCode()) {
                    case 49:
                        b3 = !str.equals("1") ? (byte) -1 : (byte) 0;
                        break;
                    case 51:
                        b3 = !str.equals("3") ? (byte) -1 : (byte) 1;
                        break;
                    case 53:
                        b3 = !str.equals("5") ? (byte) -1 : (byte) 2;
                        break;
                    case 1539:
                        if (!str.equals("03")) {
                            b3 = -1;
                        }
                        break;
                    default:
                        b3 = -1;
                        break;
                }
                switch (b3) {
                    case 0:
                        return oO00000o.o0ooOOo.OooO0OO;
                    case 1:
                        return oO00000o.o0ooOOo.OooO0o;
                    case 2:
                        return oO00000o.o0ooOOo.OooO0o0;
                    case 3:
                        return oO00000o.o0ooOOo.OooO0Oo;
                    default:
                        return "";
                }
            case 29:
                str.hashCode();
                str.hashCode();
                switch (str.hashCode()) {
                    case 49:
                        b3 = !str.equals("1") ? (byte) -1 : (byte) 0;
                        break;
                    case 51:
                        b3 = !str.equals("3") ? (byte) -1 : (byte) 1;
                        break;
                    case 53:
                        b3 = !str.equals("5") ? (byte) -1 : (byte) 2;
                        break;
                    case 1539:
                        if (!str.equals("03")) {
                            b3 = -1;
                        }
                        break;
                    default:
                        b3 = -1;
                        break;
                }
                switch (b3) {
                    case 0:
                        return oO00000o.o00000O.OooO0OO;
                    case 1:
                        return oO00000o.o00000O.OooO0o;
                    case 2:
                        return oO00000o.o00000O.OooO0o0;
                    case 3:
                        return oO00000o.o00000O.OooO0Oo;
                    default:
                        return "";
                }
            case 30:
                str.hashCode();
                str.hashCode();
                switch (str.hashCode()) {
                    case 49:
                        b4 = !str.equals("1") ? (byte) -1 : (byte) 0;
                        break;
                    case 50:
                    case 52:
                    default:
                        b4 = -1;
                        break;
                    case 51:
                        b4 = !str.equals("3") ? (byte) -1 : (byte) 1;
                        break;
                    case 53:
                        if (!str.equals("5")) {
                            b4 = -1;
                        }
                        break;
                }
                switch (b4) {
                    case 0:
                        return oO00000o.OooOOO0.OooO0OO;
                    case 1:
                        return oO00000o.OooOOO0.OooO0o0;
                    case 2:
                        return oO00000o.OooOOO0.OooO0Oo;
                    default:
                        return "";
                }
            case 32:
                str.hashCode();
                if (str.equals("1")) {
                    return oO00000o.o0000O0O.OooO0OO;
                }
                return "";
            case 33:
                str.hashCode();
                str.hashCode();
                switch (str.hashCode()) {
                    case 49:
                        b2 = !str.equals("1") ? (byte) -1 : (byte) 0;
                        break;
                    case 51:
                        b2 = !str.equals("3") ? (byte) -1 : (byte) 1;
                        break;
                    case 53:
                        b2 = !str.equals("5") ? (byte) -1 : (byte) 2;
                        break;
                    case 1539:
                        b2 = !str.equals("03") ? (byte) -1 : (byte) 3;
                        break;
                    case 1540:
                        if (!str.equals("04")) {
                            b2 = -1;
                        }
                        break;
                    default:
                        b2 = -1;
                        break;
                }
                switch (b2) {
                    case 0:
                        return oO00000o.o0OoOo0.OooO0OO;
                    case 1:
                        return oO00000o.o0OoOo0.OooO0o;
                    case 2:
                        return oO00000o.o0OoOo0.OooO0Oo;
                    case 3:
                        return oO00000o.o0OoOo0.OooO0o0;
                    case 4:
                        return oO00000o.o0OoOo0.OooO0oO;
                    default:
                        return "";
                }
            case 34:
                str.hashCode();
                str.hashCode();
                switch (str.hashCode()) {
                    case 49:
                        b2 = !str.equals("1") ? (byte) -1 : (byte) 0;
                        break;
                    case 51:
                        b2 = !str.equals("3") ? (byte) -1 : (byte) 1;
                        break;
                    case 53:
                        b2 = !str.equals("5") ? (byte) -1 : (byte) 2;
                        break;
                    case 1539:
                        b2 = !str.equals("03") ? (byte) -1 : (byte) 3;
                        break;
                    case 1540:
                        if (!str.equals("04")) {
                            b2 = -1;
                        }
                        break;
                    default:
                        b2 = -1;
                        break;
                }
                switch (b2) {
                    case 0:
                        return oO00000o.o0000O00.OooO0OO;
                    case 1:
                        return oO00000o.o0000O00.OooO0o;
                    case 2:
                        return oO00000o.o0000O00.OooO0o0;
                    case 3:
                        return oO00000o.o0000O00.OooO0Oo;
                    case 4:
                        return oO00000o.o0000O00.OooO0oO;
                    default:
                        return "";
                }
            case 35:
                str.hashCode();
                str.hashCode();
                switch (str.hashCode()) {
                    case 49:
                        b3 = !str.equals("1") ? (byte) -1 : (byte) 0;
                        break;
                    case 51:
                        b3 = !str.equals("3") ? (byte) -1 : (byte) 1;
                        break;
                    case 53:
                        b3 = !str.equals("5") ? (byte) -1 : (byte) 2;
                        break;
                    case 1539:
                        if (!str.equals("03")) {
                            b3 = -1;
                        }
                        break;
                    default:
                        b3 = -1;
                        break;
                }
                switch (b3) {
                    case 0:
                        return oO00000o.OooOo00.OooO0OO;
                    case 1:
                        return oO00000o.OooOo00.OooO0o;
                    case 2:
                        return oO00000o.OooOo00.OooO0o0;
                    case 3:
                        return oO00000o.OooOo00.OooO0Oo;
                    default:
                        return "";
                }
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x006d  */
    /* JADX WARN: Code duplicated, block: B:14:0x00c1  */
    public HashMap<String, String> OooO00o(HashMap<String, String> map, oO0O0OoO oo0o0ooo, String str) {
        map.put(o0OO000o.oooo00o, oo0o0ooo.OooO0OO + "");
        map.put(o0OO000o.o000o0O, oo0o0ooo.OooO0o0);
        map.put(o0OO000o.o000ooo0, oO0000O.OooO0O0(oo0o0ooo.OooO0OO));
        if (oo0o0ooo.OooOO0O == 1) {
            if (!TextUtils.isEmpty(str)) {
            }
            map.put(o0OO000o.o000o0o, oo0o0ooo.OooOO0O + "");
            if (oo0o0ooo.OooOOo0 == 2) {
                map.put(o0OO000o.o00O0000, this.OooO0O0.OooOOo0.OooOO0o + "");
                map.put(o0OO000o.o00, this.OooO0O0.OooOOo0.OooOO0O + "");
            }
            map.put(o0OO000o.o000o0OO, oo0o0ooo.OooOO0 + "");
            if (oo0o0ooo.OooOO0O == 0) {
                map.put(o0OO000o.o000o0Oo, oo0o0ooo.OooOOO + "");
            }
            return map;
        }
        str = oo0o0ooo.OooO + "";
        map.put(o0OO000o.o000o0o0, str);
        map.put(o0OO000o.o000o0o, oo0o0ooo.OooOO0O + "");
        if (oo0o0ooo.OooOOo0 == 2) {
            map.put(o0OO000o.o00O0000, this.OooO0O0.OooOOo0.OooOO0o + "");
            map.put(o0OO000o.o00, this.OooO0O0.OooOOo0.OooOO0O + "");
        }
        map.put(o0OO000o.o000o0OO, oo0o0ooo.OooOO0 + "");
        if (oo0o0ooo.OooOO0O == 0) {
            map.put(o0OO000o.o000o0Oo, oo0o0ooo.OooOOO + "");
        }
        return map;
    }

    public void OooO00o(o00O0 o00o0, o00O000 o00o000, ErrorInfo errorInfo) {
        String str;
        HashMap<String, Long> map;
        try {
            HashMap<String, String> mapOooO00o = o0OO000.OooO00o(o00o0.OooOOo0, o0OO000o.o0ooOoO);
            OooO00o(mapOooO00o, o00o000.OooO00o, "");
            mapOooO00o.put(o0OO000o.o000oo0o, errorInfo.msg);
            mapOooO00o.put(o0OO000o.o000ooO, errorInfo.platFormCode);
            if (!"10003".equals(errorInfo.platFormCode) || o00o000.OooO00o.OooO0OO != 4) {
                if (o00o000.OooO00o.OooO0OO == 23 && errorInfo.platFormMsg.contains("UNKNOWN_ERROR")) {
                    mapOooO00o.put(o0OO000o.o000ooOO, "UNKNOWN_ERROR");
                } else {
                    str = errorInfo.platFormMsg;
                }
                map = o00o0.OooOOo0.OooOo.OooO0o0;
                if (map != null && map.get(o00o000.OooO00o.OooO0Oo + o00o000.OooO00o.OooO0o0 + "LoadSuc") != null) {
                    mapOooO00o.put("duration", (SystemClock.elapsedRealtime() - o00o0.OooOOo0.OooOo.OooO0o0.get(o00o000.OooO00o.OooO0Oo + o00o000.OooO00o.OooO0o0 + "LoadSuc").longValue()) + "");
                }
                o0OO000.OooO00o(o0OO000o.o0ooOOo, mapOooO00o, new Object[0]);
            }
            str = oOO00O0.networkErrorMsg;
            mapOooO00o.put(o0OO000o.o000ooOO, str);
            map = o00o0.OooOOo0.OooOo.OooO0o0;
            if (map != null) {
                mapOooO00o.put("duration", (SystemClock.elapsedRealtime() - o00o0.OooOOo0.OooOo.OooO0o0.get(o00o000.OooO00o.OooO0Oo + o00o000.OooO00o.OooO0o0 + "LoadSuc").longValue()) + "");
            }
            o0OO000.OooO00o(o0OO000o.o0ooOOo, mapOooO00o, new Object[0]);
        } catch (Exception unused) {
        }
    }

    public void OooO00o(o00O0 o00o0, o00O000 o00o000, ErrorInfo errorInfo, String str, String str2) {
        try {
            HashMap<String, String> mapOooO00o = o0OO000.OooO00o(o00o0.OooOOo0, str2);
            OooO00o(mapOooO00o, o00o000.OooO00o, "");
            mapOooO00o.put(o0OO000o.o000oo0o, errorInfo.msg);
            mapOooO00o.put(o0OO000o.o000ooO, errorInfo.platFormCode);
            mapOooO00o.put(o0OO000o.o000ooOO, errorInfo.platFormMsg);
            HashMap<String, Long> map = o00o0.OooOOo0.OooOo.OooO0o0;
            if (map != null && map.get(o00o000.OooO00o.OooO0Oo + o00o000.OooO00o.OooO0o0) != null) {
                mapOooO00o.put("duration", (SystemClock.elapsedRealtime() - o00o0.OooOOo0.OooOo.OooO0o0.get(o00o000.OooO00o.OooO0Oo + o00o000.OooO00o.OooO0o0).longValue()) + "");
            }
            o0OO000.OooO00o(str, mapOooO00o, new Object[0]);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x010c  */
    /* JADX WARN: Code duplicated, block: B:32:0x0143  */
    /* JADX WARN: Code duplicated, block: B:33:0x0146  */
    public void OooO00o(o00O0 o00o0, o00O000 o00o000, oo00o oo00oVar) {
        StringBuilder sbAppend;
        Long l;
        String str;
        JSONObject jSONObject;
        try {
            oO0O0OoO oo0o0ooo = oo00oVar.getBaseAdConfig().OooO00o;
            if (o00o0 != null) {
                HashMap<String, String> mapOooO00o = o0OO000.OooO00o(o00o0.OooOOo0, o0OO000o.o0ooOO0);
                OooO00o(mapOooO00o, o00o000.OooO00o, oo00oVar.getBiddingEcpm() + "");
                if (o00o000.OooO00o.OooOO0O != 1 || o00o0.OooOOo0.OooOo.OooO0OO.get("biddingFloor") == null) {
                    if (o00o000.OooO00o.OooOO0O == 0 && o00o0.OooOOo0.OooOo.OooO0OO.get(o00o000.OooO00o.OooOOO + "") != null) {
                        sbAppend = new StringBuilder().append(SystemClock.elapsedRealtime() - o00o0.OooOOo0.OooOo.OooO0OO.get(o00o000.OooO00o.OooOOO + "").longValue()).append("");
                    }
                    l = o00o0.OooOOo0.OooOo.OooO0o0.get(oo0o0ooo.OooO0Oo + oo0o0ooo.OooO0o0 + "LoadSuc");
                    if (l != null && l.longValue() > 0) {
                        jSONObject = new JSONObject();
                        if (!TextUtils.isEmpty(oo00oVar.csjPriceMethod)) {
                            jSONObject.put(o0OO000o.o00O0OO, oo00oVar.csjPriceMethod);
                        }
                        jSONObject.put("ubixm_ads_render_duration", (SystemClock.elapsedRealtime() - l.longValue()) + "");
                        mapOooO00o.put(o0OO000o.o00O000, jSONObject.toString());
                    }
                    if (o00o0.OooO0OO.OooOO0) {
                        str = "1";
                    } else {
                        str = "2";
                    }
                    mapOooO00o.put(o0OO000o.o00Oo0oO, str);
                    o0OO000.OooO00o(o0OO000o.o00oO0O, mapOooO00o, new Object[0]);
                }
                sbAppend = new StringBuilder().append(SystemClock.elapsedRealtime() - o00o0.OooOOo0.OooOo.OooO0OO.get("biddingFloor").longValue()).append("");
                mapOooO00o.put("duration", sbAppend.toString());
                l = o00o0.OooOOo0.OooOo.OooO0o0.get(oo0o0ooo.OooO0Oo + oo0o0ooo.OooO0o0 + "LoadSuc");
                if (l != null) {
                    jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(oo00oVar.csjPriceMethod)) {
                        jSONObject.put(o0OO000o.o00O0OO, oo00oVar.csjPriceMethod);
                    }
                    jSONObject.put("ubixm_ads_render_duration", (SystemClock.elapsedRealtime() - l.longValue()) + "");
                    mapOooO00o.put(o0OO000o.o00O000, jSONObject.toString());
                }
                if (o00o0.OooO0OO.OooOO0) {
                    str = "1";
                } else {
                    str = "2";
                }
                mapOooO00o.put(o0OO000o.o00Oo0oO, str);
                o0OO000.OooO00o(o0OO000o.o00oO0O, mapOooO00o, new Object[0]);
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public void OooO00o(o00O0 o00o0, oO0O0OoO oo0o0ooo, ErrorInfo errorInfo) {
        o0OO000.OooO00o(o0OO000o.OoooOO0, o0OO000.OooO00o(o00o0.OooOOo0, oo0o0ooo, errorInfo), new Object[0]);
    }

    public void OooO00o(o00O0 o00o0, oO0O0OoO oo0o0ooo, String str, String str2, String str3) {
        try {
            HashMap<String, String> mapOooO00o = o0OO000.OooO00o(o00o0.OooOOo0, str2);
            mapOooO00o.put(o0OO000o.o000oo0o, str3);
            OooO00o(mapOooO00o, oo0o0ooo, "");
            try {
                mapOooO00o.put("duration", (SystemClock.elapsedRealtime() - o00o0.OooOOo0.OooOo.OooOO0O.get(oo0o0ooo.OooO0Oo + oo0o0ooo.OooO0o0).longValue()) + "");
            } catch (Exception e) {
                ooooO000.OooO00o(e);
            }
            mapOooO00o.remove(o0OO000o.o00O0000);
            mapOooO00o.remove(o0OO000o.o00);
            o0OO000.OooO00o(str, mapOooO00o, new Object[0]);
        } catch (Exception e2) {
            ooooO000.OooO00o(e2);
        }
    }

    public void OooO00o(o00O0 o00o0, oo00o oo00oVar) {
        try {
            HashMap<String, String> mapOooO00o = o0OO000.OooO00o(o00o0.OooOOo0, o0OO000o.oo0o0Oo);
            OooO00o(mapOooO00o, oo00oVar.getBaseAdConfig().OooO00o, oo00oVar.getBiddingEcpm() + "");
            o0OO000.OooO00o(o0OO000o.o0OO00O, mapOooO00o, new Object[0]);
        } catch (Exception unused) {
        }
    }

    public void OooO00o(o00O0 o00o0, oo00o oo00oVar, o0O000Oo o0o000oo) {
        OooO00o(o00o0, oo00oVar, o0o000oo.OooO0o, o0o000oo.OooO0oO);
    }

    public void OooO00o(o00O0 o00o0, oo00o oo00oVar, String str, String str2) {
        try {
            HashMap<String, String> mapOooO00o = o0OO000.OooO00o(o00o0.OooOOo0, str);
            OooO00o(mapOooO00o, oo00oVar.getBaseAdConfig().OooO00o, oo00oVar.getBiddingEcpm() + "");
            mapOooO00o.put(o0OO000o.o000oo0o, str2);
            o0OO000.OooO00o(o0OO000o.o0O0O00, mapOooO00o, new Object[0]);
        } catch (Exception e) {
            ooooO000.OooO0O0("-----AbsController", "e " + e.getMessage());
        }
    }

    public void OooO00o(String str, String str2) {
        ooooO000.OooO0O0(str, str2);
    }

    public boolean OooO00o(ErrorInfo errorInfo) {
        if (errorInfo == null) {
            return false;
        }
        try {
            Object obj = errorInfo.object;
            if (obj instanceof oo00o) {
                oo00o oo00oVar = (oo00o) obj;
                if (!"04".equals(oo00oVar.adType)) {
                    return false;
                }
                if (this.OooO0Oo.contains(Integer.valueOf(oo00oVar.bannerAdapterHashCode))) {
                    return true;
                }
                int i = oo00oVar.bannerAdapterHashCode;
                if (i != 0) {
                    this.OooO0Oo.add(Integer.valueOf(i));
                }
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean OooO00o(o00O0 o00o0) {
        return o00o0.OooO0o0;
    }

    public boolean OooO00o(o00O0 o00o0, oO0O0OoO oo0o0ooo) {
        int i = oo0o0ooo.OooO0OO;
        try {
            if (this.OooO0OO.contains(Integer.valueOf(i))) {
                return true;
            }
            Class.forName(OooO00o(i));
            this.OooO0OO.add(Integer.valueOf(i));
            ooooO000.OooO0Oo("已接入SDK: " + i + "  " + oO00000o.o0O0O00.OooO00o(i));
            return true;
        } catch (Throwable th) {
            ooooO000.OooO0OO("接入SDK检测异常: ", " Throwable：f" + th.getMessage());
            return false;
        }
    }

    public boolean OooO00o(oo00o oo00oVar) {
        if (oo00oVar == null) {
            return false;
        }
        try {
            if (!"04".equals(oo00oVar.adType)) {
                return false;
            }
            if (this.OooO0Oo.contains(Integer.valueOf(oo00oVar.bannerAdapterHashCode))) {
                return true;
            }
            int i = oo00oVar.bannerAdapterHashCode;
            if (i != 0) {
                this.OooO0Oo.add(Integer.valueOf(i));
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ErrorInfo OooO0O0(o00O000 o00o000, o00O o00o) {
        ErrorInfo errorInfoOooO00o = OooO00o(o00o000, o00o);
        if (errorInfoOooO00o != null) {
            return errorInfoOooO00o;
        }
        if (o00o000.OooO00o.OooOOo0 != 2) {
            return new ErrorInfo(o0OO000o.OooooO0, o0OO000o.OooooOO);
        }
        return null;
    }

    public void OooO0O0(o00O0 o00o0, o00O000 o00o000, ErrorInfo errorInfo) {
        String str;
        Long l;
        try {
            HashMap<String, String> mapOooO00o = o0OO000.OooO00o(o00o0.OooOOo0, o0OO000o.o00oO0o);
            mapOooO00o.put(o0OO000o.o000oo0o, errorInfo.msg);
            mapOooO00o.put(o0OO000o.o000ooO, errorInfo.platFormCode);
            if (!"10003".equals(errorInfo.platFormCode) || o00o000.OooO00o.OooO0OO != 4) {
                if (o00o000.OooO00o.OooO0OO == 23 && errorInfo.platFormMsg.contains("UNKNOWN_ERROR")) {
                    mapOooO00o.put(o0OO000o.o000ooOO, "UNKNOWN_ERROR");
                } else {
                    str = errorInfo.platFormMsg;
                }
                oO0O0OoO oo0o0ooo = o00o000.OooO00o;
                OooO00o(mapOooO00o, oo0o0ooo, "");
                l = o00o0.OooOOo0.OooOo.OooO0o0.get(oo0o0ooo.OooO0Oo + oo0o0ooo.OooO0o0);
                if (l != null && l.longValue() > 0) {
                    mapOooO00o.put("duration", (SystemClock.elapsedRealtime() - l.longValue()) + "");
                }
                o0OO000.OooO00o(o0OO000o.oo000o, mapOooO00o, new Object[0]);
            }
            str = oOO00O0.networkErrorMsg;
            mapOooO00o.put(o0OO000o.o000ooOO, str);
            oO0O0OoO oo0o0ooo2 = o00o000.OooO00o;
            OooO00o(mapOooO00o, oo0o0ooo2, "");
            l = o00o0.OooOOo0.OooOo.OooO0o0.get(oo0o0ooo2.OooO0Oo + oo0o0ooo2.OooO0o0);
            if (l != null) {
                mapOooO00o.put("duration", (SystemClock.elapsedRealtime() - l.longValue()) + "");
            }
            o0OO000.OooO00o(o0OO000o.oo000o, mapOooO00o, new Object[0]);
        } catch (Exception unused) {
        }
    }

    public void OooO0O0(o00O0 o00o0, oo00o oo00oVar) {
        try {
            oO0O0OoO oo0o0ooo = oo00oVar.getBaseAdConfig().OooO00o;
            HashMap<String, String> mapOooO00o = o0OO000.OooO00o(o00o0.OooOOo0, o0OO000o.o00ooo);
            Long l = o00o0.OooOOo0.OooOo.OooO0o0.get(oo0o0ooo.OooO0Oo + oo0o0ooo.OooO0o0);
            if (l != null && l.longValue() > 0) {
                mapOooO00o.put("duration", (SystemClock.elapsedRealtime() - l.longValue()) + "");
                o00o0.OooOOo0.OooOo.OooO0o0.put(oo0o0ooo.OooO0Oo + oo0o0ooo.OooO0o0 + "LoadSuc", Long.valueOf(SystemClock.elapsedRealtime()));
            }
            if (!TextUtils.isEmpty(oo00oVar.csjPriceMethod)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(o0OO000o.o00O0OO, oo00oVar.csjPriceMethod);
                mapOooO00o.put(o0OO000o.o00O000, jSONObject.toString());
            }
            OooO00o(mapOooO00o, oo0o0ooo, oo00oVar.getBiddingEcpm() + "");
            mapOooO00o.put(o0OO000o.o00Oo0oO, o00o0.OooO0OO.OooOO0 ? "1" : "2");
            o0OO000.OooO00o(o0OO000o.o00o0O, mapOooO00o, new Object[0]);
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public void OooO0O0(o00O0 o00o0, oo00o oo00oVar, String str, String str2) {
        try {
            oO0O0OoO oo0o0ooo = oo00oVar.getBaseAdConfig().OooO00o;
            HashMap<String, String> mapOooO00o = o0OO000.OooO00o(o00o0.OooOOo0, str2);
            Long l = o00o0.OooOOo0.OooOo.OooO0o0.get(oo0o0ooo.OooO0Oo + oo0o0ooo.OooO0o0);
            if (l != null && l.longValue() > 0) {
                mapOooO00o.put("duration", (SystemClock.elapsedRealtime() - l.longValue()) + "");
            }
            OooO00o(mapOooO00o, oo0o0ooo, oo00oVar.getBiddingEcpm() + "");
            o0OO000.OooO00o(str, mapOooO00o, new Object[0]);
        } catch (Exception unused) {
        }
    }

    public void OooO0O0(String str) {
        ooooO000.OooO0O0(OooO00o, str);
    }
}
