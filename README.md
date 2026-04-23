# ⭐ StarsGallery

Application Android de galerie de célébrités avec système de notation.

## 📱 Aperçu

StarsGallery affiche une liste de célébrités avec leur photo et leur note.  
L'utilisateur peut rechercher une star et partager l'application.

## ✨ Fonctionnalités

- Liste des célébrités avec photo et note (RatingBar)
- Barre de recherche en temps réel
- Écran Splash animé au démarrage
- Bouton de partage de l'application
- Architecture en couches : Beans / DAO / Service / Adapter / UI

## 🗂️ Structure du projet:
com.example.starsgallery/
├── beans/
│   └── Star.java           # Modèle de données
├── dao/
│   └── IDao.java           # Interface générique CRUD
├── service/
│   └── StarService.java    # Singleton — données des célébrités
├── adapter/
│   └── StarAdapter.java    # RecyclerView + filtre de recherche
└── ui/
├── SplashActivity.java # Écran de démarrage
└── ListActivity.java   # Activité principale

## 🎬 Célébrités incluses

| Nom | Note |
|-----|------|
| Kate Bosworth | ⭐⭐⭐ |
| George Clooney | ⭐⭐⭐ |
| Michelle Rodriguez | ⭐⭐⭐⭐⭐ |
| Tom Cruise | ⭐⭐ |
| Scarlett Johansson | ⭐⭐⭐⭐ |
| Emma Watson | ⭐⭐⭐⭐ |

## 🛠️ Technologies utilisées

- **Java** — langage principal
- **RecyclerView** — liste des stars
- **CardView** — design des items
- **CircleImageView** — photos rondes
- **Glide** — chargement des images
- **Material Design** — composants UI

## l'app enregistre :
