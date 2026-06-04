package ec.edu.uisek.githubclient.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ec.edu.uisek.githubclient.models.Repository
import ec.edu.uisek.githubclient.viewmodels.RepoFormViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeleteRepoConfirm(
    repository: Repository,
    onCancel: () -> Unit,
    onDeleteSuccess: () -> Unit,
    viewModel: RepoFormViewModel = viewModel()
) {

    val isSuccess by viewModel.isSuccess.collectAsState()

    if (isSuccess) {
        onDeleteSuccess()
        viewModel.resetSuccess()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Confirmar eliminación")
                }
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "¿Quieres eliminar este repositorio?",
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = repository.name,
                style = MaterialTheme.typography.titleLarge
            )

            Button(
                onClick = {
                    viewModel.deleteRepo(
                        owner = repository.owner.name,
                        repo = repository.name
                    )
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Eliminar")
            }

            OutlinedButton(
                onClick = onCancel,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Cancelar")
            }
        }
    }
}