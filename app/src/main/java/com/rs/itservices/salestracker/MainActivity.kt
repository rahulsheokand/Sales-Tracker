package com.rs.itservices.salestracker

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.rs.itservices.salestracker.databinding.ActivityMainBinding
import com.rs.itservices.salestracker.ui.HomeActivity

/**
 * created by **lovepreetkaur240@gmail.com** 24June,2021
 */

class MainActivity : AppCompatActivity() {
    var mGoogleSignInClient: GoogleSignInClient? = null
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail().build()

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
        mGoogleSignInClient!!.signOut()

        binding.googleSignIn.setOnClickListener {
            signIn()
        }
    }

    /**
     * google SignIn
     */
    private fun signIn() {
        val signInIntent = mGoogleSignInClient!!.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    /**
     * on Activity result from other Actions
     */
    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            Log.e("Info", "Handling Sign In Result Now..$resultCode $requestCode")
            handleSignInResult(task)
        }
    }

    /**
     * handle google sigin request
     */
    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            Toast.makeText(this@MainActivity, "Sign In Successful.", Toast.LENGTH_SHORT).show()

            startActivity(Intent(this, HomeActivity::class.java))

            Log.e("USER PHOTO URL", "handleSignInResult: ${account!!.displayName}")
        } catch (e: ApiException) {
            Log.e("Error", "Sign In failed. : ${e.localizedMessage}")
            Toast.makeText(this@MainActivity, "Failed to sign In.", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        private const val RC_SIGN_IN = 1
    }
}