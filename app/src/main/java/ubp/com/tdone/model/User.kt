import android.content.Context
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest

object User {
    private val auth = FirebaseAuth.getInstance()

    fun createUserWithEmailAndPassword(
        email: String,
        password: String,
        nickname: String,
        context: Context,
        onComplete: () -> Unit
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(context, "Nuevo Usuario", Toast.LENGTH_SHORT).show()
                    updateName(nickname, onComplete)
                }else{
                    Toast.makeText(context, "Error de Registro", Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun signInWithEmailAndPassword(email: String, password: String, context: Context, onComplete: () -> Unit) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(context, "Inicio Exitoso", Toast.LENGTH_SHORT).show()
                    onComplete()
                } else {
                    Toast.makeText(context, "Contraseña Incorrecta", Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun signOut() {
        auth.signOut()
    }

    fun getCurrentUser(): FirebaseUser? {
        return auth.currentUser
    }

    private fun updateName(nickname: String, onComplete: () -> Unit) {
        val updateNickname = UserProfileChangeRequest.Builder().setDisplayName(nickname).build()
        getCurrentUser()?.updateProfile(updateNickname)?.addOnCompleteListener {
            if (it.isSuccessful) {
                onComplete()
            }
        }
    }

}