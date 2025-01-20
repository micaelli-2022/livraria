package com.example.imdlivraria

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class banco (contexto: Context) : SQLiteOpenHelper(contexto, NOME, null, VERSAO) {


    companion object{
        private const val NOME = "dblivros"
        private const val VERSAO = 2
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            """
        CREATE TABLE IF NOT EXISTS livros (
            titulo TEXT NOT NULL,
            autor TEXT NOT NULL,
            editora TEXT,
            isbn INTEGER PRIMARY KEY,
            descricao TEXT,
            url TEXT
        )
        """
        )

    }



    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }





    fun save(titulo: String, autor: String, editora: String, isbn:Long, descricao: String, url: String): Long{
        val banco = this.writableDatabase


        //ISBN único
       val cursor = banco.query(
            "livros",
            arrayOf("isbn"),
            "isbn = ?",
            arrayOf(isbn.toString()),
            null, null, null
        )

        if (cursor.count > 0) {
            cursor.close()
            banco.close()
            return -1 // Retorna -1 para indicar falha na inserção
        }



        val container = ContentValues()
        container.put("titulo", titulo)
        container.put("autor", autor)
        container.put("editora", editora)
        container.put("isbn", isbn)
        container.put("descricao", descricao)
        container.put("url", url)

        var result = banco.insert("livros", null, container)
        banco.close()
        return result


    }





    fun update(titulo: String, autor: String, editora: String, isbn:Long, descricao: String, url: String): Int{
        val banco = this.writableDatabase
        val container = ContentValues()
        container.put("titulo", titulo)
        container.put("autor", autor)
        container.put("editora", editora)
        container.put("descricao", descricao)
        container.put("url", url)
        var result = banco.update("livros", container, "isbn=" + isbn, null)
        banco.close()
        return result
    }





    fun delete(isbn: String) : Int{
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
                var titulo = cursor.getString(0)
                var autor= cursor.getString(1)
                var editora = cursor.getString(2)
                var descricao = cursor.getString(4)
                var url = cursor.getString(5)

                // ISBN não é nulo ou inválido
                val isbn = if (!cursor.isNull(cursor.getColumnIndex("isbn"))) {
                    cursor.getInt(cursor.getColumnIndex("isbn"))
                } else {
                    0
                }

                // Adicionando livro à lista, mesmo que o ISBN seja 0 ou inválido
                array.add(Livros(titulo, autor, editora, isbn, descricao, url))

            } while (cursor.moveToNext())


        }
        cursor.close()
        banco.close()
        return array;
    }

    //função para limpar dados do banco
    fun clearBanco() {
        val banco = writableDatabase
        banco.execSQL("DELETE FROM livros")
        banco.close()
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
                livro.isbnlivro = cursor.getInt(3)
                livro.descricaolivro = cursor.getString(4)
                livro.urllivro = cursor.getString(5)

            }while(cursor.moveToNext())
        }
        return livro;
    }



}