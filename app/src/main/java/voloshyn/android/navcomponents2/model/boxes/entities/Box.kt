package voloshyn.android.navcomponents2.model.boxes.entities

import androidx.annotation.StringRes

data class Box(
    val id:Long,
    @StringRes val colorNameRes: Int,
    val colorValue: Int
)
