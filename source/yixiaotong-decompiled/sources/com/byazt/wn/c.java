package com.byazt.wn;

import android.view.View;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 58, 20})
public class c extends tt {
    public com.byazt.uj.ve i;

    public c(String str, com.byazt.db.tt ttVar) {
        super(str, ttVar);
    }

    public void callLoadSucceed(double d, Map<String, Object> map) {
        if (!hasNotifySuccess()) {
            com.byazt.eu.tt.uj("TTMediationSDK", "自定义Adapter callLoadSuccess");
            com.byazt.uj.tt ttVar = new com.byazt.uj.tt(this, this.ve);
            this.i = ttVar;
            ttVar.setMediaExtraInfo(this.n);
            this.i.setAdType(this.uj.yv());
            if (d > 0.0d && getBiddingType() == 1) {
                this.i.setCpm(d);
            }
            if (map != null) {
                this.n.putAll(map);
            }
            this.i.putExtraMsg(this.n);
            notifyLoadSuccess(this.i);
            return;
        }
        com.byazt.eu.tt.uj("TTMediationSDK", "自定义Adapter 加载成功或者失败回调只能调用一次");
    }

    public void callLoadFail(com.byazt.zm.c cVar) {
        if (!hasNotifyFail()) {
            notifyLoadFail(new com.byazt.pp.c(49004, com.byazt.pp.c.c(49004), cVar == null ? -1 : cVar.c(), cVar == null ? "" : cVar.tt()));
        } else {
            com.byazt.eu.tt.uj("TTMediationSDK", "自定义Adapter 加载成功或者失败回调只能调用一次");
        }
    }

    public void callBannerAdShow() {
        if (this.i != null) {
            checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.c.1
                @Override // com.byazt.ylx.c.InterfaceC0334c
                public void c() {
                    com.byazt.oc.c cVar = (com.byazt.oc.c) c.this.i.getTTAdatperCallback();
                    if (cVar != null) {
                        cVar.tt(null);
                    }
                }
            });
        }
    }

    public void callBannerAdClicked() {
        if (this.i != null) {
            checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.c.2
                @Override // com.byazt.ylx.c.InterfaceC0334c
                public void c() {
                    c.this.checkClick(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.c.2.1
                        @Override // com.byazt.ylx.c.InterfaceC0334c
                        public void c() {
                            com.byazt.oc.c cVar = (com.byazt.oc.c) c.this.i.getTTAdatperCallback();
                            if (cVar != null) {
                                cVar.c((View) null);
                            }
                        }
                    });
                }
            });
        }
    }

    public void callBannerAdClosed() {
        if (this.i != null) {
            checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.c.3
                @Override // com.byazt.ylx.c.InterfaceC0334c
                public void c() {
                    com.byazt.oc.c cVar = (com.byazt.oc.c) c.this.i.getTTAdatperCallback();
                    if (cVar != null) {
                        cVar.c();
                    }
                }
            });
        }
    }

    @Override // com.byazt.wn.tt
    public <T> T callManager(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        double dDoubleValue;
        Map<String, Object> map;
        if (i == 8123) {
            int iIntValue = pluginValueSet.intValue(8014);
            String strStringValue = pluginValueSet.stringValue(8015);
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom banner loader : callLoaderFail  code:" + iIntValue + " msg:" + strStringValue);
            callLoaderFail(iIntValue, strStringValue);
        } else if (i == 8107) {
            if (pluginValueSet != null) {
                dDoubleValue = pluginValueSet.doubleValue(8409);
                map = (Map) pluginValueSet.objectValue(8075, Map.class);
            } else {
                dDoubleValue = 0.0d;
                map = null;
            }
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom banner loader : callLoadSucceed price:" + dDoubleValue + " mextraMsg:" + map);
            callLoadSucceed(dDoubleValue, map);
        } else if (i == 1008) {
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom banner loader : callBannerAdShow");
            callBannerAdShow();
        } else if (i == 1009) {
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom banner loader : callBannerAdClick");
            callBannerAdClicked();
        } else if (i == 1014) {
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom banner loader : callBannerAdClosed");
            callBannerAdClosed();
        }
        return null;
    }
}
