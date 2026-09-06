package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.CpuChannelListManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class o extends ae {
    private CpuChannelListManager.CpuChannelListListener t;
    private String u;
    private int v;

    public void a(CpuChannelListManager.CpuChannelListListener cpuChannelListListener) {
        this.t = cpuChannelListListener;
    }

    public void a(String str, int i) {
        this.u = str;
        this.v = i;
    }

    public o(Context context) {
        super(context);
    }

    @Override // com.baidu.mobads.sdk.internal.ae, com.baidu.mobads.sdk.internal.bj
    public void a() {
        if (this.m == null) {
            this.n = false;
            return;
        }
        this.n = true;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, "cpu");
            this.m.createProdHandler(jSONObject2);
            p pVar = new p(this);
            this.m.addEventListener(z.ar, pVar);
            this.m.addEventListener(z.as, pVar);
            jSONObject.put("appsid", this.u);
            jSONObject.put("subChannelId", this.v);
            jSONObject.put("event_type", "cpu_channelIds");
        } catch (Exception e) {
            e.printStackTrace();
        }
        a(jSONObject);
    }
}
