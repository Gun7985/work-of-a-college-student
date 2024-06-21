package com.example.firebasetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.firebasetest.databinding.ActivityAuthBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider

class AuthActivity : AppCompatActivity() {
    lateinit var binding: ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (MyApplication.checkAuth()){
            changeVisibility("login")
        }else{
            changeVisibility("logout")
        }

        val requestLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult())
        {
            //구글 로그인 결과 처리
            val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
            try {
                val account = task.getResult(ApiException::class.java)!!
                val credential = GoogleAuthProvider.getCredential(account.idToken, null)
                MyApplication.auth.signInWithCredential(credential)
                    .addOnCompleteListener(this){ task ->
                        if (task.isSuccessful){
                            MyApplication.email = account.email
                            changeVisibility("login")
                        }else {
                            changeVisibility("logout")
                        }
                    }
            }catch (e: ApiException){
                changeVisibility("logout")
            }
        }

        binding.logoutBtn.setOnClickListener {
            //로그아웃
            MyApplication.auth.signOut()
            MyApplication.email = null
            changeVisibility("logout")
        }

        binding.goSignInBtn.setOnClickListener {
            changeVisibility("signin")
        }

        binding.googleLoginBtn.setOnClickListener {
            //구글 로그인
            val gso = GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
            val signInIntent = GoogleSignIn.getClient(this, gso).signInIntent
            requestLauncher.launch(signInIntent)
        }

        binding.signBtn.setOnClickListener {
            //이메일, 비밀번호 회원가입
            val email = binding.authEmailEdtView.text.toString()
            val password = binding.authPasswordEditView.text.toString()
            MyApplication.auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    binding.authEmailEdtView.text.clear()
                    binding.authPasswordEditView.text.clear()
                    if (task.isSuccessful){
                        MyApplication.auth.currentUser?.sendEmailVerification()
                            ?.addOnCompleteListener { sendTask ->
                                if (sendTask.isSuccessful) {
                                    Toast.makeText(
                                        baseContext,
                                        "회원가입 성공, 전송된 메일을 확인해 주세요",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    changeVisibility("logout")
                                }else{
                                    Toast.makeText(baseContext, "메일 발송 실패", Toast.LENGTH_SHORT).show()
                                    changeVisibility("logout")
                                }
                            }
                    }else{
                        Toast.makeText(baseContext, "회원가입 실패", Toast.LENGTH_SHORT).show()
                        changeVisibility("logout")
                    }
                }
        }

        binding.loginBtn.setOnClickListener {
            //이메일 비밀번호 로그인
            val email = binding.authEmailEdtView.text.toString()
            val password = binding.authPasswordEditView.text.toString()
            Log.d("kkang","email:$email, password:$password")
            MyApplication.auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    binding.authEmailEdtView.text.clear()
                    binding.authPasswordEditView.text.clear()
                    if (task.isSuccessful){
                        if (MyApplication.checkAuth()){
                            MyApplication.email = email
                            changeVisibility("logout")
                        }else{
                            Toast.makeText(baseContext, "전송된 메일로 이메일 인증이 되지 않았습니다.", Toast.LENGTH_SHORT).show()
                        }
                    }else{
                        Toast.makeText(baseContext, "로그인 실패", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

    fun changeVisibility(mode: String) {
        if (mode === "login") {
            binding.run {
                authMainTextView.text = "${MyApplication.email} 님 반갑습니다."
                loginBtn.visibility = View.VISIBLE
                goSignInBtn.visibility = View.GONE
                googleLoginBtn.visibility = View.GONE
                authEmailEdtView.visibility = View.GONE
                authPasswordEditView.visibility = View.GONE
                signBtn.visibility = View.GONE
                loginBtn.visibility = View.GONE
            }
        } else if (mode === "logout") {
            binding.run {
                authMainTextView.text = "로그인 하거나 회원가입 해주세요."
                loginBtn.visibility = View.GONE
                goSignInBtn.visibility = View.VISIBLE
                googleLoginBtn.visibility = View.VISIBLE
                authEmailEdtView.visibility = View.VISIBLE
                authPasswordEditView.visibility = View.VISIBLE
                signBtn.visibility = View.GONE
                loginBtn.visibility = View.VISIBLE
            }
        } else if (mode === "signin") {
            binding.run {
                loginBtn.visibility = View.GONE
                goSignInBtn.visibility = View.GONE
                googleLoginBtn.visibility = View.GONE
                authEmailEdtView.visibility = View.VISIBLE
                authPasswordEditView.visibility = View.VISIBLE
                signBtn.visibility = View.VISIBLE
                loginBtn.visibility = View.GONE
            }
        }
    }
}