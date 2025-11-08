function revisarFrente(casillas, boton, posRX, posRY, Rj, enemigo, color, turn){
    var posX = parseInt(posRX);
    var posY = parseInt(posRY);
    var j = parseInt(Rj);
    var casilla = posX;
    var CO = obtenerColor(turn);
    var move = casillas;
    var amenaza;
    //var amenaza = returnPosibilidades...
    if((posX > 0 && posX< 7)&&(posY > 0 && posY < 7)){
        for(var i = -1; i < 2; i++){
            if(i == 0){
                if(casillas[posX+j][posY+i] == ""){
                    var oldEnemigo = move[posX+j][posY+i];
                    move[posX][posY] = "";
                    move[posX+j][posY+i] = "P"+CO;
                    amenaza = returnPosibilidades(move,turn);    
                    if(amenaza){
                        move[posX][posY] = "P"+CO;
                        move[posX+j][posY+i] = oldEnemigo;
                    }
                    else{
                        boton[posX+j][posY+i].style.backgroundColor = "#0dff00";
                        move[posX][posY] = "P"+CO;
                        move[posX+j][posY+i] = oldEnemigo;
                    }
                }
                if(casillas[posX+j][posY+i] == "" && posX+(2*j) >= 0 && posY+i >= 0 && posX+(2*j) < 8 && posY+i < 8){
                    if(casilla == 1 && color == "N" && casillas[posX+(2*j)][posY+i] == ""){
                        var oldEnemigo = move[posX+j][posY+i];
                        move[posX][posY] = "";
                        move[posX+(2*j)][posY+i] = "P"+CO;
                        amenaza = returnPosibilidades(move,turn);    
                        if(amenaza){
                            move[posX][posY] = "P"+CO;
                            move[posX+(2*j)][posY+i] = oldEnemigo;
                        }
                        else{
                            boton[posX+(2*j)][posY+i].style.backgroundColor = "#0dff00";
                            move[posX][posY] = "P"+CO;
                            move[posX+(2*j)][posY+i] = oldEnemigo;
                        }
                    }
                    else if(casilla == 6 && color == "B" && casillas[posX+(2*j)][posY+i] == ""){
                        var oldEnemigo = move[posX+j][posY+i];
                        move[posX][posY] = "";
                        move[posX+(2*j)][posY+i] = "P"+CO;
                        amenaza = returnPosibilidades(move,turn);    
                        if(amenaza){
                            move[posX][posY] = "P"+CO;
                            move[posX+(2*j)][posY+i] = oldEnemigo;
                        }
                        else{
                            boton[posX+(2*j)][posY+i].style.backgroundColor = "#0dff00";
                            move[posX][posY] = "P"+CO;
                            move[posX+(2*j)][posY+i] = oldEnemigo;
                        }
                    }
                }
            }
            if(i == -1){
                if(casillas[posX+j][posY+i].length > 0 && casillas[posX+j][posY+i].substring(1,2) == enemigo){
                    var oldEnemigo = move[posX+j][posY+i];
                    move[posX][posY] = "";
                    move[posX+j][posY+i] = "P"+CO;
                    amenaza = returnPosibilidades(move,turn);    
                    if(amenaza){
                        move[posX][posY] = "P"+CO;
                        move[posX+j][posY+i] = oldEnemigo;
                    }
                    else{
                        boton[posX+j][posY+i].style.backgroundColor = "#0dff00";
                        move[posX][posY] = "P"+CO;
                        move[posX+j][posY+i] = oldEnemigo;
                    }
                }
            }
            if(i == 1){
                if(casillas[posX+j][posY+i].length > 0 && casillas[posX+j][posY+i].substring(1,2) == enemigo){
                    var oldEnemigo = move[posX+j][posY+i];
                    move[posX][posY] = "";
                    move[posX+j][posY+i] = "P"+CO;
                    amenaza = returnPosibilidades(move,turn);    
                    if(amenaza){
                        move[posX][posY] = "P"+CO;
                        move[posX+j][posY+i] = oldEnemigo;
                    }
                    else{
                        boton[posX+j][posY+i].style.backgroundColor = "#0dff00";
                        move[posX][posY] = "P"+CO;
                        move[posX+j][posY+i] = oldEnemigo;
                    }
                }
            }
        }
    }
    if((posX > 0 && posX < 7) && (posY == 0)){
        for(var i = 0; i < 2; i++){
            if(i == 0){
                if(casillas[posX + j][posY + i] == ""){
                    var oldEnemigo = move[posX+j][posY+i];
                    move[posX][posY] = "";
                    move[posX+j][posY+i] = "P"+CO;
                    amenaza = returnPosibilidades(move,turn);    
                    if(amenaza){
                        move[posX][posY] = "P"+CO;
                        move[posX+j][posY+i] = oldEnemigo;
                    }
                    else{
                        boton[posX+j][posY+i].style.backgroundColor = "#0dff00";
                        move[posX][posY] = "P"+CO;
                        move[posX+j][posY+i] = oldEnemigo;
                    }
                }
                if(casillas[posX + j][posY + i] == "" && posX+(2*j) >= 0 && posY+i >= 0 && posX+(2*j) < 8 && posY+i < 8){
                    if(casilla == 1 && color == "N" && casillas[posX + (2*j)][posY + i] == ""){
                        var oldEnemigo = move[posX+j][posY+i];
                        move[posX][posY] = "";
                        move[posX+(2*j)][posY+i] = "P"+CO;
                        amenaza = returnPosibilidades(move,turn);    
                        if(amenaza){
                            move[posX][posY] = "P"+CO;
                            move[posX+(2*j)][posY+i] = oldEnemigo;
                        }
                        else{
                            boton[posX+(2*j)][posY+i].style.backgroundColor = "#0dff00";
                            move[posX][posY] = "P"+CO;
                            move[posX+(2*j)][posY+i] = oldEnemigo;
                        }
                    }
                    else if(casilla == 6 && color == "B" && casillas[posX + (2*j)][posY + i] == ""){
                        var oldEnemigo = move[posX+j][posY+i];
                        move[posX][posY] = "";
                        move[posX+(2*j)][posY+i] = "P"+CO;
                        amenaza = returnPosibilidades(move,turn);    
                        if(amenaza){
                            move[posX][posY] = "P"+CO;
                            move[posX+(2*j)][posY+i] = oldEnemigo;
                        }
                        else{
                            boton[posX+(2*j)][posY+i].style.backgroundColor = "#0dff00";
                            move[posX][posY] = "P"+CO;
                            move[posX+(2*j)][posY+i] = oldEnemigo;
                        }
                    }
                }
            }
            if(i == 1){
                if(casillas[posX + j][posY + i].length > 0 && casillas[posX + j][posY + i].substring(1,2) == enemigo){
                    var oldEnemigo = move[posX+j][posY+i];
                    move[posX][posY] = "";
                    move[posX+j][posY+i] = "P"+CO;
                    amenaza = returnPosibilidades(move,turn);    
                    if(amenaza){
                        move[posX][posY] = "P"+CO;
                        move[posX+j][posY+i] = oldEnemigo;
                    }
                    else{
                        boton[posX+j][posY+i].style.backgroundColor = "#0dff00";
                        move[posX][posY] = "P"+CO;
                        move[posX+j][posY+i] = oldEnemigo;
                    }
                }
            }
        }
    }
    if((posX > 0 && posX < 7) && (posY == 7)){
        for(var i = -1; i < 1; i++){
            if(i == 0){
                if(casillas[posX + j][posY + i] == ""){
                    var oldEnemigo = move[posX+j][posY+i];
                    move[posX][posY] = "";
                    move[posX+j][posY+i] = "P"+CO;
                    amenaza = returnPosibilidades(move,turn);    
                    if(amenaza){
                        move[posX][posY] = "P"+CO;
                        move[posX+j][posY+i] = oldEnemigo;
                    }
                    else{
                        boton[posX+j][posY+i].style.backgroundColor = "#0dff00";
                        move[posX][posY] = "P"+CO;
                        move[posX+j][posY+i] = oldEnemigo;
                    }
                }
                if(casillas[posX + j][posY + i] == "" && posX+(2*j) >= 0 && posY+i >= 0 && posX+(2*j) < 8 && posY+i < 8){
                    if(casilla == 1 && color == "N" && casillas[posX + (2*j)][posY + i] == ""){
                        var oldEnemigo = move[posX+j][posY+i];
                        move[posX][posY] = "";
                        move[posX+(2*j)][posY+i] = "P"+CO;
                        amenaza = returnPosibilidades(move,turn);    
                        if(amenaza){
                            move[posX][posY] = "P"+CO;
                            move[posX+(2*j)][posY+i] = oldEnemigo;
                        }
                        else{
                            boton[posX+(2*j)][posY+i].style.backgroundColor = "#0dff00";
                            move[posX][posY] = "P"+CO;
                            move[posX+(2*j)][posY+i] = oldEnemigo;
                        }
                    }
                    else if(casilla == 6 && color == "B" && casillas[posX + (2*j)][posY + i] == ""){
                        var oldEnemigo = move[posX+j][posY+i];
                        move[posX][posY] = "";
                        move[posX+(2*j)][posY+i] = "P"+CO;
                        amenaza = returnPosibilidades(move,turn);    
                        if(amenaza){
                            move[posX][posY] = "P"+CO;
                            move[posX+(2*j)][posY+i] = oldEnemigo;
                        }
                        else{
                            boton[posX+(2*j)][posY+i].style.backgroundColor = "#0dff00";
                            move[posX][posY] = "P"+CO;
                            move[posX+(2*j)][posY+i] = oldEnemigo;
                        }
                    }
                }
            }
            if(i == -1){
                if(casillas[posX + j][posY + i].length > 0 && casillas[posX + j][posY + i].substring(1,2) == enemigo){
                    var oldEnemigo = move[posX+j][posY+i];
                    move[posX][posY] = "";
                    move[posX+j][posY+i] = "P"+CO;
                    amenaza = returnPosibilidades(move,turn);    
                    if(amenaza){
                        move[posX][posY] = "P"+CO;
                        move[posX+j][posY+i] = oldEnemigo;
                    }
                    else{
                        boton[posX+j][posY+i].style.backgroundColor = "#0dff00";
                        move[posX][posY] = "P"+CO;
                        move[posX+j][posY+i] = oldEnemigo;
                    }
                }
            }
        }
    }
}

function pintarLineas(casillas,boton,cambiarX,posX,cambiarY,posY,amigo,enemigo,turn){
    var CO = obtenerColor(turn);
    var move = casillas;
    var amenaza;
    if(posX > -1 && posX < 8){
        for(cambiarX = posX - 1; cambiarX > -1; cambiarX--){
            if(casillas[cambiarX][posY] == ""){
                var oldEnemigo = move[cambiarX][posY];
                var oldPieza = move[posX][posY]; 
                move[posX][posY] = "";
                move[cambiarX][posY] = oldPieza;
                amenaza = returnPosibilidades(move,turn);    
                if(amenaza){
                    move[posX][posY] = oldPieza;
                    move[cambiarX][posY] = oldEnemigo;
                }
                else{
                    boton[cambiarX][posY].style.backgroundColor = "#0dff00";
                    move[posX][posY] = oldPieza;
                    move[cambiarX][posY] = oldEnemigo;
                }
            }
            else if(casillas[cambiarX][posY].length > 0 && casillas[cambiarX][posY].substring(1,2) == amigo){
                break;
            }
            else if(casillas[cambiarX][posY].length > 0 && casillas[cambiarX][posY].substring(1,2) == enemigo){
                var oldEnemigo = move[cambiarX][posY];
                var oldPieza = move[posX][posY]; 
                move[posX][posY] = "";
                move[cambiarX][posY] = oldPieza;
                amenaza = returnPosibilidades(move,turn);    
                if(amenaza){
                    move[posX][posY] = oldPieza;
                    move[cambiarX][posY] = oldEnemigo;
                }
                else{
                    boton[cambiarX][posY].style.backgroundColor = "#0dff00";
                    move[posX][posY] = oldPieza;
                    move[cambiarX][posY] = oldEnemigo;
                }
                break;
            }
        }
        for(cambiarX = posX + 1; cambiarX < 8; cambiarX++){
            if(casillas[cambiarX][posY] == ""){
                var oldEnemigo = move[cambiarX][posY];
                var oldPieza = move[posX][posY]; 
                move[posX][posY] = "";
                move[cambiarX][posY] = oldPieza;
                amenaza = returnPosibilidades(move,turn);    
                if(amenaza){
                    move[posX][posY] = oldPieza;
                    move[cambiarX][posY] = oldEnemigo;
                }
                else{
                    boton[cambiarX][posY].style.backgroundColor = "#0dff00";
                    move[posX][posY] = oldPieza;
                    move[cambiarX][posY] = oldEnemigo;
                }
            }
            else if(casillas[cambiarX][posY].length > 0 && casillas[cambiarX][posY].substring(1,2) == amigo){
                break;
            }
            else if(casillas[cambiarX][posY].length > 0 && casillas[cambiarX][posY].substring(1,2) == enemigo){
                var oldEnemigo = move[cambiarX][posY];
                var oldPieza = move[posX][posY]; 
                move[posX][posY] = "";
                move[cambiarX][posY] = oldPieza;
                amenaza = returnPosibilidades(move,turn);    
                if(amenaza){
                    move[posX][posY] = oldPieza;
                    move[cambiarX][posY] = oldEnemigo;
                }
                else{
                    boton[cambiarX][posY].style.backgroundColor = "#0dff00";
                    move[posX][posY] = oldPieza;
                    move[cambiarX][posY] = oldEnemigo;
                }
                break;
            }
        }
    }
    if(posY > -1 && posY < 8){
        for(cambiarY = posY -1; cambiarY >-1; cambiarY--){
            if(casillas[posX][cambiarY] == ""){
                var oldEnemigo = move[posX][cambiarY];
                var oldPieza = move[posX][posY]; 
                move[posX][posY] = "";
                move[posX][cambiarY] = oldPieza;
                amenaza = returnPosibilidades(move,turn);    
                if(amenaza){
                    move[posX][posY] = oldPieza;
                    move[posX][cambiarY] = oldEnemigo;
                }
                else{
                    boton[posX][cambiarY].style.backgroundColor = "#0dff00";
                    move[posX][posY] = oldPieza;
                    move[posX][cambiarY] = oldEnemigo;
                }
            }
            else if(casillas[posX][cambiarY].length > 0 && casillas[posX][cambiarY].substring(1,2) == amigo){
                break;
            }
            else if(casillas[posX][cambiarY].length > 0 && casillas[posX][cambiarY].substring(1,2) == enemigo){
                var oldEnemigo = move[posX][cambiarY];
                var oldPieza = move[posX][posY]; 
                move[posX][posY] = "";
                move[posX][cambiarY] = oldPieza;
                amenaza = returnPosibilidades(move,turn);    
                if(amenaza){
                    move[posX][posY] = oldPieza;
                    move[posX][cambiarY] = oldEnemigo;
                }
                else{
                    boton[posX][cambiarY].style.backgroundColor = "#0dff00";
                    move[posX][posY] = oldPieza;
                    move[posX][cambiarY] = oldEnemigo;
                }
                break;
            }
        }
        for(cambiarY = posY +1; cambiarY <8; cambiarY++){
            if(casillas[posX][cambiarY] == ""){
                var oldEnemigo = move[posX][cambiarY];
                var oldPieza = move[posX][posY]; 
                move[posX][posY] = "";
                move[posX][cambiarY] = oldPieza;
                amenaza = returnPosibilidades(move,turn);    
                if(amenaza){
                    move[posX][posY] = oldPieza;
                    move[posX][cambiarY] = oldEnemigo;
                }
                else{
                    boton[posX][cambiarY].style.backgroundColor = "#0dff00";
                    move[posX][posY] = oldPieza;
                    move[posX][cambiarY] = oldEnemigo;
                }
            }
            else if(casillas[posX][cambiarY].length > 0 && casillas[posX][cambiarY].substring(1,2) == amigo){
                break;
            }
            else if(casillas[posX][cambiarY].length > 0 && casillas[posX][cambiarY].substring(1,2) == enemigo){
                var oldEnemigo = move[posX][cambiarY];
                var oldPieza = move[posX][posY]; 
                move[posX][posY] = "";
                move[posX][cambiarY] = oldPieza;
                amenaza = returnPosibilidades(move,turn);    
                if(amenaza){
                    move[posX][posY] = oldPieza;
                    move[posX][cambiarY] = oldEnemigo;
                }
                else{
                    boton[posX][cambiarY].style.backgroundColor = "#0dff00";
                    move[posX][posY] = oldPieza;
                    move[posX][cambiarY] = oldEnemigo;
                }
                break;
            }
        }
    }
}

function pintarL(casillas,boton,posX,posY,enemigo,turn){
    var CO = obtenerColor(turn);
    var move = casillas;
    var amenaza;
    if(posX -2 >= 0 && posX+1 >= 0 && posX-2 <8 && posY+1 < 8){
        if(casillas[posX-2][posY+1] == ""){
            var oldEnemigo = move[posX-2][posY+1];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX-2][posY+1] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX-2][posY+1] = oldEnemigo;
            }
            else{
                boton[posX-2][posY+1].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX-2][posY+1] = oldEnemigo;
            }
        }
        else if(casillas[posX-2][posY+1].substring(1,2) == enemigo){
            var oldEnemigo = move[posX-2][posY+1];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX-2][posY+1] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX-2][posY+1] = oldEnemigo;
            }
            else{
                boton[posX-2][posY+1].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX-2][posY+1] = oldEnemigo;
            }
        }
    }
    if(posX-2 >= 0 && posY-1 >= 0 && posX-2 < 8 && posY-1 < 8){
        if(casillas[posX-2][posY-1] == ""){
            var oldEnemigo = move[posX-2][posY-1];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX-2][posY-1] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX-2][posY-1] = oldEnemigo;
            }
            else{
                boton[posX-2][posY-1].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX-2][posY-1] = oldEnemigo;
            }
        }
        else if(casillas[posX-2][posY-1].substring(1,2) == enemigo){
            var oldEnemigo = move[posX-2][posY-1];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX-2][posY-1] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX-2][posY-1] = oldEnemigo;
            }
            else{
                boton[posX-2][posY-1].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX-2][posY-1] = oldEnemigo;
            }
        }
    }
    if(posX-1 >= 0 && posY+2 >= 0 && posX-1 < 8 && posY+2 < 8){
        if(casillas[posX-1][posY+2] == ""){
            var oldEnemigo = move[posX-1][posY+2];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX-1][posY+2] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX-1][posY+2] = oldEnemigo;
            }
            else{
                boton[posX-1][posY+2].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX-1][posY+2] = oldEnemigo;
            }
        }
        else if(casillas[posX-1][posY+2].substring(1,2) == enemigo){
            var oldEnemigo = move[posX-1][posY+2];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX-1][posY+2] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX-1][posY+2] = oldEnemigo;
            }
            else{
                boton[posX-1][posY+2].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX-1][posY+2] = oldEnemigo;
            }
        }
    }
    if(posX-1 >= 0 && posY-2 >= 0 && posX-1 < 8 && posY-2 < 8){
        if(casillas[posX-1][posY-2] == ""){
            var oldEnemigo = move[posX-1][posY-2];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX-1][posY-2] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX-1][posY-2] = oldEnemigo;
            }
            else{
                boton[posX-1][posY-2].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX-1][posY-2] = oldEnemigo;
            }
        }
        else if(casillas[posX-1][posY-2].substring(1,2) == enemigo){
            var oldEnemigo = move[posX-1][posY-2];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX-1][posY-2] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX-1][posY-2] = oldEnemigo;
            }
            else{
                boton[posX-1][posY-2].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX-1][posY-2] = oldEnemigo;
            }
        }
    }
    if(posX+2 >= 0 && posY+1 >= 0 && posX+2 < 8 && posY+1 < 8){
        if(casillas[posX+2][posY+1] == ""){
            var oldEnemigo = move[posX+2][posY+1];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX+2][posY+1] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX+2][posY+1] = oldEnemigo;
            }
            else{
                boton[posX+2][posY+1].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX+2][posY+1] = oldEnemigo;
            }
        }
        else if(casillas[posX+2][posY+1].substring(1,2) == enemigo){
            var oldEnemigo = move[posX+2][posY+1];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX+2][posY+1] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX+2][posY+1] = oldEnemigo;
            }
            else{
                boton[posX+2][posY+1].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX+2][posY+1] = oldEnemigo;
            }
        }
    }
    if(posX+2 >= 0 && posY-1 >= 0 && posX+2 < 8 && posY-1 < 8){
        if(casillas[posX+2][posY-1] == ""){
            var oldEnemigo = move[posX+2][posY-1];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX+2][posY-1] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX+2][posY-1] = oldEnemigo;
            }
            else{
                boton[posX+2][posY-1].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX+2][posY-1] = oldEnemigo;
            }
        }
        else if(casillas[posX+2][posY-1].substring(1,2) == enemigo){
            var oldEnemigo = move[posX+2][posY-1];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX+2][posY-1] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX+2][posY-1] = oldEnemigo;
            }
            else{
                boton[posX+2][posY-1].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX+2][posY-1] = oldEnemigo;
            }
        }
    }
    if(posX+1 >= 0 && posY+2 >= 0 && posX+1 < 8 && posY+2 < 8){
        if(casillas[posX+1][posY+2] == ""){
            var oldEnemigo = move[posX+1][posY+2];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX+1][posY+2] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX+1][posY+2] = oldEnemigo;
            }
            else{
                boton[posX+1][posY+2].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX+1][posY+2] = oldEnemigo;
            }
        }
        else if(casillas[posX+1][posY+2].substring(1,2) == enemigo){
            var oldEnemigo = move[posX+1][posY+2];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX+1][posY+2] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX+1][posY+2] = oldEnemigo;
            }
            else{
                boton[posX+1][posY+2].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX+1][posY+2] = oldEnemigo;
            }
        }
    }
    if(posX+1 >= 0 && posY-2 >= 0 && posX+1 < 8 && posY-2 < 8){
        if(casillas[posX+1][posY-2] == ""){
            var oldEnemigo = move[posX+1][posY-2];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX+1][posY-2] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX+1][posY-2] = oldEnemigo;
            }
            else{
                boton[posX+1][posY-2].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX+1][posY-2] = oldEnemigo;
            }
        }
        else if(casillas[posX+1][posY-2].substring(1,2) == enemigo){
            var oldEnemigo = move[posX+1][posY-2];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX+1][posY-2] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX+1][posY-2] = oldEnemigo;
            }
            else{
                boton[posX+1][posY-2].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX+1][posY-2] = oldEnemigo;
            }
        }
    }
}

function pintarDiagonales(casillas,boton,posX,posY,enemigo,turn){
    var i;
    var j;
    var k;
    var l;
    var CO = obtenerColor(turn);
    var move = casillas;
    var amenaza;
    for (i = 1; (posX+i<8)&&(posY+i<8); i++) {
        if(casillas[posX+i][posY+i] == ""){
            var oldEnemigo = move[posX+i][posY+i];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX+i][posY+i] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX+i][posY+i] = oldEnemigo;
            }
            else{
                boton[posX+i][posY+i].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX+i][posY+i] = oldEnemigo;
            }
        }
        else if(casillas[posX+i][posY+i].length > 0 && casillas[posX+i][posY+i].substring(1,2) == enemigo){
            var oldEnemigo = move[posX+i][posY+i];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX+i][posY+i] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX+i][posY+i] = oldEnemigo;
            }
            else{
                boton[posX+i][posY+i].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX+i][posY+i] = oldEnemigo;
            }
            break;
        }
        else{
            break;
        }
    }
    for(j = 1; ((posX-j > -1)&&(posY+j < 8)); j++){
        if(casillas[posX-j][posY+j] == ""){
            var oldEnemigo = move[posX-j][posY+j];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX-j][posY+j] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX-j][posY+j] = oldEnemigo;
            }
            else{
                boton[posX-j][posY+j].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX-j][posY+j] = oldEnemigo;
            }
        }
        else if(casillas[posX-j][posY+j].length > 0 && casillas[posX-j][posY+j].substring(1,2) == enemigo){
            var oldEnemigo = move[posX-j][posY+j];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX-j][posY+j] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX-j][posY+j] = oldEnemigo;
            }
            else{
                boton[posX-j][posY+j].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX-j][posY+j] = oldEnemigo;
            }
            break;
        }
        else{
            break;
        }
    }
    for(k = 1; (posX-k > -1) && (posY-k > -1); k++){
        if(casillas[posX-k][posY-k] == ""){
            var oldEnemigo = move[posX-k][posY-k];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX-k][posY-k] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX-k][posY-k] = oldEnemigo;
            }
            else{
                boton[posX-k][posY-k].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX-k][posY-k] = oldEnemigo;
            }
        }
        else if(casillas[posX-k][posY-k].length > 0 && casillas[posX-k][posY-k].substring(1,2) == enemigo){
            var oldEnemigo = move[posX-k][posY-k];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX-k][posY-k] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX-k][posY-k] = oldEnemigo;
            }
            else{
                boton[posX-k][posY-k].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX-k][posY-k] = oldEnemigo;
            }
            break;
        }
        else{
            break;
        }
    }
    for(l = 1; (posX+l < 8)&&(posY -l > -1);l++){
        if(casillas[posX+l][posY-l] == ""){
            var oldEnemigo = move[posX+l][posY-l];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX+l][posY-l] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX+l][posY-l] = oldEnemigo;
            }
            else{
                boton[posX+l][posY-l].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX+l][posY-l] = oldEnemigo;
            }
        }
        else if(casillas[posX+l][posY-l].length > 0 && casillas[posX+l][posY-l].substring(1,2) == enemigo){
            var oldEnemigo = move[posX+l][posY-l];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX+l][posY-l] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX+l][posY-l] = oldEnemigo;
            }
            else{
                boton[posX+l][posY-l].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX+l][posY-l] = oldEnemigo;
            }
            break;
        }
        else{
            break;
        }
    }
}

function pintarR(casillas, boton, posX, posY, amigo, turn){
    var CO = obtenerColor(turn);
    var move = casillas;
    var amenaza;
    if(posX-1 >= 0 && posY-1 >= 0 && posX-1 < 8 && posY-1 < 8){
        if(casillas[posX-1][posY-1] == ""){
            var oldEnemigo = move[posX-1][posY-1];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX-1][posY-1] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX-1][posY-1] = oldEnemigo;
            }
            else{
                boton[posX-1][posY-1].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX-1][posY-1] = oldEnemigo;
            }
        }
        else if(casillas[posX-1][posY-1].substring(1,2) != amigo){
            var oldEnemigo = move[posX-1][posY-1];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX-1][posY-1] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX-1][posY-1] = oldEnemigo;
            }
            else{
                boton[posX-1][posY-1].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX-1][posY-1] = oldEnemigo;
            }
        }
    }
    if(posX-1 >= 0 && posY >= 0 && posX-1 < 8 && posY < 8){
        if(casillas[posX-1][posY] == ""){
            var oldEnemigo = move[posX-1][posY];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX-1][posY] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX-1][posY] = oldEnemigo;
            }
            else{
                boton[posX-1][posY].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX-1][posY] = oldEnemigo;
            }
        }
        else if(casillas[posX-1][posY].substring(1,2) != amigo){
            var oldEnemigo = move[posX-1][posY];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX-1][posY] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX-1][posY] = oldEnemigo;
            }
            else{
                boton[posX-1][posY].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX-1][posY] = oldEnemigo;
            }
        }
    }
    if(posX-1 >= 0 && posY+1 >= 0 && posX-1 < 8 && posY+1 < 8){
        if(casillas[posX-1][posY+1] == ""){
            var oldEnemigo = move[posX-1][posY+1];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX-1][posY+1] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX-1][posY+1] = oldEnemigo;
            }
            else{
                boton[posX-1][posY+1].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX-1][posY+1] = oldEnemigo;
            }
        }
        else if(casillas[posX-1][posY+1].substring(1,2) != amigo){
            var oldEnemigo = move[posX-1][posY+1];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX-1][posY+1] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX-1][posY+1] = oldEnemigo;
            }
            else{
                boton[posX-1][posY+1].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX-1][posY+1] = oldEnemigo;
            }
        }
    }
    if(posX >= 0 && posY-1 >= 0 && posX < 8 && posY-1 < 8){
        if(casillas[posX][posY-1] == ""){
            var oldEnemigo = move[posX][posY-1];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX][posY-1] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX][posY-1] = oldEnemigo;
            }
            else{
                boton[posX][posY-1].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX][posY-1] = oldEnemigo;
            }
        }
        else if(casillas[posX][posY-1].substring(1,2) != amigo){
            var oldEnemigo = move[posX][posY-1];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX][posY-1] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX][posY-1] = oldEnemigo;
            }
            else{
                boton[posX][posY-1].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX][posY-1] = oldEnemigo;
            }
        }
    }
    if(posX >= 0 && posY+1 >= 0 && posX < 8 && posY+1 < 8){
        if(casillas[posX][posY+1] == ""){
            var oldEnemigo = move[posX][posY+1];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX][posY+1] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX][posY+1] = oldEnemigo;
            }
            else{
                boton[posX][posY+1].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX][posY+1] = oldEnemigo;
            }
        }
        else if(casillas[posX][posY+1].substring(1,2) != amigo){
            var oldEnemigo = move[posX][posY+1];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX][posY+1] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX][posY+1] = oldEnemigo;
            }
            else{
                boton[posX][posY+1].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX][posY+1] = oldEnemigo;
            }
        }
    }
    if(posX+1 >= 0 && posY-1 >= 0 && posX+1 < 8 && posY-1 < 8){
        if(casillas[posX+1][posY-1] == ""){
            var oldEnemigo = move[posX+1][posY-1];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX+1][posY-1] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX+1][posY-1] = oldEnemigo;
            }
            else{
                boton[posX+1][posY-1].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX+1][posY-1] = oldEnemigo;
            }
        }
        else if(casillas[posX+1][posY-1].substring(1,2) != amigo){
            var oldEnemigo = move[posX+1][posY-1];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX+1][posY-1] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX+1][posY-1] = oldEnemigo;
            }
            else{
                boton[posX+1][posY-1].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX+1][posY-1] = oldEnemigo;
            }
        }
    }
    if(posX+1 >= 0 && posY >= 0 && posX+1 < 8 && posY < 8){
        if(casillas[posX+1][posY] == ""){
            var oldEnemigo = move[posX+1][posY];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX+1][posY] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX+1][posY] = oldEnemigo;
            }
            else{
                boton[posX+1][posY].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX+1][posY] = oldEnemigo;
            }
        }
        else if(casillas[posX+1][posY].substring(1,2) != amigo){
            var oldEnemigo = move[posX+1][posY];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX+1][posY] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX+1][posY] = oldEnemigo;
            }
            else{
                boton[posX+1][posY].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX+1][posY] = oldEnemigo;
            }
        }
    }
    if(posX+1 >= 0 && posY+1 >= 0 && posX+1 < 8 && posY+1 < 8){
        if(casillas[posX+1][posY+1] == ""){
            var oldEnemigo = move[posX+1][posY+1];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX+1][posY+1] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX+1][posY+1] = oldEnemigo;
            }
            else{
                boton[posX+1][posY+1].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX+1][posY+1] = oldEnemigo;
            }
        }
        else if(casillas[posX+1][posY+1].substring(1,2) != amigo){
            var oldEnemigo = move[posX+1][posY+1];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[posX+1][posY+1] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[posX+1][posY+1] = oldEnemigo;
            }
            else{
                boton[posX+1][posY+1].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[posX+1][posY+1] = oldEnemigo;
            }
        }
    }
    if(amigo == "B"){
        if(posX == 7 && posY == 4 && casillas[7][5] == "" && casillas[7][6] == "" && casillas[7][7] == "TB"){
            var oldEnemigo = move[7][6];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[7][6] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[7][6] = oldEnemigo;
            }
            else{
                boton[7][6].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[7][6] = oldEnemigo;
            }
        }
        if(posX == 7 && posY == 4 && casillas[7][3] == "" && casillas[7][2] == "" && casillas[7][1] == "" && casillas[7][0] == "TB"){
            var oldEnemigo = move[7][2];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[7][2] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[7][2] = oldEnemigo;
            }
            else{
                boton[7][2].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[7][2] = oldEnemigo;
            }
        }
    }
    if(amigo == "N"){
        if(posX == 0 && posY == 4 && casillas[0][5] == "" && casillas[0][6] == "" && casillas[0][7] == "TN"){
            var oldEnemigo = move[0][6];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[0][6] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[0][6] = oldEnemigo;
            }
            else{
                boton[0][6].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[0][6] = oldEnemigo;
            }
        }
        if(posX == 0 && posY == 4 && casillas[0][3] == "" && casillas[0][2] == "" && casillas[0][1] == "" && casillas[0][0] == "TN"){
            var oldEnemigo = move[0][2];
            var oldPieza = move[posX][posY]; 
            move[posX][posY] = "";
            move[0][2] = oldPieza;
            amenaza = returnPosibilidades(move,turn);    
            if(amenaza){
                move[posX][posY] = oldPieza;
                move[0][2] = oldEnemigo;
            }
            else{
                boton[0][2].style.backgroundColor = "#0dff00";
                move[posX][posY] = oldPieza;
                move[0][2] = oldEnemigo;
            }
        }
    }
}

function obtenerColor(turn) {
    var res;
    if(turn == 'N'){
        res = 'B';
    }
    else{
        res = 'N';
    }
    return res;
}