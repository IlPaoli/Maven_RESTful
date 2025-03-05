# Maven_HelloWeb
Questo progetto e' una web app scritta in Java che ha come standard endpoint ```index.jsp```. Dispone inoltre di un endpoint REST che risponde con un saluto personalizzato.

## Creazione
Una volta installato Maven (software di build automation e gestione progetto) e' stato creato un progetto attraverso il seguente comando:
```
mvn -B archetype:generate \
        -DarchetypeArtifactId=maven-archetype-webapp \
        -DgroupId=paolicchi.tepsit.helloweb \
        -DartifactId=helloweb
```
- ```archetypeArtifactId=maven-archetype-webapp```  serve a impostare il template da cui creare il progetto, in questo caso e' la base per una web application
- ```groupId=paolicchi.tepsit.helloweb``` serve a impostare l'identificativo del progetto
- ```artifactId=helloweb``` serve a impostere il nome del ```.jar```.

## Struttura
```
helloweb/
├── pom.xml
└── src/
    └─ main/
        ├── java/
        │   └── paolicchi/
        │       └── tepsit/
        │           └── helloweb/
        │               ├── api/
        │               │   └── Test.java
        │               └── config/
        │                   └── Application.java
        ├── resources/
        └── webapp/
```
## File di configurazione
Il file ```pom.xml``` definisce le dipendenze, plugin e altre impostazioni del build automator. 
* **Dipendenze principali**:
  * **Jersey**: per implementazione API
    * ```Jersey Container Servlet``` fornisce supporto per l'esecuzione in un servlet
    * ```Jersey Core``` per le funzionalita' di base
    * ```Jesrey HK2``` consente l'injection delle dipendenze
  * **Jetty**: per eseguire l'applicazione con servlet.
* **Plugins**:
  * ```Jetty Maven Plugin``` permette di eseguire la web application direttamente da maven utilizzando Jetty
  * ```Maven War Plugin``` per il deploy dell' applicazione
  * ```Maven Compiler Plugin``` serve a configurare il compilatore Java.

Una volta scritto il file di configurazione si utilizza il comando ```mvn package``` per l'installazione delle dipendenze e la configurazione del progetto
## Pagine Web
* **```localhost:8080/```**: il server risponde con ```index.jsp```, un semplice file di greetings
* **```localhost:8080/author.jsp```**: pagina con informazioni dell'autore.
## API
Per l'utilizzo della API sono servite due semplici classi Java:
* **```Application.java```** per la configurazione di Jersey e la definizione dell'endpoint REST ```/api```
* **```Test.java```** risponde con un saluto personalizzato a seconda ```{name}``` nell'endpoint ```/test/{name}```.

## Esecuzione
Per compilare il progetto si utilizza il comando ```mvn clean compile``` e una volta completato il processo si esegue con ```mvn jetty:run```.\
Facendo una richiesta all'endpoint ```http://localhost:8080/api/test/{nome}``` il server risponde con ```Ciao {nome}```.
Se invece facciamo richiesta a ```http://localhost:8080/``` il server risponde con il greeting *Utente Curioso*