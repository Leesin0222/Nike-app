package com.app.nikeapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.Fragment

class HomeFragment:Fragment() {
    private lateinit var HomeFragment: WebView

    companion object {
        fun newInstance() : HomeFragment{
            return HomeFragment()
        }
    }
    //프레그먼트와 레이아웃을 연결시켜주는 부분이다
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        HomeFragment = view.findViewById(R.id.webview1)
        HomeFragment.webViewClient = WebViewClient()
        HomeFragment.loadUrl("https://www.nike.com/kr/ko_kr/")
        val text = "홈에 오셧군요!"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(context, text, duration)
        toast.show()
    }
}

