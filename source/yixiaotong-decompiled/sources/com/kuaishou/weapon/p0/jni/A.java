package com.kuaishou.weapon.p0.jni;

import android.content.Context;
import com.kuaishou.weapon.p0.dn;
import com.kuaishou.weapon.p0.w;
import org.json.JSONArray;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class A {
    private static int flag;
    private static JSONArray jsonObject;

    public static JSONArray getJsonObject() {
        return jsonObject;
    }

    public static void setJsonObject(JSONArray jSONArray) {
        jsonObject = jSONArray;
    }

    public A(Context context, int i) {
        flag = i;
        if (Engine.loadSuccess) {
            Engine.getInstance(context).qrs();
        } else {
            setA(context);
        }
    }

    public static void setA(Context context) {
        if (context != null) {
            jsonObject = new w(context).b(flag);
        }
    }

    public static void setE(String str, String str2) {
        try {
            dn dnVarA = dn.a();
            if (dnVarA != null) {
                dnVarA.b(str, str2);
            }
        } catch (Exception unused) {
        }
    }

    public static String getE(String str) {
        try {
            dn dnVarA = dn.a();
            if (dnVarA != null) {
                return dnVarA.a(str, "");
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
