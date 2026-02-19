#!/bin/bash

# Configurações do Certificado
ALIAS="microservice_c"
SENHA="123456"
ARQUIVO="microservice_c.p12"
CERT_FILE="microservice_c.cer"
VALIDADE=365

echo "Gerando keystore PKCS12 autoassinado..."

keytool -genkeypair \
        -storepass "$SENHA" \
        -keyalg RSA \
        -keysize 2048 \
        -dname "CN=localhost" \
        -alias "$ALIAS" \
        -ext "SAN=DNS:localhost,IP:127.0.0.1" \
        -storetype PKCS12 \
        -keystore "$ARQUIVO"


keytool -exportcert -keystore $ARQUIVO -storetype PKCS12 -alias "$ALIAS" -file $CERT_FILE -storepass "$SENHA"

# Execute como Administrador (Windows) ou com sudo (Linux/macOS)
keytool -importcert -trustcacerts -keystore "C:\Workspace\tools\jdk-25.0.2\lib\security\cacerts" -alias "$ALIAS" -file "$CERT_FILE" -storepass changeit -noprompt

keytool -list -keystore "C:\Workspace\tools\jdk-25.0.2\lib\security\cacerts" -storepass changeit -alias "$ALIAS"

if [ $? -eq 0 ]; then
    echo "---------------------------------------------------"
    echo "Sucesso! Arquivo gerado: $ARQUIVO"
    echo "Alias: $ALIAS"
    echo "Senha: $SENHA"
    echo "---------------------------------------------------"
else
    echo "Erro ao gerar o certificado."
fi
