package com.example.recycleviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
                //arrayListOf는 리스트 형태의 객체를 계속 넣어줌
        val profileList = arrayListOf(
            Profiles(R.drawable.man, "김배흑1", 23,"앱 개발자1"),
            Profiles(R.drawable.woman, "김배흑2", 24,"앱 개발자2"),
            Profiles(R.drawable.man, "김배흑3", 25,"앱 개발자3"),
            Profiles(R.drawable.woman, "김배흑4", 26,"앱 개발자4"),
            Profiles(R.drawable.man, "김배흑5", 27,"앱 개발자5"),
            Profiles(R.drawable.woman, "김배흑6", 28,"앱 개발자6"),
            Profiles(R.drawable.man, "김배흑7", 29,"앱 개발자7"),
            Profiles(R.drawable.woman, "김배흑8", 30,"앱 개발자8"),
            Profiles(R.drawable.man, "김배흑9", 31,"앱 개발자9"),
            Profiles(R.drawable.woman, "김배흑10", 32,"앱 개발자10")
        )
           //레이아웃매니저는 rv에서 연결해줘야하는 친구 //세로방향으로 리스트 해주세요
        rv_profile.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        rv_profile.setHasFixedSize(true) //리사이클뷰에관한 성능개선 방향

        rv_profile.adapter = ProfileAdapter(profileList)

    }
}