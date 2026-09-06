package com.ubixnow.ooooo;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oO0OO0O implements InvocationHandler {
    private static final String OooO00o = "----PH :";
    private static int OooO0O0 = -1;
    public static final HashMap<String, String> OooO0OO = new HashMap<>();
    private static String OooO0Oo;
    private static boolean OooO0o0;
    private final Object OooO0o;

    public oO0OO0O(Object obj) {
        this.OooO0o = obj;
    }

    public static long OooO00o(String str) {
        try {
            if (!TextUtils.isEmpty(str) && str.length() > 1 && (str.endsWith("L") || str.endsWith(com.kuaishou.weapon.p0.t.d))) {
                str = str.substring(0, str.length() - 1);
            }
            return Long.parseLong(str);
        } catch (Exception unused) {
            return -1L;
        }
    }

    public static void OooO00o(o00O000 o00o000, String str) {
        JSONObject jSONObjectOptJSONObject;
        Class<?> cls;
        try {
            OooO0OO.put(OooO00o(o00o000.OooO00o.OooO0o0) + "", o00o000.OooO00o.OooO0Oo);
            if (!TextUtils.isEmpty(o00o000.OooO00o.OooOOO0) && (jSONObjectOptJSONObject = new JSONObject(o00o000.OooO00o.OooOOO0).optJSONObject("advCo")) != null) {
                String strOptString = jSONObjectOptJSONObject.optString("ks_conf_support_sdk_vers");
                if (!TextUtils.isEmpty(strOptString)) {
                    String[] strArrSplit = strOptString.split(",");
                    if (strArrSplit.length > 0 && !TextUtils.isEmpty(str) && Arrays.asList(strArrSplit).contains(str)) {
                        try {
                            OooO0o0 = true;
                            if (OooO0O0 > -1) {
                                return;
                            }
                            OooO0O0 = 0;
                            try {
                                cls = Class.forName("com.kwad.sdk.core.a.d");
                            } catch (ClassNotFoundException e) {
                                Class<?> cls2 = Class.forName("com.kwad.sdk.core.kwai.d");
                                ooooO000.OooO00o(e);
                                cls = cls2;
                            }
                            Field[] declaredFields = cls.getDeclaredFields();
                            if (declaredFields.length != 1) {
                                return;
                            }
                            Method method = null;
                            Method method2 = null;
                            for (Method method3 : cls.getDeclaredMethods()) {
                                if (!"getResponseData".equals(method3.getName()) && !"stub".equals(method3.getName())) {
                                    Class<?>[] parameterTypes = method3.getParameterTypes();
                                    if (parameterTypes.length == 0) {
                                        ooooO000.OooO0O0(OooO00o, "method static name: " + method3.getName());
                                        method = method3;
                                    } else if (parameterTypes.length == 1 && parameterTypes[0] == String.class) {
                                        ooooO000.OooO0O0(OooO00o, "method name: " + method3.getName());
                                        method2 = method3;
                                    }
                                }
                            }
                            if (method != null) {
                                ooooO000.OooO0O0(OooO00o, "invoke: " + method.getName());
                                method.setAccessible(true);
                                method.invoke(null, new Object[0]);
                            }
                            if (method2 != null) {
                                OooO0Oo = method2.getName();
                                Field field = declaredFields[0];
                                field.setAccessible(true);
                                Object obj = field.get(null);
                                oO0OO0O oo0oo0o = new oO0OO0O(obj);
                                if (obj != null) {
                                    field.set(null, Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class[]{field.getType()}, oo0oo0o));
                                    OooO0O0 = 1;
                                    return;
                                } else {
                                    OooO0o0 = false;
                                    OooO0O0 = -1;
                                    return;
                                }
                            }
                            return;
                        } catch (Throwable th) {
                            OooO0o0 = false;
                            ooooO000.OooO00o(th);
                            return;
                        }
                    }
                }
            }
            OooO0o0 = false;
        } catch (Exception e2) {
            ooooO000.OooO00o(e2);
        }
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        String str;
        try {
            if (!OooO0o0) {
                return method.invoke(this.OooO0o, objArr);
            }
            if (method.getName().equals(OooO0Oo)) {
                if (ooooO000.OooO00o) {
                    ooooO000.OooO0O0(OooO00o, "reqParams:" + objArr[0]);
                }
                if (!((String) objArr[0]).matches("^\\{.*\\}$")) {
                    return method.invoke(this.OooO0o, objArr);
                }
                JSONObject jSONObject = new JSONObject((String) objArr[0]);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("appInfo");
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("impInfo");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0 && jSONObjectOptJSONObject != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                        String strOptString = jSONObjectOptJSONObject.optString("appId");
                        String strOptString2 = jSONObjectOptJSONObject2.optString("posId");
                        StringBuilder sbAppend = new StringBuilder().append("appId:").append(strOptString).append("  posId:").append(strOptString2).append(" ubix slot map:");
                        HashMap<String, String> map = OooO0OO;
                        ooooO000.OooO0O0(OooO00o, sbAppend.append(map.toString()).toString());
                        if (map.containsKey(strOptString2)) {
                            if (Objects.equals(map.get(strOptString2), strOptString)) {
                                str = "rp not did! ";
                            } else {
                                jSONObjectOptJSONObject.put("appId", map.get(strOptString2));
                                objArr[0] = jSONObject.toString();
                                if (ooooO000.OooO00o) {
                                    str = "rp succ! " + objArr[0];
                                }
                            }
                            ooooO000.OooO0O0(OooO00o, str);
                        }
                    }
                }
            }
            return method.invoke(this.OooO0o, objArr);
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }
}
