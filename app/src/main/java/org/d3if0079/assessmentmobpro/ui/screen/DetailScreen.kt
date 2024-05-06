package org.d3if0079.assessmentmobpro.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.d3if0079.assessmentmobpro.R
import org.d3if0079.assessmentmobpro.ui.theme.AssessmentMobproTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen() {
    var nama by remember { mutableStateOf("") }
    var nik by remember { mutableStateOf("") }
    var umur by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }
    var jenisKunjungan by remember { mutableStateOf("") }
    var tanggalKunjungan by remember { mutableStateOf("") }
    var keluhan by remember { mutableStateOf("") }

    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.tambah_data_pasien))
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Green,
                    titleContentColor = Color.Black,
                )
            )
        }
    ) { padding ->
        FormDataPasien(
            name = nama,
            onNameChange =  { nama = it },
            nik = nik,
            onNikChange = { nik = it },
            old = umur,
            onOldChange = { umur = it },
            address = alamat,
            onAddressChange = { alamat = it },
            gender = jenisKelamin,
            onGenderChange = { jenisKelamin = it },
            typesOfVisits = jenisKunjungan,
            onTypeOfVisitsChange = { jenisKunjungan = it },
            dateOfVisit = tanggalKunjungan,
            onDateOfVisitChange = { tanggalKunjungan = it },
            complaints = keluhan,
            onComplaintsChange = { keluhan = it },
            modifier = Modifier.padding(padding)
        )
    }
}

@Composable
fun FormDataPasien(
    name: String, onNameChange: (String) -> Unit,
    nik: String, onNikChange: (String) -> Unit,
    old: String, onOldChange: (String) -> Unit,
    address: String, onAddressChange: (String) -> Unit,
    gender: String, onGenderChange: (String) -> Unit,
    typesOfVisits: String, onTypeOfVisitsChange: (String) -> Unit,
    dateOfVisit: String, onDateOfVisitChange: (String) -> Unit,
    complaints: String, onComplaintsChange: (String) -> Unit,

    modifier: Modifier
) {
    val radioOptionsOne = listOf(
        stringResource(id = R.string.pria),
        stringResource(id = R.string.wanita)
    )
    val radioOptionsTwo = listOf(
        stringResource(id = R.string.umum),
        stringResource(id = R.string.bpjs)
    )

    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { onNameChange(it) },
            label = { Text(text = stringResource(R.string.nama)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = nik,
            onValueChange = { onNikChange(it) },
            label = { Text(text = stringResource(R.string.nik)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = old,
            onValueChange = { onOldChange(it) },
            label = { Text(text = stringResource(R.string.umur)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = address,
            onValueChange = { onAddressChange(it) },
            label = { Text(text = stringResource(R.string.alamat)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Row (
            modifier = Modifier
                .padding(top = 6.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
        ) {
            radioOptionsOne.forEach { text ->
                GenderOptions(
                    label = text,
                    isSelected = gender == text,
                    modifier = Modifier
                        .selectable(
                            selected = gender == text,
                            onClick = { onGenderChange(text) },
                            role = Role.RadioButton
                        )
                        .weight(1f)
                        .padding(16.dp)
                )
            }
        }

        Row (
            modifier = Modifier
                .padding(top = 6.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
        ) {
            radioOptionsTwo.forEach { text ->
                GenderOptions(
                    label = text,
                    isSelected = typesOfVisits == text,
                    modifier = Modifier
                        .selectable(
                            selected = typesOfVisits == text,
                            onClick = { onTypeOfVisitsChange(text) },
                            role = Role.RadioButton
                        )
                        .weight(1f)
                        .padding(16.dp)
                )
            }
        }
        OutlinedTextField(
            value = dateOfVisit,
            onValueChange = { onDateOfVisitChange(it) },
            label = { Text(text = stringResource(R.string.tanggal_kunjungan)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = complaints,
            onValueChange = { onComplaintsChange(it) },
            label = { Text(text = stringResource(R.string.keluhan)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun GenderOptions(label: String, isSelected: Boolean, modifier: Modifier) {
    Row (
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = isSelected, onClick = null)
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun DetailScreenPreview() {
    AssessmentMobproTheme {
        DetailScreen()
    }
}