package com.alibaba.fastjson.support.odps.udf;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPath;
import com.aliyun.odps.udf.OdpsType;
import com.aliyun.odps.udf.UDFException;
import com.aliyun.odps.udf.UDTF;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class JSONTuple extends UDTF {
    public OdpsType[] initialize(OdpsType[] odpsTypeArr) throws Exception {
        OdpsType[] odpsTypeArr2 = new OdpsType[odpsTypeArr.length - 1];
        Arrays.fill(odpsTypeArr2, OdpsType.STRING);
        return odpsTypeArr2;
    }

    public void process(Object[] objArr) throws UDFException {
        Object obj = JSON.parse((String) objArr[0]);
        Object[] objArr2 = new Object[objArr.length - 1];
        for (int i = 1; i < objArr.length; i++) {
            objArr2[i - 1] = JSON.toJSONString(JSONPath.eval(obj, (String) objArr[i]));
        }
        forward(objArr2);
    }
}
