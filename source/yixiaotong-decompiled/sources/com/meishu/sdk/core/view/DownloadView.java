package com.meishu.sdk.core.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.meishu.sdk.R;
import com.meishu.sdk.activity.MeishuDownloadDetailActivity;
import com.meishu.sdk.activity.MeishuWebviewActivity;
import com.meishu.sdk.core.ad.BaseAdSlot;
import com.meishu.sdk.core.bquery.i;
import com.meishu.sdk.core.domain.LayoutBean;
import com.meishu.sdk.core.safe.a;
import com.meishu.sdk.core.utils.DownloadDialogBean;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.platform.ms.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class DownloadView {
    public static final String CLICK_DOWNLOAD_INFO_TYPE_DESCRIBE = "describe";
    public static final String CLICK_DOWNLOAD_INFO_TYPE_PERMISSION = "permission";
    public static final String CLICK_DOWNLOAD_INFO_TYPE_PRIVACY = "privacy";
    private static final String TAG = "DownloadView";

    public static class SafeLinkMovementMethod extends LinkMovementMethod {
        private static final SafeLinkMovementMethod INSTANCE = new SafeLinkMovementMethod();

        private SafeLinkMovementMethod() {
        }

        public static MovementMethod getInstance() {
            return INSTANCE;
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 1 || actionMasked == 0) {
                int scrollX = textView.getScrollX() + (((int) motionEvent.getX()) - textView.getTotalPaddingLeft());
                int scrollY = textView.getScrollY() + (((int) motionEvent.getY()) - textView.getTotalPaddingTop());
                Layout layout = textView.getLayout();
                if (scrollX > layout.getLineRight(layout.getLineForVertical(scrollY))) {
                    Selection.removeSelection(spannable);
                    return false;
                }
            }
            return super.onTouchEvent(textView, spannable, motionEvent);
        }
    }

    public static void bindClickableDownloadInfo(final TextView textView, final DownloadDialogBean downloadDialogBean) {
        if (textView == null || downloadDialogBean == null) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        final Context context = textView.getContext();
        if (!TextUtils.isEmpty(downloadDialogBean.getApp_name())) {
            spannableStringBuilder.append((CharSequence) "应用名称：").append((CharSequence) downloadDialogBean.getApp_name()).append((CharSequence) " |");
        }
        if (!TextUtils.isEmpty(downloadDialogBean.getApp_ver())) {
            spannableStringBuilder.append((CharSequence) " 应用版本：").append((CharSequence) downloadDialogBean.getApp_ver()).append((CharSequence) " |");
        }
        if (!TextUtils.isEmpty(downloadDialogBean.getApp_size())) {
            spannableStringBuilder.append((CharSequence) " 应用大小：").append((CharSequence) downloadDialogBean.getApp_size()).append((CharSequence) " |");
        }
        if (!TextUtils.isEmpty(downloadDialogBean.getDeveloper())) {
            spannableStringBuilder.append((CharSequence) " 开发者：").append((CharSequence) downloadDialogBean.getDeveloper()).append((CharSequence) " |");
        }
        if (!TextUtils.isEmpty(downloadDialogBean.getApp_permission_url()) || downloadDialogBean.getApp_permission() != null) {
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) " 权限详情").append((CharSequence) " |");
            spannableStringBuilder.setSpan(new a() { // from class: com.meishu.sdk.core.view.DownloadView.1
                @Override // com.meishu.sdk.core.safe.a
                public void safeOnClick(View view) {
                    DownloadView.openByType(downloadDialogBean, context, DownloadView.CLICK_DOWNLOAD_INFO_TYPE_PERMISSION);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(textView.getCurrentTextColor());
                    textPaint.setUnderlineText(true);
                }
            }, length, length + 5, 33);
        }
        if (!TextUtils.isEmpty(downloadDialogBean.getApp_private_agreement())) {
            int length2 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) " 隐私协议").append((CharSequence) " |");
            spannableStringBuilder.setSpan(new a() { // from class: com.meishu.sdk.core.view.DownloadView.2
                @Override // com.meishu.sdk.core.safe.a
                public void safeOnClick(View view) {
                    DownloadView.openByType(downloadDialogBean, context, DownloadView.CLICK_DOWNLOAD_INFO_TYPE_PRIVACY);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(textView.getCurrentTextColor());
                    textPaint.setUnderlineText(true);
                }
            }, length2, length2 + 5, 33);
        }
        if (!TextUtils.isEmpty(downloadDialogBean.getApp_intor_url()) || !TextUtils.isEmpty(downloadDialogBean.getApp_intro())) {
            int length3 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) " 功能介绍");
            spannableStringBuilder.setSpan(new a() { // from class: com.meishu.sdk.core.view.DownloadView.3
                @Override // com.meishu.sdk.core.safe.a
                public void safeOnClick(View view) {
                    DownloadView.openByType(downloadDialogBean, context, DownloadView.CLICK_DOWNLOAD_INFO_TYPE_DESCRIBE);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(textView.getCurrentTextColor());
                    textPaint.setUnderlineText(true);
                }
            }, length3, length3 + 5, 33);
        }
        if (TextUtils.isEmpty(spannableStringBuilder)) {
            textView.setVisibility(8);
        }
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(SafeLinkMovementMethod.getInstance());
    }

    public static boolean isDownloadStyleAd(BaseAdSlot baseAdSlot) {
        return baseAdSlot != null && baseAdSlot.getInteractionType() == 1;
    }

    public static void openByType(c cVar, String str) {
        if (cVar == null) {
            return;
        }
        try {
            openByType((BaseAdSlot) cVar.a(), cVar.getContext(), str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void openWebView(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Intent intent = new Intent(context, (Class<?>) MeishuWebviewActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra(MeishuWebviewActivity.EXTRA_AD_DURL_KEY, new String[]{str});
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setImage(View view, int i, String str) {
        try {
            ImageView imageView = (ImageView) view.findViewById(i);
            if (imageView == null || TextUtils.isEmpty(str)) {
                return;
            }
            new i(imageView).a(str, false).d(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setText(View view, int i, String str) {
        try {
            TextView textView = (TextView) view.findViewById(i);
            if (textView == null || TextUtils.isEmpty(str)) {
                return;
            }
            i iVar = new i(textView);
            View view2 = iVar.d;
            if (view2 instanceof TextView) {
                ((TextView) view2).setText(str);
            }
            iVar.d(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DownloadDialogBean toBean(BaseAdSlot baseAdSlot) {
        DownloadDialogBean downloadDialogBean = new DownloadDialogBean();
        downloadDialogBean.setApp_name(baseAdSlot.getAppName());
        downloadDialogBean.setApp_ver(baseAdSlot.getApp_ver());
        downloadDialogBean.setApp_size(baseAdSlot.getApp_size());
        downloadDialogBean.setDeveloper(baseAdSlot.getDeveloper());
        downloadDialogBean.setApp_feature(baseAdSlot.getApp_feature());
        downloadDialogBean.setApp_intro(baseAdSlot.getApp_intro());
        downloadDialogBean.setApp_privacy(baseAdSlot.getApp_privacy());
        downloadDialogBean.setPayment_types(baseAdSlot.getPayment_types());
        downloadDialogBean.setApp_permission(baseAdSlot.getApp_permission());
        downloadDialogBean.setApp_permission_url(baseAdSlot.getApp_permission_url());
        downloadDialogBean.setApp_intor_url(baseAdSlot.getApp_intor_url());
        downloadDialogBean.setApp_private_agreement(baseAdSlot.getPrivacy_agreement());
        return downloadDialogBean;
    }

    public void handleDownloadView(View view, BaseAdSlot baseAdSlot) {
        if (baseAdSlot == null || view == null) {
            return;
        }
        try {
            LogUtil.d(TAG, "handleDownloadView: interactionType=" + baseAdSlot.getInteractionType());
            if (baseAdSlot.getInteractionType() == 1) {
                TextView textView = (TextView) view.findViewById(R.id.ms_download_layer_textview);
                textView.setVisibility(0);
                bindClickableDownloadInfo(textView, toBean(baseAdSlot));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void handleFeedDownloadView(final View view, final BaseAdSlot baseAdSlot, LayoutBean.StyleBean styleBean) {
        if (baseAdSlot == null || view == null) {
            return;
        }
        try {
            LogUtil.d(TAG, "handleDownloadView: interactionType=" + baseAdSlot.getInteractionType());
            if (baseAdSlot.getInteractionType() == 1) {
                final TextView textView = (TextView) view.findViewById(R.id.ms_download_layer_textview);
                textView.setVisibility(0);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                if (styleBean != null) {
                    if (styleBean.getType() == 301 || styleBean.getType() == 401) {
                        if (!TextUtils.isEmpty(baseAdSlot.getDeveloper())) {
                            spannableStringBuilder.append((CharSequence) PPSLabelView.Code).append((CharSequence) baseAdSlot.getDeveloper()).append((CharSequence) " |");
                        }
                    } else if (styleBean.getType() == 501) {
                        if (!TextUtils.isEmpty(baseAdSlot.getAppName())) {
                            spannableStringBuilder.append((CharSequence) PPSLabelView.Code).append((CharSequence) baseAdSlot.getAppName()).append((CharSequence) " |");
                        }
                        if (!TextUtils.isEmpty(baseAdSlot.getDeveloper())) {
                            spannableStringBuilder.append((CharSequence) PPSLabelView.Code).append((CharSequence) baseAdSlot.getDeveloper()).append((CharSequence) " |");
                        }
                    }
                }
                if (!TextUtils.isEmpty(baseAdSlot.getApp_permission_url()) || baseAdSlot.getApp_permission() != null) {
                    int length = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) " 权限").append((CharSequence) " |");
                    spannableStringBuilder.setSpan(new a() { // from class: com.meishu.sdk.core.view.DownloadView.4
                        @Override // com.meishu.sdk.core.safe.a
                        public void safeOnClick(View view2) {
                            DownloadView.openByType(baseAdSlot, view.getContext(), DownloadView.CLICK_DOWNLOAD_INFO_TYPE_PERMISSION);
                        }

                        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                        public void updateDrawState(TextPaint textPaint) {
                            textPaint.setColor(textView.getCurrentTextColor());
                            textPaint.setUnderlineText(true);
                        }
                    }, length, length + 3, 33);
                }
                if (!TextUtils.isEmpty(baseAdSlot.getPrivacy_agreement())) {
                    int length2 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) " 隐私").append((CharSequence) " |");
                    spannableStringBuilder.setSpan(new a() { // from class: com.meishu.sdk.core.view.DownloadView.5
                        @Override // com.meishu.sdk.core.safe.a
                        public void safeOnClick(View view2) {
                            DownloadView.openByType(baseAdSlot, view.getContext(), DownloadView.CLICK_DOWNLOAD_INFO_TYPE_PRIVACY);
                        }

                        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                        public void updateDrawState(TextPaint textPaint) {
                            textPaint.setColor(textView.getCurrentTextColor());
                            textPaint.setUnderlineText(true);
                        }
                    }, length2, length2 + 3, 33);
                }
                if (!TextUtils.isEmpty(baseAdSlot.getApp_intor_url()) || !TextUtils.isEmpty(baseAdSlot.getApp_intro())) {
                    int length3 = spannableStringBuilder.length();
                    spannableStringBuilder.append((CharSequence) " 功能");
                    spannableStringBuilder.setSpan(new a() { // from class: com.meishu.sdk.core.view.DownloadView.6
                        @Override // com.meishu.sdk.core.safe.a
                        public void safeOnClick(View view2) {
                            DownloadView.openByType(baseAdSlot, view.getContext(), DownloadView.CLICK_DOWNLOAD_INFO_TYPE_DESCRIBE);
                        }

                        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                        public void updateDrawState(TextPaint textPaint) {
                            textPaint.setColor(textView.getCurrentTextColor());
                            textPaint.setUnderlineText(true);
                        }
                    }, length3, length3 + 3, 33);
                }
                String string = spannableStringBuilder.toString();
                if (TextUtils.isEmpty(string)) {
                    textView.setVisibility(8);
                } else {
                    if (string.endsWith("|")) {
                        spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
                    }
                    if (string.startsWith(PPSLabelView.Code)) {
                        spannableStringBuilder.delete(0, 1);
                    }
                }
                textView.setText(spannableStringBuilder);
                textView.setMovementMethod(SafeLinkMovementMethod.getInstance());
                setImage(view, R.id.ms_download_layer_app_logo, baseAdSlot.getIcon());
                setText(view, R.id.ms_download_layer_app_name, baseAdSlot.getAppName());
                setText(view, R.id.ms_download_layer_app_developer, baseAdSlot.getDeveloper());
                new i(view).b(R.id.ms_download_layer_layout).d(0);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void openByType(BaseAdSlot baseAdSlot, Context context, String str) {
        openByType(baseAdSlot != null ? toBean(baseAdSlot) : null, context, str);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x003c  */
    public static void openByType(DownloadDialogBean downloadDialogBean, Context context, String str) {
        byte b;
        if (str == null) {
            str = "";
        }
        try {
            int iHashCode = str.hashCode();
            if (iHashCode != -517618225) {
                if (iHashCode != -314498168) {
                    if (iHashCode == 1018214091 && str.equals(CLICK_DOWNLOAD_INFO_TYPE_DESCRIBE)) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                } else if (str.equals(CLICK_DOWNLOAD_INFO_TYPE_PRIVACY)) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (str.equals(CLICK_DOWNLOAD_INFO_TYPE_PERMISSION)) {
                b = 2;
            } else {
                b = -1;
            }
            if (b == 0) {
                openWebView(context, downloadDialogBean != null ? downloadDialogBean.getApp_private_agreement() : null);
                return;
            }
            if (b == 1) {
                if (downloadDialogBean == null) {
                    return;
                }
                if (!TextUtils.isEmpty(downloadDialogBean.getApp_intor_url())) {
                    openWebView(context, downloadDialogBean.getApp_intor_url());
                    return;
                } else {
                    if (TextUtils.isEmpty(downloadDialogBean.getApp_intro())) {
                        return;
                    }
                    DownloadDialogBean downloadDialogBean2 = new DownloadDialogBean();
                    downloadDialogBean2.setApp_intro(downloadDialogBean.getApp_intro());
                    MeishuDownloadDetailActivity.startActivity(context, downloadDialogBean2, "功能介绍");
                    return;
                }
            }
            if (b == 2 && downloadDialogBean != null) {
                if (!TextUtils.isEmpty(downloadDialogBean.getApp_permission_url())) {
                    openWebView(context, downloadDialogBean.getApp_permission_url());
                } else {
                    if (downloadDialogBean.getApp_permission() == null || downloadDialogBean.getApp_permission().isEmpty()) {
                        return;
                    }
                    DownloadDialogBean downloadDialogBean3 = new DownloadDialogBean();
                    downloadDialogBean3.setApp_permission(downloadDialogBean.getApp_permission());
                    MeishuDownloadDetailActivity.startActivity(context, downloadDialogBean3, "权限详情");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
