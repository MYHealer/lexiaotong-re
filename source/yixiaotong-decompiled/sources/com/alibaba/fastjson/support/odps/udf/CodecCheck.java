package com.alibaba.fastjson.support.odps.udf;

import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.alibaba.fastjson.JSON;
import com.aliyun.odps.udf.UDF;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class CodecCheck extends UDF {

    public static class A {
        private int id;
        private String name;

        public int getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public void setId(int i) {
            this.id = i;
        }

        public void setName(String str) {
            this.name = str;
        }
    }

    public String evaluate() throws Exception {
        A a2 = new A();
        a2.setId(AppTypeIdUtil.NewDevice4GBathOTA);
        a2.setName("xxx");
        JSON.parseObject(JSON.toJSONString(a2), A.class);
        return "ok";
    }
}
