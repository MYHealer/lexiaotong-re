package com.ubixnow.core.api;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UMNConfigUserInfo {
    public static int USER_SUBSCRIBER_NO = 1;
    public static int USER_SUBSCRIBER_UNKONWN = 0;
    public static int USER_SUBSCRIBER_YES = 2;
    private Map<String, String> customUserInfo;
    private int subscriber;
    private String userId = "";
    private String channel = "";
    private String subChannel = "";
    private String pubSegmentId = "";

    private String subStringContent(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.length() > 1024 ? "overSize1024:" + str.substring(0, 100) : str;
    }

    public String getChannel() {
        return this.channel;
    }

    public Map<String, String> getCustomUserInfo() {
        return this.customUserInfo;
    }

    public String getPubSegmentId() {
        return this.pubSegmentId;
    }

    public String getSubChannel() {
        return this.subChannel;
    }

    public int getSubScriber() {
        return this.subscriber;
    }

    public String getUserId() {
        return this.userId;
    }

    public void isSubScriber(int i) {
        this.subscriber = i;
    }

    public void setChannel(String str) {
        this.channel = subStringContent(str);
    }

    public void setCustomUserInfo(Map<String, String> map) {
        this.customUserInfo = map;
    }

    public void setPubSegmentId(String str) {
        this.pubSegmentId = subStringContent(str);
    }

    public void setSubChannel(String str) {
        this.subChannel = subStringContent(str);
    }

    public void setUserId(String str) {
        this.userId = subStringContent(str);
    }
}
