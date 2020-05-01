package com.basic.mvp.base;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;


// View层基类
public abstract class BaseView<P extends BasePresenter,CONTRACT> extends Activity {

    protected P p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        p = getPresenter();

        p.bindView(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        p.unBindView();
    }

    //// 从子类中获取具体的契约
    public abstract P getPresenter();

    // 让P层做什么需求
    public abstract CONTRACT getContract();

    //如果Presenter层出现了异常，需要告知View层
    public void error(Exception e){

    };



}
