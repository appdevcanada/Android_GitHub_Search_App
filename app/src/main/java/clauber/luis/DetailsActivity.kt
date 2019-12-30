package clauber.luis

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.Toast
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*
import okhttp3.*
import java.io.IOException

/*
* Created by Clauber Ferreira on December 02, 2019
* Created by Luis Souza on December 02, 2019
*/
class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        supportActionBar?.title = intent.getStringExtra(CustomViewHolderClass.TITLE_KEY)

        val data = intent.getSerializableExtra(CustomViewHolderClass.OBJECT_KEY) as User

        // set underline text on TextView control
        val text = data.html_url //"Underlined Text"
        val content = SpannableString(text)
        content.setSpan(UnderlineSpan(), 0, text.length, 0)
        htmlURLTextView.text = content

        htmlURLTextView.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            intent.putExtra(getString(R.string.url_key), data.html_url)
            this.startActivity(intent)
        }

        fetchJson(data.url)
    }

    // Extension function to show toast message
    fun Context.toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun fetchJson(url: String) {

        // We are using okhttp client here, not Retrofit2
        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()

        client.newCall(request).enqueue(object : Callback { // can't execute from main thread!
            override fun onFailure(call: Call, e: IOException) {
                toast("Request Failed!")
            }

            override fun onResponse(call: Call, response: Response) {

                val body = response.body()?.string()

                val gson = GsonBuilder().create()
                val result = gson.fromJson(body, UserDetails::class.java)

                runOnUiThread {
                    Picasso.get().load(result.avatar_url).into(avatarImageView)

                    nameTextView.text = getString(R.string.user_name, result?.name ?: "unknown")
                    locationTextView.text =
                        getString(R.string.location, result?.location ?: "unknown")
                    companyTextView.text = getString(R.string.company, result?.company ?: "unknown")
                    followersTextView.text =
                        getString(R.string.followers, result.followers.toString())
                    publicGistsTextView.text =
                        getString(R.string.publicGists, result.public_gists.toString())
                    publicReposTextView.text =
                        getString(R.string.publicRepos, result.public_repos.toString())
                    lastUpdateTextView.text =
                        getString(R.string.lastUpdate, result.updated_at.substring(0, 10))
                    accountCreatedTextView.text =
                        getString(R.string.accountCreated, result.created_at.substring(0, 10))
                }
            }
        })
    }

}
