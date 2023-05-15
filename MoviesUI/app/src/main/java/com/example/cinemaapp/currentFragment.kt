package com.example.cinemaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide

private const val ARG_TITLE = "title"
private const val ARG_IMAGE = "image"
private const val ARG_RATE = "rate"
private const val ARG_ABOUT = "about"


class currentFragment : Fragment() {
    private var title: String? = null
    private var image: String? = null
    private var rate: Float? = null
    private var about: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(ARG_TITLE)
            image = it.getString(ARG_IMAGE)
            rate = it.getFloat(ARG_RATE)
            about = it.getString(ARG_ABOUT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_now_showing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<TextView>(R.id.film_title).text = title
        view.findViewById<TextView>(R.id.film_rate).text = "Оценка: $rate"
        view.findViewById<TextView>(R.id.film_about).text = about
        Glide
            .with(this)
            .load(image)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(view.findViewById(R.id.film_image))
    }

    companion object {
        @JvmStatic
        fun newInstance(title: String, image: String, rate: Float, about: String) =
            currentFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_TITLE, title)
                    putString(ARG_IMAGE, image)
                    putFloat(ARG_RATE, rate)
                    putString(ARG_ABOUT, about)
                }
            }
    }
}