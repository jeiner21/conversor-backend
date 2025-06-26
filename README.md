# 🧮 Conversor de Monedas - Backend (Spring Boot)

Este backend actúa como una API intermediaria que conecta el frontend React con una API externa de conversión de divisas.

## 🔧 Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Web
- CORS habilitado
- API externa de conversión 
- Despliegue en Render

## 🔁 ¿Cómo funciona?

1. El frontend envía al backend la moneda origen, destino y la cantidad.
2. El backend **consume una API externa** para realizar la conversión.
3. El resultado es devuelto al frontend de forma limpia y segura.

## 📡 Endpoints disponibles

| Método | Ruta              | Descripción                             |
|--------|-------------------|-----------------------------------------|
| GET    | `/convert/money`  | Retorna lista de monedas disponibles    |
| POST   | `/convert`        | Realiza la conversión vía API externa   |

## 🚀 Cómo ejecutar localmente

```bash
git clone https://github.com/jeiner21/conversor-backend.git
cd conversor-backend
./mvnw spring-boot:run
