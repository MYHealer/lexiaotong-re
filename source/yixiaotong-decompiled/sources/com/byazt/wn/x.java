package com.byazt.wn;

import com.byazt.uj.da;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 58, 71})
public class x extends tt {
    public com.byazt.uj.ve i;

    public x(String str, com.byazt.db.tt ttVar) {
        super(str, ttVar);
    }

    public void callLoadSucceed(double d, Map<String, Object> map) {
        if (!hasNotifySuccess()) {
            com.byazt.eu.tt.uj("TTMediationSDK", "自定义Adapter callLoadSuccess");
            da daVar = new da(this, this.ve);
            this.i = daVar;
            c(daVar, d, map);
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

    public void callSplashAdClicked() {
        if (this.i != null) {
            checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.x.1
                @Override // com.byazt.ylx.c.InterfaceC0334c
                public void c() {
                    x.this.checkClick(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.x.1.1
                        @Override // com.byazt.ylx.c.InterfaceC0334c
                        public void c() {
                            com.byazt.ko.tt ttVar = (com.byazt.ko.tt) x.this.i.getTTAdatperCallback();
                            if (ttVar != null) {
                                ttVar.uj();
                            }
                        }
                    });
                }
            });
        }
    }

    public void callSplashAdShow() {
        if (this.i != null) {
            checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.x.2
                @Override // com.byazt.ylx.c.InterfaceC0334c
                public void c() {
                    x.this.checkShow(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.x.2.1
                        @Override // com.byazt.ylx.c.InterfaceC0334c
                        public void c() {
                            com.byazt.ko.tt ttVar = (com.byazt.ko.tt) x.this.i.getTTAdatperCallback();
                            if (ttVar != null) {
                                ttVar.n();
                            }
                        }
                    });
                }
            });
        }
    }

    public void callSplashAdSkip() {
        if (this.i != null) {
            checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.x.3
                @Override // com.byazt.ylx.c.InterfaceC0334c
                public void c() {
                    com.byazt.ko.tt ttVar = (com.byazt.ko.tt) x.this.i.getTTAdatperCallback();
                    if (ttVar != null) {
                        ttVar.c(1);
                    }
                }
            });
        }
    }

    public void callSplashAdDismiss() {
        if (this.i != null) {
            checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.x.4
                @Override // com.byazt.ylx.c.InterfaceC0334c
                public void c() {
                    com.byazt.ko.tt ttVar = (com.byazt.ko.tt) x.this.i.getTTAdatperCallback();
                    if (ttVar != null) {
                        ttVar.tt(2);
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
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom splash loader : callLoaderFail  code:" + iIntValue + " msg:" + strStringValue);
            callLoaderFail(iIntValue, strStringValue);
        } else if (i == 8107) {
            if (pluginValueSet != null) {
                dDoubleValue = pluginValueSet.doubleValue(8409);
                map = (Map) pluginValueSet.objectValue(8075, Map.class);
            } else {
                dDoubleValue = 0.0d;
                map = null;
            }
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom splash loader : callLoadSucceed price:" + dDoubleValue + " mextraMsg:" + map);
            callLoadSucceed(dDoubleValue, map);
        } else if (i == 1009) {
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom splash loader : callSplashAdClicked");
            callSplashAdClicked();
        } else if (i == 1008) {
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom splash loader : callSplashAdShow");
            callSplashAdShow();
        } else if (i == 1019) {
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom splash loader : callSplashAdSkip");
            callSplashAdSkip();
        } else if (i == 1011) {
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom splash loader : callSplashAdDismiss");
            callSplashAdDismiss();
        }
        return null;
    }
}
