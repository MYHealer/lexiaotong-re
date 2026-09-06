package com.hihonor.updater.installsdk.api;

import android.text.TextUtils;
import com.hihonor.updater.installsdk.c.a;
import com.hihonor.updater.installsdk.c.c;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class TraceUrlData {
    private static final String TAG = "TraceUrlData";
    private final HashMap<String, ReportUrl> mUrlData = new HashMap<>();

    private interface ADEventOld {
        public static final String THIRD_APP_DOWNLOAD_FAIL = "2";
        public static final String THIRD_APP_INSTALL_FAIL = "3";
    }

    private interface JsonKeyOld {
        public static final String KEY_COMMON_TRACK = "commonTrack";
        public static final String KEY_DOWNLOAD_SUCCESS = "downloadSuccess";
        public static final String KEY_EVENT_TYPE = "eventType";
        public static final String KEY_INSTALL_SUCCESS = "installSuccess";
        public static final String KEY_TRACK_LIST = "trackList";
        public static final String KEY_TRACK_URL = "trackUrl";
    }

    public interface ReplaceFlagOld {
        public static final String ACTION = "__ACTION__";
    }

    public static final class ReportUrl {
        private String type;
        private HashSet<String> urlList;

        public ReportUrl() {
        }

        public ReportUrl(String str) {
            this.type = str;
        }

        public void addUrl(String str) {
            if (this.urlList == null) {
                this.urlList = new HashSet<>();
            }
            this.urlList.add(str);
        }

        public String getType() {
            return this.type;
        }

        public HashSet<String> getUrlList() {
            return this.urlList;
        }

        public void readFromJSON(String str) {
            JSONArray jSONArray;
            int length;
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.type = c.d(jSONObject, "type");
                String strD = c.d(jSONObject, "urlList");
                if (TextUtils.isEmpty(strD) || (length = (jSONArray = new JSONArray(strD)).length()) <= 0) {
                    return;
                }
                if (this.urlList == null) {
                    this.urlList = new HashSet<>();
                }
                for (int i = 0; i < length; i++) {
                    this.urlList.add(jSONArray.getString(i));
                }
            } catch (Throwable th) {
                a.b(TraceUrlData.TAG, "ReportUrl readFromJSON error " + th);
            }
        }

        public void setType(String str) {
            this.type = str;
        }

        public void setUrlList(HashSet<String> hashSet) {
            this.urlList = hashSet;
        }

        public JSONObject writeToJSON() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.type);
                HashSet<String> hashSet = this.urlList;
                if (hashSet != null && !hashSet.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    for (String str : this.urlList) {
                        if (str != null) {
                            jSONArray.put(str);
                        }
                    }
                    jSONObject.put("urlList", jSONArray);
                }
            } catch (Throwable th) {
                a.b(TraceUrlData.TAG, "ReportUrl writeToJSON error " + th);
            }
            return jSONObject;
        }
    }

    public interface UrlType {
        public static final String DOWNLOAD_FAIL = "downloadFail";
        public static final String DOWNLOAD_INSTALL_CANCEL = "downloadInstallCancel";
        public static final String DOWNLOAD_PAUSE = "downloadPause";
        public static final String DOWNLOAD_START = "downloadStart";
        public static final String DOWNLOAD_SUCCESS = "downloadSuccess";
        public static final String INSTALL_FAIL = "installFail";
        public static final String INSTALL_START = "installStart";
        public static final String INSTALL_SUCCESS = "installSuccess";
    }

    private String getFirstUrl(String str) {
        HashSet<String> urlList;
        ReportUrl reportUrl = this.mUrlData.get(str);
        if (reportUrl == null || (urlList = reportUrl.getUrlList()) == null || urlList.isEmpty()) {
            return null;
        }
        return urlList.iterator().next();
    }

    public TraceUrlData addReportUrl(String str, String str2) {
        ReportUrl reportUrlComputeIfAbsent = this.mUrlData.computeIfAbsent(str, new Function() { // from class: com.hihonor.updater.installsdk.api.TraceUrlData$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return new TraceUrlData.ReportUrl((String) obj);
            }
        });
        if (reportUrlComputeIfAbsent != null) {
            reportUrlComputeIfAbsent.addUrl(str2);
        }
        return this;
    }

    public HashSet<String> getReportUrl(String str) {
        ReportUrl reportUrl = this.mUrlData.get(str);
        if (reportUrl == null) {
            return null;
        }
        return reportUrl.getUrlList();
    }

    public void readFromJSON(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                ReportUrl reportUrl = new ReportUrl();
                reportUrl.readFromJSON(jSONArray.getJSONObject(i).toString());
                this.mUrlData.put(reportUrl.type, reportUrl);
            }
        } catch (Throwable th) {
            a.b(TAG, "readFromJSON error " + th);
        }
    }

    public void readFromJSONOld(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                JSONArray jSONArray = jSONObject.getJSONArray(JsonKeyOld.KEY_TRACK_LIST);
                if (jSONArray != null && jSONArray.length() != 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String string = jSONObject2.getString(JsonKeyOld.KEY_EVENT_TYPE);
                            if ("downloadSuccess".equals(string)) {
                                addReportUrl("downloadSuccess", jSONObject2.getString(JsonKeyOld.KEY_TRACK_URL));
                            } else if ("installSuccess".equals(string)) {
                                addReportUrl("installSuccess", jSONObject2.getString(JsonKeyOld.KEY_TRACK_URL));
                            }
                        } catch (Throwable th) {
                            a.b(TAG, "readFromJSONOld err1 " + th);
                        }
                    }
                }
            } catch (Throwable th2) {
                a.b(TAG, "readFromJSONOld err2 " + th2);
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray(JsonKeyOld.KEY_COMMON_TRACK);
            if (jSONArray2 == null || jSONArray2.length() == 0) {
                return;
            }
            String string2 = jSONArray2.getString(0);
            if (TextUtils.isEmpty(string2)) {
                return;
            }
            addReportUrl(UrlType.DOWNLOAD_FAIL, string2.replace("__ACTION__", "2"));
            addReportUrl(UrlType.INSTALL_FAIL, string2.replace("__ACTION__", "3"));
        } catch (Throwable th3) {
            a.b(TAG, "readFromJSONOld err3 " + th3);
        }
    }

    public JSONArray writeToJSON() {
        HashSet<String> urlList;
        JSONArray jSONArray = new JSONArray();
        try {
            for (Map.Entry<String, ReportUrl> entry : this.mUrlData.entrySet()) {
                String key = entry.getKey();
                ReportUrl value = entry.getValue();
                if (key != null && value != null && (urlList = value.getUrlList()) != null && !urlList.isEmpty()) {
                    jSONArray.put(value.writeToJSON());
                }
            }
        } catch (Throwable th) {
            a.b(TAG, "writeToJSON error " + th);
        }
        return jSONArray;
    }

    public JSONObject writeToJSONOld() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            String firstUrl = getFirstUrl("downloadSuccess");
            if (!TextUtils.isEmpty(firstUrl)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(JsonKeyOld.KEY_EVENT_TYPE, "downloadSuccess");
                jSONObject2.put(JsonKeyOld.KEY_TRACK_URL, firstUrl);
                jSONArray.put(jSONObject2);
            }
            String firstUrl2 = getFirstUrl("installSuccess");
            if (!TextUtils.isEmpty(firstUrl2)) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(JsonKeyOld.KEY_EVENT_TYPE, "installSuccess");
                jSONObject3.put(JsonKeyOld.KEY_TRACK_URL, firstUrl2);
                jSONArray.put(jSONObject3);
            }
            jSONObject.put(JsonKeyOld.KEY_TRACK_LIST, jSONArray);
            String firstUrl3 = getFirstUrl(UrlType.DOWNLOAD_FAIL);
            String strReplace = !TextUtils.isEmpty(firstUrl3) ? firstUrl3.replace(URLEncoder.encode("\"action\":2", "UTF-8"), URLEncoder.encode("\"action\":__ACTION__", "UTF-8")) : null;
            if (TextUtils.isEmpty(strReplace)) {
                String firstUrl4 = getFirstUrl(UrlType.INSTALL_FAIL);
                if (!TextUtils.isEmpty(firstUrl4)) {
                    strReplace = firstUrl4.replace(URLEncoder.encode("\"action\":3", "UTF-8"), URLEncoder.encode("\"action\":__ACTION__", "UTF-8"));
                }
            }
            if (!TextUtils.isEmpty(strReplace)) {
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(strReplace);
                jSONObject.put(JsonKeyOld.KEY_COMMON_TRACK, jSONArray2);
            }
            return jSONObject;
        } catch (Throwable th) {
            a.b(TAG, "writeToJSONOld error " + th);
            return null;
        }
    }
}
