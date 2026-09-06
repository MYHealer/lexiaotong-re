package com.heytap.msp.mobad.api.ad;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.heytap.msp.mobad.api.listener.INativeAdvanceInteractInfoListener;
import com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener;
import com.heytap.msp.mobad.api.listener.INativeAdvanceLoadListener;
import com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener;
import com.heytap.msp.mobad.api.params.INativeAdFile;
import com.heytap.msp.mobad.api.params.INativeAdvanceComplianceInfo;
import com.heytap.msp.mobad.api.params.INativeAdvanceData;
import com.heytap.msp.mobad.api.params.INativeComplianceListener;
import com.heytap.msp.mobad.api.params.MediaView;
import com.heytap.msp.mobad.api.params.NativeAdvanceContainer;
import com.opos.mobad.ad.d.g;
import com.opos.mobad.ad.d.h;
import com.opos.mobad.ad.d.i;
import com.opos.mobad.ad.d.j;
import com.opos.mobad.ad.d.k;
import com.opos.mobad.ad.d.t;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class NativeAdvanceAd {
    private static final String TAG = "NativeAdvanceAd";
    private Context mContext;
    private c mListener;
    private volatile g mNativeAdImpl;
    private String mPosId;

    static class a extends com.heytap.msp.mobad.api.params.a {
        private h c;
        private INativeAdvanceComplianceInfo d;

        public a(h hVar) {
            this.c = hVar;
            if (hVar.n() != null) {
                this.d = new INativeAdvanceComplianceInfo() { // from class: com.heytap.msp.mobad.api.ad.NativeAdvanceAd.a.6
                    @Override // com.heytap.msp.mobad.api.params.INativeAdvanceComplianceInfo
                    public String getAppName() {
                        return a.this.c.n().c();
                    }

                    @Override // com.heytap.msp.mobad.api.params.INativeAdvanceComplianceInfo
                    public String getAppVersion() {
                        return a.this.c.n().a();
                    }

                    @Override // com.heytap.msp.mobad.api.params.INativeAdvanceComplianceInfo
                    public String getDeveloperName() {
                        return a.this.c.n().b();
                    }
                };
            }
        }

        private int a(Map<String, Object> map, String str, int i) {
            Object obj;
            int iIntValue;
            if (map == null || !map.containsKey(str) || (obj = map.get(str)) == null || !(obj instanceof Integer) || (iIntValue = ((Integer) obj).intValue()) == 0) {
                return i;
            }
            return ((iIntValue >>> 24) & 255) < 77 ? (iIntValue & ViewCompat.MEASURED_SIZE_MASK) + 1291845632 : iIntValue;
        }

        private int a(Map<String, Object> map, String str, int i, int i2, int i3) {
            Object obj;
            if (map == null || !map.containsKey(str) || (obj = map.get(str)) == null || !(obj instanceof Integer)) {
                return i3;
            }
            int iIntValue = ((Integer) obj).intValue();
            if (iIntValue < i) {
                return i;
            }
            return iIntValue > i2 ? i2 : iIntValue;
        }

        private int b(Map<String, Object> map, String str, int i, int i2, int i3) {
            Object obj;
            int iIntValue;
            return (map == null || !map.containsKey(str) || (obj = map.get(str)) == null || !(obj instanceof Integer) || (iIntValue = ((Integer) obj).intValue()) < i || iIntValue > i2) ? i3 : iIntValue;
        }

        @Override // com.heytap.msp.mobad.api.params.a, com.heytap.msp.mobad.api.params.INativeAdvanceData
        public void bindMediaView(Context context, MediaView mediaView, INativeAdvanceMediaListener iNativeAdvanceMediaListener) {
            if (this.c.g() == 13) {
                this.f3452a = 16;
                this.b = 9;
            } else if (this.c.g() == 16) {
                this.f3452a = 9;
                this.b = 16;
            }
            super.bindMediaView(context, mediaView, iNativeAdvanceMediaListener);
            this.c.a(context, mediaView, new d(iNativeAdvanceMediaListener));
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public void bindToComplianceView(Context context, List<View> list, final INativeComplianceListener iNativeComplianceListener, List<View> list2, final INativeComplianceListener iNativeComplianceListener2) {
            this.c.a(context, list, new h.a() { // from class: com.heytap.msp.mobad.api.ad.NativeAdvanceAd.a.1
                @Override // com.opos.mobad.ad.d.h.a
                public void a() {
                    INativeComplianceListener iNativeComplianceListener3 = iNativeComplianceListener;
                    if (iNativeComplianceListener3 == null) {
                        return;
                    }
                    iNativeComplianceListener3.onClose();
                }

                @Override // com.opos.mobad.ad.d.h.a
                public void a(View view) {
                    INativeComplianceListener iNativeComplianceListener3 = iNativeComplianceListener;
                    if (iNativeComplianceListener3 == null) {
                        return;
                    }
                    iNativeComplianceListener3.onClick(view);
                }
            }, list2, new h.a() { // from class: com.heytap.msp.mobad.api.ad.NativeAdvanceAd.a.2
                @Override // com.opos.mobad.ad.d.h.a
                public void a() {
                    INativeComplianceListener iNativeComplianceListener3 = iNativeComplianceListener2;
                    if (iNativeComplianceListener3 == null) {
                        return;
                    }
                    iNativeComplianceListener3.onClose();
                }

                @Override // com.opos.mobad.ad.d.h.a
                public void a(View view) {
                    INativeComplianceListener iNativeComplianceListener3 = iNativeComplianceListener2;
                    if (iNativeComplianceListener3 == null) {
                        return;
                    }
                    iNativeComplianceListener3.onClick(view);
                }
            });
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public void bindToComplianceView(Context context, List<View> list, final INativeComplianceListener iNativeComplianceListener, List<View> list2, final INativeComplianceListener iNativeComplianceListener2, List<View> list3, final INativeComplianceListener iNativeComplianceListener3) {
            this.c.a(context, list, new h.a() { // from class: com.heytap.msp.mobad.api.ad.NativeAdvanceAd.a.3
                @Override // com.opos.mobad.ad.d.h.a
                public void a() {
                    INativeComplianceListener iNativeComplianceListener4 = iNativeComplianceListener;
                    if (iNativeComplianceListener4 == null) {
                        return;
                    }
                    iNativeComplianceListener4.onClose();
                }

                @Override // com.opos.mobad.ad.d.h.a
                public void a(View view) {
                    INativeComplianceListener iNativeComplianceListener4 = iNativeComplianceListener;
                    if (iNativeComplianceListener4 == null) {
                        return;
                    }
                    iNativeComplianceListener4.onClick(view);
                }
            }, list2, new h.a() { // from class: com.heytap.msp.mobad.api.ad.NativeAdvanceAd.a.4
                @Override // com.opos.mobad.ad.d.h.a
                public void a() {
                    INativeComplianceListener iNativeComplianceListener4 = iNativeComplianceListener2;
                    if (iNativeComplianceListener4 == null) {
                        return;
                    }
                    iNativeComplianceListener4.onClose();
                }

                @Override // com.opos.mobad.ad.d.h.a
                public void a(View view) {
                    INativeComplianceListener iNativeComplianceListener4 = iNativeComplianceListener2;
                    if (iNativeComplianceListener4 == null) {
                        return;
                    }
                    iNativeComplianceListener4.onClick(view);
                }
            }, list3, new h.a() { // from class: com.heytap.msp.mobad.api.ad.NativeAdvanceAd.a.5
                @Override // com.opos.mobad.ad.d.h.a
                public void a() {
                    INativeComplianceListener iNativeComplianceListener4 = iNativeComplianceListener3;
                    if (iNativeComplianceListener4 == null) {
                        return;
                    }
                    iNativeComplianceListener4.onClose();
                }

                @Override // com.opos.mobad.ad.d.h.a
                public void a(View view) {
                    INativeComplianceListener iNativeComplianceListener4 = iNativeComplianceListener3;
                    if (iNativeComplianceListener4 == null) {
                        return;
                    }
                    iNativeComplianceListener4.onClick(view);
                }
            });
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public void bindToView(Context context, NativeAdvanceContainer nativeAdvanceContainer, List<View> list) {
            this.c.a(context, nativeAdvanceContainer, (t) null, list, (List<View>) null);
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public void bindToView(Context context, NativeAdvanceContainer nativeAdvanceContainer, List<View> list, List<View> list2) {
            this.c.a(context, nativeAdvanceContainer, (t) null, list, list2);
        }

        /* JADX WARN: Code duplicated, block: B:41:0x0087  */
        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public void bindToView(Context context, NativeAdvanceContainer nativeAdvanceContainer, Map<String, Object> map, List<View> list, List<View> list2) {
            byte b;
            if (map == null) {
                this.c.a(context, nativeAdvanceContainer, (t) null, list, list2);
                return;
            }
            t.a aVar = new t.a();
            int width = nativeAdvanceContainer.getWidth() > 0 ? nativeAdvanceContainer.getWidth() : com.opos.cmn.an.h.f.a.b(context);
            int height = nativeAdvanceContainer.getHeight() > 0 ? nativeAdvanceContainer.getHeight() : com.opos.cmn.an.h.f.a.c(context);
            if (map.containsKey(INativeAdvanceData.KEY_CLOSE_BUTTON_POSITION)) {
                Object obj = map.get(INativeAdvanceData.KEY_CLOSE_BUTTON_POSITION);
                if (obj == null || !(obj instanceof String)) {
                    aVar.a(1);
                } else {
                    switch ((String) obj) {
                        case "bottomLeft":
                            b = 1;
                            break;
                        case "topLeft":
                            b = 0;
                            break;
                        case "topRight":
                            b = 3;
                            break;
                        case "bottomRight":
                            b = 2;
                            break;
                        default:
                            b = -1;
                            break;
                    }
                    if (b == 0) {
                        aVar.a(0);
                    } else if (b == 1) {
                        aVar.a(2);
                    } else if (b != 2) {
                        aVar.a(1);
                    } else {
                        aVar.a(3);
                    }
                }
            }
            aVar.b(a(map, INativeAdvanceData.KEY_NATIVE_APP_INFO_LINES, 1, 2, 1));
            aVar.c(a(map, INativeAdvanceData.KEY_NATIVE_APP_INFO_START_MARGIN, 0, Integer.MAX_VALUE, 16));
            aVar.d(a(map, INativeAdvanceData.KEY_NATIVE_APP_INFO_BOTTOM_MARGIN, 0, Integer.MAX_VALUE, 38));
            aVar.e(a(map, INativeAdvanceData.KEY_NATIVE_PRIVACY_START_MARGIN, 0, Integer.MAX_VALUE, 16));
            aVar.f(a(map, INativeAdvanceData.KEY_NATIVE_PRIVACY_BOTTOM_MARGIN, 0, Integer.MAX_VALUE, 16));
            aVar.g(a(map, INativeAdvanceData.KEY_NATIVE_AD_BUTTON_WIDTH, 44, Integer.MAX_VALUE, 74));
            aVar.h(a(map, INativeAdvanceData.KEY_NATIVE_AD_BUTTON_HEIGHT, 28, 100, 32));
            aVar.i(a(map, INativeAdvanceData.KEY_NATIVE_AD_BUTTON_END_MARGIN, 0, Integer.MAX_VALUE, 16));
            aVar.j(a(map, INativeAdvanceData.KEY_NATIVE_AD_BUTTON_BOTTOM_MARGIN, 0, Integer.MAX_VALUE, 16));
            aVar.k(a(map, INativeAdvanceData.KEY_NATIVE_AD_BUTTON_TEXT_SIZE, 10, 36, 12));
            aVar.l(a(map, INativeAdvanceData.KEY_NATIVE_AD_BUTTON_BORDER_RADIUS, 0, 50, 50));
            aVar.m(a(map, INativeAdvanceData.KEY_NATIVE_AD_BUTTON_BACKGROUND_COLOR, -16777216));
            aVar.n(a(map, INativeAdvanceData.KEY_NATIVE_AD_BUTTON_TEXT_COLOR, -1));
            aVar.o(a(map, INativeAdvanceData.KEY_NATIVE_AD_BUTTON_BORDER_COLOR, Integer.MIN_VALUE, Integer.MAX_VALUE, 0));
            aVar.p(b(map, INativeAdvanceData.KEY_NATIVE_AD_IS_SHOW_INTERACTIVE_COMPONENT, 0, 1, 0));
            aVar.q(a(map, INativeAdvanceData.KEY_NATIVE_AD_INTERACTIVE_COMPONENT_START_MARGIN, 0, width, 12));
            aVar.r(a(map, INativeAdvanceData.KEY_NATIVE_AD_INTERACTIVE_COMPONENT_TOP_MARGIN, 0, height, 12));
            aVar.s(b(map, INativeAdvanceData.KEY_NATIVE_AD_INTERACTIVE_COMPONENT_SIZE_TYPE, 0, 1, 0));
            this.c.a(context, nativeAdvanceContainer, aVar.a(), list, list2);
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public boolean canIUse(String str) {
            return this.c.a(str);
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public String getBidId() {
            return this.c.o();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public String getClickBnText() {
            return this.c.l();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public INativeAdvanceComplianceInfo getComplianceInfo() {
            return this.d;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public int getContentType() {
            return this.c.p();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public int getCreativeType() {
            return this.c.g();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public String getDesc() {
            return this.c.b();
        }

        @Override // com.heytap.msp.mobad.api.ad.IBidding
        public int getECPM() {
            return this.c.f();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public String getExtra() {
            return this.c.k();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public List<INativeAdFile> getIconFiles() {
            List<com.opos.mobad.ad.d.e> listC = this.c.c();
            if (listC == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (com.opos.mobad.ad.d.e eVar : listC) {
                if (eVar != null) {
                    arrayList.add(new e(eVar));
                }
            }
            return arrayList;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public List<INativeAdFile> getImgFiles() {
            List<com.opos.mobad.ad.d.e> listD = this.c.d();
            if (listD == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (com.opos.mobad.ad.d.e eVar : listD) {
                if (eVar != null) {
                    arrayList.add(new e(eVar));
                }
            }
            return arrayList;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public INativeAdFile getLogoFile() {
            com.opos.mobad.ad.d.e eVarI = this.c.i();
            if (eVarI == null) {
                return null;
            }
            return new e(eVarI);
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public String getTitle() {
            return this.c.a();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public int getVideoDuration() {
            return this.c.h();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public boolean isAdValid() {
            return this.c.j();
        }

        @Override // com.heytap.msp.mobad.api.ad.IBidding
        public void notifyRankLoss(int i, String str, int i2) {
            this.c.a(i, str, i2);
        }

        @Override // com.heytap.msp.mobad.api.ad.IBidding
        public void notifyRankWin(int i) {
            this.c.b(i);
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public void release() {
            this.c.m();
        }

        @Override // com.heytap.msp.mobad.api.ad.IBidding
        public void setBidECPM(int i) {
            this.c.c(i);
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public void setInteractListener(INativeAdvanceInteractListener iNativeAdvanceInteractListener) {
            this.c.a(new b(iNativeAdvanceInteractListener));
        }
    }

    private static class b implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private INativeAdvanceInteractListener f3443a;

        public b(INativeAdvanceInteractListener iNativeAdvanceInteractListener) {
            this.f3443a = iNativeAdvanceInteractListener;
        }

        @Override // com.opos.mobad.ad.d.i
        public void a() {
            INativeAdvanceInteractListener iNativeAdvanceInteractListener = this.f3443a;
            if (iNativeAdvanceInteractListener == null || !(iNativeAdvanceInteractListener instanceof INativeAdvanceInteractInfoListener)) {
                return;
            }
            ((INativeAdvanceInteractInfoListener) iNativeAdvanceInteractListener).onClose();
        }

        @Override // com.opos.mobad.ad.d.i
        public void a(int i) {
            INativeAdvanceInteractListener iNativeAdvanceInteractListener = this.f3443a;
            if (iNativeAdvanceInteractListener != null) {
                if (iNativeAdvanceInteractListener instanceof INativeAdvanceInteractInfoListener) {
                    ((INativeAdvanceInteractInfoListener) iNativeAdvanceInteractListener).onClick(i);
                } else {
                    iNativeAdvanceInteractListener.onClick();
                }
            }
        }

        @Override // com.opos.mobad.ad.d.i
        public void a(int i, String str) {
            INativeAdvanceInteractListener iNativeAdvanceInteractListener = this.f3443a;
            if (iNativeAdvanceInteractListener != null) {
                iNativeAdvanceInteractListener.onError(i, str);
            }
        }

        @Override // com.opos.mobad.ad.d.i
        public void b() {
            INativeAdvanceInteractListener iNativeAdvanceInteractListener = this.f3443a;
            if (iNativeAdvanceInteractListener != null) {
                iNativeAdvanceInteractListener.onShow();
            }
        }
    }

    static class c implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private INativeAdvanceLoadListener f3444a;

        public c(INativeAdvanceLoadListener iNativeAdvanceLoadListener) {
            this.f3444a = iNativeAdvanceLoadListener;
        }

        @Override // com.opos.mobad.ad.d.a
        public void a(int i, String str) {
            INativeAdvanceLoadListener iNativeAdvanceLoadListener = this.f3444a;
            if (iNativeAdvanceLoadListener != null) {
                iNativeAdvanceLoadListener.onAdFailed(i, str);
            }
        }

        @Override // com.opos.mobad.ad.d.a
        public void a(List<h> list) {
            ArrayList arrayList;
            if (this.f3444a != null) {
                if (list != null) {
                    arrayList = new ArrayList();
                    Iterator<h> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new a(it.next()));
                    }
                } else {
                    arrayList = null;
                }
                this.f3444a.onAdSuccess(arrayList);
            }
        }
    }

    private static class d implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private INativeAdvanceMediaListener f3445a;

        public d(INativeAdvanceMediaListener iNativeAdvanceMediaListener) {
            this.f3445a = iNativeAdvanceMediaListener;
        }

        @Override // com.opos.mobad.ad.d.k
        public void a() {
            INativeAdvanceMediaListener iNativeAdvanceMediaListener = this.f3445a;
            if (iNativeAdvanceMediaListener != null) {
                iNativeAdvanceMediaListener.onVideoPlayStart();
            }
        }

        @Override // com.opos.mobad.ad.d.k
        public void a(int i, String str) {
            INativeAdvanceMediaListener iNativeAdvanceMediaListener = this.f3445a;
            if (iNativeAdvanceMediaListener != null) {
                iNativeAdvanceMediaListener.onVideoPlayError(i, str);
            }
        }

        @Override // com.opos.mobad.ad.d.k
        public void b() {
            INativeAdvanceMediaListener iNativeAdvanceMediaListener = this.f3445a;
            if (iNativeAdvanceMediaListener != null) {
                iNativeAdvanceMediaListener.onVideoPlayComplete();
            }
        }
    }

    private static class e implements INativeAdFile {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.opos.mobad.ad.d.e f3446a;

        public e(com.opos.mobad.ad.d.e eVar) {
            this.f3446a = eVar;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdFile
        public String getMd5() {
            return this.f3446a.a();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdFile
        public String getUrl() {
            return this.f3446a.a();
        }
    }

    public NativeAdvanceAd(Context context, String str, INativeAdvanceLoadListener iNativeAdvanceLoadListener) {
        if (context == null || TextUtils.isEmpty(str) || iNativeAdvanceLoadListener == null) {
            Log.e(TAG, "NativeAd Constructor param context and posId and iNativeAdListener can't be null.");
            return;
        }
        this.mContext = context;
        this.mPosId = str;
        this.mListener = getLoadListener(iNativeAdvanceLoadListener);
        initImplIfNeed();
    }

    private boolean initImplIfNeed() {
        if (this.mNativeAdImpl != null) {
            return true;
        }
        if (this.mContext == null || TextUtils.isEmpty(this.mPosId)) {
            return false;
        }
        synchronized (this) {
            if (this.mNativeAdImpl != null) {
                return true;
            }
            this.mNativeAdImpl = com.heytap.msp.mobad.api.a.a().a(StubApp.getOrigApplicationContext(this.mContext.getApplicationContext()), this.mPosId, this.mListener);
            return this.mNativeAdImpl != null;
        }
    }

    private void loadInter(List<String> list) {
        if (initImplIfNeed()) {
            if (list == null) {
                this.mNativeAdImpl.a();
                return;
            } else {
                this.mNativeAdImpl.a(list);
                return;
            }
        }
        c cVar = this.mListener;
        if (cVar != null) {
            cVar.a(-1, "inter ad create fail");
        }
    }

    public void destroyAd() {
        if (this.mNativeAdImpl != null) {
            this.mNativeAdImpl.b();
        }
        this.mContext = null;
        this.mPosId = null;
    }

    public int getECPM() {
        if (this.mNativeAdImpl == null) {
            return 0;
        }
        this.mNativeAdImpl.f();
        return 0;
    }

    c getLoadListener(INativeAdvanceLoadListener iNativeAdvanceLoadListener) {
        return new c(iNativeAdvanceLoadListener);
    }

    public void loadAd() {
        loadInter((List<String>) null);
    }

    public void loadAd(List<String> list) {
        if (list != null && list.size() > 0) {
            loadInter(new ArrayList(list));
            return;
        }
        c cVar = this.mListener;
        if (cVar != null) {
            cVar.a(10701, "load error, please check you bidIds");
        }
    }

    public void loadAdWithData(String str) {
        loadInter(str);
    }

    protected void loadInter(String str) {
        if (initImplIfNeed()) {
            this.mNativeAdImpl.a(str);
            return;
        }
        c cVar = this.mListener;
        if (cVar != null) {
            cVar.a(-1, "inter ad create fail");
        }
    }
}
