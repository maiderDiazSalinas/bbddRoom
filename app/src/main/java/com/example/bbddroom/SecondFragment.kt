package com.example.bbddroom

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bInsertar=view.findViewById<Button>(R.id.frag2_bInsertar)
        val bBorrar=view.findViewById<Button>(R.id.frag2_bBorrar)
        val bModificar=view.findViewById<Button>(R.id.frag2_bModificar)
        val etPalabra=view.findViewById<EditText>(R.id.frag2_etPalabra)
        val tvId=view.findViewById<TextView>(R.id.frag2_tvId)
        val id:Long?=arguments?.getLong("id")
        Toast.makeText(activity, id.toString(),Toast.LENGTH_SHORT).show()

        if(id==null){
            bBorrar.isEnabled=false
            bModificar.isEnabled=false
            bInsertar.isEnabled=true
        }
        else{
            bBorrar.isEnabled=true
            bModificar.isEnabled=true
            bInsertar.isEnabled=false
            (activity as MainActivity).miViewModel.BuscarPorId(id)
            (activity as MainActivity).miViewModel.miPalabra.observe(requireActivity()){
                tvId.text=String.format("ID: ${it?.id}")
                etPalabra.setText(it?.palabra)
            }

        }

        bInsertar.setOnClickListener {
            if(etPalabra.text.isEmpty()) Toast.makeText(activity,"Tienes que insertar una palabra",Toast.LENGTH_SHORT).show()
            else{
                (activity as MainActivity).miViewModel.Insertar(Palabra(palabra=etPalabra.text.toString()))
                (activity as MainActivity).navHost.navController.navigate(R.id.action_SecondFragment_to_FirstFragment)
            }

        }

    }
}