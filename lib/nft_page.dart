import 'package:flutter/material.dart';

class NFTPage extends StatefulWidget {
  const NFTPage({super.key});

  @override
  State<NFTPage> createState() => _NFTPageState();
}

class _NFTPageState extends State<NFTPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("NFT Page"),
      ),
    );
  }
}
