package com.example.recviewforegroundbackgroundcell.helper

import android.content.ClipData
import android.graphics.Canvas
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.recviewforegroundbackgroundcell.adapter.CustomAdapter

class RecyclerItemTouchHelper(val dragDirs:Int,val spiweDivs:Int,private val listener: RecyclerItemTouchHelperListener):ItemTouchHelper.SimpleCallback(dragDirs,spiweDivs) {

    interface RecyclerItemTouchHelperListener{
   fun onSwiped(viewHolder: RecyclerView.ViewHolder,direction: Int,position: Int)
  }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        listener.onSwiped(viewHolder,direction,viewHolder.adapterPosition)
    }


    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
        if (viewHolder != null){
            val foregroundView = (viewHolder as CustomAdapter.CustomViewHolder).front_side
            ItemTouchHelper.Callback.getDefaultUIUtil().onSelected(foregroundView)
        }
    }

    override fun onChildDrawOver(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder?,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        val foregroundView = (viewHolder as CustomAdapter.CustomViewHolder).front_side
        ItemTouchHelper.Callback.getDefaultUIUtil().onDrawOver(c,recyclerView,foregroundView,dX/3,dY,actionState,isCurrentlyActive)
    }

    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        val foregroundView = (viewHolder as CustomAdapter.CustomViewHolder).front_side
        ItemTouchHelper.Callback.getDefaultUIUtil().clearView(foregroundView)
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        val foreground = (viewHolder as CustomAdapter.CustomViewHolder).front_side
        ItemTouchHelper.Callback.getDefaultUIUtil().onDraw(c,recyclerView,foreground,dX/3,dY,actionState,isCurrentlyActive)
    }

    override fun convertToAbsoluteDirection(flags: Int, layoutDirection: Int): Int {
        return super.convertToAbsoluteDirection(flags, layoutDirection)
    }

}