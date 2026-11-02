# Universal Leaf Decay

Fabric-Mod fuer Minecraft 26.1.x. Alle Blaetter verfallen, wenn kein Stamm in Reichweite ist - auch
persistente Blaetter (z. B. aus Axiom-Blueprints oder vom Spieler gesetzt).

## .jar bauen

**Mit GitHub (kein Java noetig):**
1. Neues Repository auf GitHub erstellen und den Inhalt dieses Ordners hochladen.
2. Tab "Actions" oeffnen, der Workflow "build" startet automatisch.
3. Nach dem Lauf unter "Artifacts" `universal-leaf-decay-jar` herunterladen und entpacken.

**Lokal (Java 25 noetig):**
```
./gradlew build
```
Die Datei liegt danach in `build/libs/universal-leaf-decay-1.0.0.jar`.

## Auf Modrinth hochladen
Neues Projekt erstellen, Loader "Fabric", Spielversion 26.1.2, Lizenz MIT, die .jar hochladen.
