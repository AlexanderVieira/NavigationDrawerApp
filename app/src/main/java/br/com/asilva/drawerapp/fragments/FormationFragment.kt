package br.com.asilva.drawerapp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.asilva.drawerapp.R
import br.com.asilva.drawerapp.models.User
import kotlinx.android.synthetic.main.fragment_formation.*

/**
 * A simple [Fragment] subclass.
 *Author Alexander Silva
 */
class FormationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_formation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments
        if (args != null){
            textFormation.text = args.getString(FormationFragment.FORMATION)
        }
    }

    companion object {
        val FORMATION = "formation"
        fun newInstance(user: User):FormationFragment{
            val formationFrag = FormationFragment()
            formationFrag.arguments = Bundle().apply {
                putString(FORMATION, user.formation)
            }
            return formationFrag
        }
    }

}
