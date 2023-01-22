package com.miteris.plantillavalidacioncampos

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private val myValidator = ValidationMainFields(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAutoUsername.setOnClickListener {
            val s = "bob" + (0..100).random()
            edtUserName.setText(s)
        }

        myValidator.setOnValidateListener(validatorListener())

        edtEmail.onChangeDebounce {
            myValidator.checkFieldEmail(it)
            myValidator.getAssertion(ValidationMainFields.FIELD_EMAIL)?.let {
                til1.error = it.error
            }
        }

        edtUserName.onChangeDebounce {
            myValidator.checkFieldUserName(it)
            myValidator.getAssertion(ValidationMainFields.FIELD_USER_NAME)?.let {
                til2.error = it.error
            }
        }

        edtPassword.onChangeDebounce {
            myValidator.checkFieldPassword(it)
            myValidator.getAssertion(ValidationMainFields.FIELD_PASSWORD)?.let {
                til3.error = it.error
            }
        }
        edtCofirmPassword.onChangeDebounce {
            myValidator.checkFieldConfirmPassword(edtPassword.text.toString(), it)
            myValidator.getAssertion(ValidationMainFields.FIELD_CONFIRM_PASSWORD)?.let {
                til4.error = it.error
            }
        }

        btnValidate.setOnClickListener {
            myValidator.checkFieldEmail(edtEmail.text.toString())
            myValidator.checkFieldUserName(edtUserName.text.toString())
            myValidator.checkFieldPassword(edtPassword.text.toString())
            myValidator.checkFieldConfirmPassword(edtPassword.text.toString(), edtCofirmPassword.text.toString())
            myValidator.validate()
        }

        edtCofirmPassword.onDone {
            btnValidate.performClick()
        }

    }

    private fun validatorListener(): ValidatorFieldHelper.ValidatorFieldsListener {
        return object : ValidatorFieldHelper.ValidatorFieldsListener {
            override fun onSuccessfulValidator() {
                toast("onSuccessfulValidator")
                til1.error = null
                til2.error = null
                til3.error = null
                til4.error = null
            }

            override fun onErrorValidator(assertionList: HashMap<String, ValidatorFieldHelper.AssertionItem>) {
                toast("Validator error")
                Log.w(TAG, "onErrorValidator() called with: assertionList = [$assertionList]")

                assertionList[ValidationMainFields.FIELD_EMAIL]?.let {
                    til1.error = it.error
                }
                assertionList[ValidationMainFields.FIELD_USER_NAME]?.let {
                    til2.error = it.error
                }
                assertionList[ValidationMainFields.FIELD_PASSWORD]?.let {
                    til3.error = it.error
                }
                assertionList[ValidationMainFields.FIELD_CONFIRM_PASSWORD]?.let {
                    til4.error = it.error
                }
            }
        }
    }

    //Kotlin extensions
    fun Context?.toast(text: CharSequence, duration: Int = Toast.LENGTH_SHORT) =
        this?.let { Toast.makeText(it, text, duration).show() }

    fun TextInputEditText.onChange(cb: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                cb(s.toString())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    fun TextInputEditText.onChangeDebounce(duration: Long = 350L, cb: (String) -> Unit) {
        var lastStr = ""
        this.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val newStr = s.toString()
                if (newStr == lastStr)
                    return
                lastStr = newStr
                GlobalScope.launch(Dispatchers.Main) {
                    delay(duration)
                    if (newStr != lastStr)
                        return@launch
                    if (isAttachedToWindow) cb(s.toString())
                }
            }
        })
    }

    fun TextInputEditText.onDone(callback: () -> Unit) {
        setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                callback.invoke()
            }
            false
        }
    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
}