package my.shin.numberbaseballgame_2020062

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    }

    override fun setValues() {

        chatList.add(Chat("CPU","숫자 야구게임에 오신것을 환영합니다."))
        chatList.add(Chat("CPU","세자리 숫자를 맞춰주세요."))
        chatList.add(Chat("CPU","숫자 야구게임에 오신것을 환영합니다."))

        mChatAdapter = ChatAdapter(mContext,R.layout.chat_list_item, chatList)
        chatListView.adapter = mChatAdapter
    }


}
