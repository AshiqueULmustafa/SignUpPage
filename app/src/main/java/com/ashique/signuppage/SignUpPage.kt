package com.ashique.signuppage


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SignUpPage : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_page)

        val etfname = findViewById<EditText>(R.id.etFname)
        val tvfname = findViewById<TextView>(R.id.missfname)
        val etlname = findViewById<EditText>(R.id.etLname)
        val tvlname = findViewById<TextView>(R.id.misslname)
        val etdob = findViewById<EditText>(R.id.etDOB)
        val tvdob = findViewById<TextView>(R.id.missdob)
        val etemail = findViewById<EditText>(R.id.etEmail)
        val tvemail = findViewById<TextView>(R.id.missemail)
        val etaddress = findViewById<EditText>(R.id.etAddress)
        val tvaddress = findViewById<TextView>(R.id.missaddress)
        val etpassword = findViewById<EditText>(R.id.etPass)
        val tvpass = findViewById<TextView>(R.id.misspass)
        val etphone = findViewById<EditText>(R.id.etPhone)
        val tvphone = findViewById<TextView>(R.id.missphone)
        val etconfirmPass = findViewById<EditText>(R.id.etCpass)
        val tvcpass = findViewById<TextView>(R.id.misscpass)
        val tvmissmatch = findViewById<TextView>(R.id.missmatchpass)
        val btnsubmit: Button = findViewById(R.id.btnSubmit)
        val badPass: TextView = findViewById(R.id.tvBadPass)



        etpassword.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                tvpass.visibility = View.GONE
                badPass.visibility = View.VISIBLE
            } else {
                badPass.visibility = View.GONE
            }
        }


        btnsubmit.setOnClickListener {

            val fields = mapOf(
                etfname to tvfname,
                etlname to tvlname,
                etdob to tvdob,
                etaddress to tvaddress,
                etemail to tvemail,
                etphone to tvphone,
                etconfirmPass to tvcpass
            )
            fields.forEach{ (editText, textview)->
                val fieldvalue = editText.toString().trim()
                if(fieldvalue.isEmpty()){
                    textview.visibility = View.VISIBLE
                }
                else {
                    textview.visibility = View.GONE
                }

            }


//                if(fname.isEmpty()){
//                    tvfname.visibility = View.VISIBLE
//                }
//                if(lname.isEmpty()){
//                    tvlname.visibility = View.VISIBLE
//                }
//                if(dob.isEmpty()){
//                    tvdob.visibility = View.VISIBLE
//                }
//                if(email.isEmpty()){
//                    tvemail.visibility = View.VISIBLE
//                }


            val password = etpassword.toString().trim()
            val confirmpass = etconfirmPass.toString().trim()

            if (password.isEmpty()) {
                tvpass.visibility = View.VISIBLE
            } else {
                tvpass.visibility = View.GONE
            }

            if (confirmpass.isEmpty()) {
                tvcpass.visibility = View.VISIBLE
            } else if (password != confirmpass) {
                tvmissmatch.visibility = View.VISIBLE
            } else {
                tvmissmatch.visibility = View.GONE
            }


//            val field = listOf(fname, lname, etdob, etemail,etphone, etpassword, etconfirmpass)
//            val isAnyFieldEmpty: Boolean = field.any { it.isEmpty() }
//            if (isAnyFieldEmpty
//            ) {
//                Toast.makeText(
//                    this@SignUpPage,
//                    "Please Complete All The Information",
//                    Toast.LENGTH_SHORT
//                ).show()
//            } else {
//                btnsubmit.setBackgroundColor(Color.CYAN)
//                Toast.makeText(this@SignUpPage, "Your Data is Accepted", Toast.LENGTH_LONG).show()
//
//            }
        }


    }
}