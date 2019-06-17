package br.com.asilva.drawerapp.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.asilva.drawerapp.R
import br.com.asilva.drawerapp.models.User
import kotlinx.android.synthetic.main.fragment_course.*
import kotlinx.android.synthetic.main.fragment_formation.*

/**
 * A simple [Fragment] subclass.
 * Author Alexander Silva
 */
class CourseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_course, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments
        if (args != null){
            textCourse.text = args.getString(CourseFragment.COURSE)
        }
    }

    companion object {
        val COURSE = "course"
        fun newInstance(user: User):CourseFragment{
            val courseFragment = CourseFragment()
            courseFragment.arguments = Bundle().apply {
                putString(COURSE, user.course)
            }
            return courseFragment
        }
    }
}
