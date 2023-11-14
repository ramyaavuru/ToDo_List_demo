package com.example.todo_list_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val mList: MutableList<ItemsViewModel>, private val context: Context) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.reclerview_items_adapter, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]
        holder.textView.text = ItemsViewModel.name
        holder.textView1.text = ItemsViewModel.price


        holder.deleteButton.setOnClickListener {
            lateinit var inputEditTextField: EditText
            inputEditTextField= EditText(context)
            val dialog = AlertDialog.Builder(context)
                .setTitle("Delete Item")
                .setMessage("")
                .setView(inputEditTextField)
                .setPositiveButton("yes") { dialogInterface, i ->
                    mList.removeAt(position)
                    notifyDataSetChanged()
                }
                .setNegativeButton("No") { dialogInterface, i -> }
                .create()
            dialog.show() }

        holder.addButton.setOnClickListener {
            lateinit var inputEditTextField: EditText
            inputEditTextField= EditText(context)
            val dialog = AlertDialog.Builder(context)
                .setTitle("Add Item")
                .setMessage("")
                .setView(inputEditTextField)
                .setPositiveButton("OK") { dialogInterface, i ->
                    val editTextInput = inputEditTextField.text.toString()
                    mList.add(ItemsViewModel(editTextInput,"100"))
                   notifyDataSetChanged();
                    // Log.d("onClick", "EditText value is: $editTextInput")
                }
                .setNegativeButton("Cancel") { dialogInterface, i -> }
                .create()
            dialog.show() }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView1: TextView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)
        val addButton: Button =itemView.findViewById(R.id.add_product)
        val deleteButton: Button =itemView.findViewById(R.id.delete_product)
    }
}
