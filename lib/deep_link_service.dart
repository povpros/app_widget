// import 'package:firebase_dynamic_links/firebase_dynamic_links.dart';

// class DeepLinkService {
//   Future<Uri> createDynamicLink() async {
//     final parameters = DynamicLinkParameters(
//       link: Uri.parse('https://www.wingbank.com.kh/en/'),
//       uriPrefix: 'https://rgcwallet.page.link',
//       androidParameters: const AndroidParameters(
//         packageName: 'com.winginterlts.wingwallet.dev',
//       ),
//     );

//     final ShortDynamicLink shortDynamicLink = await FirebaseDynamicLinks.instance.buildShortLink(
//       parameters,
//       shortLinkType: ShortDynamicLinkType.short,
//     );

//     final Uri shortUrl = shortDynamicLink.shortUrl;

//     return shortUrl;
//   }
// }

// // class DeepLinkService {
// //   Future<Uri> createDynamicLink() async {
// //     final parameters = DynamicLinkParameters(
// //       link: Uri.parse('https://rgcwallet.page.link/userprofile'),
// //       uriPrefix: 'https://rgcwallet.page.link',
// //       androidParameters: const AndroidParameters(
// //         packageName: 'com.winginterlts.wingwallet.dev',
// //       ),
// //       //   iosParameters: const IOSParameters(
// //       //     bundleId: 'com.example.yourapp',
// //       //   ),
// //       //   googleAnalyticsParameters: const GoogleAnalyticsParameters(
// //       //     source: 'example',
// //       //     medium: 'dynamic-link',
// //       //     campaign: 'example-campaign',
// //       //   ),
// //       //   socialMetaTagParameters: SocialMetaTagParameters(
// //       //     title: 'Your App',
// //       //     description: 'Check out this app!',
// //       //     imageUrl: Uri.parse('https://your-domain.com/image.png'),
// //       //   ),
// //     );

// //     final ShortDynamicLink shortDynamicLink = await FirebaseDynamicLinks.instance.buildShortLink(parameters, shortLinkType: ShortDynamicLinkType.short);

// //     final Uri shortUrl = shortDynamicLink.shortUrl;

// //     return shortUrl;
// //   }
// // }
