package com.example.phonecontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.phonecontacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    lateinit var adapter: ContactAdapter
    lateinit var ContactList: MutableList<Contact_kt>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        createContactList();
        adapter = ContactAdapter(ContactList)
        binding.rvContacts.adapter =adapter
    }

    private fun createContactList() {
        ContactList.add(Contact_kt("mahmoud","0111669336",R.drawable.img))
        ContactList.add(Contact_kt("mahmoud","0111669336",R.drawable.img))
        ContactList.add(Contact_kt("mahmoud","0111669336",R.drawable.img))
    }
}