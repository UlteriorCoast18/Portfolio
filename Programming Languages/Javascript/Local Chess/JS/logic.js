let turn = 'B';
let selected = false;

const green = "rgb(13, 255, 0)";

var boton = new Array(8);
var casillas = new Array(8);
var lastPiece;
var lastPosX;
var lastPosY;

var Mov = document.getElementById("text");

function addButton(){
    for (let z = 0; z < 8; z++) {
        boton[z] = new Array(8);
        casillas[z] = new Array(8);
    }
    for(var i = 0; i < 8; i++){
        for(var j = 0; j < 8; j++){
            boton[i][j] = document.createElement("button");
            boton[i][j].type = "button";
            boton[i][j].id = i+","+j;
            if(i%2 == 1 && j%2 == 1){
                boton[i][j].className = "buttonB";
                document.getElementById("mainDiv").appendChild(boton[i][j]);
            }
            else if(i%2 == 0 && j%2 == 0){
                boton[i][j].className = "buttonB";
                document.getElementById("mainDiv").appendChild(boton[i][j]);
            }
            else{
                boton[i][j].className = "buttonN";
                document.getElementById("mainDiv").appendChild(boton[i][j]);
            }
        }
    }
    casillas = generateCasillas(boton, casillas);
    boton = generateBoton(boton, casillas);
    for(var i = 0; i < 8; i++){
        for(var j = 0; j < 8; j++){
            boton[i][j].addEventListener("click", function(evt){
                var RBoton = evt.target.id;
                var posX = RBoton.substring(0,1);
                var posY = RBoton.substring(2,3);
                obtainLetter(posX,posY,casillas);
            });
        }
    }
}

function obtainLetter(posX,posY,casillas){
    if(selected && turn == 'B'){
        if(boton[posX][posY].style.backgroundColor == green){
            moverPieza(casillas[lastPosX][lastPosY],parseInt(posX),parseInt(posY),parseInt(lastPosX),parseInt(lastPosY),boton,casillas,turn,Mov);
            var mate = isMate(casillas,turn);
            if(mate == false){
                selected = false;
                turn = 'N';
            }
            else{
                actBotones(boton,true);
                alert("GG, los blancos ganaron");
            }
        }
        else{
            selected = false;
            repaint(boton);
        }
    }
    else if(selected && turn == 'N'){
        if(boton[posX][posY].style.backgroundColor == green){
            moverPieza(casillas[lastPosX][lastPosY],parseInt(posX),parseInt(posY),parseInt(lastPosX),parseInt(lastPosY),boton,casillas,turn,Mov);
            var mate = isMate(casillas,turn);
            if(mate == false){
                selected = false;
                turn = 'B';
            }
            else{
                actBotones(boton,true);
                alert("GG, los negros ganaron");
            }
        }
        else{
            selected = false;
            repaint(boton);
        }
    }
    else if(casillas[posX][posY] == ""){
        repaint(boton);
    }
    else{
        if(casillas[posX][posY].substring(1,2) == "B" && turn == 'B'){
            repaint(boton);
            switch(casillas[posX][posY]){
                case "PB":
                    Peon(casillas, boton, posX, posY, "N");
                break;
                case "TB":
                    Torre(casillas, boton, posX, posY, "N");
                break;
                case "CB":
                    Caballo(casillas, boton, posX, posY, "N");
                break;
                case "AB":
                    Alfil(casillas, boton, posX, posY, "N");
                break;
                case "DB":
                    Dama(casillas, boton, posX, posY, "N");
                break;
                case "RB":
                    Rey(casillas, boton, posX, posY, "B", "N");
                break;
            }
            lastPiece = casillas[posX][posY];
            lastPosX = posX;
            lastPosY = posY;
            selected = true;
        }
        else if(casillas[posX][posY].substring(1,2) == "N" && turn == 'N'){
            repaint(boton);
            switch(casillas[posX][posY]){
                case "PN":
                    Peon(casillas, boton, posX, posY, "B");
                break;
                case "TN":
                    Torre(casillas, boton, posX, posY, "B");
                break;
                case "CN":
                    Caballo(casillas, boton, posX, posY, "B");
                break;
                case "AN":
                    Alfil(casillas, boton, posX, posY, "B");
                break;
                case "DN":
                    Dama(casillas, boton, posX, posY, "B");
                break;
                case "RN":
                    Rey(casillas, boton, posX, posY, "N", "B");
                break;
            }
            lastPiece = casillas[posX][posY];
            lastPosX = posX;
            lastPosY = posY;
            selected = true;
        }
        else{
            return;
        }
    }
}

function generateCasillas(boton, casillas){
    for(var i = 0; i < 8; i++){
        for(var j = 0; j < 8; j++){
            if(i == 1){
                boton[i][j].className = boton[i][j].className + " peonN";
                casillas[i][j] = "PN";
            }
            else if(i == 6){
                boton[i][j].className = boton[i][j].className + " peonB";
                casillas[i][j] = "PB";
            }
            else if(i == 0 && (j == 1 || j == 6)){
                boton[i][j].className = boton[i][j].className + " caballoN";
                casillas[i][j] = "CN";
            }
            else if(i == 7 && (j == 1 || j == 6)){
                boton[i][j].className = boton[i][j].className + " caballoB";
                casillas[i][j] = "CB";
            }
            else if(i == 0 && (j == 2 || j == 5)){
                boton[i][j].className = boton[i][j].className + " alfilN";
                casillas[i][j] = "AN";
            }
            else if(i == 7 && (j == 2 || j == 5)){
                boton[i][j].className = boton[i][j].className + " alfilB";
                casillas[i][j] = "AB";
            }
            else if(i == 0 && (j == 0 || j == 7)){
                boton[i][j].className = boton[i][j].className + " torreN";
                casillas[i][j] = "TN";
            }
            else if(i == 7 && (j == 0 || j == 7)){
                boton[i][j].className = boton[i][j].className + " torreB";
                casillas[i][j] = "TB";
            }
            else if(i == 0 && j == 3){
                boton[i][j].className = boton[i][j].className + " damaN";
                casillas[i][j] = "DN";
            }
            else if(i == 7 && j == 3){
                boton[i][j].className = boton[i][j].className + " damaB";
                casillas[i][j] = "DB";
            }
            else if(i == 0 && j == 4){
                boton[i][j].className = boton[i][j].className + " reyN";
                casillas[i][j] = "RN";
            }
            else if(i == 7 && j == 4){
                boton[i][j].className = boton[i][j].className + " reyB";
                casillas[i][j] = "RB";
            }
            else{
                casillas[i][j] = "";
            }
        }
    }
    return casillas;
}

function generateBoton(boton, casillas){
    for(var i = 0; i < 8; i++){
        for(var j = 0; j < 8; j++){
            if(i == 1){
                boton[i][j].className = boton[i][j].className + " peonN";
                casillas[i][j] = "PN";
            }
            else if(i == 6){
                boton[i][j].className = boton[i][j].className + " peonB";
                casillas[i][j] = "PB";
            }
            else if(i == 0 && (j == 1 || j == 6)){
                boton[i][j].className = boton[i][j].className + " caballoN";
                casillas[i][j] = "CN";
            }
            else if(i == 7 && (j == 1 || j == 6)){
                boton[i][j].className = boton[i][j].className + " caballoB";
                casillas[i][j] = "CB";
            }
            else if(i == 0 && (j == 2 || j == 5)){
                boton[i][j].className = boton[i][j].className + " alfilN";
                casillas[i][j] = "AN";
            }
            else if(i == 7 && (j == 2 || j == 5)){
                boton[i][j].className = boton[i][j].className + " alfilB";
                casillas[i][j] = "AB";
            }
            else if(i == 0 && (j == 0 || j == 7)){
                boton[i][j].className = boton[i][j].className + " torreN";
                casillas[i][j] = "TN";
            }
            else if(i == 7 && (j == 0 || j == 7)){
                boton[i][j].className = boton[i][j].className + " torreB";
                casillas[i][j] = "TB";
            }
            else if(i == 0 && j == 3){
                boton[i][j].className = boton[i][j].className + " damaN";
                casillas[i][j] = "DN";
            }
            else if(i == 7 && j == 3){
                boton[i][j].className = boton[i][j].className + " damaB";
                casillas[i][j] = "DB";
            }
            else if(i == 0 && j == 4){
                boton[i][j].className = boton[i][j].className + " reyN";
                casillas[i][j] = "RN";
            }
            else if(i == 7 && j == 4){
                boton[i][j].className = boton[i][j].className + " reyB";
                casillas[i][j] = "RB";
            }
            else{
                casillas[i][j] = "";
            }
        }
    }
    return boton;
}

function repaint(boton){
    for(var i = 0; i < 8; i++){
        for(var j = 0; j < 8; j++){
            if(i%2 == 1 && j%2 == 1){
                boton[i][j].style.backgroundColor = "#dadada";
            }
            else if(i%2 == 0 && j%2 == 0){
                boton[i][j].style.backgroundColor = "#dadada";
            }
            else{
                boton[i][j].style.backgroundColor = "#888888";
            }
        }
    }
}