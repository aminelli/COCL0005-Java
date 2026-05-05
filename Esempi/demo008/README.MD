
# Testing


```bash

# 1. Lanciare applicazione

# 2. Check della feature checkout
#    Stato iniziale:
#    app.features.new-checkout = false
curl http://localhost:8080/checkout

# 3. Modifichiamo a caldo il file yaml di configurazione 
#    app.features.new-checkout = true

# 4. Forzare rilettura file yaml di configurazione; 
#    in pratica scateno il trigger Spring dietro all'api refresh dell'actuator
curl -X POST  http://localhost:8080/actuator/refresh

# 5. Verifica aggiornamento parametro
curl http://localhost:8080/checkout


```