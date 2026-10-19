# Réponse aux questions du lab1

1. Combien de modules Gradle contient le projet ? Lesquels ? Où sont-ils déclarés ?
   iosApp en fait-il partie ? Pourquoi ?
2. Quelles versions de Kotlin, Compose Multiplatform, AGP et Gradle sont utilisées ?
3. Quels plugins applique shared/build.gradle.kts ?Et androidApp/build.gradle.kts ? Pourquoi androidApp n'applique-t-il pas
   org.jetbrains.kotlin.android ?
4. Où sont configurés le minSdk de la bibliothèque partagée et celui de l'application ?
   Sous quelle forme (valeur en dur ou catalog) ?
5. Listez les dossiers de shared/src/ . Pourquoi n'y a-t-il pas de iosArm64Main alors que la cible iosArm64() est déclarée ?
6. Où est déclarée expect fun getPlatform() ? Combien d'actual existe-t-il, et dans quels fichiers ?
7. Quel est l'applicationId Android ? Quelle est la mainClass desktop, et pourquoi se termine-t-elle par Kt ?
8. Où la fonction App () est-elle définie ? Depuis combien d'endroits est-elle appelée, et lesquels ?
9. Que contient le •gitignore généré ? Pourquoi local.properties doit-il être ignoré ?
10. Dans shared/src/commonMain/.../App.kt, ajoutez temporairement val f= java.io.File("x") dans App () . Que dit l'IDE ? Pourquoi ? (Supprimez la ligne ensuite.)