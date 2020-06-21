package my.shin.numberbaseballgame_2020062

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import my.shin.numberbaseballgame_2020062.adapters.ChatAdapter
import my.shin.numberbaseballgame_2020062.datas.Chat

class MainActivity : BaseActivity() {

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


        }

    }

    override fun setValues() {

        chatList.add(Chat("CPU","숫자 야구게임에 오신것을 환영합니다."))
        chatList.add(Chat("CPU","세자리 숫자를 맞춰주세요."))
        chatList.add(Chat("CPU","숫자 야구게임에 오신것을 환영합니다."))

        mChatAdapter = ChatAdapter(mContext,R.layout.chat_list_item, chatList)
        chatListView.adapter = mChatAdapter
    }


}
