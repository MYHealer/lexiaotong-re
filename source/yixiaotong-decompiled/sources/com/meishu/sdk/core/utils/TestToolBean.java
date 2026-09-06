package com.meishu.sdk.core.utils;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class TestToolBean implements Serializable {
    private String etag;
    private List<PidListBean> pids;
    private String test_status = "0";

    public static class PidListBean implements Serializable {
        private List<PidsBean> pids;
        private String type;

        public static class PidsBean implements Serializable {
            private String mobileType;
            private String pid;

            public String getMobileType() {
                return this.mobileType;
            }

            public String getPid() {
                return this.pid;
            }

            public void setMobileType(String str) {
                this.mobileType = str;
            }

            public void setPid(String str) {
                this.pid = str;
            }
        }

        public List<PidsBean> getPids() {
            return this.pids;
        }

        public String getType() {
            return this.type;
        }

        public void setPids(List<PidsBean> list) {
            this.pids = list;
        }

        public void setType(String str) {
            this.type = str;
        }
    }

    public String getEtag() {
        return this.etag;
    }

    public List<PidListBean> getPids() {
        return this.pids;
    }

    public String getTest_status() {
        return this.test_status;
    }

    public void setEtag(String str) {
        this.etag = str;
    }

    public void setPids(List<PidListBean> list) {
        this.pids = list;
    }

    public void setTest_status(String str) {
        this.test_status = str;
    }
}
