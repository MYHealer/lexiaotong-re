package org.videolan.libvlc;

import android.os.Handler;
import android.os.Looper;
import com.google.common.base.Ascii;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class Dialog {
    public static final int TYPE_ERROR = 0;
    public static final int TYPE_LOGIN = 1;
    public static final int TYPE_PROGRESS = 3;
    public static final int TYPE_QUESTION = 2;
    private static Callbacks sCallbacks;
    private static Handler sHandler;
    private Object mContext;
    public String mText;
    private final String mTitle;
    public final int mType;

    public interface Callbacks {
        void onCanceled(Dialog dialog);

        void onDisplay(ErrorMessage errorMessage);

        void onDisplay(LoginDialog loginDialog);

        void onDisplay(ProgressDialog progressDialog);

        void onDisplay(QuestionDialog questionDialog);

        void onProgressUpdate(ProgressDialog progressDialog);
    }

    public static class ErrorMessage extends Dialog {
        private ErrorMessage(String str, String str2) {
            super(0, str, str2);
        }
    }

    public static abstract class IdDialog extends Dialog {
        public long mId;

        public IdDialog(long j, int i, String str, String str2) {
            super(i, str, str2);
            this.mId = j;
        }

        private native void nativeDismiss(long j);

        @Override // org.videolan.libvlc.Dialog
        public void dismiss() {
            long j = this.mId;
            if (j != 0) {
                nativeDismiss(j);
                this.mId = 0L;
            }
        }
    }

    public static class LoginDialog extends IdDialog {
        private final boolean mAskStore;
        private final String mDefaultUsername;

        private LoginDialog(long j, String str, String str2, String str3, boolean z) {
            super(j, 1, str, str2);
            this.mDefaultUsername = str3;
            this.mAskStore = z;
        }

        private native void nativePostLogin(long j, String str, String str2, boolean z);

        public boolean asksStore() {
            return this.mAskStore;
        }

        @Override // org.videolan.libvlc.Dialog.IdDialog, org.videolan.libvlc.Dialog
        public /* bridge */ /* synthetic */ void dismiss() {
            super.dismiss();
        }

        public String getDefaultUsername() {
            return this.mDefaultUsername;
        }

        public void postLogin(String str, String str2, boolean z) {
            long j = this.mId;
            if (j != 0) {
                nativePostLogin(j, str, str2, z);
                this.mId = 0L;
            }
        }
    }

    public static class ProgressDialog extends IdDialog {
        private final String mCancelText;
        private final boolean mIndeterminate;
        private float mPosition;

        private ProgressDialog(long j, String str, String str2, boolean z, float f, String str3) {
            super(j, 3, str, str2);
            this.mIndeterminate = z;
            this.mPosition = f;
            this.mCancelText = str3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void update(float f, String str) {
            this.mPosition = f;
            this.mText = str;
        }

        @Override // org.videolan.libvlc.Dialog.IdDialog, org.videolan.libvlc.Dialog
        public /* bridge */ /* synthetic */ void dismiss() {
            super.dismiss();
        }

        public String getCancelText() {
            return this.mCancelText;
        }

        public float getPosition() {
            return this.mPosition;
        }

        public boolean isCancelable() {
            return this.mCancelText != null;
        }

        public boolean isIndeterminate() {
            return this.mIndeterminate;
        }
    }

    public static class QuestionDialog extends IdDialog {
        public static final int TYPE_ERROR = 2;
        public static final int TYPE_NORMAL = 0;
        public static final int TYPE_WARNING = 1;
        private final String mAction1Text;
        private final String mAction2Text;
        private final String mCancelText;
        private final int mQuestionType;

        private QuestionDialog(long j, String str, String str2, int i, String str3, String str4, String str5) {
            super(j, 2, str, str2);
            this.mQuestionType = i;
            this.mCancelText = str3;
            this.mAction1Text = str4;
            this.mAction2Text = str5;
        }

        private native void nativePostAction(long j, int i);

        @Override // org.videolan.libvlc.Dialog.IdDialog, org.videolan.libvlc.Dialog
        public /* bridge */ /* synthetic */ void dismiss() {
            super.dismiss();
        }

        public String getAction1Text() {
            return this.mAction1Text;
        }

        public String getAction2Text() {
            return this.mAction2Text;
        }

        public String getCancelText() {
            return this.mCancelText;
        }

        public int getQuestionType() {
            return this.mQuestionType;
        }

        public void postAction(int i) {
            long j = this.mId;
            if (j != 0) {
                nativePostAction(j, i);
                this.mId = 0L;
            }
        }
    }

    public Dialog(int i, String str, String str2) {
        this.mType = i;
        this.mTitle = str;
        this.mText = str2;
    }

    private static void cancelFromNative(Dialog dialog) {
        sHandler.post(new Runnable() { // from class: org.videolan.libvlc.Dialog.5
            @Override // java.lang.Runnable
            public void run() {
                Dialog dialog2 = Dialog.this;
                if (dialog2 instanceof IdDialog) {
                    ((IdDialog) dialog2).dismiss();
                }
                if (Dialog.sCallbacks == null || Dialog.this == null) {
                    return;
                }
                Dialog.sCallbacks.onCanceled(Dialog.this);
            }
        });
    }

    private static void displayErrorFromNative(String str, String str2) {
        final ErrorMessage errorMessage = new ErrorMessage(str, str2);
        sHandler.post(new Runnable() { // from class: org.videolan.libvlc.Dialog.1
            @Override // java.lang.Runnable
            public void run() {
                if (Dialog.sCallbacks != null) {
                    Dialog.sCallbacks.onDisplay(errorMessage);
                }
            }
        });
    }

    private static Dialog displayLoginFromNative(long j, String str, String str2, String str3, boolean z) {
        final LoginDialog loginDialog = new LoginDialog(j, str, str2, str3, z);
        sHandler.post(new Runnable() { // from class: org.videolan.libvlc.Dialog.2
            @Override // java.lang.Runnable
            public void run() {
                if (Dialog.sCallbacks != null) {
                    Dialog.sCallbacks.onDisplay(loginDialog);
                }
            }
        });
        return loginDialog;
    }

    private static Dialog displayProgressFromNative(long j, String str, String str2, boolean z, float f, String str3) {
        final ProgressDialog progressDialog = new ProgressDialog(j, str, str2, z, f, str3);
        sHandler.post(new Runnable() { // from class: org.videolan.libvlc.Dialog.4
            @Override // java.lang.Runnable
            public void run() {
                if (Dialog.sCallbacks != null) {
                    Dialog.sCallbacks.onDisplay(progressDialog);
                }
            }
        });
        return progressDialog;
    }

    private static Dialog displayQuestionFromNative(long j, String str, String str2, int i, String str3, String str4, String str5) {
        final QuestionDialog questionDialog = new QuestionDialog(j, str, str2, i, str3, str4, str5);
        sHandler.post(new Runnable() { // from class: org.videolan.libvlc.Dialog.3
            @Override // java.lang.Runnable
            public void run() {
                if (Dialog.sCallbacks != null) {
                    Dialog.sCallbacks.onDisplay(questionDialog);
                }
            }
        });
        return questionDialog;
    }

    private static native void nativeSetCallbacks(LibVLC libVLC, boolean z);

    public static void setCallbacks(LibVLC libVLC, Callbacks callbacks) {
        if (callbacks != null && sHandler == null) {
            sHandler = new Handler(Looper.getMainLooper());
        }
        sCallbacks = callbacks;
        nativeSetCallbacks(libVLC, callbacks != null);
    }

    private static void updateProgressFromNative(Dialog dialog, final float f, final String str) {
        sHandler.post(new Runnable() { // from class: org.videolan.libvlc.Dialog.6
            @Override // java.lang.Runnable
            public void run() {
                if (Dialog.this.getType() != 3) {
                    throw new IllegalArgumentException(s.d(new byte[]{86, 90, 80, 85, 12, 87, 65, 13, Ascii.NAK, 66, 95, 10, 70, 19, 80, Ascii.EM, 19, 66, 14, 3, Ascii.DC4, 7, 66, Ascii.SYN, Ascii.DC2, 87, 88, 88, 15, 95, 6}, "2319c0"));
                }
                ProgressDialog progressDialog = (ProgressDialog) Dialog.this;
                progressDialog.update(f, str);
                if (Dialog.sCallbacks != null) {
                    Dialog.sCallbacks.onProgressUpdate(progressDialog);
                }
            }
        });
    }

    public void dismiss() {
    }

    public Object getContext() {
        return this.mContext;
    }

    public String getText() {
        return this.mText;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public int getType() {
        return this.mType;
    }

    public void setContext(Object obj) {
        this.mContext = obj;
    }
}
