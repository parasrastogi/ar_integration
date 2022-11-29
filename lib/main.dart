import 'package:dio/dio.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(const MyApp());
}
// static var arURL: String {
// if mode == development {
// return "\(baseURLDevelopment)api/armodels/getfurnituremodels?platform=1"
// } else if mode == local {
// return "\(baseURLLocal)api/armodels/getfurnituremodels?platform=1"
// } else if mode == staging {
// return "\(baseURLStaging)api/armodels/getfurnituremodels?platform=1"
// } else {
// return "\(baseURLProduction)api/armodels/getfurnituremodels?platform=1"
// }
// }
const furnitureURL = "http://salesarchitect-build.bhitest.com/api/armodels/getfurnituremodels?platform=1";
class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        // This is the theme of your application.
        //
        // Try running your application with "flutter run". You'll see the
        // application has a blue toolbar. Then, without quitting the app, try
        // changing the primarySwatch below to Colors.green and then invoke
        // "hot reload" (press "r" in the console where you ran "flutter run",
        // or simply save your changes to "hot reload" in a Flutter IDE).
        // Notice that the counter didn't reset back to zero; the application
        // is not restarted.
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  // This widget is the home page of your application. It is stateful, meaning
  // that it has a State object (defined below) that contains fields that affect
  // how it looks.

  // This class is the configuration for the state. It holds the values (in this
  // case the title) provided by the parent (in this case the App widget) and
  // used by the build method of the State. Fields in a Widget subclass are
  // always marked "final".

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  static const platform = MethodChannel('samples.flutter.dev/arIntegration');

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        // Here we take the value from the MyHomePage object that was created by
        // the App.build method, and use it to set our appbar title.
        title: Text(widget.title),
      ),
      body: Center(
        // Center is a layout widget. It takes a single child and positions it
        // in the middle of the parent.
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            TextButton(onPressed: _loadRoomMeasurement, child: const Text('Room Measurement')),
            TextButton(onPressed: _loadFurnitureDrop, child: const Text('Furniture Drop')),
            TextButton(onPressed: _loadPOI, child: const Text('POI'))
            //furnitureURL
          ],
        ),
      ),

    );
  }

  Future<void> _loadRoomMeasurement() async {
    String batteryLevel;
    try {
      final int result = await platform.invokeMethod('loadRoomMeasurement');
      batteryLevel = 'Battery level at $result % .';
    } on PlatformException catch (e) {
      batteryLevel = "Failed to get battery level: '${e.message}'.";
    }

    setState(() {

    });
  }

  Future<void> _loadFurnitureDrop() async {
    String batteryLevel;
    try {
      final int result = await platform.invokeMethod('loadFurnitureDrop', {"furnitureURL": furnitureURL});
      batteryLevel = 'Battery level at $result % .';
    } on PlatformException catch (e) {
      batteryLevel = "Failed to get battery level: '${e.message}'.";
    }

  }

  Future<void> _loadPOI() async {
    String url = "https://salesarchitect-stage.exsquared.com/";
    var headers = {"SAApiVersion" : "2.0",
      "Authorization": "bearer dsGgGw6KR6r3cY45w-QQ6qJqG6igSGZLlvGjIE6slcSZc1c0wE82VnEEptmn3ssov0z3CVoLGNGU4ub6t5cjpP96lTN4bFwwWYbl0O8aH4tqdMceEouW2CdUabc6TNi03_MHjmHMPs991Pl0SCFgKLklf1or0AjJpgvzJqFsO3UkLCbGbQR36d6rsNoJZ2ivQZCw9lUl3uhKgNKu9FnOaLX-huOUEoeJA_JhORq8OhgYLmpkfPRUUHzSR9ovQJL3zS609vDIrOBXTlS1QrVZuPds1u-gSPFar239_1cDsk5ykd5BK_xh01W14-lz9Z_kfCLgp8DonK58G1UiuYgfY4H1GHJjjwOygOvhwFy2d66wAjRcTlAomKCcAsoJrFEAENmIbc1fap3gPnZbD41QzvtBI27pcvMiHbdxeBl4T0j3aNKfl93Q1-45xaGG-HpDKGqU-d8PdK8WaU9DUt9m8kWd4UpsLiVJ68Wsk93QmbqDUjUrzNPyTpP3Qxt_FfZtDYW4gRN7ejgLp1yUo_bMbdgWbEZ4SispvjUV4JpnGZbSf8cLpUCl_QU6dwbCh6KOCDFmc1QP0vtxCJjHt36zhaQewLHeRM1uI9QLGz2r1O_3BUI7FRcQJUNeBdT8iym8FNF_ORv20IsJnxI9R3_VjapWGU-Q661xgjv5DaJO2Zz-2ebcNN_X-9JD_3XRSAGsXBBUhZDP_CUk6Axb4bfIT2F8eLk",
      "Accept": "application/json"};
    try {
      final int result = await platform.invokeMethod('loadPOI', {"url": url, "header": headers});
    } on PlatformException catch (e) {
    }

  }
}
