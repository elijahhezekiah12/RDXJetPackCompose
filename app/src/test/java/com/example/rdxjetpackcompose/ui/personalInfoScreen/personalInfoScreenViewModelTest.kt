import com.example.rdxjetpackcompose.ui.theme.personalInfoScreen.personalInfoScreenViewModel
import org.junit.Before
import org.junit.Test
import org.robolectric.annotation.Config


@Config(manifest= Config.NONE)
class PersonalInfoScreenViewModelTest {

    private lateinit var testObject: personalInfoScreenViewModel

    @Before
    fun setUp(){
        testObject = personalInfoScreenViewModel()
    }


   @Test
   fun  `is telephone valid` (){
       val tel  = "077777777"
       val result =testObject.validateTelephone(tel)
       assert(result)

   }



  @Test
  fun  `is last name empty` (){
      val lastName  = "Smith"
      val result = testObject.lasttNameisNotEmpty(lastName)
      assert(result)

  }



    @Test
    fun  `is first name empty` (){
        val firstName  = "Ella"
        val result = testObject.lasttNameisNotEmpty(firstName)
        assert(result)

    }




}