package com.huawei.openalliance.ad.beans.metadata;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class VideoInfo implements Serializable {
    private static final long serialVersionUID = 5224357961234973073L;
    private Integer autoPlayAreaRatio;
    private Integer autoStopPlayAreaRatio;
    private int checkSha256Flag;
    private String liveRoomName;

    @com.huawei.openalliance.ad.annotations.a
    private String originalDownloadUrl;
    private String sha256;
    private float splashSwitchTime;

    @com.huawei.openalliance.ad.annotations.a
    private String videoDownloadUrl;
    private int videoDuration;
    private int videoFileSize;
    private Float videoRatio;
    private String videoAutoPlayOnWifi = "y";
    private String videoAutoPlayWithSound = "n";
    private int timeBeforeVideoAutoPlay = 200;
    private int videoPlayMode = 1;
    private int downloadNetwork = 0;
    private String showSoundIcon = "y";
    private int videoType = 0;

    public int B() {
        return this.videoFileSize;
    }

    public void B(int i) {
        this.downloadNetwork = i;
    }

    public void B(String str) {
        this.liveRoomName = str;
    }

    public String C() {
        return this.videoAutoPlayOnWifi;
    }

    public void C(int i) {
        this.videoType = i;
    }

    public String Code() {
        return this.videoDownloadUrl;
    }

    public void Code(float f) {
        this.splashSwitchTime = f;
    }

    public void Code(int i) {
        this.videoDuration = i;
    }

    public void Code(Float f) {
        this.videoRatio = f;
    }

    public void Code(Integer num) {
        this.autoPlayAreaRatio = num;
    }

    public void Code(String str) {
        this.videoDownloadUrl = str;
    }

    public String D() {
        return this.sha256;
    }

    public int F() {
        return this.timeBeforeVideoAutoPlay;
    }

    public int I() {
        return this.videoDuration;
    }

    public void I(int i) {
        this.timeBeforeVideoAutoPlay = i;
    }

    public void I(String str) {
        this.videoAutoPlayWithSound = str;
    }

    public int L() {
        return this.videoPlayMode;
    }

    public String S() {
        return this.videoAutoPlayWithSound;
    }

    public String V() {
        return this.originalDownloadUrl;
    }

    public void V(int i) {
        this.videoFileSize = i;
    }

    public void V(Integer num) {
        this.autoStopPlayAreaRatio = num;
    }

    public void V(String str) {
        this.videoAutoPlayOnWifi = str;
    }

    public int Z() {
        return this.videoDuration;
    }

    public void Z(int i) {
        this.checkSha256Flag = i;
    }

    public void Z(String str) {
        this.sha256 = str;
    }

    public int a() {
        return this.checkSha256Flag;
    }

    public Integer b() {
        return this.autoPlayAreaRatio;
    }

    public Integer c() {
        return this.autoStopPlayAreaRatio;
    }

    public int d() {
        return this.downloadNetwork;
    }

    public Float e() {
        return this.videoRatio;
    }

    public String f() {
        return this.showSoundIcon;
    }

    public float g() {
        return this.splashSwitchTime;
    }

    public int h() {
        return this.videoType;
    }

    public String i() {
        return this.liveRoomName;
    }
}
