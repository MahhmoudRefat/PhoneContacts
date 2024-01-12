package com.example.phonecontacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.phonecontacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var adapter: ContactAdapter
    private var contactlist:MutableList<Contact_kt> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        createContactList()
        adapter = ContactAdapter(contactlist)

        adapter.onContactClickListner =ContactAdapter.OnContactClickListener {
            contact ->  navigateToContactDetailsActivity(contact)
        }
        adapter.onSaveClickListener =ContactAdapter.OnSaveClickListener {
                contact ->  SaveToContact(contact)
        }

       /* adapter.onSaveClickListener = object :ContactAdapter.OnSaveClickListener{
            override fun onSaveClick(contact: Contact_kt) {
                TODO("Not yet implemented")  /* This is anonymous object */
            }
        }*/

        binding.rvContacts.adapter =adapter
    }

    private fun SaveToContact(contact: Contact_kt) {
        binding.etName.text.toString()
        binding.etPhoneNumber.text.toString()
        binding.etDescription.text.toString()
        contactlist.add(Contact_kt(binding.etName.text.toString(),binding.etPhoneNumber.text.toString(),R.drawable.img,binding.etDescription.text.toString()))
    }
    private fun navigateToContactDetailsActivity(contact:Contact_kt) {
        val intent = Intent(this,ContactDetails::class.java)
        intent.putExtra("contact_details",contact)
        startActivity(intent)
    }
    private fun createContactList() {

        contactlist.add(Contact_kt("mahmoud","0111669336",R.drawable.img,""))

    }
}