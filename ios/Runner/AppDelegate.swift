import UIKit
import Flutter
import NHNARIntegration

@UIApplicationMain
@objc class AppDelegate: FlutterAppDelegate {

  override func application(
    _ application: UIApplication,
    didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?
  ) -> Bool {
      let controller : FlutterViewController = window?.rootViewController as! FlutterViewController
      // ar intergration
      let arIntegrationChannel = FlutterMethodChannel(name: "samples.flutter.dev/arIntegration",
                                                binaryMessenger: controller.binaryMessenger)
      arIntegrationChannel.setMethodCallHandler({
        (call: FlutterMethodCall, result: @escaping FlutterResult) -> Void in
        // This method is invoked on the UI thread.
        // Handle loadRoomMeasurement messages.

        switch(ARIntegrationMethodName(rawValue: call.method)){
        case .loadRoomMeasurement:
            self.onTouchRoomMeasurement()
        case .loadFurnitureDrop:
            guard let args = call.arguments as? [String : Any] else {return}
            
          if let url = args["furnitureURL"] as? String{
             self.onTouchFurnitureDrop(url: url)
          }

        case .loadPOI:
            guard let args = call.arguments as? [String : Any] else {return}
            if let url = args["url"] as? String, let header = args["header"] as? [String: String]{
                self.onTouchPointOfIntereast(url: url, header: header)
            }
        default:
            break
        }
      })

      GeneratedPluginRegistrant.register(with: self)
      return super.application(application, didFinishLaunchingWithOptions: launchOptions)
    }

    var controller : FlutterViewController {
      return window?.rootViewController as! FlutterViewController
    }

    private func onTouchRoomMeasurement() {
        if #available(iOS 11.0, *) {
          //  logEvent(eventCode: .nhnrmAR)
            ARManager.openMeasureViewController(caller: controller)
        }
    }

    private func onTouchFurnitureDrop(url: String) {
            if #available(iOS 11.0, *) {
                //logEvent(eventCode: .nhnfurAR)
                ARManager.openFurnitureViewController(caller: controller, urlForModels: url)
                
            }
        }
    
    private func onTouchPointOfIntereast(url: String, header: [String: String] ) {
        
        if #available(iOS 11.0, *) {
            //logEvent(eventCode: .nhnpoiAR)
            ARManager.openPointOfInterestViewController(caller: controller, headers: header, domain: url)

        }
    }

  }
