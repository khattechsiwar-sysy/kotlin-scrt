package isetb.tp2.locationvoitures

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSeConnecter = findViewById<Button>(R.id.btnSeConnecter)
        val btnSinscrire = findViewById<Button>(R.id.btnSinscrire)


        btnSeConnecter.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }

        btnSinscrire.setOnClickListener {
            startActivity(Intent(this, CreerCompte::class.java))
        }
    }
}