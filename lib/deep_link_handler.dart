// import 'dart:async';
// import 'dart:developer';

// import 'package:firebase_dynamic_links/firebase_dynamic_links.dart';
// import 'package:flutter/material.dart';
// import 'package:flutter/services.dart';

// class DeepLinkHandler {
//   // static final Logger _logger = Logger('DeepLinkHandler');
//   static StreamSubscription<dynamic>? _dynamicLinkSubscription;

//   static void initDynamicLinks() async {
//     WidgetsFlutterBinding.ensureInitialized();

//     FirebaseDynamicLinks.instance.getInitialLink().then((data) {
//       final Uri? deepLink = data?.link;
//       if (deepLink != null) {
//         handleDeepLink(deepLink);
//       }
//     }).catchError((error) {
//       log('Failed to retrieve initial dynamic link: $error');
//     });

//     _dynamicLinkSubscription = FirebaseDynamicLinks.instance.onLink.listen((dynamicLink) {
//       final Uri deepLink = dynamicLink.link;
//       handleDeepLink(deepLink);
//     });

//     try {
//       final PendingDynamicLinkData? data = await FirebaseDynamicLinks.instance.getInitialLink();
//       final Uri? deepLink = data?.link;

//       if (deepLink != null) {
//         handleDeepLink(deepLink);
//       }
//     } on PlatformException catch (e) {
//       log('Failed to retrieve initial dynamic link: ${e.message}');
//     } catch (e) {
//       log('Failed to retrieve initial dynamic link: $e');
//     }
//   }

//   static void handleDeepLink(Uri deepLink) {
//     log('Received deep link: $deepLink');
//     // Perform the desired actions based on the deep link
//     // ...
//   }

//   static void dispose() {
//     _dynamicLinkSubscription?.cancel();
//   }
// }

// // class DeepLinkHandler {
// //   StreamSubscription? dynamicLinkSubscription;

// //   void initDynamicLinks() async {
// //     try {
// //       // Initialize FirebaseDynamicLinks
// //       final FirebaseDynamicLinks dynamicLinks = FirebaseDynamicLinks.instance;

// //       // Handle initial deep link when the app is first opened
// //       final PendingDynamicLinkData? data = await dynamicLinks.getInitialLink();
// //       final Uri? deepLink = data?.link;

// //       if (deepLink != null) {
// //         // Handle the deep link appropriately when the app is first opened.
// //         log('deep link is not null');
// //         handleDeepLink(Get.context!, deepLink);
// //       }

// //       // Register a listener for incoming dynamic links
// //       dynamicLinkSubscription = dynamicLinks.onLink.listen((dynamicLink) {
// //         log('listen to deep link');
// //         final Uri deepLink = dynamicLink.link;
// //         handleDeepLink(Get.context!, deepLink);
// //       });

// //       log('deep link handler');
// //     } catch (e) {
// //       log(e.toString());
// //     }
// //   }

// //   static void handleDeepLink(BuildContext context, Uri deepLink) {
// //     log('deep navigation');
// //     // if (deepLink.path == '/some-page') {
// //     Navigator.push(
// //       context,
// //       MaterialPageRoute(builder: (context) => const SampleScree()),
// //     );
// //     // }
// //   }

// //   void dispose() {
// //     dynamicLinkSubscription?.cancel();
// //   }
// // }
