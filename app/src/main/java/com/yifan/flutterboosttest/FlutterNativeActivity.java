package com.yifan.flutterboosttest;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.yifan.flutterboosttest.nativeview.NativeViewFactory;
import com.yifan.flutterboosttest.nativeview.NativeViewPlugin;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.plugins.GeneratedPluginRegistrant;

/**
 * @author yifan Wu
 *
 * created in 2023/5/5.
 *
 * used for Flutter,基于原有Flutter提供的容器类
 */
public class FlutterNativeActivity extends FlutterActivity {

    private static final String TAG = "FlutterNativeActivity";

    @Override
    public String getInitialRoute() {
        return "/";
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (null == getFlutterEngine() || null == getFlutterEngine().getPlugins()) {
            Log.i(TAG, "onCreate: null");
            return;
        }
//        getFlutterEngine().getPlugins().add(new NativeViewPlugin());
        GeneratedPluginRegistrant.registerWith(getFlutterEngine());
        PlatformViewRegistry registry = getFlutterEngine().getPlatformViewsController().getRegistry();
        registry.registerViewFactory(NativeViewPlugin.VIEW_ID,
                new NativeViewFactory(getFlutterEngine().getDartExecutor()));
    }
}
