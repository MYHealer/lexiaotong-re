package com.meishu.sdk.core.utils;

import com.google.gson.Gson;
import com.meishu.sdk.core.AdSdk;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: RecordUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap<String, a> f4949a = new HashMap<>();
    public static final Gson b = new Gson();
    public static HashMap<String, HashMap<String, RecordBean>> c;

    /* JADX INFO: compiled from: RecordUtil.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f4950a;
        public boolean b;
    }

    public static void a(String str, int i) {
        try {
            HashMap<String, RecordBean> mapA = a();
            if (mapA == null) {
                mapA = new HashMap<>();
            }
            RecordBean recordBean = mapA.get(str);
            if (recordBean == null) {
                recordBean = new RecordBean();
            }
            recordBean.setPid(str);
            switch (i) {
                case 1:
                    recordBean.setLoadNum(recordBean.getLoadNum() + 1);
                    break;
                case 2:
                    recordBean.setLoadSucc(recordBean.getLoadSucc() + 1);
                    break;
                case 3:
                    recordBean.setExposureNum(recordBean.getExposureNum() + 1);
                    break;
                case 4:
                    recordBean.setClickNum(recordBean.getClickNum() + 1);
                    break;
                case 5:
                    recordBean.setDynamicClickNum(recordBean.getDynamicClickNum() + 1);
                    break;
                case 6:
                    recordBean.setLastDynamicLoadedTime(System.currentTimeMillis());
                    break;
                case 7:
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    recordBean.setLastDynamicClickTime(jCurrentTimeMillis);
                    recordBean.setLastClickTime(jCurrentTimeMillis);
                    q.a().b("last_dynamic_time", jCurrentTimeMillis);
                    q.a().b("last_click_time", jCurrentTimeMillis);
                    break;
                case 8:
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    recordBean.setLastClickTime(jCurrentTimeMillis2);
                    q.a().b("last_click_time", jCurrentTimeMillis2);
                    break;
            }
            mapA.put(str, recordBean);
            a(mapA);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(HashMap<String, RecordBean> map) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
            String str = simpleDateFormat.format(new Date(jCurrentTimeMillis));
            if (c == null) {
                c = new HashMap<>();
            }
            c.put(str, map);
            RecordMapBean recordMapBean = new RecordMapBean();
            recordMapBean.setDateRecordMap(c);
            q.a().b("record_data", b.toJson(recordMapBean));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static HashMap<String, RecordBean> a() {
        String string;
        try {
            if (q.a().a("record_data")) {
                string = q.a().a("record_data", "");
            } else {
                string = AdSdk.getSharedPreferences().getString("record_data", "");
            }
            RecordMapBean recordMapBean = (RecordMapBean) b.fromJson(string, RecordMapBean.class);
            if (recordMapBean == null) {
                return null;
            }
            HashMap<String, HashMap<String, RecordBean>> dateRecordMap = recordMapBean.getDateRecordMap();
            if (dateRecordMap == null) {
                dateRecordMap = new HashMap<>();
            }
            Calendar calendar = Calendar.getInstance();
            return dateRecordMap.get(String.format("%04d-%02d-%02d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5))));
        } catch (Throwable unused) {
            return null;
        }
    }
}
