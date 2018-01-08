package org.wordpress.android.editor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.support.annotation.DrawableRes;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;

import org.wordpress.android.util.ImageUtils;

public class MediaUtils {
    public static BitmapDrawable getAztecPlaceholderDrawableFromResID(Context context, @DrawableRes int drawableId, int maxImageWidthForVisualEditor) {
        Drawable drawable = ContextCompat.getDrawable(context, drawableId);
        Bitmap bitmap;
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
            bitmap = ImageUtils.getScaledBitmapAtLongestSide(bitmap, maxImageWidthForVisualEditor);
        } else if (drawable instanceof VectorDrawableCompat || drawable instanceof VectorDrawable) {
            bitmap = Bitmap.createBitmap(maxImageWidthForVisualEditor, maxImageWidthForVisualEditor, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
        } else {
            throw new IllegalArgumentException("Unsupported drawable type");
        }
        bitmap.setDensity(DisplayMetrics.DENSITY_DEFAULT);
        return new BitmapDrawable(context.getResources(), bitmap);
    }
}
