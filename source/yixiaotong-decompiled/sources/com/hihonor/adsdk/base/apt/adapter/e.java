package com.hihonor.adsdk.base.apt.adapter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.hihonor.adsdk.base.net.request.MediaData;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class e extends TypeAdapter<MediaData> {
    private Gson hnadsa;
    private TypeAdapter<String> hnadsb;
    private TypeAdapter<Integer> hnadsc;

    public e(Gson gson) {
        this.hnadsa = gson;
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
    public MediaData read2(JsonReader jsonReader) throws IOException {
        MediaData mediaData = new MediaData();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            strNextName.hashCode();
            switch (strNextName) {
                case "sdkVersion":
                    mediaData.setSdkVersion(hnadsb().read2(jsonReader));
                    break;
                case "mediaPackage":
                    mediaData.setMediaPackage(hnadsb().read2(jsonReader));
                    break;
                case "wechatOpenSdkVersion":
                    mediaData.setWechatOpenSdkVersion(hnadsa().read2(jsonReader).intValue());
                    break;
                case "mediaId":
                    mediaData.setMediaId(hnadsb().read2(jsonReader));
                    break;
                case "allianceChannelInfo":
                    mediaData.setAllianceChannelInfo(hnadsb().read2(jsonReader));
                    break;
                case "appVersion":
                    mediaData.setAppVersion(hnadsb().read2(jsonReader));
                    break;
                case "wechatVersion":
                    mediaData.setWechatVersion(hnadsa().read2(jsonReader).intValue());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return mediaData;
    }

    public TypeAdapter<String> hnadsb() {
        if (this.hnadsb == null) {
            this.hnadsb = this.hnadsa.getAdapter(TypeToken.get(String.class));
        }
        return this.hnadsb;
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter jsonWriter, MediaData mediaData) throws IOException {
        if (mediaData == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginObject();
        jsonWriter.name("mediaId");
        hnadsb().write(jsonWriter, mediaData.getMediaId());
        jsonWriter.name("mediaPackage");
        hnadsb().write(jsonWriter, mediaData.getMediaPackage());
        jsonWriter.name("appVersion");
        hnadsb().write(jsonWriter, mediaData.getAppVersion());
        jsonWriter.name("sdkVersion");
        hnadsb().write(jsonWriter, mediaData.getSdkVersion());
        jsonWriter.name("allianceChannelInfo");
        hnadsb().write(jsonWriter, mediaData.getAllianceChannelInfo());
        jsonWriter.name("wechatOpenSdkVersion");
        hnadsa().write(jsonWriter, Integer.valueOf(mediaData.getWechatOpenSdkVersion()));
        jsonWriter.name("wechatVersion");
        hnadsa().write(jsonWriter, Integer.valueOf(mediaData.getWechatVersion()));
        jsonWriter.endObject();
    }

    public TypeAdapter<Integer> hnadsa() {
        if (this.hnadsc == null) {
            this.hnadsc = this.hnadsa.getAdapter(TypeToken.get(Integer.class));
        }
        return this.hnadsc;
    }
}
