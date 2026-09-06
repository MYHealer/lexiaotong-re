package com.ubixnow.ooooo;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e {
    private static final String OooO00o = "---.UbixDataHelper";
    private static final String[] OooO0O0 = {"sensorsdata_app_visual_properties"};
    private static final Pattern OooO0OO = Pattern.compile("^((?!^distinct_id$|^original_id$|^time$|^properties$|^id$|^first_id$|^second_id$|^users$|^events$|^event$|^user_id$|^date$|^datetime$)[a-zA-Z_$][a-zA-Z\\d_$]{0,99})$", 2);

    public static JSONObject OooO00o(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("$lib_method", "autoTrack");
        } catch (JSONException e) {
            oOO0O0O.OooO00o(e);
        }
        return jSONObject;
    }

    public static void OooO00o(String str) throws oOo0o00 {
        if (str == null || str.length() < 1) {
            throw new oOo0o00("The key is empty.");
        }
        if (!OooO0OO.matcher(str).matches()) {
            throw new oOo0o00("The key '" + str + "' is invalid.");
        }
    }

    public static String OooO0O0(String str) {
        if (str == null || str.length() <= 8191) {
            return str;
        }
        String str2 = str.substring(0, 8191) + "$";
        ooooO000.OooO00o("The property value is too long. property=" + str2);
        return str2;
    }

    public static void OooO0O0(JSONObject jSONObject) throws oOo0o00 {
        StringBuilder sbAppend;
        if (jSONObject == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            OooO00o(next);
            try {
                Object obj = jSONObject.get(next);
                if (obj == JSONObject.NULL) {
                    itKeys.remove();
                } else {
                    if (obj instanceof List) {
                        List list = (List) obj;
                        int size = list.size();
                        JSONArray jSONArray = new JSONArray();
                        for (int i = 0; i < size; i++) {
                            jSONArray.put(list.get(i));
                        }
                        jSONObject.put(next, jSONArray);
                        obj = jSONArray;
                    }
                    if (!(obj instanceof CharSequence) && !(obj instanceof Number) && !(obj instanceof JSONArray) && !(obj instanceof Boolean) && !(obj instanceof Date)) {
                        throw new oOo0o00("The property value must be an instance of CharSequence/Number/Boolean/JSONArray/Date/List<String>. [key='" + next + "', value='" + obj.toString() + "', class='" + obj.getClass().getCanonicalName() + "']");
                    }
                    if (obj instanceof JSONArray) {
                        JSONArray jSONArray2 = (JSONArray) obj;
                        int length = jSONArray2.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            if (!(jSONArray2.get(i2) instanceof CharSequence)) {
                                throw new oOo0o00("The array property value must be an instance of List<String> or JSONArray only contains String. [key='" + next + "', value='" + obj.toString() + "']");
                            }
                        }
                    } else if ("app_crashed_reason".equals(next)) {
                        if ((obj instanceof String) && ((String) obj).length() > 16382) {
                            jSONObject.put(next, ((String) obj).substring(0, 16382) + "$");
                            sbAppend = new StringBuilder().append("The property value is too long. [key='").append(next).append("', value='").append(obj.toString());
                            oOO0O0O.OooO00o(OooO00o, sbAppend.append("']").toString());
                        }
                    } else if (!Arrays.asList(OooO0O0).contains(next) && (obj instanceof String) && ((String) obj).length() > 8191) {
                        jSONObject.put(next, ((String) obj).substring(0, 8191) + "$");
                        sbAppend = new StringBuilder().append("The property value is too long. [key='").append(next).append("', value='").append(obj.toString());
                        oOO0O0O.OooO00o(OooO00o, sbAppend.append("']").toString());
                    }
                }
            } catch (JSONException unused) {
                throw new oOo0o00("Unexpected property key. [key='" + next + "']");
            }
        }
    }

    public static void OooO0OO(String str) throws oOo0o00 {
        if (TextUtils.isEmpty(str)) {
            throw new oOo0o00("The value is empty.");
        }
        if (str.length() > 255) {
            throw new oOo0o00("The " + str + " is too long, max length is 255.");
        }
    }
}
