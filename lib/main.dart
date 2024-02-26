// import 'package:android_intent_plus/android_intent.dart';
import 'package:flutter/material.dart';
import 'package:homewidget/home_screen.dart';
import 'package:homewidget/nft_page.dart';
import 'package:homewidget/page_a.dart';
import 'package:homewidget/page_b.dart';

final GlobalKey<NavigatorState> navigatorKey = GlobalKey<NavigatorState>();
void main() async {
  WidgetsFlutterBinding.ensureInitialized();

  // Run the Flutter app
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({
    super.key,
  });

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      initialRoute: '/',
      routes: {
        '/': (context) => const HomeScreen(),
        '/pageA': (context) => const PageA(),
        '/pageB': (context) => const PageB(),
        '/property': (context) => const NFTPage(),
      },
    );
  }
}
