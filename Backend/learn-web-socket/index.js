const express = require('express');
const expressWs = require('express-ws');
const path = require('path');

const app = express();

// Usa o middleware express-ws, que implementa websocket
expressWs(app);

// define que a pasta "public" contém conteúdo estático (ali fica a página html do cliente)
app.use(express.static(path.join(__dirname, 'public')));

// configura um endpoint para websocket na URI /ws. A função callback passada por parâmetro define
// o que deve ser feito em dois casos usando a função ws.on: 
// 'message': quando recebe uma mensagem de um cliente
// 'close': quando um cliente desconecta
// Quando um cliente conecta a callback é executadam define os tratadores de eventos 'mesasge' e 'close', e então
// envia uma mensagem de boas-vindas ao cliente

let clients = new Set();
app.ws('/ws', (ws, req) => {
  let hasNickname = false;
  ws.on('message', msg => {
    if(!hasNickname){
      clients.add({nickname: msg, ws})
    }
    console.log(`Recebeu mensagem: ${msg}`);
    clients.forEach(client => {
      client.ws.send(`${client.nickname}: ${msg}`);
    });
    hasNickname = true;
  });

  ws.on('close', () => {
    console.log('Cliente desconectou');
    clients.delete(ws);
  });
  ws.send('Bem vindo ao servidor websocket !');
});

app.listen(8080, () => {
  console.log('Servidor iniciou no port 8080');
});
