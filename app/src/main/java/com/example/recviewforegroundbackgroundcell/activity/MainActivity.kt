package com.example.recviewforegroundbackgroundcell.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.*
import com.example.recviewforegroundbackgroundcell.R
import com.example.recviewforegroundbackgroundcell.adapter.CustomAdapter
import com.example.recviewforegroundbackgroundcell.helper.RecyclerItemTouchHelper
import com.example.recviewforegroundbackgroundcell.model.Member
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        val member = prepareMemberList()

        refreshAdapter(member)

    }

    fun refreshAdapter(member: List<Member>){

        recyclerView.adapter = CustomAdapter(member)
    }

    fun initView(){
        recyclerView.layoutManager = GridLayoutManager(this,1)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))

        val itemTouchHelperCallback = RecyclerItemTouchHelper(0,ItemTouchHelper.LEFT,object :RecyclerItemTouchHelper.RecyclerItemTouchHelperListener{
            override fun onSwiped(
                viewHolder: RecyclerView.ViewHolder,
                direction: Int,
                position: Int
            ) {
                Log.d("@@@", "@@@position$position")
            }
        })
        ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView)
    }

   fun prepareMemberList():List<Member>{
       val member = ArrayList<Member>()
       for (i in 0..15 ){
           member.add(Member("Goi"+1))
       }
   return member
   }

}