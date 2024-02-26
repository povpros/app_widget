import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:homewidget/home_screen.dart';
import 'package:homewidget/page_a.dart';
import 'package:homewidget/page_b.dart';

final GoRouter routers = GoRouter(
  routes: <RouteBase>[
    GoRoute(
      path: '/',
      builder: (BuildContext context, GoRouterState state) {
        return const HomeScreen();
      },
      routes: <RouteBase>[
        GoRoute(
          path: 'property',
          builder: (BuildContext context, GoRouterState state) {
            return const PageA();
          },
        ),
        GoRoute(
          path: 'b',
          builder: (BuildContext context, GoRouterState state) {
            return const PageB();
          },
        ),
      ],
    ),
  ],
);
