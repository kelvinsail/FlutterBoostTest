package com.yifan.flutterboosttest.nativeview;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yifan.flutterboosttest.R;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.platform.PlatformView;

public class AndroidNativeView implements PlatformView {

    private static final String TAG = "AndroidNativeView";

    private Context context;

    public AndroidNativeView(Context context, int viewId, Object args) {
        this.context = context;
    }

    @Override
    public View getView() {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_native_view, null, false);
        //这句一定得加，不然空指针
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view instanceof Button) {
                    Log.i(TAG, "onClick: " + ((Button) view).getText().toString());
                }
            }
        };
        for (int i = 0; i < ((ViewGroup)view).getChildCount(); i++) {
            View subView = ((ViewGroup) view).getChildAt(i);
            subView.setOnClickListener(clickListener);
        }
        ((RecyclerView)view.findViewById(R.id.listView)).setAdapter(new Adapter());
        return view;
    }

    @Override
    public void onFlutterViewAttached(@NonNull View flutterView) {
        PlatformView.super.onFlutterViewAttached(flutterView);
    }

    @Override
    public void onFlutterViewDetached() {
        PlatformView.super.onFlutterViewDetached();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void onInputConnectionLocked() {
        PlatformView.super.onInputConnectionLocked();
    }

    @Override
    public void onInputConnectionUnlocked() {
        PlatformView.super.onInputConnectionUnlocked();
    }

    class Adapter extends RecyclerView.Adapter<Adapter.ItemHolder> {

        @NonNull
        @Override
        public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LinearLayout layout = new LinearLayout(parent.getContext());
            layout.setGravity(Gravity.CENTER);
            Button button = new Button(parent.getContext());
            button.setId(android.R.id.button1);
            layout.addView(button);
            return new ItemHolder(layout);
        }

        @Override
        public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
            holder.textButton.setText("列表按钮：" + position);
        }

        @Override
        public int getItemCount() {
            return 100;
        }

        class ItemHolder extends RecyclerView.ViewHolder{
            Button textButton;
            public ItemHolder(@NonNull View itemView) {
                super(itemView);
                textButton = itemView.findViewById(android.R.id.button1);
                textButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.i(TAG, "onClick: 列表：" + getAdapterPosition());
                    }
                });
            }


        }

    }
}
