package com.example.nippon.view.login

import android.R
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.nippon.base.BaseFragment
import com.example.nippon.databinding.LoginFragmentBinding


class LoginFragment : BaseFragment() {
    private lateinit var loginFragmentBinding: LoginFragmentBinding
    private val model: LoginViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginFragmentBinding = LoginFragmentBinding.inflate(inflater)

        mSetCreateAccountText()
        mSetTermsAndConditionAndPrivacyPolicy()
        observeViewModel()
        mSpinnerSet()
        //Login Button clicked
        loginFragmentBinding.loginBtn.setOnClickListener {
            val enteredEmail = loginFragmentBinding.email.text.toString()
            val enteredPassword = loginFragmentBinding.password.text.toString()



            val action = LoginFragmentDirections.actionLoginFragmentToHome()

            Navigation.findNavController(loginFragmentBinding.loginBtn).navigate(action)
            //todo - email pattern validation check and password validation check

            loginFragmentBinding.email.text?.isNotEmpty().apply {
                loginFragmentBinding.password.text?.isNotEmpty().apply {

                    //login in user
                    model.loginUser(
                        loginFragmentBinding.email.text.toString(),
                        loginFragmentBinding.password.text.toString()
                    )
                }
            }
        }

        return loginFragmentBinding.root
    }

    private fun mSpinnerSet() {


        val branch: MutableList<String> = ArrayList()

        branch.add("AHMEDABAD")
        branch.add("BENGALURU")
        branch.add("CHENNAI")
        branch.add("COCHIN")
        branch.add("COIMBATORE")
        branch.add("HYDERABAD")
        branch.add("MUMBAI")
        branch.add("PUNE")
        branch.add("VISHAKHAPATNAM")
        // access the spinner
        val subbranch: MutableList<String> = ArrayList()

        subbranch.add("Lipsom")
        subbranch.add("Lipsom")
        subbranch.add("Lipsom")
        subbranch.add("Lipsom")
        subbranch.add("Lipsom")
        subbranch.add("Lipsom")
        subbranch.add("Lipsom")
        subbranch.add("Lipsom")
        subbranch.add("Lipsom")
//        if (loginFragmentBinding.branchSpinner != null) {
        val adapterBranch = ArrayAdapter(
            loginFragmentBinding.root.context,
            android.R.layout.simple_spinner_item, branch
        )
        loginFragmentBinding.branchSpinner.adapter = adapterBranch
        val adapterSubBranch = ArrayAdapter(
            loginFragmentBinding.root.context,
            android.R.layout.simple_spinner_item, subbranch
        )
        loginFragmentBinding.subbranchSpinner.adapter = adapterSubBranch

        loginFragmentBinding.branchSpinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {

            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }
//        }
    }

    private fun observeViewModel() {
        model.isUserType.observe(viewLifecycleOwner) {
            when {
                model.isUserType.value.equals("CH") -> {
                    Toast.makeText(activity, "Login as BRANCH user", Toast.LENGTH_SHORT).show()
                    val action = LoginFragmentDirections.actionLoginFragmentToHome()

                    Navigation.findNavController(loginFragmentBinding.loginBtn).navigate(action)
                }
                model.isUserType.value.equals("RC") -> {
                    Toast.makeText(activity, "Login as Route controller user", Toast.LENGTH_SHORT)
                        .show()
                    val action = LoginFragmentDirections.actionLoginFragmentToHome()
                    Navigation.findNavController(loginFragmentBinding.loginBtn).navigate(action)
                }
                model.isUserType.value.equals("V") -> {
                    Toast.makeText(activity, "Login as V user", Toast.LENGTH_SHORT).show()
                    val action = LoginFragmentDirections.actionLoginFragmentToHome()
                    Navigation.findNavController(loginFragmentBinding.loginBtn).navigate(action)
                }
                else -> {
                    Toast.makeText(
                        activity,
                        "Unable to LoginIn. Please try again after some time",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }
    }

    private fun mSetCreateAccountText() {
        val createAccountSpanText = SpannableString("Don't have account Create account")

        val createOneClick = object : ClickableSpan() {
            override fun onClick(view: View) {
                val action = LoginFragmentDirections.actionLoginFragmentToSignUpFragment()
                Navigation.findNavController(loginFragmentBinding.createAccountTvOnLogin)
                    .navigate(action)
            }
        }

        createAccountSpanText.setSpan(
            createOneClick, 19, createAccountSpanText.length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE
        )

        createAccountSpanText.setSpan(
            ForegroundColorSpan(Color.BLUE), 19, // start
            createAccountSpanText.length, // end
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        loginFragmentBinding.createAccountTvOnLogin.setText(
            createAccountSpanText,
            TextView.BufferType.SPANNABLE
        );

        loginFragmentBinding.createAccountTvOnLogin.movementMethod =
            LinkMovementMethod.getInstance()
    }

    private fun mSetTermsAndConditionAndPrivacyPolicy() {

        val termConditionsAndPrivacyPolicySpanText =
            SpannableString("Terms and conditions & Privacy Policy")

        val termsAndConditionClickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                Navigation.findNavController(loginFragmentBinding.termsConditionPrivacyPolicyLoginTv)
                    .navigate(LoginFragmentDirections.actionLoginFragmentToTermsAndConditionsFragmnet())
            }
        }

        termConditionsAndPrivacyPolicySpanText.setSpan(
            termsAndConditionClickableSpan,
            0,
            20,
            Spanned.SPAN_INCLUSIVE_EXCLUSIVE
        )

        termConditionsAndPrivacyPolicySpanText.setSpan(
            ForegroundColorSpan(Color.BLUE), 0, // start
            20,// end
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        val privacyPolicyClickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                Navigation.findNavController(loginFragmentBinding.termsConditionPrivacyPolicyLoginTv)
                    .navigate(LoginFragmentDirections.actionLoginFragmentToPrivacyPolicyFragment())
            }
        }

        termConditionsAndPrivacyPolicySpanText.setSpan(
            privacyPolicyClickableSpan,
            23,
            termConditionsAndPrivacyPolicySpanText.length,
            Spanned.SPAN_INCLUSIVE_EXCLUSIVE
        )

        termConditionsAndPrivacyPolicySpanText.setSpan(
            ForegroundColorSpan(Color.BLUE),
            23, // start
            termConditionsAndPrivacyPolicySpanText.length,// end
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        loginFragmentBinding.termsConditionPrivacyPolicyLoginTv.setText(
            termConditionsAndPrivacyPolicySpanText,
            TextView.BufferType.SPANNABLE
        );

        loginFragmentBinding.termsConditionPrivacyPolicyLoginTv.movementMethod =
            LinkMovementMethod.getInstance()
    }

}