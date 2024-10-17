const displayContent = document.getElementById("conteudo-visor");
const display = document.querySelector(".visor");
const numbers = document.querySelectorAll(".numero");
const sum = document.getElementById("+");
sum.onclick = () => insertElementTextToDisplay(sum);
const sub = document.getElementById("-");
sub.onclick = () => insertElementTextToDisplay(sub);
const div = document.getElementById("/");
div.onclick = () => insertElementTextToDisplay(div);
const mult = document.getElementById("*");
mult.onclick = () => insertElementTextToDisplay(mult);
const porcentage = document.getElementById("%");
porcentage.onclick = () => insertElementTextToDisplay(porcentage);
const coma = document.getElementById(",");
coma.onclick = () => insertElementTextToDisplay(coma);
const power = document.getElementById("^");
power.onclick = () => {
    displayContent.innerText += "^"
};
const root = document.getElementById("raiz");
root.onclick = () => insertElementTextToDisplay(root);

const equals = document.getElementById("=");
const remove = document.getElementById("remove");
remove.onclick = removeOneCaracterFromDisplay;
const clear = document.getElementById("c");







function verifyDisplayContentFontSize(){
    const displayContentSize = displayContent.getBoundingClientRect().width;
    const displaySize = display.getBoundingClientRect().width;
    const estiloConteudo = window.getComputedStyle(displayContent, null);
    const tamanhoFonteConteudoPx = estiloConteudo.getPropertyValue('font-size');
    const tamanhoFonteConteudoUnidade = tamanhoFonteConteudoPx.slice(0, -2);

    if(displayContentSize > displaySize){
        increasesDisplayContentFontSize(tamanhoFonteConteudoUnidade);
    }

    if((tamanhoFonteConteudoUnidade / 17) < 5 && displayContentSize < (displaySize / 2)){
        decreasesDisplayContentFontSize(tamanhoFonteConteudoUnidade);
    }
}

function increasesDisplayContentFontSize(contentFontSizeNum){
    displayContent.style.fontSize = (+contentFontSizeNum - 10) + 'px';
}

function decreasesDisplayContentFontSize(contentFontSizeNum){
    displayContent.style.fontSize = (+contentFontSizeNum + 10) + 'px';
}

function insertElementTextToDisplay(element){
    displayContent.innerText = displayContent.innerText + element.innerText
}

function removeOneCaracterFromDisplay(){
    displayContent.innerText = displayContent.innerText.slice(0, -1);
}

function clearDisplayContent(){
    displayContent.innerText = "";
}

function fakeClick(element){
    element.classList.toggle("hover");
    setTimeout(() => {
        element.classList.toggle("active");
    }, 50)

    setTimeout(() => {
        element.classList.toggle("hover");
        element.classList.toggle("active");
    }, 200)
}

numbers.forEach((number) => {
number.addEventListener("click", () => {
    insertElementTextToDisplay(number);
    verifyDisplayContentFontSize();
})
});

equals.addEventListener("click", () => {
})

document.addEventListener("keydown", (e) => {
    switch(e.key){
        case "Backspace":
            removeOneCaracterFromDisplay();
            fakeClick(remove);
            break;
        case "c":
            clearDisplayContent();
            fakeClick(clear);
            break;
        default:
            const regex = /^[\d\s()+\-,*/%^]+$/;
            if(regex.test(e.key)){
                const element = document.getElementById(e.key);
                insertElementTextToDisplay(element);
                fakeClick(element);
            }
            
        }
        verifyDisplayContentFontSize();
})
