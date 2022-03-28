package com.example.nippon.view.signUp

import android.content.Intent
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
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.nippon.base.BaseFragment
import com.example.nippon.databinding.SignUpFragmentBinding
import com.example.nippon.view.MainActivity
import com.example.nippon.view.login.LoginFragmentDirections

class SignUpFragment : BaseFragment() {
    private lateinit var signUpFragmentbinding: SignUpFragmentBinding
    val model: SignUpViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        signUpFragmentbinding = SignUpFragmentBinding.inflate(inflater)
        mSetCreateAccountText()
        mSetTermsAndConditionAndPrivacyPolicy()
        observeViewModel()
        signUpFragmentbinding.signupBtn.setOnClickListener {
            Toast.makeText(activity, "Sign up Clicked", Toast.LENGTH_SHORT).show()
            val enteredEmail = signUpFragmentbinding.signupEmail.text.toString()
            val enteredPassword = signUpFragmentbinding.signupPassword.text.toString()
            val enteredUsername = signUpFragmentbinding.signupUserName.text.toString()

            //todo - email pattern validation check and password validation check

            signUpFragmentbinding.signupEmail.text?.isNotEmpty().apply {
                signUpFragmentbinding.signupPassword.text?.isNotEmpty().apply {
                    signUpFragmentbinding.signupUserName.text?.isNotEmpty().apply {
                        //login in user
                        model.signUpUser(
                            signUpFragmentbinding.signupUserName.text.toString(),
                            signUpFragmentbinding.signupEmail.text.toString(),
                            signUpFragmentbinding.signupPassword.text.toString()
                        )
                    }
                }
            }
        }


        return signUpFragmentbinding.root
    }

    private fun observeViewModel() {
        model.isUserSignUp.observe(viewLifecycleOwner) { isUserLoggedIn ->
            if (isUserLoggedIn == true) {
                goToMain()
            } else {
                Toast.makeText(
                    activity,
                    "Unable to Sign Up. Please try again after some time",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
    }
    private fun goToMain(){
        val intent = Intent(requireActivity() , MainActivity::class.java)
        startActivity(intent)
    }

//TODO make a single declation

    private fun mSetCreateAccountText() {
        val createAccountSpanText = SpannableString("Already have an account? Login in")

        val createOneClick = object : ClickableSpan() {
            override fun onClick(view: View) {
                val action = SignUpFragmentDirections.actionSignUpFragmentToLoginFragment()
                Navigation.findNavController(signUpFragmentbinding.signupCreateAccountTvOnLogin)
                    .navigate(action)
            }
        }

        createAccountSpanText.setSpan(
            createOneClick, 25, createAccountSpanText.length, Spanned.SPAN_INCLUSIVE_EXCLUSIVE
        )

        createAccountSpanText.setSpan(
            ForegroundColorSpan(Color.BLUE), 25, // start
            createAccountSpanText.length, // end
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        signUpFragmentbinding.signupCreateAccountTvOnLogin.setText(
            createAccountSpanText,
            TextView.BufferType.SPANNABLE
        );

        signUpFragmentbinding.signupCreateAccountTvOnLogin.movementMethod =
            LinkMovementMethod.getInstance()
    }

    private fun mSetTermsAndConditionAndPrivacyPolicy() {

        val termConditionsAndPrivacyPolicySpanText =
            SpannableString("Terms and conditions & Privacy Policy")

        val termsAndConditionClickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                Navigation.findNavController(signUpFragmentbinding.signupTermsConditionPrivacyPolicyLoginTv)
                    .navigate(SignUpFragmentDirections.actionSignUpFragmentToTermsAndConditionsFragmnet())
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
                Navigation.findNavController(signUpFragmentbinding.signupTermsConditionPrivacyPolicyLoginTv)
                    .navigate(SignUpFragmentDirections.actionSignUpFragmentToPrivacyPolicyFragment())
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

        signUpFragmentbinding.signupTermsConditionPrivacyPolicyLoginTv.setText(
            termConditionsAndPrivacyPolicySpanText,
            TextView.BufferType.SPANNABLE
        );

        signUpFragmentbinding.signupTermsConditionPrivacyPolicyLoginTv.movementMethod =
            LinkMovementMethod.getInstance()
    }

}