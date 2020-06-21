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
//            사용자 입력값을 받아오자
            val inputNum = numberEdt.text.toString()

//            세자리 일때만  OK
            if (inputNum.length!=3){
                Toast.makeText(mContext,"세자리 숫자만 입력  가능합니다.",Toast.LENGTH_SHORT).show()
//                이벤트 강제종료
                return@setOnClickListener
            }

//            입력값이 3자리이 보증됨
//            사용자가 한 말로 입력 처리 => 채팅 내역으로 추가
            chatList.add(Chat("ME",inputNum))

            mChatAdapter.notifyDataSetChanged()

//            한번 숫자 입력시 입력 칸 비워주기

            numberEdt.setText("")

//            입력한 값을 가지고 ?S ?B 인지 판단해서 답장하기

            checkUserInputStrikeAndBall(inputNum)
        }
    }

    fun checkUserInputStrikeAndBall(input : String){
        val number = input.toInt() //"265" => 265

//        세자리 숫자를 => 세칸의 배열로 분리. 256 => 2,5,6
        val numArr = ArrayList<Int>()

        numArr.add(number / 100)  // 100의 자리 2 : 256 / 100 = 2.56 (int는 자동적으로 정수로 나타냄)
        numArr.add(number / 10 % 10)  // 10의 자리 5 : 256 /10 % 10 = 5
        numArr.add(number % 10)  // 1의 자리 6 : 256 % 10 = 6

//        찾은 S?B 갯수를 저장할 변수
        var strikeCount = 0
        var ballCount = 0


//        내 입력값을 돌아주는 반복 : i가 내 숫자들 담당
        for (i in numArr.indices) {


//            문제 숫자를 돌아주는 반복 : j 가 컴퓨터 숫자들 담당
            for (j in cpuNumList.indices) {

//                내 숫자와 CPU 숫자가 같은가?
                if (numArr[i] == cpuNumList[j]) {
                    if (i == j) {
//                        같다면 s 하나 더 찾았다

                    }

                    else{
//                        숫자는 같지만 위치가 다르면 B 하나 더 찾았다 바보 멍충이 업곰지
                    }

                }

            }

        }
//        ?S ? B 판단이 모두 끝남. 결과가 cPU 가 답장
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

//
        makeQuestionNum()

        for (num in cpuNumList) {Log.d("문제 출제", num.tostring())

        chatList.add(Chat("CPU","숫자 야구게임에 오신것을 환영합니다."))
        chatList.add(Chat("CPU","세자리 숫자를 맞춰주세요."))
        chatList.add(Chat("CPU","0은 포함되지 않으며,. 중복된 숫자도 없습니다"))

        mChatAdapter = ChatAdapter(mContext, R.layout.chat_list_item, chatList)
        chatListView.adapter = mChatAdapter
    }

    fun makeQuestionNum() {

//        세자리 숫자를 만든다 => 한자리씩 배열에 저장. ex 741=> 7,4,1

        for (i in 0..2) {
//            조건에 맞는 숫자가 나오면 배열에 대입.
//            조건에 안맞는 숫자가 나오면 다시 뽑자.
//            조건에 맞는 숫자가 뽑힐때 까지 계속 뽑자.

            while (true) {


//                0*9+1<= (Math.random()).toInt() Ex. 9.8=>9 < 1*9+1
//                우리가 원하는 수자 : 0 제외. 1~9 정수
                val randomNum = (Math.random()*9 +1).toInt()

//                중복된 숫자면 안됨. => 문제 배열을 보고 같은 숫자가 있는지?
//                있다면 사용 불가 (중복)

//                일단 써도 된다고 했다가 => 검사결과 같은게 있다면 => 쓰면 안된다고.

                var duplCheckResult = true

                for (num in cpuNumList) {
                    if (num == randomNum) {
//                        문제에 같은 숫자가 있다! => 사용하면 안된다!
                        duplCheckResult = false

                    }
                }
//                랜덤숫자가 중복검사를 통과 했는지?

                if (duplCheckResult) {

//                    써도 되는 숫자니까 출제 숫자에 등록.
                    cpuNumList.add(randomNum)
//                    무한 반복을 깨고 다음 숫자를 뽑으로 이동.
                    break
                }



                if () {

                }

            }
        }

    }


}
