package com.hihonor.adsdk.base.bean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class VideoReportBean {
    private String VideoType;
    private String auStart;
    private int bufferPercent;
    private long bufferPosition;
    private String code;
    private long currentPercent;
    private long currentSecond;
    private int errorType;
    private String hasVoice;
    private boolean isCompleted;
    private int measuredHeight;
    private int measuredWidth;
    private String msg;
    private int playAction;
    private int playerSource = 0;
    private long prepareTime;
    private long remainingTime;
    private String scene;
    private String source;
    private long startToReleaseTime;
    private long totalStartTime;

    public String getAuStart() {
        return this.auStart;
    }

    public int getBufferPercent() {
        return this.bufferPercent;
    }

    public long getBufferPosition() {
        return this.bufferPosition;
    }

    public String getCode() {
        return this.code;
    }

    public long getCurrentPercent() {
        return this.currentPercent;
    }

    public long getCurrentSecond() {
        return this.currentSecond;
    }

    public int getErrorType() {
        return this.errorType;
    }

    public String getHasVoice() {
        return this.hasVoice;
    }

    public int getMeasuredHeight() {
        return this.measuredHeight;
    }

    public int getMeasuredWidth() {
        return this.measuredWidth;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getPlayAction() {
        return this.playAction;
    }

    public int getPlayerSource() {
        return this.playerSource;
    }

    public long getPrepareTime() {
        return this.prepareTime;
    }

    public long getRemainingTime() {
        return this.remainingTime;
    }

    public String getScene() {
        return this.scene;
    }

    public String getSource() {
        return this.source;
    }

    public long getStartToReleaseTime() {
        return this.startToReleaseTime;
    }

    public long getTotalStartTime() {
        return this.totalStartTime;
    }

    public String getVideoType() {
        return this.VideoType;
    }

    public boolean isCompleted() {
        return this.isCompleted;
    }

    public String isHasVoice() {
        return this.hasVoice;
    }

    public void setAuStart(String str) {
        this.auStart = str;
    }

    public void setBufferPercent(int i) {
        this.bufferPercent = i;
    }

    public void setBufferPosition(long j) {
        this.bufferPosition = j;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setCompleted(boolean z) {
        this.isCompleted = z;
    }

    public void setCurrentPercent(long j) {
        this.currentPercent = j;
    }

    public void setCurrentSecond(long j) {
        this.currentSecond = j;
    }

    public void setErrorType(int i) {
        this.errorType = i;
    }

    public void setHasVoice(String str) {
        this.hasVoice = str;
    }

    public void setMeasuredHeight(int i) {
        this.measuredHeight = i;
    }

    public void setMeasuredWidth(int i) {
        this.measuredWidth = i;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setPlayAction(int i) {
        this.playAction = i;
    }

    public void setPlayerSource(int i) {
        this.playerSource = i;
    }

    public void setPrepareTime(long j) {
        this.prepareTime = j;
    }

    public void setRemainingTime(long j) {
        this.remainingTime = j;
    }

    public void setScene(String str) {
        this.scene = str;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setStartToReleaseTime(long j) {
        this.startToReleaseTime = j;
    }

    public void setTotalStartTime(long j) {
        this.totalStartTime = j;
    }

    public void setVideoType(String str) {
        this.VideoType = str;
    }
}
