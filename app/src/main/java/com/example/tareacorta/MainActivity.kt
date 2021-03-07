package com.example.tareacorta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // GLOBAL VARIABLES USED
        val listOfDishes = arrayListOf("Chinese","Pork","Salad")
        var countListOfDishes = 0
        var lenghtOfListDishes : Int = listOfDishes.size

        // VARIABLES OF UI ELEMENTS
        val buttonNextOption : Button = findViewById(R.id.buttonNextOption)
        val buttonAddToCart : Button = findViewById(R.id.buttonAddToCart)

        // METHODS OF UI ELEMENTS
        buttonNextOption.setOnClickListener{displayNextDish(listOfDishes, {
            //Lambda function to control countListOfDishes global variable triggered by
            // clicking buttonNextOption
            if (countListOfDishes == lenghtOfListDishes -1){
                countListOfDishes = 0
            }
            else if (countListOfDishes>=0 && countListOfDishes<lenghtOfListDishes){
                countListOfDishes++
            }
            else{
                countListOfDishes = 0
            }
        },countListOfDishes)
        }

        buttonAddToCart.setOnClickListener{onDevelopment()}

    }

    // Function to be used whenever a function is being developed
    private fun onDevelopment(){
        Toast.makeText(this, "On development", Toast.LENGTH_SHORT).show()
    }

    /*
    This function changes "foodItemTxt" value to one of the list provided
    @param listOfDishes: ArrayList<String> : array containing list of dishes
    @param counterModify: () -> Unit :lamda fuction that modifies global variable used as counter passed in next parameter
    @param counterOfList : Int : index of element to be displayed from listOfDishes
    @return Unit
     */
    private fun displayNextDish( listOfDishes: ArrayList<String>, counterModify: () -> Unit, counterOfList : Int) {
        counterModify()
        val foodItemText : TextView = findViewById(R.id.foodItemTxt)
        var dish : String
        dish = listOfDishes[counterOfList]
        foodItemText.text = dish
    }
}


