package com.loodos.cryptoapp.subviews

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.ShapeAppearanceModel
import com.loodos.cryptoapp.util.Device.widthRatio


class RadiusImageView: ShapeableImageView {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)


    init {
        shapeAppearanceModel = ShapeAppearanceModel().withCornerSize(0.02f.widthRatio.toFloat())
    }
}