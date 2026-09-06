package com.byazt.db;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.me.da;
import com.byazt.nc.t;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.o;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 734, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp extends uj {
    public com.byazt.dhf.c da;
    public com.byazt.sp.ve sl;

    public sp(com.byazt.dv.c cVar, com.byazt.sp.ve veVar) {
        super(cVar);
        this.sl = veVar;
    }

    @Override // com.byazt.db.uj
    public <T> T callMethod(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8130) {
            if (getAdType() == 5) {
                if (getSubAdType() == 5) {
                    if (this.f2890a != null) {
                        this.f2890a.c(null);
                    }
                } else if (this.c != null) {
                    this.c.c(null);
                }
            } else if (getAdType() == 9 && this.f2890a != null) {
                this.f2890a.c(null);
            }
        } else if (i == 8113) {
            if (getAdType() == 5) {
                if (getSubAdType() == 5) {
                    if (this.f2890a != null) {
                        this.f2890a.c();
                    }
                } else if (this.c != null) {
                    this.c.c();
                }
            } else if (getAdType() == 9 && this.f2890a != null) {
                this.f2890a.c();
            }
        } else if (i == 8131) {
            if (this.sl != null) {
                this.sl.nativeDislikeClick(this, pluginValueSet.stringValue(8036));
            }
        } else if (i == 8132) {
            if (this.i != null) {
                com.byazt.bg.c.c(this.i.tt());
            }
            if (this.da != null) {
                this.da.c(pluginValueSet.intValue(8038), pluginValueSet.stringValue(8039), false);
            }
        } else if (i == 8133) {
            float fFloatValue = pluginValueSet.floatValue(8040);
            float fFloatValue2 = pluginValueSet.floatValue(8041);
            if (getAdType() == 5) {
                if (getSubAdType() == 5) {
                    if (this.f2890a instanceof com.byazt.fy.uj) {
                        ((com.byazt.fy.uj) this.f2890a).c(fFloatValue, fFloatValue2);
                    }
                } else if (this.c instanceof com.byazt.me.a) {
                    ((com.byazt.me.a) this.c).c(fFloatValue, fFloatValue2);
                }
            } else if (getAdType() == 9 && (this.f2890a instanceof com.byazt.fy.uj)) {
                ((com.byazt.fy.uj) this.f2890a).c(fFloatValue, fFloatValue2);
            }
        } else if (i == 8134) {
            int iIntValue = pluginValueSet.intValue(8014);
            String strStringValue = pluginValueSet.stringValue(8015);
            View view = (View) pluginValueSet.objectValue(8042, View.class);
            if (getAdType() == 5) {
                if (getSubAdType() == 5) {
                    if (this.f2890a instanceof com.byazt.fy.uj) {
                        ((com.byazt.fy.uj) this.f2890a).c(view, strStringValue, iIntValue);
                    }
                } else if (this.c instanceof com.byazt.me.a) {
                    ((com.byazt.me.a) this.c).c(view, strStringValue, iIntValue);
                }
            } else if (getAdType() == 9 && (this.f2890a instanceof com.byazt.fy.uj)) {
                ((com.byazt.fy.uj) this.f2890a).c(view, strStringValue, iIntValue);
            }
        } else if (i == 8140) {
            String strStringValue2 = pluginValueSet.stringValue(8045);
            String strStringValue3 = pluginValueSet.stringValue(8046);
            int iIntValue2 = pluginValueSet.intValue(8047);
            String strStringValue4 = pluginValueSet.stringValue(8048);
            String strStringValue5 = pluginValueSet.stringValue(8049);
            String strStringValue6 = pluginValueSet.stringValue(8050);
            int iIntValue3 = pluginValueSet.intValue(8051);
            int iIntValue4 = pluginValueSet.intValue(8052);
            List<String> list = (List) pluginValueSet.objectValue(8053, List.class);
            String strStringValue7 = pluginValueSet.stringValue(8054);
            boolean zBooleanValue = pluginValueSet.booleanValue(8055);
            String strStringValue8 = pluginValueSet.stringValue(8056);
            String strStringValue9 = pluginValueSet.stringValue(8057);
            Object objObjectValue = pluginValueSet.objectValue(8036, Object.class);
            String strStringValue10 = pluginValueSet.stringValue(8058);
            double dDoubleValue = pluginValueSet.doubleValue(8016);
            boolean zBooleanValue2 = pluginValueSet.booleanValue(8033);
            int iIntValue5 = pluginValueSet.intValue(8060);
            String strStringValue11 = pluginValueSet.stringValue(8061);
            String strStringValue12 = pluginValueSet.stringValue(8061);
            long jLongValue = pluginValueSet.longValue(8078);
            String strStringValue13 = pluginValueSet.stringValue(8079);
            Map<String, String> map = (Map) pluginValueSet.objectValue(8427, Map.class);
            String strStringValue14 = pluginValueSet.stringValue(8080);
            String strStringValue15 = pluginValueSet.stringValue(8081);
            double dDoubleValue2 = pluginValueSet.doubleValue(8082);
            int iIntValue6 = pluginValueSet.intValue(8059);
            String strStringValue16 = pluginValueSet.stringValue(8551);
            String strStringValue17 = pluginValueSet.stringValue(8559);
            int iIntValue7 = pluginValueSet.intValue(8553);
            setTitle(strStringValue2);
            setAdDescription(strStringValue3);
            setAppSize(iIntValue2);
            setIconUrl(strStringValue4);
            setSource(strStringValue5);
            setImageUrl(strStringValue6);
            setImageHeight(iIntValue3);
            setImageWidth(iIntValue4);
            setImages(list);
            setPackageName(strStringValue7);
            setIsAppDownload(zBooleanValue);
            setAppName(strStringValue8);
            setAuthorName(strStringValue9);
            if (TextUtils.equals(getAdNetWorkName(), "baidu")) {
                putExtraMsg(MediationConstant.BAIDU_DISLIKE_INFO, objObjectValue);
            }
            setLevelTag(strStringValue10);
            setCpm(dDoubleValue);
            setExpressAd(zBooleanValue2);
            setImageMode(iIntValue5);
            setActionText(strStringValue11);
            setStore(strStringValue12);
            setPackageSizeBytes(jLongValue);
            setPermissionsUrl(strStringValue13);
            setPermissionsMap(map);
            setPrivacyAgreement(strStringValue14);
            setVersionName(strStringValue15);
            setRating(dDoubleValue2);
            setInteractionType(iIntValue6);
            setFunctionDescUrl(strStringValue16);
            setRegUrl(strStringValue17);
            setSupportRender(iIntValue7);
        } else {
            if (i == 8143) {
                return (T) Double.valueOf(getCpm());
            }
            if (i == 8145) {
                if (this.tt != null) {
                    this.tt.tt();
                }
            } else if (i == 8146) {
                if (this.tt != null) {
                    this.tt.ve();
                }
            } else if (i == 8118) {
                if (this.tt != null) {
                    this.tt.n();
                }
            } else if (i == 8117) {
                int iIntValue8 = pluginValueSet.intValue(8014);
                String strStringValue18 = pluginValueSet.stringValue(8015);
                if (this.tt != null) {
                    this.tt.c(new com.byazt.pp.c(iIntValue8, strStringValue18));
                }
            } else if (i == 8150) {
                if (this.tt != null) {
                    this.tt.uj();
                }
            } else if (i == 1025) {
                if (this.tt != null) {
                    this.tt.c(pluginValueSet.longValue(8072), pluginValueSet.longValue(8073));
                }
            } else if (i == 8152) {
                if (this.ve != null) {
                    this.ve.c();
                }
            } else if (i == 8153) {
                if (this.ve != null) {
                    this.ve.tt();
                }
            } else if (i == 8187) {
                if (this.ve != null) {
                    this.ve.c(pluginValueSet.longValue(8062), pluginValueSet.longValue(8063), pluginValueSet.intValue(8064), pluginValueSet.intValue(8065), "", "");
                }
            } else if (i == 8155) {
                if (this.ve != null) {
                    this.ve.c(pluginValueSet.longValue(8062), pluginValueSet.stringValue(8066), pluginValueSet.stringValue(8056));
                }
            } else if (i == 8156) {
                if (this.ve != null) {
                    this.ve.c(pluginValueSet.stringValue(8066), pluginValueSet.stringValue(8056));
                }
            } else if (i == 8157) {
                if (this.ve != null) {
                    this.ve.tt(pluginValueSet.longValue(8062), pluginValueSet.longValue(8063), pluginValueSet.stringValue(8066), pluginValueSet.stringValue(8056));
                }
            } else if (i == 8158) {
                if (this.ve != null) {
                    this.ve.c(pluginValueSet.longValue(8062), pluginValueSet.longValue(8063), pluginValueSet.stringValue(8066), pluginValueSet.stringValue(8056));
                }
            } else {
                if (i == 8160) {
                    return (T) Boolean.valueOf(isUseCustomVideo());
                }
                if (i == 6069) {
                    return (T) Integer.valueOf(getImageMode());
                }
                if (i == 8185) {
                    com.byazt.dhf.c cVar = this.da;
                    if (cVar != null) {
                        cVar.c();
                    }
                } else if (i == 8184) {
                    com.byazt.dhf.c cVar2 = this.da;
                    if (cVar2 != null) {
                        cVar2.tt();
                    }
                } else {
                    if (i == 8196) {
                        return (T) Boolean.valueOf(isExpressAd());
                    }
                    if (i == 8197) {
                        if (this.uj != null) {
                            this.uj.c();
                        }
                    } else if (i == 8227) {
                        if (pluginValueSet != null) {
                            putExtraMsg((Map) pluginValueSet.objectValue(8075, Map.class));
                        }
                    } else if (i == 6107 && this.n != null) {
                        this.n.c(pluginValueSet.intValue(20055));
                    }
                }
            }
        }
        return (T) com.byazt.hf.c.c(cls);
    }

    @Override // com.byazt.yl.ve
    public void setDislikeCallback(Activity activity, com.byazt.dhf.c cVar) {
        this.da = cVar;
        if (this.x != null) {
            this.x.apply(com.byazt.yxi.uj.c().c(6085).c(Void.class).c(20033, activity).tt());
        }
    }

    @Override // com.byazt.yl.ve
    public void render() {
        super.render();
        if (this.x != null) {
            this.x.apply(com.byazt.yxi.uj.c().c(6083).c(Void.class).tt());
        }
    }

    @Override // com.byazt.yl.ve
    public View getAdView() {
        if (this.x != null) {
            Object objApply = this.x.apply(com.byazt.yxi.uj.c().c(6081).c(View.class).tt());
            if (objApply instanceof View) {
                return (View) objApply;
            }
            return null;
        }
        return super.getAdView();
    }

    @Override // com.byazt.yl.ve
    public View getVideoView() {
        if (this.x != null) {
            Object objApply = this.x.apply(com.byazt.yxi.uj.c().c(6164).c(View.class).tt());
            if (objApply instanceof View) {
                return (View) objApply;
            }
            return null;
        }
        return super.getVideoView();
    }

    @Override // com.byazt.yl.ve
    public boolean hasDislike() {
        try {
            if (this.x != null) {
                Object objApply = this.x.apply(com.byazt.yxi.uj.c().c(8135).c(Boolean.class).tt());
                return (objApply instanceof Boolean) && ((Boolean) objApply).booleanValue();
            }
        } catch (Exception unused) {
        }
        return super.hasDislike();
    }

    @Override // com.byazt.yl.ve
    public Integer isReadyStatus() {
        return isReadyStatus(this.x);
    }

    @Override // com.byazt.yl.ve
    public void registerViewForInteraction(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, da daVar, List<View> list4) {
        super.registerViewForInteraction(activity, viewGroup, list, list2, list3, daVar, list4);
        c(activity, viewGroup, list, list2, list3, daVar, list4);
    }

    private void c(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, da daVar, List<View> list4) {
        if (this.x != null) {
            this.x.apply(com.byazt.yxi.uj.c().c(8159).c(Void.class).c(20033, activity).c(8067, viewGroup).c(8068, list).c(8069, list2).c(8070, list3).c(8071, da.c(daVar)).c(8053, list4).tt());
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
    public int getVideoWidth() {
        if (this.x != null) {
            Object objApply = this.x.apply(com.byazt.yxi.uj.c().c(8161).c(Integer.class).tt());
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
            return 0;
        }
        return super.getVideoWidth();
    }

    @Override // com.byazt.yl.ve
    public int getVideoHeight() {
        if (this.x != null) {
            Object objApply = this.x.apply(com.byazt.yxi.uj.c().c(8162).c(Integer.class).tt());
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
            return 0;
        }
        return super.getVideoWidth();
    }

    @Override // com.byazt.yl.ve
    public String getVideoUrl() {
        if (this.x != null) {
            Object objApply = this.x.apply(com.byazt.yxi.uj.c().c(8163).c(String.class).tt());
            return objApply instanceof String ? objApply.toString() : "";
        }
        return super.getVideoUrl();
    }

    @Override // com.byazt.yl.ve
    public t getVideoCoverImage() {
        if (this.x != null) {
            Object objApply = this.x.apply(com.byazt.yxi.uj.c().c(8269).c(Map.class).tt());
            if (objApply instanceof Map) {
                Map map = (Map) objApply;
                Object obj = map.get("imgUrl");
                final Object obj2 = map.get("width");
                final Object obj3 = map.get("height");
                final Object obj4 = map.get("valid");
                final Object obj5 = map.get("duration");
                if (obj instanceof String) {
                    final String str = (String) obj;
                    if (!TextUtils.isEmpty(str)) {
                        return new t() { // from class: com.byazt.db.sp.1
                            @Override // com.byazt.nc.t
                            public String getImageUrl() {
                                return str;
                            }

                            @Override // com.byazt.nc.t
                            public int getHeight() {
                                Object obj6 = obj3;
                                if (obj6 instanceof Integer) {
                                    return ((Integer) obj6).intValue();
                                }
                                return 0;
                            }

                            @Override // com.byazt.nc.t
                            public int getWidth() {
                                Object obj6 = obj2;
                                if (obj6 instanceof Integer) {
                                    return ((Integer) obj6).intValue();
                                }
                                return 0;
                            }

                            @Override // com.byazt.nc.t
                            public double getDuration() {
                                Object obj6 = obj5;
                                if (obj6 instanceof Double) {
                                    return ((Double) obj6).doubleValue();
                                }
                                return 0.0d;
                            }

                            @Override // com.byazt.nc.t
                            public boolean isValid() {
                                Object obj6 = obj4;
                                return (obj6 instanceof Boolean) && ((Boolean) obj6).booleanValue();
                            }
                        };
                    }
                }
            }
        }
        return super.getVideoCoverImage();
    }

    @Override // com.byazt.yl.ve
    public Bitmap getAdLogo() {
        if (TextUtils.equals(getAdnName(), MediationConstant.ADN_GDT)) {
            return com.byazt.fh.uj.c(2);
        }
        if (this.x != null) {
            Object objApply = this.x.apply(com.byazt.yxi.uj.c().c(8267).c(Bitmap.class).tt());
            if (objApply instanceof Bitmap) {
                return (Bitmap) objApply;
            }
            return null;
        }
        return super.getAdLogo();
    }

    @Override // com.byazt.yl.ve
    public double getVideoDuration() {
        if (this.x != null) {
            Object objApply = this.x.apply(com.byazt.yxi.uj.c().c(8268).c(Double.class).tt());
            if (objApply instanceof Double) {
                return ((Double) objApply).doubleValue();
            }
            return 0.0d;
        }
        return super.getVideoDuration();
    }

    @Override // com.byazt.yl.ve
    public com.byazt.me.n getGMNativeCustomVideoReporter() {
        if (this.x == null) {
            return null;
        }
        Object objApply = this.x.apply(com.byazt.yxi.uj.c().c(8320).c(Function.class).tt());
        if (objApply instanceof Function) {
            return com.byazt.zr.c.c((Function) objApply);
        }
        return null;
    }

    @Override // com.byazt.yl.ve
    public void pauseAppDownload() {
        if (this.x != null) {
            this.x.apply(com.byazt.yxi.uj.c().c(8191).c(Void.class).tt());
        }
    }

    @Override // com.byazt.yl.ve
    public void resumeAppDownload() {
        if (this.x != null) {
            this.x.apply(com.byazt.yxi.uj.c().c(8192).c(Void.class).tt());
        }
    }

    @Override // com.byazt.yl.ve
    public void cancelDownload() {
        if (this.x != null) {
            this.x.apply(com.byazt.yxi.uj.c().c(6093).c(Void.class).tt());
        }
    }

    @Override // com.byazt.yl.ve
    public int getDownloadStatus() {
        if (this.x != null) {
            Object objApply = this.x.apply(com.byazt.yxi.uj.c().c(o.a.p).c(Integer.class).tt());
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
            return 0;
        }
        return super.getDownloadStatus();
    }

    @Override // com.byazt.yl.ve
    public void dislikeClick(String str, Map<String, Object> map) {
        if (this.x != null) {
            this.x.apply(com.byazt.yxi.uj.c().c(8194).c(Integer.class).c(8036, str).c(8075, map).tt());
        }
    }

    @Override // com.byazt.yl.ve
    public void unregisterView() {
        if (this.x != null) {
            this.x.apply(com.byazt.yxi.uj.c().c(o.a.r).c(Void.class).tt());
        }
    }
}
