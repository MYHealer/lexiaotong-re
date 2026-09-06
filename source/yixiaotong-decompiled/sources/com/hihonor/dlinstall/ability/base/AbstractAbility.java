package com.hihonor.dlinstall.ability.base;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.hihonor.dlinstall.ipc.m;
import com.hihonor.dlinstall.ipc.o;
import com.hihonor.dlinstall.page.a;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public abstract class AbstractAbility<T, R> extends m.b<T> implements m.a<T> {
    public m.c<ResponseData<R>> mResult;
    public WeakReference<Context> mWrfContext;

    public AbstractAbility(Context context, T t, long j) {
        super(t, j);
        this.mResult = new m.c<>();
        this.mWrfContext = new WeakReference<>(context);
        this.action = initAction();
        this.command = tag();
    }

    private void executeAbility(o oVar, T t) {
        Bundle bundleBuildRequestBundle;
        if (!onPreExecute() || (bundleBuildRequestBundle = buildRequestBundle()) == null) {
            return;
        }
        try {
            Context context = this.mWrfContext.get();
            if (context != null) {
                bundleBuildRequestBundle.putString("key_caller_package_name", context.getPackageName());
            }
            bundleBuildRequestBundle.putLong("key_sdk_version", 14L);
            oVar.a(commandFlag(), bundleBuildRequestBundle);
        } catch (RemoteException e) {
            a.b(logTag(), "onSuccessAction exception, e is: " + e.getMessage());
        }
    }

    private m.a<T> initAction() {
        return new m.a<T>() { // from class: com.hihonor.dlinstall.ability.base.AbstractAbility.1
            @Override // com.hihonor.dlinstall.ipc.m.a
            public void onErrorAction(T t, int i, String str) {
                AbstractAbility.this.onErrorAction(t, i, str);
            }

            @Override // com.hihonor.dlinstall.ipc.m.a
            public void onSuccessAction(o oVar, T t) {
                AbstractAbility.this.onSuccessAction(oVar, t);
            }

            @Override // com.hihonor.dlinstall.ipc.m.a
            public void onTimeoutAction(T t) {
                AbstractAbility.this.onTimeoutAction(t);
            }
        };
    }

    public abstract Bundle buildRequestBundle();

    public abstract int commandFlag();

    public String commandStr() {
        return "";
    }

    public ResponseData<R> getExecuteAbilityResponse() {
        try {
            return this.mResult.a(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            a.b(logTag(), "getExecuteAbilityResult exception, message:" + e.getMessage());
            return null;
        }
    }

    public R getExecuteAbilityResult() {
        try {
            return this.mResult.a(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).data;
        } catch (Exception e) {
            a.b(logTag(), "getExecuteAbilityResult exception, message:" + e.getMessage());
            return null;
        }
    }

    public String logTag() {
        return "[" + tag() + "]";
    }

    @Override // com.hihonor.dlinstall.ipc.m.a
    @Deprecated
    public void onErrorAction(T t, int i, String str) {
        R r = (R) new ResponseData(null, i, str);
        m.c<ResponseData<R>> cVar = this.mResult;
        cVar.f3605a = r;
        cVar.b.run();
        a.b(logTag(), "onErrorAction: data is " + t + ",code is " + i + ",message is " + str);
    }

    public boolean onPreExecute() {
        return true;
    }

    @Override // com.hihonor.dlinstall.ipc.m.a
    @Deprecated
    public void onSuccessAction(o oVar, T t) {
        executeAbility(oVar, t);
    }

    @Override // com.hihonor.dlinstall.ipc.m.a
    @Deprecated
    public void onTimeoutAction(T t) {
        String str = "process " + tag() + " timeout";
        R r = (R) new ResponseData(null, -1, str);
        m.c<ResponseData<R>> cVar = this.mResult;
        cVar.f3605a = r;
        cVar.b.run();
        a.b(logTag(), str);
    }

    public String tag() {
        String strCommandStr = commandStr();
        return TextUtils.isEmpty(strCommandStr) ? String.valueOf(commandFlag()) : strCommandStr;
    }
}
