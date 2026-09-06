package com.hihonor.dlinstall.ability;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.hihonor.dlinstall.ability.base.AbstractAbility;
import com.hihonor.dlinstall.ability.base.ResponseData;
import com.hihonor.dlinstall.clone.WishInfo;
import com.hihonor.dlinstall.clone.WishVo;
import com.hihonor.dlinstall.ipc.m;
import com.hihonor.dlinstall.ipc.p;
import com.hihonor.dlinstall.page.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class AddWishAbility extends AbstractAbility<List<String>, WishInfo> {
    private String callerPkgName;
    private boolean isInstall;

    public AddWishAbility(Context context, List<String> list, boolean z) {
        super(context, list, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        this.callerPkgName = context.getPackageName();
        this.isInstall = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [R, com.hihonor.dlinstall.ability.base.ResponseData] */
    /* JADX WARN: Type inference failed for: r3v3, types: [R, com.hihonor.dlinstall.ability.base.ResponseData] */
    /* JADX WARN: Type inference failed for: r3v4, types: [R, com.hihonor.dlinstall.ability.base.ResponseData] */
    public void handleAddWishResult(Bundle bundle) {
        if (bundle == null) {
            String str = logTag() + " : data = null";
            a.c(logTag(), str);
            WishInfo wishInfo = new WishInfo(-1, str, new ArrayList());
            m.c<ResponseData<R>> cVar = this.mResult;
            cVar.f3605a = new ResponseData(wishInfo, -1, str);
            cVar.b.run();
            return;
        }
        ArrayList<Bundle> parcelableArrayList = bundle.getParcelableArrayList("key_add_wish");
        if (parcelableArrayList == null || parcelableArrayList.size() == 0) {
            String str2 = logTag() + " : statusBundleList = null";
            a.c(logTag(), str2);
            WishInfo wishInfo2 = new WishInfo(-1, str2, new ArrayList());
            m.c<ResponseData<R>> cVar2 = this.mResult;
            cVar2.f3605a = new ResponseData(wishInfo2, -1, str2);
            cVar2.b.run();
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i = bundle.getInt("key_wish_Interface_request_code");
        String string = bundle.getString("key_wish_add_list_msg");
        for (Bundle bundle2 : parcelableArrayList) {
            String string2 = bundle2.getString("key_wish_apk_name_list");
            if (!TextUtils.isEmpty(string2)) {
                arrayList.add(new WishVo(string2, bundle2.getInt("key_wish_code")));
            }
        }
        WishInfo wishInfo3 = new WishInfo(i, string, arrayList);
        m.c<ResponseData<R>> cVar3 = this.mResult;
        cVar3.f3605a = new ResponseData(wishInfo3, -1, string);
        cVar3.b.run();
    }

    @Override // com.hihonor.dlinstall.ability.base.AbstractAbility
    public Bundle buildRequestBundle() {
        Bundle bundle = new Bundle();
        bundle.putLong("key_sdk_version", 14L);
        bundle.putStringArrayList("key_wish_apk_name", new ArrayList<>((Collection) this.params));
        bundle.putBoolean("key_is_install", this.isInstall);
        bundle.putString("key_caller_package_name", this.callerPkgName);
        bundle.putBinder("key_listener", new p.a() { // from class: com.hihonor.dlinstall.ability.AddWishAbility.1
            @Override // com.hihonor.dlinstall.ipc.p
            public void onQueryResult(Bundle bundle2) {
                AddWishAbility.this.handleAddWishResult(bundle2);
            }
        });
        return bundle;
    }

    @Override // com.hihonor.dlinstall.ability.base.AbstractAbility
    public int commandFlag() {
        return 7;
    }

    @Override // com.hihonor.dlinstall.ability.base.AbstractAbility
    public String commandStr() {
        return "AddWish";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [R, com.hihonor.dlinstall.ability.base.ResponseData] */
    @Override // com.hihonor.dlinstall.ability.base.AbstractAbility
    public boolean onPreExecute() {
        boolean z;
        String str;
        boolean z2 = false;
        if (this.mWrfContext.get() == null) {
            str = tag() + ": context is null";
            z = false;
        } else {
            z = true;
            str = null;
        }
        if (z && m.c().b(this.mWrfContext.get())) {
            str = tag() + ": version mismatch";
        } else {
            z2 = z;
        }
        if (!TextUtils.isEmpty(str)) {
            ?? responseData = new ResponseData(new WishInfo(-1, str, new ArrayList()), -1, str);
            m.c<ResponseData<R>> cVar = this.mResult;
            cVar.f3605a = responseData;
            cVar.b.run();
            a.b(logTag(), str);
        }
        return z2;
    }
}
