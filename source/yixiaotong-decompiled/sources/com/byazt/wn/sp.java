package com.byazt.wn;

import com.byazt.uj.i;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 58, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp extends tt {
    public volatile com.byazt.uj.ve i;

    public sp(String str, com.byazt.db.tt ttVar) {
        super(str, ttVar);
    }

    public void callLoadSucceed(double d, Map<String, Object> map) {
        if (!hasNotifySuccess()) {
            com.byazt.eu.tt.uj("TTMediationSDK", "自定义Adapter callLoadSuccess");
            if (this.i == null) {
                this.i = new i(this, this.ve);
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
            this.i = new i(this, this.ve);
        }
        notifyVideoCache(this.i, (com.byazt.pp.c) null);
    }

    public void callRewardedAdShow() {
        if (this.i != null) {
            checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.sp.1
                @Override // com.byazt.ylx.c.InterfaceC0334c
                public void c() {
                    sp.this.checkShow(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.sp.1.1
                        @Override // com.byazt.ylx.c.InterfaceC0334c
                        public void c() {
                            com.byazt.uhf.c cVar = (com.byazt.uhf.c) sp.this.i.getTTAdatperCallback();
                            if (cVar != null) {
                                cVar.c();
                            }
                        }
                    });
                }
            });
        }
    }

    public final void callRewardClick() {
        if (this.i != null) {
            checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.sp.2
                @Override // com.byazt.ylx.c.InterfaceC0334c
                public void c() {
                    sp.this.checkClick(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.sp.2.1
                        @Override // com.byazt.ylx.c.InterfaceC0334c
                        public void c() {
                            com.byazt.uhf.c cVar = (com.byazt.uhf.c) sp.this.i.getTTAdatperCallback();
                            if (cVar != null) {
                                cVar.i_();
                            }
                        }
                    });
                }
            });
        }
    }

    public final void callRewardedAdClosed() {
        if (this.i != null) {
            checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.sp.3
                @Override // com.byazt.ylx.c.InterfaceC0334c
                public void c() {
                    com.byazt.uhf.c cVar = (com.byazt.uhf.c) sp.this.i.getTTAdatperCallback();
                    if (cVar != null) {
                        cVar.j_();
                    }
                }
            });
        }
    }

    public final void callRewardVideoComplete() {
        if (this.i != null) {
            checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.sp.4
                @Override // com.byazt.ylx.c.InterfaceC0334c
                public void c() {
                    com.byazt.uhf.c cVar = (com.byazt.uhf.c) sp.this.i.getTTAdatperCallback();
                    if (cVar != null) {
                        cVar.uj();
                    }
                }
            });
        }
    }

    public final void callRewardVideoError() {
        if (this.i != null) {
            checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.sp.5
                @Override // com.byazt.ylx.c.InterfaceC0334c
                public void c() {
                    com.byazt.uhf.c cVar = (com.byazt.uhf.c) sp.this.i.getTTAdatperCallback();
                    if (cVar != null) {
                        cVar.n();
                    }
                }
            });
        }
    }

    public final void callRewardSkippedVideo() {
        if (this.i != null) {
            checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.sp.6
                @Override // com.byazt.ylx.c.InterfaceC0334c
                public void c() {
                    com.byazt.uhf.c cVar = (com.byazt.uhf.c) sp.this.i.getTTAdatperCallback();
                    if (cVar != null) {
                        cVar.a();
                    }
                }
            });
        }
    }

    public final void callRewardVerify(final com.byazt.bo.c cVar) {
        if (this.i != null) {
            checkLoadSuccess(new com.byazt.ylx.c.InterfaceC0334c() { // from class: com.byazt.wn.sp.7
                @Override // com.byazt.ylx.c.InterfaceC0334c
                public void c() {
                    com.byazt.uhf.c cVar2 = (com.byazt.uhf.c) sp.this.i.getTTAdatperCallback();
                    if (cVar2 != null) {
                        cVar2.c(cVar);
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
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom reward loader : callLoaderFail  code:" + iIntValue + " msg:" + strStringValue);
            callLoaderFail(iIntValue, strStringValue);
        } else if (i == 8107) {
            if (pluginValueSet != null) {
                dDoubleValue = pluginValueSet.doubleValue(8409);
                map = (Map) pluginValueSet.objectValue(8075, Map.class);
            } else {
                dDoubleValue = 0.0d;
                map = null;
            }
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom reward loader : callLoadSucceed price:" + dDoubleValue + " mextraMsg:" + map);
            callLoadSucceed(dDoubleValue, map);
        } else if (i == 8112) {
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom reward loader : callAdVideoCache");
            callAdVideoCache();
        } else if (i == 1008) {
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom reward loader : callRewardedAdShow");
            callRewardedAdShow();
        } else if (i == 1009) {
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom reward loader : callRewardClick");
            callRewardClick();
        } else if (i == 1014) {
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom reward loader : callRewardedAdClosed");
            callRewardedAdClosed();
        } else if (i == 1026) {
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom reward loader : callRewardVideoComplete");
            callRewardVideoComplete();
        } else if (i == 1021) {
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom reward loader : callRewardVideoError");
            callRewardVideoError();
        } else if (i == 1037) {
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom reward loader : callRewardSkippedVideo");
            callRewardSkippedVideo();
        } else if (i == 1018 && pluginValueSet != null) {
            final boolean zBooleanValue = pluginValueSet.booleanValue(8017);
            final float fFloatValue = pluginValueSet.floatValue(8018);
            final String strStringValue2 = pluginValueSet.stringValue(8019);
            final Map map2 = (Map) pluginValueSet.objectValue(8075, Map.class);
            com.byazt.eu.tt.tt("TTMediationSDK", "Adn custom reward loader : callRewardVerify rewardVerify:" + zBooleanValue + " amount:" + fFloatValue + " name:" + strStringValue2 + " map:" + map2);
            callRewardVerify(new com.byazt.bo.c() { // from class: com.byazt.wn.sp.8
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
