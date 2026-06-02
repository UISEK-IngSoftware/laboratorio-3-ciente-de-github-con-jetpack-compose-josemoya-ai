package ec.edu.uisek.githubclient.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ec.edu.uisek.githubclient.ui.components.RepoItem

@Composable
fun RepoList() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        RepoItem(
            name = "Jose",
            description = "hola",
            avatarImg = "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/007.png",
            language = "Kodlin"
        )
        RepoItem(
            name = "Martin",
            description = "buenas",
            avatarImg = "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/007.png",
            language = "Python"
        )
    }
}