package com.alibaba.fastjson.serializer;

import com.huawei.hms.ads.ez;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AtomicBooleanSerializer implements ObjectSerializer {
    public static final AtomicBooleanSerializer instance = new AtomicBooleanSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter writer = jSONSerializer.getWriter();
        if (((AtomicBoolean) obj).get()) {
            writer.append(ez.Code);
        } else {
            writer.append(ez.V);
        }
    }
}
