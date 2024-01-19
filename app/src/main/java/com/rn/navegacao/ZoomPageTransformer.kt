package com.rn.navegacao

import android.view.View
import androidx.viewpager.widget.ViewPager

class ZoomPageTransformer : ViewPager.PageTransformer{
    override fun transformPage(page: View, position: Float) {
        val minScale = 0.85f
        val minAlpha = 0.5f
        val pageWidth = page.width
        val pageHeight = page.height
        when {
            (position < -1) ->
                page.alpha = 0f
            (position <= 1) -> {
                val scaleFactor = Math.max(minScale, 1 - Math.abs(position))
                val vertMargin = pageHeight * (1 - scaleFactor) / 2
                val horzMargin = pageWidth * (1 - scaleFactor) / 2
                page.apply {
                    translationX = if (position < 0) {
                        horzMargin - vertMargin / 2
                    } else {
                        -horzMargin + vertMargin / 2
                    }
                    scaleX = scaleFactor
                    scaleY = scaleFactor
                    alpha = minAlpha + (scaleFactor - minScale) /
                            (1 - minScale) * (1 - minAlpha)
                }
            }
            else ->
                page.alpha = 0f
        }
    }
}