package com.jjg.ejercicio3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.jjg.ejercicio3.ui.theme.Ejercicio3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ejercicio3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ConstraintBarrier()
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.NEXUS_5
)

@Composable
fun GreetingPreview() {
    Ejercicio3Theme {
        ConstraintBarrier()
    }
}

@Composable
fun ConstraintBarrier(){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (box1, box2, box3) = createRefs()
        val barrier= createEndBarrier(box1,box2)

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(box1) {
                start.linkTo(parent.start, margin = 16.dp)
            }
        )

        Box(modifier = Modifier
            .size(225.dp)
            .background(Color.Yellow)
            .constrainAs(box2) {
                top.linkTo(box1.bottom, margin = 32.dp)
            }
        )

        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Red)
            .constrainAs(box3) {
                start.linkTo(barrier)
            }
        )
    }
    }

@Composable
fun ConstraintLayoutGuide(){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val boxRed = createRef()
        val topGuido= createGuidelineFromTop(0.1f)
        val startGuido= createGuidelineFromStart(0.25f)
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(topGuido)
                start.linkTo(startGuido)
            }
        )
    }
}

@Composable
fun ContraintExample() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (boxRed, boxYellow,boxBlue,boxGreen,boxMorado) = createRefs()//crear variables de referencia

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(parent.top) //zona superior
                start.linkTo(parent.start) //zona izquierda
                end.linkTo(parent.end) //zona derecha
                bottom.linkTo(parent.bottom) //zona inferior
            }
        )

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                end.linkTo(boxRed.start)
                bottom.linkTo(boxRed.top)
            }
        )

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue) {
                start.linkTo(boxRed.end)
                bottom.linkTo(boxRed.top)
            }
        )

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                start.linkTo(boxRed.end)
                top.linkTo(boxRed.bottom)
            }
        )

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Magenta)
            .constrainAs(boxMorado) {
                end.linkTo(boxRed.start)
                top.linkTo(boxRed.bottom)
            }
        )


    }
}
