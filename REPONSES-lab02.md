# Réponses aux questions du lab 2

## 1. Pourquoi ne peut-on pas utiliser java.text.Normalizer directement dans commonMain, alors qye l'application tourne sur Android et sur desktop, deux plateformes JVM ?

> Le code de commonMain est compilé pour toutes les cibles mais iOS tourne en natif et n'a pas de JDK. 
> java.text.Normalizer n'existe donc pas pour lui. 
> L'IDE affiche "unresolved reference" et le build iOS échoue. 
> La règle ne dépend pas des plateformes qu'on utilise vraiment : le code commun ne peut utiliser que la bibliothèque standard Kotlin et les bibliothèques multiplateformes. 
> On déclare donc un expect en commun. 
> Le Normalizer est utilisé dans les actual Android et JVM. iOS a le sien avec NSString.

## 2. Pourquoi PokemonRepository et ScoreRepository sont-ils des interfaces plutôt que des expect class ? Donnez au moins trois arguments.

> - Les tests sont plus simples. Dans commonTest, on écrit un faux repository en mémoire, sans réseau ni base de données.
> - Une interface peut avoir une seule implémentation commune. Un expect class oblige à écrire un actual par cible.
> - On peut changer d'implémentation (API réelle, faux, cache) sans toucher au domaine.
> - expect/actual sert à accéder aux API de la plateforme. Il ne sert pas à définir un contrat métier.

## 3. Que se passe-t-il si une cible n'a pas d'actual ? Expérimentez : commentez le corps du fichier TextNormalization. jvm.kt, lancez •/gradlew : shared:jvmTest, notez le message, puis restaurez. Que se passerait-il si on ajoutait une cible wasmJs() demain ?

> j'ai commenté l'actual fun dans TextNormalization.jvm.kt puis j'ai lancé ./gradlew :shared:jvmTest.
> j'ai ensuite eu le message suivant : ".../commonMain/kotlin/fr/m2/pokequiz/platform/TextNormalization.kt:4:1 The 'expect' declaration 'removeDiacritics' has no 'actual' declaration in module '<commonMain> for JVM'."
> La tâche compileKotlinJvm échoue avec l'erreur NO_ACTUAL_FOR_EXPECT. 
> Ce n'est pas le test qui échoue mais la compilation. Les tests ne se lancent donc pas. 
> Si on ajoute wasmJs() plus tard, la même erreur apparaîtra pour cette cible. Il faudrait écrire un actual pour wasmJs. 
> Le compilateur nous empêche ainsi d'oublier une plateforme.

## 4. Pourquoi QuizEngine.submit reçoit-il elapsed en paramètre au lieu de mesurer le temps lui-même ?

> le temps dépend d'une horloge et donc de l'interface (chrono affiché, pause, rotation de l'écran). 
> En le passant en param, QuizEngine reste de la logique pure. 
> les tests sont déterministes : on passe 10.seconds ou 9_999.milliseconds sans attendre. 
> Il n'y a aucun risque de test instable. L'écran mesure le temps et l'envoie au moteur.

## 5. Nidoran♀ et Nidoran♂ se normalisent tous deux en nidoran. Bug ou fonctionnalité ? Proposez une évolution si vous jugez qu'il faut corriger.

> Les deux : c'est pratique car personne ne sait taper "♀" ou "♂" au clavier mais ce sont deux Pokémon différents...
> Donc, si la réponse attendue est ♀, la réponse ♂ est aussi acceptée. C'est une erreur de règle. 
> Pour corriger, on pourrait remplacer ♀ par "f" et ♂ par "m" avant de supprimer les caractères spéciaux. 
> Les deux noms deviendront alors différents.

## 6. Le test AnswerCheckerTest est écrit dans commonTest. Qu'est-ce qu'il vérifie de plus que s'il était dans jvmTest ?

> Un test dans commonTest s'exécute sur chaque cible : JVM, Android host et iOS. 
> Il vérifie donc que le comportement est le même partout. 
> C'est important car removeDiacritics a trois implémentations : Normalizer sur JVM et Android, NSString sur iOS. 
> Un test placé seulement en jvmTest ne verrait pas une différence côté iOS. 
> On teste donc le contrat commun et non une implémentation.

## 7. Pourquoi submit après la fin lève-t-il IllegalStateException (check) et une liste vide IllegalArgumentException (require) ?

> require vérifie les arguments.
> Une liste vide passée au constructeur est une mauvaise valeur, d'où IllegalArgumentException. 
> check vérifie l'état de l'objet. 
> Appeler submit quand la partie est finie est un appel valide mais fait au mauvais moment, d'où IllegalStateException. 
> Dans le code, c'est checkNotNull qui est utilisé : c'est une variante de check. 
> Deux exceptions différentes indiquent ainsi ce qui est faux : la donnée ou le moment.