package com.hihonor.adsdk.base.apt.adapter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.hihonor.adsdk.base.bean.Address;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b extends TypeAdapter<Address> {
    private Gson hnadsa;
    private TypeAdapter<String> hnadsb;

    public b(Gson gson) {
        this.hnadsa = gson;
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
    public Address read2(JsonReader jsonReader) throws IOException {
        Address address = new Address();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            strNextName.hashCode();
            switch (strNextName) {
                case "countryName":
                    address.setCountryName(hnadsa().read2(jsonReader));
                    break;
                case "cityName":
                    address.setCityName(hnadsa().read2(jsonReader));
                    break;
                case "street":
                    address.setStreet(hnadsa().read2(jsonReader));
                    break;
                case "provinceName":
                    address.setProvinceName(hnadsa().read2(jsonReader));
                    break;
                case "district":
                    address.setDistrict(hnadsa().read2(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return address;
    }

    @Override // com.google.gson.TypeAdapter
    /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter jsonWriter, Address address) throws IOException {
        if (address == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginObject();
        jsonWriter.name("countryName");
        hnadsa().write(jsonWriter, address.getCountryName());
        jsonWriter.name("provinceName");
        hnadsa().write(jsonWriter, address.getProvinceName());
        jsonWriter.name("cityName");
        hnadsa().write(jsonWriter, address.getCityName());
        jsonWriter.name("district");
        hnadsa().write(jsonWriter, address.getDistrict());
        jsonWriter.name("street");
        hnadsa().write(jsonWriter, address.getStreet());
        jsonWriter.endObject();
    }

    public TypeAdapter<String> hnadsa() {
        if (this.hnadsb == null) {
            this.hnadsb = this.hnadsa.getAdapter(TypeToken.get(String.class));
        }
        return this.hnadsb;
    }
}
