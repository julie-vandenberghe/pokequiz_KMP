# PokéQuiz

Projet de cours (M2) en Kotlin Multiplatform. PokéQuiz est un quiz sur les Pokémon : le joueur doit retrouver le nom d'un Pokémon. Une partie compte 5 questions. Le score dépend de la réponse, de l'utilisation d'un indice et du temps de réponse.

Cibles : Android, iOS et Desktop (JVM). 
Package : fr.m2.pokequiz.

## Avancement

| Lab | Contenu | Réponses aux questions | Tag associé |
| --- | --- | --- |-------------|
| Lab 1 | Environnement, projet et premier lancement | [docs/lab01.md](./docs/lab01.md) | lab01       |
| Lab 2 | Domaine du quiz (moteur, score, vérification des réponses) et tests | [REPONSES-lab02.md](./REPONSES-lab02.md) | lab02       |

## Structure du projet

* [/androidApp](./androidApp) contient l'application Android.
* [/desktopApp](./desktopApp) contient l'application Desktop (JVM).
* [/iosApp](./iosApp/iosApp) contient l'application iOS. 
* [/shared](./shared/src) contient le code partagé entre les applications :
  - [commonMain](./shared/src/commonMain/kotlin) : code commun à toutes les cibles (domaine du quiz et UI).
  - [commonTest](./shared/src/commonTest/kotlin) : tests communs, exécutés sur chaque cible.
  - [androidMain](./shared/src/androidMain/kotlin), [jvmMain](./shared/src/jvmMain/kotlin) et [iosMain](./shared/src/iosMain/kotlin) : code propre à chaque plateforme (les actual de expect).

## Lancer les applications

Utilise les run configurations de l'IDE. Tu peux aussi utiliser ces commandes :

- Android : `./gradlew :androidApp:assembleDebug`
- Desktop :
  - Hot reload : `./gradlew :desktopApp:hotRun --auto`
  - Lancement standard : `./gradlew :desktopApp:run`
- iOS : ouvrir le dossier [/iosApp](./iosApp) dans Xcode et lancer depuis Xcode.

## Lancer les tests

- Android : `./gradlew :shared:testAndroidHostTest`
- Desktop : `./gradlew :shared:jvmTest`
- iOS : `./gradlew :shared:iosSimulatorArm64Test`