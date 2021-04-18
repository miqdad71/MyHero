package com.miqdad71.myhero

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ismaeldivita.chipnavigation.ChipNavigationBar

class AboutMeActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)
        supportActionBar?.hide()

        val btnEmailB = findViewById<ImageView>(R.id.btn_email_b)
        btnEmailB.setOnClickListener(this)
        val btnEmailText = findViewById<TextView>(R.id.email_text)
        btnEmailText.setOnClickListener(this)

        val btnIGB = findViewById<ImageView>(R.id.btn_ig_b)
        btnIGB.setOnClickListener(this)
        val btnIGText = findViewById<TextView>(R.id.ig_text)
        btnIGText.setOnClickListener(this)

        val btnWaB = findViewById<ImageView>(R.id.btn_whatsapp_b)
        btnWaB.setOnClickListener(this)
        val btnWaText = findViewById<TextView>(R.id.wa_text)
        btnWaText.setOnClickListener(this)

        val btnGithub = findViewById<ImageView>(R.id.btn_github_b)
        btnGithub.setOnClickListener(this)
        val btnGithubText = findViewById<TextView>(R.id.github_text)
        btnGithubText.setOnClickListener(this)

//Navigation Bottom
        val bottomNavigation: ChipNavigationBar = findViewById(R.id.bottom_nav_test)
        bottomNavigation.setItemSelected(R.id.iAboutMe)
        bottomNavigation.setOnItemSelectedListener {
            when (it) {
                R.id.iHero -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finishAffinity()
                }
                R.id.iAboutMe -> {
                    val intent = Intent(this, AboutMeActivity::class.java)
                    startActivity(intent)
                    finishAffinity()
                }

            }
        }
//Navigation Bottom
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_email_b, R.id.email_text -> {
                val intent = Intent(Intent.ACTION_SEND)
                intent.data = Uri.parse("Email")
                intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("miqdad.ihbs71777@gmail.com"))
                intent.putExtra(Intent.EXTRA_SUBJECT, "User Pahlawan Ku")
                intent.putExtra(Intent.EXTRA_TEXT, "Hi Miqdad. \nSaya User Pahlawan Ku")
                intent.type = "message/rfc822"
                startActivity(intent)
            }

            R.id.btn_whatsapp_b, R.id.wa_text -> {
                val webWhatsApp =
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://api.whatsapp.com/send?phone=+6281298056468&text=Hai Miqdad!%0ASaya User Pahlawan Ku.")
                    )
                startActivity(webWhatsApp)
            }

            R.id.btn_ig_b, R.id.ig_text -> {
                val webIG = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/miqdad_aja7/")
                )
                startActivity(webIG)
            }

            R.id.btn_github_b, R.id.github_text -> {
                val webGithub = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://github.com/miqdad71")
                )
                startActivity(webGithub)
            }
        }
    }
}