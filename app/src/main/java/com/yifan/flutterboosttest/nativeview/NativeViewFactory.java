package com.yifan.flutterboosttest.nativeview;

import android.content.Context;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

/**
 * @author yifan wu
 *
 * created in 2023/5/8.
 *
 * used for
 */
public class NativeViewFactory extends PlatformViewFactory {

    /**
     * @param createArgsCodec the codec used to decode the args parameter of {@link #create}.
     */
    public NativeViewFactory() {
        super(StandardMessageCodec.INSTANCE);
    }

    @Override
    public PlatformView create(Context context, int viewId, Object args) {
        return new AndroidNativeView(context, viewId, args);
    }


}
