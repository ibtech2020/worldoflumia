package com.infobooktechnologies.worldoflumia.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.infobooktechnologies.worldoflumia.R
import com.infobooktechnologies.worldoflumia.databinding.RowFragmentPlayer01Binding
import com.infobooktechnologies.worldoflumia.databinding.RowFragmentPlayer02Binding
import com.infobooktechnologies.worldoflumia.databinding.RowFragmentPlayer03Binding
import com.infobooktechnologies.worldoflumia.databinding.RowFragmentPlayer04Binding
import com.infobooktechnologies.worldoflumia.ui.common.Constant

class PlayerThreeAdapter(_ViewType: Int) : RecyclerView.Adapter<PlayerThreeAdapter.ThreePlayerViewHolder>() {
    var viewTypeModel =_ViewType
    lateinit var viewbinding : ViewBinding
    var count:Int=0
    var resetValue = "0"
    lateinit var list: MutableList<Int>

    fun listCount(_count:Int){
        count = _count
//        repeat(count){
//            notifyItemChanged(it)
//        }
        notifyDataSetChanged()
    }


    class ThreePlayerViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThreePlayerViewHolder {

        when (viewTypeModel) {
            Constant.PLAYERONE -> {
                viewbinding  = RowFragmentPlayer01Binding.bind(LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.row_fragment_player_01, parent, false))
            }
            Constant.PLAYERTWO -> {
                viewbinding  = RowFragmentPlayer02Binding.bind(LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.row_fragment_player_02, parent, false))
            }Constant.PLAYERTHREE -> {
                viewbinding  = RowFragmentPlayer03Binding.bind(LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.row_fragment_player_03, parent, false))
            }Constant.PLAYERFOUR -> {
            viewbinding  = RowFragmentPlayer04Binding.bind(LayoutInflater
                .from(parent.context)
                .inflate(R.layout.row_fragment_player_04, parent, false))
        }

            else -> throw IllegalArgumentException("Invalid type")
        }
        return ThreePlayerViewHolder(viewbinding)
    }

    override fun onBindViewHolder(holder: ThreePlayerViewHolder, position: Int) {
        when (viewTypeModel) {
            Constant.PLAYERONE->{
                var view= (viewbinding as RowFragmentPlayer01Binding)
                view.title.text = "Player "
                view.lineBar.visibility = View.GONE
                view.score.text= resetValue
                view.btnPlayer1LeftWhite.customBtn.setBackgroundResource(R.drawable.ic_button1oneplayer_white_3x)
                view.btnPlayer1RightWhite.customBtn.setBackgroundResource(R.drawable.ic_button1oneplayer_white_3x)
                view.btnPlayer1LeftWhite.customBtn.text = "-1"
                view.btnPlayer1RightWhite.customBtn.text = "+1"
                view.btnPlayer1LeftYellow.customBtn.text = "-5"
                view.btnPlayer1RightYellow.customBtn.text = "+5"

                view.btnPlayer1LeftWhite.customBtn.setOnClickListener{
                    updateScoreView(view.score,view.btnPlayer1LeftWhite.customBtn.text.toString().toInt())
                }
                view.btnPlayer1RightWhite.customBtn.setOnClickListener {
                    updateScoreView(view.score,view.btnPlayer1RightWhite.customBtn.text.toString().toInt())
                }
                view.btnPlayer1LeftYellow.customBtn.setOnClickListener {
                    updateScoreView(view.score,view.btnPlayer1LeftYellow.customBtn.text.toString().toInt())
                }
                view.btnPlayer1RightYellow.customBtn.setOnClickListener {
                    updateScoreView(view.score,view.btnPlayer1RightYellow.customBtn.text.toString().toInt())
                }

            }
            Constant.PLAYERTWO -> {
                var view= (viewbinding as RowFragmentPlayer02Binding)
                view.title.text = "Player "+(position+1)
               if(position==(count-1))view.lineBar.visibility = View.GONE
                view.score.text= resetValue
                view.btnPlayer1LeftWhite.customBtn.setBackgroundResource(R.drawable.ic_button1oneplayer_white_3x)
                view.btnPlayer1RightWhite.customBtn.setBackgroundResource(R.drawable.ic_button1oneplayer_white_3x)
                view.btnPlayer1LeftWhite.customBtn.text = "-1"
                view.btnPlayer1RightWhite.customBtn.text = "+1"
                view.btnPlayer1LeftYellow.customBtn.text = "-5"
                view.btnPlayer1RightYellow.customBtn.text = "+5"

                view.btnPlayer1LeftWhite.customBtn.setOnClickListener{
                    println("POSITION :: "+holder.layoutPosition)
                    updateScoreView(view.score,view.btnPlayer1LeftWhite.customBtn.text.toString().toInt())
                }
                view.btnPlayer1RightWhite.customBtn.setOnClickListener {
                    updateScoreView(view.score,view.btnPlayer1RightWhite.customBtn.text.toString().toInt())
                }
                view.btnPlayer1LeftYellow.customBtn.setOnClickListener {
                    updateScoreView(view.score,view.btnPlayer1LeftYellow.customBtn.text.toString().toInt())
                }
                view.btnPlayer1RightYellow.customBtn.setOnClickListener {
                    updateScoreView(view.score,view.btnPlayer1RightYellow.customBtn.text.toString().toInt())
                }
            }
            Constant.PLAYERTHREE -> {
               var view= (viewbinding as RowFragmentPlayer03Binding)
                view.player1Title.text = "Player "+(position+1)
                if(position==(count-1))view.lineBar.visibility = View.GONE
                view.score.text= resetValue
                view.btnPlayer1LeftWhite.customBtn.setBackgroundResource(R.drawable.ic_button1oneplayer_white_3x)
                view.btnPlayer1RightWhite.customBtn.setBackgroundResource(R.drawable.ic_button1oneplayer_white_3x)
                view.btnPlayer1LeftWhite.customBtn.text = "-1"
                view.btnPlayer1RightWhite.customBtn.text = "+1"
                view.btnPlayer1LeftYellow.customBtn.text = "-5"
                view.btnPlayer1RightYellow.customBtn.text = "+5"

                view.btnPlayer1LeftWhite.customBtn.setOnClickListener{
                    updateScoreView(view.score,view.btnPlayer1LeftWhite.customBtn.text.toString().toInt())
                    println("POSITION :: "+holder.adapterPosition)
//                    updateItem(holder.adapterPosition,-1)
                }
                view.btnPlayer1RightWhite.customBtn.setOnClickListener {
                    updateScoreView(view.score,view.btnPlayer1RightWhite.customBtn.text.toString().toInt())
                }
                view.btnPlayer1LeftYellow.customBtn.setOnClickListener {
                    updateScoreView(view.score,view.btnPlayer1LeftYellow.customBtn.text.toString().toInt())
                }
                view.btnPlayer1RightYellow.customBtn.setOnClickListener {
                    updateScoreView(view.score,view.btnPlayer1RightYellow.customBtn.text.toString().toInt())
                }

            }
            Constant.PLAYERFOUR -> {
                var view= (viewbinding as RowFragmentPlayer04Binding)
                view.player1Title.text = "Player "+(position+1)
                if(position==(count-1))view.lineBar.visibility = View.GONE
                view.score.text= resetValue
                view.btnPlayer1LeftWhite.customBtn.setBackgroundResource(R.drawable.ic_button1oneplayer_white_3x)
                view.btnPlayer1RightWhite.customBtn.setBackgroundResource(R.drawable.ic_button1oneplayer_white_3x)
                view.btnPlayer1LeftWhite.customBtn.text = "-1"
                view.btnPlayer1RightWhite.customBtn.text = "+1"
                view.btnPlayer1LeftYellow.customBtn.text = "-5"
                view.btnPlayer1RightYellow.customBtn.text = "+5"

                view.btnPlayer1LeftWhite.customBtn.setOnClickListener{
                    updateScoreView(view.score,view.btnPlayer1LeftWhite.customBtn.text.toString().toInt())
                }
                view.btnPlayer1RightWhite.customBtn.setOnClickListener {
                    updateScoreView(view.score,view.btnPlayer1RightWhite.customBtn.text.toString().toInt())
                }
                view.btnPlayer1LeftYellow.customBtn.setOnClickListener {
                    updateScoreView(view.score,view.btnPlayer1LeftYellow.customBtn.text.toString().toInt())
                }
                view.btnPlayer1RightYellow.customBtn.setOnClickListener {
                    updateScoreView(view.score,view.btnPlayer1RightYellow.customBtn.text.toString().toInt())
                }
            }
        }

    }

    override fun getItemCount(): Int {
        return count
    }

    fun updateScoreView(textView: TextView,int: Int){
        var _cV= textView.text.toString().toInt()
        when(int){
            -1->{
                if (_cV>0){
                    textView.text = (_cV.minus(1)).toString()
                }

            }
            -5->{
                if (_cV>0){
                    if(_cV<=5){
                        textView.text = "0"
                    }else {
                        textView.text = (_cV.minus(5)).toString()
                    }
                }

            }
            1->{
                if(_cV<999){
                    textView.text = (textView.text.toString().toInt().plus(1)).toString()
                }

            }
            5->{
                if(_cV<999){
                    if(_cV in 994..998){
                        textView.text = "999"
                    }else{
                        textView.text = (textView.text.toString().toInt().plus(5)).toString()
                    }

                }

            }
        }
    }



}