package com.example.phonecontacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(val items: List<Contact_kt>) :
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val acount_name: TextView = itemView.findViewById(R.id.tv_name)
        val acount_phone: TextView = itemView.findViewById(R.id.tv_phone)
        val post_image: ImageView = itemView.findViewById(R.id.contact_image_)
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
    }

}