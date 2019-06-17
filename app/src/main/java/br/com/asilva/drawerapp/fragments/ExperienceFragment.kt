package br.com.asilva.drawerapp.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.asilva.drawerapp.R
import br.com.asilva.drawerapp.models.User
import kotlinx.android.synthetic.main.fragment_experience.*
import kotlinx.android.synthetic.main.fragment_formation.*

/**
 * A simple [Fragment] subclass.
 * Author Alexander Silva
 */
class ExperienceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_experience, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments
        if (args != null){
            textExperience.text = args.getString(ExperienceFragment.EXPERIENCE)
        }
    }

    companion object {
        val EXPERIENCE = "experience"
        fun newInstance(user: User):ExperienceFragment{
            val experienceFragment = ExperienceFragment()
            experienceFragment.arguments = Bundle().apply {
                putString(EXPERIENCE, user.experience)
            }
            return experienceFragment
        }
    }
}