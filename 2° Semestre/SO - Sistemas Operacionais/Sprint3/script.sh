#!/bin/bash
sudo apt upgrade && sudo apt update -y
java -version
if [ $? -eq 0 ];
then
        echo "java instalado"
        cd Java-Jar
        if [ $? -eq 0 ];
        then
                echo "Executando jar..."
                sleep 1
                java -jar login-screen-1.0-SNAPSHOT-jar-with-dependencies.jar
        else
                echo "Clonando o repositorio..."
                git clone https://github.com/grupoPiQuatro/Java-Jar.git
                cd Java-Jar
                echo "Executando jar..."
                sleep 1
                java -jar login-screen-1.0-SNAPSHOT-jar-with-dependencies.jar
        fi
else
        echo "java não instalado"
        sudo apt install zip
        curl -s "https://get.sdkman.io" | bash
        source "/home/ubuntu/.sdkman/bin/sdkman-init.sh"
        sdk install java 17.0.5-amzn
        git clone https://github.com/grupoPiQuatro/Java-Jar.git
        cd Java-Jar
        java -jar login-screen-1.0-SNAPSHOT-jar-with-dependencies.jar
        echo "java instalado"
fi