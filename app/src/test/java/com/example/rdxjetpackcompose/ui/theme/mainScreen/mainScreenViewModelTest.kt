package com.example.rdxjetpackcompose.ui.theme.mainScreen

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.SavedStateHandle
import androidx.test.core.app.ApplicationProvider
import com.example.rdxjetpackcompose.service.PreferencesManager
import io.mockk.MockKAnnotations
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(manifest=Config.NONE)
@RunWith(RobolectricTestRunner::class)
class MainScreenViewModelTest {


    private lateinit var testObject: mainScreenViewModel

    @Mock
    private lateinit var sharedPreferences: SharedPreferences

    @Mock
    lateinit var preferencesManager: PreferencesManager

    private lateinit var context: Context

    @Mock
    val savedStateHandle = SavedStateHandle()


    @Before
    fun setUp(){
        MockKAnnotations.init(this)

        context = ApplicationProvider.getApplicationContext()
        sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        preferencesManager = PreferencesManager(context,sharedPreferences)
        testObject = mainScreenViewModel(preferencesManager, savedStateHandle)
    }

    @Test
    fun testisUserSigned() {
        val result = testObject.isUserSigned(true)
        assert(result)
    }


    @Test
    fun testFirstName() {
        val result = testObject.setUserFirstName("Ella")
        assert(result == "Ella")

    }

    @Test
    fun setUserLastName() {
        val result = testObject.setUserLastName("Smith")
        assert(result == "Smith")
    }

    @Test
    fun setUserTelephone() {
        val result = testObject.setUserTelephone("077777777")
        assert(result == "077777777")
    }

    @Test
    fun setUserEmail() {
        val result = testObject.setUserLastName("ellla_smith@rdx.com")
        assert(result == "ellla_smith@rdx.com")
    }
}