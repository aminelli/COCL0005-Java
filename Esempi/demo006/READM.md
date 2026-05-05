# Varie


## Automation

Per automation per verifica correttezza file yaml:


```sh
pip install yamllint
yamllint application.yaml
```

## Avvio con profilo

Alternativa 1:

```sh
java -jar app.jar -Dspring.application.son='{
"server": {"port": 8081}
}' 
```

Alternativa 2:

```sh

export SPRING_APPLICATION_JSON='{
"server": {"port": 8081}
}' 

java -jar app.jar
```