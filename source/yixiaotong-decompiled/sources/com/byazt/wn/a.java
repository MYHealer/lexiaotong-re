package com.byazt.wn;

import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 58, 34})
public class a extends tt {
    public com.byazt.uj.ve i;

    public a(String str, com.byazt.db.tt ttVar) {
        super(str, ttVar);
    }

    public void callLoadSucceed(double d, Map<String, Object> map) {
        if (!hasNotifySuccess()) {
            com.byazt.eu.tt.uj("TTMediationSDK", "自定义Adapter callLoadSuccess");
            com.byazt.uj.sp spVar = new com.byazt.uj.sp(this, this.ve);
            this.i = spVar;
            c(spVar, d, map);
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

    public void callInterstitialShow() {
        if (this.i != null) {
            checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.a.1
                @Override // com.byazt.ylx.c.InterfaceC0334c
                public void c() {
                    a.this.checkShow(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.a.1.1
                        @Override // com.byazt.ylx.c.InterfaceC0334c
                        public void c() {
                            com.byazt.xu.c cVar = (com.byazt.xu.c) a.this.i.getTTAdatperCallback();
                            if (cVar != null) {
                                cVar.c();
                            }
                        }
                    });
                }
            });
        }
    }

    public void callInterstitialAdClick() {
        if (this.i != null) {
            checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.a.2
                @Override // com.byazt.ylx.c.InterfaceC0334c
                public void c() {
                    a.this.checkClick(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.a.2.1
                        @Override // com.byazt.ylx.c.InterfaceC0334c
                        public void c() {
                            com.byazt.xu.c cVar = (com.byazt.xu.c) a.this.i.getTTAdatperCallback();
                            if (cVar != null) {
                                cVar.tt();
                            }
                        }
                    });
                }
            });
        }
    }

    public void callInterstitialClosed() {
        if (this.i != null) {
            checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.a.3
                @Override // com.byazt.ylx.c.InterfaceC0334c
                public void c() {
                    com.byazt.xu.c cVar = (com.byazt.xu.c) a.this.i.getTTAdatperCallback();
                    if (cVar != null) {
                        cVar.ve();
                    }
                }
            });
        }
    }

    public void callInterstitialAdOpened() {
        if (this.i != null) {
            checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.a.4
                @Override // com.byazt.ylx.c.InterfaceC0334c
                public void c() {
                    com.byazt.xu.c cVar = (com.byazt.xu.c) a.this.i.getTTAdatperCallback();
                    if (cVar != null) {
                        cVar.uj();
                    }
                }
            });
        }
    }

    public void callInterstitialAdLeftApplication() {
        if (this.i != null) {
            checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.a.5
                @Override // com.byazt.ylx.c.InterfaceC0334c
                public void c() {
                    com.byazt.xu.c cVar = (com.byazt.xu.c) a.this.i.getTTAdatperCallback();
                    if (cVar != null) {
                        cVar.n();
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
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom interstitial loader : callLoaderFail  code:" + iIntValue + " msg:" + strStringValue);
            callLoaderFail(iIntValue, strStringValue);
        } else if (i == 8107) {
            if (pluginValueSet != null) {
                dDoubleValue = pluginValueSet.doubleValue(8409);
                map = (Map) pluginValueSet.objectValue(8075, Map.class);
            } else {
                dDoubleValue = 0.0d;
                map = null;
            }
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom interstitial loader : callLoadSucceed price:" + dDoubleValue + " mextraMsg:" + map);
            callLoadSucceed(dDoubleValue, map);
        } else if (i == 1008) {
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom interstitial loader : callInterstitialShow");
            callInterstitialShow();
        } else if (i == 1009) {
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom interstitial loader : callInterstitialAdClick");
            callInterstitialAdClick();
        } else if (i == 1014) {
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom interstitial loader : callInterstitialClosed");
            callInterstitialClosed();
        } else if (i == 1015) {
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom interstitial loader : callInterstitialAdOpened");
            callInterstitialAdOpened();
        } else if (i == 1016) {
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom interstitial loader : callInterstitialAdLeftApplication");
            callInterstitialAdLeftApplication();
        }
        return null;
    }
}
