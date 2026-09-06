package com.fancy.adsdk.lib;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import com.fancy._c7;
import com.fancy._ca;
import com.fancy._ev;
import com.fancy._fl;
import com.fancy._g;
import com.fancy._ie;
import com.fancy._il;
import com.fancy._in;
import com.fancy._kr;
import com.fancy._lu;
import com.fancy._lx;
import com.fancy._n4;
import com.fancy._n5;
import com.fancy._oz;
import com.fancy._p0;
import com.fancy._p2;
import com.fancy._ph;
import com.fancy.adsdk.lib.interf.PtgCustomController;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import com.fancy.adsdk.lib.utils.Logger;
import com.fancy.mpsdk.provider.PtgApiProvider;
import com.stub.StubApp;
import com.umeng.analytics.pro.am;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class PtgAdSdk {
    private static Context mContext;
    private static _g sAppLifecycleListener;
    public static PtgCustomController tempPtgCustomController;
    public static PtgSDKConfig config = new PtgSDKConfig();
    public static PtgAdNative globalProvider = new com.fancy.adsdk.lib.provider._a();
    private static final AtomicBoolean isInitializing = new AtomicBoolean();
    private static final AtomicBoolean isInitialized = new AtomicBoolean();

    public interface Callback {
        void fail(int i, String str);

        void success();
    }

    private static PtgAdNative[] automaticIntegrationProviders() {
        ArrayList arrayList = new ArrayList();
        for (int i : _il._b(1)) {
            try {
                _in._a(i);
                if (_lx._a("com.fancy.mpsdk.PtgAdProxy")) {
                    _in._b(i);
                    arrayList.add((PtgAdNative) PtgApiProvider.class.newInstance());
                }
            } catch (Exception unused) {
            }
        }
        return (PtgAdNative[]) arrayList.toArray(new PtgAdNative[0]);
    }

    private static boolean checkParametersValidity(PtgSDKConfig ptgSDKConfig, Callback callback) {
        if (ptgSDKConfig != null && ptgSDKConfig.getMediaId() != null && !ptgSDKConfig.getMediaId().isEmpty() && ptgSDKConfig.getMediaSecret() != null && !ptgSDKConfig.getMediaSecret().isEmpty()) {
            return true;
        }
        if (callback == null) {
            throw new IllegalArgumentException("MediaId 或 MediaSecret 未配置！");
        }
        callback.fail(10003, "MediaId 或 MediaSecret 未配置！");
        return false;
    }

    private static void clearConfigSp() {
        _kr._a(mContext, am.bo, "");
        _kr._a(mContext, "config", "");
    }

    public static PtgAdNative get() {
        return globalProvider;
    }

    public static _g getAppLifecycleListener() {
        if (sAppLifecycleListener == null) {
            sAppLifecycleListener = new _g();
        }
        return sAppLifecycleListener;
    }

    public static PtgSDKConfig getConfig() {
        return config;
    }

    public static Context getContext() {
        return mContext;
    }

    public static boolean getIsInitializing() {
        return isInitializing.get();
    }

    public static boolean getSensorStatus() {
        return getConfig().isSensorStatus();
    }

    public static void init(Context context, PtgSDKConfig ptgSDKConfig) {
        init(context, ptgSDKConfig, null, automaticIntegrationProviders());
    }

    public static void init(Context context, PtgSDKConfig ptgSDKConfig, Callback callback) {
        init(context, ptgSDKConfig, callback, automaticIntegrationProviders());
    }

    @Deprecated
    public static void init(Context context, PtgSDKConfig ptgSDKConfig, final Callback callback, PtgAdNative... ptgAdNativeArr) {
        try {
            if (checkParametersValidity(ptgSDKConfig, callback)) {
                if (isInitialized()) {
                    if (callback != null) {
                        callback.success();
                        return;
                    }
                    return;
                }
                AtomicBoolean atomicBoolean = isInitializing;
                if (atomicBoolean.get()) {
                    return;
                }
                atomicBoolean.set(true);
                mContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                _fl._c._a(mContext, getAppLifecycleListener());
                _ev._a(mContext);
                config = ptgSDKConfig;
                clearConfigSp();
                ptgSDKConfig.setInitStartTime();
                Logger.LogDispatcher.addLogReceiver(new _ph());
                Logger.LogDispatcher.addLogReceiver(new com.fancy.adsdk.lib.utils._c(new Logger.PlainLogger(Logger.ILogger.TAG)));
                mergeCustomController();
                initDeviceInfo();
                Context context2 = mContext;
                Callback callback2 = new Callback() { // from class: com.fancy.adsdk.lib.PtgAdSdk.1
                    @Override // com.fancy.adsdk.lib.PtgAdSdk.Callback
                    public void fail(final int i, final String str) {
                        PtgAdSdk.isInitializing.set(false);
                        PtgAdSdk.isInitialized.set(false);
                        com.fancy.adsdk.lib.utils._d._c(new Runnable() { // from class: com.fancy.adsdk.lib.PtgAdSdk.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                Callback callback3 = callback;
                                if (callback3 != null) {
                                    callback3.fail(i, str);
                                }
                            }
                        });
                    }

                    @Override // com.fancy.adsdk.lib.PtgAdSdk.Callback
                    public void success() {
                        PtgAdSdk.isInitializing.set(false);
                        PtgAdSdk.isInitialized.set(true);
                        com.fancy.adsdk.lib.utils._d._c(new Runnable() { // from class: com.fancy.adsdk.lib.PtgAdSdk.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Callback callback3 = callback;
                                if (callback3 != null) {
                                    callback3.success();
                                }
                            }
                        });
                    }
                };
                if (callback == null) {
                    _a._a(context2, ptgSDKConfig, callback2, ptgAdNativeArr);
                } else {
                    com.fancy.adsdk.lib.utils._d._b(new _b(context2, ptgSDKConfig, callback2, ptgAdNativeArr));
                }
            }
        } catch (Exception e) {
            isInitializing.set(false);
            isInitialized.set(false);
            com.fancy.adsdk.lib.utils._d._c(new Runnable() { // from class: com.fancy.adsdk.lib.PtgAdSdk.2
                @Override // java.lang.Runnable
                public void run() {
                    Callback callback3 = callback;
                    if (callback3 != null) {
                        callback3.fail(10006, e.getMessage());
                    }
                }
            });
        }
    }

    private static void initDeviceInfo() {
        boolean z = true;
        _lu._a[1] = 33;
        _n4._a = _ca._c();
        ConcurrentHashMap<String, SharedPreferences> concurrentHashMap = _kr._a;
        if (_n4._a != null) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                String str = _n4._a._s;
                long j_b = _kr._b(getContext(), "sdk_local_f_i_t");
                if (j_b == 0) {
                    _kr._a(getContext(), "sdk_local_f_i_t", jCurrentTimeMillis);
                    j_b = jCurrentTimeMillis;
                }
                long j_b2 = _kr._b(getContext(), "sdk_local_i_t" + str);
                if (j_b2 == 0) {
                    _kr._a(getContext(), "sdk_local_i_t" + str, jCurrentTimeMillis);
                } else {
                    jCurrentTimeMillis = j_b2;
                }
                _c7 _c7Var = _n4._a;
                _c7Var._B = j_b;
                _c7Var._C = jCurrentTimeMillis;
            } catch (Exception unused) {
            }
        }
        Context context = mContext;
        AtomicBoolean atomicBoolean = _p2._a;
        byte[] bArr = _lu._a;
        bArr[0] = 82;
        bArr[2] = 12;
        if (TextUtils.isEmpty(getConfig().getDetectRule()) && _kr._b(context, "ru_la_bu_ti") <= 0) {
            try {
                getConfig().setDetectRule(_n5._a("86F8039660DDDF2141BA72C515EF950439D1B83E597E5E29D2E7E2A2C37A936A8AA043845CEB54BD2B9DC7D9535658D26BE1DE2CBD5BAADBB0B227F1EAC9B2DD3004772AF4F2D2CDBF2FCA683D62E7B24114DE1B1C47386D9B5634831FE0A0D9F8BA84F957CEC22969F25789217760DFC3C39C7B7F5E6CED5586224A904DA1BB291838FB045F6DB846DD9B096436014EEBB6D868B599792E3FA0829D677210845C8467EEC088EB3733CC957D348800AB1437E327EF2CCC0E103BAB208BE4575BAA359705A13A94682F0D9008A96509C707C09C6D2BED0E4FF96496F0B7733CF8CA35C137BEAAE22A5F30CAC763FCEB49A3E7B01136ACA392B40EC54EE528922BAFDEDC1B49C9A8B5C8FDD1644EA4F0308E680626920F8787F3A2D87054D52B03BB15B5549919B723F8F038AA8B2FDB47A6C0AFAF8B6D86F0320690577382A9016BB2A88EEAE79844CD5336DEB92DB99C09C3655B8BDB6B456C6196AFC41AA4B23C6DA5983CF8F7894D4165CA3B88EE193D2B949CF93092867A9B2E56D965B3A9D1080C808D443B9132F447056E9BB81080338F5C14A1479DF41BC88C1B52D7652C6585972FD2FCC57F36BF20AD97E5AACA2CE600A8CC269DEB785F98850E502937CB4E99A38DA620F4D26E37E3DCF087E703AB9EE10797BDC3261FCB1602C5668423615CCFFD6E6772AA0CD706BDE6D9A62DE2168632DB44D231D99801713CA7BD9E9467C213DC68502D06E3C2149FB4887A65352F7094A7815AC7CF56093B74672487E3453F9C19D09C4EFBE6AB3FC90E767B41491DE2E91433C07D6F92976E6D1DFAD1C61436A3C31A616990A49F89DE061B7FC920D35462BA7900B90C5C6AF97E762C6238537F50D33FB84E052EA5E5104D1CA8623A4F2503B7CA58AD7510DC74247A08C17BCE6D9DB181714FE60A9A9AED79F8859B61F3B0AC08D5CC839B4F15AF969C7D7967661E268030B976795DFEBA021EB1F16F5CEF59E8D7B342D2BD7DFB1D0A9367813558A7555E28D3CB5A246D3C76BEEA33943B3DE1C05CC4F7494069244866EFB16992804CC6B5B2F26A3486AA65CAAEC4D46C3684782937F73C0CE60D707E2CD03A921B15935CD86B665B81929B8253A67F8FB7FFC60C812C5554B30D08E8E8116F0D7BD7B49B1996004283399187434B950AA991DBEC6EB015C338368921F0FA812AB1F77FAC8220E821328EEBA191B8C7979963D3FFEA6EC422722AD7BAAED31A814725D3DC8661E2505B63328D7029995D9578391ED9DF56C4C560B608AA1E6791D2071A71551FD5A7FEAB57D76DBBCE1900AD280BD45142F4E31018025059B37B9B0E323D4213536A248447D64FE1A9A708F62BC44EB223731F526C62B2B33793932E0F98AB6BF40C936299941B25EF6D17E7CF0EE93ACDA28BB9350C8E4D639DDF2A6BB20A33CD288FD3E490D1D2564A711E0159960B637A144785101C0D34E3BC424578F08E8F2678F1DAE4E7737AEE1E9C562ACBE5DE4251F1107410EE9A126B92A6A26C195A2A0DBEE899596A7EADFB8EA923FC00D0E758467E285FBD30B22260673560D84D6C661E66B92901C0DC1F0268B8F4A22A344D0D4743156B89BFD835001D5EA188E5753D6C1309A51752B9BBE8B76987462D19DF1DD6A3E9D8942EF465A048DD8E6FDE1D8BFD50630E9814426A0F5197910B4BA35AA7D44EE6D32A51348753B6F3E8D2DB898A49BE7DA42F18A05E0915D5F6F37BD2503584EAC5A93E238B3F5B36745B6F93F30A57718D398695D23D7CC5E9D22031233903E34CFFDB36681459E47687EB374F5AE62506D898F883C595A0A46B58A3C1BCF1F82CD9941FDCBA8FE59227895FBD52F3ACE051C58310EE916F3D61662A363AB09C566DC911940C21A07608F17DE0FED04C347B46DAB497345296E8A15B845771D2C43572AFFE8236B95DB96C2A66F9BFF1852A978B9A7808D5F819036705DAD48912FFAF8AE1C54DD5F34625D08B47D1B0AA0B58969881EDC559A58FEBC604477480D706C72ADF86"));
                PtgCustomController ptgCustomController = getConfig().getPtgCustomController();
                int fdRule = getConfig().getFdRule();
                if (ptgCustomController == null || !ptgCustomController.isAllowSDKInstallList()) {
                    z = false;
                }
                if (fdRule <= 0 && !z) {
                    com.fancy.adsdk.lib.utils._d._b(new _oz());
                    return;
                }
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    com.fancy.adsdk.lib.utils._d._b(new _p0(false));
                } else {
                    _p2._b(_p2._a(false));
                }
            } catch (Exception e) {
                Logger.e(_ie._a("ru_err: ").append(e.getMessage()).toString());
            }
        }
    }

    public static boolean isInitialized() {
        return isInitialized.get();
    }

    public static void mergeCustomController() {
        if (tempPtgCustomController != null) {
            getConfig().setPtgCustomController(tempPtgCustomController);
        }
    }

    public static void setPersonalizedState(boolean z) {
        getConfig().setPersonalizedState(z);
    }

    public static void setProgrammaticRecommendState(boolean z) {
        getConfig().setProgrammaticRecommendState(z);
    }

    public static void setPtgCustomController(PtgCustomController ptgCustomController) {
        tempPtgCustomController = ptgCustomController;
    }

    public static void setSensorStatus(boolean z) {
        getConfig().setSensorStatus(z);
    }
}
