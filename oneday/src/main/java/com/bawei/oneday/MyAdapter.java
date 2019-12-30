package com.bawei.oneday;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.oneday.bean.JsonBean;
import com.bawei.oneday.util.GlideUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.OneViewHodler> {
    private List<JsonBean.ResultBean> list;
    private Context context;

    public MyAdapter(List<JsonBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public OneViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.activity_name, null);
        return new OneViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OneViewHodler holder, int position) {
        holder.textView01.setText(list.get(position).getCommodityName());
        GlideUtil.GlideInfo(list.get(position).getMasterPic(),holder.imageView01);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cliCent.onCliCent(position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    setCliCent cliCent;

    public void setCliCent(setCliCent cliCent) {
        this.cliCent = cliCent;
    }

    public  interface setCliCent{
        void onCliCent(int item);
    }
    public static class OneViewHodler extends RecyclerView.ViewHolder {
        @BindView(R.id.text_view01)
        TextView textView01;
        @BindView(R.id.image_view01)
        ImageView imageView01;
        public OneViewHodler(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
