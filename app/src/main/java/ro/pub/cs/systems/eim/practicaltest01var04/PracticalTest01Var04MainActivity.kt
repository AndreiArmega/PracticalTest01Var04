package ro.pub.cs.systems.eim.practicaltest01var04

import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.app.Activity
import android.content.Intent

import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class   PracticalTest01Var04MainActivity : AppCompatActivity() {
private lateinit var top_right_button: Button
private lateinit var action_button: Button
private lateinit var  down_left : TextView

private lateinit var  top_edit_text : EditText
private lateinit var  navigateToSecondaryActivityButton : Button
private lateinit var  bottom_edit_text : EditText
    companion object {
        const val TOP_TEXT = "top_text"
        const val BOTTOM_TEXT = "bottom_text"
        const val text1 = "t1"
        const val text2 = "t2"
    }
    private val activityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            Toast.makeText(this, "Rezultat primit: OK", Toast.LENGTH_LONG).show()
        } else if (result.resultCode == Activity.RESULT_CANCELED) {
            Toast.makeText(this, "Rezultat primit: CANCEL", Toast.LENGTH_LONG).show()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var04_main)
        //top_right_button = findViewById(R.id.top_right_button)
        action_button = findViewById(R.id.action_button)
        down_left = findViewById(R.id.down_left)
        top_edit_text = findViewById(R.id.top_edit_text)
        bottom_edit_text = findViewById(R.id.bottom_edit_text)
        navigateToSecondaryActivityButton = findViewById(R.id.navigate_to_secondary_activity)
        action_button.setOnClickListener {
            down_left.text = top_edit_text.text.toString() + bottom_edit_text.text.toString();

        }
        navigateToSecondaryActivityButton.setOnClickListener {
            val topText = top_edit_text.text.toString()
            val botText = bottom_edit_text.text.toString()
            val t1 = topText
            val t2 = botText

            val intent = Intent(applicationContext, PracticalTest01Var04SecondaryActivity::class.java)
            intent.putExtra(text1, t1)
            intent.putExtra(text2,t2)

            activityResultLauncher.launch(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString(TOP_TEXT, top_edit_text.text.toString())
        outState.putString(BOTTOM_TEXT, bottom_edit_text.text.toString())
    }
}
