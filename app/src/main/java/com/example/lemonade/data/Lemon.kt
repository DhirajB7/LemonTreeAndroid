package com.example.lemonade.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Lemon(val id:Int, @StringRes val lemonStringID: Int, @DrawableRes val lemonDrawableId: Int)