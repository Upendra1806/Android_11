package com.payoda.android_11.network

import android.content.Context
import android.graphics.BitmapFactory
import androidx.hilt.Assisted
import androidx.hilt.work.WorkerInject
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.payoda.android_11.R
import timber.log.Timber

class DemoWorker @WorkerInject constructor(
    @Assisted ctx: Context,
    @Assisted params: WorkerParameters
) : Worker(ctx, params) {

    override fun doWork(): Result {

        val appContext = applicationContext

        makeStatusNotification("Blurring image", appContext)

        return try {
            val picture = BitmapFactory.decodeResource(
                appContext.resources,
                R.drawable.ic_launcher_foreground
            )

            val output = blurBitmap(picture, appContext)

            // Write bitmap to a temp file
            val outputUri = writeBitmapToFile(appContext, output)

            makeStatusNotification("Output is $outputUri", appContext)

            Result.success()
        } catch (throwable: Throwable) {
            Timber.e(throwable, "Error applying blur")
            Result.failure()
        }
    }
}