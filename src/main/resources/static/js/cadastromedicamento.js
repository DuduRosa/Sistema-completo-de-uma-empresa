function cadastrar() {
    //Pegando o codigo do select da tarja
    const tarja = window.document.getElementById('tarja');
    const tarjainput = window.document.getElementById('tarjainput');

    //Faz Verificação das tarjas e insere no input hidden
    if (tarja.value == 1) {
        tarjainput.value = 'Sem tarja';
    }
    if (tarja.value == 2) {
        tarjainput.value = 'Tarja amarela';
    }
    if (tarja.value == 3) {
        tarjainput.value = 'Tarja vermelha (sem retenção da receita)';
    }
    if (tarja.value == 4) {
        tarjainput.value = 'Tarja vermelha (com retenção da receita)';
    }
    if (tarja.value == 5) {
        tarjainput.value = 'Tarja Preta';
    }

    //Pegando o codigo do select da tipo
    const tipo = window.document.getElementById('tipo');
    const tipoinput = window.document.getElementById('tipoinput');

    //Faz Verificação dos tipos e insere no input hidden
    if (tipo.value == 1) {
        tipoinput.value = 'Fitoterápico';
    }
    if (tipo.value == 2) {
        tipoinput.value = 'Alopático';
    }
    if (tipo.value == 3) {
        tipoinput.value = 'Homeopático';
    }
    if (tipo.value == 4) {
        tipoinput.value = 'Similar';
    }
    if (tipo.value == 5) {
        tipoinput.value = 'Genérico';
    }
    if (tipo.value == 6) {
        tipoinput.value = 'Referência';
    }
    if (tipo.value == 7) {
        tipoinput.value = 'Manipulado';
    }

    console.log(tipoinput.value)
    console.log(tipo.value)
    console.log(tarjainput.value)
    console.log(tarja.value)


};