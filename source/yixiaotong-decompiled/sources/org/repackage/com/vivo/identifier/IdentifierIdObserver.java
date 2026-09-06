package org.repackage.com.vivo.identifier;

import android.database.ContentObserver;
import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class IdentifierIdObserver extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9732a = "VMS_IDLG_SDK_Observer";
    private String b;
    private int c;
    private IdentifierIdClient d;

    public IdentifierIdObserver(IdentifierIdClient identifierIdClient, int i, String str) {
        super(null);
        this.d = identifierIdClient;
        this.c = i;
        this.b = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        IdentifierIdClient identifierIdClient = this.d;
        if (identifierIdClient != null) {
            identifierIdClient.a(this.c, this.b);
        } else {
            Log.e(f9732a, "mIdentifierIdClient is null");
        }
    }
}
