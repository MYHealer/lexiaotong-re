package com.alibaba.fastjson.support.odps.udf;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.aliyun.odps.udf.UDF;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class JSONSize extends UDF {
    public JSONSize() {
        SerializeConfig.getGlobalInstance().setAsmEnable(false);
    }

    public Long evaluate(String str, String str2) throws Exception {
        return Long.valueOf(JSONPath.size(JSON.parse(str), str2));
    }
}
