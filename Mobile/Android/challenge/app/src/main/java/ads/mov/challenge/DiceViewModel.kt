package ads.mov.challenge

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

enum class PossibleResults() {
    NOTHING, LOSE, WIN, POINT
}

data class DiceUiState (
    val firstTry: Boolean = true,
    val faceDice1: Int = 6,
    val faceDice2: Int = 6,
    val gameResult: PossibleResults = PossibleResults.NOTHING,
    val winningSum: List<Int> = listOf(7, 11),
    val losingSum: List<Int> = listOf(2, 3, 12)
)
class DiceViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(DiceUiState())
    val uiState = _uiState.asStateFlow()

    fun rollDices(){
        val d1 = (1..6).random()
        val d2 = (1..6).random()

        _uiState.update {
            it.copy (
                faceDice1 = d1,
                faceDice2 = d2
            )
        }

        if (_uiState.value.gameResult == PossibleResults.WIN || _uiState.value.gameResult == PossibleResults.LOSE) {
            _uiState.update {
                it.copy(
                    firstTry = true,
                    gameResult = PossibleResults.NOTHING,
                    winningSum = listOf(7, 11),
                    losingSum = listOf(2, 3, 12)
                )
            }
        }
        val sum = _uiState.value.faceDice1 + _uiState.value.faceDice2
        val gameResult = when(true){
            _uiState.value.winningSum.contains(sum) -> PossibleResults.WIN
            _uiState.value.losingSum.contains(sum) -> PossibleResults.WIN
            else -> PossibleResults.POINT
        }

        if (_uiState.value.firstTry && gameResult == PossibleResults.POINT) {
            _uiState.update {
                it.copy(
                    firstTry = false,
                    gameResult = PossibleResults.POINT,
                    winningSum = listOf(sum),
                    losingSum = listOf(7)
                )
            }
        }
    }

    fun getBackgroundColor(): Color {
        return when(_uiState.value.gameResult) {
            PossibleResults.NOTHING, PossibleResults.POINT -> Color.Magenta
            PossibleResults.WIN -> Color.Green
            PossibleResults.LOSE -> Color.Red
        }
    }

    fun getButonText(): String {
        return when(_uiState.value.gameResult) {
            PossibleResults.NOTHING, PossibleResults.POINT -> "Jogar"
            PossibleResults.WIN -> "Jogar Novamente"
            PossibleResults.LOSE -> "Jogar Novamente"
        }
    }
}