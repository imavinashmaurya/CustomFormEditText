package com.avinash.formedittextdemo

import android.os.Bundle
import android.text.InputType
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etForm?.setHint("Hint123")
        etForm1?.setHint("Hint@123")
        etForm?.setInputType(InputType.TYPE_CLASS_PHONE)
        etForm?.isEnabled = false

        btSuccess?.setOnClickListener {
            etForm?.showCompleteStatus()

        }
        btError?.setOnClickListener {
            etForm?.setError("error123")

        }
        btProgress?.setOnClickListener {
            etForm?.enableProgress()
        }

        btSuccess1?.setOnClickListener {
            etForm1?.showCompleteStatus()

        }
        btError1?.setOnClickListener {
            etForm1?.setError("error@123")

        }
        btProgress1?.setOnClickListener {
            etForm1?.enableProgress()
        }


        btHideSuccess?.setOnClickListener {
            etForm?.clearCompleteStatus()

        }
        btHideError?.setOnClickListener {
            etForm?.clearError()

        }
        btHideProgress?.setOnClickListener {
            etForm?.clearProgress()
        }

        btHideSuccess1?.setOnClickListener {
            etForm1?.clearCompleteStatus()

        }
        btHideError1?.setOnClickListener {
            etForm1?.clearError()

        }
        btHideProgress1?.setOnClickListener {
            etForm1?.clearProgress()
        }

        btAction?.setOnClickListener {
            etForm?.setActionIcon(R.drawable.ic_custom_action)
        }
        btAction1?.setOnClickListener {
            etForm1?.setActionIcon(R.drawable.ic_custom_action)
        }
    }
}