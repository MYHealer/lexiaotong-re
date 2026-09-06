package com.byazt.wn;

import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 58, 46})
public class n extends tt {
    public volatile com.byazt.uj.ve i;

    public n(String str, com.byazt.db.tt ttVar) {
        super(str, ttVar);
    }

    public void callLoadSucceed(double d, Map<String, Object> map) {
        if (!hasNotifySuccess()) {
            com.byazt.eu.tt.uj("TTMediationSDK", "自定义Adapter callLoadSuccess");
            if (this.i == null) {
                this.i = new com.byazt.uj.a(this, this.ve);
            }
            c(this.i, d, map);
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

    public void callAdVideoCache() {
        if (this.i == null) {
            this.i = new com.byazt.uj.a(this, this.ve);
        }
        notifyVideoCache(this.i, (com.byazt.pp.c) null);
    }

    public void callFullVideoAdShow() {
        if (this.i != null) {
            checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.n.1
                @Override // com.byazt.ylx.c.InterfaceC0334c
                public void c() {
                    n.this.checkShow(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.n.1.1
                        @Override // com.byazt.ylx.c.InterfaceC0334c
                        public void c() {
                            com.byazt.ln.c cVar = (com.byazt.ln.c) n.this.i.getTTAdatperCallback();
                            if (cVar != null) {
                                cVar.c();
                            }
                        }
                    });
                }
            });
        }
    }

    public void callFullVideoAdClick() {
        if (this.i != null) {
            checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.n.2
                @Override // com.byazt.ylx.c.InterfaceC0334c
                public void c() {
                    n.this.checkClick(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.n.2.1
                        @Override // com.byazt.ylx.c.InterfaceC0334c
                        public void c() {
                            com.byazt.ln.c cVar = (com.byazt.ln.c) n.this.i.getTTAdatperCallback();
                            if (cVar != null) {
                                cVar.g_();
                            }
                        }
                    });
                }
            });
        }
    }

    public void callFullVideoAdClosed() {
        if (this.i != null) {
            checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.n.3
                @Override // com.byazt.ylx.c.InterfaceC0334c
                public void c() {
                    com.byazt.ln.c cVar = (com.byazt.ln.c) n.this.i.getTTAdatperCallback();
                    if (cVar != null) {
                        cVar.h_();
                    }
                }
            });
        }
    }

    public void callFullVideoComplete() {
        if (this.i != null) {
            checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.n.4
                @Override // com.byazt.ylx.c.InterfaceC0334c
                public void c() {
                    com.byazt.ln.c cVar = (com.byazt.ln.c) n.this.i.getTTAdatperCallback();
                    if (cVar != null) {
                        cVar.uj();
                    }
                }
            });
        }
    }

    public void callFullVideoError() {
        if (this.i != null) {
            checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.n.5
                @Override // com.byazt.ylx.c.InterfaceC0334c
                public void c() {
                    com.byazt.ln.c cVar = (com.byazt.ln.c) n.this.i.getTTAdatperCallback();
                    if (cVar != null) {
                        cVar.n();
                    }
                }
            });
        }
    }

    public void callFullVideoSkippedVideo() {
        if (this.i != null) {
            checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.n.6
                @Override // com.byazt.ylx.c.InterfaceC0334c
                public void c() {
                    com.byazt.ln.c cVar = (com.byazt.ln.c) n.this.i.getTTAdatperCallback();
                    if (cVar != null) {
                        cVar.a();
                    }
                }
            });
        }
    }

    public void callFullVideoRewardVerify(final com.byazt.bo.c cVar) {
        if (cVar == null || this.i == null) {
            return;
        }
        checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.n.7
            @Override // com.byazt.ylx.c.InterfaceC0334c
            public void c() {
                com.byazt.ln.c cVar2 = (com.byazt.ln.c) n.this.i.getTTAdatperCallback();
                if (cVar2 != null) {
                    cVar2.c(cVar);
                }
            }
        });
    }

    @Override // com.byazt.wn.tt
    public <T> T callManager(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        double dDoubleValue;
        Map<String, Object> map;
        if (i == 8123) {
            int iIntValue = pluginValueSet.intValue(8014);
            String strStringValue = pluginValueSet.stringValue(8015);
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom full loader : callLoaderFail  code:" + iIntValue + " msg:" + strStringValue);
            callLoaderFail(iIntValue, strStringValue);
        } else if (i == 8107) {
            if (pluginValueSet != null) {
                dDoubleValue = pluginValueSet.doubleValue(8409);
                map = (Map) pluginValueSet.objectValue(8075, Map.class);
            } else {
                dDoubleValue = 0.0d;
                map = null;
            }
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom full loader : callLoadSucceed price:" + dDoubleValue + " mextraMsg:" + map);
            callLoadSucceed(dDoubleValue, map);
        } else if (i == 8112) {
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom full loader : callAdVideoCache");
            callAdVideoCache();
        } else if (i == 1008) {
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom full loader : callFullVideoAdShow");
            callFullVideoAdShow();
        } else if (i == 1009) {
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom full loader : callFullVideoAdClick");
            callFullVideoAdClick();
        } else if (i == 1014) {
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom full loader : callFullVideoAdClosed");
            callFullVideoAdClosed();
        } else if (i == 1026) {
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom full loader : callFullVideoComplete");
            callFullVideoComplete();
        } else if (i == 1021) {
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom full loader : callFullVideoError");
            callFullVideoError();
        } else if (i == 1037) {
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom full loader : callFullVideoSkippedVideo");
            callFullVideoSkippedVideo();
        } else if (i == 1018 && pluginValueSet != null) {
            final boolean zBooleanValue = pluginValueSet.booleanValue(8017);
            final float fFloatValue = pluginValueSet.floatValue(8018);
            final String strStringValue2 = pluginValueSet.stringValue(8019);
            final Map map2 = (Map) pluginValueSet.objectValue(8075, Map.class);
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom full loader : callFullVideoRewardVerify rewardVerify:" + zBooleanValue + " amount:" + fFloatValue + " name:" + strStringValue2 + " map:" + map2);
            callFullVideoRewardVerify(new com.byazt.bo.c() { // from class: com.byazt.wn.n.8
                @Override // com.byazt.bo.c
                public boolean c() {
                    return zBooleanValue;
                }

                @Override // com.byazt.bo.c
                public float tt() {
                    return fFloatValue;
                }

                @Override // com.byazt.bo.c
                public Map<String, Object> uj() {
                    return map2;
                }

                @Override // com.byazt.bo.c
                public String ve() {
                    return strStringValue2;
                }
            });
        }
        return null;
    }
}
