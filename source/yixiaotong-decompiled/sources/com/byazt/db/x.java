package com.byazt.db;

import android.app.Activity;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.umeng.analytics.pro.o;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 734, 71})
public class x extends uj {
    public x(com.byazt.dv.c cVar) {
        super(cVar);
    }

    private com.byazt.uhf.c c() {
        return (com.byazt.uhf.c) this.sp;
    }

    @Override // com.byazt.yl.ve
    public Integer isReadyStatus() {
        return isReadyStatus(this.x);
    }

    @Override // com.byazt.yl.ve
    public void showAd(Activity activity, Object obj, String str) {
        super.showAd(activity, obj, str);
        if (this.x != null) {
            this.x.apply(com.byazt.yxi.uj.c().c(8113).c(Void.class).c(20033, activity).tt());
        }
    }

    @Override // com.byazt.yl.ve
    public String getReqId() {
        if (this.x != null) {
            Object objApply = this.x.apply(com.byazt.yxi.uj.c().c(8147).c(String.class).tt());
            if (objApply instanceof String) {
                return objApply.toString();
            }
            return null;
        }
        return super.getReqId();
    }

    @Override // com.byazt.yl.ve
    public boolean adnHasAdVideoCachedApi() {
        if (this.x != null) {
            Object objApply = this.x.apply(com.byazt.yxi.uj.c().c(o.a.A).c(Boolean.class).tt());
            if (objApply instanceof Boolean) {
                return ((Boolean) objApply).booleanValue();
            }
            return super.adnHasAdVideoCachedApi();
        }
        return super.adnHasAdVideoCachedApi();
    }

    @Override // com.byazt.db.uj
    public <T> T callMethod(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        String strStringValue;
        if (i == 8115) {
            if (this.sp instanceof com.byazt.uhf.c) {
                c().i_();
            }
        } else if (i == 8116) {
            if (this.sp instanceof com.byazt.uhf.c) {
                c().j_();
            }
        } else if (i == 8117) {
            if (this.sp instanceof com.byazt.uhf.c) {
                c().n();
            }
        } else if (i == 8118) {
            if (this.sp instanceof com.byazt.uhf.c) {
                c().uj();
            }
        } else if (i == 8119) {
            if (this.sp instanceof com.byazt.uhf.c) {
                c().a();
            }
        } else if (i == 8230) {
            if (this.sp instanceof com.byazt.uhf.c) {
                c().c();
            }
        } else if (i == 8231) {
            if (this.sp instanceof com.byazt.uhf.c) {
                final boolean zBooleanValue = pluginValueSet.booleanValue(8017);
                final float fIntValue = pluginValueSet.intValue(8018);
                final String strStringValue2 = pluginValueSet.stringValue(8019);
                Map map = (Map) pluginValueSet.objectValue(8020, Map.class);
                final HashMap map2 = new HashMap();
                if (map != null) {
                    map2.putAll(map);
                }
                com.byazt.bo.c cVar = new com.byazt.bo.c() { // from class: com.byazt.db.x.1
                    @Override // com.byazt.bo.c
                    public boolean c() {
                        return zBooleanValue;
                    }

                    @Override // com.byazt.bo.c
                    public float tt() {
                        return fIntValue;
                    }

                    @Override // com.byazt.bo.c
                    public Map<String, Object> uj() {
                        return map2;
                    }

                    @Override // com.byazt.bo.c
                    public String ve() {
                        return strStringValue2;
                    }
                };
                com.byazt.bz.uj.c(cVar, "GMRewardAd reward verify");
                c().c(cVar);
            }
        } else if (i == 1017) {
            if (this.sp instanceof com.byazt.uhf.c) {
                int iIntValue = 0;
                if (pluginValueSet != null) {
                    iIntValue = pluginValueSet.intValue(8014, 0);
                    strStringValue = pluginValueSet.stringValue(8015);
                } else {
                    strStringValue = "";
                }
                c().c(new com.byazt.pp.c(iIntValue, strStringValue));
            }
        } else if (i == 8111) {
            setCpm(pluginValueSet.doubleValue(8016));
        }
        return (T) com.byazt.hf.c.c(cls);
    }
}
