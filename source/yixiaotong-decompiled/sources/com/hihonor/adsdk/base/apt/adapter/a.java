package com.hihonor.adsdk.base.apt.adapter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.hihonor.adsdk.base.net.request.AdUnit;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a extends TypeAdapter<AdUnit> {
    private Gson hnadsa;
    private TypeAdapter<String> hnadsb;
    private TypeAdapter<Integer> hnadsc;
    private TypeAdapter<List<String>> hnadsd;

    public a(Gson gson) {
        this.hnadsa = gson;
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
    public AdUnit read2(JsonReader jsonReader) throws IOException {
        AdUnit adUnit = new AdUnit();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            strNextName.hashCode();
            switch (strNextName) {
                case "adUnitId":
                    adUnit.setAdUnitId(hnadsb().read2(jsonReader));
                    break;
                case "adType":
                    adUnit.setAdType(hnadsa().read2(jsonReader).intValue());
                    break;
                case "height":
                    adUnit.setHeight(hnadsa().read2(jsonReader).intValue());
                    break;
                case "industryIds":
                    adUnit.setIndustryIds(hnadsc().read2(jsonReader));
                    break;
                case "width":
                    adUnit.setWidth(hnadsa().read2(jsonReader).intValue());
                    break;
                case "excludeIds":
                    adUnit.setExcludeIds(hnadsc().read2(jsonReader));
                    break;
                case "renderMode":
                    adUnit.setRenderMode(hnadsa().read2(jsonReader).intValue());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return adUnit;
    }

    public TypeAdapter<String> hnadsb() {
        if (this.hnadsb == null) {
            this.hnadsb = this.hnadsa.getAdapter(TypeToken.get(String.class));
        }
        return this.hnadsb;
    }

    public TypeAdapter<List<String>> hnadsc() {
        if (this.hnadsd == null) {
            this.hnadsd = this.hnadsa.getAdapter(TypeToken.getParameterized(List.class, String.class));
        }
        return this.hnadsd;
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter jsonWriter, AdUnit adUnit) throws IOException {
        if (adUnit == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginObject();
        jsonWriter.name("adUnitId");
        hnadsb().write(jsonWriter, adUnit.getAdUnitId());
        jsonWriter.name("adType");
        hnadsa().write(jsonWriter, Integer.valueOf(adUnit.getAdType()));
        jsonWriter.name("excludeIds");
        hnadsc().write(jsonWriter, adUnit.getExcludeIds());
        jsonWriter.name("width");
        hnadsa().write(jsonWriter, Integer.valueOf(adUnit.getWidth()));
        jsonWriter.name("height");
        hnadsa().write(jsonWriter, Integer.valueOf(adUnit.getHeight()));
        jsonWriter.name("renderMode");
        hnadsa().write(jsonWriter, Integer.valueOf(adUnit.getRenderMode()));
        jsonWriter.name("industryIds");
        hnadsc().write(jsonWriter, adUnit.getIndustryIds());
        jsonWriter.endObject();
    }

    public TypeAdapter<Integer> hnadsa() {
        if (this.hnadsc == null) {
            this.hnadsc = this.hnadsa.getAdapter(TypeToken.get(Integer.class));
        }
        return this.hnadsc;
    }
}
