package com.hihonor.adsdk.base.apt.adapter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.hihonor.adsdk.base.net.request.AdUnit;
import com.hihonor.adsdk.base.net.request.BaseRequest;
import com.hihonor.adsdk.base.net.request.DeviceData;
import com.hihonor.adsdk.base.net.request.MediaData;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c extends TypeAdapter<BaseRequest> {
    private Gson hnadsa;
    private TypeAdapter<DeviceData> hnadsb;
    private TypeAdapter<MediaData> hnadsc;
    private TypeAdapter<AdUnit> hnadsd;
    private TypeAdapter<String> hnadse;

    public c(Gson gson) {
        this.hnadsa = gson;
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
    public BaseRequest read2(JsonReader jsonReader) throws IOException {
        BaseRequest baseRequest = new BaseRequest();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            strNextName.hashCode();
            switch (strNextName) {
                case "adUnit":
                    baseRequest.setAdUnit(hnadsa().read2(jsonReader));
                    break;
                case "device":
                    baseRequest.setDeviceData(hnadsb().read2(jsonReader));
                    break;
                case "media":
                    baseRequest.setMediaData(hnadsc().read2(jsonReader));
                    break;
                case "adContext":
                    baseRequest.setAdContext(hnadsd().read2(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return baseRequest;
    }

    public TypeAdapter<DeviceData> hnadsb() {
        if (this.hnadsb == null) {
            this.hnadsb = new d(this.hnadsa);
        }
        return this.hnadsb;
    }

    public TypeAdapter<MediaData> hnadsc() {
        if (this.hnadsc == null) {
            this.hnadsc = new e(this.hnadsa);
        }
        return this.hnadsc;
    }

    public TypeAdapter<String> hnadsd() {
        if (this.hnadse == null) {
            this.hnadse = this.hnadsa.getAdapter(TypeToken.get(String.class));
        }
        return this.hnadse;
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter jsonWriter, BaseRequest baseRequest) throws IOException {
        if (baseRequest == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginObject();
        jsonWriter.name(com.alipay.sdk.packet.e.n);
        hnadsb().write(jsonWriter, baseRequest.getDeviceData());
        jsonWriter.name("media");
        hnadsc().write(jsonWriter, baseRequest.getMediaData());
        jsonWriter.name("adUnit");
        hnadsa().write(jsonWriter, baseRequest.getAdUnit());
        jsonWriter.name("adContext");
        hnadsd().write(jsonWriter, baseRequest.getAdContext());
        jsonWriter.endObject();
    }

    public TypeAdapter<AdUnit> hnadsa() {
        if (this.hnadsd == null) {
            this.hnadsd = new a(this.hnadsa);
        }
        return this.hnadsd;
    }
}
