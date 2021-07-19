package com.sriyank.javatokotlindemo.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import com.sriyank.javatokotlindemo.app.Constants
import com.sriyank.javatokotlindemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var etName: EditText? = null
    private var etGithubRepoName: EditText? = null
    private var etLanguage: EditText? = null
    private var etGithubUser: EditText? = null
    private var inputLayoutName: TextInputLayout? = null
    private var inputLayoutRepoName: TextInputLayout? = null
    private var inputLayoutGithubUser: TextInputLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setSupportActionBar(binding.toolbar)
    }
    /** Save app username in SharedPreference */
    fun saveName(view: View){
        val personName = binding.etName.text.toString()
       val sp = getSharedPreferences(Constants.APP_SHARED_PREFERENCES, Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString(Constants.KEY_PERSON_NAME, personName)
        editor.apply()
    }

    /** Search repositories on github after passing data to DisplayActivity  */
    fun listRepositories(view : View){

        if (isNotEmpty(binding.etRepoName, binding.inputLayoutRepoName)) {
            val queryRepo = binding.etRepoName.text.toString()
            val repoLanguage = binding.etLanguage.text.toString()

            val intent = Intent(this@MainActivity, DisplayActivity::class.java)
            intent.putExtra(Constants.KEY_QUERY_TYPE, Constants.SEARCH_BY_REPO)
            intent.putExtra(Constants.KEY_REPO_SEARCH, queryRepo)
            intent.putExtra(Constants.KEY_LANGUAGE, repoLanguage)
            startActivity(intent)
        }
    }

    /** Search repositories of a particular github user after passing data to DisplayActivity  */
    fun listUserRepositories(view : View){

        if(isNotEmpty(binding.etGithubUser, binding.inputLayoutGithubUser)) {
            val githubUser = binding.etGithubUser.text.toString()


            val intent = Intent(this@MainActivity, DisplayActivity::class.java)
            intent.putExtra(Constants.KEY_QUERY_TYPE, Constants.SEARCH_BY_USER)
            intent.putExtra(Constants.KEY_GITHUB_USER, githubUser)
            startActivity(intent)
        }
    }

    private fun isNotEmpty(editText: EditText, textInputLayout: TextInputLayout): Boolean{
        return if (editText.text.toString().isEmpty()){
            textInputLayout.error = "Cannot be blank"
            false
        }else{
            textInputLayout.isErrorEnabled = false
            true
        }
    }

}