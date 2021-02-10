package com.example.bbddroom

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView

class Adaptador(private val listaPalabras: List<Palabra>, val actividad: Activity) : RecyclerView.Adapter<Adaptador.miViewHolder>(){
    inner class miViewHolder(view: View) : RecyclerView.ViewHolder(view) , View.OnClickListener{
        lateinit private var miItem: Palabra
        var nombre: TextView = view.findViewById<View>(R.id.item_tvPalabra) as TextView
        var id: TextView = view.findViewById<View>(R.id.item_tvID) as TextView

        init {
            view.setOnClickListener(this)
        }

        fun setItem(miPalabra: Palabra) {
            miItem = miPalabra
            nombre.text = miPalabra.palabra
            id.text = miPalabra.id.toString()
        }

        override fun onClick(view: View) {
            val bundle= bundleOf("id" to this.id.text.toString().toLong())
            (actividad as MainActivity).navHost.navController.navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): miViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return miViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: miViewHolder, position: Int) {
        val movie = listaPalabras[position]
        holder.setItem(movie)
    }

    override fun getItemCount(): Int {
        return listaPalabras.size
    }
}