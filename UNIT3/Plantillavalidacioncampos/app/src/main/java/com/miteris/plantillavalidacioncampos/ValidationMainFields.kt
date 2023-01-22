package com.miteris.plantillavalidacioncampos

import android.content.Context
import android.text.TextUtils
import android.util.Patterns

class ValidationMainFields(private val context: Context) : ValidatorFieldHelper() {

    init {
        addAssertion(FIELD_EMAIL)
        addAssertion(FIELD_USER_NAME)
        addAssertion(FIELD_PASSWORD)
        addAssertion(FIELD_CONFIRM_PASSWORD)
    }

    fun checkFieldEmail(s: String): AssertionItem? {
        var isValid = false
        var errorMsg: String? = null
        if (s.isNotEmpty()) {
            if (isValidEmail(s)) {
                isValid = true
            } else {
                errorMsg = context.getString(R.string.error_email)
            }
        } else {
            errorMsg = context.getString(R.string.error_empty)
        }
        setAssertion(FIELD_EMAIL, AssertionItem(isValid, errorMsg))
        return getAssertion(FIELD_EMAIL)
    }

    fun checkFieldUserName(s: String): AssertionItem? {
        var isValid = false
        var errorMsg: String? = null
        if (s.isNotEmpty()) {
            if (isUniqueUserName(s)) {
                isValid = true
            } else {
                errorMsg = context.getString(R.string.error_username)
            }
        } else {
            errorMsg = context.getString(R.string.error_empty)
        }
        setAssertion(FIELD_USER_NAME, AssertionItem(isValid, errorMsg))
        return getAssertion(FIELD_USER_NAME)

    }

    fun checkFieldPassword(s: String): AssertionItem? {
        var isValid = false
        var errorMsg: String? = null
        if (s.isNotEmpty()) {
            isValid = true
        } else {
            errorMsg = context.getString(R.string.error_empty)
        }
        setAssertion(FIELD_PASSWORD, AssertionItem(isValid, errorMsg))
        return getAssertion(FIELD_PASSWORD)
    }

    fun checkFieldConfirmPassword(password1: String, password2: String): AssertionItem? {
        var isValid = false
        var errorMsg: String? = null
        if (password2.isNotEmpty()) {
            isValid = password1 == password2
            if (!isValid) errorMsg = context.getString(R.string.error_password_confirm)
        } else {
            errorMsg = context.getString(R.string.error_empty)
        }

        setAssertion(FIELD_CONFIRM_PASSWORD, AssertionItem(isValid, errorMsg))
        return getAssertion(FIELD_CONFIRM_PASSWORD)
    }

    private fun isValidEmail(target: CharSequence): Boolean {
        return if (TextUtils.isEmpty(target)) {
            false
        } else {
            Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }
    }

    private fun isUniqueUserName(s: String): Boolean {
        return s != "bob"
    }

    companion object {
        const val FIELD_EMAIL = "FIELD_EMAIL"
        const val FIELD_USER_NAME = "FIELD_USER_NAME"
        const val FIELD_PASSWORD = "FIELD_PASSWORD"
        const val FIELD_CONFIRM_PASSWORD = "FIELD_CONFIRM_PASSWORD"
    }
}