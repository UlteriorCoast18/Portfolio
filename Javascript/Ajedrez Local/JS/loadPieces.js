function moverPieza(pieza, newPosX, newPosY, oldPosX, oldPosY, boton, casillas, turn, Mov){
    if(turn == "B" && boton[newPosX][newPosY].style.backgroundColor == green){
        repaint(boton);
        casillas[oldPosX][oldPosY] = "";
        casillas[newPosX][newPosY] = pieza;
        if(pieza == "PB"){
            repaint(boton);
            if(newPosX == 0){
                actBotones(boton,true);
                generarBlancos(casillas,boton,oldPosX,oldPosY,newPosX,newPosY);
            }
            else{
                boton[oldPosX][oldPosY].className = "buttonB";
                boton[newPosX][newPosY].className = "buttonB" + " peonB";
                repaint(boton);
            }
        }
        if(pieza == "CB"){
            boton[oldPosX][oldPosY].className = "buttonB";
            boton[newPosX][newPosY].className = "buttonB" + " caballoB";
            repaint(boton);
        }
        if(pieza == "AB"){
            boton[oldPosX][oldPosY].className = "buttonB";
            boton[newPosX][newPosY].className = "buttonB" + " alfilB";
            repaint(boton);
        }
        if(pieza == "TB"){
            boton[oldPosX][oldPosY].className = "buttonB";
            boton[newPosX][newPosY].className = "buttonB" + " torreB";
            repaint(boton);
        }
        if(pieza == "DB"){
            boton[oldPosX][oldPosY].className = "buttonB";
            boton[newPosX][newPosY].className = "buttonB" + " damaB";
            repaint(boton);
        }
        if(pieza == "RB"){
            repaint(boton);
            if(oldPosX == 7 && oldPosY == 4 && newPosX == 7 && newPosY == 6){
                boton[oldPosX][oldPosY].className = "buttonB";
                boton[newPosX][newPosY].className = "buttonB" + " reyB";
                boton[7][7].className = "buttonB";
                casillas[7][7] = "";
                boton[7][5].className = "buttonB torreB";
                casillas[7][5] = "TB";
                repaint(boton);
            }
            else if(oldPosX == 7 && oldPosY == 4 && newPosX == 7 && newPosY == 2){
                boton[oldPosX][oldPosY].className = "buttonB";
                boton[newPosX][newPosY].className = "buttonB" + " reyB";
                boton[7][0].className = "buttonB";
                casillas[7][0] = "";
                boton[7][3].className = "buttonB torreB";
                casillas[7][3] = "TB";
                repaint(boton);
            }
            else{
                boton[oldPosX][oldPosY].className = "buttonB";
                boton[newPosX][newPosY].className = "buttonB" + " reyB";
                repaint(boton);
            }
        }
    }
    else if(turn == "N" && boton[newPosX][newPosY].style.backgroundColor == green){
        repaint(boton);
        casillas[oldPosX][oldPosY] = "";
        casillas[newPosX][newPosY] = pieza;
        if(pieza == "PN"){
            if(newPosX == 7){
                actBotones(boton,true);
                generarNegros(casillas,boton,oldPosX,oldPosY,newPosX,newPosY);
            }
            else{
                boton[oldPosX][oldPosY].className = "buttonN";
                boton[newPosX][newPosY].className = "buttonN" + " peonN";
                repaint(boton);
            }
        }
        if(pieza == "CN"){
            boton[oldPosX][oldPosY].className = "buttonN";
            boton[newPosX][newPosY].className = "buttonN" + " caballoN";
            repaint(boton);
        }
        if(pieza == "AN"){
            boton[oldPosX][oldPosY].className = "buttonN";
            boton[newPosX][newPosY].className = "buttonN" + " alfilN";
            repaint(boton);
        }
        if(pieza == "TN"){
            boton[oldPosX][oldPosY].className = "buttonN";
            boton[newPosX][newPosY].className = "buttonN" + " torreN";
            repaint(boton);
        }
        if(pieza == "DN"){
            boton[oldPosX][oldPosY].className = "buttonN";
            boton[newPosX][newPosY].className = "buttonN" + " damaN";
            repaint(boton);
        }
        if(pieza == "RN"){
            repaint(boton);
            if(oldPosX == 0 && oldPosY == 4 && newPosX == 0 && newPosY == 6){
                boton[oldPosX][oldPosY].className = "buttonN";
                boton[newPosX][newPosY].className = "buttonN" + " reyN";
                boton[0][7].className = "buttonN";
                casillas[0][7] = "";
                boton[0][5].className = "buttonN torreN";
                casillas[0][5] = "TN";
                repaint(boton);
            }
            else if(oldPosX == 0 && oldPosY == 4 && newPosX == 0 && newPosY == 2){
                boton[oldPosX][oldPosY].className = "buttonN";
                boton[newPosX][newPosY].className = "buttonN" + " reyN";
                boton[0][0].className = "buttonN";
                casillas[0][0] = "";
                boton[0][3].className = "buttonN torreN";
                casillas[0][3] = "TN";
                repaint(boton);
            }
            else{
                boton[oldPosX][oldPosY].className = "buttonN";
                boton[newPosX][newPosY].className = "buttonN" + " reyN";
                repaint(boton);
            }
        }
    }
}

function generarBlancos(casillas,boton,oldPosX,oldPosY,newPosX,newPosY){
    var caballo = document.createElement("button");
    var alfil = document.createElement("button");
    var torre = document.createElement("button");
    var dama = document.createElement("button");

    caballo.type = "button";
    alfil.type = "button";
    torre.type = "button";
    dama.type = "button";

    caballo.id = "CB";
    alfil.id = "AB";
    torre.id = "TB";
    dama.id = "DB";

    caballo.className = "buttonB caballoB";
    alfil.className = "buttonN alfilB";
    torre.className = "buttonB torreB";
    dama.className = "buttonN damaB";

    document.getElementById("coronarDiv").appendChild(caballo);
    document.getElementById("coronarDiv").appendChild(alfil);
    document.getElementById("coronarDiv").appendChild(torre);
    document.getElementById("coronarDiv").appendChild(dama);

    caballo.addEventListener("click", function(evt){
        var piece = evt.target.id;
        casillas[newPosX][newPosY] = piece;
        boton[oldPosX][oldPosY].className = "buttonB";
        boton[newPosX][newPosY].className = "buttonB" + " caballoB";
        actBotones(boton,false);
        var list = document.getElementById("coronarDiv");
        while(list.hasChildNodes()){
            list.removeChild(list.firstChild);
        }
        repaint(boton);
    });

    alfil.addEventListener("click", function(evt){
        var piece = evt.target.id;
        casillas[newPosX][newPosY] = piece;
        boton[oldPosX][oldPosY].className = "buttonB";
        boton[newPosX][newPosY].className = "buttonB" + " alfilB";
        actBotones(boton,false);
        var list = document.getElementById("coronarDiv");
        while(list.hasChildNodes()){
            list.removeChild(list.firstChild);
        }
        repaint(boton);
    });

    torre.addEventListener("click", function(evt){
        var piece = evt.target.id;
        casillas[newPosX][newPosY] = piece;
        boton[oldPosX][oldPosY].className = "buttonB";
        boton[newPosX][newPosY].className = "buttonB" + " torreB";
        actBotones(boton,false);
        var list = document.getElementById("coronarDiv");
        while(list.hasChildNodes()){
            list.removeChild(list.firstChild);
        }
        repaint(boton);
    });

    dama.addEventListener("click", function(evt){
        var piece = evt.target.id;
        casillas[newPosX][newPosY] = piece;
        boton[oldPosX][oldPosY].className = "buttonB";
        boton[newPosX][newPosY].className = "buttonB" + " damaB";
        actBotones(boton,false);
        var list = document.getElementById("coronarDiv");
        while(list.hasChildNodes()){
            list.removeChild(list.firstChild);
        }
        repaint(boton);
    });
}

function generarNegros(casillas,boton,oldPosX,oldPosY,newPosX,newPosY){
    var caballo = document.createElement("button");
    var alfil = document.createElement("button");
    var torre = document.createElement("button");
    var dama = document.createElement("button");

    caballo.type = "button";
    alfil.type = "button";
    torre.type = "button";
    dama.type = "button";

    caballo.id = "CN";
    alfil.id = "AN";
    torre.id = "TN";
    dama.id = "DN";

    caballo.className = "buttonN caballoN";
    alfil.className = "buttonB alfilN";
    torre.className = "buttonN torreN";
    dama.className = "buttonB damaN";

    document.getElementById("coronarDiv").appendChild(caballo);
    document.getElementById("coronarDiv").appendChild(alfil);
    document.getElementById("coronarDiv").appendChild(torre);
    document.getElementById("coronarDiv").appendChild(dama);

    caballo.addEventListener("click", function(evt){
        var piece = evt.target.id;
        casillas[newPosX][newPosY] = piece;
        boton[oldPosX][oldPosY].className = "buttonN";
        boton[newPosX][newPosY].className = "buttonN" + " caballoN";
        actBotones(boton,false);
        var list = document.getElementById("coronarDiv");
        while(list.hasChildNodes()){
            list.removeChild(list.firstChild);
        }
        repaint(boton);
    });

    alfil.addEventListener("click", function(evt){
        var piece = evt.target.id;
        casillas[newPosX][newPosY] = piece;
        boton[oldPosX][oldPosY].className = "buttonN";
        boton[newPosX][newPosY].className = "buttonN" + " alfilN";
        actBotones(boton,false);
        var list = document.getElementById("coronarDiv");
        while(list.hasChildNodes()){
            list.removeChild(list.firstChild);
        }
        repaint(boton);
    });

    torre.addEventListener("click", function(evt){
        var piece = evt.target.id;
        casillas[newPosX][newPosY] = piece;
        boton[oldPosX][oldPosY].className = "buttonN";
        boton[newPosX][newPosY].className = "buttonN" + " torreN";
        actBotones(boton,false);
        var list = document.getElementById("coronarDiv");
        while(list.hasChildNodes()){
            list.removeChild(list.firstChild);
        }
        repaint(boton);
    });

    dama.addEventListener("click", function(evt){
        var piece = evt.target.id;
        casillas[newPosX][newPosY] = piece;
        boton[oldPosX][oldPosY].className = "buttonN";
        boton[newPosX][newPosY].className = "buttonN" + " damaN";
        actBotones(boton,false);
        var list = document.getElementById("coronarDiv");
        while(list.hasChildNodes()){
            list.removeChild(list.firstChild);
        }
        repaint(boton);
    });
}

function actBotones(boton,act){
    for(var i = 0; i < 8; i++){
        for(var j = 0; j < 8; j++){
            boton[i][j].disabled = act;
        }
    }
}