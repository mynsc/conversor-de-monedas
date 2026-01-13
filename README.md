# 💱 Conversor de Monedas

Aplicación de consola en Java para convertir entre diferentes divisas utilizando tasas de cambio en tiempo real desde ExchangeRate-API.

## 📋 Descripción

Este conversor de monedas permite a los usuarios realizar conversiones entre 6 divisas principales de forma rápida y sencilla. La aplicación consulta las tasas de cambio actualizadas mediante una API externa y proporciona resultados precisos.

## ✨ Características

- 🌍 Conversión entre 6 monedas principales:
  - Sol Peruano (PEN)
  - Peso Argentino (ARS)
  - Euro (EUR)
  - Yen Japonés (JPY)
  - Won Surcoreano (KRW)
  - Dólar Estadounidense (USD)

- ✅ Validación de códigos de moneda
- 🔄 Tasas de cambio en tiempo real
- 🛡️ Manejo robusto de errores
- 💬 Interfaz de consola intuitiva
- 🔒 Prevención de conversión entre la misma moneda

## 🛠️ Tecnologías Utilizadas

- **Java** - Lenguaje de programación principal
- **Gson** - Procesamiento de JSON
- **ExchangeRate-API** - Proveedor de tasas de cambio
- **Java Dotenv** - Gestión de variables de entorno
- **Java HTTP Client** - Peticiones HTTP

## 📁 Estructura del Proyecto

```
conversor de monedas/
│
├── src/
│   ├── Main.java                          # Punto de entrada
│   ├── .env                                # Configuración de API key
│   └── com/mynsc/conversor/
│       ├── aplicacion/
│       │   ├── AppConfig.java             # Configuración general
│       │   └── DataBaseClient.java        # Cliente de datos
│       └── modelos/
│           ├── Client.java                # Cliente HTTP
│           ├── ConversionRatesByAPI.java  # Modelo de respuesta API
│           ├── Converter.java             # Lógica de conversión
│           └── Menu.java                  # Interfaz de usuario
│
├── lib/                                    # Bibliotecas externas
├── bin/                                    # Archivos compilados
├── run.sh                                  # Script de compilación y ejecución
└── README.md                               # Este archivo
```

## 🚀 Requisitos Previos

- Java Development Kit (JDK) 17 o superior
- Conexión a Internet (para consultar tasas de cambio)
- API Key de [ExchangeRate-API](https://www.exchangerate-api.com/)

## ⚙️ Configuración

1. **Clonar el repositorio:**
   ```bash
   git clone <url-del-repositorio>
   cd "conversor de monedas"
   ```

2. **Obtener API Key:**
   - Registrarse en [ExchangeRate-API](https://www.exchangerate-api.com/)
   - Obtener una API key gratuita

3. **Configurar variables de entorno:**
   - Copiar el archivo de ejemplo:
     ```bash
     cp src/.env.example src/.env
     ```
   - Editar `src/.env` y agregar tu API key:
     ```
     API_KEY=tu_api_key_aqui
     ```

4. **Verificar las bibliotecas:**
   - Asegurarse de que las dependencias necesarias estén en el directorio `lib/`:
     - `gson-*.jar`
     - `dotenv-java-*.jar`

## ▶️ Ejecución.sh Main

### Manualmente:
```bash
# Compilar
javac -cp "lib/*" -d bin -sourcepath src $(find src -name "*.java")

# Ejecutar
java -cp "lib/*:bin" Main
```

## 📖 Uso

1. **Ingresar moneda base:**
   - Escribir el monto seguido del código de moneda
   - Ejemplo: `100 USD`, `50 EUR`, `1000 JPY`

2. **Seleccionar moneda objetivo:**
   - Elegir el número correspondiente a la moneda deseada (1-6)

3. **Ver resultado:**
   - La aplicación mostrará el monto convertido

4. **Salir:**
   - Presionar `7` en cualquier momento para salir

### Ejemplo de uso:
```
Ingrese el monto y el código de moneda (Ej. 23 USD, 8 JPY, 9 PEN) ---> 100 USD

Ingrese el número correspondiente de la moneda objetivo ---> 3

Cantidad convertida: 95.23 EUR
```

## 👨‍💻 Autor

**mynsc**
- Comunidad de Java por las herramientas y recursos
