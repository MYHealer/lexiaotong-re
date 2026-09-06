package com.hihonor.dlinstall.ability;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.hihonor.dlinstall.ability.base.AbstractAbility;
import com.hihonor.dlinstall.ability.base.ResponseData;
import com.hihonor.dlinstall.clone.AppInfo;
import com.hihonor.dlinstall.ipc.m;
import com.hihonor.dlinstall.ipc.p;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class GetDeviceEssentialListAbility extends AbstractAbility<Integer, List<AppInfo>> {
    public GetDeviceEssentialListAbility(Context context, Integer num) {
        super(context, num, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.hihonor.dlinstall.ability.base.AbstractAbility
    public Bundle buildRequestBundle() {
        Bundle bundle = new Bundle();
        bundle.putLong("key_sdk_version", 14L);
        bundle.putInt("key_request_count", ((Integer) this.params).intValue());
        bundle.putBinder("key_listener", new p.a() { // from class: com.hihonor.dlinstall.ability.GetDeviceEssentialListAbility.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.hihonor.dlinstall.ipc.p
            public void onQueryResult(Bundle bundle2) throws RemoteException {
                m.c cVar;
                R responseData;
                int i = bundle2.getInt("key_error_code");
                String string = bundle2.getString("key_error_message");
                int i2 = bundle2.getInt("key_market_mode", 0);
                Serializable serializable = bundle2.getSerializable("key_response_data");
                if (serializable instanceof List) {
                    cVar = GetDeviceEssentialListAbility.this.mResult;
                    responseData = new ResponseData((List) serializable, i2, i, string);
                } else {
                    cVar = GetDeviceEssentialListAbility.this.mResult;
                    responseData = new ResponseData(null, i2, i, string);
                }
                cVar.f3605a = responseData;
                cVar.b.run();
            }
        });
        return bundle;
    }

    @Override // com.hihonor.dlinstall.ability.base.AbstractAbility
    public int commandFlag() {
        return 11;
    }

    @Override // com.hihonor.dlinstall.ability.base.AbstractAbility
    public String commandStr() {
        return "DeviceEssentialList";
    }
}
