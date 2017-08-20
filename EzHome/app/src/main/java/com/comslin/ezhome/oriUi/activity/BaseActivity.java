package com.comslin.ezhome.oriUi.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.comslin.ezhome.R;

/**
 * @Description
 * @author Nana
 * @date 2014-4-10
 */
public abstract class BaseActivity extends Activity {
    protected ImageView topLeftBtn;
    protected ImageView topRightBtn;
    protected TextView topTitleTxt;
    protected TextView letTitleTxt;
    protected TextView topRightTitleTxt;
    protected ViewGroup topBar;
    protected ViewGroup topContentView;
    protected ViewGroup baseRoot;
    protected float x1, y1, x2, y2 = 0;
    private ProgressBar mProgressView;
    private static BaseActivity runningActivity;

    public static BaseActivity getRunningActivity() {
        return runningActivity;
    }

    public static void setRunningActivity(BaseActivity activity) {
        runningActivity = activity;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppComBaseTheme);
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        topContentView = (ViewGroup) LayoutInflater.from(this).inflate(
                R.layout.activity_base, null);
        topBar = (ViewGroup) topContentView.findViewById(R.id.topbar);
        topTitleTxt = (TextView) topContentView.findViewById(R.id.base_activity_title);
        topLeftBtn = (ImageView) topContentView.findViewById(R.id.left_btn);
        topRightTitleTxt = (TextView) topContentView.findViewById(R.id.right_txt);
//        topRightBtn = (ImageView) topContentView.findViewById(R.id.right_btn);
        letTitleTxt = (TextView) topContentView.findViewById(R.id.left_txt);
        baseRoot = (ViewGroup)topContentView.findViewById(R.id.act_base_root);
        mProgressView=(ProgressBar)topContentView.findViewById(R.id.pg_base);
        topTitleTxt.setVisibility(View.GONE);
//        topRightBtn.setVisibility(View.GONE);
        letTitleTxt.setVisibility(View.GONE);
        topLeftBtn.setVisibility(View.GONE);
        topRightTitleTxt.setVisibility(View.GONE);
        setContentView(topContentView);
        setLeftButton(R.drawable.backbtn_selector);
    }

    protected void setLeftText(String text) {
        if (null == text) {
            return;
        }
        letTitleTxt.setText(text);
        letTitleTxt.setVisibility(View.VISIBLE);
    }

    protected void setTitle(String title) {
        if (title == null) {
            return;
        }
        if (title.length() > 12) {
            title = title.substring(0, 11) + "...";
        }
        topTitleTxt.setText(title);
        topTitleTxt.setVisibility(View.VISIBLE);
    }

    @Override
    public void setTitle(int id) {
        String strTitle = getResources().getString(id);
        setTitle(strTitle);
    }

    protected void setLeftButton(int resID) {
        if (resID <= 0) {
            return;
        }

        topLeftBtn.setImageResource(resID);
        topLeftBtn.setVisibility(View.VISIBLE);
        topLeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
        }
    }
    protected void setTopRightText(@StringRes int res){
        topRightTitleTxt.setText(res);
        topRightTitleTxt.setVisibility(View.VISIBLE);

    }
    protected void setTopRightText(String text) {
        if (null == text) {
            return;
        }
        topRightTitleTxt.setText(text);
        topRightTitleTxt.setVisibility(View.VISIBLE);
    }


    protected void setRightButton(int resID) {
        if (resID <= 0) {
            return;
        }

//        topRightBtn.setImageResource(resID);
//        topRightBtn.setVisibility(View.VISIBLE);
    }

    protected void setTopBar(int resID) {
        if (resID <= 0) {
            return;
        }
        topBar.setBackgroundResource(resID);
    }

    public void WarningDialog(String message) {
        try {
            AlertDialog.Builder builder = new Builder(this);
            builder.setMessage(message);
            builder.setPositiveButton(getString(R.string.confirm), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.create().show();
        }
        catch (Exception e) {
        }
    }

    public void WarningDialog(String message, String positive, String negative, final DialogClickListener listener) {
        try {
            AlertDialog.Builder builder = new Builder(this);
            builder.setMessage(message);
            builder.setPositiveButton(positive, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    listener.ok();
                }
            });
            if (!TextUtils.isEmpty(negative)) {
                builder.setNegativeButton(negative, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int arg1) {
                        dialog.dismiss();
                        listener.cancel();
                    }
                });
            }
            builder.create().show();
        }
        catch (Exception e) {
        }
    }

    public interface DialogClickListener
    {
        public void ok();
        public void cancel();
    }
}
