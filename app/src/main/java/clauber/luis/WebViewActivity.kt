package clauber.luis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_web_view.*

/*
* Created by Luis Souza on November 30, 2019
*/
class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val url = intent.getStringExtra(getString(R.string.url_key))

        webViewGitHub.settings.javaScriptEnabled
        webViewGitHub.settings.loadWithOverviewMode
        webViewGitHub.settings.useWideViewPort

        webViewGitHub.loadUrl(url)
    }
}
