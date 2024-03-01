package com.example.rdxjetpackcompose.ui.theme.mainScreen

import android.content.Context
import android.content.SharedPreferences
import androidx.test.core.app.ApplicationProvider
import com.example.rdxjetpackcompose.service.PreferencesManager
import io.mockk.MockKAnnotations
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class MainScreenViewModelTest {


    lateinit var testObject: mainScreenViewModel

    private lateinit var sharedPreferences: SharedPreferences

    @Mock
    lateinit var preferencesManager: PreferencesManager

    private lateinit var context: Context


    @Before
    fun setUp(){
        MockKAnnotations.init(this)

        context = ApplicationProvider.getApplicationContext()
        sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        preferencesManager = PreferencesManager(context,sharedPreferences)
        testObject = mainScreenViewModel(context,preferencesManager)
    }

    @Test
    fun testisUserSigned() {
        val result = testObject.isUserSigned(true)
        assert(result)
    }


    @Test
    fun testFirstName() {
        val result = testObject.setUserFirstName()
        assert(result != "Ellla")

    }

    @Test
    fun setUserLastName() {
        val result = testObject.setUserLastName()
        assert(result != "Ellla")
    }

    @Test
    fun setUserTelephone() {
        val result = testObject.setUserTelephone()
        assert(result != "Ellla")
    }

    @Test
    fun setUserEmail() {
        val result = testObject.setUserLastName()
        assert(result != "Ellla")
    }
}