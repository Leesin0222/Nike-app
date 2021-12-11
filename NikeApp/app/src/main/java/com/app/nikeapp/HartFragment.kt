package com.app.nikeapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.Fragment

class HartFragment:Fragment() {
    private lateinit var HartFragement: WebView

    companion object {
        fun newInstance() : HartFragment{
            return HartFragment()
        }
    }
    //프레그먼트와 레이아웃을 연결시켜주는 부분이다
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_hart, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        HartFragement = view.findViewById(R.id.webview2)
        HartFragement.webViewClient = WebViewClient()
        HartFragement.loadUrl("https://www.nike.com/kr/ko_kr/cart")
        val text = "막 담으세요! 더 채우세요!"
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(context, text, duration)
        toast.show()
    }
}