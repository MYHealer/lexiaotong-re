package com.hihonor.adsdk.base.apt.adapter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.hihonor.adsdk.base.bean.Address;
import com.hihonor.adsdk.base.net.request.DeviceData;
import com.umeng.analytics.pro.am;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class d extends TypeAdapter<DeviceData> {
    private Gson hnadsa;
    private TypeAdapter<String> hnadsb;
    private TypeAdapter<Integer> hnadsc;
    private TypeAdapter<Address> hnadsd;
    private TypeAdapter<Long> hnadse;

    public d(Gson gson) {
        this.hnadsa = gson;
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
    public DeviceData read2(JsonReader jsonReader) throws IOException {
        return null;
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter jsonWriter, DeviceData deviceData) throws IOException {
        if (deviceData == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginObject();
        jsonWriter.name("appVersion");
        hnadsd().write(jsonWriter, deviceData.getAppVersion());
        jsonWriter.name(am.P);
        hnadsd().write(jsonWriter, deviceData.getCarrier());
        jsonWriter.name("connectionType");
        hnadsb().write(jsonWriter, Integer.valueOf(deviceData.getConnectionType()));
        jsonWriter.name("countryCode");
        hnadsd().write(jsonWriter, deviceData.getCountryCode());
        jsonWriter.name("deviceType");
        hnadsb().write(jsonWriter, Integer.valueOf(deviceData.getDeviceType()));
        jsonWriter.name(com.hihonor.adsdk.base.g.j.e.a.hnadsv);
        hnadsd().write(jsonWriter, deviceData.getGaid());
        jsonWriter.name("gaidMd5");
        hnadsd().write(jsonWriter, deviceData.getGaidMd5());
        jsonWriter.name("language");
        hnadsd().write(jsonWriter, deviceData.getLanguage());
        jsonWriter.name("make");
        hnadsd().write(jsonWriter, deviceData.getMake());
        jsonWriter.name("model");
        hnadsd().write(jsonWriter, deviceData.getModel());
        jsonWriter.name("orientation");
        hnadsb().write(jsonWriter, Integer.valueOf(deviceData.getOrientation()));
        jsonWriter.name(am.x);
        hnadsd().write(jsonWriter, deviceData.getOs());
        jsonWriter.name("osv");
        hnadsd().write(jsonWriter, deviceData.getOsv());
        jsonWriter.name("ppi");
        hnadsb().write(jsonWriter, Integer.valueOf(deviceData.getPpi()));
        jsonWriter.name("screenHeight");
        hnadsb().write(jsonWriter, Integer.valueOf(deviceData.getScreenHeight()));
        jsonWriter.name("screenWidth");
        hnadsb().write(jsonWriter, Integer.valueOf(deviceData.getScreenWidth()));
        jsonWriter.name("sdkVersion");
        hnadsd().write(jsonWriter, deviceData.getSdkVersion());
        jsonWriter.name("cityCode");
        hnadsd().write(jsonWriter, deviceData.getCityCode());
        jsonWriter.name("magicUiVersion");
        hnadsd().write(jsonWriter, deviceData.getMagicUiVersion());
        jsonWriter.name(com.hihonor.adsdk.base.g.j.e.a.G0);
        hnadsa().write(jsonWriter, deviceData.getAddress());
        jsonWriter.name("honorOaid");
        hnadsd().write(jsonWriter, deviceData.getHonorOaid());
        jsonWriter.name("honorOaidMd5");
        hnadsd().write(jsonWriter, deviceData.getHonorOaidMd5());
        jsonWriter.name("ua");
        hnadsd().write(jsonWriter, deviceData.getUa());
        jsonWriter.name("honorLmt");
        hnadsb().write(jsonWriter, Integer.valueOf(deviceData.getHonorLmt()));
        jsonWriter.name("timeStamp");
        hnadsc().write(jsonWriter, Long.valueOf(deviceData.getTimeStamp()));
        jsonWriter.name("deviceMode");
        hnadsb().write(jsonWriter, Integer.valueOf(deviceData.getDeviceMode()));
        jsonWriter.name("romVersion");
        hnadsd().write(jsonWriter, deviceData.getRomVersion());
        jsonWriter.name("mmsData");
        hnadsd().write(jsonWriter, deviceData.getMmsData());
        jsonWriter.endObject();
    }

    public TypeAdapter<Integer> hnadsb() {
        if (this.hnadsc == null) {
            this.hnadsc = this.hnadsa.getAdapter(TypeToken.get(Integer.class));
        }
        return this.hnadsc;
    }

    public TypeAdapter<Long> hnadsc() {
        if (this.hnadse == null) {
            this.hnadse = this.hnadsa.getAdapter(TypeToken.get(Long.class));
        }
        return this.hnadse;
    }

    public TypeAdapter<String> hnadsd() {
        if (this.hnadsb == null) {
            this.hnadsb = this.hnadsa.getAdapter(TypeToken.get(String.class));
        }
        return this.hnadsb;
    }

    public TypeAdapter<Address> hnadsa() {
        if (this.hnadsd == null) {
            this.hnadsd = new b(this.hnadsa);
        }
        return this.hnadsd;
    }
}
