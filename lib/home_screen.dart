// import 'package:android_intent_plus/android_intent.dart';
import 'package:flutter/material.dart';
// import 'package:quick_actions/quick_actions.dart';
// import 'package:url_launcher/url_launcher.dart';
// import 'package:url_launcher/url_launcher_string.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({
    super.key,
  });

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  // QuickActions quickActions = const QuickActions();
  @override
  void initState() {
    super.initState();

    // HomeWidget.setAppGroupId('com.example.homewidget');

    // HomeWidget.registerInteractivityCallback(interactiveCallback);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.green,
        title: const Text('Home Screen'),
      ),
      body: Center(
        child: IconButton(
          icon: const Icon(Icons.abc),
          onPressed: () async {
            // await launchUrlString(
            //   'ppros://ppov/propertiesListing',
            // );
          },
        ),
      ),
    );
  }
}
