# Guide Git & GitHub — Workflow d'équipe

Ce document explique comment on utilise Git et GitHub au quotidien pour collaborer efficacement à 4 sur ce projet : **Danis** et **Evann** (back-end), **Lionel** et **Helianthe** (front-end).

## Organisation des branches

- `main` — branche par défaut, toujours **stable et fonctionnelle**. On n'y pousse jamais directement.
- `develop` — branche d'intégration où on fusionne les fonctionnalités terminées avant de passer sur `main`.
- Branches personnelles (`danis`, `evann`, `lionel`, `helianthe`) — chacun travaille sur sa propre branche au quotidien.

### Schéma du flux

```
main        ← releases stables uniquement
  ↑
develop     ← intégration continue
  ↑
danis / evann / lionel / helianthe  ← travail individuel quotidien
```

## Workflow quotidien

### 1. Se mettre à jour avant de commencer

```bash
git checkout develop
git pull origin develop
git checkout ma-branche
git merge develop
```

Ça évite de partir de code obsolète et limite les conflits plus tard.

### 2. Travailler sur sa branche

```bash
git checkout ma-branche
# ... on code ...
git add .
git commit -m "Message clair et précis"
```

**Bonnes pratiques de commit :**
- Un commit = une modification logique (pas un gros commit fourre-tout en fin de journée)
- Message au présent : `"Ajoute la validation du formulaire"` plutôt que `"ajouté"` ou `"fix"`
- Commiter régulièrement, pas juste une fois par jour

### 3. Pousser son travail

```bash
git push origin ma-branche
```

### 4. Créer une Pull Request (PR) (Pas obligatoire ou demandez à Danis)

Une fois une fonctionnalité terminée sur sa branche :
1. Aller sur GitHub → onglet **Pull requests** → **New pull request**
2. Base : `develop` ← Compare : `ma-branche`
3. Décrire ce qui a été fait (quoi, pourquoi, comment tester)
4. Demander une **review** à au moins un autre membre de l'équipe (idéalement quelqu'un du même pôle, back ou front)
5. Corriger les retours si besoin, puis merger

**Règle :** on ne merge jamais sa propre PR sans review, même pour un petit changement.

### 5. Après le merge

```bash
git checkout develop
git pull origin develop
```

Puis répéter le cycle.

## Gérer les conflits

Quand `git merge` ou `git pull` signale un conflit :

1. Git indique les fichiers en conflit avec des marqueurs `<<<<<<<`, `=======`, `>>>>>>>`
2. Ouvrir le fichier, choisir/fusionner le bon code, supprimer les marqueurs
3. `git add fichier-corrigé`
4. `git commit` pour finaliser le merge

En cas de doute sur un conflit dans le code d'un coéquipier, mieux vaut lui demander avant de trancher seul.

## Bonnes pratiques générales

| Règle | Pourquoi |
|---|---|
| Jamais de push direct sur `main` | Évite de casser la version stable |
| Toujours passer par une PR pour `develop` | Permet la review et détecte les bugs tôt |
| Pull avant de commencer à coder | Réduit les conflits |
| Petits commits fréquents | Plus facile à relire et à annuler si besoin |
| `.gitignore` bien configuré | Évite de commiter `node_modules`, fichiers `.env`, etc. |
| Communiquer sur Slack/Discord quand on touche un fichier partagé | Évite le travail en double |

## Commandes utiles à connaître

```bash
git status              # voir l'état actuel
git log --oneline       # historique condensé
git diff                # voir les changements non commités
git branch -a           # lister toutes les branches
git stash                # mettre de côté des changements temporairement
git checkout -- fichier  # annuler les changements locaux sur un fichier
```

## Répartition suggérée

- **Back-end** (Danis, Evann) : coordonner sur les endpoints API et le schéma de données avant de coder en parallèle, pour éviter les conflits de structure.
- **Front-end** (Lionel, Helianthe) : se répartir les composants/pages en amont pour ne pas travailler sur les mêmes fichiers en même temps.
- **Interface back/front** : dès qu'un endpoint change, prévenir l'équipe front (et inversement si un besoin front impacte l'API).

---

*Des questions sur le workflow ? Ouvrez une discussion sur le dépôt ou demandez en équipe avant de merger si un doute persiste.*
