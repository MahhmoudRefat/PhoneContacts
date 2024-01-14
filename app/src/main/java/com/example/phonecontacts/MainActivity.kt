package com.example.phonecontacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.phonecontacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var name: String
    private lateinit var phoneNum: String
    private lateinit var desc: String
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ContactAdapter
    private var contactlist: MutableList<Contact_kt> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        saveContact()
        //addContact()
    }

    private fun initRecyclerView() {

        adapter = ContactAdapter(contactlist)

        adapter.onContactClickListner = ContactAdapter.OnContactClickListener { contact ->
            navigateToContactDetailsActivity(contact)
        }



        /* adapter.onSaveClickListener = object :ContactAdapter.OnSaveClickListener{
             override fun onSaveClick(contact: Contact_kt) {
                 TODO("Not yet implemented")  /* This is anonymous object */
             }
         }*/

        binding.rvContacts.adapter = adapter
    }

    fun saveContact() {
            binding.btnSaveContact.setOnClickListener {
                desc = binding.etDescription.text.toString()
                if (isValidName() && isValidNumber()) {
                    contactlist.add(Contact_kt(name, phoneNum, R.drawable.img, desc))
                    binding.etName.text?.clear()
                    binding.etPhoneNumber.text?.clear()
                    binding.etDescription.text?.clear()
                    adapter.notifyItemInserted(contactlist.size-1)
                }
            }
    }

    private fun navigateToContactDetailsActivity(contact: Contact_kt) {
        val intent = Intent(this, ContactDetails::class.java)
        intent.putExtra("contact_details", contact)
        startActivity(intent)
    }


    private fun SaveToContact(contact: Contact_kt) {
        /* binding.etName.text.toString()
          binding.etPhoneNumber.text.toString()
          binding.etDescription.text.toString()*/
        contactlist.add(
            Contact_kt(
                binding.etName.text.toString(),
                binding.etPhoneNumber.text.toString(),
                R.drawable.img,
                binding.etDescription.text.toString()
            )
        )
    }
   private fun isValidName(): Boolean{
        name = binding.etName.text.toString()
        return if (name.length < 3) {
           Toast.makeText(this,"Not valid name",Toast.LENGTH_SHORT).show()
            false
        }else {
            true
        }
    }
    private fun isValidNumber(): Boolean{
        phoneNum = binding.etPhoneNumber.text.toString()
        return if (phoneNum.length < 10) {
            Toast.makeText(this,"Not valid number pleases enter a number from 11 number ",Toast.LENGTH_SHORT).show()
            false
        } else {
            true
        }
    }

   /* private fun addContact() {
        binding.apply {
            btnSaveContact.setOnClickListener {
                contactlist.add(
                    Contact_kt(
                        binding.etName.text.toString(),
                        binding.etPhoneNumber.text.toString(),
                        R.drawable.img,
                        binding.etDescription.text.toString()
                    )
                )

            }
        }
    }*/

}


