package com.jg.ids.meizu;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
public final class c extends com.jg.ids.a implements b {
    public c(Context context) {
        super(context, "meizu_thread");
        a.a().a(this);
    }

    @Override // com.jg.ids.a
    protected final void a(Message message) {
        if (message != null) {
            try {
                int i = message.getData().getInt("type", -1);
                String strD = "";
                switch (i) {
                    case 0:
                        strD = a.a().c(this.f4599a);
                        break;
                    case 1:
                        strD = a.a().d(this.f4599a);
                        break;
                    case 2:
                        strD = a.a().b(this.f4599a);
                        break;
                }
                a(i, strD);
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.jg.ids.a
    protected final void b() {
        b(2);
        b(0);
        b(1);
    }

    private void b(int i) {
        try {
            Message messageA = a();
            messageA.what = 0;
            Bundle bundle = new Bundle();
            bundle.putInt("type", i);
            messageA.setData(bundle);
            b(messageA);
        } catch (Throwable th) {
        }
    }

    @Override // com.jg.ids.f, com.jg.ids.i
    public final boolean d() {
        return a.a().a(this.f4599a);
    }

    @Override // com.jg.ids.meizu.b
    public final void a(int i) {
        switch (i) {
            case 0:
                b(0);
                break;
            case 1:
                b(1);
                break;
            case 2:
                b(2);
                break;
        }
    }
}
