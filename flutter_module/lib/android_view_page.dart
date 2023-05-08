import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';

class AndroidViewPage extends StatelessWidget {
  const AndroidViewPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    String? title = "androidView";

    return Scaffold(

      appBar: AppBar(title: Text(title ?? ''),),
      body: Center(
        child:iosView(),
      ),
    );
  }
  Widget iosView() {
    if(defaultTargetPlatform == TargetPlatform.android){
      return  const AndroidView(
        viewType: 'plugins.flutter.io/custom_platform_view',
      );
    }else {
      return Container();
    }
  }
}