package com.example.pratice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = findViewById<EditText>(R.id.EMaildET)
        email.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s!!.contains(" ")){
                    email.setError("請勿輸入空白字元")
                }else if(!Patterns.EMAIL_ADDRESS.matcher(s.toString()).matches()){
                    email.setError("不符合E-MAIL格式")
                }else{
                    email.setError(null)
                }
            }
            override fun afterTextChanged(s: Editable?) {

            }
        })

        val pwd = findViewById<EditText>(R.id.PasswordET)
        pwd.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s!!.length <= 6){
                    pwd.error = "密碼長度需大於六"
                }else if(!Pattern.matches("^[a-zA-Z0-9]+$",s)){
                    pwd.error = "密碼僅能為英文字母或數字"
                }else{
                    pwd.error = null
                }
            }
            override fun afterTextChanged(s: Editable?) {
            }

        })

        val register = findViewById<TextView>(R.id.RegisterTV)
        register.setOnClickListener {
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }

        val login = findViewById<Button>(R.id.LoginBtn)
        login.setOnClickListener {
            val intent = Intent(this,SplashActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}