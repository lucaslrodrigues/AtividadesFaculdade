
cards = [
    {
        id : 1,
        def: 3,
        atac: 3,
        src: "cartas/capitao_america.png"
    },
    {
        id : 2,
        def: 1,
        atac: 1,
        src: "cartas/deadpool.png"
    },
    {
        id : 3,
        def: 5,
        atac: 0,
        src: "cartas/homem_de_ferro.png"
    },
    {
        id : 4,
        def: 1,
        atac: 2,
        src: "cartas/mercurio.png"
    },
    {
        id : 5,
        def: 2,
        atac: 2,
        src: "cartas/mulher_invisivel.png"
    },
    {
        id : 6,
        def: 3,
        atac: 2,
        src: "cartas/sr_fantastico.png"
    },
    {
        id : 7,
        def: 3,
        atac: 4,
        src: "cartas/thor.png"
    },
    {
        id : 8,
        def: 3,
        atac: 1,
        src: "cartas/venom.png"
    },
    {
        id : 9,
        def: 2,
        atac: 1,
        src: "cartas/viuva_negra.png"
    },
    {
        id : 10,
        def: 2,
        atac: 3,
        src: "cartas/wolverine.png"
    }
]

var playerCards = [];
var adversaryCards = [];

// for(let i = 0; i < 5; i ++){
while (playerCards.length < 5) {
    let numCard = (Math.random() * 10).toFixed(0);

    if (playerCards.length > 0) {
        let verify = true;
        for (let index = 0; index < playerCards.length; index ++) {
            // console.log('CARTA: '+playerCards[index].id)
            if(playerCards[index].id == numCard){
                verify = false;
                break;
            }
        }
        if (verify) {
            numCard > 0 ? playerCards.push(cards[numCard - 1]) : playerCards.push(cards[numCard]);
        }
    }else{
        // console.log('Tamanho: '+ playerCards.length)
        numCard > 0 ? playerCards.push(cards[numCard - 1]) : playerCards.push(cards[numCard]);
    }
    console.log("Número sorteado: "+numCard)
}
console.log(playerCards);
// }

while (adversaryCards.length < 5) {
    let numCard = (Math.random() * 10).toFixed(0);

    if (adversaryCards.length > 0) {
        let verify = true;
        for (let index = 0; index < adversaryCards.length; index ++) {
            if(adversaryCards[index].id == numCard){
                verify = false;
            }
        }
        if (verify) {
            numCard > 0 ? adversaryCards.push(cards[numCard - 1]) : adversaryCards.push(cards[numCard]);
        }
    }else{
        numCard > 0 ? adversaryCards.push(cards[numCard - 1]) : adversaryCards.push(cards[numCard]);
    }
    console.log("Número sorteado: "+numCard)
}
console.log(adversaryCards);

// EXIBIÇÃO

for (let i = 0; i < 5; i++) {
    cardsPlayer.innerHTML += `<span id="cardP${i}"><img src="${playerCards[i].src}"></span>`
}
for (let i = 0; i < 5; i++) {
    cardsAdversary.innerHTML += `<span id="cardA${i}"><img src="${adversaryCards[i].src}"></span>`
}

var arrayNumbers = [];
function start(){
    // Player
    let numCard = (Math.random() * 5).toFixed(0);
    console.log(numCard)
    if (arrayNumbers.length != 0){
        
    }

    // console.log('Local da carta: ' + playerCards[numCard].src);
    imgPlayer.innerHTML = `<img src="${playerCards[numCard].src}">`

    // let teste = `cardP${numCard}`;
    // console.log(teste)
    // teste.innerHTML = ``;

    let span = document.getElementById(`cardP${numCard}`);
    span.innerHTML = ``;

    let arrayP = [];
    for (let i = 0; i < playerCards.length; i ++) {
        if (i != numCard) {
            arrayP.push(playerCards[i])
        }
    }
    playerCards = arrayP;
    console.log(playerCards);
}