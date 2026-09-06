package com.kwad.sdk.core.response.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class HttpDnsInfo extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
    private static final long serialVersionUID = -6943205584670122267L;
    public List<IpInfo> recommendList = new ArrayList();
    public List<IpInfo> backUpList = new ArrayList();
    public List<IpInfo> otherList = new ArrayList();

    public static class IpInfo extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = -6943205584670122266L;
        public String ip = "";
        public int weight;

        @Override // com.kwad.sdk.core.response.a.a
        public String toString() {
            try {
                return toJson().toString();
            } catch (Exception unused) {
                return "";
            }
        }
    }

    @Override // com.kwad.sdk.core.response.a.a
    public String toString() {
        try {
            return toJson().toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
