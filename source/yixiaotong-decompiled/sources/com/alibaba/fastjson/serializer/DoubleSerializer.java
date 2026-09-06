package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DoubleSerializer implements ObjectSerializer {
    public static final DoubleSerializer instance = new DoubleSerializer();
    private DecimalFormat decimalFormat;

    public DoubleSerializer() {
        this.decimalFormat = null;
    }

    public DoubleSerializer(DecimalFormat decimalFormat) {
        this.decimalFormat = decimalFormat;
    }

    public DoubleSerializer(String str) {
        this(new DecimalFormat(str));
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        String string;
        SerializeWriter writer = jSONSerializer.getWriter();
        if (obj == null) {
            if (jSONSerializer.isEnabled(SerializerFeature.WriteNullNumberAsZero)) {
                writer.write('0');
                return;
            } else {
                writer.writeNull();
                return;
            }
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        if (Double.isNaN(dDoubleValue)) {
            writer.writeNull();
            return;
        }
        if (Double.isInfinite(dDoubleValue)) {
            writer.writeNull();
            return;
        }
        DecimalFormat decimalFormat = this.decimalFormat;
        if (decimalFormat == null) {
            string = Double.toString(dDoubleValue);
            if (string.endsWith(".0")) {
                string = string.substring(0, string.length() - 2);
            }
        } else {
            string = decimalFormat.format(dDoubleValue);
        }
        writer.append((CharSequence) string);
        if (jSONSerializer.isEnabled(SerializerFeature.WriteClassName)) {
            writer.write('D');
        }
    }
}
