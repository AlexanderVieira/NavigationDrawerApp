package br.com.asilva.drawerapp.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.asilva.drawerapp.R
import br.com.asilva.drawerapp.models.User
import kotlinx.android.synthetic.main.fragment_formation.*
import kotlinx.android.synthetic.main.fragment_publication.*

/**
 * A simple [Fragment] subclass.
 * Author Alexander Silva
 */
class PublicationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_publication, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments
        if (args != null){
            textPublication.text = args.getString(PublicationFragment.PUBLICATION)
        }
    }

    companion object {
        val PUBLICATION = "publication"
        fun newInstance(user: User):PublicationFragment{
            val publicationFragment = PublicationFragment()
            publicationFragment.arguments = Bundle().apply {
                putString(PUBLICATION, user.publication)
            }
            return publicationFragment
        }
    }
}
