package com.icbc.paysdk.services;

import android.util.Log;
import com.icbc.paysdk.constants.Constants;
import com.icbc.paysdk.model.PayList;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class JsonParse {
    public static PayList parsePayList(String str) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(Constants.checkdate);
            String string2 = jSONObject.getString(Constants.payList);
            Log.i(Constants.LogFlag, "parsePayList 中：json.getString(\"checkDate\") = " + string + "  json.getString(\"payList\") = " + string2);
            date = simpleDateFormat.parse(string);
            Log.i(Constants.LogFlag, "parsePayList 中：checkDate = " + date);
            for (String str2 : string2.split("\\|")) {
                Log.i(Constants.LogFlag, "parsePayList 中：S = " + str2);
                arrayList.add(Integer.valueOf(Integer.parseInt(str2)));
            }
            Log.i(Constants.LogFlag, "parsePayList 中：paylist = " + arrayList.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        PayList payList = new PayList();
        payList.setCheckDate(date);
        payList.setPayList(arrayList);
        return payList;
    }
}
