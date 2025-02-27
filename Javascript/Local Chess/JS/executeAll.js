function returnPosibilidades(casillas,turn){
    var amenaza = false;
    var ataques = new Array(8);
    for(let z = 0; z < 8; z++){
        ataques[z] = new Array(8);
    }
    var res = new Array();
    var posXR = 0;
    var posYR = 0;
    for(var i = 0; i < 8; i++){
        for(var j = 0; j < 8; j++){
            if(turn == "B"){
                if(casillas[i][j] == "PB"){
                    res = PeonV(casillas,i,j);
                    if(res.length == 0){
                    }
                    else{
                        for(var k = 0; k < res.length; k++){
                            if(res[k] == ""){
                            }
                            else{
                                var posX = parseInt(res[k].substring(0,1));
                                var posY = parseInt(res[k].substring(2,3));
                                ataques[posX][posY] = "■";
                            }
                        }
                    }
                }
                if(casillas[i][j] == "AB"){
                    res = AlfilV(casillas,i,j);
                    if(res.length == 0){
                    }
                    else{
                        for(var k = 0; k < res.length; k++){
                            if(res[k] == ""){
                            }
                            else{
                                var posX = parseInt(res[k].substring(0,1));
                                var posY = parseInt(res[k].substring(2,3));
                                ataques[posX][posY] = "■";
                            }
                        }
                    }
                }
                if(casillas[i][j] == "CB"){
                    res = CaballoV(casillas,i,j);
                    if(res.length == 0){
                    }
                    else{
                        for(var k = 0; k < res.length; k++){
                            if(res[k] == ""){
                            }
                            else{
                                var posX = parseInt(res[k].substring(0,1));
                                var posY = parseInt(res[k].substring(2,3));
                                ataques[posX][posY] = "■";
                            }
                        }
                    }
                }
                if(casillas[i][j] == "TB"){
                    res = TorreV(casillas,i,j);
                    if(res.length == 0){
                    }
                    else{
                        for(var k = 0; k < res.length; k++){
                            if(res[k] == ""){
                            }
                            else{
                                var posX = parseInt(res[k].substring(0,1));
                                var posY = parseInt(res[k].substring(2,3));
                                ataques[posX][posY] = "■";
                            }
                        }
                    }
                }
                if(casillas[i][j] == "DB"){
                    res = DamaV(casillas,i,j);
                    if(res.length == 0){
                    }
                    else{
                        for(var k = 0; k < res.length; k++){
                            if(res[k] == ""){
                            }
                            else{
                                var posX = parseInt(res[k].substring(0,1));
                                var posY = parseInt(res[k].substring(2,3));
                                ataques[posX][posY] = "■";
                            }
                        }
                    }
                }
                if(casillas[i][j] == "RB"){
                    res = ReyV(casillas,i,j,"B");
                    if(res.length == 0){
                    }
                    else{
                        for(var k = 0; k < res.length; k++){
                            if(res[k] == ""){
                            }
                            else{
                                var posX = parseInt(res[k].substring(0,1));
                                var posY = parseInt(res[k].substring(2,3));
                                ataques[posX][posY] = "■";
                            }
                        }
                    }
                }
                if(casillas[i][j] == "RN"){
                    posXR = i;
                    posYR = j;
                }
            }
            else if(turn == "N"){
                if(casillas[i][j] == "PN"){
                    res = PeonV(casillas,i,j);
                    if(res.length == 0){
                    }
                    else{
                        for(var k = 0; k < res.length; k++){
                            if(res[k] == ""){
                            }
                            else{
                                var posX = parseInt(res[k].substring(0,1));
                                var posY = parseInt(res[k].substring(2,3));
                                ataques[posX][posY] = "■";
                            }
                        }
                    }
                }
                if(casillas[i][j] == "AN"){
                    res = AlfilV(casillas,i,j);
                    if(res.length == 0){
                    }
                    else{
                        for(var k = 0; k < res.length; k++){
                            if(res[k] == ""){
                            }
                            else{
                                var posX = parseInt(res[k].substring(0,1));
                                var posY = parseInt(res[k].substring(2,3));
                                ataques[posX][posY] = "■";
                            }
                        }
                    }
                }
                if(casillas[i][j] == "CN"){
                    res = CaballoV(casillas,i,j);
                    if(res.length == 0){
                    }
                    else{
                        for(var k = 0; k < res.length; k++){
                            if(res[k] == ""){
                            }
                            else{
                                var posX = parseInt(res[k].substring(0,1));
                                var posY = parseInt(res[k].substring(2,3));
                                ataques[posX][posY] = "■";
                            }
                        }
                    }
                }
                if(casillas[i][j] == "TN"){
                    res = TorreV(casillas,i,j);
                    if(res.length == 0){
                    }
                    else{
                        for(var k = 0; k < res.length; k++){
                            if(res[k] == ""){
                            }
                            else{
                                var posX = parseInt(res[k].substring(0,1));
                                var posY = parseInt(res[k].substring(2,3));
                                ataques[posX][posY] = "■";
                            }
                        }
                    }
                }
                if(casillas[i][j] == "DN"){
                    res = DamaV(casillas,i,j);
                    if(res.length == 0){
                    }
                    else{
                        for(var k = 0; k < res.length; k++){
                            if(res[k] == ""){
                            }
                            else{
                                var posX = parseInt(res[k].substring(0,1));
                                var posY = parseInt(res[k].substring(2,3));
                                ataques[posX][posY] = "■";
                            }
                        }
                    }
                }
                if(casillas[i][j] == "RN"){
                    res = ReyV(casillas,i,j,"N");
                    if(res.length == 0){
                    }
                    else{
                        for(var k = 0; k < res.length; k++){
                            if(res[k] == ""){
                            }
                            else{
                                var posX = parseInt(res[k].substring(0,1));
                                var posY = parseInt(res[k].substring(2,3));
                                ataques[posX][posY] = "■";
                            }
                        }
                    }
                }
                if(casillas[i][j] == "RB"){
                    posXR = i;
                    posYR = j;
                }
            }
        }
    }
    for(var k = 0; k < 8; k++){
        for(var l = 0; l < 8; l++){
            if(ataques[k][l] != undefined){
                if (k == posXR && l == posYR) {
                    amenaza = true;
                    console.log(amenaza);
                }
            }
            else{
                ataques[k][l] = "□";
            }
        }
    }
    return amenaza;
}

function revisarFrenteV(casillas,posX,posY,j,enemigo,color){
    var pos = new Array(81);
    var z = 0;
    var casilla = posX;
    if((posX > 0 && posX< 7)&&(posY > 0 && posY < 7)){
        for(var i = -1; i < 2; i++){
            if(i == 0){
            }
            if(i == -1){
                if(casillas[posX+j][posY+i] == ""){
                    pos[z] = (posX+j) + "," + (posY+i);
                    z++;
                }
                if(casillas[posX+j][posY+i].length > 0 && casillas[posX+j][posY+i].substring(1,2) == enemigo){
                    pos[z] = (posX+j) + "," + (posY+i);
                    z++;
                }
            }
            if(i == 1){
                if(casillas[posX+j][posY+i] == ""){
                    pos[z] = (posX+j) + "," + (posY+i);
                    z++;
                }
                if(casillas[posX+j][posY+i].length > 0 && casillas[posX+j][posY+i].substring(1,2) == enemigo){
                    pos[z] = (posX+j) + "," + (posY+i);
                    z++;
                }
            }
        }
    }
    if((posX > 0 && posX < 7) && (posY == 0)){
        for(var i = 0; i < 2; i++){
            if(i == 0){
            }
            if(i == 1){
                if(casillas[posX+j][posY+i] == ""){
                    pos[z] = (posX+j) + "," + (posY+i);
                    z++;
                }
                if(casillas[posX + j][posY + i].length > 0 && casillas[posX + j][posY + i].substring(1,2) == enemigo){
                    pos[z] = (posX+j) + "," + (posY+i);
                    z++;
                }
            }
        }
    }
    if((posX > 0 && posX < 7) && (posY == 7)){
        for(var i = -1; i < 1; i++){
            if(i == 0){
            }
            if(i == -1){
                if(casillas[posX+j][posY+i] == ""){
                    pos[z] = (posX+j) + "," + (posY+i);
                    z++;
                }
                if(casillas[posX+j][posY+i].length > 0 && casillas[posX+j][posY+i].substring(1,2) == enemigo){
                    pos[z] = (posX+j) + "," + (posY+i);
                    z++;
                }
            }
        }
    }
    for(var k = 0; k < pos.length; k++){
        if(pos[k] != null){}
        else{
            pos[k] = "";
        }
    }
    return pos;
}

function pintarLineasV(casillas,cambiarX,posX,cambiarY,posY,amigo,enemigo){
    var pos = new Array(81);
    var z = 0;
    if(posX > -1 && posX < 8){
        for(cambiarX = posX - 1; cambiarX > -1; cambiarX--){
            if(casillas[cambiarX][posY] == ""){
                pos[z] = (cambiarX) + "," + (posY);
                z++;
            }
            else if(casillas[cambiarX][posY].length > 0 && casillas[cambiarX][posY].substring(1,2) == amigo){
                break;
            }
            else if(casillas[cambiarX][posY].length > 0 && casillas[cambiarX][posY].substring(1,2) == enemigo){
                pos[z] = (cambiarX) + "," + (posY);
                z++;
                break;
            }
        }
        for(cambiarX = posX + 1; cambiarX < 8; cambiarX++){
            if(casillas[cambiarX][posY] == ""){
                pos[z] = (cambiarX) + "," + (posY);
                z++;
            }
            else if(casillas[cambiarX][posY].length > 0 && casillas[cambiarX][posY].substring(1,2) == amigo){
                break;
            }
            else if(casillas[cambiarX][posY].length > 0 && casillas[cambiarX][posY].substring(1,2) == enemigo){
                pos[z] = (cambiarX) + "," + (posY);
                z++;
                break;
            }
        }
    }
    if(posY > -1 && posY < 8){
        for(cambiarY = posY -1; cambiarY >-1; cambiarY--){
            if(casillas[posX][cambiarY] == ""){
                pos[z] = (posX) + "," + (cambiarY);
                z++;
            }
            else if(casillas[posX][cambiarY].length > 0 && casillas[posX][cambiarY].substring(1,2) == amigo){
                break;
            }
            else if(casillas[posX][cambiarY].length > 0 && casillas[posX][cambiarY].substring(1,2) == enemigo){
                pos[z] = (posX) + "," + (cambiarY);
                z++;
                break;
            }
        }
        for(cambiarY = posY +1; cambiarY <8; cambiarY++){
            if(casillas[posX][cambiarY] == ""){
                pos[z] = (posX) + "," + (cambiarY);
                z++;
            }
            else if(casillas[posX][cambiarY].length > 0 && casillas[posX][cambiarY].substring(1,2) == amigo){
                break;
            }
            else if(casillas[posX][cambiarY].length > 0 && casillas[posX][cambiarY].substring(1,2) == enemigo){
                pos[z] = (posX) + "," + (cambiarY);
                z++;
                break;
            }
        }
    }
    for(var k = 0; k < pos.length; k++){
        if(pos[k] != null){}
        else{
            pos[k] = "";
        }
    }
    return pos;
}

function pintarLV(casillas,posX,posY,enemigo){
    var pos = new Array(81);
    var z = 0;
    if(posX -2 >= 0 && posX+1 >= 0 && posX-2 <8 && posY+1 < 8){
        if(casillas[posX-2][posY+1] == ""){
            pos[z] = (posX-2) + "," + (posY+1);
            z++;
        }
        else if(casillas[posX-2][posY+1].substring(1,2) == enemigo){
            pos[z] = (posX-2) + "," + (posY+1);
            z++;
        }
    }
    if(posX-2 >= 0 && posY-1 >= 0 && posX-2 < 8 && posY-1 < 8){
        if(casillas[posX-2][posY-1] == ""){
            pos[z] = (posX-2) + "," + (posY-1);
            z++;
        }
        else if(casillas[posX-2][posY-1].substring(1,2) == enemigo){
            pos[z] = (posX-2) + "," + (posY-1);
            z++;
        }
    }
    if(posX-1 >= 0 && posY+2 >= 0 && posX-1 < 8 && posY+2 < 8){
        if(casillas[posX-1][posY+2] == ""){
            pos[z] = (posX-1) + "," + (posY+2);
            z++;
        }
        else if(casillas[posX-1][posY+2].substring(1,2) == enemigo){
            pos[z] = (posX-1) + "," + (posY+2);
            z++;
        }
    }
    if(posX-1 >= 0 && posY-2 >= 0 && posX-1 < 8 && posY-2 < 8){
        if(casillas[posX-1][posY-2] == ""){
            pos[z] = (posX-1) + "," + (posY-2);
            z++;
        }
        else if(casillas[posX-1][posY-2].substring(1,2) == enemigo){
            pos[z] = (posX-1) + "," + (posY-2);
            z++;
        }
    }
    if(posX+2 >= 0 && posY+1 >= 0 && posX+2 < 8 && posY+1 < 8){
        if(casillas[posX+2][posY+1] == ""){
            pos[z] = (posX+2) + "," + (posY+1);
            z++;
        }
        else if(casillas[posX+2][posY+1].substring(1,2) == enemigo){
            pos[z] = (posX+2) + "," + (posY+1);
            z++;
        }
    }
    if(posX+2 >= 0 && posY-1 >= 0 && posX+2 < 8 && posY-1 < 8){
        if(casillas[posX+2][posY-1] == ""){
            pos[z] = (posX+2) + "," + (posY-1);
            z++;
        }
        else if(casillas[posX+2][posY-1].substring(1,2) == enemigo){
            pos[z] = (posX+2) + "," + (posY-1);
            z++;
        }
    }
    if(posX+1 >= 0 && posY+2 >= 0 && posX+1 < 8 && posY+2 < 8){
        if(casillas[posX+1][posY+2] == ""){
            pos[z] = (posX+1) + "," + (posY+2);
            z++;
        }
        else if(casillas[posX+1][posY+2].substring(1,2) == enemigo){
            pos[z] = (posX+1) + "," + (posY+2);
            z++;
        }
    }
    if(posX+1 >= 0 && posY-2 >= 0 && posX+1 < 8 && posY-2 < 8){
        if(casillas[posX+1][posY-2] == ""){
            pos[z] = (posX+1) + "," + (posY-2);
            z++;
        }
        else if(casillas[posX+1][posY-2].substring(1,2) == enemigo){
            pos[z] = (posX+1) + "," + (posY-2);
            z++;
        }
    }
    for(var k = 0; k < pos.length; k++){
        if(pos[k] != null){}
        else{
            pos[k] = "";
        }
    }
    return pos;
}

function pintarDiagonalesV(casillas,posX,posY,enemigo){
    var i;
    var j;
    var k;
    var l;
    var pos = new Array(81);
    var z = 0;
    for (i = 1; (posX+i<8)&&(posY+i<8); i++) {
        if(casillas[posX+i][posY+i] == ""){
            pos[z] = (posX+i) + "," + (posY+i);
            z++;
        }
        else if(casillas[posX+i][posY+i].length > 0 && casillas[posX+i][posY+i].substring(1,2) == enemigo){
            pos[z] = (posX+i) + "," + (posY+i);
            z++;
            break;
        }
        else{
            break;
        }
    }
    for(j = 1; ((posX-j > -1)&&(posY+j < 8)); j++){
        if(casillas[posX-j][posY+j] == ""){
            pos[z] = (posX-j) + "," + (posY+j);
            z++;
        }
        else if(casillas[posX-j][posY+j].length > 0 && casillas[posX-j][posY+j].substring(1,2) == enemigo){
            pos[z] = (posX-j) + "," + (posY+j);
            z++;
            break;
        }
        else{
            break;
        }
    }
    for(k = 1; (posX-k > -1) && (posY-k > -1); k++){
        if(casillas[posX-k][posY-k] == ""){
            pos[z] = (posX-k) + "," + (posY-k);
            z++;
        }
        else if(casillas[posX-k][posY-k].length > 0 && casillas[posX-k][posY-k].substring(1,2) == enemigo){
            pos[z] = (posX-k) + "," + (posY-k);
            z++;
            break;
        }
        else{
            break;
        }
    }
    for(l = 1; (posX+l < 8)&&(posY -l > -1);l++){
        if(casillas[posX+l][posY-l] == ""){
            pos[z] = (posX+l) + "," + (posY-l);
            z++;
        }
        else if(casillas[posX+l][posY-l].length > 0 && casillas[posX+l][posY-l].substring(1,2) == enemigo){
            pos[z] = (posX+l) + "," + (posY-l);
            z++;
            break;
        }
        else{
            break;
        }
    }
    for(var m = 0; m < pos.length; m++){
        if(pos[m] != null){}
        else{
            pos[m] = "";
        }
    }
    return pos;
}

function pintarRV(casillas, posX, posY, amigo){
    var pos = new Array(81);
    var z = 0;
    if(posX-1 >= 0 && posY-1 >= 0 && posX-1 < 8 && posY-1 < 8){
        if(casillas[posX-1][posY-1] == ""){
            pos[z] = (posX-1) + "," + (posY-1);
            z++;
        }
        else if(casillas[posX-1][posY-1].substring(1,2) != amigo){
            pos[z] = (posX-1) + "," + (posY-1);
            z++;
        }
    }
    if(posX-1 >= 0 && posY >= 0 && posX-1 < 8 && posY < 8){
        if(casillas[posX-1][posY] == ""){
            pos[z] = (posX-1) + "," + (posY);
            z++;
        }
        else if(casillas[posX-1][posY].substring(1,2) != amigo){
            pos[z] = (posX-1) + "," + (posY);
            z++;
        }
    }
    if(posX-1 >= 0 && posY+1 >= 0 && posX-1 < 8 && posY+1 < 8){
        if(casillas[posX-1][posY+1] == ""){
            pos[z] = (posX-1) + "," + (posY+1);
            z++;
        }
        else if(casillas[posX-1][posY+1].substring(1,2) != amigo){
            pos[z] = (posX-1) + "," + (posY+1);
            z++;
        }
    }
    if(posX >= 0 && posY-1 >= 0 && posX < 8 && posY-1 < 8){
        if(casillas[posX][posY-1] == ""){
            pos[z] = (posX) + "," + (posY-1);
            z++;
        }
        else if(casillas[posX][posY-1].substring(1,2) != amigo){
            pos[z] = (posX) + "," + (posY-1);
            z++;
        }
    }
    if(posX >= 0 && posY+1 >= 0 && posX < 8 && posY+1 < 8){
        if(casillas[posX][posY+1] == ""){
            pos[z] = (posX) + "," + (posY+1);
            z++;
        }
        else if(casillas[posX][posY+1].substring(1,2) != amigo){
            pos[z] = (posX) + "," + (posY+1);
            z++;
        }
    }
    if(posX+1 >= 0 && posY-1 >= 0 && posX+1 < 8 && posY-1 < 8){
        if(casillas[posX+1][posY-1] == ""){
            pos[z] = (posX+1) + "," + (posY-1);
            z++;
        }
        else if(casillas[posX+1][posY-1].substring(1,2) != amigo){
            pos[z] = (posX+1) + "," + (posY-1);
            z++;
        }
    }
    if(posX+1 >= 0 && posY >= 0 && posX+1 < 8 && posY < 8){
        if(casillas[posX+1][posY] == ""){
            pos[z] = (posX+1) + "," + (posY);
            z++;
        }
        else if(casillas[posX+1][posY].substring(1,2) != amigo){
            pos[z] = (posX+1) + "," + (posY);
            z++;
        }
    }
    if(posX+1 >= 0 && posY+1 >= 0 && posX+1 < 8 && posY+1 < 8){
        if(casillas[posX+1][posY+1] == ""){
            pos[z] = (posX+1) + "," + (posY+1);
            z++;
        }
        else if(casillas[posX+1][posY+1].substring(1,2) != amigo){
            pos[z] = (posX+1) + "," + (posY+1);
            z++;
        }
    }
    if(amigo == "B"){
        if(posX == 7 && posY == 4 && casillas[7][5] == "" && casillas[7][6] == "" && casillas[7][7] == "TB"){
            pos[z] = (7) + "," + (6);
            z++;
        }
        if(posX == 7 && posY == 4 && casillas[7][3] == "" && casillas[7][2] == "" && casillas[7][1] == "" && casillas[7][0] == "TB"){
            pos[z] = (7) + "," + (2);
            z++;
        }
    }
    if(amigo == "N"){
        if(posX == 0 && posY == 4 && casillas[0][5] == "" && casillas[0][6] == "" && casillas[0][7] == "TN"){
            pos[z] = (0) + "," + (6);
            z++;
        }
        if(posX == 0 && posY == 4 && casillas[0][3] == "" && casillas[0][2] == "" && casillas[0][1] == "" && casillas[0][0] == "TN"){
            pos[z] = (0) + "," + (2);
            z++;
        }
    }
    for(var m = 0; m < pos.length; m++){
        if(pos[m] != null){
        }
        else{
            pos[m] = "";
        }
    }
    return pos;
}

function PeonV(casillas, posX, posY){
    var ame = new Array();
    var j;
    var enemigo;
    if(casillas[posX][posY].substring(1,2) == "B"){
        j = -1;
        enemigo = "N";
        ame = revisarFrenteV(casillas,parseInt(posX),parseInt(posY),j,enemigo,"B");
        return ame;
    }
    else{
        j = 1;
        enemigo = "B";
        ame = revisarFrenteV(casillas,parseInt(posX),parseInt(posY),j,enemigo,"N");
        return ame;
    }
}

function CaballoV(casillas,posX,posY){
    var ame = new Array();
    if(casillas[posX][posY].substring(1,2) == "N"){
        ame = pintarLV(casillas,parseInt(posX),parseInt(posY),"B");
        return ame;
    }
    else{
        ame = pintarLV(casillas,parseInt(posX),parseInt(posY),"N");
        return ame;
    }
}

function AlfilV(casillas,posX,posY){
    var ame = new Array();
    if(casillas[posX][posY].substring(1,2) == "N"){
        ame = pintarDiagonalesV(casillas,parseInt(posX),parseInt(posY),"B");
        return ame;
    }
    else{
        ame = pintarDiagonalesV(casillas,parseInt(posX),parseInt(posY),"N");
        return ame;
    }
}

function TorreV(casillas,posX,posY){
    var ame = new Array();
    var cambiarX;
    var cambiarY;
    if(casillas[posX][posY].substring(1,2) == "N"){
        cambiarX = 0;
        cambiarY = 0;
        ame = pintarLineasV(casillas,cambiarX,parseInt(posX),cambiarY,parseInt(posY),"N","B");
        return ame;
    }
    else{
        cambiarX = 7;
        cambiarY = 7;
        ame = pintarLineasV(casillas,cambiarX,parseInt(posX),cambiarY,parseInt(posY),"B","N");
        return ame;
    }
}   

function DamaV(casillas,posX,posY){
    var cambiarX;
    var cambiarY;
    var ame = new Array();
    var ama = new Array();
    if(casillas[posX][posY].substring(1,2) == "N"){
        cambiarX = 0;
        cambiarY = 0;
        ame = pintarLineasV(casillas,cambiarX,parseInt(posX),cambiarY,parseInt(posY),"N","B");
        ama = pintarDiagonalesV(casillas,parseInt(posX),parseInt(posY),"B");
    }
    else{
        cambiarX = 7;
        cambiarY = 7;
        ame = pintarLineasV(casillas,cambiarX,parseInt(posX),cambiarY,parseInt(posY),"B","N");
        ama = pintarDiagonalesV(casillas,parseInt(posX),parseInt(posY),"N");
    }
    var resa = new Array(ame.length + ama.length);
    for(var i = 0; i < ame.length; i++){
        resa[i] = ame[i];
    }
    for(var i = 0; i < ama.length; i++){
        resa[ame.length+i] = ama[i];
    }
    return resa;
}

function ReyV(casillas,posX,posY,amigo){
    var ame = new Array();
    if(amigo == "B"){
        ame = pintarRV(casillas,parseInt(posX),parseInt(posY),amigo);
    }
    else{
        ame = pintarRV(casillas,parseInt(posX),parseInt(posY),amigo);
    }
    return ame;
}