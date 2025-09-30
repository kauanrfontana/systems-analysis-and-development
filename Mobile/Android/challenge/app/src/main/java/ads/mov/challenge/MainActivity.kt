package ads.mov.challenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ads.mov.challenge.ui.theme.ChallengeTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChallengeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Game(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Game(modifier: Modifier = Modifier, viewModel: DiceViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    var firstTry by rememberSaveable { mutableStateOf(true) }
    var gameResult by rememberSaveable { mutableStateOf(PossibleResults.NOTHING) }
    var winningSum by rememberSaveable { mutableStateOf(listOf(7, 11)) }
    var losingSum by rememberSaveable { mutableStateOf(listOf(2, 3, 12)) }

    Surface(
        modifier = modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.statusBars),
        color = viewModel.getBackgroundColor()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row {
                Dice(uiState.faceDice1)
                Dice(uiState.faceDice2)
            }

            if(gameResult == PossibleResults.NOTHING) {
                Text(
                    viewModel.getButonText(),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = modifier
                )
            }

            Button (
                onClick = {
                    viewModel.rollDices()
                }
            ) {
                if (gameResult == PossibleResults.LOSE || gameResult == PossibleResults.WIN) {
                    Text("Jogar Novamente", fontSize = 24.sp)
                }else {
                    Text("Jogar", fontSize = 24.sp)
                }
            }
        }
    }

}

@Composable
fun Dice(face: Int, modifier: Modifier = Modifier) {
    val imagem = when (face) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Image(
        painter = painterResource(imagem),
        contentDescription = face.toString()
    )
}

@Preview(showBackground = true)
@Composable
fun GamePreview() {
    Game()
}