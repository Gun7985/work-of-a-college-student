package kr.ac.wku.dailytest_20231028

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import kr.ac.wku.dailytest_20231028.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        로그인 버튼이 눌리면 할 일 설정
        binding.btnLogin.setOnClickListener {

//            EditText에 입력된 값들을 변수에 담기

            val userEmail = binding.edtEmail.text.toString()
            val userPass = binding.edtPass.text.toString()
            val adminEmail = "admin@test.com"
            val adminPass = "qwer"

//            조건문 : 아이디와 비번을 확인하여 코스트 메세지 띄우기
            if (userEmail == adminEmail && userPass == adminPass) {
                Toast.makeText(this, "관리자입니다.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
