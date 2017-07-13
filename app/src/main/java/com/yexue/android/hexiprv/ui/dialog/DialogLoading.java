package com.yexue.android.hexiprv.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

import com.yexue.android.hexiprv.R;

/**
 * @author yexue
 * @version 1.0
 * @name com.yexue.android.hexiprv.ui.dialog
 * @explain
 * @time 2017/7/13 10:41
 */
public class DialogLoading extends Dialog {

    private TextView loadingLabel;

    public DialogLoading(Context context) {
        super(context, R.style.Dialog);
        setContentView(R.layout.dialog_loading_layout);
        setCanceledOnTouchOutside(false);
        loadingLabel = (TextView) findViewById(R.id.loading_text);
    }

    public void setDialogLabel(String label) {
        loadingLabel.setText(label);
    }

}
