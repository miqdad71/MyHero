package com.miqdad71.myhero

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.miqdad71.myhero.Data.Hero

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.hide()

        val hero = intent.getParcelableExtra<Hero>(MainActivity.INTENT_PARCELABLE)

        val imgDetail : ImageView = findViewById(R.id.img_detail_page)
        val detailName : TextView = findViewById(R.id.tv_name_detail)
        val detailTimes : TextView = findViewById(R.id.tv_time_detail)
        val detailDesc : TextView = findViewById(R.id.desc_detail_page)
        val shareInfo : Button = findViewById(R.id.shareInfo)

        if (hero != null) {
            imgDetail.setImageResource(hero.photo)
            detailName.text = hero.name
            detailTimes.text = hero.times
            detailDesc.text = hero.detail

            shareInfo.setOnClickListener{
               /* val mUriIntent = Uri.parse("geo:0,0?q=${detailName.text.toString() + " " + detailTimes.text.toString()}")
                val mMapIntent = Intent(Intent.ACTION_VIEW, mUriIntent)
                mMapIntent.setPackage("com.google.android.apps.maps")
                startActivity(mMapIntent)*/
            }
        }

    }
}