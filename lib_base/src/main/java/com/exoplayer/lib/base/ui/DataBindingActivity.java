package com.exoplayer.lib.base.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * Activity基类架构
 *
 * @author zhangshuai
 */
public abstract class DataBindingActivity<B extends ViewDataBinding> extends AppCompatActivity {

    protected B mBinding;

    /**
     * Activity的xml布局
     */

    protected abstract int layoutRes();

    /**
     * Activity初始化
     */
    protected abstract void init();

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (layoutRes() > 0) {
            mBinding = DataBindingUtil.setContentView(this, layoutRes());
        }
    }


}
