package com.jg.ids.k;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.jg.ids.IdsHelper;
import com.ubixnow.ooooo.oOOOoo00;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
public final class a extends com.jg.ids.a {
    private String b;
    private ContentObserver c;
    private ContentObserver d;
    private ContentObserver e;

    public a(Context context, String str) {
        super(context, "vivo_thread");
        this.c = null;
        this.d = null;
        this.e = null;
        this.b = str;
        try {
            this.c = new b(this, null, str, 0);
            this.d = new b(this, null, str, 1);
            this.e = new b(this, null, str, 2);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, this.c);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), true, this.d);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str), true, this.e);
        } catch (Throwable th) {
        }
    }

    @Override // com.jg.ids.f, com.jg.ids.i
    public final String a(Context context) {
        String strA = super.a(context);
        if (TextUtils.isEmpty(strA)) {
            b(1, this.b);
        }
        return strA;
    }

    @Override // com.jg.ids.f, com.jg.ids.i
    public final String b(Context context) {
        String string;
        try {
            Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            if (cursorQuery == null) {
                return "";
            }
            if (!cursorQuery.moveToNext()) {
                string = "";
            } else {
                string = cursorQuery.getString(cursorQuery.getColumnIndex(oOOOoo00.OooOo0o));
            }
            try {
                cursorQuery.close();
                return string;
            } catch (Throwable th) {
                return string;
            }
        } catch (Throwable th2) {
            return "";
        }
    }

    @Override // com.jg.ids.f, com.jg.ids.i
    public final String c(Context context) {
        String strC = super.c(context);
        if (TextUtils.isEmpty(strC)) {
            b(2, this.b);
        }
        return strC;
    }

    @Override // com.jg.ids.a
    protected final void b() {
        b(1, this.b);
        b(2, this.b);
        b(0, this.b);
    }

    @Override // com.jg.ids.a
    protected final void a(Message message) {
        if (message != null) {
            try {
                if (message.what == 0) {
                    int i = message.getData().getInt("type", -1);
                    a(i, a(IdsHelper.CONTEXT, i, message.getData().getString("appid", "")));
                }
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str) {
        try {
            Message messageA = a();
            messageA.what = 0;
            Bundle bundle = new Bundle();
            bundle.putInt("type", i);
            bundle.putString("appid", str);
            messageA.setData(bundle);
            b(messageA);
        } catch (Throwable th) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0078  */
    private static String a(Context context, int i, String str) throws Throwable {
        Cursor cursor;
        Uri uri;
        String string;
        Cursor cursor2 = null;
        try {
            switch (i) {
                case 0:
                    uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
                    break;
                case 1:
                    uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str);
                    break;
                case 2:
                    uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str);
                    break;
                default:
                    uri = null;
                    break;
            }
            if (uri == null) {
                return "";
            }
            Cursor cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToNext()) {
                        string = cursorQuery.getString(cursorQuery.getColumnIndex(oOOOoo00.OooOo0o));
                    } else {
                        string = "";
                    }
                } catch (Throwable th) {
                    cursor = cursorQuery;
                }
            } else {
                string = "";
            }
            if (cursorQuery == null) {
                return string;
            }
            cursorQuery.close();
            return string;
        } catch (Throwable th2) {
            th = th2;
        }
        if (cursor == null) {
            return "";
        }
        cursor.close();
        return "";
    }
}
