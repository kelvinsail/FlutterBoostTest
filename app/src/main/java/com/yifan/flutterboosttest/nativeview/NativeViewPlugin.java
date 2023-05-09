package com.yifan.flutterboosttest.nativeview;

import androidx.annotation.NonNull;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry;

/**
 * @author yifan wu
 *
 * created in 2023/5/8.
 *
 * used for
 */
public class NativeViewPlugin implements FlutterPlugin {
    public static final String VIEW_ID = "plugins.flutter.io/custom_platform_view";

    @Override
    public void onAttachedToEngine(@NonNull FlutterPluginBinding binding) {
        binding.getPlatformViewRegistry()
                .registerViewFactory(VIEW_ID, new NativeViewFactory());
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {

    }
}
