package com.bawei.oneday;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.oneday.base.BaseActivity;
import com.bawei.oneday.base.BasePresenter;
import com.bawei.oneday.bean.NameBean;
import com.bawei.oneday.presenter.IPresenter;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends BaseActivity {


    @BindView(R.id.edit_name)
    EditText editName;
    @BindView(R.id.button_shousuo)
    Button buttonShousuo;
    @BindView(R.id.button_zfc)
    Button buttonZfc;
    @BindView(R.id.button_nbl)
    Button buttonNbl;
    @BindView(R.id.image_view02)
    ImageView imageView02;

    @Override
    protected void startPresenter() {

    }

    @Override
    protected BasePresenter getPresenter() {
        return new IPresenter();
    }

    @Override
    protected void initView() {
        CodeUtils.init(this);
        imageView02.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String s = editName.getText().toString();
                Toast.makeText(Main2Activity.this, "" + s, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main2;
    }

    @Override
    public void onSuccess(String url) {

    }

    @Override
    public void onError(String error) {

    }

    @OnClick({R.id.button_shousuo, R.id.button_zfc, R.id.button_nbl, R.id.image_view02})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_shousuo:
                String trim = editName.getText().toString().trim();
                Bitmap image = CodeUtils.createImage(trim, 200, 200, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
                imageView02.setImageBitmap(image);
                break;
            case R.id.button_zfc:
                EventBus.getDefault().post("白烺长得好帅");
                break;
            case R.id.button_nbl:
                EventBus.getDefault().post(new NameBean("白烺", 10));
                break;
            case R.id.image_view02:
                CodeUtils.analyzeByImageView(imageView02, new CodeUtils.AnalyzeCallback() {
                    @Override
                    public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                        Toast.makeText(Main2Activity.this, "成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnalyzeFailed() {
                        Toast.makeText(Main2Activity.this, "失败", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void nameBeanstring(NameBean nameBean) {
        Toast.makeText(this, "" + nameBean.toString(), Toast.LENGTH_SHORT).show();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void nameToString(String name) {
        Toast.makeText(this, "" + name, Toast.LENGTH_SHORT).show();
    }

}
