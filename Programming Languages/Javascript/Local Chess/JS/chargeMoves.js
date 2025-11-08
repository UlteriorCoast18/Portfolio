function Peon(casillas, boton, posX, posY, turn){
    var j;
    var enemigo;
    repaint(boton);
    if(casillas[posX][posY].substring(1,2).toUpperCase() == "B"){
        j = -1;
        enemigo = "N";
        revisarFrente(casillas, boton, posX, posY, j, enemigo, "B", turn);
    }
    else{
        j = 1;
        enemigo = "B";
        revisarFrente(casillas, boton, posX, posY, j, enemigo, "N", turn);
    }
}

function Torre(casillas, boton, posX, posY, turn){
    var cambiarX;
    var cambiarY;
    repaint(boton);
    if(casillas[posX][posY].substring(1,2) == "N"){
        cambiarX = 0;
        cambiarY = 0;
        pintarLineas(casillas,boton,cambiarX,parseInt(posX),cambiarY,parseInt(posY),"N","B",turn);
    }
    else{
        cambiarX = 7;
        cambiarY = 7;
        pintarLineas(casillas,boton,cambiarX,parseInt(posX),cambiarY,parseInt(posY),"B","N",turn);
    }
}

function Caballo(casillas, boton, posX, posY, turn){
    repaint(boton);
    if(casillas[posX][posY].substring(1,2) == "N"){
        pintarL(casillas,boton,parseInt(posX),parseInt(posY),"B",turn);
    }
    else{
        pintarL(casillas,boton,parseInt(posX),parseInt(posY),"N",turn);
    }
}

function Alfil(casillas, boton, posX, posY, turn){
    repaint(boton);
    if(casillas[posX][posY].substring(1,2) == "N"){
        pintarDiagonales(casillas,boton,parseInt(posX),parseInt(posY),"B",turn);
    }
    else{
        pintarDiagonales(casillas,boton,parseInt(posX),parseInt(posY),"N",turn);
    }
}

function Dama(casillas, boton, posX, posY, turn){
    var cambiarX;
    var cambiarY;
    repaint(boton);
    if(casillas[posX][posY].substring(1,2) == "N"){
        cambiarX = 0;
        cambiarY = 0;
        pintarLineas(casillas,boton,cambiarX,parseInt(posX),cambiarY,parseInt(posY),"N","B",turn);
        pintarDiagonales(casillas,boton,parseInt(posX),parseInt(posY),"B",turn);
    }
    else{
        cambiarX = 7;
        cambiarY = 7;
        pintarLineas(casillas,boton,cambiarX,parseInt(posX),cambiarY,parseInt(posY),"B","N",turn);
        pintarDiagonales(casillas,boton,parseInt(posX),parseInt(posY),"N",turn);
    }
}

function Rey(casillas,boton,posX,posY,amigo,turn){
    repaint(boton);
    if(amigo == "B"){
        pintarR(casillas,boton,parseInt(posX),parseInt(posY),amigo,turn);
    }
    else{
        pintarR(casillas,boton,parseInt(posX),parseInt(posY),amigo,turn);
    }
}