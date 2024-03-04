package com.example.rdxjetpackcompose.ui.theme.credentialsScreen

import org.junit.Before
import org.junit.Test
import org.robolectric.annotation.Config


@Config(manifest= Config.NONE)
class credentialsViewModelTest {

    private lateinit var testObject: credentialsViewModel

    @Before
    fun setUp() {
        testObject = credentialsViewModel()
    }

    @Test
    fun `is Email  valid`() {
        val email  = "ellla_smith@rdx.com"
        val result = testObject.validateEmail(email)
        assert(result)
    }
}