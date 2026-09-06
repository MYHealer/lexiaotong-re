package com.byazt.db;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.PluginValueSet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 734, 42})
public class i extends uj {
    public com.byazt.zq.a da;

    public i(com.byazt.dv.c cVar) {
        super(cVar);
    }

    private com.byazt.zq.n c() {
        return (com.byazt.zq.n) this.sp;
    }

    @Override // com.byazt.yl.ve
    public Integer isReadyStatus() {
        return isReadyStatus(this.x);
    }

    @Override // com.byazt.yl.ve
    public void showSplashAd(ViewGroup viewGroup) {
        super.showSplashAd(viewGroup);
        if (this.x != null) {
            this.x.apply(com.byazt.yxi.uj.c().c(6152).c(Void.class).c(20060, viewGroup).tt());
        }
    }

    @Override // com.byazt.yl.ve
    public void showSplashCardView(ViewGroup viewGroup, Activity activity) {
        super.showSplashCardView(viewGroup, activity);
        if (this.x != null) {
            this.x.apply(com.byazt.yxi.uj.c().c(6154).c(Void.class).c(20060, viewGroup).c(20033, activity).tt());
        }
    }

    @Override // com.byazt.yl.ve
    public void hideSkipBtn() {
        super.hideSkipBtn();
        if (this.x != null) {
            this.x.apply(com.byazt.yxi.uj.c().c(6165).c(Void.class).tt());
        }
    }

    @Override // com.byazt.yl.ve
    public void showMinWindow(Rect rect, com.byazt.zq.a aVar) {
        super.showMinWindow(rect, aVar);
        if (this.x != null) {
            this.x.apply(com.byazt.yxi.uj.c().c(6161).c(Void.class).c(20067, rect).tt());
        }
    }

    @Override // com.byazt.yl.ve
    public void splashMinWindowAnimationFinish() {
        super.splashMinWindowAnimationFinish();
        if (this.x != null) {
            this.x.apply(com.byazt.yxi.uj.c().c(6162).c(Void.class).tt());
        }
    }

    @Override // com.byazt.yl.ve
    public Bitmap getSplashBitMap() {
        if (this.x != null) {
            Object objApply = this.x.apply(com.byazt.yxi.uj.c().c(6163).c(Bitmap.class).tt());
            if (objApply instanceof Bitmap) {
                return (Bitmap) objApply;
            }
        }
        return null;
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.byazt.db.uj
    public <T> T callMethod(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        String strStringValue;
        if (i == 8143) {
            return (T) Double.valueOf(getCpm());
        }
        int iIntValue = 0;
        if (i == 1009) {
            if (pluginValueSet != null && pluginValueSet.booleanValue(20040, false)) {
                com.byazt.zq.a aVar = this.da;
                if (!(aVar instanceof com.byazt.ko.tt)) {
                    return null;
                }
                ((com.byazt.ko.tt) aVar).uj();
                return null;
            }
            if (c() == null) {
                return null;
            }
            c().uj();
            return null;
        }
        if (i == 1017) {
            if (c() == null) {
                return null;
            }
            if (pluginValueSet != null) {
                iIntValue = pluginValueSet.intValue(8014, 0);
                strStringValue = pluginValueSet.stringValue(8015);
            } else {
                strStringValue = "";
            }
            c().c(new com.byazt.pp.c(iIntValue, strStringValue));
            return null;
        }
        if (i == 1011) {
            boolean zBooleanValue = pluginValueSet != null ? pluginValueSet.booleanValue(20040, false) : false;
            if (pluginValueSet != null) {
                pluginValueSet.intValue(8552);
            }
            if (zBooleanValue) {
                com.byazt.zq.a aVar2 = this.da;
                if (!(aVar2 instanceof com.byazt.ko.tt)) {
                    return null;
                }
                ((com.byazt.ko.tt) aVar2).tt(2);
                return null;
            }
            if (c() == null) {
                return null;
            }
            c().tt(2);
            return null;
        }
        if (i == 1008) {
            if (pluginValueSet != null && pluginValueSet.booleanValue(20040, false)) {
                com.byazt.zq.a aVar3 = this.da;
                if (!(aVar3 instanceof com.byazt.ko.tt)) {
                    return null;
                }
                ((com.byazt.ko.tt) aVar3).n();
                return null;
            }
            if (c() == null) {
                return null;
            }
            c().n();
            return null;
        }
        if (i == 1019) {
            boolean zBooleanValue2 = pluginValueSet != null ? pluginValueSet.booleanValue(20040, false) : false;
            if (pluginValueSet != null) {
                pluginValueSet.intValue(8552);
            }
            if (zBooleanValue2) {
                com.byazt.zq.a aVar4 = this.da;
                if (!(aVar4 instanceof com.byazt.ko.tt)) {
                    return null;
                }
                ((com.byazt.ko.tt) aVar4).c(1);
                return null;
            }
            if (c() == null) {
                return null;
            }
            c().c(1);
            return null;
        }
        if (i == 1074) {
            if (c() != null) {
                return (T) c().getActivity();
            }
            return null;
        }
        if (i == 1051) {
            c();
            return null;
        }
        if (i == 1052) {
            c();
            return null;
        }
        if (i == 6156) {
            if (c() == null) {
                return null;
            }
            c().l_();
            return null;
        }
        if (i != 8111) {
            return null;
        }
        setCpm(pluginValueSet.doubleValue(8016));
        return null;
    }
}
