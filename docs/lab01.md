# Réponse aux questions du lab1

1. Combien de modules Gradle contient le projet ? Lesquels ? Où sont-ils déclarés ?
   iosApp en fait-il partie ? Pourquoi ?
> Dans settings.gradle.kts, on voit que le projet contient 3 modules Gradle : ":androidApp", ":desktopApp" et ":shared". 
> Ils sont déclarés tout en bas du fichier settings.gradle.kts.
> iosApp n'en fait pas partie car il est géré en dehors de Gradle, par XCode. 
2. Quelles versions de Kotlin, Compose Multiplatform, AGP et Gradle sont utilisées ?
> Dans gradle/libs.versions.toml, on peut voir que Kotlin est en version 2.4.20, Compose Multiplatform en 1.12.1 et AGP en 9.1.1.
> Pour Gradle, on voit l'info dans gradle/wrapper/gradle-wrapper.properties : 9.5.1 (on a l'info dans l'URL).
3. Quels plugins applique shared/build.gradle.kts ? Et androidApp/build.gradle.kts ? Pourquoi androidApp n'applique-t-il pas
   org.jetbrains.kotlin.android ?
> Dans shared/build.gradle.kts, le fichier applique les plugins multiplateformes : org.jetbrains.kotlin.multiplatform, com.android.library, org.jetbrains.compose pour éviter de les reloader pour chaque plateforme (comme précisé dans le fichier).
> Dans androidApp/build.gradle.kts, on applique les plugins com.android.application et le compilateur Compose.
> androidApp n'applique pas org.jetbrains.kotlin.android explicitement car il utilise le plugin d'application Android et le compilateur Kotlin/Compose qui intègrent déjà le support de Kotlin pour Android.
4. Où sont configurés le minSdk de la bibliothèque partagée et celui de l'application ?
   Sous quelle forme (valeur en dur ou catalog) ?
> 
5. Listez les dossiers de shared/src/ . Pourquoi n'y a-t-il pas de iosArm64Main alors que la cible iosArm64() est déclarée ?
6. Où est déclarée expect fun getPlatform() ? Combien d'actual existe-t-il, et dans quels fichiers ?
7. Quel est l'applicationId Android ? Quelle est la mainClass desktop, et pourquoi se termine-t-elle par Kt ?
8. Où la fonction App () est-elle définie ? Depuis combien d'endroits est-elle appelée, et lesquels ?
9. Que contient le •gitignore généré ? Pourquoi local.properties doit-il être ignoré ?
10. Dans shared/src/commonMain/.../App.kt, ajoutez temporairement val f= java.io.File("x") dans App () . Que dit l'IDE ? Pourquoi ? (Supprimez la ligne ensuite.)