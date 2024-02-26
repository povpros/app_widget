package com.example.homewidget



import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import androidx.core.app.JobIntentService
import androidx.core.app.TaskStackBuilder
import io.flutter.embedding.android.FlutterActivity
import io.flutter.plugin.common.MethodChannel
import android.appwidget.AppWidgetProvider;
import android.appwidget.AppWidgetManager
import android.app.PendingIntent
import android.app.ActivityManager
import io.flutter.FlutterInjector
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import android.content.ComponentName


class HomeScreenWidgetProvider : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            val views = RemoteViews(context.packageName, R.layout.widget_layout)

            // Set click listeners for each card
            setCardClickHandler(context, views, appWidgetId, R.id.nftID, "/property")
            setCardClickHandler(context, views, appWidgetId, R.id.pageA, "/pageA")
            setCardClickHandler(context, views, appWidgetId, R.id.pageB, "/pageB")

            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }

    private fun setCardClickHandler(
        context: Context,
        views: RemoteViews,
        appWidgetId: Int,
        cardViewId: Int,
        route: String
    ) {
        val intent = Intent(context, HomeScreenWidgetProvider::class.java)
        intent.action = "FLUTTER_APP_WIDGET_CLICKED"
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
        intent.putExtra("route", route)

        // Add FLAG_IMMUTABLE to the PendingIntent
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            cardViewId,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        views.setOnClickPendingIntent(cardViewId, pendingIntent)
    }

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)

        if (intent.action == "FLUTTER_APP_WIDGET_CLICKED") {
            val route = intent.getStringExtra("route")

            val isAppInForeground = isAppInForeground(context)

            // if (isAppInForeground) {
                val flutterIntent = Intent(context, FlutterActivity::class.java)
                flutterIntent.action = Intent.ACTION_RUN
                flutterIntent.putExtra("route", route)
                flutterIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

                // Ensure the Flutter app is launched with the correct back stack
                val stackBuilder = TaskStackBuilder.create(context)
                    .addNextIntentWithParentStack(flutterIntent)
                stackBuilder.startActivities()
            // } 
            // else {
            //     // Launch Flutter app from the background
            //     val flutterIntent = Intent(context, FlutterActivity::class.java)
            //     flutterIntent.action = Intent.ACTION_RUN
            //     flutterIntent.putExtra("route", route)
            //     flutterIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            //     context.startActivity(flutterIntent)
            // }
        }
    }

    private fun isAppInForeground(context: Context): Boolean {
        val activityManager =
            context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val appProcesses = activityManager.runningAppProcesses ?: return false
        val packageName = context.packageName

        for (appProcess in appProcesses) {
            if (appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND &&
                appProcess.processName == packageName
            ) {
                return true
            }
        }
        return false
    }
}















// // work on background
// import android.app.PendingIntent;
// import android.appwidget.AppWidgetManager;
// import android.appwidget.AppWidgetProvider;
// import android.content.Context;
// import android.content.Intent;
// import android.widget.RemoteViews;

// import io.flutter.embedding.android.FlutterActivity
// import io.flutter.embedding.engine.FlutterEngine
// import io.flutter.plugin.common.MethodChannel
// class HomeScreenWidgetProvider : AppWidgetProvider() {
//     override fun onUpdate(
//         context: Context,
//         appWidgetManager: AppWidgetManager,
//         appWidgetIds: IntArray
//     ) {
//         for (appWidgetId in appWidgetIds) {
        
//              val views = RemoteViews(context.packageName, R.layout.widget_layout)

//         // Handle button click event
//             val intent = Intent(context, HomeScreenWidgetProvider::class.java)
//             intent.action = "FLUTTER_APP_WIDGET_CLICKED"
//             intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)

//             // Add FLAG_IMMUTABLE to the PendingIntent
//             val pendingIntent = PendingIntent.getBroadcast(
//                 context,
//                 0,
//                 intent,
//                 PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
//             )

//             views.setOnClickPendingIntent(R.id.nftID, pendingIntent)

//             appWidgetManager.updateAppWidget(appWidgetId, views)
//             }
//     }

//     override fun onReceive(context: Context, intent: Intent) {
//         super.onReceive(context, intent)

//         if (intent.action == "FLUTTER_APP_WIDGET_CLICKED") {
//             // Launch Flutter app and navigate to a specific page
//             val flutterIntent = Intent(context, FlutterActivity::class.java)
//             flutterIntent.action = Intent.ACTION_RUN
//             flutterIntent.putExtra(
//                 "route",
//                 "/property" 
//             )
//             flutterIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//             flutterIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//             context.startActivity(flutterIntent)
//         }
//     }
// }
