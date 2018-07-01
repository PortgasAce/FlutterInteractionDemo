package com.portgas.flutterappinteraction;

import android.content.Intent;
import android.os.Bundle;
import io.flutter.app.FlutterActivity;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class MainActivity extends FlutterActivity {

  private static final String CHANNEL = "demo.plugin";


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // 自定义插件
    new MethodChannel(getFlutterView(), CHANNEL).setMethodCallHandler(new MethodCallHandler() {
      @Override
      public void onMethodCall(MethodCall call, Result result) {
        if (call.method.equals("interaction")) {
          Intent intent = new Intent(MainActivity.this, SplashActivity.class);
          MainActivity.this.startActivity(intent);
          result.success("success");
        } else {
          result.notImplemented();
        }
      }
    });

    GeneratedPluginRegistrant.registerWith(this);

  }
}
