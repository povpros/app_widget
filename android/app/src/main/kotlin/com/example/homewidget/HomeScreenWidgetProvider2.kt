
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


class HomeScreenWidgetProvider2 : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            val views = RemoteViews(context.packageName, R.layout.widget_layout2)

            // Handle button click event
            val intent = Intent(context, HomeScreenWidgetProvider2::class.java)
            intent.action = "FLUTTER_APP_WIDGET_CLICKED"
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)

            // Add FLAG_IMMUTABLE to the PendingIntent
            val pendingIntent = PendingIntent.getBroadcast(
                context,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )

            views.setOnClickPendingIntent(R.id.nftCard, pendingIntent)

            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)

        if (intent.action == "FLUTTER_APP_WIDGET_CLICKED") {
            // Check if the app is in the foreground
        //    val isAppInForeground = isAppInForeground(context)

        //     if (isAppInForeground) {
        //          val flutterIntent = Intent(context, FlutterActivity::class.java)
        //         flutterIntent.action = Intent.ACTION_RUN
        //         flutterIntent.putExtra("route", "/property")
        //         flutterIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

        //         // Ensure the Flutter app is launched with the correct back stack
        //         val stackBuilder = TaskStackBuilder.create(context)
        //             .addNextIntentWithParentStack(flutterIntent)
        //         stackBuilder.startActivities()
             
        //     } else {

                // Launch Flutter app from the background
                val flutterIntent = Intent(context, FlutterActivity::class.java)
                flutterIntent.action = Intent.ACTION_RUN
                flutterIntent.putExtra("route", "/property")
                flutterIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

                // Ensure the Flutter app is launched with the correct back stack
                val stackBuilder = TaskStackBuilder.create(context)
                    .addNextIntentWithParentStack(flutterIntent)
                stackBuilder.startActivities()
        //     }
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

