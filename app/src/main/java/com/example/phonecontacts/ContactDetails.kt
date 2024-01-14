package com.example.phonecontacts

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build.VERSION.SDK_INT
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import com.example.phonecontacts.databinding.ActivityContactDetailsBinding

class ContactDetails : AppCompatActivity() {
    lateinit var binding:ActivityContactDetailsBinding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

     val contact = intent.parcelable<Contact_kt>("contact_details")
        contact?.let{  contact ->binding.tvNameDetails.text=contact.name
            binding.tvPhoneDetails.text=contact.phoneNumber
            binding.tvDescriptionDetails.text=contact.description

           // binding.contactImage.setImageResource(contact.imageId ?: R.drawable.img)
        }


    }
}
inline fun <reified T : Parcelable> Intent.parcelable(key: String): T? = when {
    SDK_INT >= 33 -> getParcelableExtra(key, T::class.java)
    else -> @Suppress("DEPRECATION") getParcelableExtra(key) as? T
}