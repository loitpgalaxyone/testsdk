package com.example.testsdkgravty

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.gravty.sdk.GravtyRequest
import com.gravty.sdk.models.MemberResponse
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
    }

    private fun logD(s: String) {
        Log.d("loitpp", s)
    }

    private fun logD(a: Any?) {
        Log.d("loitpp", Gson().toJson(a))
    }

    private fun setupViews() {
        findViewById<Button>(R.id.btLogin).setOnClickListener {
            logD("Click")
            GravtyRequest.login(
                "123456789", "123456789",
                object : GravtyRequest.Callback<MemberResponse?> {
                    override fun onResponse(response: Response<MemberResponse?>) {
                        logD("onResponse $response")
                        logD(response.errorBody())
                        if (response.isSuccessful) {
                            val memberResponse: MemberResponse? = response.body()
                            logD(">>>memberResponse $memberResponse")
                        }
                    }

                    override fun onFailure(t: Throwable) {
                        logD("onFailure $t")
                    }
                }
            )
        }
    }
}
