package com.example.imdlivraria

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.ArrayAdapter

class banco (contexto: Context) : SQLiteOpenHelper(contexto, NOME, null, VERSAO) {


    companion object{
        private const val NOME = "dblivros"
        private const val VERSAO = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            """
        CREATE TABLE livros (
            titulo TEXT NOT NULL,
            autor TEXT NOT NULL,
            editora TEXT,
            ISBN INTEGER PRIMARY KEY,
            descricao TEXT,
            URL TEXT
        )
        """
        )
    }



    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }





    fun save(titulo: String, autor: String, editora: String?, isbn:Long, descriçao: String, Url: String?): Long{
        val banco = this.writableDatabase
        val container = ContentValues()
        container.put("titulo", titulo)
        container.put("autor", autor)
        container.put("editora", editora)
        container.put("ISBN", isbn)
        container.put("descriçao", descriçao)
        container.put("Url", Url)
        var result = banco.insert("livros", null, container)
        banco.close()
        return result
    }





    fun update(titulo: String, autor: String, editora: String?, isbn:Int, descriçao: String, Url: String?): Int{
        val banco = this.writableDatabase
        val container = ContentValues()
        container.put("titulo", titulo)
        container.put("autor", autor)
        container.put("editora", editora)
        container.put("descriçao", descriçao)
        container.put("Url", Url)
        var result = banco.update("livros", container, "isbn=" + isbn, null)
        banco.close()
        return result
    }





    fun delete(isbn: Long) : Int{
        val banco = this.writableDatabase
        var resultado = banco.delete("livros", "isbn = " + isbn, null)
        banco.close()
        return resultado
    }





    fun listAll() : ArrayList<Livros>{
        val banco = this.readableDatabase
        var cursor = banco.rawQuery("SELECT * FROM livros", null)
        var array = ArrayList<Livros>()
        if(cursor.count > 0){
            cursor.moveToFirst()
            do{
                var titulolivro = cursor.getString(0)
                var autorlivro = cursor.getString(1)
                var editoralivro = cursor.getString(2)
                var isbn = cursor.getInt(3)
                var descricaolivro = cursor.getString(4)
                var url = cursor.getString(5)

                array.add(Livros(titulolivro, autorlivro, editoralivro, isbn, descricaolivro, url ))
            }while(cursor.moveToNext())
        }
        cursor.close()
        banco.close()
        return array;
    }





    fun findByCodigo(isbn: Long) : Livros{
        val banco = this.readableDatabase
        var cursor = banco.rawQuery("SELECT * FROM livros WHERE isbn=" + isbn, null)
        var livro = Livros();
        if(cursor.count > 0){
            cursor.moveToFirst()
            do{

                livro.titulolivro = cursor.getString(0)
                livro.autorlivro = cursor.getString(1)
                livro.editoralivro = cursor.getString(2)
                livro.isbn = cursor.getInt(3)
                livro.descricaolivro = cursor.getString(4)
                livro.url = cursor.getString(5)

            }while(cursor.moveToNext())
        }
        return livro;
    }



}