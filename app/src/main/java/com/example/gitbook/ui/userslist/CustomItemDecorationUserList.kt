package com.example.gitbook.ui.userslist

import android.content.Context
import android.graphics.Rect
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView


class CustomItemDecorationUserList(context: Context) : RecyclerView.ItemDecoration() {
    private val mPadding: Int
   override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val itemPosition = parent.getChildAdapterPosition(view)
        if (itemPosition == RecyclerView.NO_POSITION) {
            return
        }
        if (itemPosition == 0) {
            outRect.top = mPadding
        }
       outRect.bottom=mPadding
    }

    companion object {
        private const val PADDING_IN_DIPS = 10
    }

    init {
        val metrics: DisplayMetrics = context.resources.displayMetrics
        mPadding = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            PADDING_IN_DIPS.toFloat(),
            metrics
        ).toInt()
    }
}