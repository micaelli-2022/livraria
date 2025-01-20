package com.example.imdlivraria

data class Livros
    (var titulolivro:String = "", var autorlivro:String = "", var editoralivro:String = "", var isbnlivro :Int = 0,  var descricaolivro: String = "", var urllivro: String = ""){

    override fun toString(): String {
        return "titulo: $titulolivro \nautor: $autorlivro \neditora: $editoralivro \nisnb: $isbnlivro \ndescrição: $descricaolivro \nurl: $urllivro\n"


    }
}