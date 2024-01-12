package com.example.phonecontacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(val items: List<Contact_kt>) :
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val acount_name: TextView = itemView.findViewById(R.id.tv_name)
        val acount_phone: TextView = itemView.findViewById(R.id.tv_phone)
        val post_image: ImageView = itemView.findViewById(R.id.contact_image_)
      //  val saveContact: Button = itemView.findViewById(R.id.btn_saveContact)

    }
    override fun getItemCount(): Int = items.size ?: 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = items?.get(position)
        if (contact != null) {
            holder.post_image.setImageResource(contact?.imageId ?: R.drawable.img)
            holder.acount_name.text = contact?.name
            holder.acount_phone.text = contact?.phoneNumber
        }
        if (onContactClickListner != null ) {
            holder.itemView.setOnClickListener {
                if (contact != null) {
                    onContactClickListner?.onContactClick(contact)
                }
            }
        }
     /*   if (onSaveClickListener != null ) {
            holder.saveContact.setOnClickListener {
                if (contact != null) {
                    onSaveClickListener?.onSaveClick(contact) // this is the function calling
                    //here is the good place to know witch  item is clicked
                }
            }
        }*/
    }
     var onContactClickListner:OnContactClickListener?=null
    // var onSaveClickListener:OnSaveClickListener?=null // the delegate -> where the adapter could call the main activity


    fun interface OnContactClickListener{
        fun onContactClick(contact:Contact_kt )
    }
  /*  fun interface OnSaveClickListener{
        fun onSaveClick(contact:Contact_kt ) // the main is the implemntaion
    }*/


}