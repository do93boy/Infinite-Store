package com.example.infinitestore.ui.theme.Screens.Home

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.infinitestore.Navigation.LOGIN_URL
import com.example.infinitestore.Navigation.SIGNUP_URL
import com.example.infinitestore.R
import com.example.infinitestore.ui.theme.InfiniteStoreTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    var context = LocalContext.current
    val scrollState = rememberScrollState()
    var expanded by remember { mutableStateOf(false) }
    var isAddedToCart by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .background(Color.Gray)
            .verticalScroll(state = scrollState)
    ) {
        // App Bar with menu icon
        TopAppBar(
            title = { Text(text = "InfiniteStore") },
            navigationIcon = {
                IconButton(
                    onClick = { expanded = true },
                    modifier = Modifier.padding(12.dp)
                ) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                }
            }
        )

        // Your existing rows and cards here

        // Repeat the following block as many times as needed for your content
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(modifier = Modifier.weight(1f)) {
                Column(
                    modifier = Modifier
                        .background(Color.Cyan)
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.chapati),
                        contentDescription = "my pic",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    )
                    Text(text = "Chapati ksh/=50", color = Color.Black)
                    Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly ){
                        Button(onClick = {
                            val simToolKitLaunchIntent: Intent = context.getApplicationContext().getPackageManager()
                                .getLaunchIntentForPackage("com.android.stk")!!
                            if (simToolKitLaunchIntent != null) {
                                context.startActivity(simToolKitLaunchIntent)
                            }
                        }) {
                            Text(text = "Buy")
                        }
                        Button(onClick = {
                            val intent = Intent(Intent.ACTION_CALL, Uri.parse("Call:" + "0712345678"))
                            if (ContextCompat.checkSelfPermission(
                                    context,
                                    Manifest.permission.CALL_PHONE
                                ) != PackageManager.PERMISSION_GRANTED
                            ) {
                                ActivityCompat.requestPermissions(
                                    context as Activity,
                                    arrayOf<String>(Manifest.permission.CALL_PHONE),
                                    1
                                )
                            } else {
                                context.startActivity(intent)
                            }
                        }) {
                            // Replace Text with Icon
                            Icon(
                                imageVector = Icons.Default.Call,
                                contentDescription = "Call",
                                modifier = Modifier
                                    .size(30.dp)
                                    .weight(1f) // Adjust size as needed
                            )
                        }

                    }

                    Button(onClick = {
                        if (!isAddedToCart) {
                            // Perform add to cart action
                            Toast.makeText(context, "Successfully Added To Cart", Toast.LENGTH_SHORT).show()
                            isAddedToCart = true
                        } else {
                            // Perform remove from cart action if needed
                            isAddedToCart = false
                        }
                    }) {
                        if (isAddedToCart) {
                            // If item is in cart, show trolley icon
                            Icon(
                                imageVector = Icons.Default.ShoppingCart,
                                contentDescription = "Shopping Cart",
                                modifier = Modifier.size(24.dp)
                            )
                        } else {
                            // Otherwise, show "Add to Cart" text
                            Text(text = "Add to Cart")
                        }
                    }


                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Card(modifier = Modifier.weight(1f)) {
                Column(
                    modifier = Modifier
                        .background(Color.Cyan)
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    Image(
                        painter = painterResource(id = R.drawable.beef),
                        contentDescription = "my pic",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    )
                    Text(text = "Beef ksh/=750", color = Color.Black)
                    Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly ){
                        Button(onClick = {
                            val simToolKitLaunchIntent: Intent = context.getApplicationContext().getPackageManager()
                                .getLaunchIntentForPackage("com.android.stk")!!
                            if (simToolKitLaunchIntent != null) {
                                context.startActivity(simToolKitLaunchIntent)
                            }
                        }) {
                            Text(text = "Buy")
                        }
                        Button(onClick = {
                            val intent = Intent(Intent.ACTION_CALL, Uri.parse("Call:" + "0712345678"))
                            if (ContextCompat.checkSelfPermission(
                                    context,
                                    Manifest.permission.CALL_PHONE
                                ) != PackageManager.PERMISSION_GRANTED
                            ) {
                                ActivityCompat.requestPermissions(
                                    context as Activity,
                                    arrayOf<String>(Manifest.permission.CALL_PHONE),
                                    1
                                )
                            } else {
                                context.startActivity(intent)
                            }
                        }) {
                            // Replace Text with Icon
                            Icon(
                                imageVector = Icons.Default.Call,
                                contentDescription = "Call",
                                modifier = Modifier
                                    .size(30.dp)
                                    .weight(1f) // Adjust size as needed
                            )
                        }

                    }
                    Button(onClick = { Toast.makeText(context, "Successfully added to cart", Toast.LENGTH_SHORT).show() }) {
                        Text(text = " Add to Cart")

                    }
                }
            }
            // Repeat for the second card
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(modifier = Modifier.weight(1f)) {
                Column(
                    modifier = Modifier
                        .background(Color.Cyan)
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.fries),
                        contentDescription = "my pic",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    )
                    Text(text = "Fries ksh/=199", color = Color.Black)
                    Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly ){
                        Button(onClick = {
                            val simToolKitLaunchIntent: Intent = context.getApplicationContext().getPackageManager()
                                .getLaunchIntentForPackage("com.android.stk")!!
                            if (simToolKitLaunchIntent != null) {
                                context.startActivity(simToolKitLaunchIntent)
                            }
                        }) {
                            Text(text = "Buy")
                        }
                        Button(onClick = {
                            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "0712345678"))
                            if (ContextCompat.checkSelfPermission(
                                    context,
                                    Manifest.permission.CALL_PHONE
                                ) != PackageManager.PERMISSION_GRANTED
                            ) {
                                ActivityCompat.requestPermissions(
                                    context as Activity,
                                    arrayOf<String>(Manifest.permission.CALL_PHONE),
                                    1
                                )
                            } else {
                                context.startActivity(intent)
                            }
                        }) {
                            // Replace Text with Icon
                            Icon(
                                imageVector = Icons.Default.Call,
                                contentDescription = "Call",
                                modifier = Modifier
                                    .size(30.dp)
                                    .weight(1f) // Adjust size as needed
                            )
                        }

                    }
                    Button(onClick = { Toast.makeText(context, "Successfully added to cart", Toast.LENGTH_SHORT).show() }) {
                        Text(text = " Add to Cart")

                    }


                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Card(modifier = Modifier.weight(1f)) {
                Column(
                    modifier = Modifier
                        .background(Color.Cyan)
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    Image(
                        painter = painterResource(id = R.drawable.fish),
                        contentDescription = "my pic",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    )
                    Text(text = "Fish ksh/=500", color = Color.Black)

                    Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly ){
                        Button(onClick = {
                            val simToolKitLaunchIntent: Intent = context.getApplicationContext().getPackageManager()
                                .getLaunchIntentForPackage("com.android.stk")!!
                            if (simToolKitLaunchIntent != null) {
                                context.startActivity(simToolKitLaunchIntent)
                            }
                        }) {
                            Text(text = "Buy")
                        }
                        Button(onClick = {
                            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "0712345678"))
                            if (ContextCompat.checkSelfPermission(
                                    context,
                                    Manifest.permission.CALL_PHONE
                                ) != PackageManager.PERMISSION_GRANTED
                            ) {
                                ActivityCompat.requestPermissions(
                                    context as Activity,
                                    arrayOf<String>(Manifest.permission.CALL_PHONE),
                                    1
                                )
                            } else {
                                context.startActivity(intent)
                            }
                        }) {
                            // Replace Text with Icon
                            Icon(
                                imageVector = Icons.Default.Call,
                                contentDescription = "Call",
                                modifier = Modifier
                                    .size(30.dp)
                                    .weight(1f) // Adjust size as needed
                            )
                        }

                    }
                    Button(onClick = { Toast.makeText(context, "Successfully added to cart", Toast.LENGTH_SHORT).show() }) {
                        Text(text = " Add to Cart")

                    }
                }
            }
            // Repeat for the second card
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(modifier = Modifier.weight(1f)) {
                Column(
                    modifier = Modifier
                        .background(Color.Cyan)
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.soda),
                        contentDescription = "my pic",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    )
                    Text(text = "Soda ksh/=150", color = Color.Black)
                    Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly ){
                        Button(onClick = {
                            val simToolKitLaunchIntent: Intent = context.getApplicationContext().getPackageManager()
                                .getLaunchIntentForPackage("com.android.stk")!!
                            if (simToolKitLaunchIntent != null) {
                                context.startActivity(simToolKitLaunchIntent)
                            }
                        }) {
                            Text(text = "Buy")
                        }
                        Button(onClick = {
                            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "0712345678"))
                            if (ContextCompat.checkSelfPermission(
                                    context,
                                    Manifest.permission.CALL_PHONE
                                ) != PackageManager.PERMISSION_GRANTED
                            ) {
                                ActivityCompat.requestPermissions(
                                    context as Activity,
                                    arrayOf<String>(Manifest.permission.CALL_PHONE),
                                    1
                                )
                            } else {
                                context.startActivity(intent)
                            }
                        }) {
                            // Replace Text with Icon
                            Icon(
                                imageVector = Icons.Default.Call,
                                contentDescription = "Call",
                                modifier = Modifier
                                    .size(30.dp)
                                    .weight(1f) // Adjust size as needed
                            )
                        }

                    }
                    Button(onClick = { Toast.makeText(context, "Successfully added to cart", Toast.LENGTH_SHORT).show() }) {
                        Text(text = " Add to Cart")

                    }


                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Card(modifier = Modifier.weight(1f)) {
                Column(
                    modifier = Modifier
                        .background(Color.Cyan)
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    Image(
                        painter = painterResource(id = R.drawable.kuku),
                        contentDescription = "my pic",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    )
                    Text(text = "Chicken ksh/=999", color = Color.Black)


                    Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly ){
                        Button(onClick = {
                            val simToolKitLaunchIntent: Intent = context.getApplicationContext().getPackageManager()
                                .getLaunchIntentForPackage("com.android.stk")!!
                            if (simToolKitLaunchIntent != null) {
                                context.startActivity(simToolKitLaunchIntent)
                            }
                        }) {
                            Text(text = "Buy")
                        }
                        Button(onClick = {
                            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "0712345678"))
                            if (ContextCompat.checkSelfPermission(
                                    context,
                                    Manifest.permission.CALL_PHONE
                                ) != PackageManager.PERMISSION_GRANTED
                            ) {
                                ActivityCompat.requestPermissions(
                                    context as Activity,
                                    arrayOf<String>(Manifest.permission.CALL_PHONE),
                                    1
                                )
                            } else {
                                context.startActivity(intent)
                            }
                        }) {
                            // Replace Text with Icon
                            Icon(
                                imageVector = Icons.Default.Call,
                                contentDescription = "Call",
                                modifier = Modifier
                                    .size(30.dp)
                                    .weight(1f) // Adjust size as needed
                            )
                        }

                    }
                    Button(onClick = { Toast.makeText(context, "Successfully added to cart", Toast.LENGTH_SHORT).show() }) {
                        Text(text = " Add to Cart")

                    }
                }
            }
            // Repeat for the second card
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(modifier = Modifier.weight(1f)) {
                Column(
                    modifier = Modifier
                        .background(Color.Cyan)
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    Image(
                        painter = painterResource(id = R.drawable.ugali),
                        contentDescription = "my pic",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    )
                    Text(text = "Ugali ksh/=100", color = Color.Black)


                    Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly ){
                        Button(onClick = {
                            val simToolKitLaunchIntent: Intent = context.getApplicationContext().getPackageManager()
                                .getLaunchIntentForPackage("com.android.stk")!!
                            if (simToolKitLaunchIntent != null) {
                                context.startActivity(simToolKitLaunchIntent)
                            }
                        }) {
                            Text(text = "Buy")
                        }
                        Button(onClick = {
                            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "0712345678"))
                            if (ContextCompat.checkSelfPermission(
                                    context,
                                    Manifest.permission.CALL_PHONE
                                ) != PackageManager.PERMISSION_GRANTED
                            ) {
                                ActivityCompat.requestPermissions(
                                    context as Activity,
                                    arrayOf<String>(Manifest.permission.CALL_PHONE),
                                    1
                                )
                            } else {
                                context.startActivity(intent)
                            }
                        }) {
                            // Replace Text with Icon
                            Icon(
                                imageVector = Icons.Default.Call,
                                contentDescription = "Call",
                                modifier = Modifier
                                    .size(30.dp)
                                    .weight(1f) // Adjust size as needed
                            )
                        }

                    }
                    Button(onClick = { Toast.makeText(context, "Successfully added to cart", Toast.LENGTH_SHORT).show() }) {
                        Text(text = " Add to Cart")

                    }


                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Card(modifier = Modifier.weight(1f)) {
                Column(
                    modifier = Modifier
                        .background(Color.Cyan)
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    Image(
                        painter = painterResource(id = R.drawable.samosa),
                        contentDescription = "my pic",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    )
                    Text(text = "Samosa ksh/=120", color = Color.Black)
                    Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly ){
                        Button(onClick = {
                            val simToolKitLaunchIntent: Intent = context.getApplicationContext().getPackageManager()
                                .getLaunchIntentForPackage("com.android.stk")!!
                            if (simToolKitLaunchIntent != null) {
                                context.startActivity(simToolKitLaunchIntent)
                            }
                        }) {
                            Text(text = "Buy")
                        }
                        Button(onClick = {
                            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "0712345678"))
                            if (ContextCompat.checkSelfPermission(
                                    context,
                                    Manifest.permission.CALL_PHONE
                                ) != PackageManager.PERMISSION_GRANTED
                            ) {
                                ActivityCompat.requestPermissions(
                                    context as Activity,
                                    arrayOf<String>(Manifest.permission.CALL_PHONE),
                                    1
                                )
                            } else {
                                context.startActivity(intent)
                            }
                        }) {
                            // Replace Text with Icon
                            Icon(
                                imageVector = Icons.Default.Call,
                                contentDescription = "Call",
                                modifier = Modifier
                                    .size(30.dp)
                                    .weight(1f) // Adjust size as needed
                            )
                        }

                    }
                    Button(onClick = { Toast.makeText(context, "Successfully added to cart", Toast.LENGTH_SHORT).show() }) {
                        Text(text = " Add to Cart")

                    }
                }
            }
            // Repeat for the second card
        }


        // Dropdown menu
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxWidth()
        ) {
            // ... (previous code)

// Dropdown menu
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .fillMaxWidth()
            ) {
                DropdownMenuItem(text = { Text(text = "Login") }, onClick = {navController.navigate(
                    LOGIN_URL)})
                DropdownMenuItem(text = { Text(text = "Sign in") }, onClick = {navController.navigate(
                    SIGNUP_URL)})

                // Add more menu items as needed
            }

// ... (remaining code)

            // Add more menu items as needed
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    InfiniteStoreTheme {
        HomeScreen(navController = rememberNavController())
    }
}
