package my.shin.numberbaseballgame_2020062

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import my.shin.numberbaseballgame_2020062.adapters.ChatAdapter
import my.shin.numberbaseballgame_2020062.datas.Chat

class MainActivity : BaseActivity() {

//    문제로 나온 숫자를 담는 배열

    val cpuNumList = ArratyList<Int>

    val chatList = ArrayList<Chat>()
    lateinit var mChatAdapter : ChatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()

    }

    override fun setupEvents() {

        inputBtn.setOnClickListener {
            val inputNum = numberEdt.text.toString()

            if (inputNum.length!=3){
                Toast.makeText(mContext,"세자리 숫자만 입력  가능합니다.",Toast.LENGTH_SHORT).show()

                return@setOnClickListener
            }

            chatList.add(Chat("ME",inputNum))

            mChatAdapter.notifyDataSetChanged()

            numberEdt.setText("")

            checkUserInputStrikeAndBall(inputNum)
        }
    }

    fun checkUserInputStrikeAndBall(input : String){
        val number = input.toInt() //"265" => 265

        val numArr = ArrayList<Int>()

        numArr.add(number / 100)
        numArr.add(number / 10 % 10)
        numArr.add(number % 10)

        var strikeCount = 0
        var ballCount = 0


        for (i in numArr.indices) {


//            문제 숫자를 돌아주는 반복 : j 가 컴퓨터 숫자들 담당
            for (j in cpuNumList.indices) {

//                내 숫자와 CPU 숫자가 같은가?
                if (numArr[i] == cpuNumList[j]) {
                    if (i == j) {
//                        같다면 s 하나 더 찾았다

                    }

                    else{
                    }

                }

            }

        }
        chatList.add(Chat("CPU","${strikeCount}S ${ballCount}B 입니다."))

        mChatAdapter.notifyDataSetChanged()

        if (strikeCount ==3) {
            chatList.add(Chat("CPU","축하합니다!!"))

            Toast.makeText(mContext,"게임을 종료합니다.",Toast.LENGTH_SHORT).show()

//            입력도 못하도록 막자
            numberEdt.isEnabled = false
            inputBtn.isEnabled = false
        }

    }
}

    override fun setValues() {
        makeQuestionNum()

        for (num in cpuNumList) {Log.d("문제 출제", num.tostring())

        chatList.add(Chat("CPU","숫자 야구게임에 오신것을 환영합니다."))
        chatList.add(Chat("CPU","세자리 숫자를 맞춰주세요."))
        chatList.add(Chat("CPU","0은 포함되지 않으며,. 중복된 숫자도 없습니다"))

        mChatAdapter = ChatAdapter(mContext, R.layout.chat_list_item, chatList)
        chatListView.adapter = mChatAdapter
    }

    fun makeQuestionNum() {


        for (i in 0..2) {


            while (true) {


                val randomNum = (Math.random()*9 +1).toInt()

                var duplCheckResult = true

                for (num in cpuNumList) {
                    if (num == randomNum) {
                        duplCheckResult = false

                    }
                }

                if (duplCheckResult) {

                    cpuNumList.add(randomNum)
                    break
                }



                if () {

                }

            }
        }

    }


}
