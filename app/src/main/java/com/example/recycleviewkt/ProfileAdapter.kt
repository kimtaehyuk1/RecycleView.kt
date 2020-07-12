package com.example.recycleviewkt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//메인 액티비티 띄우기 위한 중간 다리역활 adapter
//profileList는 그냥 우리가만든 Profiles(입력 단자들)를 그걸 또 리스트화 시키는 변수임 , 또 코틀린에서 class옆에 : 는 상속개념
//: 옆에있는건 그 기능을 쓰겠다는 형식임
//처음에 RecyclerView치면 빨간색 떠서 알트 엔터눌러서 add dependency어쩌구 누러서 build.gradle(사용가능하게 다운받았는지 보는창?)
class ProfileAdapter(val profileList: ArrayList<Profiles>) : RecyclerView.Adapter<ProfileAdapter.CustomViewHolder>() //customviewhold는 우리가 만든 변수이름
{                                                                                          //RecyclerView.Adapter<a.b> a클래스와b클래스 연결 해주는 함수=내용이랑 뷰연결
    //!!!!!!!!!!!!!!!!일단 메인동작 이해해야되는데 1. 밑에 미리 생성해둔 list_item 를 붙임
    //                                          2.  cutomviewhold에서 findid로 변수들에게 할당 = bindviewhold에서 써먹을라고
    //                                          3. bindview에서 써머금
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileAdapter.CustomViewHolder {
        //이 함수는 main에서 oncreat있어 xml연결한거 처럼 여기서도 플러그로 연결된 화면이 먼가..미리 만들어준 화면 붙이기
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent,false)  // view는 그냥 미리 만든  list_item뷰를 메인에 붙인다 생각
        return CustomViewHolder(view) //뷰에서 받은 정보를 홀드시켜줌 id 다 가지고오면서
    }


    override fun getItemCount(): Int {
        return profileList.size
    }

    override fun onBindViewHolder(holder: ProfileAdapter.CustomViewHolder, position: Int) {
        //실제 연결부분 리스트뷰같은거  계속 사용할때 안정적으로 데이터 매치시켜주는 곳
        holder.gender.setImageResource(profileList.get(position).gender) //현재 바인드 위치나 클릭 위치가 포지션됨
        holder.name.text = profileList.get(position).name
        holder.age.text = profileList.get(position).age.toString()
        holder.job.text = profileList.get(position).job


    }
                    //아이디만가고 바인드뷰에서 내용은 바꾼다생각
    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) { //내부 class 뷰에대한거 잡아주는 역활 이따 뷰연결해줄때 쓸거임
        val gender = itemView.findViewById<ImageView>(R.id.iv_profile) //findViewById<>속성의 ()위치에있는 아이디를 가져온다
        val name = itemView.findViewById<TextView>(R.id.tv_name)
        val age = itemView.findViewById<TextView>(R.id.tv_age)
        val job = itemView.findViewById<TextView>(R.id.tv_job)
    }

}