package clauber.luis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_about.*
import kotlinx.android.synthetic.main.activity_details.*

/*
* Created by Luis Souza on December 01, 2019
*/
class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        txtProjectNameAndVersion.text =
            getString(R.string.app_version, getString(R.string.app_name))
        txtEmail.text = getString(
            R.string.email,
            getString(R.string.email_luis)
        )
        txtSite.text = getString(
            R.string.site,
            getString(R.string.site_luis)
        )
    }
}
