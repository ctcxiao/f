package com.example.danale.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.danale.myapplication.R;

import java.util.List;

/**
 * Created by danale on 2017/7/25.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder implements IViewHolder {

    private View itemView;
    private IRemoveItem iRemoveItem;

    public BaseViewHolder(View itemView, IRemoveItem iRemoveItem) {
        super(itemView);
        this.itemView = itemView;
        this.iRemoveItem = iRemoveItem;
    }

    @Override
    public void bindData(final List<ViewModel> data, final int position) {
        ImageView imageView = itemView.findViewById(R.id.acc_icon);
        TextView textView = itemView.findViewById(R.id.acc_description);
        Button delete = itemView.findViewById(R.id.delete);

        imageView.setBackgroundResource(R.drawable.image_nest);
        textView.setText("NEST");

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = getAdapterPosition();
                iRemoveItem.notifyRemove(data, position);
                Log.i("tag", position+"delete");
            }
        });
    }


}
