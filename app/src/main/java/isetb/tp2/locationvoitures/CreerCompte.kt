package isetb.tp2.locationvoitures

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CreerCompte : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creer_compte)

        val etNom = findViewById<EditText>(R.id.etNom)
        val etPrenom = findViewById<EditText>(R.id.etPrenom)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etTel = findViewById<EditText>(R.id.etTel)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etConfirm = findViewById<EditText>(R.id.etConfirm)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val tvLogin = findViewById<TextView>(R.id.tvLogin)

        btnRegister.setOnClickListener {
            val nom = etNom.text.toString().trim()
            val prenom = etPrenom.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val tel = etTel.text.toString().trim()
            val password = etPassword.text.toString()
            val confirm = etConfirm.text.toString()

            val erreurMdp = verifierMotDePasse(password)

            if (nom.isEmpty() || prenom.isEmpty()) {
                Toast.makeText(this, "Nom et prénom obligatoires", Toast.LENGTH_SHORT).show()
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches() || !email.lowercase().endsWith(".com")) {
                Toast.makeText(this, "Email invalide (exemple : nom@gmail.com)", Toast.LENGTH_SHORT).show()
            } else if (tel.length < 8) {
                Toast.makeText(this, "Téléphone invalide", Toast.LENGTH_SHORT).show()
            } else if (erreurMdp != null) {
                Toast.makeText(this, erreurMdp, Toast.LENGTH_SHORT).show()
            } else if (password != confirm) {
                Toast.makeText(this, "Les mots de passe ne correspondent pas", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Compte créé, connectez-vous", Toast.LENGTH_SHORT).show()
                finish() // retour à la page Login
            }
        }

        tvLogin.setOnClickListener { finish() }
    }

    private fun verifierMotDePasse(password: String): String? {
        if (password.length < 6)
            return "Mot de passe : 6 caractères minimum"
        if (!password[0].isUpperCase())
            return "Le mot de passe doit commencer par une majuscule"
        if (!password.any { it.isDigit() })
            return "Le mot de passe doit contenir au moins un chiffre"
        if (!password.any { !it.isLetterOrDigit() })
            return "Le mot de passe doit contenir un caractère spécial"
        return null
    }
}