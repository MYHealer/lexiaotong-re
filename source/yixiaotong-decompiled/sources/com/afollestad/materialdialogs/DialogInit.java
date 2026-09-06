package com.afollestad.materialdialogs;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.internal.MDAdapter;
import com.afollestad.materialdialogs.internal.MDButton;
import com.afollestad.materialdialogs.internal.MDRootLayout;
import com.afollestad.materialdialogs.internal.MDTintHelper;
import com.afollestad.materialdialogs.util.DialogUtils;
import java.util.ArrayList;
import java.util.Arrays;
import me.zhanghai.android.materialprogressbar.HorizontalProgressDrawable;
import me.zhanghai.android.materialprogressbar.IndeterminateHorizontalProgressDrawable;
import me.zhanghai.android.materialprogressbar.IndeterminateProgressDrawable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
class DialogInit {
    private static void fixCanvasScalingWhenHardwareAccelerated(ProgressBar progressBar) {
    }

    DialogInit() {
    }

    static int getTheme(MaterialDialog.Builder builder) {
        boolean zResolveBoolean = DialogUtils.resolveBoolean(builder.context, R.attr.md_dark_theme, builder.theme == Theme.DARK);
        builder.theme = zResolveBoolean ? Theme.DARK : Theme.LIGHT;
        return zResolveBoolean ? R.style.MD_Dark : R.style.MD_Light;
    }

    static int getInflateLayout(MaterialDialog.Builder builder) {
        if (builder.customView != null) {
            return R.layout.md_dialog_custom;
        }
        if ((builder.items != null && builder.items.size() > 0) || builder.adapter != null) {
            if (builder.checkBoxPrompt != null) {
                return R.layout.md_dialog_list_check;
            }
            return R.layout.md_dialog_list;
        }
        if (builder.progress > -2) {
            return R.layout.md_dialog_progress;
        }
        if (builder.indeterminateProgress) {
            if (builder.indeterminateIsHorizontalProgress) {
                return R.layout.md_dialog_progress_indeterminate_horizontal;
            }
            return R.layout.md_dialog_progress_indeterminate;
        }
        if (builder.inputCallback != null) {
            if (builder.checkBoxPrompt != null) {
                return R.layout.md_dialog_input_check;
            }
            return R.layout.md_dialog_input;
        }
        if (builder.checkBoxPrompt != null) {
            return R.layout.md_dialog_basic_check;
        }
        return R.layout.md_dialog_basic;
    }

    public static void init(MaterialDialog materialDialog) {
        MaterialDialog.Builder builder = materialDialog.mBuilder;
        materialDialog.setCancelable(builder.cancelable);
        materialDialog.setCanceledOnTouchOutside(builder.canceledOnTouchOutside);
        if (builder.backgroundColor == 0) {
            builder.backgroundColor = DialogUtils.resolveColor(builder.context, R.attr.md_background_color, DialogUtils.resolveColor(materialDialog.getContext(), R.attr.colorBackgroundFloating));
        }
        if (builder.backgroundColor != 0) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(builder.context.getResources().getDimension(R.dimen.md_bg_corner_radius));
            gradientDrawable.setColor(builder.backgroundColor);
            DialogUtils.setBackgroundCompat(materialDialog.view, gradientDrawable);
        }
        if (!builder.positiveColorSet) {
            builder.positiveColor = DialogUtils.resolveActionTextColorStateList(builder.context, R.attr.md_positive_color, builder.positiveColor);
        }
        if (!builder.neutralColorSet) {
            builder.neutralColor = DialogUtils.resolveActionTextColorStateList(builder.context, R.attr.md_neutral_color, builder.neutralColor);
        }
        if (!builder.negativeColorSet) {
            builder.negativeColor = DialogUtils.resolveActionTextColorStateList(builder.context, R.attr.md_negative_color, builder.negativeColor);
        }
        if (!builder.widgetColorSet) {
            builder.widgetColor = DialogUtils.resolveColor(builder.context, R.attr.md_widget_color, builder.widgetColor);
        }
        if (!builder.titleColorSet) {
            builder.titleColor = DialogUtils.resolveColor(builder.context, R.attr.md_title_color, DialogUtils.resolveColor(materialDialog.getContext(), android.R.attr.textColorPrimary));
        }
        if (!builder.contentColorSet) {
            builder.contentColor = DialogUtils.resolveColor(builder.context, R.attr.md_content_color, DialogUtils.resolveColor(materialDialog.getContext(), android.R.attr.textColorSecondary));
        }
        if (!builder.itemColorSet) {
            builder.itemColor = DialogUtils.resolveColor(builder.context, R.attr.md_item_color, builder.contentColor);
        }
        materialDialog.title = (TextView) materialDialog.view.findViewById(R.id.md_title);
        materialDialog.icon = (ImageView) materialDialog.view.findViewById(R.id.md_icon);
        materialDialog.titleFrame = materialDialog.view.findViewById(R.id.md_titleFrame);
        materialDialog.content = (TextView) materialDialog.view.findViewById(R.id.md_content);
        materialDialog.recyclerView = (RecyclerView) materialDialog.view.findViewById(R.id.md_contentRecyclerView);
        materialDialog.checkBoxPrompt = (CheckBox) materialDialog.view.findViewById(R.id.md_promptCheckbox);
        materialDialog.positiveButton = (MDButton) materialDialog.view.findViewById(R.id.md_buttonDefaultPositive);
        materialDialog.neutralButton = (MDButton) materialDialog.view.findViewById(R.id.md_buttonDefaultNeutral);
        materialDialog.negativeButton = (MDButton) materialDialog.view.findViewById(R.id.md_buttonDefaultNegative);
        if (builder.inputCallback != null && builder.positiveText == null) {
            builder.positiveText = builder.context.getText(android.R.string.ok);
        }
        materialDialog.positiveButton.setVisibility(builder.positiveText != null ? 0 : 8);
        materialDialog.neutralButton.setVisibility(builder.neutralText != null ? 0 : 8);
        materialDialog.negativeButton.setVisibility(builder.negativeText != null ? 0 : 8);
        if (builder.icon != null) {
            materialDialog.icon.setVisibility(0);
            materialDialog.icon.setImageDrawable(builder.icon);
        } else {
            Drawable drawableResolveDrawable = DialogUtils.resolveDrawable(builder.context, R.attr.md_icon);
            if (drawableResolveDrawable != null) {
                materialDialog.icon.setVisibility(0);
                materialDialog.icon.setImageDrawable(drawableResolveDrawable);
            } else {
                materialDialog.icon.setVisibility(8);
            }
        }
        int dimensionPixelSize = builder.maxIconSize;
        if (dimensionPixelSize == -1) {
            dimensionPixelSize = DialogUtils.resolveDimension(builder.context, R.attr.md_icon_max_size);
        }
        if (builder.limitIconToDefaultSize || DialogUtils.resolveBoolean(builder.context, R.attr.md_icon_limit_icon_to_default_size)) {
            dimensionPixelSize = builder.context.getResources().getDimensionPixelSize(R.dimen.md_icon_max_size);
        }
        if (dimensionPixelSize > -1) {
            materialDialog.icon.setAdjustViewBounds(true);
            materialDialog.icon.setMaxHeight(dimensionPixelSize);
            materialDialog.icon.setMaxWidth(dimensionPixelSize);
            materialDialog.icon.requestLayout();
        }
        if (!builder.dividerColorSet) {
            builder.dividerColor = DialogUtils.resolveColor(builder.context, R.attr.md_divider_color, DialogUtils.resolveColor(materialDialog.getContext(), R.attr.md_divider));
        }
        materialDialog.view.setDividerColor(builder.dividerColor);
        if (materialDialog.title != null) {
            materialDialog.setTypeface(materialDialog.title, builder.mediumFont);
            materialDialog.title.setTextColor(builder.titleColor);
            materialDialog.title.setGravity(builder.titleGravity.getGravityInt());
            materialDialog.title.setTextAlignment(builder.titleGravity.getTextAlignment());
            if (builder.title == null) {
                materialDialog.titleFrame.setVisibility(8);
            } else {
                materialDialog.title.setText(builder.title);
                materialDialog.titleFrame.setVisibility(0);
            }
        }
        if (materialDialog.content != null) {
            materialDialog.content.setMovementMethod(new LinkMovementMethod());
            materialDialog.setTypeface(materialDialog.content, builder.regularFont);
            materialDialog.content.setLineSpacing(0.0f, builder.contentLineSpacingMultiplier);
            if (builder.linkColor == null) {
                materialDialog.content.setLinkTextColor(DialogUtils.resolveColor(materialDialog.getContext(), android.R.attr.textColorPrimary));
            } else {
                materialDialog.content.setLinkTextColor(builder.linkColor);
            }
            materialDialog.content.setTextColor(builder.contentColor);
            materialDialog.content.setGravity(builder.contentGravity.getGravityInt());
            materialDialog.content.setTextAlignment(builder.contentGravity.getTextAlignment());
            if (builder.content != null) {
                materialDialog.content.setText(builder.content);
                materialDialog.content.setVisibility(0);
            } else {
                materialDialog.content.setVisibility(8);
            }
        }
        if (materialDialog.checkBoxPrompt != null) {
            materialDialog.checkBoxPrompt.setText(builder.checkBoxPrompt);
            materialDialog.checkBoxPrompt.setChecked(builder.checkBoxPromptInitiallyChecked);
            materialDialog.checkBoxPrompt.setOnCheckedChangeListener(builder.checkBoxPromptListener);
            materialDialog.setTypeface(materialDialog.checkBoxPrompt, builder.regularFont);
            materialDialog.checkBoxPrompt.setTextColor(builder.contentColor);
            MDTintHelper.setTint(materialDialog.checkBoxPrompt, builder.widgetColor);
        }
        materialDialog.view.setButtonGravity(builder.buttonsGravity);
        materialDialog.view.setButtonStackedGravity(builder.btnStackedGravity);
        materialDialog.view.setStackingBehavior(builder.stackingBehavior);
        boolean zResolveBoolean = DialogUtils.resolveBoolean(builder.context, android.R.attr.textAllCaps, true);
        if (zResolveBoolean) {
            zResolveBoolean = DialogUtils.resolveBoolean(builder.context, R.attr.textAllCaps, true);
        }
        MDButton mDButton = materialDialog.positiveButton;
        materialDialog.setTypeface(mDButton, builder.mediumFont);
        mDButton.setAllCapsCompat(zResolveBoolean);
        mDButton.setText(builder.positiveText);
        mDButton.setTextColor(builder.positiveColor);
        materialDialog.positiveButton.setStackedSelector(materialDialog.getButtonSelector(DialogAction.POSITIVE, true));
        materialDialog.positiveButton.setDefaultSelector(materialDialog.getButtonSelector(DialogAction.POSITIVE, false));
        materialDialog.positiveButton.setTag(DialogAction.POSITIVE);
        materialDialog.positiveButton.setOnClickListener(materialDialog);
        materialDialog.positiveButton.setVisibility(0);
        MDButton mDButton2 = materialDialog.negativeButton;
        materialDialog.setTypeface(mDButton2, builder.mediumFont);
        mDButton2.setAllCapsCompat(zResolveBoolean);
        mDButton2.setText(builder.negativeText);
        mDButton2.setTextColor(builder.negativeColor);
        materialDialog.negativeButton.setStackedSelector(materialDialog.getButtonSelector(DialogAction.NEGATIVE, true));
        materialDialog.negativeButton.setDefaultSelector(materialDialog.getButtonSelector(DialogAction.NEGATIVE, false));
        materialDialog.negativeButton.setTag(DialogAction.NEGATIVE);
        materialDialog.negativeButton.setOnClickListener(materialDialog);
        materialDialog.negativeButton.setVisibility(0);
        MDButton mDButton3 = materialDialog.neutralButton;
        materialDialog.setTypeface(mDButton3, builder.mediumFont);
        mDButton3.setAllCapsCompat(zResolveBoolean);
        mDButton3.setText(builder.neutralText);
        mDButton3.setTextColor(builder.neutralColor);
        materialDialog.neutralButton.setStackedSelector(materialDialog.getButtonSelector(DialogAction.NEUTRAL, true));
        materialDialog.neutralButton.setDefaultSelector(materialDialog.getButtonSelector(DialogAction.NEUTRAL, false));
        materialDialog.neutralButton.setTag(DialogAction.NEUTRAL);
        materialDialog.neutralButton.setOnClickListener(materialDialog);
        materialDialog.neutralButton.setVisibility(0);
        if (builder.listCallbackMultiChoice != null) {
            materialDialog.selectedIndicesList = new ArrayList();
        }
        if (materialDialog.recyclerView != null) {
            if (builder.adapter == null) {
                if (builder.listCallbackSingleChoice != null) {
                    materialDialog.listType = MaterialDialog.ListType.SINGLE;
                } else if (builder.listCallbackMultiChoice != null) {
                    materialDialog.listType = MaterialDialog.ListType.MULTI;
                    if (builder.selectedIndices != null) {
                        materialDialog.selectedIndicesList = new ArrayList(Arrays.asList(builder.selectedIndices));
                        builder.selectedIndices = null;
                    }
                } else {
                    materialDialog.listType = MaterialDialog.ListType.REGULAR;
                }
                builder.adapter = new DefaultRvAdapter(materialDialog, MaterialDialog.ListType.getLayoutForType(materialDialog.listType));
            } else if (builder.adapter instanceof MDAdapter) {
                ((MDAdapter) builder.adapter).setDialog(materialDialog);
            }
        }
        setupProgressDialog(materialDialog);
        setupInputDialog(materialDialog);
        if (builder.customView != null) {
            ((MDRootLayout) materialDialog.view.findViewById(R.id.md_root)).noTitleNoPadding();
            FrameLayout frameLayout = (FrameLayout) materialDialog.view.findViewById(R.id.md_customViewFrame);
            materialDialog.customViewFrame = frameLayout;
            View view = builder.customView;
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            View view2 = view;
            if (builder.wrapCustomViewInScroll) {
                Resources resources = materialDialog.getContext().getResources();
                int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.md_dialog_frame_margin);
                ScrollView scrollView = new ScrollView(materialDialog.getContext());
                int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.md_content_padding_top);
                int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.md_content_padding_bottom);
                scrollView.setClipToPadding(false);
                if (view instanceof EditText) {
                    scrollView.setPadding(dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize4);
                } else {
                    scrollView.setPadding(0, dimensionPixelSize3, 0, dimensionPixelSize4);
                    view.setPadding(dimensionPixelSize2, 0, dimensionPixelSize2, 0);
                }
                scrollView.addView(view, new FrameLayout.LayoutParams(-1, -2));
                view2 = scrollView;
            }
            frameLayout.addView(view2, new ViewGroup.LayoutParams(-1, -2));
        }
        if (builder.showListener != null) {
            materialDialog.setOnShowListener(builder.showListener);
        }
        if (builder.cancelListener != null) {
            materialDialog.setOnCancelListener(builder.cancelListener);
        }
        if (builder.dismissListener != null) {
            materialDialog.setOnDismissListener(builder.dismissListener);
        }
        if (builder.keyListener != null) {
            materialDialog.setOnKeyListener(builder.keyListener);
        }
        materialDialog.setOnShowListenerInternal();
        materialDialog.invalidateList();
        materialDialog.setViewInternal(materialDialog.view);
        materialDialog.checkIfListInitScroll();
    }

    private static void setupProgressDialog(MaterialDialog materialDialog) {
        MaterialDialog.Builder builder = materialDialog.mBuilder;
        if (builder.indeterminateProgress || builder.progress > -2) {
            materialDialog.mProgress = (ProgressBar) materialDialog.view.findViewById(android.R.id.progress);
            if (materialDialog.mProgress == null) {
                return;
            }
            if (builder.indeterminateProgress) {
                if (builder.indeterminateIsHorizontalProgress) {
                    IndeterminateHorizontalProgressDrawable indeterminateHorizontalProgressDrawable = new IndeterminateHorizontalProgressDrawable(builder.getContext());
                    indeterminateHorizontalProgressDrawable.setTint(builder.widgetColor);
                    materialDialog.mProgress.setProgressDrawable(indeterminateHorizontalProgressDrawable);
                    materialDialog.mProgress.setIndeterminateDrawable(indeterminateHorizontalProgressDrawable);
                } else {
                    IndeterminateProgressDrawable indeterminateProgressDrawable = new IndeterminateProgressDrawable(builder.getContext());
                    indeterminateProgressDrawable.setTint(builder.widgetColor);
                    materialDialog.mProgress.setProgressDrawable(indeterminateProgressDrawable);
                    materialDialog.mProgress.setIndeterminateDrawable(indeterminateProgressDrawable);
                }
            } else {
                HorizontalProgressDrawable horizontalProgressDrawable = new HorizontalProgressDrawable(builder.getContext());
                horizontalProgressDrawable.setTint(builder.widgetColor);
                materialDialog.mProgress.setProgressDrawable(horizontalProgressDrawable);
                materialDialog.mProgress.setIndeterminateDrawable(horizontalProgressDrawable);
            }
            if (!builder.indeterminateProgress || builder.indeterminateIsHorizontalProgress) {
                materialDialog.mProgress.setIndeterminate(builder.indeterminateIsHorizontalProgress);
                materialDialog.mProgress.setProgress(0);
                materialDialog.mProgress.setMax(builder.progressMax);
                materialDialog.mProgressLabel = (TextView) materialDialog.view.findViewById(R.id.md_label);
                if (materialDialog.mProgressLabel != null) {
                    materialDialog.mProgressLabel.setTextColor(builder.contentColor);
                    materialDialog.setTypeface(materialDialog.mProgressLabel, builder.mediumFont);
                    materialDialog.mProgressLabel.setText(builder.progressPercentFormat.format(0L));
                }
                materialDialog.mProgressMinMax = (TextView) materialDialog.view.findViewById(R.id.md_minMax);
                if (materialDialog.mProgressMinMax != null) {
                    materialDialog.mProgressMinMax.setTextColor(builder.contentColor);
                    materialDialog.setTypeface(materialDialog.mProgressMinMax, builder.regularFont);
                    if (builder.showMinMax) {
                        materialDialog.mProgressMinMax.setVisibility(0);
                        materialDialog.mProgressMinMax.setText(String.format(builder.progressNumberFormat, 0, Integer.valueOf(builder.progressMax)));
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) materialDialog.mProgress.getLayoutParams();
                        marginLayoutParams.leftMargin = 0;
                        marginLayoutParams.rightMargin = 0;
                    } else {
                        materialDialog.mProgressMinMax.setVisibility(8);
                    }
                } else {
                    builder.showMinMax = false;
                }
            }
        }
        if (materialDialog.mProgress != null) {
            fixCanvasScalingWhenHardwareAccelerated(materialDialog.mProgress);
        }
    }

    private static void setupInputDialog(MaterialDialog materialDialog) {
        MaterialDialog.Builder builder = materialDialog.mBuilder;
        materialDialog.input = (EditText) materialDialog.view.findViewById(android.R.id.input);
        if (materialDialog.input == null) {
            return;
        }
        materialDialog.setTypeface(materialDialog.input, builder.regularFont);
        if (builder.inputPrefill != null) {
            materialDialog.input.setText(builder.inputPrefill);
        }
        materialDialog.setInternalInputCallback();
        materialDialog.input.setHint(builder.inputHint);
        materialDialog.input.setSingleLine();
        materialDialog.input.setTextColor(builder.contentColor);
        materialDialog.input.setHintTextColor(DialogUtils.adjustAlpha(builder.contentColor, 0.3f));
        MDTintHelper.setTint(materialDialog.input, materialDialog.mBuilder.widgetColor);
        if (builder.inputType != -1) {
            materialDialog.input.setInputType(builder.inputType);
            if (builder.inputType != 144 && (builder.inputType & 128) == 128) {
                materialDialog.input.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
        materialDialog.inputMinMax = (TextView) materialDialog.view.findViewById(R.id.md_minMax);
        if (builder.inputMinLength > 0 || builder.inputMaxLength > -1) {
            materialDialog.invalidateInputMinMaxIndicator(materialDialog.input.getText().toString().length(), !builder.inputAllowEmpty);
        } else {
            materialDialog.inputMinMax.setVisibility(8);
            materialDialog.inputMinMax = null;
        }
    }
}
