# siggeluring

# Install & Use

## Install & run

## Use

# Vad?

En simpel tjänst för att kolla uptime av sajter. 

# TODO:
- Generera projekt
- Lägg till POST /service
- Lägg till GET /service
- Lägg till DELETE /service/{id}
- Spara services i en text-fil, i JSON format
- Läs services från text-filen.
- Polla varje service.url en gång i minuten, från att den är tillagd, den är "OK" om tjänsten svarar med statuskoden 200
- Fixa så statiska filer leveras
- Lägg till /- routen
- Visa alla services i GUI
- Lägg till GUI för att skapa en service
- Lägg till GUI för att ta bort en service

# Notes

En service består av:
  - id GUID
  - name String
  - url String
  - status "OK" | "FAIL"
  - lastCheck DateTime

Spara services i en text-fil, i JSON format:
Finns olika sätt o göra detta på, men IOM att det ej finns "update" så finns det ingen större risk för felhantering.
Eventuellt skapa en tjänst som har allting i minne och sparar till disk då och då?


Använda vertx.io, för backenden
Skriv frontenden i backbone.js eller react.js


För mig:
~~Striktroughggo~~
