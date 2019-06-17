package br.com.asilva.drawerapp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.asilva.drawerapp.R
import br.com.asilva.drawerapp.models.User
import kotlinx.android.synthetic.main.fragment_user_info.*

/**
 * A simple [Fragment] subclass.
 * Author Alexander Silva
 */
class UserInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments
        if (args != null){
            textName.text = args.getString(NAME)
            textIdade.text = args.getString(AGE) + " anos"
            textDataNasc.text = args.getString(BIRTHDAY)
            textStateCivil.text = args.getString(STATE_CIVIL)
            textPhone.text = args.getString(PHONE)
        }
    }

    companion object {
        val NAME = "name"
        val AGE = "age"
        val BIRTHDAY = "birthday"
        val STATE_CIVIL = "state_civil"
        val PHONE = "phone"
        /*val FORMATION = "formation"
        val EXPERIENCE = "experience"
        val COURSE = "course"
        val PUBLICATION = "publication"*/

        fun newInstance(user: User):UserInfoFragment{
            val userInfoFrag = UserInfoFragment()
            userInfoFrag.arguments = Bundle().apply {
                putString(NAME, user.name)
                putString(AGE, user.age.toString())
                putString(BIRTHDAY, user.barthday)
                putString(STATE_CIVIL, user.stateCivil)
                putString(PHONE, user.phone)
                /*putString(FORMATION, user.formation)
                putString(EXPERIENCE, user.experience)
                putString(COURSE, user.course)
                putString(PUBLICATION, user.publication)*/
            }
            return userInfoFrag
        }
    }
}
