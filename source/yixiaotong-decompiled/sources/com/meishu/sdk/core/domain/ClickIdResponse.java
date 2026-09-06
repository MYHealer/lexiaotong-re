package com.meishu.sdk.core.domain;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class ClickIdResponse {
    private ClickIdInfo data;
    private Integer ret;

    public static class ClickIdInfo {
        private String clickid;
        private String dstlink;

        public String getClickid() {
            return this.clickid;
        }

        public String getDstlink() {
            return this.dstlink;
        }

        public void setClickid(String str) {
            this.clickid = str;
        }

        public void setDstlink(String str) {
            this.dstlink = str;
        }
    }

    public ClickIdInfo getData() {
        return this.data;
    }

    public Integer getRet() {
        return this.ret;
    }

    public void setData(ClickIdInfo clickIdInfo) {
        this.data = clickIdInfo;
    }

    public void setRet(Integer num) {
        this.ret = num;
    }
}
