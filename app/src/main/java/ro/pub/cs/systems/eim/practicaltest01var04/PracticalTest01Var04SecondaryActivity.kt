package ro.pub.cs.systems.eim.practicaltest01var04

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PracticalTest01Var04SecondaryActivity: AppCompatActivity() {
    private lateinit var text_box1: TextView
    private lateinit var text_box2: TextView
    private lateinit var okButton: Button
    private lateinit var cancelButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var04_secondary)

        text_box1 = findViewById(R.id.text_box1)
        text_box2 = findViewById(R.id.text_box2)
        okButton = findViewById(R.id.ok_button)
        cancelButton = findViewById(R.id.cancel_button)

        val intent = intent
        val text1 = intent.getStringExtra(PracticalTest01Var04MainActivity.text1)
        val text2 = intent.getStringExtra(PracticalTest01Var04MainActivity.text2)

        text_box1.text = "Text1: $text1"
        text_box2.text = "Text2: $text2"

        okButton.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }

        cancelButton.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}