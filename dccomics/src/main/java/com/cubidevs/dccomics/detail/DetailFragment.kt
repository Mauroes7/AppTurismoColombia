package com.cubidevs.dccomics.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.cubidevs.dccomics.databinding.FragmentDetailBinding
import com.cubidevs.dccomics.main.MainActivity
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.showIcon()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)

        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val superheroe = args.superheroe

        with(detailBinding){
            tituloTextView.text = superheroe.name
            descripcionTextview.text = superheroe.alias
            nombreTextview.text = superheroe.city
            alturaTextview.text = superheroe.occupation
            timeTextview.text = superheroe.height.toString()
            com.squareup.picasso.Picasso.get().load(superheroe.urlPicture).into(pictureImageView)

            mapButton.setOnClickListener {
                findNavController().navigate(DetailFragmentDirections.actionNavigationDetailToMapsFragment(superheroeItem=superheroe))
            }
        }
    }
}