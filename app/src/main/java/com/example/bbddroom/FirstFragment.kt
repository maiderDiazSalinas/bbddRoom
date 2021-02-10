package com.example.bbddroom

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var misPalabras:List<Palabra> = listOf()
        val miListaPalabras=(activity as MainActivity).miViewModel.allWords
        miListaPalabras.observe(activity as MainActivity, Observer { Palabra ->
            // Update the cached copy of the words in the adapter.
            Palabra?.let { misPalabras=it }
        })

        if(misPalabras.size==0){
            view.findViewById<TextView>(R.id.frag1_texto).visibility=View.VISIBLE
            view.findViewById<RecyclerView>(R.id.frag1_recyclerView).visibility=View.GONE
        }
        else{
            view.findViewById<TextView>(R.id.frag1_texto).visibility=View.GONE
            view.findViewById<RecyclerView>(R.id.frag1_recyclerView).visibility=View.VISIBLE
            val recyclerView = view.findViewById<RecyclerView>(R.id.frag1_recyclerView)
            val adapter = Adaptador(misPalabras,activity as MainActivity)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(activity)

        }

        view.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            (activity as MainActivity).navHost.navController.navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

    }
}