// não altere!
const serialport = require('serialport');
const express = require('express');
const mysql = require('mysql2');
const sql = require('mssql');

// não altere!
const SERIAL_BAUD_RATE = 9600;
const SERVIDOR_PORTA = 3300;

// configure a linha abaixo caso queira que os dados capturados sejam inseridos no banco de dados.
// false -> nao insere
// true -> insere
const HABILITAR_OPERACAO_INSERIR = true;

// altere o valor da variável AMBIENTE para o valor desejado:
// API conectada ao banco de dados remoto, SQL Server -> 'producao'
// API conectada ao banco de dados local, MySQL Workbench - 'desenvolvimento'
const AMBIENTE = 'producao';

const serial = async (
    vsens1,
    vsens2,
    vsens3,
    vsens4,
    vsens5,
    vsens6,
    vsens7,
    vsens8,
    vsens9,
    vsens10,
    vsens11,
    vsens12,
    vsens13,
    vsens14,
    vsens15,
    vsens16,
    vsens17,
    vsens18,
    vsens19,
    vsens20,
    vsens21,
    vsens22,
    vsens23,
    vsens24,
    vsens25,
    vsens26,
    vsens27,
    vsens28,
    vsens29,
    vsens30,
    vsens31,
    vsens32,
    vsens33,
    vsens34,
    vsens35,
    vsens36
) => {
    let poolBancoDados = ''

    if (AMBIENTE == 'desenvolvimento') {
        poolBancoDados = mysql.createPool(
            {
                // altere!
                // CREDENCIAIS DO BANCO LOCAL - MYSQL WORKBENCH
                host: 'localhost',
                user: 'aluno',
                password: 'sptech',
                database: 'systoyanka'
            }
        ).promise();
    } else if (AMBIENTE == 'producao') {
        console.log('Projeto rodando inserindo dados em nuvem. Configure as credenciais abaixo.');
    } else {
        throw new Error('Ambiente não configurado. Verifique o arquivo "main.js" e tente novamente.');
    }


    const portas = await serialport.SerialPort.list();
    const portaArduino = portas.find((porta) => porta.vendorId == 2341 && porta.productId == 43);
    if (!portaArduino) {
        throw new Error('O arduino não foi encontrado em nenhuma porta serial');
    }
    const arduino = new serialport.SerialPort(
        {
            path: portaArduino.path,
            baudRate: SERIAL_BAUD_RATE
        }
    );
    arduino.on('open', () => {
        console.log(`A leitura do arduino foi iniciada na porta ${portaArduino.path} utilizando Baud Rate de ${SERIAL_BAUD_RATE}`);
    });
    arduino.pipe(new serialport.ReadlineParser({ delimiter: '\r\n' })).on('data', async (data) => {
        //console.log(data);
        const valores = data.split(';');
        const sens1 = parseInt(valores[0]);
        const sens2 = parseInt(valores[1]);
        const sens3 = parseInt(valores[2]);
        const sens4 = parseInt(valores[3]);
        const sens5 = parseInt(valores[4]);
        const sens6 = parseInt(valores[5]);
        const sens7 = parseInt(valores[6]);
        const sens8 = parseInt(valores[7]);
        const sens9 = parseInt(valores[8]);
        const sens10 = parseInt(valores[9]);
        const sens11 = parseInt(valores[10]);
        const sens12 = parseInt(valores[11]);
        const sens13 = parseInt(valores[12]);
        const sens14 = parseInt(valores[13]);
        const sens15 = parseInt(valores[14]);
        const sens16 = parseInt(valores[15]);
        const sens17 = parseInt(valores[16]);
        const sens18 = parseInt(valores[17]);
        const sens19 = parseInt(valores[18]);
        const sens20 = parseInt(valores[19]);
        const sens21 = parseInt(valores[20]);
        const sens22 = parseInt(valores[21]);
        const sens23 = parseInt(valores[22]);
        const sens24 = parseInt(valores[23]);
        const sens25 = parseInt(valores[24]);
        const sens26 = parseInt(valores[25]);
        const sens27 = parseInt(valores[26]);
        const sens28 = parseInt(valores[27]);
        const sens29 = parseInt(valores[28]);
        const sens30 = parseInt(valores[29]);
        const sens31 = parseInt(valores[30]);
        const sens32 = parseInt(valores[31]);
        const sens33 = parseInt(valores[32]);
        const sens34 = parseInt(valores[33]);
        const sens35 = parseInt(valores[34]);
        const sens36 = parseInt(valores[35]);

        vsens1.push(sens1);
        vsens2.push(sens2);
        vsens3.push(sens3);
        vsens4.push(sens4);
        vsens5.push(sens5);
        vsens6.push(sens6);
        vsens7.push(sens7);
        vsens8.push(sens8);
        vsens9.push(sens9);
        vsens10.push(sens10);
        vsens11.push(sens11);
        vsens12.push(sens12);
        vsens13.push(sens13);
        vsens14.push(sens14);
        vsens15.push(sens15);
        vsens16.push(sens16);
        vsens17.push(sens17);
        vsens18.push(sens18);
        vsens19.push(sens19);
        vsens20.push(sens20);
        vsens21.push(sens21);
        vsens22.push(sens22);
        vsens23.push(sens23);
        vsens24.push(sens24);
        vsens25.push(sens25);
        vsens26.push(sens26);
        vsens27.push(sens27);
        vsens28.push(sens28);
        vsens29.push(sens29);
        vsens30.push(sens30);
        vsens31.push(sens31);
        vsens32.push(sens32);
        vsens33.push(sens33);
        vsens34.push(sens34);
        vsens35.push(sens35);
        vsens36.push(sens36);

        if (HABILITAR_OPERACAO_INSERIR) {
            if (AMBIENTE == 'producao') {
                // altere!
                // Este insert irá inserir os dados na tabela "medida"
                // -> altere nome da tabela e colunas se necessário
                // Este insert irá inserir dados de fk_aquario id=1 (fixo no comando do insert abaixo)
                // >> Importante! você deve ter o aquario de id 1 cadastrado.
                sqlquery = `INSERT INTO leitura (statusRetorno, fkSensor) VALUES (${sens1}, 1), (${sens2}, 2), (${sens3}, 3), (${sens4}, 4), (${sens5}, 5), (${sens6}, 6), (${sens7}, 7), (${sens8}, 8), (${sens9}, 9), (${sens10}, 10), (${sens11}, 11), (${sens12}, 12), (${sens13}, 13), (${sens14}, 14), (${sens15}, 15), (${sens16}, 16), (${sens17}, 17), (${sens18}, 18), (${sens19}, 19), (${sens20}, 20), (${sens21}, 21), (${sens22}, 22), (${sens23}, 23), (${sens24}, 24), (${sens25}, 25), (${sens26}, 26), (${sens27}, 27), (${sens28}, 28), (${sens29}, 29), (${sens30}, 30), (${sens5}, 31), (${sens5}, 32), (${sens5}, 33), (${sens34}, 34), (${sens35}, 35);`;

                // CREDENCIAIS DO BANCO REMOTO - SQL SERVER
                // Importante! você deve ter criado o usuário abaixo com os comandos presentes no arquivo
                // "script-criacao-usuario-sqlserver.sql", presente neste diretório.
                const connStr = "Server=systoyanka.database.windows.net;Database=systoyanka;User Id=admin-systoyanka-site;Password=#Gfgrupo1;";

                function inserirComando(conn, sqlquery) {
                    conn.query(sqlquery);
                    console.log("valores inseridos no banco: ", sens1 + ", " + sens2 + ", " + sens3 + ", " + sens4 + ", " + sens5)
                }

                sql.connect(connStr)
                    .then(conn => inserirComando(conn, sqlquery))
                    .catch(err => console.log("erro! " + err));

            } else if (AMBIENTE == 'desenvolvimento') {

                // altere!
                // Este insert irá inserir os dados na tabela "medida"
                // -> altere nome da tabela e colunas se necessário
                // Este insert irá inserir dados de fk_aquario id=1 (fixo no comando do insert abaixo)
                // >> você deve ter o aquario de id 1 cadastrado.
                await poolBancoDados.execute(
                    `INSERT INTO leitura (statusRetorno, fkSensor) VALUES (${sens1}, 1), (${sens2}, 2), (${sens3}, 3), (${sens4}, 4), (${sens5}, 5), (${sens6}, 6), (${sens7}, 7), (${sens8}, 8), (${sens9}, 9), (${sens10}, 10), (${sens11}, 11), (${sens12}, 12), (${sens13}, 13), (${sens14}, 14), (${sens15}, 15), (${sens16}, 16), (${sens17}, 17), (${sens18}, 18), (${sens19}, 19), (${sens20}, 20), (${sens21}, 21), (${sens22}, 22), (${sens23}, 23), (${sens24}, 24), (${sens25}, 25), (${sens26}, 26), (${sens27}, 27), (${sens28}, 28), (${sens29}, 29), (${sens30}, 30), (${sens5}, 31), (${sens5}, 32), (${sens5}, 33), (${sens34}, 34), (${sens35}, 35);`
                    // [dht11Umidade, dht11Temperatura, luminosidade, lm35Temperatura, chave]
                );
                console.log("valores inseridos no banco: ", sens1 + ", " + sens2 + ", " + sens3 + ", " + sens4 + ", " + sens5)

            } else {
                throw new Error('Ambiente não configurado. Verifique o arquivo "main.js" e tente novamente.');
            }
        }
    });
    arduino.on('error', (mensagem) => {
        console.error(`Erro no arduino (Mensagem: ${mensagem}`)
    });
}


// não altere!
const servidor = (
    vsens1,
    vsens2,
    vsens3,
    vsens4,
    vsens5,
    vsens6,
    vsens7,
    vsens8,
    vsens9,
    vsens10,
    vsens11,
    vsens12,
    vsens13,
    vsens14,
    vsens15,
    vsens16,
    vsens17,
    vsens18,
    vsens19,
    vsens20,
    vsens21,
    vsens22,
    vsens23,
    vsens24,
    vsens25,
    vsens26,
    vsens27,
    vsens28,
    vsens29,
    vsens30,
    vsens31,
    vsens32,
    vsens33,
    vsens34,
    vsens35,
    vsens36
) => {
    const app = express();
    app.use((request, response, next) => {
        response.header('Access-Control-Allow-Origin', '*');
        response.header('Access-Control-Allow-Headers', 'Origin, Content-Type, Accept');
        next();
    });
    app.listen(SERVIDOR_PORTA, () => {
        console.log(`API executada com sucesso na porta ${SERVIDOR_PORTA}`);
    });
    app.get('/sensores/sens1', (_, response) => {
        return response.json(vsens1);
    });
    app.get('/sensores/sens2', (_, response) => {
        return response.json(vsens2);
    });
    app.get('/sensores/sens3', (_, response) => {
        return response.json(vsens3);
    });
    app.get('/sensores/sens4', (_, response) => {
        return response.json(vsens4);
    });
    app.get('/sensores/sens5', (_, response) => {
        return response.json(vsens5);
    });
    app.get('/sensores/sens6', (_, response) => {
        return response.json(vsens6);
    });
    app.get('/sensores/sens7', (_, response) => {
        return response.json(vsens7);
    });
    app.get('/sensores/sens8', (_, response) => {
        return response.json(vsens8);
    });
    app.get('/sensores/sens9', (_, response) => {
        return response.json(vsens9);
    });
    app.get('/sensores/sens10', (_, response) => {
        return response.json(vsens10);
    });
    app.get('/sensores/sens11', (_, response) => {
        return response.json(vsens11);
    });
    app.get('/sensores/sens12', (_, response) => {
        return response.json(vsens12);
    });
    app.get('/sensores/sens13', (_, response) => {
        return response.json(vsens13);
    });
    app.get('/sensores/sens14', (_, response) => {
        return response.json(vsens14);
    });
    app.get('/sensores/sens15', (_, response) => {
        return response.json(vsens15);
    });
    app.get('/sensores/sens16', (_, response) => {
        return response.json(vsens16);
    });
    app.get('/sensores/sens17', (_, response) => {
        return response.json(vsens18);
    });
    app.get('/sensores/sens18', (_, response) => {
        return response.json(vsens18);
    });
    app.get('/sensores/sens19', (_, response) => {
        return response.json(vsens19);
    });
    app.get('/sensores/sens20', (_, response) => {
        return response.json(vsens20);
    });
    app.get('/sensores/sens21', (_, response) => {
        return response.json(vsens21);
    });
    app.get('/sensores/sens22', (_, response) => {
        return response.json(vsens22);
    });
    app.get('/sensores/sens23', (_, response) => {
        return response.json(vsens23);
    });
    app.get('/sensores/sens24', (_, response) => {
        return response.json(vsens24);
    });
    app.get('/sensores/sens25', (_, response) => {
        return response.json(vsens25);
    });
    app.get('/sensores/sens26', (_, response) => {
        return response.json(vsens26);
    });
    app.get('/sensores/sens27', (_, response) => {
        return response.json(vsens27);
    });
    app.get('/sensores/sens28', (_, response) => {
        return response.json(vsens28);
    });
    app.get('/sensores/sens29', (_, response) => {
        return response.json(vsens29);
    });
    app.get('/sensores/sens29', (_, response) => {
        return response.json(vsens29);
    });
    app.get('/sensores/sens30', (_, response) => {
        return response.json(vsens30);
    });
    app.get('/sensores/sens31', (_, response) => {
        return response.json(vsens31);
    });
    app.get('/sensores/sens32', (_, response) => {
        return response.json(vsens32);
    });
    app.get('/sensores/sens33', (_, response) => {
        return response.json(vsens33);
    });
    app.get('/sensores/sens34', (_, response) => {
        return response.json(vsens34);
    });
    app.get('/sensores/sens35', (_, response) => {
        return response.json(vsens35);
    });
    app.get('/sensores/sens36', (_, response) => {
        return response.json(vsens36);
    });
    
}

(async () => {
    const vsens1 = [];
    const vsens2 = [];
    const vsens3 = [];
    const vsens4 = [];
    const vsens5 = [];
    const vsens6 = [];
    const vsens7 = [];
    const vsens8 = [];
    const vsens9 = [];
    const vsens10 = [];
    const vsens11 = [];
    const vsens12 = [];
    const vsens13 = [];
    const vsens14 = [];
    const vsens15 = [];
    const vsens16 = [];
    const vsens17 = [];
    const vsens18 = [];
    const vsens19 = [];
    const vsens20 = [];
    const vsens21 = [];
    const vsens22 = [];
    const vsens23 = [];
    const vsens24 = [];
    const vsens25 = [];
    const vsens26 = [];
    const vsens27 = [];
    const vsens28 = [];
    const vsens29 = [];
    const vsens30 = [];
    const vsens31 = [];
    const vsens32 = [];
    const vsens33 = [];
    const vsens34 = [];
    const vsens35 = [];
    const vsens36 = [];
    
    await serial(
        vsens1,
        vsens2,
        vsens3,
        vsens4,
        vsens5,
        vsens6,
        vsens7,
        vsens8,
        vsens9,
        vsens10,
        vsens11,
        vsens12,
        vsens13,
        vsens14,
        vsens15,
        vsens16,
        vsens17,
        vsens18,
        vsens19,
        vsens20,
        vsens21,
        vsens22,
        vsens23,
        vsens24,
        vsens25,
        vsens26,
        vsens27,
        vsens28,
        vsens29,
        vsens30,
        vsens31,
        vsens32,
        vsens33,
        vsens34,
        vsens35,
        vsens36
    );
    servidor(
        vsens1,
        vsens2,
        vsens3,
        vsens4,
        vsens5,
        vsens6,
        vsens7,
        vsens8,
        vsens9,
        vsens10,
        vsens11,
        vsens12,
        vsens13,
        vsens14,
        vsens15,
        vsens16,
        vsens17,
        vsens18,
        vsens19,
        vsens20,
        vsens21,
        vsens22,
        vsens23,
        vsens24,
        vsens25,
        vsens26,
        vsens27,
        vsens28,
        vsens29,
        vsens30,
        vsens31,
        vsens32,
        vsens33,
        vsens34,
        vsens35,
        vsens36
    );
})();