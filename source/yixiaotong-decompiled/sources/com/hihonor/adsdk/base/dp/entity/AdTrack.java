package com.hihonor.adsdk.base.dp.entity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class AdTrack {
    public long id;
    private long time = 0;
    private String trackUrl = "";
    private int trackingType = 0;
    private int reportCnt = 0;
    private int reportState = 0;
    private long reportTime = 0;
    private String method = "";
    private String body = "";
    private String headers = "";
    private String adUnitId = "";
    private String adId = "";
    private String requestId = "";
    private String recordId = "";
    private String recordIds = "";
    private int urlType = 0;

    public String getAdId() {
        return this.adId;
    }

    public String getAdUnitId() {
        return this.adUnitId;
    }

    public String getBody() {
        return this.body;
    }

    public String getHeaders() {
        return this.headers;
    }

    public long getId() {
        return this.id;
    }

    public String getMethod() {
        return this.method;
    }

    public String getRecordId() {
        return this.recordId;
    }

    public String getRecordIds() {
        return this.recordIds;
    }

    public int getReportCnt() {
        return this.reportCnt;
    }

    public int getReportState() {
        return this.reportState;
    }

    public long getReportTime() {
        return this.reportTime;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public long getTime() {
        return this.time;
    }

    public String getTrackUrl() {
        return this.trackUrl;
    }

    public int getTrackingType() {
        return this.trackingType;
    }

    public int getUrlType() {
        return this.urlType;
    }

    public void setAdId(String str) {
        this.adId = str;
    }

    public void setAdUnitId(String str) {
        this.adUnitId = str;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public void setHeaders(String str) {
        this.headers = str;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setRecordId(String str) {
        this.recordId = str;
    }

    public void setRecordIds(String str) {
        this.recordIds = str;
    }

    public void setReportCnt(int i) {
        this.reportCnt = i;
    }

    public void setReportState(int i) {
        this.reportState = i;
    }

    public void setReportTime(long j) {
        this.reportTime = j;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public void setTrackUrl(String str) {
        this.trackUrl = str;
    }

    public void setTrackingType(int i) {
        this.trackingType = i;
    }

    public void setUrlType(int i) {
        this.urlType = i;
    }
}
