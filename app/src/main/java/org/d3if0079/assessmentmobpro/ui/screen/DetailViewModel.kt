package org.d3if0079.assessmentmobpro.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if0079.assessmentmobpro.database.DataPasienDao
import org.d3if0079.assessmentmobpro.model.DataPasien
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DetailViewModel(private val dao: DataPasienDao) : ViewModel() {

    private val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)

    fun insert(nama: String, nik: String, umur: String, alamat: String, jenisKelamin: String, jenisKunjungan: String, tanggalKunjungan: String, keluhan: String) {
        val dataPasien = DataPasien(
            nama = nama,
            nik = nik,
            umur = umur,
            alamat = alamat,
            jenisKelamin = jenisKelamin,
            jenisKunjungan = jenisKunjungan,
            tanggalKunjungan = formatter.format(Date()),
            keluhan = keluhan
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(dataPasien)
        }
    }
}