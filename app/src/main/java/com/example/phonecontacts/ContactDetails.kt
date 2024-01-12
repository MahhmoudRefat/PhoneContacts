package com.example.phonecontacts

import android.content.Intent
import android.os.Build.VERSION.SDK_INT
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import com.example.phonecontacts.databinding.ActivityContactDetailsBinding

class ContactDetails : AppCompatActivity() {
    lateinit var binding:ActivityContactDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

     val contact = intent.parcelable<Contact_kt>("contact_details")
        contact?.let{  contact ->binding.tvName.text=contact.name
            binding.tvPhone.text=contact.phoneNumber
           // binding.contactImage.setImageResource(contact.imageId ?: R.drawable.img)
        }


    }
}
inline fun <reified T : Parcelable> Intent.parcelable(key: String): T? = when {
    SDK_INT >= 33 -> getParcelableExtra(key, T::class.java)
    else -> @Suppress("DEPRECATION") getParcelableExtra(key) as? T
}