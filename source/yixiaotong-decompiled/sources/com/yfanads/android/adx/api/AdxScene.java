package com.yfanads.android.adx.api;

import com.yfanads.android.adx.core.annotate.AdSdkApi;
import com.yfanads.android.adx.core.load.AdxLoader;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
@AdSdkApi
public interface AdxScene extends Serializable {

    @AdSdkApi
    public static class Builder {
        private final AdxScene scene;

        @AdSdkApi
        public Builder(String str) {
            AdxScene adxScene = (AdxScene) AdxLoader.get().newInstance(AdxScene.class);
            this.scene = adxScene;
            adxScene.setPosId(str);
        }

        @AdSdkApi
        public Builder action(int i) {
            this.scene.setAction(i);
            return this;
        }

        @AdSdkApi
        public Builder adNum(int i) {
            this.scene.setAdNum(i);
            return this;
        }

        @AdSdkApi
        public Builder adStyle(int i) {
            this.scene.setAdStyle(i);
            return this;
        }

        @AdSdkApi
        public AdxScene build() {
            return this.scene;
        }

        @AdSdkApi
        public Builder height(int i) {
            this.scene.setHeight(i);
            return this;
        }

        @AdSdkApi
        public Builder posId(String str) {
            this.scene.setPosId(str);
            return this;
        }

        @AdSdkApi
        public Builder rewardCallbackExtraData(Map<String, String> map) {
            this.scene.setRewardCallbackExtraData(map);
            return this;
        }

        @AdSdkApi
        public Builder screenOrientation(int i) {
            this.scene.setScreenOrientation(i);
            return this;
        }

        @AdSdkApi
        public Builder setEcpm(long j) {
            this.scene.setEcpm(j);
            return this;
        }

        @AdSdkApi
        public Builder setReqId(String str) {
            this.scene.setReqId(str);
            return this;
        }

        @AdSdkApi
        public Builder width(int i) {
            this.scene.setWidth(i);
            return this;
        }
    }

    @AdSdkApi
    int getAction();

    @AdSdkApi
    int getAdNum();

    @AdSdkApi
    int getAdStyle();

    @AdSdkApi
    long getEcpm();

    @AdSdkApi
    int getHeight();

    @AdSdkApi
    String getPosId();

    @AdSdkApi
    String getReqId();

    @AdSdkApi
    Map<String, String> getRewardCallbackExtraData();

    @AdSdkApi
    int getScreenOrientation();

    @AdSdkApi
    int getWidth();

    @AdSdkApi
    void setAction(int i);

    @AdSdkApi
    void setAdNum(int i);

    @AdSdkApi
    void setAdStyle(int i);

    @AdSdkApi
    void setEcpm(long j);

    @AdSdkApi
    void setHeight(int i);

    @AdSdkApi
    void setPosId(String str);

    @AdSdkApi
    void setReqId(String str);

    @AdSdkApi
    void setRewardCallbackExtraData(Map<String, String> map);

    @AdSdkApi
    void setScreenOrientation(int i);

    @AdSdkApi
    void setWidth(int i);

    @AdSdkApi
    JSONObject toJson();
}
