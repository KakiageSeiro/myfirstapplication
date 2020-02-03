package com.example.myfirstapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class TopFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //最初の画面を定義
        val view = inflater.inflate(R.layout.fragment_top2, container, false)

        //最初に作ったfragment_top（２じゃない方）を使うとき用のボタン設定
//        //IDがloginの部品を取得
//        val button = view.findViewById<Button>(R.id.login)
//        button.setOnClickListener { println("■■■ろぐいん■■■") }

        //次の画面へボタンクリックイベントリスナ
        val b = view.findViewById<Button>(R.id.nextView)
        b.setOnClickListener{
            //次の画面へ遷移する矢印（nav_main.xmlのDesignタブで作成した矢印のこと）
            //レシーバはit
            Navigation.findNavController(it).navigate(R.id.action_topFragment_to_detailFragment)
        }

        return view
    }
}