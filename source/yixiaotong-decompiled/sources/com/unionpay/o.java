package com.unionpay;

import android.content.DialogInterface;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class o implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UPPayWapActivity f9329a;

    o(UPPayWapActivity uPPayWapActivity) {
        this.f9329a = uPPayWapActivity;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.unionpay.UPPayWapActivity.a(com.unionpay.UPPayWapActivity, java.lang.String, java.lang.String):void
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:80)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:50)
        Caused by: java.lang.ArrayIndexOutOfBoundsException: Index 34 out of bounds for length 33
        	at java.base/java.util.ArrayList.add(ArrayList.java:455)
        	at java.base/java.util.ArrayList.add(ArrayList.java:467)
        	at jadx.core.utils.ListUtils.safeReplace(ListUtils.java:150)
        	at jadx.core.dex.visitors.InlineMethods.replaceClsUsage(InlineMethods.java:193)
        	at jadx.core.dex.visitors.InlineMethods.lambda$updateUsageInfo$0(InlineMethods.java:173)
        	at jadx.core.dex.nodes.InsnNode.visitInsns(InsnNode.java:301)
        	at jadx.core.dex.visitors.InlineMethods.updateUsageInfo(InlineMethods.java:164)
        	at jadx.core.dex.visitors.InlineMethods.inlineMethod(InlineMethods.java:93)
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:78)
        	... 1 more
        */
    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(android.content.DialogInterface r2, int r3) {
        /*
            r1 = this;
            com.unionpay.UPPayWapActivity r2 = r1.f9329a
            java.lang.String r3 = "cancel"
            r0 = 0
            com.unionpay.UPPayWapActivity.a(r2, r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unionpay.o.onClick(android.content.DialogInterface, int):void");
    }
}
