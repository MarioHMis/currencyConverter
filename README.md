Conversor de Monedas

Esta aplicación es un convertidor de monedas desarrollado en Java, que utiliza la API de ExchangeRate para obtener tasas de cambio actualizadas. Los usuarios pueden convertir entre diferentes monedas predefinidas o 
ingresar manualmente los códigos de moneda para realizar conversiones.

Características

    Conversión entre monedas comunes como USD, MXN, EUR, ARS, y más.
    Soporte para la entrada manual de códigos de monedas.
    Consulta de tasas de cambio en tiempo real mediante la API de ExchangeRate.
    Menú interactivo para una fácil navegación.

Requisitos Previos

    Java 8 o superior.
    Librería Gson para la manipulación de JSON.
    Acceso a la API de ExchangeRate (obtén tu API key aquí).

Instalación

    Clona este repositorio en tu máquina local:

    bash

git clone https://github.com/MarioHMis/currencyConverter.git

Asegúrate de tener Java 8 o superior instalado:

bash

java -version

Agrega la librería de Gson a tu proyecto. Si estás usando Maven, añade la dependencia a tu archivo pom.xml:

xml

<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.6</version>
</dependency>

Coloca tu clave de API en el archivo ApiHandler.java, reemplazando la variable API_KEY con tu clave personal:

java

    private static final String API_KEY = "TU_API_KEY";

Uso

    Ejecuta la aplicación desde tu IDE o usando la línea de comandos:

    bash

    javac Main.java
    java Main

    Sigue las instrucciones en pantalla para convertir monedas. Puedes seleccionar entre monedas predefinidas
    o ingresar manualmente los códigos de las monedas que deseas convertir.



API utilizada

Esta aplicación utiliza la API de ExchangeRate para obtener las tasas de cambio en tiempo real.
Contribución

Si deseas contribuir a este proyecto:

    Haz un fork del repositorio.
    Crea una nueva rama (git checkout -b feature/nueva-funcionalidad).
    Haz commit de tus cambios (git commit -am 'Añadida nueva funcionalidad').
    Haz push a la rama (git push origin feature/nueva-funcionalidad).
    Abre un Pull Request.

Licencia

Este proyecto está licenciado bajo la Licencia MIT - consulta el archivo LICENSE para más detalles.

********************************************************************************************************************************************************************************************************************************************


Currency Converter

This is a currency converter application developed in Java that uses the ExchangeRate API to fetch real-time exchange rates. Users can convert between predefined currencies or manually input currency codes to perform conversions.
Features

    Convert between common currencies like USD, MXN, EUR, ARS, and more.
    Support for manual entry of currency codes.
    Real-time exchange rate lookup using the ExchangeRate API.
    Interactive menu for easy navigation.

Prerequisites

    Java 8 or higher.
    Gson library for JSON manipulation.
    Access to the ExchangeRate API (get your API key here).

Installation

    Clone this repository to your local machine:

    bash

git clone https://github.com/MarioHMis/currencyConverter.git

Make sure you have Java 8 or higher installed:

bash

java -version

Add the Gson library to your project. If you're using Maven, add the dependency to your pom.xml file:

xml

<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.6</version>
</dependency>

Insert your API key in the ApiHandler.java file by replacing the API_KEY variable with your personal key:

java

    private static final String API_KEY = "YOUR_API_KEY";

Usage

    Run the application from your IDE or using the command line:

    bash

    javac Main.java
    java Main

    Follow the on-screen instructions to convert currencies. You can choose from predefined currencies or manually enter the currency codes you want to convert.


API used

This application uses the ExchangeRate API to get real-time exchange rates.
Contribution

If you would like to contribute to this project:

    Fork the repository.
    Create a new branch (git checkout -b feature/new-feature).
    Commit your changes (git commit -am 'Added new feature').
    Push to the branch (git push origin feature/new-feature).
    Open a Pull Request.

License

This project is licensed under the MIT License - see the LICENSE file for details.
