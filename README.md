# Maven_RESTful
Questo progetto include due progetti Maven; il primo è una web app scritta in Java che ha come standard endpoint ```index.jsp```. Dispone inoltre di un endpoint REST che risponde con un saluto personalizzato.
L'altro è un client che esegue dei test sulla API del server

## Creazione
Una volta installato Maven (software di build automation e gestione progetto) sono stati creati due progetti attraverso i seguenti comandi:
```
mvn -B archetype:generate \
        -DarchetypeArtifactId=maven-archetype-webapp \
        -DgroupId=paolicchi.tepsit.restfulwebservices \
        -DartifactId=RESTfulWebServices
```
```
mvn -B archetype:generate \
        -DarchetypeArtifactId=maven-archetype-simple \
        -DgroupId=paolicchi.tepsit.restfulwebservicesclient \
        -DartifactId=RESTfulWebServicesClient
```
- ```archetypeArtifactId={x}```  serve a impostare il template da cui creare il progetto
  - ```maven-archetype-webapp``` per una web application
  - ```maven-archetype-simple``` per creare un semplice progetto
- ```groupId={x}``` serve a impostare l'identificativo del progetto
- ```artifactId={x}``` serve a impostere il nome del ```.jar```. 

## Struttura
```
Maven_RESTful/
├── RESTfulWebServiceClient/
│   ├── pom.xml
│   └── src/
│       ├── main/
│       │   ├── java/
│       │   │   └── paolicchi/
│       │   │       └── tepsit/
│       │   │           └── restfulwebservicesclient/
│       │   │               └── App.java
│       │   └── resources/
│       ├── test/
│       │   └── java/
│       │       └── paolicchi/
│       │           └── tepsit/
│       │               └── restfulwebservicesclient/
│       │                   ├── Author.java
│       │                   ├── Book.java
│       │                   └── BookTest.java
│       └── site/
│           └── site.xml
└── RESTfulWebServices/
    ├── pom.xml
    └── src/
        └── main/
            ├── java/
            │   └── paolicchi/
            │       └── tepsit/
            │           └── restfulwebservices/
            │               ├── api/
            │               │   ├── Author.java
            │               │   ├── AuthorServices.java
            │               │   ├── Book.java
            │               │   └── BookServices.java
            │               └── config/
            │                   └── Application.java
            └── webapp/
```
## File di configurazione
I file ```pom.xml``` definiscono le dipendenze, plugin e altre impostazioni del build automator. 
- **Dipendenze principali**:
  - **Jersey**: per implementazione API
    - ```Jersey-Container-Servlet``` fornisce supporto per l'esecuzione in un servlet
    - ```Jersey-Core``` per le funzionalita' di base
    - ```Jersey-HK2``` consente l'injection delle dipendenze
    - ```jersey-media-json-jackson``` per convertire automaticamente gli oggetti Java in JSON
  - **Jetty**: per eseguire l'applicazione con servlet.
- **Plugins**:
  - ```Jetty Maven Plugin``` permette di eseguire la web application direttamente da maven utilizzando Jetty
  - ```Maven War Plugin``` per il deploy dell' applicazione
  - ```Maven Compiler Plugin``` serve a configurare il compilatore Java.

Una volta scritto il file di configurazione si utilizza il comando ```mvn package``` per l'installazione delle dipendenze e la configurazione del progetto
## Pagine Web
- **```localhost:8080/```**: il server risponde con ```index.jsp```, un semplice file di greetings
- **```localhost:8080/author.jsp```**: pagina con informazioni dell'autore.
## API
Per l'utilizzo della API sono servite due semplici classi Java:
- **```Application.java```** per la configurazione di Jersey e la definizione dell'endpoint REST ```/api```
- **```Test.java```** risponde con un saluto personalizzato a seconda ```{name}``` nell'endpoint ```/test/{name}```.
# Compilazione
Per compilare i progetti si esegue il comando ```mvn clean compile``` all'interno di ogni progetto.
## Esecuzione Server
Eseguendo da terminale, all'interno della cartella del progetto ```RESTfulWebServices``` il comando ```mvn jetty:run``` il server inizia la sue esecuzione.\
Facendo una richiesta all'endpoint ```http://localhost:8080/api/test/{nome}``` il server risponde con ```Ciao {nome}```.\
Se invece facciamo richiesta a ```http://localhost:8080/``` il server risponde con il greeting *Utente Curioso*
## Esecuzione Test Client
Eseguendo da terminale, all'interno della cartella del progetto ```RESTfulWebServicesClient``` il comando ```mvn test``` si nota che l'applicazione esegue dei test utilizzando la API del server e mostra cosa ha inviato quest'ultimo come risposta.

> Prima di utilizzare il comando ```mvn test``` deve essere eseguito il server
