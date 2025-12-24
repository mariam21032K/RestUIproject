# 👥 Person Management System

Note Important : Les images/captures d'écran ne peuvent pas être directement intégrées dans ce fichier README markdown.
Pour voir les captures d'écran réelles de l'application, veuillez consulter le dossier /screenshots du projet 


## 📋 Table of Contents
- [Description du projet](#description-du-projet)
- [Fonctionnalités](#fonctionnalités)
- [Technologies utilisées](#technologies-utilisées)
- [Architecture du système](#architecture-du-système)
- [Exécution du projet](#exécution-du-projet)
- [Documentation API avec exemples](#documentation-api-avec-exemples)
- [Guide d'utilisation](#guide-dutilisation)
- [Structure du projet](#structure-du-projet)
- [Dépannage](#dépannage)

---

## 📖 Description du projet

**Person Management System** est une application web complète de gestion de contacts basée sur une architecture REST. Ce projet permet de gérer une base de données de personnes avec des opérations CRUD (Create, Read, Update, Delete) via une interface utilisateur moderne et intuitive.

L'application est construite en utilisant une pile technologique moderne :
- **Backend** : API REST en Java avec Jersey
- **Base de données** : MySQL pour la persistence des données
- **Serveur d'application** : Apache Tomcat 9
- **Frontend** : Interface web HTML5/CSS3/JavaScript
- **IDE** : Eclipse IDE 2018
- **Build** : Maven 3.9

Le projet démontre les principes de l'architecture orientée services (SOA) et les bonnes pratiques de développement web moderne.

---

## ✨ Fonctionnalités

✅ **Gestion complète des personnes**
- ➕ Ajouter de nouvelles personnes avec validation
- 📋 Afficher la liste complète des personnes
- 🔍 Rechercher des personnes par nom ou ID
- ✏️ Modifier les informations d'une personne existante
- 🗑️ Supprimer des personnes de la base de données

✅ **Interface utilisateur avancée**
- 🎨 Design moderne et réactif (responsive)
- 📝 Formulaire dynamique pour ajouter/modifier
- 📊 Affichage en grille des personnes avec 10+ contacts
- 🔔 Système d'alerte visuelle (succès/erreur)
- 🔎 Recherche en temps réel
- 🔄 Mode édition intuitif avec formulaire pré-rempli

✅ **API REST complète**
- 📡 5 Endpoints documentés et normalisés
- ⚠️ Gestion d'erreurs cohérente
- ✔️ Validation des données côté serveur
- 📦 Réponses JSON structurées

✅ **Robustesse**
- 🛡️ Validation des données (nom non vide, âge > 0)
- 📝 Gestion des exceptions détaillée
- 📊 Logging détaillé des opérations dans Tomcat
- 💬 Messages d'erreur explicites

---

## 🛠️ Technologies utilisées

### Backend
| Technologie | Version | Description |
|-------------|---------|-------------|
| **Java** | 1.8 | Langage de programmation principal |
| **Jersey** | 2.35 | Framework REST (JAX-RS) |
| **MySQL** | 5.7+ | Système de gestion de base de données |
| **MySQL JDBC** | 5.1.48 | Pilote de connexion MySQL |
| **Maven** | 3.9 | Gestionnaire de dépendances et build |
| **Tomcat** | 9.0.113 | Serveur d'application |

### Frontend
| Technologie | Description |
|-------------|-------------|
| **HTML5** | Structure et sémantique du contenu |
| **CSS3** | Styles modernes avec dégradés, animation et responsive design |
| **JavaScript (Vanilla)** | Logique côté client et requêtes AJAX/Fetch |

### Outils de développement
| Outil | Version | Utilité |
|------|---------|---------|
| **Eclipse IDE** | 2018 | Environnement de développement intégré |
| **Postman** | Latest | Test et documentation des endpoints API |
| **MySQL Workbench** | 8c | Gestion et administration de la base de données |

---

## 🏗️ Architecture du système

### Diagramme d'architecture

```
┌─────────────────────────────────────────────────────────────┐
│                    CLIENT (NAVIGATEUR)                      │
│  ┌──────────────────────────────────────────────────────┐   │
│  │         Interface web HTML/CSS/JavaScript            │   │
│  │  - Formulaire d'ajout/modification                   │   │
│  │  - Grille de personnes avec actions                  │   │
│  │  - Barre de recherche (nom ou ID)                    │   │
│  │  - Système d'alertes dynamique                       │   │
│  └──────────────────────────────────────────────────────┘   │
└──────────────────┬──────────────────────────────────────────┘
                   │ Requêtes HTTP/JSON (Fetch API)
                   │
┌──────────────────▼──────────────────────────────────────────┐
│           SERVEUR (TOMCAT 9.0.113 sur localhost:8080)       │
│  ┌──────────────────────────────────────────────────────┐   │
│  │         RestRouter (JAX-RS REST API)                 │   │
│  │  - GET /api/users/affiche (tous les utilisateurs)    │   │
│  │  - POST /api/users/add (ajouter)                     │   │
│  │  - GET /api/users/get/{id} (par ID)                  │   │
│  │  - PUT /api/users/update (modifier)                  │   │
│  │  - DELETE /api/users/remove/{id} (supprimer)         │   │
│  └──────────────────────────────────────────────────────┘   │
│  ┌──────────────────────────────────────────────────────┐   │
│  │         PersonServiceImpl (logique métier)            │   │
│  │  - Validation des données                            │   │
│  │  - Gestion des transactions BD                       │   │
│  │  - Logging détaillé des opérations                   │   │
│  └──────────────────────────────────────────────────────┘   │
└──────────────────┬──────────────────────────────────────────┘
                   │ Requêtes SQL (JDBC PreparedStatement)
                   │
┌──────────────────▼──────────────────────────────────────────┐
│            BASE DE DONNÉES (MySQL localhost:3306)           │
│  ┌──────────────────────────────────────────────────────┐   │
│  │  Table : person                                      │   │
│  │  ┌─────────────────────────────────────────────────┐ │   │
│  │  │ id (INT, PK, AI) │ Name (VARCHAR) │ Age (INT) │ │   │
│  │  └─────────────────────────────────────────────────┘ │   │
│  │                                                      │   │
│  │  Données exemple (10+ enregistrements) :            │   │
│  │  - Mariam (21 ans, ID: 9)                           │   │
│  │  - Lamisse (30 ans, ID: 18)                         │   │
│  │  - Rawen (25 ans, ID: 19)                           │   │
│  │  - Ghada (32 ans, ID: 20)                           │   │
│  │  - Mehdi (28 ans, ID: 21)                           │   │
│  │  - Et d'autres...                                   │   │
│  └──────────────────────────────────────────────────────┘   │
└─────────────────────────────────────────────────────────────┘
```

### Modèle MVC

- **Model** : `Person.java` (classe de domaine avec getters/setters)
- **View** : `index.html` (interface utilisateur responsive)
- **Controller** : `RestRouter.java` (endpoints REST avec validation)
- **Service** : `PersonServiceImpl.java` (logique métier et BD)
- **Data Access** : `ConnexionDB.java` (connexion singleton à MySQL)

---


## Création la base de données

Ouvrez **MySQL Workbench** ou l'invite de commande MySQL :

```sql
-- Créer la base de données
CREATE DATABASE IF NOT EXISTS projetdb;

-- Utiliser la base de données
USE projetdb;

-- Créer la table person
CREATE TABLE IF NOT EXISTS person (
    id INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL,
    Age INT NOT NULL
);


-- Vérifier
SELECT * FROM person;
```


---

## 🌐 Exécution du projet
###via Eclipse IDE 

 to run this server : 
maven force update 
rus as :
maven clean 
maven build -> clean install

**Vous devriez voir dans la console :**
```
Dec 24, 2025 11:07:32 PM org.apache.catalina.startup.Catalina start
INFO: Server startup in X milliseconds
```

#### Accéder à l'application
 
servers : tomcat 
add & remove : remove all & add all 
run as server tomcat localhost 
browser http://http://localhost:8080/tp333/

arreter  tomcat on eclipse ide 2018 

**La page d'accueil devrait afficher :**

![Person Management System]

### Via ligne de commande (Mode standalone)

#### Démarrer Tomcat

```bash
# Ouvrir l'invite de commande en tant qu'administrateur
cd "C:\Program Files\apache-tomcat-9.0.113\apache-tomcat-9.0.113\bin"

# Démarrer le serveur
startup.bat

# Vous devriez voir : "Server startup in X milliseconds"
```

#### Accéder à l'application

```
http://localhost:8080/tp333/
essayer  les CRUD  dans le UI```

#### Arrêter Tomcat

```bash
shutdown.bat
```

---

## 🎨 Guide d'utilisation de l'interface

### 1️⃣ Page d'accueil

![Page d'accueil]

**Éléments visibles :**
- En-tête : "👥 Person Management System"
- Sous-titre : "Manage your contacts efficiently with our modern interface"
- Barre de recherche avec boutons "🔍 Search" et "↻ Show All"
- Formulaire d'ajout à gauche
- Grille de personnes à droite

### 2️⃣ Ajouter une personne

```
┌─── ➕ Add New Person ───┐
│ Name *        [hello____]  │
│ Âge *        [-34_____]    │
│              [ADD PERSON]  │
└─────────────────────────────┘


```

**Étapes :**
1. Remplissez le champ **Name** (ex: "Ahmed")
2. Entrez l'**Age** (ex: 25)
3. Cliquez **ADD PERSON**
4. Confirmation verte : ✅ "Person added successfully!"
5. La personne apparaît dans la grille

**Validations :**
- ❌ Name vide → "Name cannot be empty"
- ❌ Age ≤ 0 → "Age must be greater than 0"

**Résultat attendu :**
```json
{
  "state": "ok",
  "message": "Person added successfully"
}
```

### 3️⃣ Afficher la liste

**La liste affiche :**
- Prénom 
- ID avec badge violet 
- Âge 
- Boutons ✏️ Edit et 🗑️ Delete

**Exemple de grille avec 10 personnes :**
```
┌─────────────────────────────────────┐
│ 👤 Mariam              │ 👤 Lamisse│
│ ID: #9                 │ ID: #18    │
│ Age: 21 years old      │ Age: 30 ...│
│ [✏️ Edit] [🗑️ Delete] │ [✏️] [🗑️] │
└─────────────────────────────────────┘
```

### 4️⃣ Rechercher une personne

**Méthode 1 : Par nom**
1. Entrez "Mariam" dans la barre de recherche
2. Cliquez **🔍 Search**
3. Résultat : ✅ "Found 1 person(s)"
4. La grille affiche uniquement "Mariam"

**Méthode 2 : Par ID**
1. Entrez "21" dans la barre de recherche
2. Cliquez **🔍 Search**
3. Résultat : ✅ "Found 1 person(s)"
4. La grille affiche la personne avec ID #21

**Cas d'erreur :**
- ❌ "No person found with that name or ID"

**Réinitialiser :**
- Cliquez **↻ Show All** pour afficher toutes les personnes

### 5️⃣ Modifier une personne

```
Avant :                          Après :
┌───➕ Add New Person  ───┐     ┌─── ✏️ Edit Person ───┐
│ Name *  [_______]       │     │ Name * [Mariam___]    │
│ Age  *  [_______]       │  →  │ Age  * [21_____]      │
│    [ADD PERSON]         │     │ [UPDATE] [CANCEL]     │
└─────────────────────────┘     └───────────────────-───┘
```

**Étapes :**
1. Cliquez **✏️ Edit** sur une personne (ex: Mariam)
2. Le formulaire se remplit automatiquement
3. Modifiez les champs (ex: Age 21 → 22)
4. Cliquez **UPDATE PERSON**
5. Confirmation : ✅ "Person updated successfully!"
6. La grille se met à jour

**Exemple d'update :**
- ID: 9
- Ancien nom: "Mariam"
- Nouveau nom: "Mariam"
- Ancien âge: 21
- Nouvel âge: 20

### 6️⃣ Supprimer une personne

**Étapes :**
1. Cliquez **🗑️ Delete** sur une personne
2. Boîte de confirmation : "Are you sure you want to delete this person?"
3. Cliquez **OK**
4. Confirmation : ✅ "Person deleted successfully!"
5. La personne disparaît de la grille

---

## 📡 Documentation API avec exemples

### Base URL
```
http://localhost:8080/tp333/api/users
```

### 1️⃣ AJOUTER UNE PERSONNE (POST)

**Endpoint :** `POST /add`

**Headers :**
```
Content-Type: application/json
```

**Requête :**
```json
{
  "name": "DaDa",
  "age": 32
}
```

**Réponse (succès) :**
```json
{
  "state": "ok",
  "message": "Person added successfully"
}
```

**Postman Screenshot :**
```
[POST] http://localhost:8080/tp333/api/users/add

Body (raw, JSON):
{
  "name": "DaDa",
  "age": 32
}

Response: 200 OK
{
  "state": "ok",
  "message": "Person added successfully"
}
```


**Logs Tomcat :**
```
Received person: name=DaDa, age=32
Adding person: DaDa, 32
Ajout avec succès - Rows affected: 1
```

---

### 2️⃣ AFFICHER TOUTES LES PERSONNES (GET)

**Endpoint :** `GET /affiche`

**Réponse (succès) :**
```json
[
  {
    "name": "Mariam",
    "age": 21,
    "id": 9
  },
  {
    "name": "Lamisse",
    "age": 30,
    "id": 18
  },
  {
    "name": "Rawen",
    "age": 25,
    "id": 19
  },
  {
    "name": "Ghada",
    "age": 32,
    "id": 20
  },
  {
    "name": "Mehdi",
    "age": 28,
    "id": 21
  },
  {
    "name": "Issam",
    "age": 35,
    "id": 22
  },
  {
    "name": "Ali",
    "age": 18,
    "id": 23
  },
  {
    "name": "Mohamed",
    "age": 66,
    "id": 24
  },
  {
    "name": "Dalila",
    "age": 18,
    "id": 25
  },
  {
    "name": "hello",
    "age": 34,
    "id": 26
  }
]
```

**Postman Screenshot :**
```
[GET] http://localhost:8080/tp333/api/users/affiche

Response: 200 OK
Status: 501 B
Time: 18 ms

[
  {
    "name": "Mariam",
    "age": 21,
    "id": 9
  },
  ...
]
```

**cURL :**
```bash
curl http://localhost:8080/tp333/api/users/affiche
```

---

### 3️⃣ OBTENIR UNE PERSONNE PAR ID (GET)

**Endpoint :** `GET /get/{id}`

**Exemple 1 : ID existant (21)**

**Requête :**
```
GET /get/21
```

**Réponse (succès) :**
```json
{
  "state": "ok",
  "data": {
    "name": "Mehdi",
    "age": 28,
    "id": 21
  }
}
```

**Postman Screenshot :**
```
[GET] http://localhost:8080/tp333/api/users/get/21

Response: 200 OK
{
  "state": "ok",
  "data": {
    "name": "Mehdi",
    "age": 28,
    "id": 21
  }
}
```

**Exemple 2 : ID inexistant (1)**

**Requête :**
```
GET /get/1
```

**Réponse (erreur) :**
```json
{
  "state": "ko",
  "message": "Person not found"
}
```

**Postman Screenshot :**
```
[GET] http://localhost:8080/tp333/api/users/get/1

Response: 200 OK
{
  "state": "ko",
  "message": "Person not found"
}
```

**cURL :**
```bash
curl http://localhost:8080/tp333/api/users/get/21
```

---

### 4️⃣ MODIFIER UNE PERSONNE (PUT)

**Endpoint :** `PUT /update`

**Requête :**
```json
{
  "id": 26,
  "name": "DaDa",
  "age": 18
}
```

**Réponse (succès) :**
```json
{
  "state": "ok",
  "message": "User updated"
}
```

**Postman Screenshot :**
```
[PUT] http://localhost:8080/tp333/api/users/update/

Body (raw, JSON):
{
  "id": 26,
  "name": "DaDa",
  "age": 18
}

Response: 200 OK
{
  "state": "ok",
  "message": "User updated"
}
```

**Cas d'erreur : Utilisateur non trouvé**

**Requête :**
```json
{
  "id": 2,
  "name": "Dalila",
  "age": 18
}
```

**Réponse (erreur) :**
```json
{
  "state": "ko",
  "message": "User not found"
}
```

**cURL :**
```bash
curl -X PUT http://localhost:8080/tp333/api/users/update \
  -H "Content-Type: application/json" \
  -d '{"id":26,"name":"DaDa","age":18}'
```

**Logs Tomcat :**
```
Updating person: id=26, name=DaDa, age=18
Update result - Rows affected: 1
```

---

### 5️⃣ SUPPRIMER UNE PERSONNE (DELETE)

**Endpoint :** `DELETE /remove/{id}`

**Exemple 1 : ID existant (26)**

**Requête :**
```
DELETE /remove/26
```

**Réponse (succès) :**
```json
{
  "state": "ok"
}
```

**Postman Screenshot :**
```
[DELETE] http://localhost:8080/tp333/api/users/remove/26

Response: 200 OK
{
  "state": "ok"
}
```

**Exemple 2 : ID inexistant (3)**

**Requête :**
```
DELETE /remove/3
```

**Réponse (erreur) :**
```json
{
  "state": "ko: id doesn't exist"
}
```

**Postman Screenshot :**
```
[DELETE] http://localhost:8080/tp333/api/users/remove/3

Response: 200 OK
{
  "state": "ko: id doesn't exist"
}
```

**cURL :**
```bash
curl -X DELETE http://localhost:8080/tp333/api/users/remove/26
```

---

## 🧪 Tester l'API complète avec Postman

### Procédure complète

**1. Ajouter une personne**
```
POST http://localhost:8080/tp333/api/users/add
{
  "name": "DaDa",
  "age": 32
}
↓
Response: 200 OK
{
  "state": "ok",
  "message": "Person added successfully"
}
```

**2. Lister tous les utilisateurs**
```
GET http://localhost:8080/tp333/api/users/affiche
↓
Response: 200 OK
[
  {
    "name": "DaDa",
    "age": 32,
    "id": 27  (← nouvel ID auto-généré)
  },
  ... (autres utilisateurs)
]
```

**3. Récupérer par ID**
```
GET http://localhost:8080/tp333/api/users/get/27
↓
Response: 200 OK
{
  "state": "ok",
  "data": {
    "name": "DaDa",
    "age": 32,
    "id": 27
  }
}
```

**4. Modifier la personne**
```
PUT http://localhost:8080/tp333/api/users/update
{
  "id": 27,
  "name": "DaDa Updated",
  "age": 33
}
↓
Response: 200 OK
{
  "state": "ok",
  "message": "User updated"
}
```

**5. Supprimer la personne**
```
DELETE http://localhost:8080/tp333/api/users/remove/27
↓
Response: 200 OK
{
  "state": "ok"
}
```

**6. Vérifier la suppression**
```
GET http://localhost:8080/tp333/api/users/get/27
↓
Response: 200 OK
{
  "state": "ko",
  "message": "Person not found"
}
```

---

## 📊 Logs Tomcat et debugging

### Accéder aux logs

**Windows :**
```
C:\Program Files\apache-tomcat-9.0.113\apache-tomcat-9.0.113\logs\catalina.out
```

**Ou dans Eclipse :**
```
Servers → Tomcat v9.0 Server at localhost → Console (F1)
```

### Exemples de logs

**Démarrage réussi :**
```
24-Dec-2025 22:59:38.123 INFO [main] org.apache.catalina.startup.Catalina.start
Server startup in [2012] milliseconds
```

**Ajout d'une personne :**
```
Received person: name=hello, age=34
Adding person: hello, 34
Ajout avec succès - Rows affected: 1
```

**Modification :**
```
Updating person: id=2, name=Dalila, age=18
Update result - Rows affected: 0
```

**Recherche :**
```
Getting person with id: 21
```

### Erreurs courantes

**Erreur de connexion BD :**
```
java.sql.SQLException: Communications link failure
```
→ Vérifier que MySQL est démarré et accessible

**Table not found :**
```
Table 'projetdb.person' doesn't exist
```
→ Créer la table avec les scripts SQL

---

## 📁 Structure du projet

```
tp333/
│
├── src/
│   └── com/info/
│       │
│       ├── db/
│       │   └── ConnexionDB.java (30 lignes)
│       │       └── Classe singleton - Gère la connexion à MySQL
│       │           • URL : jdbc:mysql://localhost/projetdb
│       │           • Utilisateur : root
│       │           • Mot de passe : root
│       │           • Crée la connexion une seule fois
│       │           • Réutilise la même connexion
│       │           • Charge le driver : com.mysql.jdbc.Driver
│       │
│       ├── model/
│       │   └── Person.java (40 lignes)
│       │       └── Classe de domaine (entité)
│       │           • Propriétés : int id, String name, int age
│       │           • Constructeur par défaut (pour JSON)
│       │           • Constructeur avec (name, age)
│       │           • Constructeur avec (id, name, age)
│       │           • Getters et Setters pour chaque propriété
│       │
│       ├── service/
│       │   ├── PersonService.java (interface)
│       │   │   └── Contrats de service :
│       │   │       • boolean addPerson(Person p)
│       │   │       • boolean deletePerson(int id)
│       │   │       • Person getPersonByName(String name)
│       │   │       • Person getPerson(int id)
│       │   │       • Person[] getAllPersons()
│       │   │       • boolean update(Person person)
│       │   │
│       │   └── PersonServiceImpl.java (120 lignes)
│       │       └── Implémentation de PersonService
│       │           • addPerson() : INSERT INTO person
│       │           • deletePerson() : DELETE FROM person WHERE id
│       │           • getPerson() : SELECT * FROM person WHERE id
│       │           • getPersonByName() : SELECT * FROM person WHERE Name
│       │           • getAllPersons() : SELECT * FROM person (retourne array)
│       │           • update() : UPDATE person SET Name, Age WHERE id
│       │           • Gestion des PreparedStatement et ResultSet
│       │           • Try-catch et logging des erreurs
│       │
│       └── router/
│           └── RestRouter.java (150 lignes)
│               └── API REST avec Jersey (JAX-RS)
│                   • Path : /users
│                   • Endpoints :
│                     - GET  /affiche           → Tous les utilisateurs
│                     - POST /add               → Ajouter utilisateur
│                     - GET  /get/{id}          → Par ID
│                     - PUT  /update            → Modifier
│                     - DELETE /remove/{id}     → Supprimer
│                   • Annotations : @Path, @GET, @POST, @PUT, @DELETE
│                   • @Produces(MediaType.APPLICATION_JSON)
│                   • @Consumes(MediaType.APPLICATION_JSON)
│                   • Validation des données
│                   • Gestion des exceptions
│                   • Réponses structurées en JSON
│
├── WebContent/
│   ├── index.html (500 lignes)
│   │   └── Interface utilisateur principale
│   │       • Structure HTML5 sémantique
│   │       • Formulaire d'ajout/modification (id, name, age)
│   │       • Barre de recherche (par nom ou ID)
│   │       • Grille dynamique des personnes (grid responsive)
│   │       • Boutons Edit (vert), Delete (rouge)
│   │       • Système d'alertes (succès/erreur)
│   │       • CSS moderne avec dégradés (667eea → 764ba2)
│   │       • Media queries pour responsivité
│   │       • JavaScript Vanilla (Fetch API)
│   │       • Fonctions :
│   │         - loadAllPersons() : récupère tous
│   │         - addPerson() : ajoute via POST
│   │         - updatePerson() : modifie via PUT
│   │         - deletePerson() : supprime via DELETE
│   │         - searchPerson() : filtre par nom/ID
│   │         - editPerson() : remplit le formulaire
│   │         - cancelEdit() : annule l'édition
│   │         - displayPersons() : affiche la grille
│   │         - showAlert() : affiche les notifications
│   │
│   └── WEB-INF/
│       ├── web.xml
│       │   └── Configuration du serveur web
│       │       • Déclaration du servlet Jersey
│       │       • Mapping d'URL : /api/*
│       │       • Packages scannés : com.info.router
│       │       • Welcome files : index.html
│       │
│       └── META-INF/
│           └── Métadonnées de l'application
│
├── pom.xml (50 lignes)
│   └── Configuration Maven
│       • GroupId : tp333
│       • ArtifactId : tp333
│       • Version : 0.0.1-SNAPSHOT
│       • Packaging : war
│       • Dépendances :
│         - jersey-hk2 (2.35)           : Injection de dépendances
│         - jersey-server (2.35)        : Serveur REST
│         - jersey-container-servlet (2.35) : Conteneur
│         - jersey-media-json-jackson (2.35) : JSON processing
│         - mysql-connector-java (5.1.48)    : Driver JDBC
│       • Plugins :
│         - maven-compiler-plugin (1.8)     : Java version
│         - maven-war-plugin                : Génère WAR
│
├── target/
│   ├── classes/
│   │   └── Fichiers .class compilés
│   │       • com/info/db/ConnexionDB.class
│   │       • com/info/model/Person.class
│   │       • com/info/service/PersonService.class
│   │       • com/info/service/PersonServiceImpl.class
│   │       • com/info/router/RestRouter.class
│   │
│   ├── generated-sources/
│   │   └── Code généré par Maven
│   │
│   └── tp333-0.0.1-SNAPSHOT.war (6.652 KB)
│       └── Archive WAR déployable
│           • Contient tous les .class
│           • Contient index.html et CSS/JS
│           • Contient web.xml
│           • Contient les dépendances (lib/)
│
├── build/ (généré par Eclipse)
│   └── classes/
│       └── Compilation Eclipse
│
├── .classpath
│   └── Configuration des chemins de classe Eclipse
│
├── .project
│   └── Configuration du projet Eclipse
│
├── .settings/
│   ├── org.eclipse.jdt.core.prefs
│   ├── org.eclipse.m2e.core.prefs
│   └── org.eclipse.wst.common.component
│       └── Configuration des facettes Web
│
└── README.md
    └── Documentation complète du projet


## 🔄 Flux de données (Data Flow)
Client (Navigateur)
        ↓ (Fetch API)
        ↓
    [index.html]
        ↓
    http://localhost:8080/tp333/api/users/add
        ↓
    [RestRouter.java]  (Reçoit la requête POST)
        ↓
    [PersonServiceImpl]  (Logique métier)
        ↓
    [ConnexionDB]  (Crée/récupère connexion)
        ↓
    [MySQL Database] (Exécute INSERT)
        ↓
    ResultSet/Response
        ↓
    [RestRouter]  (Crée réponse JSON)
        ↓
    Client (reçoit réponse)
        ↓
    [JavaScript alert] (Affiche succès/erreur)


