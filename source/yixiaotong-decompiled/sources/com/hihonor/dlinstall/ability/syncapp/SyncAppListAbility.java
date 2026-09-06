package com.hihonor.dlinstall.ability.syncapp;

import android.content.Context;
import android.os.Bundle;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.hihonor.dlinstall.ability.base.AbstractAbility;
import com.hihonor.dlinstall.ability.base.ResponseData;
import com.hihonor.dlinstall.ipc.m;
import com.hihonor.dlinstall.ipc.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class SyncAppListAbility extends AbstractAbility<List<SyncAppInfo>, Boolean> {
    public SyncAppListAbility(Context context, List<SyncAppInfo> list) {
        super(context, list, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    @Override // com.hihonor.dlinstall.ability.base.AbstractAbility
    public Bundle buildRequestBundle() {
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_package_name_list", new ArrayList((Collection) this.params));
        bundle.putBinder("key_listener", new p.a() { // from class: com.hihonor.dlinstall.ability.syncapp.SyncAppListAbility.1
            /* JADX WARN: Type inference failed for: r2v0, types: [R, com.hihonor.dlinstall.ability.base.ResponseData] */
            @Override // com.hihonor.dlinstall.ipc.p
            public void onQueryResult(Bundle bundle2) {
                int i = bundle2.getInt("key_error_code");
                String string = bundle2.getString("key_error_message");
                m.c cVar = SyncAppListAbility.this.mResult;
                cVar.f3605a = new ResponseData(Boolean.valueOf(i == 0), i, string);
                cVar.b.run();
            }
        });
        return bundle;
    }

    @Override // com.hihonor.dlinstall.ability.base.AbstractAbility
    public int commandFlag() {
        return 8;
    }
}
