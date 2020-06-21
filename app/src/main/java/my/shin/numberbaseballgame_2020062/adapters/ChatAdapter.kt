package my.shin.numberbaseballgame_2020062.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.TextView
import my.shin.numberbaseballgame_2020062.R
import my.shin.numberbaseballgame_2020062.datas.Chat

class ChatAdapter(val mContext:Context,
                  val resId:Int,
                  val mList: ArrayList<Chat>) : ArrayAdapter<Chat>(mContext,resId,mList) {


    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var temprow = convertView

        temprow?.let {

        }.let {
            temprow = inf.inflate(R.layout.chat_list_item, null)

        }

        val row = temprow!!

        val computerLayout = row.findViewById<LinearLayout>(R.id.computerLayout)
        val computerTxt = row.findViewById<TextView>(R.id.computerTxt)
        val myLayout = row.findViewById<LinearLayout>(R.id.myLayout)
        val myTxt = row.findViewById<TextView>(R.id.myTxt)

        val data = mList[position]

//        컴퓨터가 말하면? 왼쪽 배치 레이아웃 보여주고, 오른쪽 배치 레이아웃 숨기기.
//        그 외에는? 왼쪽 배치 숨기고, 오른쪽 배치 보여주기.

        if (data.who == "CPU") {
            computerLayout.visibility = View.VISIBLE
            myLayout.visibility = View.GONE

//            컴퓨터가 말한 내용이니 컴퓨터 텍스트뷰에 적용

            computerTxt.text = data.content

        }

        else {
            computerLayout.visibility = View.GONE
            myLayout.visibility = View.VISIBLE

            myTxt.text = data.content
        }

        return row
    }


}