
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

var arrayNumbersPlayer = [];
var arrayNumbersAdversary = [];
var finish = false;
var pointsPlayer = 0;
var pointsAdversary = 0;


function start(){
    let player = 0;
    let adversary = 0;

    // PLAYER
    var loop = true;
    while (loop) {
        let verify = true;
        let numCard = (Math.random() * 4).toFixed(0);
        console.log(numCard)

        if (arrayNumbersPlayer.length > 0){
            for (let i = 0; i < arrayNumbersPlayer.length; i ++) {
                if (numCard == arrayNumbersPlayer[i]) {
                    verify = false;
                }
            }
            if (verify) {
                // console.log('Local da carta: ' + playerCards[numCard].src);
                // numCard == 5 ? imgPlayer.innerHTML = `<img src="${playerCards[numCard - 1].src}">`
                imgPlayer.innerHTML = `<img src="${playerCards[numCard].src}">`
            
                // let teste = `cardP${numCard}`;
                // console.log(teste)
                // teste.innerHTML = ``;
            
                let span = document.getElementById(`cardP${numCard}`);
                span.innerHTML = ``;
                
                player = playerCards[numCard]; 
                delete playerCards[numCard];
                arrayNumbersPlayer.push(numCard);
            
                // let arrayP = [];
                // for (let i = 0; i < playerCards.length; i ++) {
                //     if (i != numCard) {
                //         arrayP.push(playerCards[i])
                //     }
                // }
                // playerCards = arrayP;
            
                console.log(playerCards);
                loop = false;
            }
        }else{
            imgPlayer.innerHTML = `<img src="${playerCards[numCard].src}">`

            let span = document.getElementById(`cardP${numCard}`);
            span.innerHTML = ``;
        
            player = playerCards[numCard]; 
            delete playerCards[numCard];
            arrayNumbersPlayer.push(numCard);
        
            console.log(playerCards);
            loop = false;
        }
        if (arrayNumbersPlayer.length == 5) {
            loop = false;
            finish = true;
            buttonStart.style.display = "none";
        }
    }

    // ADVERSARY

    loop = true;
    while (loop) {
        let verify = true;
        let numCard = (Math.random() * 4).toFixed(0);

        if (arrayNumbersAdversary.length > 0){
            for (let i = 0; i < arrayNumbersAdversary.length; i ++) {
                if (numCard == arrayNumbersAdversary[i]) {
                    verify = false;
                }
            }
            if (verify) {
                imgAdversary.innerHTML = `<img src="${adversaryCards[numCard].src}">`
            
                let span = document.getElementById(`cardA${numCard}`);
                span.innerHTML = ``;
                
                adversary = adversaryCards[numCard];
                delete adversaryCards[numCard];
                arrayNumbersAdversary.push(numCard);
            
                console.log(adversaryCards);
                loop = false;
            }
        }else{
            imgAdversary.innerHTML = `<img src="${adversaryCards[numCard].src}">`
            
            let span = document.getElementById(`cardA${numCard}`);
            span.innerHTML = ``;
        
            adversary = adversaryCards[numCard];
            delete adversaryCards[numCard];
            arrayNumbersAdversary.push(numCard);
        
            console.log(adversaryCards);
            loop = false;
        }
        if (arrayNumbersAdversary.length == 5) {
            loop = false;
            finish = true;
            buttonStart.style.display = "none";
        }
    }

    // PONTUAÇÂO

    winner = '<label style = "color: #06777c">Empate</label>';
    console.log(player, adversary)
    if (player.def <= adversary.atac && adversary.def <= player.atac) {

        pointsAdversary += 1;
        pointsAdversaryView.innerHTML = `${pointsAdversary}`;
        pointsPlayer += 1;
        pointsPlayerView.innerHTML = `${pointsPlayer}`;

    }else if (player.def <= adversary.atac) {

        winner = '<label style = "color:#D9301C">o Adversario venceu</label>';
        pointsAdversary += 3;
        pointsAdversaryView.innerHTML = `${pointsAdversary}`;

    }else if (adversary.def <= player.atac) {

        winner = '<span style = "color:#016a2d;" >o jogador venceu</span>';
        pointsPlayer += 3;
        pointsPlayerView.innerHTML = `${pointsPlayer}`;
    }else{

        pointsAdversary += 1;
        pointsAdversaryView.innerHTML = `${pointsAdversary}`;
        pointsPlayer += 1;
        pointsPlayerView.innerHTML = `${pointsPlayer}`;

    }

    resTurn.innerHTML = `${winner}`

    // RESULTADO
    if (finish) {
        if (pointsAdversary > pointsPlayer) {
            resBattle.innerHTML = `<label style = " color : #D9301C ">O adversário venceu a partida com ${pointsAdversary} pontos!</label>`
        } else if (pointsPlayer > pointsAdversary) {
            resBattle.innerHTML = `<label style = " color : #016a2d ">O jogador é o grande vencedor da partida com ${pointsPlayer} pontos!</label>`
        } else {
            resBattle.innerHTML = `<label style = " color : #06777c ">Oloco meo! Ambos são igualmente bons!</label>`
        }
    }
}