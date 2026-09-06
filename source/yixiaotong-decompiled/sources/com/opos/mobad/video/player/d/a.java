package com.opos.mobad.video.player.d;

import android.app.Activity;
import android.os.Bundle;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {
    public static com.opos.mobad.template.a a(Activity activity, AdItemData adItemData, MaterialData materialData, Bundle bundle, com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        com.opos.mobad.template.a aVarA = com.opos.mobad.ui.c.b.a().a(activity, adItemData, materialData, bundle, interfaceC1003a);
        if (aVarA != null) {
            return aVarA instanceof com.opos.mobad.ui.c.a ? aVarA : new b(activity, adItemData, aVarA);
        }
        return null;
    }
}
