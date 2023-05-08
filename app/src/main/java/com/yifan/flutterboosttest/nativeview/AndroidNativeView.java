package com.yifan.flutterboosttest.nativeview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;

import com.yifan.flutterboosttest.R;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.platform.PlatformView;

public class AndroidNativeView implements PlatformView {

    private Context context;

    public AndroidNativeView(Context context, BinaryMessenger binaryMessenger, int viewId, Object args) {
        this.context = context;
    }

    @Override
    public View getView() {
        return LayoutInflater.from(context).inflate(R.layout.layout_native_view, null, false);
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
}
